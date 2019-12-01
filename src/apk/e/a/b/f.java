package e.a.b;

import java.io.InputStream;

/* compiled from: Buffer */
class f extends InputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ g f7880a;

    f(g gVar) {
        this.f7880a = gVar;
    }

    public int available() {
        return (int) Math.min(this.f7880a.f7883c, 2147483647L);
    }

    public void close() {
    }

    public int read() {
        g gVar = this.f7880a;
        if (gVar.f7883c > 0) {
            return gVar.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7880a);
        sb.append(".inputStream()");
        return sb.toString();
    }

    public int read(byte[] bArr, int i2, int i3) {
        return this.f7880a.a(bArr, i2, i3);
    }
}
