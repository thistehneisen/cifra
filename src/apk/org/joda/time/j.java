package org.joda.time;

import java.io.Serializable;
import org.joda.time.a.b;
import org.joda.time.b.u;

/* compiled from: Instant */
public final class j extends b implements r, Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final j f10957a = new j(0);
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public j() {
        this.iMillis = e.a();
    }

    public a getChronology() {
        return u.O();
    }

    public long n() {
        return this.iMillis;
    }

    public j toInstant() {
        return this;
    }

    public j(long j2) {
        this.iMillis = j2;
    }
}
