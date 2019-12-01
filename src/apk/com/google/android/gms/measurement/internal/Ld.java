package com.google.android.gms.measurement.internal;

abstract class Ld extends Id {

    /* renamed from: c reason: collision with root package name */
    private boolean f5646c;

    Ld(Kd kd) {
        super(kd);
        this.f5601b.a(this);
    }

    public final void r() {
        if (!this.f5646c) {
            u();
            this.f5601b.q();
            this.f5646c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: 0000 */
    public final boolean s() {
        return this.f5646c;
    }

    /* access modifiers changed from: protected */
    public final void t() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean u();
}
