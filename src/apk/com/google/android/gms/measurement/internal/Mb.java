package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class Mb<V> extends FutureTask<V> implements Comparable<Mb> {

    /* renamed from: a reason: collision with root package name */
    private final long f5649a = Ib.f5589c.getAndIncrement();

    /* renamed from: b reason: collision with root package name */
    final boolean f5650b;

    /* renamed from: c reason: collision with root package name */
    private final String f5651c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Ib f5652d;

    Mb(Ib ib, Callable<V> callable, boolean z, String str) {
        this.f5652d = ib;
        super(callable);
        q.a(str);
        this.f5651c = str;
        this.f5650b = z;
        if (this.f5649a == Long.MAX_VALUE) {
            ib.e().t().a("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        Mb mb = (Mb) obj;
        boolean z = this.f5650b;
        if (z != mb.f5650b) {
            return z ? -1 : 1;
        }
        long j2 = this.f5649a;
        long j3 = mb.f5649a;
        if (j2 < j3) {
            return -1;
        }
        if (j2 > j3) {
            return 1;
        }
        this.f5652d.e().u().a("Two tasks share the same index. index", Long.valueOf(this.f5649a));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f5652d.e().t().a(this.f5651c, th);
        super.setException(th);
    }

    Mb(Ib ib, Runnable runnable, boolean z, String str) {
        this.f5652d = ib;
        super(runnable, null);
        q.a(str);
        this.f5651c = str;
        this.f5650b = false;
        if (this.f5649a == Long.MAX_VALUE) {
            ib.e().t().a("Tasks index overflow");
        }
    }
}
