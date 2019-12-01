package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SearchCompanyViewController.kt */
final class ha implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchCompanyViewController f7720a;

    ha(SearchCompanyViewController searchCompanyViewController) {
        this.f7720a = searchCompanyViewController;
    }

    public final void onClick(View view) {
        this.f7720a.navigateToSearchViewController();
    }
}
