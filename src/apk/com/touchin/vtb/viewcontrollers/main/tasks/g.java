package com.touchin.vtb.viewcontrollers.main.tasks;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskTaxViewController.kt */
final class g implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskTaxViewController f7667a;

    g(TaskTaxViewController taskTaxViewController) {
        this.f7667a = taskTaxViewController;
    }

    public final void onClick(View view) {
        this.f7667a.viewModel.c();
    }
}
