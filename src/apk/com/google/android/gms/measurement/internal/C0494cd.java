package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.sf;

/* renamed from: com.google.android.gms.measurement.internal.cd reason: case insensitive filesystem */
final class C0494cd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ sf f5857a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5858b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5859c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ boolean f5860d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f5861e;

    C0494cd(AppMeasurementDynamiteService appMeasurementDynamiteService, sf sfVar, String str, String str2, boolean z) {
        this.f5861e = appMeasurementDynamiteService;
        this.f5857a = sfVar;
        this.f5858b = str;
        this.f5859c = str2;
        this.f5860d = z;
    }

    public final void run() {
        this.f5861e.f5504a.A().a(this.f5857a, this.f5858b, this.f5859c, this.f5860d);
    }
}
