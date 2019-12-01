package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.Ad;
import com.google.android.gms.measurement.internal.C0593wd;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements Ad {

    /* renamed from: a reason: collision with root package name */
    private C0593wd<AppMeasurementJobService> f5491a;

    private final C0593wd<AppMeasurementJobService> a() {
        if (this.f5491a == null) {
            this.f5491a = new C0593wd<>(this);
        }
        return this.f5491a;
    }

    public final void a(Intent intent) {
    }

    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        a().b(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return a().a(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return a().c(intent);
    }

    public final boolean a(int i2) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
