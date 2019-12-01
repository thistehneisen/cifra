package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.touchin.vtb.R;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.ca reason: case insensitive filesystem */
/* compiled from: SearchCompanyViewController.kt */
final class C0681ca implements OnApplyWindowInsetsListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchCompanyViewController f7710a;

    C0681ca(SearchCompanyViewController searchCompanyViewController) {
        this.f7710a = searchCompanyViewController;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        View view2 = this.f7710a.getView();
        h.a((Object) windowInsets, "insets");
        view2.setPadding(view2.getPaddingLeft(), windowInsets.getSystemWindowInsetTop(), view2.getPaddingRight(), view2.getPaddingBottom());
        View findViewById = this.f7710a.findViewById(R.id.view_controller_search_company_content_view);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }
}
