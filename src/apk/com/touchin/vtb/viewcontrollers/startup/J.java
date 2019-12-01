package com.touchin.vtb.viewcontrollers.startup;

/* compiled from: GetAccessViewController.kt */
final class J implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ K f7695a;

    J(K k2) {
        this.f7695a = k2;
    }

    public final void run() {
        this.f7695a.this$0.scrollView.scrollTo(0, this.f7695a.this$0.passwordFocusawareEditText.getBottom());
    }
}
