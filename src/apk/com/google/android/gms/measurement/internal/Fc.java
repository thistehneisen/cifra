package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Fc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5560a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5561b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5562c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f5563d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ boolean f5564e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ C0582uc f5565f;

    Fc(C0582uc ucVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f5565f = ucVar;
        this.f5560a = atomicReference;
        this.f5561b = str;
        this.f5562c = str2;
        this.f5563d = str3;
        this.f5564e = z;
    }

    public final void run() {
        this.f5565f.f5987a.A().a(this.f5560a, this.f5561b, this.f5562c, this.f5563d, this.f5564e);
    }
}
