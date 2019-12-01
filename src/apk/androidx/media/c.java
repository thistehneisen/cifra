package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase */
class c implements a {

    /* renamed from: a reason: collision with root package name */
    int f1677a = 0;

    /* renamed from: b reason: collision with root package name */
    int f1678b = 0;

    /* renamed from: c reason: collision with root package name */
    int f1679c = 0;

    /* renamed from: d reason: collision with root package name */
    int f1680d = -1;

    c() {
    }

    public int a() {
        return this.f1678b;
    }

    public int b() {
        int i2 = this.f1679c;
        int c2 = c();
        if (c2 == 6) {
            i2 |= 4;
        } else if (c2 == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f1680d;
        if (i2 != -1) {
            return i2;
        }
        return AudioAttributesCompat.a(false, this.f1679c, this.f1677a);
    }

    public int d() {
        return this.f1677a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1678b == cVar.a() && this.f1679c == cVar.b() && this.f1677a == cVar.d() && this.f1680d == cVar.f1680d) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1678b), Integer.valueOf(this.f1679c), Integer.valueOf(this.f1677a), Integer.valueOf(this.f1680d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1680d != -1) {
            sb.append(" stream=");
            sb.append(this.f1680d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f1677a));
        sb.append(" content=");
        sb.append(this.f1678b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1679c).toUpperCase());
        return sb.toString();
    }
}
