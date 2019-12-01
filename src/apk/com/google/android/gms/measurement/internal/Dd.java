package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.sf;

final class Dd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ sf f5536a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0525j f5537b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5538c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5539d;

    Dd(AppMeasurementDynamiteService appMeasurementDynamiteService, sf sfVar, C0525j jVar, String str) {
        this.f5539d = appMeasurementDynamiteService;
        this.f5536a = sfVar;
        this.f5537b = jVar;
        this.f5538c = str;
    }

    public final void run() {
        this.f5539d.f5504a.A().a(this.f5536a, this.f5537b, this.f5538c);
    }
}
