package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.measurement.internal.Ad;

/* renamed from: com.google.android.gms.measurement.internal.wd reason: case insensitive filesystem */
public final class C0593wd<T extends Context & Ad> {

    /* renamed from: a reason: collision with root package name */
    private final T f6151a;

    public C0593wd(T t) {
        q.a(t);
        this.f6151a = t;
    }

    public final void a() {
        Ob a2 = Ob.a((Context) this.f6151a, (Af) null);
        C0532kb e2 = a2.e();
        a2.b();
        e2.B().a("Local AppMeasurementService is starting up");
    }

    public final void b() {
        Ob a2 = Ob.a((Context) this.f6151a, (Af) null);
        C0532kb e2 = a2.e();
        a2.b();
        e2.B().a("Local AppMeasurementService is shutting down");
    }

    public final boolean c(Intent intent) {
        if (intent == null) {
            c().t().a("onUnbind called with null intent");
            return true;
        }
        c().B().a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    private final C0532kb c() {
        return Ob.a((Context) this.f6151a, (Af) null).e();
    }

    public final int a(Intent intent, int i2, int i3) {
        Ob a2 = Ob.a((Context) this.f6151a, (Af) null);
        C0532kb e2 = a2.e();
        if (intent == null) {
            e2.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a2.b();
        e2.B().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a((Runnable) new C0588vd(this, i3, e2, intent));
        }
        return 2;
    }

    public final void b(Intent intent) {
        if (intent == null) {
            c().t().a("onRebind called with null intent");
            return;
        }
        c().B().a("onRebind called. action", intent.getAction());
    }

    private final void a(Runnable runnable) {
        Kd a2 = Kd.a((Context) this.f6151a);
        a2.d().a((Runnable) new C0598xd(this, a2, runnable));
    }

    public final IBinder a(Intent intent) {
        if (intent == null) {
            c().t().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new Pb(Kd.a((Context) this.f6151a));
        }
        c().w().a("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    public final boolean a(JobParameters jobParameters) {
        Ob a2 = Ob.a((Context) this.f6151a, (Af) null);
        C0532kb e2 = a2.e();
        String string = jobParameters.getExtras().getString("action");
        a2.b();
        e2.B().a("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            a((Runnable) new C0603yd(this, e2, jobParameters));
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(C0532kb kbVar, JobParameters jobParameters) {
        kbVar.B().a("AppMeasurementJobService processed last upload request.");
        ((Ad) this.f6151a).a(jobParameters, false);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(int i2, C0532kb kbVar, Intent intent) {
        if (((Ad) this.f6151a).a(i2)) {
            kbVar.B().a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            c().B().a("Completed wakeful intent.");
            ((Ad) this.f6151a).a(intent);
        }
    }
}
