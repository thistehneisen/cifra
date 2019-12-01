package org.joda.time.b;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.a;
import org.joda.time.b;
import org.joda.time.b.a.C0124a;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.f;
import org.joda.time.d.k;
import org.joda.time.d.o;
import org.joda.time.d.r;
import org.joda.time.d.t;
import org.joda.time.g;
import org.joda.time.i;

/* compiled from: BuddhistChronology */
public final class l extends a {
    private static final c K = new h("BE");
    private static final ConcurrentHashMap<g, l> L = new ConcurrentHashMap<>();
    private static final l M = b(g.f10938a);
    private static final long serialVersionUID = -3474595157769370126L;

    private l(a aVar, Object obj) {
        super(aVar, obj);
    }

    public static l N() {
        return M;
    }

    public static l b(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        l lVar = (l) L.get(gVar);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(n.a(gVar, null), null);
        b bVar = new b(1, 1, 1, 0, 0, 0, 0, lVar2);
        l lVar3 = new l(x.a(lVar2, bVar, null), "");
        l lVar4 = (l) L.putIfAbsent(gVar, lVar3);
        return lVar4 != null ? lVar4 : lVar3;
    }

    private Object readResolve() {
        a L2 = L();
        return L2 == null ? N() : b(L2.k());
    }

    public a G() {
        return M;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return k().equals(((l) obj).k());
    }

    public int hashCode() {
        return ("Buddhist".hashCode() * 11) + k().hashCode();
    }

    public String toString() {
        g k2 = k();
        String str = "BuddhistChronology";
        if (k2 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('[');
        sb.append(k2.c());
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        if (M() == null) {
            aVar.f10718l = t.a(i.c());
            aVar.E = new k(new r(this, aVar.E), 543);
            c cVar = aVar.F;
            aVar.F = new f(aVar.E, aVar.f10718l, d.V());
            aVar.B = new k(new r(this, aVar.B), 543);
            aVar.H = new org.joda.time.d.g(new k(aVar.F, 99), aVar.f10718l, d.x(), 100);
            aVar.f10717k = aVar.H.a();
            aVar.G = new k(new o((org.joda.time.d.g) aVar.H), d.U(), 1);
            aVar.C = new k(new o(aVar.B, aVar.f10717k, d.S(), 100), d.S(), 1);
            aVar.I = K;
        }
    }
}
