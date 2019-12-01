package org.joda.time.d;

import org.joda.time.h;
import org.joda.time.i;

/* compiled from: ScaledDurationField */
public class p extends e {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public p(h hVar, i iVar, int i2) {
        super(hVar, iVar);
        if (i2 == 0 || i2 == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i2;
    }

    public long a(long j2, int i2) {
        return f().a(j2, ((long) i2) * ((long) this.iScalar));
    }

    public long b() {
        return f().b() * ((long) this.iScalar);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (!(f().equals(pVar.f()) && a() == pVar.a() && this.iScalar == pVar.iScalar)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j2 = (long) this.iScalar;
        return ((int) (j2 ^ (j2 >>> 32))) + a().hashCode() + f().hashCode();
    }

    public long a(long j2, long j3) {
        return f().a(j2, h.a(j3, this.iScalar));
    }
}
