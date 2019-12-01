package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
class a implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    private final AtomicInteger f9039a = new AtomicInteger(1);

    a() {
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTask #");
        sb.append(this.f9039a.getAndIncrement());
        return new Thread(runnable, sb.toString());
    }
}
