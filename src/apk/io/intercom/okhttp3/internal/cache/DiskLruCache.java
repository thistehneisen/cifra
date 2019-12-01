package io.intercom.okhttp3.internal.cache;

import e.a.b.A;
import e.a.b.B;
import e.a.b.h;
import e.a.b.i;
import e.a.b.t;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.io.FileSystem;
import io.intercom.okhttp3.internal.platform.Platform;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.this$0.mostRecentRebuildFailed = true;
            r5.this$0.journalWriter = e.a.b.t.a(e.a.b.t.a());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0033 */
        public void run() {
            synchronized (DiskLruCache.this) {
                if (!(!DiskLruCache.this.initialized) && !DiskLruCache.this.closed) {
                    DiskLruCache.this.trimToSize();
                    DiskLruCache.this.mostRecentTrimFailed = true;
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                } else {
                    return;
                }
            }
            return;
        }
    };
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    h journalWriter;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.currentEditor == this) {
                        DiskLruCache.this.completeEdit(this, false);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.currentEditor == this) {
                        DiskLruCache.this.completeEdit(this, true);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void detach() {
            if (this.entry.currentEditor == this) {
                int i2 = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i2 < diskLruCache.valueCount) {
                        try {
                            diskLruCache.fileSystem.delete(this.entry.dirtyFiles[i2]);
                        } catch (IOException unused) {
                        }
                        i2++;
                    } else {
                        this.entry.currentEditor = null;
                        return;
                    }
                }
            }
        }

        public A newSink(int i2) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                } else if (this.entry.currentEditor != this) {
                    A a2 = t.a();
                    return a2;
                } else {
                    if (!this.entry.readable) {
                        this.written[i2] = true;
                    }
                    try {
                        AnonymousClass1 r1 = new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i2])) {
                            /* access modifiers changed from: protected */
                            public void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.detach();
                                }
                            }
                        };
                        return r1;
                    } catch (FileNotFoundException unused) {
                        return t.a();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            return null;
         */
        public B newSource(int i2) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                } else if (this.entry.readable && this.entry.currentEditor == this) {
                    try {
                        B source = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i2]);
                        return source;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            int i2 = DiskLruCache.this.valueCount;
            this.lengths = new long[i2];
            this.cleanFiles = new File[i2];
            this.dirtyFiles = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < DiskLruCache.this.valueCount; i3++) {
                sb.append(i3);
                this.cleanFiles[i3] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i3] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.lengths[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        invalidLengths(strArr);
                        throw null;
                    }
                }
                return;
            }
            invalidLengths(strArr);
            throw null;
        }

        /* access modifiers changed from: 0000 */
        public Snapshot snapshot() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                B[] bArr = new B[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.lengths.clone();
                int i2 = 0;
                int i3 = 0;
                while (i3 < DiskLruCache.this.valueCount) {
                    try {
                        bArr[i3] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i3]);
                        i3++;
                    } catch (FileNotFoundException unused) {
                        while (i2 < DiskLruCache.this.valueCount && bArr[i2] != null) {
                            Util.closeQuietly((Closeable) bArr[i2]);
                            i2++;
                        }
                        try {
                            DiskLruCache.this.removeEntry(this);
                        } catch (IOException unused2) {
                        }
                        return null;
                    }
                }
                Snapshot snapshot = new Snapshot(this.key, this.sequenceNumber, bArr, jArr);
                return snapshot;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        public void writeLengths(h hVar) throws IOException {
            for (long g2 : this.lengths) {
                hVar.writeByte(32).g(g2);
            }
        }
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final B[] sources;

        Snapshot(String str, long j2, B[] bArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j2;
            this.sources = bArr;
            this.lengths = jArr;
        }

        public void close() {
            for (B closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int i2) {
            return this.lengths[i2];
        }

        public B getSource(int i2) {
            return this.sources[i2];
        }

        public String key() {
            return this.key;
        }
    }

    DiskLruCache(FileSystem fileSystem2, File file, int i2, int i3, long j2, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i2;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i3;
        this.maxSize = j2;
        this.executor = executor2;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true));
            DiskLruCache diskLruCache = new DiskLruCache(fileSystem2, file, i2, i3, j2, threadPoolExecutor);
            return diskLruCache;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private h newJournalWriter() throws FileNotFoundException {
        return t.a((A) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i2 = 0;
            if (entry.currentEditor == null) {
                while (i2 < this.valueCount) {
                    this.size += entry.lengths[i2];
                    i2++;
                }
            } else {
                entry.currentEditor = null;
                while (i2 < this.valueCount) {
                    this.fileSystem.delete(entry.cleanFiles[i2]);
                    this.fileSystem.delete(entry.dirtyFiles[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.o() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    private void readJournal() throws IOException {
        String str = ", ";
        i a2 = t.a(this.fileSystem.source(this.journalFile));
        try {
            String p = a2.p();
            String p2 = a2.p();
            String p3 = a2.p();
            String p4 = a2.p();
            String p5 = a2.p();
            if (!MAGIC.equals(p) || !VERSION_1.equals(p2) || !Integer.toString(this.appVersion).equals(p3) || !Integer.toString(this.valueCount).equals(p4) || !"".equals(p5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(p);
                sb.append(str);
                sb.append(p2);
                sb.append(str);
                sb.append(p4);
                sb.append(str);
                sb.append(p5);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                readJournalLine(a2.p());
                i2++;
            }
        } finally {
            Util.closeQuietly((Closeable) a2);
        }
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = (Entry) this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                entry.currentEditor = new Editor(entry);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith(READ))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                throw new IOException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(str);
        throw new IOException(sb2.toString());
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public synchronized void close() throws IOException {
        Entry[] entryArr;
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor == editor) {
            if (z && !entry.readable) {
                int i2 = 0;
                while (i2 < this.valueCount) {
                    if (!editor.written[i2]) {
                        editor.abort();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Newly created entry didn't create value for index ");
                        sb.append(i2);
                        throw new IllegalStateException(sb.toString());
                    } else if (!this.fileSystem.exists(entry.dirtyFiles[i2])) {
                        editor.abort();
                        return;
                    } else {
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.valueCount; i3++) {
                File file = entry.dirtyFiles[i3];
                if (!z) {
                    this.fileSystem.delete(file);
                } else if (this.fileSystem.exists(file)) {
                    File file2 = entry.cleanFiles[i3];
                    this.fileSystem.rename(file, file2);
                    long j2 = entry.lengths[i3];
                    long size2 = this.fileSystem.size(file2);
                    entry.lengths[i3] = size2;
                    this.size = (this.size - j2) + size2;
                }
            }
            this.redundantOpCount++;
            entry.currentEditor = null;
            if (entry.readable || z) {
                entry.readable = true;
                this.journalWriter.a(CLEAN).writeByte(32);
                this.journalWriter.a(entry.key);
                entry.writeLengths(this.journalWriter);
                this.journalWriter.writeByte(10);
                if (z) {
                    long j3 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j3;
                    entry.sequenceNumber = j3;
                }
            } else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.a(REMOVE).writeByte(32);
                this.journalWriter.a(entry.key);
                this.journalWriter.writeByte(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, ANY_SEQUENCE_NUMBER);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
        this.mostRecentTrimFailed = false;
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    public synchronized Snapshot get(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry != null) {
            if (entry.readable) {
                Snapshot snapshot = entry.snapshot();
                if (snapshot == null) {
                    return null;
                }
                this.redundantOpCount++;
                this.journalWriter.a(READ).writeByte(32).a(str).writeByte(10);
                if (journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
            }
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() throws IOException {
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e2) {
                    Platform platform = Platform.get();
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(this.directory);
                    sb.append(" is corrupt: ");
                    sb.append(e2.getMessage());
                    sb.append(", removing");
                    platform.log(5, sb.toString(), e2);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    /* access modifiers changed from: 0000 */
    public boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        return i2 >= 2000 && i2 >= this.lruEntries.size();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        h a2 = t.a(this.fileSystem.sink(this.journalFileTmp));
        try {
            a2.a(MAGIC).writeByte(10);
            a2.a(VERSION_1).writeByte(10);
            a2.g((long) this.appVersion).writeByte(10);
            a2.g((long) this.valueCount).writeByte(10);
            a2.writeByte(10);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    a2.a(DIRTY).writeByte(32);
                    a2.a(entry.key);
                    a2.writeByte(10);
                } else {
                    a2.a(CLEAN).writeByte(32);
                    a2.a(entry.key);
                    entry.writeLengths(a2);
                    a2.writeByte(10);
                }
            }
            a2.close();
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    public synchronized boolean remove(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean removeEntry = removeEntry(entry);
        if (removeEntry && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean removeEntry(Entry entry) throws IOException {
        Editor editor = entry.currentEditor;
        if (editor != null) {
            editor.detach();
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            this.fileSystem.delete(entry.cleanFiles[i2]);
            long j2 = this.size;
            long[] jArr = entry.lengths;
            this.size = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.a(REMOVE).writeByte(32).a(entry.key).writeByte(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized void setMaxSize(long j2) {
        this.maxSize = j2;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {
            final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = ((Entry) this.delegate.next()).snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            public void remove() {
                Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.remove(snapshot.key);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        this.removeSnapshot = null;
                        throw th;
                    }
                    this.removeSnapshot = null;
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }

            public Snapshot next() {
                if (hasNext()) {
                    this.removeSnapshot = this.nextSnapshot;
                    this.nextSnapshot = null;
                    return this.removeSnapshot;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry((Entry) this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    public synchronized Editor edit(String str, long j2) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j2 == ANY_SEQUENCE_NUMBER || (entry != null && entry.sequenceNumber == j2)) {
            if (entry != null) {
                if (entry.currentEditor != null) {
                    return null;
                }
            }
            if (!this.mostRecentTrimFailed) {
                if (!this.mostRecentRebuildFailed) {
                    this.journalWriter.a(DIRTY).writeByte(32).a(str).writeByte(10);
                    this.journalWriter.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(entry);
                    entry.currentEditor = editor;
                    return editor;
                }
            }
            this.executor.execute(this.cleanupRunnable);
            return null;
        }
    }
}
