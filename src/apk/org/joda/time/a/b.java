package org.joda.time.a;

import org.joda.time.d.h;
import org.joda.time.e;
import org.joda.time.g;
import org.joda.time.j;
import org.joda.time.m;
import org.joda.time.r;

/* compiled from: AbstractInstant */
public abstract class b implements r {
    protected b() {
    }

    public g a() {
        return getChronology().k();
    }

    public m b() {
        return new m(n(), a());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (n() != rVar.n() || !h.a((Object) getChronology(), (Object) rVar.getChronology())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((int) (n() ^ (n() >>> 32))) + getChronology().hashCode();
    }

    public org.joda.time.b p() {
        return new org.joda.time.b(n(), a());
    }

    public j toInstant() {
        return new j(n());
    }

    public String toString() {
        return org.joda.time.e.j.b().a((r) this);
    }

    public boolean a(long j2) {
        return n() < j2;
    }

    /* renamed from: b */
    public int compareTo(r rVar) {
        if (this == rVar) {
            return 0;
        }
        int i2 = (n() > rVar.n() ? 1 : (n() == rVar.n() ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public boolean a(r rVar) {
        return a(e.b(rVar));
    }

    public String a(org.joda.time.e.b bVar) {
        if (bVar == null) {
            return toString();
        }
        return bVar.a((r) this);
    }
}
