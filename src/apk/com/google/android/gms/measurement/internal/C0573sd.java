package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.sd reason: case insensitive filesystem */
final class C0573sd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ComponentName f6096a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0564qd f6097b;

    C0573sd(C0564qd qdVar, ComponentName componentName) {
        this.f6097b = qdVar;
        this.f6096a = componentName;
    }

    public final void run() {
        this.f6097b.f6072c.a(this.f6096a);
    }
}
