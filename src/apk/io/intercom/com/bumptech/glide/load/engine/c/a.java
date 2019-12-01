package io.intercom.com.bumptech.glide.load.engine.c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

/* compiled from: GlideExecutor */
class a extends Thread {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f9848a;

    a(a aVar, Runnable runnable, String str) {
        this.f9848a = aVar;
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(9);
        if (this.f9848a.f9857c) {
            StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.f9848a.f9856b.a(th);
        }
    }
}
