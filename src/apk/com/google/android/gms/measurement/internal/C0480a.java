package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import b.d.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.a reason: case insensitive filesystem */
public final class C0480a extends Ea {

    /* renamed from: b reason: collision with root package name */
    private final Map<String, Long> f5809b = new b();

    /* renamed from: c reason: collision with root package name */
    private final Map<String, Integer> f5810c = new b();

    /* renamed from: d reason: collision with root package name */
    private long f5811d;

    public C0480a(Ob ob) {
        super(ob);
    }

    /* access modifiers changed from: private */
    public final void c(String str, long j2) {
        h();
        j();
        q.b(str);
        if (this.f5810c.isEmpty()) {
            this.f5811d = j2;
        }
        Integer num = (Integer) this.f5810c.get(str);
        if (num != null) {
            this.f5810c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f5810c.size() >= 100) {
            e().w().a("Too many ads visible");
        } else {
            this.f5810c.put(str, Integer.valueOf(1));
            this.f5809b.put(str, Long.valueOf(j2));
        }
    }

    /* access modifiers changed from: private */
    public final void d(String str, long j2) {
        h();
        j();
        q.b(str);
        Integer num = (Integer) this.f5810c.get(str);
        if (num != null) {
            Vc B = s().B();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f5810c.remove(str);
                Long l2 = (Long) this.f5809b.get(str);
                if (l2 == null) {
                    e().t().a("First ad unit exposure time was never set");
                } else {
                    long longValue = j2 - l2.longValue();
                    this.f5809b.remove(str);
                    a(str, longValue, B);
                }
                if (this.f5810c.isEmpty()) {
                    long j3 = this.f5811d;
                    if (j3 == 0) {
                        e().t().a("First ad exposure time was never set");
                        return;
                    } else {
                        a(j2 - j3, B);
                        this.f5811d = 0;
                    }
                }
                return;
            }
            this.f5810c.put(str, Integer.valueOf(intValue));
            return;
        }
        e().t().a("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void a(String str, long j2) {
        if (str == null || str.length() == 0) {
            e().t().a("Ad unit id must be a non-empty string");
        } else {
            d().a((Runnable) new C0496da(this, str, j2));
        }
    }

    public final void b(String str, long j2) {
        if (str == null || str.length() == 0) {
            e().t().a("Ad unit id must be a non-empty string");
        } else {
            d().a((Runnable) new B(this, str, j2));
        }
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

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
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

    public final /* bridge */ /* synthetic */ C0582uc p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ Uc s() {
        return super.s();
    }

    private final void a(long j2, Vc vc) {
        if (vc == null) {
            e().B().a("Not logging ad exposure. No active activity");
        } else if (j2 < 1000) {
            e().B().a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j2);
            Uc.a(vc, bundle, true);
            p().b("am", "_xa", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void b(long j2) {
        for (String put : this.f5809b.keySet()) {
            this.f5809b.put(put, Long.valueOf(j2));
        }
        if (!this.f5809b.isEmpty()) {
            this.f5811d = j2;
        }
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    private final void a(String str, long j2, Vc vc) {
        if (vc == null) {
            e().B().a("Not logging ad unit exposure. No active activity");
        } else if (j2 < 1000) {
            e().B().a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j2);
            Uc.a(vc, bundle, true);
            p().b("am", "_xu", bundle);
        }
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final void a(long j2) {
        Vc B = s().B();
        for (String str : this.f5809b.keySet()) {
            a(str, j2 - ((Long) this.f5809b.get(str)).longValue(), B);
        }
        if (!this.f5809b.isEmpty()) {
            a(j2 - this.f5811d, B);
        }
        b(j2);
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
