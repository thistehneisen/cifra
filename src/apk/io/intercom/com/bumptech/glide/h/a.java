package io.intercom.com.bumptech.glide.h;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final AtomicReference<byte[]> f9380a = new AtomicReference<>();

    /* renamed from: io.intercom.com.bumptech.glide.h.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferUtil */
    private static class C0104a extends InputStream {

        /* renamed from: a reason: collision with root package name */
        private final ByteBuffer f9381a;

        /* renamed from: b reason: collision with root package name */
        private int f9382b = -1;

        C0104a(ByteBuffer byteBuffer) {
            this.f9381a = byteBuffer;
        }

        public int available() throws IOException {
            return this.f9381a.remaining();
        }

        public synchronized void mark(int i2) {
            this.f9382b = this.f9381a.position();
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            if (!this.f9381a.hasRemaining()) {
                return -1;
            }
            return this.f9381a.get();
        }

        public synchronized void reset() throws IOException {
            if (this.f9382b != -1) {
                this.f9381a.position(this.f9382b);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        public long skip(long j2) throws IOException {
            if (!this.f9381a.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j2, (long) available());
            ByteBuffer byteBuffer = this.f9381a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + min));
            return min;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!this.f9381a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i3, available());
            this.f9381a.get(bArr, i2, min);
            return min;
        }
    }

    /* compiled from: ByteBufferUtil */
    static final class b {

        /* renamed from: a reason: collision with root package name */
        final int f9383a;

        /* renamed from: b reason: collision with root package name */
        final int f9384b;

        /* renamed from: c reason: collision with root package name */
        final byte[] f9385c;

        b(byte[] bArr, int i2, int i3) {
            this.f9385c = bArr;
            this.f9383a = i2;
            this.f9384b = i3;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(2:12|13)|14|15|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004e A[SYNTHETIC, Splitter:B:29:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    public static ByteBuffer a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            } else if (length != 0) {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        MappedByteBuffer load = channel.map(MapMode.READ_ONLY, 0, length).load();
                        if (channel != null) {
                            channel.close();
                        }
                        randomAccessFile.close();
                        return load;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        fileChannel = channel;
                        th = th2;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileChannel != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    throw th;
                }
            } else {
                throw new IOException("File unsuitable for memory mapping");
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            if (fileChannel != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static InputStream b(ByteBuffer byteBuffer) {
        return new C0104a(byteBuffer);
    }

    private static b c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|(2:6|7)|8|9|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[SYNTHETIC, Splitter:B:15:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[SYNTHETIC, Splitter:B:19:0x0032] */
    public static void a(ByteBuffer byteBuffer, File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                if (fileChannel != null) {
                    fileChannel.close();
                }
                randomAccessFile.close();
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileChannel != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        b c2 = c(byteBuffer);
        if (c2 != null && c2.f9383a == 0 && c2.f9384b == c2.f9385c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }
}
