package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.touchin.vtb.R;
import kotlin.e.b.h;

/* compiled from: WelcomeViewController.kt */
final class ya implements OnApplyWindowInsetsListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ WelcomeViewController f7735a;

    ya(WelcomeViewController welcomeViewController) {
        this.f7735a = welcomeViewController;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        h.a((Object) windowInsets, "insets");
        if (windowInsets.getSystemWindowInsetBottom() != 0) {
            this.f7735a.scrollView.smoothScrollTo(0, this.f7735a.phoneMaskedEditText.getBottom());
            this.f7735a.scrollView.post(new xa(this));
        } else {
            this.f7735a.phoneMaskedEditText.clearFocus();
        }
        View findViewById = this.f7735a.findViewById(R.id.welcome_view_controller_content_container);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }
}
