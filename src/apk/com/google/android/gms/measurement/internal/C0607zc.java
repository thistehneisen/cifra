package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.zc reason: case insensitive filesystem */
final class C0607zc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Bundle f6178a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f6179b;

    C0607zc(C0582uc ucVar, Bundle bundle) {
        this.f6179b = ucVar;
        this.f6178a = bundle;
    }

    public final void run() {
        this.f6179b.d(this.f6178a);
    }
}
