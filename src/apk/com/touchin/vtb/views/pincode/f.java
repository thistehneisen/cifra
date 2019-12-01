package com.touchin.vtb.views.pincode;

/* compiled from: View.kt */
public final class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ PincodeView f7843a;

    public f(PincodeView pincodeView) {
        this.f7843a = pincodeView;
    }

    public final void run() {
        this.f7843a.getOnPincodeEnteredListener().a(this.f7843a.A);
    }
}
