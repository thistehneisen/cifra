package org.joda.time.d;

import org.joda.time.a;
import org.joda.time.c;

/* compiled from: SkipUndoDateTimeField */
public final class r extends f {
    private static final long serialVersionUID = -5875876968979L;

    /* renamed from: a reason: collision with root package name */
    private transient int f10821a;
    private final a iChronology;
    private final int iSkip;

    public r(a aVar, c cVar) {
        this(aVar, cVar, 0);
    }

    private Object readResolve() {
        return g().a(this.iChronology);
    }

    public int a(long j2) {
        int a2 = super.a(j2);
        return a2 < this.iSkip ? a2 + 1 : a2;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, this.f10821a, c());
        if (i2 <= this.iSkip) {
            i2--;
        }
        return super.b(j2, i2);
    }

    public int d() {
        return this.f10821a;
    }

    public r(a aVar, c cVar, int i2) {
        super(cVar);
        this.iChronology = aVar;
        int d2 = super.d();
        if (d2 < i2) {
            this.f10821a = d2 + 1;
        } else if (d2 == i2 + 1) {
            this.f10821a = i2;
        } else {
            this.f10821a = d2;
        }
        this.iSkip = i2;
    }
}
