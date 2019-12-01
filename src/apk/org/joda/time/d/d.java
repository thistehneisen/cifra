package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.h;

/* compiled from: DecoratedDateTimeField */
public abstract class d extends b {

    /* renamed from: b reason: collision with root package name */
    private final c f10801b;

    protected d(c cVar, org.joda.time.d dVar) {
        super(dVar);
        if (cVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (cVar.i()) {
            this.f10801b = cVar;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public int a(long j2) {
        return this.f10801b.a(j2);
    }

    public long b(long j2, int i2) {
        return this.f10801b.b(j2, i2);
    }

    public int c() {
        return this.f10801b.c();
    }

    public int d() {
        return this.f10801b.d();
    }

    public h f() {
        return this.f10801b.f();
    }

    public boolean h() {
        return this.f10801b.h();
    }

    public final c j() {
        return this.f10801b;
    }

    public h a() {
        return this.f10801b.a();
    }
}
