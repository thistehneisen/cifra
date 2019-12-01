package com.bumptech.glide.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: Executors */
class e implements Executor {

    /* renamed from: a reason: collision with root package name */
    private final Handler f3520a = new Handler(Looper.getMainLooper());

    e() {
    }

    public void execute(Runnable runnable) {
        this.f3520a.post(runnable);
    }
}
