package org.joda.time.b;

import org.joda.time.g;
import org.joda.time.j;

/* compiled from: GJCacheKey */
class m {

    /* renamed from: a reason: collision with root package name */
    private final g f10730a;

    /* renamed from: b reason: collision with root package name */
    private final j f10731b;

    /* renamed from: c reason: collision with root package name */
    private final int f10732c;

    m(g gVar, j jVar, int i2) {
        this.f10730a = gVar;
        this.f10731b = jVar;
        this.f10732c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        j jVar = this.f10731b;
        if (jVar == null) {
            if (mVar.f10731b != null) {
                return false;
            }
        } else if (!jVar.equals(mVar.f10731b)) {
            return false;
        }
        if (this.f10732c != mVar.f10732c) {
            return false;
        }
        g gVar = this.f10730a;
        if (gVar == null) {
            if (mVar.f10730a != null) {
                return false;
            }
        } else if (!gVar.equals(mVar.f10730a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        j jVar = this.f10731b;
        int i2 = 0;
        int hashCode = ((((jVar == null ? 0 : jVar.hashCode()) + 31) * 31) + this.f10732c) * 31;
        g gVar = this.f10730a;
        if (gVar != null) {
            i2 = gVar.hashCode();
        }
        return hashCode + i2;
    }
}
