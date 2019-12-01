package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.internal.measurement.qf;
import com.google.android.gms.internal.measurement.sf;
import com.google.android.gms.internal.measurement.tf;
import com.google.android.gms.internal.measurement.yf;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends qf {

    /* renamed from: a reason: collision with root package name */
    Ob f5504a = null;

    /* renamed from: b reason: collision with root package name */
    private Map<Integer, C0572sc> f5505b = new b.d.b();

    class a implements C0572sc {

        /* renamed from: a reason: collision with root package name */
        private tf f5506a;

        a(tf tfVar) {
            this.f5506a = tfVar;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j2) {
            try {
                this.f5506a.onEvent(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f5504a.e().w().a("Event listener threw exception", e2);
            }
        }
    }

    class b implements C0558pc {

        /* renamed from: a reason: collision with root package name */
        private tf f5508a;

        b(tf tfVar) {
            this.f5508a = tfVar;
        }

        public final void a(String str, String str2, Bundle bundle, long j2) {
            try {
                this.f5508a.onEvent(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f5504a.e().w().a("Event interceptor threw exception", e2);
            }
        }
    }

    private final void a(sf sfVar, String str) {
        this.f5504a.G().a(sfVar, str);
    }

    private final void h() {
        if (this.f5504a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void beginAdUnitExposure(String str, long j2) throws RemoteException {
        h();
        this.f5504a.x().a(str, j2);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        h();
        this.f5504a.y().a(str, str2, bundle);
    }

    public void endAdUnitExposure(String str, long j2) throws RemoteException {
        h();
        this.f5504a.x().b(str, j2);
    }

    public void generateEventId(sf sfVar) throws RemoteException {
        h();
        this.f5504a.G().a(sfVar, this.f5504a.G().u());
    }

    public void getAppInstanceId(sf sfVar) throws RemoteException {
        h();
        this.f5504a.d().a((Runnable) new Dc(this, sfVar));
    }

    public void getCachedAppInstanceId(sf sfVar) throws RemoteException {
        h();
        a(sfVar, this.f5504a.y().E());
    }

    public void getConditionalUserProperties(String str, String str2, sf sfVar) throws RemoteException {
        h();
        this.f5504a.d().a((Runnable) new Zd(this, sfVar, str, str2));
    }

    public void getCurrentScreenClass(sf sfVar) throws RemoteException {
        h();
        a(sfVar, this.f5504a.y().B());
    }

    public void getCurrentScreenName(sf sfVar) throws RemoteException {
        h();
        a(sfVar, this.f5504a.y().C());
    }

    public void getDeepLink(sf sfVar) throws RemoteException {
        h();
        C0582uc y = this.f5504a.y();
        y.j();
        String str = "";
        if (!y.g().d(null, C0535l.Ia)) {
            y.m().a(sfVar, str);
        } else if (y.f().A.a() > 0) {
            y.m().a(sfVar, str);
        } else {
            y.f().A.a(y.c().currentTimeMillis());
            y.f5987a.a(sfVar);
        }
    }

    public void getGmpAppId(sf sfVar) throws RemoteException {
        h();
        a(sfVar, this.f5504a.y().D());
    }

    public void getMaxUserProperties(String str, sf sfVar) throws RemoteException {
        h();
        this.f5504a.y();
        q.b(str);
        this.f5504a.G().a(sfVar, 25);
    }

    public void getTestFlag(sf sfVar, int i2) throws RemoteException {
        h();
        if (i2 == 0) {
            this.f5504a.G().a(sfVar, this.f5504a.y().H());
        } else if (i2 == 1) {
            this.f5504a.G().a(sfVar, this.f5504a.y().I().longValue());
        } else if (i2 == 2) {
            Wd G = this.f5504a.G();
            double doubleValue = this.f5504a.y().K().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                sfVar.c(bundle);
            } catch (RemoteException e2) {
                G.f5987a.e().w().a("Error returning double value to wrapper", e2);
            }
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.f5504a.G().a(sfVar, this.f5504a.y().G().booleanValue());
            }
        } else {
            this.f5504a.G().a(sfVar, this.f5504a.y().J().intValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, sf sfVar) throws RemoteException {
        h();
        Ib d2 = this.f5504a.d();
        C0494cd cdVar = new C0494cd(this, sfVar, str, str2, z);
        d2.a((Runnable) cdVar);
    }

    public void initForTests(Map map) throws RemoteException {
        h();
    }

    public void initialize(com.google.android.gms.dynamic.a aVar, Af af, long j2) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        Ob ob = this.f5504a;
        if (ob == null) {
            this.f5504a = Ob.a(context, af);
        } else {
            ob.e().w().a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(sf sfVar) throws RemoteException {
        h();
        this.f5504a.d().a((Runnable) new Yd(this, sfVar));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        h();
        this.f5504a.y().a(str, str2, bundle, z, z2, j2);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, sf sfVar, long j2) throws RemoteException {
        h();
        q.b(str2);
        String str3 = "app";
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", str3);
        C0525j jVar = new C0525j(str2, new C0520i(bundle), str3, j2);
        this.f5504a.d().a((Runnable) new Dd(this, sfVar, jVar, str));
    }

    public void logHealthData(int i2, String str, com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) throws RemoteException {
        Object obj;
        Object obj2;
        h();
        Object obj3 = null;
        if (aVar == null) {
            obj = null;
        } else {
            obj = com.google.android.gms.dynamic.b.a(aVar);
        }
        if (aVar2 == null) {
            obj2 = null;
        } else {
            obj2 = com.google.android.gms.dynamic.b.a(aVar2);
        }
        if (aVar3 != null) {
            obj3 = com.google.android.gms.dynamic.b.a(aVar3);
        }
        this.f5504a.e().a(i2, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(com.google.android.gms.dynamic.a aVar, Bundle bundle, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityCreated((Activity) com.google.android.gms.dynamic.b.a(aVar), bundle);
        }
    }

    public void onActivityDestroyed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityDestroyed((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    public void onActivityPaused(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityPaused((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    public void onActivityResumed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityResumed((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    public void onActivitySaveInstanceState(com.google.android.gms.dynamic.a aVar, sf sfVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        Bundle bundle = new Bundle();
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivitySaveInstanceState((Activity) com.google.android.gms.dynamic.b.a(aVar), bundle);
        }
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5504a.e().w().a("Error returning bundle value to wrapper", e2);
        }
    }

    public void onActivityStarted(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityStarted((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    public void onActivityStopped(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        h();
        Nc nc = this.f5504a.y().f6117c;
        if (nc != null) {
            this.f5504a.y().F();
            nc.onActivityStopped((Activity) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    public void performAction(Bundle bundle, sf sfVar, long j2) throws RemoteException {
        h();
        sfVar.c(null);
    }

    public void registerOnMeasurementEventListener(tf tfVar) throws RemoteException {
        h();
        C0572sc scVar = (C0572sc) this.f5505b.get(Integer.valueOf(tfVar.e()));
        if (scVar == null) {
            scVar = new a(tfVar);
            this.f5505b.put(Integer.valueOf(tfVar.e()), scVar);
        }
        this.f5504a.y().a(scVar);
    }

    public void resetAnalyticsData(long j2) throws RemoteException {
        h();
        this.f5504a.y().a(j2);
    }

    public void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        h();
        if (bundle == null) {
            this.f5504a.e().t().a("Conditional user property must not be null");
        } else {
            this.f5504a.y().a(bundle, j2);
        }
    }

    public void setCurrentScreen(com.google.android.gms.dynamic.a aVar, String str, String str2, long j2) throws RemoteException {
        h();
        this.f5504a.B().a((Activity) com.google.android.gms.dynamic.b.a(aVar), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        h();
        this.f5504a.y().b(z);
    }

    public void setEventInterceptor(tf tfVar) throws RemoteException {
        h();
        C0582uc y = this.f5504a.y();
        b bVar = new b(tfVar);
        y.h();
        y.x();
        y.d().a((Runnable) new C0597xc(y, bVar));
    }

    public void setInstanceIdProvider(yf yfVar) throws RemoteException {
        h();
    }

    public void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        h();
        this.f5504a.y().a(z);
    }

    public void setMinimumSessionDuration(long j2) throws RemoteException {
        h();
        this.f5504a.y().b(j2);
    }

    public void setSessionTimeoutDuration(long j2) throws RemoteException {
        h();
        this.f5504a.y().c(j2);
    }

    public void setUserId(String str, long j2) throws RemoteException {
        h();
        this.f5504a.y().a(null, "_id", str, true, j2);
    }

    public void setUserProperty(String str, String str2, com.google.android.gms.dynamic.a aVar, boolean z, long j2) throws RemoteException {
        h();
        this.f5504a.y().a(str, str2, com.google.android.gms.dynamic.b.a(aVar), z, j2);
    }

    public void unregisterOnMeasurementEventListener(tf tfVar) throws RemoteException {
        h();
        C0572sc scVar = (C0572sc) this.f5505b.remove(Integer.valueOf(tfVar.e()));
        if (scVar == null) {
            scVar = new a(tfVar);
        }
        this.f5504a.y().b(scVar);
    }
}
