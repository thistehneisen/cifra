package io.fabric.sdk.android.a.b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
public abstract class j implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void onRun();

    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
