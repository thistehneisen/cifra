package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import b.k.a.a;
import com.google.android.gms.measurement.internal.Ad;
import com.google.android.gms.measurement.internal.C0593wd;

public final class AppMeasurementService extends Service implements Ad {

    /* renamed from: a reason: collision with root package name */
    private C0593wd<AppMeasurementService> f5493a;

    private final C0593wd<AppMeasurementService> a() {
        if (this.f5493a == null) {
            this.f5493a = new C0593wd<>(this);
        }
        return this.f5493a;
    }

    public final IBinder onBind(Intent intent) {
        return a().a(intent);
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

    public final int onStartCommand(Intent intent, int i2, int i3) {
        return a().a(intent, i2, i3);
    }

    public final boolean onUnbind(Intent intent) {
        return a().c(intent);
    }

    public final boolean a(int i2) {
        return stopSelfResult(i2);
    }

    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void a(Intent intent) {
        a.a(intent);
    }
}
