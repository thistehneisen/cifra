package org.joda.time.b;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.a;
import org.joda.time.b.a.C0124a;
import org.joda.time.g;

/* compiled from: GregorianChronology */
public final class t extends f {
    private static final t ha = b(g.f10938a);
    private static final ConcurrentHashMap<g, t[]> ia = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -861407383323710522L;

    private t(a aVar, Object obj, int i2) {
        super(aVar, obj, i2);
    }

    public static t Z() {
        return ha;
    }

    public static t b(g gVar) {
        return a(gVar, 4);
    }

    private Object readResolve() {
        a L = L();
        int Y = Y();
        if (Y == 0) {
            Y = 4;
        }
        if (L == null) {
            return a(g.f10938a, Y);
        }
        return a(L.k(), Y);
    }

    public a G() {
        return ha;
    }

    /* access modifiers changed from: 0000 */
    public long P() {
        return 31083597720000L;
    }

    /* access modifiers changed from: 0000 */
    public long Q() {
        return 2629746000L;
    }

    /* access modifiers changed from: 0000 */
    public long R() {
        return 31556952000L;
    }

    /* access modifiers changed from: 0000 */
    public long S() {
        return 15778476000L;
    }

    /* access modifiers changed from: 0000 */
    public int W() {
        return 292278993;
    }

    /* access modifiers changed from: 0000 */
    public int X() {
        return -292275054;
    }

    public /* bridge */ /* synthetic */ int Y() {
        return super.Y();
    }

    public /* bridge */ /* synthetic */ long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return super.a(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: 0000 */
    public boolean g(int i2) {
        return (i2 & 3) == 0 && (i2 % 100 != 0 || i2 % 400 == 0);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ g k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        return super.a(i2, i3, i4, i5, i6, i7, i8);
    }

    public static t a(g gVar, int i2) {
        t tVar;
        if (gVar == null) {
            gVar = g.b();
        }
        t[] tVarArr = (t[]) ia.get(gVar);
        if (tVarArr == null) {
            tVarArr = new t[7];
            t[] tVarArr2 = (t[]) ia.putIfAbsent(gVar, tVarArr);
            if (tVarArr2 != null) {
                tVarArr = tVarArr2;
            }
        }
        int i3 = i2 - 1;
        try {
            t tVar2 = tVarArr[i3];
            if (tVar2 == null) {
                synchronized (tVarArr) {
                    tVar2 = tVarArr[i3];
                    if (tVar2 == null) {
                        if (gVar == g.f10938a) {
                            tVar = new t(null, null, i2);
                        } else {
                            tVar = new t(y.a((a) a(g.f10938a, i2), gVar), null, i2);
                        }
                        tVarArr[i3] = tVar;
                        tVar2 = tVar;
                    }
                }
            }
            return tVar2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid min days in first week: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public a a(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        if (gVar == k()) {
            return this;
        }
        return b(gVar);
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        if (L() == null) {
            super.a(aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public long a(int i2) {
        int i3;
        int i4 = i2 / 100;
        if (i2 < 0) {
            i3 = ((((i2 + 3) >> 2) - i4) + ((i4 + 3) >> 2)) - 1;
        } else {
            i3 = ((i2 >> 2) - i4) + (i4 >> 2);
            if (g(i2)) {
                i3--;
            }
        }
        return ((((long) i2) * 365) + ((long) (i3 - 719527))) * 86400000;
    }
}
