package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.internal.measurement.Cf;
import com.google.android.gms.measurement.internal.Mc;
import com.google.android.gms.measurement.internal.Ob;
import com.google.android.gms.measurement.internal.ee;
import com.google.firebase.iid.FirebaseInstanceId;

public final class FirebaseAnalytics {

    /* renamed from: a reason: collision with root package name */
    private static volatile FirebaseAnalytics f6650a;

    /* renamed from: b reason: collision with root package name */
    private final Ob f6651b;

    /* renamed from: c reason: collision with root package name */
    private final Cf f6652c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f6653d;

    /* renamed from: e reason: collision with root package name */
    private final Object f6654e;

    private FirebaseAnalytics(Ob ob) {
        q.a(ob);
        this.f6651b = ob;
        this.f6652c = null;
        this.f6653d = false;
        this.f6654e = new Object();
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f6650a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f6650a == null) {
                    if (Cf.b(context)) {
                        f6650a = new FirebaseAnalytics(Cf.a(context));
                    } else {
                        f6650a = new FirebaseAnalytics(Ob.a(context, (Af) null));
                    }
                }
            }
        }
        return f6650a;
    }

    @Keep
    public static Mc getScionFrontendApiImplementation(Context context, Bundle bundle) {
        if (!Cf.b(context)) {
            return null;
        }
        Cf a2 = Cf.a(context, (String) null, (String) null, (String) null, bundle);
        if (a2 == null) {
            return null;
        }
        return new a(a2);
    }

    public final void a(String str, Bundle bundle) {
        if (this.f6653d) {
            this.f6652c.a(str, bundle);
        } else {
            this.f6651b.y().a("app", str, bundle, true);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.b().a();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f6653d) {
            this.f6652c.a(activity, str, str2);
        } else if (!ee.a()) {
            this.f6651b.e().w().a("setCurrentScreen must be called from the main thread");
        } else {
            this.f6651b.B().a(activity, str, str2);
        }
    }

    public final void a(String str, String str2) {
        if (this.f6653d) {
            this.f6652c.b(str, str2);
        } else {
            this.f6651b.y().a("app", str, (Object) str2, false);
        }
    }

    private FirebaseAnalytics(Cf cf) {
        q.a(cf);
        this.f6651b = null;
        this.f6652c = cf;
        this.f6653d = true;
        this.f6654e = new Object();
    }
}
