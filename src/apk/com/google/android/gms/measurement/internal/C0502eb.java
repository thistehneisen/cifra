package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.eb reason: case insensitive filesystem */
final class C0502eb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f5891a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0480a f5892b;

    C0502eb(C0480a aVar, long j2) {
        this.f5892b = aVar;
        this.f5891a = j2;
    }

    public final void run() {
        this.f5892b.b(this.f5891a);
    }
}
