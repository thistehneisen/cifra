package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.v reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0702v implements OnFocusChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessConfirmSmsViewController f7730a;

    C0702v(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.f7730a = getAccessConfirmSmsViewController;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7730a.getView().postDelayed(new C0701u(this), 100);
        }
    }
}
