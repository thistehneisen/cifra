package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.C0340cd;

public final class Gd extends Ld {

    /* renamed from: d reason: collision with root package name */
    private final AlarmManager f5572d = ((AlarmManager) a().getSystemService("alarm"));

    /* renamed from: e reason: collision with root package name */
    private final C0485b f5573e;

    /* renamed from: f reason: collision with root package name */
    private Integer f5574f;

    protected Gd(Kd kd) {
        super(kd);
        this.f5573e = new Jd(this, kd.r(), kd);
    }

    private final int w() {
        if (this.f5574f == null) {
            String str = "measurement";
            String valueOf = String.valueOf(a().getPackageName());
            this.f5574f = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.f5574f.intValue();
    }

    @TargetApi(24)
    private final void x() {
        JobScheduler jobScheduler = (JobScheduler) a().getSystemService("jobscheduler");
        int w = w();
        e().B().a("Cancelling job. JobID", Integer.valueOf(w));
        jobScheduler.cancel(w);
    }

    private final PendingIntent y() {
        Context a2 = a();
        return PendingIntent.getBroadcast(a2, 0, new Intent().setClassName(a2, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    public final void a(long j2) {
        t();
        b();
        Context a2 = a();
        if (!Eb.a(a2)) {
            e().A().a("Receiver not registered/enabled");
        }
        if (!Wd.a(a2, false)) {
            e().A().a("Service not registered/enabled");
        }
        v();
        long a3 = c().a() + j2;
        if (j2 < Math.max(0, ((Long) C0535l.I.a(null)).longValue()) && !this.f5573e.c()) {
            e().B().a("Scheduling upload with DelayedRunnable");
            this.f5573e.a(j2);
        }
        b();
        if (VERSION.SDK_INT >= 24) {
            e().B().a("Scheduling upload with JobScheduler");
            Context a4 = a();
            ComponentName componentName = new ComponentName(a4, "com.google.android.gms.measurement.AppMeasurementJobService");
            int w = w();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new Builder(w, componentName).setMinimumLatency(j2).setOverrideDeadline(j2 << 1).setExtras(persistableBundle).build();
            e().B().a("Scheduling job. JobID", Integer.valueOf(w));
            C0340cd.a(a4, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        e().B().a("Scheduling upload with AlarmManager");
        this.f5572d.setInexactRepeating(2, a3, Math.max(((Long) C0535l.D.a(null)).longValue(), j2), y());
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

    public final /* bridge */ /* synthetic */ Sd n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ ce o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ ke p() {
        return super.p();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        this.f5572d.cancel(y());
        if (VERSION.SDK_INT >= 24) {
            x();
        }
        return false;
    }

    public final void v() {
        t();
        this.f5572d.cancel(y());
        this.f5573e.a();
        if (VERSION.SDK_INT >= 24) {
            x();
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
