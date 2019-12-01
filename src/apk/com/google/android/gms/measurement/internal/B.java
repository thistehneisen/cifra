package com.google.android.gms.measurement.internal;

final class B implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f5510a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ long f5511b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ C0480a f5512c;

    B(C0480a aVar, String str, long j2) {
        this.f5512c = aVar;
        this.f5510a = str;
        this.f5511b = j2;
    }

    public final void run() {
        this.f5512c.d(this.f5510a, this.f5511b);
    }
}
