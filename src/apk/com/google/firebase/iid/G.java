package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class G {

    /* renamed from: a reason: collision with root package name */
    final Intent f6761a;

    /* renamed from: b reason: collision with root package name */
    private final PendingResult f6762b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6763c = false;

    /* renamed from: d reason: collision with root package name */
    private final ScheduledFuture<?> f6764d;

    G(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f6761a = intent;
        this.f6762b = pendingResult;
        this.f6764d = scheduledExecutorService.schedule(new F(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a() {
        if (!this.f6763c) {
            this.f6762b.finish();
            this.f6764d.cancel(false);
            this.f6763c = true;
        }
    }
}
