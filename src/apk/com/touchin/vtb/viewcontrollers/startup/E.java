package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.touchin.vtb.R;
import kotlin.e.b.h;

/* compiled from: GetAccessViewController.kt */
final class E implements OnApplyWindowInsetsListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessViewController f7689a;

    E(GetAccessViewController getAccessViewController) {
        this.f7689a = getAccessViewController;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        View view2 = this.f7689a.getView();
        h.a((Object) windowInsets, "insets");
        view2.setPadding(view2.getPaddingLeft(), windowInsets.getSystemWindowInsetTop(), view2.getPaddingRight(), view2.getPaddingBottom());
        View findViewById = this.f7689a.findViewById(R.id.view_controller_get_access_content_view);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }
}
