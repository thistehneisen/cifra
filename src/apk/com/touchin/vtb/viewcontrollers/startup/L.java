package com.touchin.vtb.viewcontrollers.startup;

/* compiled from: GetAccessViewController.kt */
final class L implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ M f7696a;

    L(M m) {
        this.f7696a = m;
    }

    public final void run() {
        this.f7696a.this$0.scrollView.scrollTo(0, this.f7696a.this$0.loginFocusawareEditText.getBottom() / 2);
    }
}
