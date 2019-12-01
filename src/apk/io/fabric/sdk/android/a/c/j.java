package io.fabric.sdk.android.a.c;

import android.content.Context;
import io.fabric.sdk.android.a.b.l;

/* compiled from: TimeBasedFileRollOverRunnable */
public class j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final Context f8888a;

    /* renamed from: b reason: collision with root package name */
    private final f f8889b;

    public j(Context context, f fVar) {
        this.f8888a = context;
        this.f8889b = fVar;
    }

    public void run() {
        try {
            l.c(this.f8888a, "Performing time based file roll over.");
            if (!this.f8889b.rollFileOver()) {
                this.f8889b.cancelTimeBasedFileRollOver();
            }
        } catch (Exception e2) {
            l.a(this.f8888a, "Failed to roll over file", (Throwable) e2);
        }
    }
}
