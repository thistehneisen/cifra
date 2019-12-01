package b.g.f;

import java.util.Comparator;

/* compiled from: FontsContractCompat */
class e implements Comparator<byte[]> {
    e() {
    }

    /* renamed from: a */
    public int compare(byte[] bArr, byte[] bArr2) {
        int i2;
        int i3;
        if (bArr.length != bArr2.length) {
            i3 = bArr.length;
            i2 = bArr2.length;
        } else {
            int i4 = 0;
            while (i4 < bArr.length) {
                if (bArr[i4] != bArr2[i4]) {
                    i3 = bArr[i4];
                    i2 = bArr2[i4];
                } else {
                    i4++;
                }
            }
            return 0;
        }
        return i3 - i2;
    }
}
