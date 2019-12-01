package io.intercom.okhttp3.internal.cache2;

import e.a.b.B;
import e.a.b.D;
import e.a.b.g;
import e.a.b.j;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import io.intercom.okhttp3.internal.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final j PREFIX_CLEAN = j.c("OkHttp cache v1\n");
    static final j PREFIX_DIRTY = j.c("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final g buffer = new g();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final j metadata;
    int sourceCount;
    B upstream;
    final g upstreamBuffer = new g();
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements B {
        private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
        private long sourcePos;
        private final D timeout = new D();

        RelaySource() {
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                Closeable closeable = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay.this.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile = Relay.this.file;
                        Relay.this.file = null;
                        closeable = randomAccessFile;
                    }
                }
                if (closeable != null) {
                    Util.closeQuietly(closeable);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            r5 = r7 - r1.this$0.buffer.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            if (r1.sourcePos >= r5) goto L_0x011b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r1.sourcePos);
            r1.this$0.buffer.a(r22, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0136, code lost:
            return r2;
         */
        public long read(g gVar, long j2) throws IOException {
            long j3;
            char c2;
            long j4 = j2;
            if (this.fileOperator != null) {
                synchronized (Relay.this) {
                    while (true) {
                        long j5 = this.sourcePos;
                        j3 = Relay.this.upstreamPos;
                        if (j5 != j3) {
                            break;
                        } else if (Relay.this.complete) {
                            return -1;
                        } else {
                            if (Relay.this.upstreamReader != null) {
                                this.timeout.waitUntilNotified(Relay.this);
                            } else {
                                Relay.this.upstreamReader = Thread.currentThread();
                                c2 = 1;
                            }
                        }
                    }
                    if (c2 == 2) {
                        long min = Math.min(j4, j3 - this.sourcePos);
                        this.fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, gVar, min);
                        this.sourcePos += min;
                        return min;
                    }
                    try {
                        long read = Relay.this.upstream.read(Relay.this.upstreamBuffer, Relay.this.bufferMaxSize);
                        if (read == -1) {
                            Relay.this.commit(j3);
                            synchronized (Relay.this) {
                                Relay.this.upstreamReader = null;
                                Relay.this.notifyAll();
                            }
                            return -1;
                        }
                        long min2 = Math.min(read, j4);
                        Relay.this.upstreamBuffer.a(gVar, 0, min2);
                        this.sourcePos += min2;
                        this.fileOperator.write(j3 + Relay.FILE_HEADER_SIZE, Relay.this.upstreamBuffer.clone(), read);
                        synchronized (Relay.this) {
                            Relay.this.buffer.write(Relay.this.upstreamBuffer, read);
                            if (Relay.this.buffer.size() > Relay.this.bufferMaxSize) {
                                Relay.this.buffer.skip(Relay.this.buffer.size() - Relay.this.bufferMaxSize);
                            }
                            Relay.this.upstreamPos += read;
                        }
                        synchronized (Relay.this) {
                            Relay.this.upstreamReader = null;
                            Relay.this.notifyAll();
                        }
                        return min2;
                    } catch (Throwable th) {
                        synchronized (Relay.this) {
                            Relay.this.upstreamReader = null;
                            Relay.this.notifyAll();
                            throw th;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(Action.CLOSED);
            }
        }

        public D timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, B b2, long j2, j jVar, long j3) {
        this.file = randomAccessFile;
        this.upstream = b2;
        this.complete = b2 == null;
        this.upstreamPos = j2;
        this.metadata = jVar;
        this.bufferMaxSize = j3;
    }

    public static Relay edit(File file2, B b2, j jVar, long j2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, b2, 0, jVar, j2);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        g gVar = new g();
        fileOperator.read(0, gVar, FILE_HEADER_SIZE);
        if (gVar.b((long) PREFIX_CLEAN.size()).equals(PREFIX_CLEAN)) {
            long readLong = gVar.readLong();
            long readLong2 = gVar.readLong();
            g gVar2 = new g();
            fileOperator.read(readLong + FILE_HEADER_SIZE, gVar2, readLong2);
            Relay relay = new Relay(randomAccessFile, null, readLong, gVar2.d(), 0);
            return relay;
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(j jVar, long j2, long j3) throws IOException {
        g gVar = new g();
        gVar.a(jVar);
        gVar.k(j2);
        gVar.k(j3);
        if (gVar.size() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0, gVar, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j2) throws IOException {
        g gVar = new g();
        gVar.a(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j2, gVar, (long) this.metadata.size());
    }

    /* access modifiers changed from: 0000 */
    public void commit(long j2) throws IOException {
        writeMetadata(j2);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j2, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: 0000 */
    public boolean isClosed() {
        return this.file == null;
    }

    public j metadata() {
        return this.metadata;
    }

    public B newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
