package com.bumptech.glide.load.engine.c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

/* compiled from: GlideExecutor */
class a extends Thread {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f3980a;

    a(a aVar, Runnable runnable, String str) {
        this.f3980a = aVar;
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(9);
        if (this.f3980a.f3986c) {
            StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.f3980a.f3985b.a(th);
        }
    }
}
