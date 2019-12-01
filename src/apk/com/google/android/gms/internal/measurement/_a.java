package com.google.android.gms.internal.measurement;

final class _a extends C0363gb {
    private final int zzadl;
    private final int zzadm;

    _a(byte[] bArr, int i2, int i3) {
        super(bArr);
        Xa.b(i2, i2 + i3, bArr.length);
        this.zzadl = i2;
        this.zzadm = i3;
    }

    public final byte a(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            return this.zzado[this.zzadl + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public final byte f(int i2) {
        return this.zzado[this.zzadl + i2];
    }

    /* access modifiers changed from: protected */
    public final int h() {
        return this.zzadl;
    }

    public final int size() {
        return this.zzadm;
    }
}
