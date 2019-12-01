package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.sf;

final class Zd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ sf f5797a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5798b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5799c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5800d;

    Zd(AppMeasurementDynamiteService appMeasurementDynamiteService, sf sfVar, String str, String str2) {
        this.f5800d = appMeasurementDynamiteService;
        this.f5797a = sfVar;
        this.f5798b = str;
        this.f5799c = str2;
    }

    public final void run() {
        this.f5800d.f5504a.A().a(this.f5797a, this.f5798b, this.f5799c);
    }
}
