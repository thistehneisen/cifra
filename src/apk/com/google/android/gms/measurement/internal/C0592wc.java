package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.wc reason: case insensitive filesystem */
final class C0592wc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f6142a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6143b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ long f6144c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Bundle f6145d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ boolean f6146e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ boolean f6147f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ boolean f6148g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ String f6149h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ C0582uc f6150i;

    C0592wc(C0582uc ucVar, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f6150i = ucVar;
        this.f6142a = str;
        this.f6143b = str2;
        this.f6144c = j2;
        this.f6145d = bundle;
        this.f6146e = z;
        this.f6147f = z2;
        this.f6148g = z3;
        this.f6149h = str3;
    }

    public final void run() {
        this.f6150i.a(this.f6142a, this.f6143b, this.f6144c, this.f6145d, this.f6146e, this.f6147f, this.f6148g, this.f6149h);
    }
}
