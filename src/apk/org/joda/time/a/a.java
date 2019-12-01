package org.joda.time.a;

import org.joda.time.p;

/* compiled from: AbstractDateTime */
public abstract class a extends b implements p {
    protected a() {
    }

    public int c() {
        return getChronology().g().a(n());
    }

    public int d() {
        return getChronology().D().a(n());
    }

    public int e() {
        return getChronology().H().a(n());
    }

    public String toString() {
        return super.toString();
    }
}
