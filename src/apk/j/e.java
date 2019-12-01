package j;

import java.io.InputStream;

/* compiled from: Buffer */
class e extends InputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f10247a;

    e(f fVar) {
        this.f10247a = fVar;
    }

    public int available() {
        return (int) Math.min(this.f10247a.f10250c, 2147483647L);
    }

    public void close() {
    }

    public int read() {
        f fVar = this.f10247a;
        if (fVar.f10250c > 0) {
            return fVar.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10247a);
        sb.append(".inputStream()");
        return sb.toString();
    }

    public int read(byte[] bArr, int i2, int i3) {
        return this.f10247a.a(bArr, i2, i3);
    }
}
