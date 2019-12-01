package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.x reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0704x implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessConfirmSmsViewController f7733a;

    C0704x(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.f7733a = getAccessConfirmSmsViewController;
    }

    public final void onClick(View view) {
        this.f7733a.getView().postDelayed(new C0703w(this), 100);
    }
}
