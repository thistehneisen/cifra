package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Dc;

/* renamed from: com.google.android.gms.measurement.internal.b reason: case insensitive filesystem */
abstract class C0485b {

    /* renamed from: a reason: collision with root package name */
    private static volatile Handler f5831a;

    /* renamed from: b reason: collision with root package name */
    private final C0543mc f5832b;

    /* renamed from: c reason: collision with root package name */
    private final Runnable f5833c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public volatile long f5834d;

    C0485b(C0543mc mcVar) {
        q.a(mcVar);
        this.f5832b = mcVar;
        this.f5833c = new C0500e(this, mcVar);
    }

    private final Handler d() {
        Handler handler;
        if (f5831a != null) {
            return f5831a;
        }
        synchronized (C0485b.class) {
            if (f5831a == null) {
                f5831a = new Dc(this.f5832b.a().getMainLooper());
            }
            handler = f5831a;
        }
        return handler;
    }

    public final void a(long j2) {
        a();
        if (j2 >= 0) {
            this.f5834d = this.f5832b.c().currentTimeMillis();
            if (!d().postDelayed(this.f5833c, j2)) {
                this.f5832b.e().t().a("Failed to schedule delayed post. time", Long.valueOf(j2));
            }
        }
    }

    public abstract void b();

    public final boolean c() {
        return this.f5834d != 0;
    }

    /* access modifiers changed from: 0000 */
    public final void a() {
        this.f5834d = 0;
        d().removeCallbacks(this.f5833c);
    }
}
