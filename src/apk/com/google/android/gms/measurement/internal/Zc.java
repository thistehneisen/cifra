package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.sf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class Zc extends C0503ec {
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final C0564qd f5790c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public C0487bb f5791d;

    /* renamed from: e reason: collision with root package name */
    private volatile Boolean f5792e;

    /* renamed from: f reason: collision with root package name */
    private final C0485b f5793f;

    /* renamed from: g reason: collision with root package name */
    private final Hd f5794g;

    /* renamed from: h reason: collision with root package name */
    private final List<Runnable> f5795h = new ArrayList();

    /* renamed from: i reason: collision with root package name */
    private final C0485b f5796i;

    protected Zc(Ob ob) {
        super(ob);
        this.f5794g = new Hd(ob.c());
        this.f5790c = new C0564qd(this);
        this.f5793f = new Yc(this, ob);
        this.f5796i = new C0524id(this, ob);
    }

    private final boolean I() {
        b();
        return true;
    }

    /* access modifiers changed from: private */
    public final void J() {
        j();
        this.f5794g.b();
        this.f5793f.a(((Long) C0535l.R.a(null)).longValue());
    }

    /* access modifiers changed from: private */
    public final void K() {
        j();
        if (C()) {
            e().B().a("Inactivity, disconnecting from the service");
            B();
        }
    }

    /* access modifiers changed from: private */
    public final void L() {
        j();
        e().B().a("Processing queued up service tasks", Integer.valueOf(this.f5795h.size()));
        for (Runnable run : this.f5795h) {
            try {
                run.run();
            } catch (Exception e2) {
                e().t().a("Task exception while flushing queue", e2);
            }
        }
        this.f5795h.clear();
        this.f5796i.a();
    }

    public final void B() {
        j();
        x();
        this.f5790c.a();
        try {
            a.a().a(a(), this.f5790c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f5791d = null;
    }

    public final boolean C() {
        j();
        x();
        return this.f5791d != null;
    }

    /* access modifiers changed from: protected */
    public final void D() {
        j();
        h();
        x();
        ae a2 = a(false);
        if (I()) {
            t().B();
        }
        a((Runnable) new C0489bd(this, a2));
    }

    /* access modifiers changed from: protected */
    public final void E() {
        j();
        x();
        ae a2 = a(true);
        boolean a3 = g().a(C0535l.Ja);
        if (a3) {
            t().C();
        }
        a((Runnable) new C0499dd(this, a2, a3));
    }

    /* access modifiers changed from: protected */
    public final void F() {
        j();
        x();
        a((Runnable) new C0519hd(this, a(true)));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    public final void G() {
        boolean z;
        boolean z2;
        boolean z3;
        j();
        x();
        if (!C()) {
            boolean z4 = false;
            if (this.f5792e == null) {
                j();
                x();
                Boolean v = f().v();
                if (v == null || !v.booleanValue()) {
                    b();
                    if (q().G() != 1) {
                        e().B().a("Checking service availability");
                        int a2 = m().a((int) g.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                        if (a2 != 0) {
                            if (a2 != 1) {
                                if (a2 == 2) {
                                    e().A().a("Service container out of date");
                                    if (m().w() >= 15300) {
                                        Boolean v2 = f().v();
                                        if (v2 == null || v2.booleanValue()) {
                                            z = true;
                                            z2 = false;
                                            if (!z && g().x()) {
                                                e().t().a("No way to upload. Consider using the full version of Analytics");
                                                z2 = false;
                                            }
                                            if (z2) {
                                                f().b(z);
                                            }
                                        }
                                    }
                                } else if (a2 == 3) {
                                    e().w().a("Service disabled");
                                } else if (a2 == 9) {
                                    e().w().a("Service invalid");
                                } else if (a2 != 18) {
                                    e().w().a("Unexpected service status", Integer.valueOf(a2));
                                } else {
                                    e().w().a("Service updating");
                                }
                                z = false;
                                z2 = false;
                                e().t().a("No way to upload. Consider using the full version of Analytics");
                                z2 = false;
                                if (z2) {
                                }
                            } else {
                                e().B().a("Service missing");
                            }
                            z3 = false;
                            z2 = true;
                            e().t().a("No way to upload. Consider using the full version of Analytics");
                            z2 = false;
                            if (z2) {
                            }
                        } else {
                            e().B().a("Service available");
                        }
                    }
                    z3 = true;
                    z2 = true;
                    e().t().a("No way to upload. Consider using the full version of Analytics");
                    z2 = false;
                    if (z2) {
                    }
                } else {
                    z = true;
                }
                this.f5792e = Boolean.valueOf(z);
            }
            if (this.f5792e.booleanValue()) {
                this.f5790c.b();
                return;
            }
            if (!g().x()) {
                b();
                String str = "com.google.android.gms.measurement.AppMeasurementService";
                List queryIntentServices = a().getPackageManager().queryIntentServices(new Intent().setClassName(a(), str), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    z4 = true;
                }
                if (z4) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context a3 = a();
                    b();
                    intent.setComponent(new ComponentName(a3, str));
                    this.f5790c.a(intent);
                    return;
                }
                e().t().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final Boolean H() {
        return this.f5792e;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    public final void a(C0487bb bbVar, com.google.android.gms.common.internal.safeparcel.a aVar, ae aeVar) {
        int i2;
        int size;
        int i3;
        j();
        h();
        x();
        boolean I = I();
        int i4 = 0;
        int i5 = 100;
        while (i4 < 1001 && i5 == 100) {
            ArrayList arrayList = new ArrayList();
            if (I) {
                List a2 = t().a(100);
                if (a2 != null) {
                    arrayList.addAll(a2);
                    i2 = a2.size();
                    if (aVar != null && i2 < 100) {
                        arrayList.add(aVar);
                    }
                    size = arrayList.size();
                    i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        com.google.android.gms.common.internal.safeparcel.a aVar2 = (com.google.android.gms.common.internal.safeparcel.a) obj;
                        if (aVar2 instanceof C0525j) {
                            try {
                                bbVar.a((C0525j) aVar2, aeVar);
                            } catch (RemoteException e2) {
                                e().t().a("Failed to send event to the service", e2);
                            }
                        } else if (aVar2 instanceof Rd) {
                            try {
                                bbVar.a((Rd) aVar2, aeVar);
                            } catch (RemoteException e3) {
                                e().t().a("Failed to send attribute to the service", e3);
                            }
                        } else if (aVar2 instanceof de) {
                            try {
                                bbVar.a((de) aVar2, aeVar);
                            } catch (RemoteException e4) {
                                e().t().a("Failed to send conditional property to the service", e4);
                            }
                        } else {
                            e().t().a("Discarding data. Unrecognized parcel type.");
                        }
                    }
                    i4++;
                    i5 = i2;
                }
            }
            i2 = 0;
            arrayList.add(aVar);
            size = arrayList.size();
            i3 = 0;
            while (i3 < size) {
            }
            i4++;
            i5 = i2;
        }
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
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

    public final /* bridge */ /* synthetic */ C0492cb q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ C0512gb t() {
        return super.t();
    }

    /* access modifiers changed from: protected */
    public final boolean z() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(C0525j jVar, String str) {
        q.a(jVar);
        j();
        x();
        boolean I = I();
        C0534kd kdVar = new C0534kd(this, I, I && t().a(jVar), jVar, a(true), str);
        a((Runnable) kdVar);
    }

    /* access modifiers changed from: protected */
    public final void a(de deVar) {
        q.a(deVar);
        j();
        x();
        b();
        C0529jd jdVar = new C0529jd(this, true, t().a(deVar), new de(deVar), a(true), deVar);
        a((Runnable) jdVar);
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReference<List<de>> atomicReference, String str, String str2, String str3) {
        j();
        x();
        C0544md mdVar = new C0544md(this, atomicReference, str, str2, str3, a(false));
        a((Runnable) mdVar);
    }

    /* access modifiers changed from: protected */
    public final void a(sf sfVar, String str, String str2) {
        j();
        x();
        C0539ld ldVar = new C0539ld(this, str, str2, a(false), sfVar);
        a((Runnable) ldVar);
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReference<List<Rd>> atomicReference, String str, String str2, String str3, boolean z) {
        j();
        x();
        C0554od odVar = new C0554od(this, atomicReference, str, str2, str3, z, a(false));
        a((Runnable) odVar);
    }

    /* access modifiers changed from: protected */
    public final void a(sf sfVar, String str, String str2, boolean z) {
        j();
        x();
        C0549nd ndVar = new C0549nd(this, str, str2, z, a(false), sfVar);
        a((Runnable) ndVar);
    }

    /* access modifiers changed from: protected */
    public final void a(Rd rd) {
        j();
        x();
        a((Runnable) new _c(this, I() && t().a(rd), rd, a(true)));
    }

    public final void a(AtomicReference<String> atomicReference) {
        j();
        x();
        a((Runnable) new C0484ad(this, atomicReference, a(false)));
    }

    public final void a(sf sfVar) {
        j();
        x();
        a((Runnable) new C0504ed(this, a(false), sfVar));
    }

    /* access modifiers changed from: protected */
    public final void a(Vc vc) {
        j();
        x();
        a((Runnable) new C0514gd(this, vc));
    }

    /* access modifiers changed from: protected */
    public final void a(C0487bb bbVar) {
        j();
        q.a(bbVar);
        this.f5791d = bbVar;
        J();
        L();
    }

    /* access modifiers changed from: private */
    public final void a(ComponentName componentName) {
        j();
        if (this.f5791d != null) {
            this.f5791d = null;
            e().B().a("Disconnected from device MeasurementService", componentName);
            j();
            G();
        }
    }

    private final void a(Runnable runnable) throws IllegalStateException {
        j();
        if (C()) {
            runnable.run();
        } else if (((long) this.f5795h.size()) >= 1000) {
            e().t().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f5795h.add(runnable);
            this.f5796i.a(60000);
            G();
        }
    }

    private final ae a(boolean z) {
        b();
        return q().a(z ? e().C() : null);
    }

    public final void a(sf sfVar, C0525j jVar, String str) {
        j();
        x();
        if (m().a((int) g.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            e().w().a("Not bundling data. Service unavailable or out of date");
            m().a(sfVar, new byte[0]);
            return;
        }
        a((Runnable) new C0509fd(this, jVar, str, sfVar));
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
