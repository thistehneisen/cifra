package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Cc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5524a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5525b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5526c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f5527d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0582uc f5528e;

    Cc(C0582uc ucVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5528e = ucVar;
        this.f5524a = atomicReference;
        this.f5525b = str;
        this.f5526c = str2;
        this.f5527d = str3;
    }

    public final void run() {
        this.f5528e.f5987a.A().a(this.f5524a, this.f5525b, this.f5526c, this.f5527d);
    }
}
