package org.joda.time.a;

import java.io.Serializable;
import org.joda.time.a;
import org.joda.time.b.u;
import org.joda.time.c.h;
import org.joda.time.e;
import org.joda.time.g;
import org.joda.time.p;

/* compiled from: BaseDateTime */
public abstract class d extends a implements p, Serializable {
    private static final long serialVersionUID = -6728882245981L;
    private volatile a iChronology;
    private volatile long iMillis;

    public d() {
        this(e.a(), (a) u.N());
    }

    private void f() {
        if (this.iMillis == Long.MIN_VALUE || this.iMillis == Long.MAX_VALUE) {
            this.iChronology = this.iChronology.G();
        }
    }

    /* access modifiers changed from: protected */
    public long a(long j2, a aVar) {
        return j2;
    }

    /* access modifiers changed from: protected */
    public a a(a aVar) {
        return e.a(aVar);
    }

    /* access modifiers changed from: protected */
    public void b(long j2) {
        this.iMillis = a(j2, this.iChronology);
    }

    public a getChronology() {
        return this.iChronology;
    }

    public long n() {
        return this.iMillis;
    }

    public d(long j2, g gVar) {
        this(j2, (a) u.b(gVar));
    }

    /* access modifiers changed from: protected */
    public void b(a aVar) {
        this.iChronology = a(aVar);
    }

    public d(long j2, a aVar) {
        this.iChronology = a(aVar);
        this.iMillis = a(j2, this.iChronology);
        f();
    }

    public d(Object obj, a aVar) {
        h a2 = org.joda.time.c.d.a().a(obj);
        this.iChronology = a(a2.b(obj, aVar));
        this.iMillis = a(a2.a(obj, aVar), this.iChronology);
        f();
    }

    public d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, a aVar) {
        this.iChronology = a(aVar);
        this.iMillis = a(this.iChronology.a(i2, i3, i4, i5, i6, i7, i8), this.iChronology);
        f();
    }
}
