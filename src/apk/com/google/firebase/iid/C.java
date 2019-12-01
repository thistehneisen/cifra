package com.google.firebase.iid;

import android.content.Intent;

final class C implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Intent f6738a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Intent f6739b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ E f6740c;

    C(E e2, Intent intent, Intent intent2) {
        this.f6740c = e2;
        this.f6738a = intent;
        this.f6739b = intent2;
    }

    public final void run() {
        this.f6740c.zzd(this.f6738a);
        this.f6740c.zza(this.f6739b);
    }
}
