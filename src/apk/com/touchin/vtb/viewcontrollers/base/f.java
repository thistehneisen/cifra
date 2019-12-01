package com.touchin.vtb.viewcontrollers.base;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VTBBottomMenuViewController.kt */
final class f implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ VTBBottomMenuViewController f7644a;

    f(VTBBottomMenuViewController vTBBottomMenuViewController) {
        this.f7644a = vTBBottomMenuViewController;
    }

    public final void onClick(View view) {
        this.f7644a.showBottomMenu();
        this.f7644a.bottomMenu.setNeedToInterceptTouch(false);
    }
}
