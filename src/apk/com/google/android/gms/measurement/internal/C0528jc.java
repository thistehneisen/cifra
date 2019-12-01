package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.jc reason: case insensitive filesystem */
abstract class C0528jc extends C0533kc {

    /* renamed from: b reason: collision with root package name */
    private boolean f5964b;

    C0528jc(Ob ob) {
        super(ob);
        this.f5987a.a(this);
    }

    public final void n() {
        if (this.f5964b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!r()) {
            this.f5987a.t();
            this.f5964b = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean o() {
        return this.f5964b;
    }

    /* access modifiers changed from: protected */
    public final void p() {
        if (!o()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void q() {
        if (!this.f5964b) {
            s();
            this.f5987a.t();
            this.f5964b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public void s() {
    }
}
