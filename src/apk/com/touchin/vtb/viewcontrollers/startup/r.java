package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.touchin.vtb.R;
import kotlin.e.b.h;

/* compiled from: GetAccessConfirmSmsViewController.kt */
final class r implements OnApplyWindowInsetsListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessConfirmSmsViewController f7726a;

    r(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.f7726a = getAccessConfirmSmsViewController;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        View view2 = this.f7726a.getView();
        h.a((Object) windowInsets, "insets");
        view2.setPadding(view2.getPaddingLeft(), windowInsets.getSystemWindowInsetTop(), view2.getPaddingRight(), view2.getPaddingBottom());
        View findViewById = this.f7726a.findViewById(R.id.view_controller_get_access_confirm_sms_content);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }
}
