package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.gb reason: case insensitive filesystem */
class C0363gb extends C0345db {
    protected final byte[] zzado;

    C0363gb(byte[] bArr) {
        if (bArr != null) {
            this.zzado = bArr;
            return;
        }
        throw new NullPointerException();
    }

    public byte a(int i2) {
        return this.zzado[i2];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Xa) || size() != ((Xa) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C0363gb)) {
            return obj.equals(this);
        }
        C0363gb gbVar = (C0363gb) obj;
        int g2 = g();
        int g3 = gbVar.g();
        if (g2 == 0 || g3 == 0 || g2 == g3) {
            return a((Xa) gbVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public byte f(int i2) {
        return this.zzado[i2];
    }

    /* access modifiers changed from: protected */
    public int h() {
        return 0;
    }

    public int size() {
        return this.zzado.length;
    }

    public final Xa a(int i2, int i3) {
        int b2 = Xa.b(0, i3, size());
        if (b2 == 0) {
            return Xa.f5082a;
        }
        return new _a(this.zzado, h(), b2);
    }

    public final boolean f() {
        int h2 = h();
        return C0326ad.a(this.zzado, h2, size() + h2);
    }

    /* access modifiers changed from: 0000 */
    public final void a(Ua ua) throws IOException {
        ua.a(this.zzado, h(), size());
    }

    /* access modifiers changed from: protected */
    public final String a(Charset charset) {
        return new String(this.zzado, h(), size(), charset);
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(Xa xa, int i2, int i3) {
        if (i3 > xa.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > xa.size()) {
            int size2 = xa.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(xa instanceof C0363gb)) {
            return xa.a(0, i3).equals(a(0, i3));
        } else {
            C0363gb gbVar = (C0363gb) xa;
            byte[] bArr = this.zzado;
            byte[] bArr2 = gbVar.zzado;
            int h2 = h() + i3;
            int h3 = h();
            int h4 = gbVar.h();
            while (h3 < h2) {
                if (bArr[h3] != bArr2[h4]) {
                    return false;
                }
                h3++;
                h4++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2, int i3, int i4) {
        return Fb.a(i2, this.zzado, h(), i4);
    }
}
