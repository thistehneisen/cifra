package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* renamed from: com.google.android.gms.measurement.internal.vd reason: case insensitive filesystem */
final /* synthetic */ class C0588vd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final C0593wd f6136a;

    /* renamed from: b reason: collision with root package name */
    private final int f6137b;

    /* renamed from: c reason: collision with root package name */
    private final C0532kb f6138c;

    /* renamed from: d reason: collision with root package name */
    private final Intent f6139d;

    C0588vd(C0593wd wdVar, int i2, C0532kb kbVar, Intent intent) {
        this.f6136a = wdVar;
        this.f6137b = i2;
        this.f6138c = kbVar;
        this.f6139d = intent;
    }

    public final void run() {
        this.f6136a.a(this.f6137b, this.f6138c, this.f6139d);
    }
}
