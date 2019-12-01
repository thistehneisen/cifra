package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class Ac implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Bundle f5502a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5503b;

    Ac(C0582uc ucVar, Bundle bundle) {
        this.f5503b = ucVar;
        this.f5502a = bundle;
    }

    public final void run() {
        this.f5503b.c(this.f5502a);
    }
}
