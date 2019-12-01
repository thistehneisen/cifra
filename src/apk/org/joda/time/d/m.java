package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: PreciseDurationDateTimeField */
public abstract class m extends b {

    /* renamed from: b reason: collision with root package name */
    final long f10815b;

    /* renamed from: c reason: collision with root package name */
    private final h f10816c;

    public m(d dVar, h hVar) {
        super(dVar);
        if (hVar.c()) {
            this.f10815b = hVar.b();
            if (this.f10815b >= 1) {
                this.f10816c = hVar;
                return;
            }
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public h a() {
        return this.f10816c;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, d(), d(j2, i2));
        return j2 + (((long) (i2 - a(j2))) * this.f10815b);
    }

    public long c(long j2) {
        if (j2 >= 0) {
            return j2 % this.f10815b;
        }
        long j3 = j2 + 1;
        long j4 = this.f10815b;
        return ((j3 % j4) + j4) - 1;
    }

    public int d() {
        return 0;
    }

    public long d(long j2) {
        if (j2 <= 0) {
            return j2 - (j2 % this.f10815b);
        }
        long j3 = j2 - 1;
        long j4 = this.f10815b;
        return (j3 - (j3 % j4)) + j4;
    }

    public long e(long j2) {
        long j3;
        if (j2 >= 0) {
            j3 = j2 % this.f10815b;
        } else {
            long j4 = j2 + 1;
            j3 = this.f10815b;
            j2 = j4 - (j4 % j3);
        }
        return j2 - j3;
    }

    public boolean h() {
        return false;
    }

    public final long j() {
        return this.f10815b;
    }

    /* access modifiers changed from: protected */
    public int d(long j2, int i2) {
        return i(j2);
    }
}
