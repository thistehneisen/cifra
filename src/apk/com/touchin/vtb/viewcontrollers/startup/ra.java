package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.StartupActivity;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: UpdateViewController.kt */
final class ra extends i implements a<m> {
    final /* synthetic */ UpdateViewController this$0;

    ra(UpdateViewController updateViewController) {
        this.this$0 = updateViewController;
        super(0);
    }

    public final void b() {
        ((StartupActivity) this.this$0.getActivity()).onBackPressed();
    }
}
