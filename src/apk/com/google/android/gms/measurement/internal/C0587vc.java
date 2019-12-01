package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.vc reason: case insensitive filesystem */
final class C0587vc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f6131a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6132b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Object f6133c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ long f6134d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0582uc f6135e;

    C0587vc(C0582uc ucVar, String str, String str2, Object obj, long j2) {
        this.f6135e = ucVar;
        this.f6131a = str;
        this.f6132b = str2;
        this.f6133c = obj;
        this.f6134d = j2;
    }

    public final void run() {
        this.f6135e.a(this.f6131a, this.f6132b, this.f6133c, this.f6134d);
    }
}
