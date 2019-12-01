package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.sf;

final class Yd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ sf f5777a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5778b;

    Yd(AppMeasurementDynamiteService appMeasurementDynamiteService, sf sfVar) {
        this.f5778b = appMeasurementDynamiteService;
        this.f5777a = sfVar;
    }

    public final void run() {
        this.f5778b.f5504a.G().a(this.f5777a, this.f5778b.f5504a.r());
    }
}
