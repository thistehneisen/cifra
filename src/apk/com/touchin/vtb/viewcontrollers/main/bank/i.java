package com.touchin.vtb.viewcontrollers.main.bank;

import kotlin.e.a.a;
import kotlin.m;

/* compiled from: BankViewController.kt */
final class i extends kotlin.e.b.i implements a<m> {
    final /* synthetic */ Throwable $throwable;
    final /* synthetic */ BankViewController this$0;

    i(BankViewController bankViewController, Throwable th) {
        this.this$0 = bankViewController;
        this.$throwable = th;
        super(0);
    }

    public final void b() {
        if (this.this$0.isBankSessionExpiredError(this.$throwable)) {
            this.this$0.viewModel.f();
        } else {
            this.this$0.viewModel.d();
        }
    }
}
