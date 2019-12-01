package io.fabric.sdk.android.a.b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
class s implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String f8850a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ AtomicLong f8851b;

    s(String str, AtomicLong atomicLong) {
        this.f8850a = str;
        this.f8851b = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new r(this, runnable));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8850a);
        sb.append(this.f8851b.getAndIncrement());
        newThread.setName(sb.toString());
        return newThread;
    }
}
