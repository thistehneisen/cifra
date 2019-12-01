package com.google.android.gms.common.util.a;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    private final String f4793a;

    /* renamed from: b reason: collision with root package name */
    private final int f4794b;

    /* renamed from: c reason: collision with root package name */
    private final ThreadFactory f4795c;

    public a(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4795c.newThread(new b(runnable, 0));
        newThread.setName(this.f4793a);
        return newThread;
    }

    private a(String str, int i2) {
        this.f4795c = Executors.defaultThreadFactory();
        q.a(str, (Object) "Name must not be null");
        this.f4793a = str;
        this.f4794b = 0;
    }
}
