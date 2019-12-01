package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.ec reason: case insensitive filesystem */
abstract class C0503ec extends Ea {

    /* renamed from: b reason: collision with root package name */
    private boolean f5893b;

    C0503ec(Ob ob) {
        super(ob);
        this.f5987a.a(this);
    }

    /* access modifiers changed from: protected */
    public void A() {
    }

    public final void v() {
        if (this.f5893b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!z()) {
            this.f5987a.t();
            this.f5893b = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean w() {
        return this.f5893b;
    }

    /* access modifiers changed from: protected */
    public final void x() {
        if (!w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void y() {
        if (!this.f5893b) {
            A();
            this.f5987a.t();
            this.f5893b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean z();
}
