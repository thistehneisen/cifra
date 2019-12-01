package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class Od implements Callable<String> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5676a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Kd f5677b;

    Od(Kd kd, ae aeVar) {
        this.f5677b = kd;
        this.f5676a = aeVar;
    }

    public final /* synthetic */ Object call() throws Exception {
        Fb a2 = this.f5677b.e(this.f5676a);
        if (a2 != null) {
            return a2.a();
        }
        this.f5677b.e().w().a("App info was null when attempting to get app instance id");
        return null;
    }
}
