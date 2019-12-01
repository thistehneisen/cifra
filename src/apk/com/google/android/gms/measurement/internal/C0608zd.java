package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.Dc;

/* renamed from: com.google.android.gms.measurement.internal.zd reason: case insensitive filesystem */
public final class C0608zd extends C0503ec {

    /* renamed from: c reason: collision with root package name */
    private Handler f6180c;

    /* renamed from: d reason: collision with root package name */
    private long f6181d = c().a();

    /* renamed from: e reason: collision with root package name */
    private long f6182e = this.f6181d;

    /* renamed from: f reason: collision with root package name */
    private final C0485b f6183f = new Cd(this, this.f5987a);

    /* renamed from: g reason: collision with root package name */
    private final C0485b f6184g = new Bd(this, this.f5987a);

    C0608zd(Ob ob) {
        super(ob);
    }

    private final void E() {
        synchronized (this) {
            if (this.f6180c == null) {
                this.f6180c = new Dc(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void F() {
        j();
        a(false, false);
        o().a(c().a());
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        j();
        E();
        if (g().e(q().C(), C0535l.ja)) {
            f().z.a(false);
        }
        e().B().a("Activity resumed, time", Long.valueOf(j2));
        this.f6181d = j2;
        this.f6182e = this.f6181d;
        if (this.f5987a.f()) {
            if (g().p(q().C())) {
                a(c().currentTimeMillis(), false);
                return;
            }
            this.f6183f.a();
            this.f6184g.a();
            if (f().a(c().currentTimeMillis())) {
                f().s.a(true);
                f().x.a(0);
            }
            if (f().s.a()) {
                this.f6183f.a(Math.max(0, f().q.a() - f().x.a()));
            } else {
                this.f6184g.a(Math.max(0, 3600000 - f().x.a()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(long j2) {
        j();
        E();
        if (g().e(q().C(), C0535l.ja)) {
            f().z.a(true);
        }
        this.f6183f.a();
        this.f6184g.a();
        e().B().a("Activity paused, time", Long.valueOf(j2));
        if (this.f6181d != 0) {
            f().x.a(f().x.a() + (j2 - this.f6181d));
        }
    }

    private final void c(long j2) {
        j();
        e().B().a("Session started, time", Long.valueOf(c().a()));
        Long valueOf = g().n(q().C()) ? Long.valueOf(j2 / 1000) : null;
        p().a("auto", "_sid", (Object) valueOf, j2);
        f().s.a(false);
        Bundle bundle = new Bundle();
        if (g().n(q().C())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        p().a("auto", "_s", j2, bundle);
        f().w.a(j2);
    }

    /* access modifiers changed from: 0000 */
    public final void B() {
        j();
        this.f6183f.a();
        this.f6184g.a();
        this.f6181d = 0;
        this.f6182e = this.f6181d;
    }

    /* access modifiers changed from: protected */
    public final void C() {
        j();
        c(c().currentTimeMillis());
    }

    /* access modifiers changed from: 0000 */
    public final long D() {
        long a2 = c().a();
        long j2 = a2 - this.f6182e;
        this.f6182e = a2;
        return j2;
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0480a o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0582uc p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ C0492cb q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ Uc s() {
        return super.s();
    }

    /* access modifiers changed from: protected */
    public final boolean z() {
        return false;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    /* access modifiers changed from: 0000 */
    public final void a(long j2, boolean z) {
        j();
        E();
        this.f6183f.a();
        this.f6184g.a();
        if (f().a(j2)) {
            f().s.a(true);
            f().x.a(0);
        }
        if (z && g().q(q().C())) {
            f().w.a(j2);
        }
        if (f().s.a()) {
            c(j2);
        } else {
            this.f6184g.a(Math.max(0, 3600000 - f().x.a()));
        }
    }

    public final boolean a(boolean z, boolean z2) {
        j();
        x();
        long a2 = c().a();
        f().w.a(c().currentTimeMillis());
        long j2 = a2 - this.f6181d;
        if (z || j2 >= 1000) {
            f().x.a(j2);
            e().B().a("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            Uc.a(s().B(), bundle, true);
            if (g().r(q().C())) {
                if (g().e(q().C(), C0535l.oa)) {
                    if (!z2) {
                        D();
                    }
                } else if (z2) {
                    bundle.putLong("_fr", 1);
                } else {
                    D();
                }
            }
            if (!g().e(q().C(), C0535l.oa) || !z2) {
                p().b("auto", "_e", bundle);
            }
            this.f6181d = a2;
            this.f6184g.a();
            this.f6184g.a(Math.max(0, 3600000 - f().x.a()));
            return true;
        }
        e().B().a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
