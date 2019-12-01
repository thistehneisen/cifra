package org.joda.time.d;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.d;

/* compiled from: SkipDateTimeField */
public final class q extends f {
    private static final long serialVersionUID = -8869148464118507846L;

    /* renamed from: a reason: collision with root package name */
    private transient int f10820a;
    private final a iChronology;
    private final int iSkip;

    public q(a aVar, c cVar) {
        this(aVar, cVar, 0);
    }

    private Object readResolve() {
        return g().a(this.iChronology);
    }

    public int a(long j2) {
        int a2 = super.a(j2);
        return a2 <= this.iSkip ? a2 - 1 : a2;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, this.f10820a, c());
        int i3 = this.iSkip;
        if (i2 <= i3) {
            if (i2 != i3) {
                i2++;
            } else {
                throw new IllegalFieldValueException(d.T(), Integer.valueOf(i2), null, null);
            }
        }
        return super.b(j2, i2);
    }

    public int d() {
        return this.f10820a;
    }

    public q(a aVar, c cVar, int i2) {
        super(cVar);
        this.iChronology = aVar;
        int d2 = super.d();
        if (d2 < i2) {
            this.f10820a = d2 - 1;
        } else if (d2 == i2) {
            this.f10820a = i2 + 1;
        } else {
            this.f10820a = d2;
        }
        this.iSkip = i2;
    }
}
