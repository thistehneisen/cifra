package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;

final class Hd {

    /* renamed from: a reason: collision with root package name */
    private final d f5585a;

    /* renamed from: b reason: collision with root package name */
    private long f5586b;

    public Hd(d dVar) {
        q.a(dVar);
        this.f5585a = dVar;
    }

    public final void a() {
        this.f5586b = 0;
    }

    public final void b() {
        this.f5586b = this.f5585a.a();
    }

    public final boolean a(long j2) {
        if (this.f5586b != 0 && this.f5585a.a() - this.f5586b < 3600000) {
            return false;
        }
        return true;
    }
}
