package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SearchCompanyViewController.kt */
final class ga implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchCompanyViewController f7718a;

    ga(SearchCompanyViewController searchCompanyViewController) {
        this.f7718a = searchCompanyViewController;
    }

    public final void onClick(View view) {
        this.f7718a.navigateToSearchViewController();
    }
}
