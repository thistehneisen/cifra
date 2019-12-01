package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.sf;

final class Dc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ sf f5534a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5535b;

    Dc(AppMeasurementDynamiteService appMeasurementDynamiteService, sf sfVar) {
        this.f5535b = appMeasurementDynamiteService;
        this.f5534a = sfVar;
    }

    public final void run() {
        this.f5535b.f5504a.A().a(this.f5534a);
    }
}
