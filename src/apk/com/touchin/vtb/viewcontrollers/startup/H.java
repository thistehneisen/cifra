package com.touchin.vtb.viewcontrollers.startup;

/* compiled from: GetAccessViewController.kt */
final class H implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ I f7694a;

    H(I i2) {
        this.f7694a = i2;
    }

    public final void run() {
        this.f7694a.this$0.scrollView.scrollTo(0, this.f7694a.this$0.passwordFocusawareEditText.getBottom());
    }
}
