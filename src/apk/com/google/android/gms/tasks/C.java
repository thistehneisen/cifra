package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class C implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ B f6193a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Callable f6194b;

    C(B b2, Callable callable) {
        this.f6193a = b2;
        this.f6194b = callable;
    }

    public final void run() {
        try {
            this.f6193a.a(this.f6194b.call());
        } catch (Exception e2) {
            this.f6193a.a(e2);
        }
    }
}
