package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.BitSet;

/* compiled from: TypeAdapters */
class U extends D<BitSet> {
    U() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (java.lang.Integer.parseInt(r1) != 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        if (r8.l() != 0) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[SYNTHETIC] */
    public BitSet a(b bVar) throws IOException {
        BitSet bitSet = new BitSet();
        bVar.a();
        c G = bVar.G();
        int i2 = 0;
        while (G != c.END_ARRAY) {
            int i3 = ba.f10044a[G.ordinal()];
            boolean z = true;
            if (i3 != 1) {
                if (i3 == 2) {
                    z = bVar.j();
                } else if (i3 == 3) {
                    String F = bVar.F();
                    try {
                    } catch (NumberFormatException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error: Expecting: bitset number value (1, 0), Found: ");
                        sb.append(F);
                        throw new JsonSyntaxException(sb.toString());
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid bitset value type: ");
                    sb2.append(G);
                    throw new JsonSyntaxException(sb2.toString());
                }
                if (!z) {
                    bitSet.set(i2);
                }
                i2++;
                G = bVar.G();
            }
            z = false;
            if (!z) {
            }
            i2++;
            G = bVar.G();
        }
        bVar.d();
        return bitSet;
    }

    public void a(d dVar, BitSet bitSet) throws IOException {
        dVar.a();
        int length = bitSet.length();
        for (int i2 = 0; i2 < length; i2++) {
            dVar.h(bitSet.get(i2) ? 1 : 0);
        }
        dVar.c();
    }
}
