package com.touchin.vtb.viewcontrollers.main.bank;

/* compiled from: BankViewController.kt */
final class k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BankViewController f7650a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f7651b;

    k(BankViewController bankViewController, int i2) {
        this.f7650a = bankViewController;
        this.f7651b = i2;
    }

    public final void run() {
        this.f7650a.cardsRecycler.i(this.f7651b);
    }
}
