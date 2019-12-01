package e.a.b;

import java.io.OutputStream;

/* renamed from: e.a.b.e reason: case insensitive filesystem */
/* compiled from: Buffer */
class C0711e extends OutputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ g f7879a;

    C0711e(g gVar) {
        this.f7879a = gVar;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7879a);
        sb.append(".outputStream()");
        return sb.toString();
    }

    public void write(int i2) {
        this.f7879a.writeByte((int) (byte) i2);
    }

    public void write(byte[] bArr, int i2, int i3) {
        this.f7879a.write(bArr, i2, i3);
    }
}
