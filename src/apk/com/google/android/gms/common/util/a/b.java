package com.google.android.gms.common.util.a;

import android.os.Process;

final class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final Runnable f4796a;

    /* renamed from: b reason: collision with root package name */
    private final int f4797b;

    public b(Runnable runnable, int i2) {
        this.f4796a = runnable;
        this.f4797b = i2;
    }

    public final void run() {
        Process.setThreadPriority(this.f4797b);
        this.f4796a.run();
    }
}
