package org.joda.time.b;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.a;
import org.joda.time.b.a.C0124a;
import org.joda.time.d;
import org.joda.time.d.q;
import org.joda.time.g;

/* compiled from: JulianChronology */
public final class w extends f {
    private static final w ha = b(g.f10938a);
    private static final ConcurrentHashMap<g, w[]> ia = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -8731039522547897247L;

    w(a aVar, Object obj, int i2) {
        super(aVar, obj, i2);
    }

    public static w b(g gVar) {
        return a(gVar, 4);
    }

    static int h(int i2) {
        if (i2 > 0) {
            return i2;
        }
        if (i2 != 0) {
            return i2 + 1;
        }
        throw new IllegalFieldValueException(d.T(), Integer.valueOf(i2), null, null);
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
        return 31083663600000L;
    }

    /* access modifiers changed from: 0000 */
    public long Q() {
        return 2629800000L;
    }

    /* access modifiers changed from: 0000 */
    public long R() {
        return 31557600000L;
    }

    /* access modifiers changed from: 0000 */
    public long S() {
        return 15778800000L;
    }

    /* access modifiers changed from: 0000 */
    public int W() {
        return 292272992;
    }

    /* access modifiers changed from: 0000 */
    public int X() {
        return -292269054;
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
        return (i2 & 3) == 0;
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

    public static w a(g gVar, int i2) {
        w wVar;
        if (gVar == null) {
            gVar = g.b();
        }
        w[] wVarArr = (w[]) ia.get(gVar);
        if (wVarArr == null) {
            wVarArr = new w[7];
            w[] wVarArr2 = (w[]) ia.putIfAbsent(gVar, wVarArr);
            if (wVarArr2 != null) {
                wVarArr = wVarArr2;
            }
        }
        int i3 = i2 - 1;
        try {
            w wVar2 = wVarArr[i3];
            if (wVar2 == null) {
                synchronized (wVarArr) {
                    wVar2 = wVarArr[i3];
                    if (wVar2 == null) {
                        if (gVar == g.f10938a) {
                            wVar = new w(null, null, i2);
                        } else {
                            wVar = new w(y.a((a) a(g.f10938a, i2), gVar), null, i2);
                        }
                        wVarArr[i3] = wVar;
                        wVar2 = wVar;
                    }
                }
            }
            return wVar2;
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

    /* access modifiers changed from: 0000 */
    public long a(int i2, int i3, int i4) throws IllegalArgumentException {
        return super.a(h(i2), i3, i4);
    }

    /* access modifiers changed from: 0000 */
    public long a(int i2) {
        int i3;
        int i4 = i2 - 1968;
        if (i4 <= 0) {
            i3 = (i4 + 3) >> 2;
        } else {
            int i5 = i4 >> 2;
            i3 = !g(i2) ? i5 + 1 : i5;
        }
        return (((((long) i4) * 365) + ((long) i3)) * 86400000) - 62035200000L;
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        if (L() == null) {
            super.a(aVar);
            aVar.E = new q(this, aVar.E);
            aVar.B = new q(this, aVar.B);
        }
    }
}
