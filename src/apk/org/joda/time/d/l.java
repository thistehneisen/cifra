package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: PreciseDateTimeField */
public class l extends m {

    /* renamed from: d reason: collision with root package name */
    private final int f10813d;

    /* renamed from: e reason: collision with root package name */
    private final h f10814e;

    public l(d dVar, h hVar, h hVar2) {
        super(dVar, hVar);
        if (hVar2.c()) {
            this.f10813d = (int) (hVar2.b() / j());
            if (this.f10813d >= 2) {
                this.f10814e = hVar2;
                return;
            }
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    public int a(long j2) {
        if (j2 >= 0) {
            return (int) ((j2 / j()) % ((long) this.f10813d));
        }
        return (this.f10813d - 1) + ((int) (((j2 + 1) / j()) % ((long) this.f10813d)));
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, d(), c());
        return j2 + (((long) (i2 - a(j2))) * this.f10815b);
    }

    public int c() {
        return this.f10813d - 1;
    }

    public h f() {
        return this.f10814e;
    }
}
