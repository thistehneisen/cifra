package org.joda.time;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.joda.time.a.e;
import org.joda.time.b.u;
import org.joda.time.e.j;

/* compiled from: LocalDate */
public final class l extends e implements t, Serializable {

    /* renamed from: a reason: collision with root package name */
    private static final Set<i> f10958a = new HashSet();
    private static final long serialVersionUID = -8775358157899L;

    /* renamed from: b reason: collision with root package name */
    private transient int f10959b;
    private final a iChronology;
    private final long iLocalMillis;

    static {
        f10958a.add(i.b());
        f10958a.add(i.k());
        f10958a.add(i.i());
        f10958a.add(i.l());
        f10958a.add(i.m());
        f10958a.add(i.a());
        f10958a.add(i.c());
    }

    public l() {
        this(e.a(), u.N());
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        if (aVar == null) {
            return new l(this.iLocalMillis, u.O());
        }
        return !g.f10938a.equals(aVar.k()) ? new l(this.iLocalMillis, this.iChronology.G()) : this;
    }

    /* access modifiers changed from: protected */
    public c a(int i2, a aVar) {
        if (i2 == 0) {
            return aVar.H();
        }
        if (i2 == 1) {
            return aVar.w();
        }
        if (i2 == 2) {
            return aVar.e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid index: ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public int b(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (a(dVar)) {
            return dVar.a(getChronology()).a(a());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Field '");
            sb.append(dVar);
            sb.append("' is not supported");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.iChronology.equals(lVar.iChronology)) {
                if (this.iLocalMillis != lVar.iLocalMillis) {
                    z = false;
                }
                return z;
            }
        }
        return super.equals(obj);
    }

    public a getChronology() {
        return this.iChronology;
    }

    public int getValue(int i2) {
        if (i2 == 0) {
            return getChronology().H().a(a());
        }
        if (i2 == 1) {
            return getChronology().w().a(a());
        }
        if (i2 == 2) {
            return getChronology().e().a(a());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid index: ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public int hashCode() {
        int i2 = this.f10959b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = super.hashCode();
        this.f10959b = hashCode;
        return hashCode;
    }

    public int size() {
        return 3;
    }

    public String toString() {
        return j.a().a((t) this);
    }

    public l(long j2, a aVar) {
        a a2 = e.a(aVar);
        long a3 = a2.k().a(g.f10938a, j2);
        a G = a2.G();
        this.iLocalMillis = G.e().e(a3);
        this.iChronology = G;
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        i E = dVar.E();
        if (f10958a.contains(E) || E.a(getChronology()).b() >= getChronology().h().b()) {
            return dVar.a(getChronology()).i();
        }
        return false;
    }

    public int b() {
        return getChronology().H().a(a());
    }

    /* access modifiers changed from: protected */
    public long a() {
        return this.iLocalMillis;
    }

    /* renamed from: a */
    public int compareTo(t tVar) {
        int i2 = 0;
        if (this == tVar) {
            return 0;
        }
        if (tVar instanceof l) {
            l lVar = (l) tVar;
            if (this.iChronology.equals(lVar.iChronology)) {
                long j2 = this.iLocalMillis;
                long j3 = lVar.iLocalMillis;
                if (j2 < j3) {
                    i2 = -1;
                } else if (j2 != j3) {
                    i2 = 1;
                }
                return i2;
            }
        }
        return super.a(tVar);
    }
}
