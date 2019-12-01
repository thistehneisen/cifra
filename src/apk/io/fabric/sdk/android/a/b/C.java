package io.fabric.sdk.android.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class C implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f8789a = Logger.getLogger(C.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final RandomAccessFile f8790b;

    /* renamed from: c reason: collision with root package name */
    int f8791c;

    /* renamed from: d reason: collision with root package name */
    private int f8792d;

    /* renamed from: e reason: collision with root package name */
    private a f8793e;

    /* renamed from: f reason: collision with root package name */
    private a f8794f;

    /* renamed from: g reason: collision with root package name */
    private final byte[] f8795g = new byte[16];

    /* compiled from: QueueFile */
    static class a {

        /* renamed from: a reason: collision with root package name */
        static final a f8796a = new a(0, 0);

        /* renamed from: b reason: collision with root package name */
        final int f8797b;

        /* renamed from: c reason: collision with root package name */
        final int f8798c;

        a(int i2, int i3) {
            this.f8797b = i2;
            this.f8798c = i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(a.class.getSimpleName());
            sb.append("[position = ");
            sb.append(this.f8797b);
            sb.append(", length = ");
            sb.append(this.f8798c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: QueueFile */
    private final class b extends InputStream {

        /* renamed from: a reason: collision with root package name */
        private int f8799a;

        /* renamed from: b reason: collision with root package name */
        private int f8800b;

        /* synthetic */ b(C c2, a aVar, B b2) {
            this(aVar);
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            C.b(bArr, "buffer");
            if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = this.f8800b;
            if (i4 <= 0) {
                return -1;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            C.this.a(this.f8799a, bArr, i2, i3);
            this.f8799a = C.this.d(this.f8799a + i3);
            this.f8800b -= i3;
            return i3;
        }

        private b(a aVar) {
            this.f8799a = C.this.d(aVar.f8797b + 4);
            this.f8800b = aVar.f8798c;
        }

        public int read() throws IOException {
            if (this.f8800b == 0) {
                return -1;
            }
            C.this.f8790b.seek((long) this.f8799a);
            int read = C.this.f8790b.read();
            this.f8799a = C.this.d(this.f8799a + 1);
            this.f8800b--;
            return read;
        }
    }

    /* compiled from: QueueFile */
    public interface c {
        void read(InputStream inputStream, int i2) throws IOException;
    }

    public C(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.f8790b = b(file);
        e();
    }

    private static void b(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    private void c(int i2) throws IOException {
        this.f8790b.setLength((long) i2);
        this.f8790b.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    public int d(int i2) {
        int i3 = this.f8791c;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    private void e() throws IOException {
        this.f8790b.seek(0);
        this.f8790b.readFully(this.f8795g);
        this.f8791c = a(this.f8795g, 0);
        if (((long) this.f8791c) <= this.f8790b.length()) {
            this.f8792d = a(this.f8795g, 4);
            int a2 = a(this.f8795g, 8);
            int a3 = a(this.f8795g, 12);
            this.f8793e = b(a2);
            this.f8794f = b(a3);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File is truncated. Expected length: ");
        sb.append(this.f8791c);
        sb.append(", Actual length: ");
        sb.append(this.f8790b.length());
        throw new IOException(sb.toString());
    }

    private int f() {
        return this.f8791c - d();
    }

    public synchronized void close() throws IOException {
        this.f8790b.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f8791c);
        sb.append(", size=");
        sb.append(this.f8792d);
        sb.append(", first=");
        sb.append(this.f8793e);
        sb.append(", last=");
        sb.append(this.f8794f);
        sb.append(", element lengths=[");
        try {
            a((c) new B(this, sb));
        } catch (IOException e2) {
            f8789a.log(Level.WARNING, "read error", e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int d() {
        if (this.f8792d == 0) {
            return 16;
        }
        a aVar = this.f8794f;
        int i2 = aVar.f8797b;
        int i3 = this.f8793e.f8797b;
        if (i2 >= i3) {
            return (i2 - i3) + 4 + aVar.f8798c + 16;
        }
        return (((i2 + 4) + aVar.f8798c) + this.f8791c) - i3;
    }

    public synchronized void c() throws IOException {
        if (b()) {
            throw new NoSuchElementException();
        } else if (this.f8792d == 1) {
            a();
        } else {
            int d2 = d(this.f8793e.f8797b + 4 + this.f8793e.f8798c);
            a(d2, this.f8795g, 0, 4);
            int a2 = a(this.f8795g, 0);
            a(this.f8791c, this.f8792d - 1, d2, this.f8794f.f8797b);
            this.f8792d--;
            this.f8793e = new a(d2, a2);
        }
    }

    private static void a(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int b2 : iArr) {
            b(bArr, i2, b2);
            i2 += 4;
        }
    }

    private a b(int i2) throws IOException {
        if (i2 == 0) {
            return a.f8796a;
        }
        this.f8790b.seek((long) i2);
        return new a(i2, this.f8790b.readInt());
    }

    private static int a(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    private void a(int i2, int i3, int i4, int i5) throws IOException {
        a(this.f8795g, i2, i3, i4, i5);
        this.f8790b.seek(0);
        this.f8790b.write(this.f8795g);
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private void b(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int d2 = d(i2);
        int i5 = d2 + i4;
        int i6 = this.f8791c;
        if (i5 <= i6) {
            this.f8790b.seek((long) d2);
            this.f8790b.write(bArr, i3, i4);
            return;
        }
        int i7 = i6 - d2;
        this.f8790b.seek((long) d2);
        this.f8790b.write(bArr, i3, i7);
        this.f8790b.seek(16);
        this.f8790b.write(bArr, i3 + i7, i4 - i7);
    }

    /* JADX INFO: finally extract failed */
    private static void a(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".tmp");
        File file2 = new File(sb.toString());
        RandomAccessFile b2 = b(file2);
        try {
            b2.setLength(4096);
            b2.seek(0);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            b2.write(bArr);
            b2.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public synchronized boolean b() {
        return this.f8792d == 0;
    }

    /* access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* access modifiers changed from: private */
    public void a(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int d2 = d(i2);
        int i5 = d2 + i4;
        int i6 = this.f8791c;
        if (i5 <= i6) {
            this.f8790b.seek((long) d2);
            this.f8790b.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - d2;
        this.f8790b.seek((long) d2);
        this.f8790b.readFully(bArr, i3, i7);
        this.f8790b.seek(16);
        this.f8790b.readFully(bArr, i3 + i7, i4 - i7);
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        b(bArr, "buffer");
        if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        a(i3);
        boolean b2 = b();
        if (b2) {
            i4 = 16;
        } else {
            i4 = d(this.f8794f.f8797b + 4 + this.f8794f.f8798c);
        }
        a aVar = new a(i4, i3);
        b(this.f8795g, 0, i3);
        b(aVar.f8797b, this.f8795g, 0, 4);
        b(aVar.f8797b + 4, bArr, i2, i3);
        a(this.f8791c, this.f8792d + 1, b2 ? aVar.f8797b : this.f8793e.f8797b, aVar.f8797b);
        this.f8794f = aVar;
        this.f8792d++;
        if (b2) {
            this.f8793e = this.f8794f;
        }
    }

    private void a(int i2) throws IOException {
        int i3 = i2 + 4;
        int f2 = f();
        if (f2 < i3) {
            int i4 = this.f8791c;
            do {
                f2 += i4;
                i4 <<= 1;
            } while (f2 < i3);
            c(i4);
            a aVar = this.f8794f;
            int d2 = d(aVar.f8797b + 4 + aVar.f8798c);
            if (d2 < this.f8793e.f8797b) {
                FileChannel channel = this.f8790b.getChannel();
                channel.position((long) this.f8791c);
                long j2 = (long) (d2 - 4);
                if (channel.transferTo(16, j2, channel) != j2) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i5 = this.f8794f.f8797b;
            int i6 = this.f8793e.f8797b;
            if (i5 < i6) {
                int i7 = (this.f8791c + i5) - 16;
                a(i4, this.f8792d, i6, i7);
                this.f8794f = new a(i7, this.f8794f.f8798c);
            } else {
                a(i4, this.f8792d, i6, i5);
            }
            this.f8791c = i4;
        }
    }

    public synchronized void a(c cVar) throws IOException {
        int i2 = this.f8793e.f8797b;
        for (int i3 = 0; i3 < this.f8792d; i3++) {
            a b2 = b(i2);
            cVar.read(new b(this, b2, null), b2.f8798c);
            i2 = d(b2.f8797b + 4 + b2.f8798c);
        }
    }

    public synchronized void a() throws IOException {
        a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
        this.f8792d = 0;
        this.f8793e = a.f8796a;
        this.f8794f = a.f8796a;
        if (this.f8791c > 4096) {
            c(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        this.f8791c = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }

    public boolean a(int i2, int i3) {
        return (d() + 4) + i2 <= i3;
    }
}
