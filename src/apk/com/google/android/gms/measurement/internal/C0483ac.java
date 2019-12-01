package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.ac reason: case insensitive filesystem */
final class C0483ac implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0525j f5813a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5814b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5815c;

    C0483ac(Pb pb, C0525j jVar, String str) {
        this.f5815c = pb;
        this.f5813a = jVar;
        this.f5814b = str;
    }

    public final void run() {
        this.f5815c.f5680a.p();
        this.f5815c.f5680a.a(this.f5813a, this.f5814b);
    }
}
