package com.touchin.vtb;

import androidx.appcompat.app.p;
import androidx.lifecycle.A;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.w;
import com.bluelinelabs.logansquare.LoganSquare;
import com.touchin.vtb.c.a.h;
import io.intercom.android.sdk.Intercom;
import java.math.BigDecimal;
import l.a.c.c.t;
import l.a.c.c.u;
import l.a.d.a.a.b;

/* compiled from: VTBAccountingApplication.kt */
public final class VTBAccountingApplication extends b implements u, k {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public static boolean f6880a = true;

    /* renamed from: b reason: collision with root package name */
    public static final a f6881b = new a(null);

    /* renamed from: c reason: collision with root package name */
    public t f6882c;

    /* compiled from: VTBAccountingApplication.kt */
    public static final class a {
        private a() {
        }

        public final boolean a() {
            return VTBAccountingApplication.f6880a;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    private final void c() {
        Intercom.initialize(this, "android_sdk-e629534292db98239555658040838bc34e3007d4", "o67ob76o");
    }

    private final void d() {
        com.touchin.vtb.c.a.h.a a2 = h.a();
        a2.a(new com.touchin.vtb.c.a.b(this));
        a2.a().a(this);
    }

    private final void e() {
        org.joda.time.e.b a2 = org.joda.time.e.a.a("yyyy-MM-dd'T'HH:mm:ssZ");
        LoganSquare.registerTypeConverter(BigDecimal.class, new ru.touchin.templates.a.a());
        LoganSquare.registerTypeConverter(org.joda.time.b.class, new ru.touchin.templates.a.b(a2));
    }

    public t a() {
        t tVar = this.f6882c;
        if (tVar != null) {
            return tVar;
        }
        kotlin.e.b.h.b("viewModelFactory");
        throw null;
    }

    @w(androidx.lifecycle.h.a.ON_STOP)
    public final void onAppBackgrounded() {
        f6880a = true;
    }

    @w(androidx.lifecycle.h.a.ON_START)
    public final void onAppForegrounded() {
        f6880a = false;
    }

    public void onCreate() {
        super.onCreate();
        l g2 = A.g();
        kotlin.e.b.h.a((Object) g2, "ProcessLifecycleOwner.get()");
        g2.getLifecycle().a(this);
        p.a(true);
        e();
        d();
        c();
    }
}
