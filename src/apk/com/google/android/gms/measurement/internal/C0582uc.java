package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import b.d.b;
import com.google.android.gms.common.api.internal.C0300c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.uc reason: case insensitive filesystem */
public final class C0582uc extends C0503ec {

    /* renamed from: c reason: collision with root package name */
    protected Nc f6117c;

    /* renamed from: d reason: collision with root package name */
    private C0558pc f6118d;

    /* renamed from: e reason: collision with root package name */
    private final Set<C0572sc> f6119e = new CopyOnWriteArraySet();

    /* renamed from: f reason: collision with root package name */
    private boolean f6120f;

    /* renamed from: g reason: collision with root package name */
    private final AtomicReference<String> f6121g = new AtomicReference<>();

    /* renamed from: h reason: collision with root package name */
    protected boolean f6122h = true;

    protected C0582uc(Ob ob) {
        super(ob);
    }

    /* access modifiers changed from: private */
    public final void M() {
        if (g().e(q().C(), C0535l.qa)) {
            j();
            String a2 = f().t.a();
            if (a2 != null) {
                if ("unset".equals(a2)) {
                    a("app", "_npa", (Object) null, c().currentTimeMillis());
                } else {
                    a("app", "_npa", (Object) Long.valueOf("true".equals(a2) ? 1 : 0), c().currentTimeMillis());
                }
            }
        }
        if (!this.f5987a.f() || !this.f6122h) {
            e().A().a("Updating Scion state (FE)");
            r().F();
            return;
        }
        e().A().a("Recording app launch after enabling measurement for the first time (FE)");
        L();
    }

    /* access modifiers changed from: private */
    public final void c(boolean z) {
        j();
        h();
        x();
        e().A().a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        f().a(z);
        M();
    }

    /* access modifiers changed from: private */
    public final void d(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = "creation_timestamp";
        String str2 = "origin";
        String str3 = "app_id";
        j();
        x();
        q.a(bundle);
        String str4 = "name";
        q.b(bundle2.getString(str4));
        if (!this.f5987a.f()) {
            e().A().a("Conditional property not cleared since collection is disabled");
            return;
        }
        Rd rd = new Rd(bundle2.getString(str4), 0, null, null);
        try {
            C0525j a2 = m().a(bundle2.getString(str3), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString(str2), bundle2.getLong(str), true, false);
            Rd rd2 = rd;
            de deVar = new de(bundle2.getString(str3), bundle2.getString(str2), rd2, bundle2.getLong(str), bundle2.getBoolean("active"), bundle2.getString("trigger_event_name"), null, bundle2.getLong("trigger_timeout"), null, bundle2.getLong("time_to_live"), a2);
            r().a(deVar);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final String B() {
        Vc C = this.f5987a.B().C();
        if (C != null) {
            return C.f5744b;
        }
        return null;
    }

    public final String C() {
        Vc C = this.f5987a.B().C();
        if (C != null) {
            return C.f5743a;
        }
        return null;
    }

    public final String D() {
        if (this.f5987a.n() != null) {
            return this.f5987a.n();
        }
        try {
            return C0300c.a();
        } catch (IllegalStateException e2) {
            this.f5987a.e().t().a("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    public final String E() {
        h();
        return (String) this.f6121g.get();
    }

    public final void F() {
        if (a().getApplicationContext() instanceof Application) {
            ((Application) a().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f6117c);
        }
    }

    public final Boolean G() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) d().a(atomicReference, 15000, "boolean test flag value", new C0577tc(this, atomicReference));
    }

    public final String H() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) d().a(atomicReference, 15000, "String test flag value", new Bc(this, atomicReference));
    }

    public final Long I() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) d().a(atomicReference, 15000, "long test flag value", new Ec(this, atomicReference));
    }

    public final Integer J() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) d().a(atomicReference, 15000, "int test flag value", new Hc(this, atomicReference));
    }

    public final Double K() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) d().a(atomicReference, 15000, "double test flag value", new Gc(this, atomicReference));
    }

    public final void L() {
        j();
        h();
        x();
        if (this.f5987a.u()) {
            r().E();
            this.f6122h = false;
            String y = f().y();
            if (!TextUtils.isEmpty(y)) {
                k().p();
                if (!y.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", y);
                    b("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void a(boolean z) {
        x();
        h();
        d().a((Runnable) new Jc(this, z));
    }

    public final void b(boolean z) {
        x();
        h();
        d().a((Runnable) new Ic(this, z));
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

    public final /* bridge */ /* synthetic */ void n() {
        super.n();
        throw null;
    }

    public final /* bridge */ /* synthetic */ C0492cb q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ Zc r() {
        return super.r();
    }

    public final /* bridge */ /* synthetic */ Uc s() {
        return super.s();
    }

    public final /* bridge */ /* synthetic */ C0608zd u() {
        return super.u();
    }

    /* access modifiers changed from: protected */
    public final boolean z() {
        return false;
    }

    public final void a(String str, String str2, Bundle bundle, boolean z) {
        a(str, str2, bundle, false, true, c().currentTimeMillis());
    }

    public final void b(long j2) {
        h();
        d().a((Runnable) new Lc(this, j2));
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str, String str2, long j2, Bundle bundle) {
        h();
        j();
        a(str, str2, j2, bundle, true, this.f6118d == null || Wd.e(str2), false, null);
    }

    public final void c(long j2) {
        h();
        d().a((Runnable) new Kc(this, j2));
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, c().currentTimeMillis());
    }

    private final void b(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle b2 = Wd.b(bundle);
        Ib d2 = d();
        C0592wc wcVar = new C0592wc(this, str, str2, j2, b2, z, z2, z3, str3);
        d2.a((Runnable) wcVar);
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Vc vc;
        int i2;
        int i3;
        ArrayList arrayList;
        long j3;
        Bundle bundle2;
        Class cls;
        String str9 = str;
        String str10 = str2;
        long j4 = j2;
        Bundle bundle3 = bundle;
        String str11 = str3;
        q.b(str);
        if (!g().e(str11, C0535l.va)) {
            q.b(str2);
        }
        q.a(bundle);
        j();
        x();
        if (!this.f5987a.f()) {
            e().A().a("Event not sent since app measurement is disabled");
            return;
        }
        if (g().e(q().C(), C0535l.Da)) {
            List E = q().E();
            if (E != null && !E.contains(str10)) {
                e().A().a("Dropping non-safelisted event. event name, origin", str10, str9);
                return;
            }
        }
        int i4 = 0;
        if (!this.f6120f) {
            this.f6120f = true;
            try {
                if (!this.f5987a.q()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, a().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{a()});
                } catch (Exception e2) {
                    e().w().a("Failed to invoke Tag Manager's initialize() method", e2);
                }
            } catch (ClassNotFoundException unused) {
                e().z().a("Tag Manager is not found and thus will not be used");
            }
        }
        if (g().e(q().C(), C0535l.Ka) && "_cmp".equals(str10)) {
            String str12 = "gclid";
            if (bundle3.containsKey(str12)) {
                a("auto", "_lgclid", (Object) bundle3.getString(str12), c().currentTimeMillis());
            }
        }
        if (z3) {
            b();
            if (!"_iap".equals(str10)) {
                Wd G = this.f5987a.G();
                String str13 = "event";
                int i5 = 2;
                if (G.b(str13, str10)) {
                    if (!G.a(str13, C0553oc.f6047a, str10)) {
                        i5 = 13;
                    } else if (G.a(str13, 40, str10)) {
                        i5 = 0;
                    }
                }
                if (i5 != 0) {
                    e().v().a("Invalid public event name. Event will not be logged (FE)", l().a(str10));
                    this.f5987a.G();
                    this.f5987a.G().a(i5, "_ev", Wd.a(str10, 40, true), str10 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        b();
        Vc B = s().B();
        String str14 = "_sc";
        if (B != null && !bundle3.containsKey(str14)) {
            B.f5746d = true;
        }
        Uc.a(B, bundle3, z && z3);
        boolean equals = "am".equals(str9);
        boolean e3 = Wd.e(str2);
        if (z && this.f6118d != null && !e3 && !equals) {
            e().A().a("Passing event to registered event handler (FE)", l().a(str10), l().a(bundle3));
            this.f6118d.a(str, str2, bundle, j2);
        } else if (this.f5987a.u()) {
            int b2 = m().b(str10);
            if (b2 != 0) {
                e().v().a("Invalid event name. Event will not be logged (FE)", l().a(str10));
                m();
                String a2 = Wd.a(str10, 40, true);
                if (str10 != null) {
                    i4 = str2.length();
                }
                this.f5987a.G().a(str3, b2, "_ev", a2, i4);
                return;
            }
            String str15 = "_sn";
            String str16 = "_o";
            String str17 = "_si";
            List a3 = e.a((T[]) new String[]{str16, str15, str14, str17});
            String str18 = str11;
            String str19 = str10;
            Bundle a4 = m().a(str3, str2, bundle, a3, z3, true);
            Vc vc2 = (a4 == null || !a4.containsKey(str14) || !a4.containsKey(str17)) ? null : new Vc(a4.getString(str15), a4.getString(str14), Long.valueOf(a4.getLong(str17)).longValue());
            Vc vc3 = vc2 == null ? B : vc2;
            String str20 = "_ae";
            if (g().r(str18)) {
                b();
                if (s().B() != null && str20.equals(str19)) {
                    long D = u().D();
                    if (D > 0) {
                        m().a(a4, D);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(a4);
            long nextLong = m().v().nextLong();
            if (!g().e(q().C(), C0535l.ja) || f().w.a() <= 0 || !f().a(j2) || !f().z.a()) {
                str4 = str16;
            } else {
                e().B().a("Current session is expired, remove the session number and Id");
                if (g().e(q().C(), C0535l.fa)) {
                    str4 = str16;
                    a("auto", "_sid", (Object) null, c().currentTimeMillis());
                } else {
                    str4 = str16;
                }
                if (g().e(q().C(), C0535l.ga)) {
                    a("auto", "_sno", (Object) null, c().currentTimeMillis());
                }
            }
            if (!g().q(q().C()) || a4.getLong("extend_session", 0) != 1) {
                long j5 = j2;
            } else {
                e().B().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.f5987a.D().a(j2, true);
            }
            String[] strArr = (String[]) a4.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                str5 = "_eid";
                if (i6 >= length) {
                    break;
                }
                String str21 = strArr[i6];
                Object obj = a4.get(str21);
                m();
                String[] strArr2 = strArr;
                Bundle[] a5 = Wd.a(obj);
                if (a5 != null) {
                    i2 = length;
                    a4.putInt(str21, a5.length);
                    int i8 = 0;
                    while (i8 < a5.length) {
                        Bundle bundle4 = a5[i8];
                        Uc.a(vc3, bundle4, true);
                        String str22 = str5;
                        int i9 = i7;
                        int i10 = i8;
                        int i11 = i6;
                        long j6 = nextLong;
                        Bundle bundle5 = bundle4;
                        ArrayList arrayList3 = arrayList2;
                        Vc vc4 = vc3;
                        String str23 = str20;
                        Bundle bundle6 = a4;
                        Bundle a6 = m().a(str3, "_ep", bundle5, a3, z3, false);
                        a6.putString("_en", str19);
                        a6.putLong(str22, j6);
                        a6.putString("_gn", str21);
                        a6.putInt("_ll", a5.length);
                        int i12 = i10;
                        a6.putInt("_i", i12);
                        arrayList3.add(a6);
                        int i13 = i12 + 1;
                        a4 = bundle6;
                        nextLong = j6;
                        arrayList2 = arrayList3;
                        i8 = i13;
                        i6 = i11;
                        vc3 = vc4;
                        i7 = i9;
                        str20 = str23;
                        str5 = str22;
                    }
                    vc = vc3;
                    i3 = i6;
                    j3 = nextLong;
                    arrayList = arrayList2;
                    str8 = str20;
                    bundle2 = a4;
                    i7 += a5.length;
                } else {
                    vc = vc3;
                    i2 = length;
                    i3 = i6;
                    int i14 = i7;
                    j3 = nextLong;
                    arrayList = arrayList2;
                    str8 = str20;
                    bundle2 = a4;
                }
                a4 = bundle2;
                nextLong = j3;
                arrayList2 = arrayList;
                length = i2;
                vc3 = vc;
                str20 = str8;
                long j7 = j2;
                i6 = i3 + 1;
                strArr = strArr2;
            }
            String str24 = str5;
            int i15 = i7;
            long j8 = nextLong;
            ArrayList arrayList4 = arrayList2;
            String str25 = str20;
            Bundle bundle7 = a4;
            if (i15 != 0) {
                bundle7.putLong(str24, j8);
                bundle7.putInt("_epc", i15);
            }
            int i16 = 0;
            while (i16 < arrayList4.size()) {
                Bundle bundle8 = (Bundle) arrayList4.get(i16);
                if (i16 != 0) {
                    str7 = "_ep";
                    str6 = str19;
                } else {
                    str7 = str19;
                    str6 = str7;
                }
                String str26 = str4;
                bundle8.putString(str26, str);
                if (z2) {
                    bundle8 = m().a(bundle8);
                }
                Bundle bundle9 = bundle8;
                e().A().a("Logging event (FE)", l().a(str6), l().a(bundle9));
                ArrayList arrayList5 = arrayList4;
                C0525j jVar = new C0525j(str7, new C0520i(bundle9), str, j2);
                r().a(jVar, str3);
                if (!equals) {
                    for (C0572sc onEvent : this.f6119e) {
                        onEvent.onEvent(str, str2, new Bundle(bundle9), j2);
                    }
                }
                i16++;
                str19 = str6;
                str4 = str26;
                arrayList4 = arrayList5;
            }
            String str27 = str19;
            b();
            if (s().B() != null && str25.equals(str27)) {
                u().a(true, true);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void c(String str, String str2, Bundle bundle) {
        h();
        j();
        a(str, str2, c().currentTimeMillis(), bundle);
    }

    public final void b(C0572sc scVar) {
        h();
        x();
        q.a(scVar);
        if (!this.f6119e.remove(scVar)) {
            e().w().a("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: private */
    public final void c(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = "app_id";
        j();
        x();
        q.a(bundle);
        String str2 = "name";
        q.b(bundle2.getString(str2));
        String str3 = "origin";
        q.b(bundle2.getString(str3));
        String str4 = "value";
        q.a(bundle2.get(str4));
        if (!this.f5987a.f()) {
            e().A().a("Conditional property not sent since collection is disabled");
            return;
        }
        Rd rd = new Rd(bundle2.getString(str2), bundle2.getLong("triggered_timestamp"), bundle2.get(str4), bundle2.getString(str3));
        try {
            C0525j a2 = m().a(bundle2.getString(str), bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), bundle2.getString(str3), 0, true, false);
            de deVar = new de(bundle2.getString(str), bundle2.getString(str3), rd, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), m().a(bundle2.getString(str), bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), bundle2.getString(str3), 0, true, false), bundle2.getLong("trigger_timeout"), a2, bundle2.getLong("time_to_live"), m().a(bundle2.getString(str), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString(str3), 0, true, false));
            r().a(deVar);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void b(Bundle bundle) {
        q.a(bundle);
        q.b(bundle.getString("app_id"));
        n();
        throw null;
    }

    private final void b(Bundle bundle, long j2) {
        q.a(bundle);
        C0538lc.a(bundle, "app_id", String.class, null);
        String str = "origin";
        C0538lc.a(bundle, str, String.class, null);
        String str2 = "name";
        C0538lc.a(bundle, str2, String.class, null);
        String str3 = "value";
        C0538lc.a(bundle, str3, Object.class, null);
        String str4 = "trigger_event_name";
        C0538lc.a(bundle, str4, String.class, null);
        Long valueOf = Long.valueOf(0);
        String str5 = "trigger_timeout";
        C0538lc.a(bundle, str5, Long.class, valueOf);
        C0538lc.a(bundle, "timed_out_event_name", String.class, null);
        C0538lc.a(bundle, "timed_out_event_params", Bundle.class, null);
        C0538lc.a(bundle, "triggered_event_name", String.class, null);
        C0538lc.a(bundle, "triggered_event_params", Bundle.class, null);
        String str6 = "time_to_live";
        C0538lc.a(bundle, str6, Long.class, valueOf);
        C0538lc.a(bundle, "expired_event_name", String.class, null);
        C0538lc.a(bundle, "expired_event_params", Bundle.class, null);
        q.b(bundle.getString(str2));
        q.b(bundle.getString(str));
        q.a(bundle.get(str3));
        bundle.putLong("creation_timestamp", j2);
        String string = bundle.getString(str2);
        Object obj = bundle.get(str3);
        if (m().c(string) != 0) {
            e().t().a("Invalid conditional user property name", l().c(string));
        } else if (m().b(string, obj) != 0) {
            e().t().a("Invalid conditional user property value", l().c(string), obj);
        } else {
            Object c2 = m().c(string, obj);
            if (c2 == null) {
                e().t().a("Unable to normalize conditional user property value", l().c(string), obj);
                return;
            }
            C0538lc.a(bundle, c2);
            long j3 = bundle.getLong(str5);
            if (TextUtils.isEmpty(bundle.getString(str4)) || (j3 <= 15552000000L && j3 >= 1)) {
                long j4 = bundle.getLong(str6);
                if (j4 > 15552000000L || j4 < 1) {
                    e().t().a("Invalid conditional user property time to live", l().c(string), Long.valueOf(j4));
                    return;
                }
                d().a((Runnable) new Ac(this, bundle));
                return;
            }
            e().t().a("Invalid conditional user property timeout", l().c(string), Long.valueOf(j3));
        }
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    private final void b(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = c().currentTimeMillis();
        q.b(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        d().a((Runnable) new C0607zc(this, bundle2));
    }

    public final ArrayList<Bundle> b(String str, String str2) {
        h();
        return b((String) null, str, str2);
    }

    private final ArrayList<Bundle> b(String str, String str2, String str3) {
        if (d().t()) {
            e().t().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (ee.a()) {
            e().t().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                Ib d2 = this.f5987a.d();
                Cc cc = new Cc(this, atomicReference, str, str2, str3);
                d2.a((Runnable) cc);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e2) {
                    e().w().a("Interrupted waiting for get conditional user properties", str, e2);
                }
            }
            List list = (List) atomicReference.get();
            if (list != null) {
                return Wd.b(list);
            }
            e().w().a("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    private final Map<String, Object> b(String str, String str2, String str3, boolean z) {
        if (d().t()) {
            e().t().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (ee.a()) {
            e().t().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                Ib d2 = this.f5987a.d();
                Fc fc = new Fc(this, atomicReference, str, str2, str3, z);
                d2.a((Runnable) fc);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e2) {
                    e().w().a("Interrupted waiting for get user properties", e2);
                }
            }
            List<Rd> list = (List) atomicReference.get();
            if (list == null) {
                e().w().a("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            b bVar = new b(list.size());
            for (Rd rd : list) {
                bVar.put(rd.f5706b, rd.f());
            }
            return bVar;
        }
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        boolean z3;
        h();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2) {
            if (this.f6118d != null && !Wd.e(str2)) {
                z3 = false;
                b(str3, str2, j2, bundle2, z2, z3, !z, null);
            }
        }
        z3 = true;
        b(str3, str2, j2, bundle2, z2, z3, !z, null);
    }

    public final void a(String str, String str2, Object obj, boolean z) {
        a(str, str2, obj, z, c().currentTimeMillis());
    }

    public final void a(String str, String str2, Object obj, boolean z, long j2) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 6;
        int i3 = 0;
        if (z) {
            i2 = m().c(str2);
        } else {
            Wd m = m();
            String str4 = "user property";
            if (m.b(str4, str2)) {
                if (!m.a(str4, C0563qc.f6068a, str2)) {
                    i2 = 15;
                } else if (m.a(str4, 24, str2)) {
                    i2 = 0;
                }
            }
        }
        String str5 = "_ev";
        if (i2 != 0) {
            m();
            String a2 = Wd.a(str2, 24, true);
            if (str2 != null) {
                i3 = str2.length();
            }
            this.f5987a.G().a(i2, str5, a2, i3);
        } else if (obj != null) {
            int b2 = m().b(str2, obj);
            if (b2 != 0) {
                m();
                String a3 = Wd.a(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i3 = String.valueOf(obj).length();
                }
                this.f5987a.G().a(b2, str5, a3, i3);
                return;
            }
            Object c2 = m().c(str2, obj);
            if (c2 != null) {
                a(str3, str2, j2, c2);
            }
        } else {
            a(str3, str2, j2, (Object) null);
        }
    }

    private final void a(String str, String str2, long j2, Object obj) {
        Ib d2 = d();
        C0587vc vcVar = new C0587vc(this, str, str2, obj, j2);
        d2.a((Runnable) vcVar);
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r10v14, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=null, for r11v0, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v2
      assigns: []
      uses: []
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Unknown variable types count: 5 */
    public final void a(String str, String str2, Object r11, long j2) {
        ? r6;
        String str3;
        ? r62;
        q.b(str);
        q.b(str2);
        j();
        h();
        x();
        String str4 = "_npa";
        if (g().e(q().C(), C0535l.qa) && "allow_personalized_ads".equals(str2)) {
            if (r11 instanceof String) {
                String str5 = (String) r11;
                if (!TextUtils.isEmpty(str5)) {
                    String str6 = "false";
                    ? valueOf = Long.valueOf(str6.equals(str5.toLowerCase(Locale.ENGLISH)) ? 1 : 0);
                    Ab ab = f().t;
                    if (valueOf.longValue() == 1) {
                        str6 = "true";
                    }
                    ab.a(str6);
                    r62 = valueOf;
                    str3 = str4;
                    r6 = r62;
                    if (!this.f5987a.f()) {
                        e().A().a("User property not set since app measurement is disabled");
                        return;
                    } else if (this.f5987a.u()) {
                        e().A().a("Setting user property (FE)", l().a(str3), r6);
                        Rd rd = new Rd(str3, j2, r6, str);
                        r().a(rd);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (r11 == 0) {
                f().t.a("unset");
                r62 = r11;
                str3 = str4;
                r6 = r62;
                if (!this.f5987a.f()) {
                }
            }
        }
        str3 = str2;
        r6 = r11;
        if (!this.f5987a.f()) {
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str) {
        this.f6121g.set(str);
    }

    public final void a(long j2) {
        a((String) null);
        d().a((Runnable) new C0602yc(this, j2));
    }

    public final void a(C0558pc pcVar) {
        j();
        h();
        x();
        if (pcVar != null) {
            C0558pc pcVar2 = this.f6118d;
            if (pcVar != pcVar2) {
                q.b(pcVar2 == null, "EventInterceptor already set.");
            }
        }
        this.f6118d = pcVar;
    }

    public final void a(C0572sc scVar) {
        h();
        x();
        q.a(scVar);
        if (!this.f6119e.add(scVar)) {
            e().w().a("OnEventListener already registered");
        }
    }

    public final void a(Bundle bundle) {
        a(bundle, c().currentTimeMillis());
    }

    public final void a(Bundle bundle, long j2) {
        q.a(bundle);
        h();
        Bundle bundle2 = new Bundle(bundle);
        String str = "app_id";
        if (!TextUtils.isEmpty(bundle2.getString(str))) {
            e().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(str);
        b(bundle2, j2);
    }

    public final void a(String str, String str2, Bundle bundle) {
        h();
        b((String) null, str, str2, bundle);
    }

    public final void a(String str, String str2, String str3, Bundle bundle) {
        q.b(str);
        n();
        throw null;
    }

    public final ArrayList<Bundle> a(String str, String str2, String str3) {
        q.b(str);
        n();
        throw null;
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        h();
        return b((String) null, str, str2, z);
    }

    public final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        q.b(str);
        n();
        throw null;
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
