package org.joda.time.d;

import org.joda.time.i;

/* compiled from: PreciseDurationField */
public class n extends c {
    private static final long serialVersionUID = -8346152187724495365L;
    private final long iUnitMillis;

    public n(i iVar, long j2) {
        super(iVar);
        this.iUnitMillis = j2;
    }

    public long a(long j2, int i2) {
        return h.a(j2, ((long) i2) * this.iUnitMillis);
    }

    public final long b() {
        return this.iUnitMillis;
    }

    public final boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!(a() == nVar.a() && this.iUnitMillis == nVar.iUnitMillis)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j2 = this.iUnitMillis;
        return ((int) (j2 ^ (j2 >>> 32))) + a().hashCode();
    }

    public long a(long j2, long j3) {
        return h.a(j2, h.b(j3, this.iUnitMillis));
    }
}
