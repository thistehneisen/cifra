package com.bumptech.glide.load.engine;

import android.os.Process;

/* renamed from: com.bumptech.glide.load.engine.a reason: case insensitive filesystem */
/* compiled from: ActiveResources */
class C0287a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Runnable f3898a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0288b f3899b;

    C0287a(C0288b bVar, Runnable runnable) {
        this.f3899b = bVar;
        this.f3898a = runnable;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.f3898a.run();
    }
}
