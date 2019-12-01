package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class i {

    /* renamed from: a reason: collision with root package name */
    public static final Executor f6196a = new a();

    /* renamed from: b reason: collision with root package name */
    static final Executor f6197b = new A();

    private static final class a implements Executor {

        /* renamed from: a reason: collision with root package name */
        private final Handler f6198a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f6198a.post(runnable);
        }
    }
}
