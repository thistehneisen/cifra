package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.ub reason: case insensitive filesystem */
final class C0581ub implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f6115a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0566rb f6116b;

    C0581ub(C0566rb rbVar, boolean z) {
        this.f6116b = rbVar;
        this.f6115a = z;
    }

    public final void run() {
        this.f6116b.f6075a.a(this.f6115a);
    }
}
