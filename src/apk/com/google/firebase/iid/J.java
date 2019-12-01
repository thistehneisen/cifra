package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class J {

    /* renamed from: a reason: collision with root package name */
    private static final Executor f6768a = L.f6775a;

    static Executor a() {
        return f6768a;
    }

    static Executor b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), M.f6776a);
        return threadPoolExecutor;
    }

    static final /* synthetic */ Thread a(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }
}
