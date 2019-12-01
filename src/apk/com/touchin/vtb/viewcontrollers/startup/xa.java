package com.touchin.vtb.viewcontrollers.startup;

/* compiled from: WelcomeViewController.kt */
final class xa implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ya f7734a;

    xa(ya yaVar) {
        this.f7734a = yaVar;
    }

    public final void run() {
        if (this.f7734a.f7735a.scrollYPositionWithOpenedKeyboard == 0) {
            WelcomeViewController welcomeViewController = this.f7734a.f7735a;
            welcomeViewController.scrollYPositionWithOpenedKeyboard = welcomeViewController.scrollView.getScrollY();
        }
    }
}
