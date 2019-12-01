package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: com.google.android.gms.measurement.internal.ud reason: case insensitive filesystem */
final class C0583ud implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0564qd f6123a;

    C0583ud(C0564qd qdVar) {
        this.f6123a = qdVar;
    }

    public final void run() {
        Zc zc = this.f6123a.f6072c;
        Context a2 = zc.a();
        this.f6123a.f6072c.b();
        zc.a(new ComponentName(a2, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
