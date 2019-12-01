package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.da reason: case insensitive filesystem */
final class C0496da implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f5868a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ long f5869b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ C0480a f5870c;

    C0496da(C0480a aVar, String str, long j2) {
        this.f5870c = aVar;
        this.f5868a = str;
        this.f5869b = j2;
    }

    public final void run() {
        this.f5870c.c(this.f5868a, this.f5869b);
    }
}
