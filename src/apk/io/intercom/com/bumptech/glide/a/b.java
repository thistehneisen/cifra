package io.intercom.com.bumptech.glide.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache */
public final class b implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final File f9133a;

    /* renamed from: b reason: collision with root package name */
    private final File f9134b;

    /* renamed from: c reason: collision with root package name */
    private final File f9135c;

    /* renamed from: d reason: collision with root package name */
    private final File f9136d;

    /* renamed from: e reason: collision with root package name */
    private final int f9137e;

    /* renamed from: f reason: collision with root package name */
    private long f9138f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final int f9139g;

    /* renamed from: h reason: collision with root package name */
    private long f9140h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public Writer f9141i;

    /* renamed from: j reason: collision with root package name */
    private final LinkedHashMap<String, c> f9142j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public int f9143k;

    /* renamed from: l reason: collision with root package name */
    private long f9144l = 0;
    final ThreadPoolExecutor m;
    private final Callable<Void> n;

    /* compiled from: DiskLruCache */
    private static final class a implements ThreadFactory {
        private a() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    /* renamed from: io.intercom.com.bumptech.glide.a.b$b reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public final class C0099b {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public final c f9145a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final boolean[] f9146b;

        /* renamed from: c reason: collision with root package name */
        private boolean f9147c;

        /* synthetic */ C0099b(b bVar, c cVar, a aVar) {
            this(cVar);
        }

        public void c() throws IOException {
            b.this.a(this, true);
            this.f9147c = true;
        }

        private C0099b(c cVar) {
            this.f9145a = cVar;
            this.f9146b = cVar.f9153e ? null : new boolean[b.this.f9139g];
        }

        public File a(int i2) throws IOException {
            File b2;
            synchronized (b.this) {
                if (this.f9145a.f9154f == this) {
                    if (!this.f9145a.f9153e) {
                        this.f9146b[i2] = true;
                    }
                    b2 = this.f9145a.b(i2);
                    if (!b.this.f9133a.exists()) {
                        b.this.f9133a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return b2;
        }

        public void b() {
            if (!this.f9147c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void a() throws IOException {
            b.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    private final class c {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public final String f9149a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final long[] f9150b;

        /* renamed from: c reason: collision with root package name */
        File[] f9151c;

        /* renamed from: d reason: collision with root package name */
        File[] f9152d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public boolean f9153e;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public C0099b f9154f;
        /* access modifiers changed from: private */

        /* renamed from: g reason: collision with root package name */
        public long f9155g;

        /* synthetic */ c(b bVar, String str, a aVar) {
            this(str);
        }

        private c(String str) {
            this.f9149a = str;
            this.f9150b = new long[b.this.f9139g];
            this.f9151c = new File[b.this.f9139g];
            this.f9152d = new File[b.this.f9139g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < b.this.f9139g; i2++) {
                sb.append(i2);
                this.f9151c[i2] = new File(b.this.f9133a, sb.toString());
                sb.append(".tmp");
                this.f9152d[i2] = new File(b.this.f9133a, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length == b.this.f9139g) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f9150b[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        public String a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f9150b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f9152d[i2];
        }

        private IOException a(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        public File a(int i2) {
            return this.f9151c[i2];
        }
    }

    /* compiled from: DiskLruCache */
    public final class d {

        /* renamed from: a reason: collision with root package name */
        private final String f9157a;

        /* renamed from: b reason: collision with root package name */
        private final long f9158b;

        /* renamed from: c reason: collision with root package name */
        private final long[] f9159c;

        /* renamed from: d reason: collision with root package name */
        private final File[] f9160d;

        /* synthetic */ d(b bVar, String str, long j2, File[] fileArr, long[] jArr, a aVar) {
            this(str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return this.f9160d[i2];
        }

        private d(String str, long j2, File[] fileArr, long[] jArr) {
            this.f9157a = str;
            this.f9158b = j2;
            this.f9160d = fileArr;
            this.f9159c = jArr;
        }
    }

    private b(File file, int i2, int i3, long j2) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(null));
        this.m = threadPoolExecutor;
        this.n = new a(this);
        this.f9133a = file2;
        this.f9137e = i2;
        this.f9134b = new File(file2, "journal");
        this.f9135c = new File(file2, "journal.tmp");
        this.f9136d = new File(file2, "journal.bkp");
        this.f9139g = i3;
        this.f9138f = j2;
    }

    /* access modifiers changed from: private */
    public void g() throws IOException {
        while (this.f9140h > this.f9138f) {
            d((String) ((Entry) this.f9142j.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized void close() throws IOException {
        if (this.f9141i != null) {
            Iterator it = new ArrayList(this.f9142j.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.f9154f != null) {
                    cVar.f9154f.a();
                }
            }
            g();
            this.f9141i.close();
            this.f9141i = null;
        }
    }

    public synchronized boolean isClosed() {
        return this.f9141i == null;
    }

    private void d() throws IOException {
        a(this.f9135c);
        Iterator it = this.f9142j.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i2 = 0;
            if (cVar.f9154f == null) {
                while (i2 < this.f9139g) {
                    this.f9140h += cVar.f9150b[i2];
                    i2++;
                }
            } else {
                cVar.f9154f = null;
                while (i2 < this.f9139g) {
                    a(cVar.a(i2));
                    a(cVar.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f9143k = r0 - r9.f9142j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.a() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f9141i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f9134b, true), io.intercom.com.bumptech.glide.a.e.f9168a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    private void e() throws IOException {
        String str = ", ";
        d dVar = new d(new FileInputStream(this.f9134b), e.f9168a);
        try {
            String b2 = dVar.b();
            String b3 = dVar.b();
            String b4 = dVar.b();
            String b5 = dVar.b();
            String b6 = dVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b3) || !Integer.toString(this.f9137e).equals(b4) || !Integer.toString(this.f9139g).equals(b5) || !"".equals(b6)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(b2);
                sb.append(str);
                sb.append(b3);
                sb.append(str);
                sb.append(b5);
                sb.append(str);
                sb.append(b6);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                e(dVar.b());
                i2++;
            }
        } finally {
            e.a((Closeable) dVar);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void f() throws IOException {
        if (this.f9141i != null) {
            this.f9141i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9135c), e.f9168a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f9137e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f9139g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.f9142j.values()) {
                if (cVar.f9154f != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(cVar.f9149a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(cVar.f9149a);
                    sb2.append(cVar.a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f9134b.exists()) {
                a(this.f9134b, this.f9136d, true);
            }
            a(this.f9135c, this.f9134b, false);
            this.f9136d.delete();
            this.f9141i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9134b, true), e.f9168a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public C0099b b(String str) throws IOException {
        return a(str, -1);
    }

    public synchronized d c(String str) throws IOException {
        b();
        c cVar = (c) this.f9142j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f9153e) {
            return null;
        }
        for (File exists : cVar.f9151c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f9143k++;
        this.f9141i.append("READ");
        this.f9141i.append(' ');
        this.f9141i.append(str);
        this.f9141i.append(10);
        if (c()) {
            this.m.submit(this.n);
        }
        d dVar = new d(this, str, cVar.f9155g, cVar.f9151c, cVar.f9150b, null);
        return dVar;
    }

    private void b() {
        if (this.f9141i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static b a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            b bVar = new b(file, i2, i3, j2);
            if (bVar.f9134b.exists()) {
                try {
                    bVar.e();
                    bVar.d();
                    return bVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(e2.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    bVar.a();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i2, i3, j2);
            bVar2.f();
            return bVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    public synchronized boolean d(String str) throws IOException {
        b();
        c cVar = (c) this.f9142j.get(str);
        if (cVar != null) {
            if (cVar.f9154f == null) {
                for (int i2 = 0; i2 < this.f9139g; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("failed to delete ");
                            sb.append(a2);
                            throw new IOException(sb.toString());
                        }
                    }
                    this.f9140h -= cVar.f9150b[i2];
                    cVar.f9150b[i2] = 0;
                }
                this.f9143k++;
                this.f9141i.append("REMOVE");
                this.f9141i.append(' ');
                this.f9141i.append(str);
                this.f9141i.append(10);
                this.f9142j.remove(str);
                if (c()) {
                    this.m.submit(this.n);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean c() {
        int i2 = this.f9143k;
        return i2 >= 2000 && i2 >= this.f9142j.size();
    }

    private void e(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f9142j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = (c) this.f9142j.get(str2);
            if (cVar == null) {
                cVar = new c(this, str2, null);
                this.f9142j.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f9153e = true;
                cVar.f9154f = null;
                cVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f9154f = new C0099b(this, cVar, null);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith("READ"))) {
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

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    private synchronized C0099b a(String str, long j2) throws IOException {
        b();
        c cVar = (c) this.f9142j.get(str);
        if (j2 == -1 || (cVar != null && cVar.f9155g == j2)) {
            if (cVar == null) {
                cVar = new c(this, str, null);
                this.f9142j.put(str, cVar);
            } else if (cVar.f9154f != null) {
                return null;
            }
            C0099b bVar = new C0099b(this, cVar, null);
            cVar.f9154f = bVar;
            this.f9141i.append("DIRTY");
            this.f9141i.append(' ');
            this.f9141i.append(str);
            this.f9141i.append(10);
            this.f9141i.flush();
            return bVar;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    public synchronized void a(C0099b bVar, boolean z) throws IOException {
        c a2 = bVar.f9145a;
        if (a2.f9154f == bVar) {
            if (z && !a2.f9153e) {
                int i2 = 0;
                while (i2 < this.f9139g) {
                    if (!bVar.f9146b[i2]) {
                        bVar.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Newly created entry didn't create value for index ");
                        sb.append(i2);
                        throw new IllegalStateException(sb.toString());
                    } else if (!a2.b(i2).exists()) {
                        bVar.a();
                        return;
                    } else {
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.f9139g; i3++) {
                File b2 = a2.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a3 = a2.a(i3);
                    b2.renameTo(a3);
                    long j2 = a2.f9150b[i3];
                    long length = a3.length();
                    a2.f9150b[i3] = length;
                    this.f9140h = (this.f9140h - j2) + length;
                }
            }
            this.f9143k++;
            a2.f9154f = null;
            if (a2.f9153e || z) {
                a2.f9153e = true;
                this.f9141i.append("CLEAN");
                this.f9141i.append(' ');
                this.f9141i.append(a2.f9149a);
                this.f9141i.append(a2.a());
                this.f9141i.append(10);
                if (z) {
                    long j3 = this.f9144l;
                    this.f9144l = 1 + j3;
                    a2.f9155g = j3;
                }
            } else {
                this.f9142j.remove(a2.f9149a);
                this.f9141i.append("REMOVE");
                this.f9141i.append(' ');
                this.f9141i.append(a2.f9149a);
                this.f9141i.append(10);
            }
            this.f9141i.flush();
            if (this.f9140h > this.f9138f || c()) {
                this.m.submit(this.n);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() throws IOException {
        close();
        e.a(this.f9133a);
    }
}
