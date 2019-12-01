package io.intercom.android.sdk.profile;

import android.content.Context;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout.c;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.WindowUtils;

abstract class ProfileToolbarBehavior implements c {
    float toolbarHeight;

    public ProfileToolbarBehavior(Context context) {
        this.toolbarHeight = context.getResources().getDimension(R.dimen.intercom_toolbar_height);
        this.toolbarHeight += (float) WindowUtils.getStatusBarHeight(context.getResources());
    }

    /* access modifiers changed from: protected */
    public float getScrollPercentage(View view) {
        return ((((float) view.getBottom()) - this.toolbarHeight) / (((float) view.getHeight()) - this.toolbarHeight)) * 100.0f;
    }

    /* access modifiers changed from: protected */
    public void setAlphaAsPercentageOfScroll(View view, View view2, float f2, boolean z) {
        float scrollPercentage = getScrollPercentage(view2);
        if (z) {
            scrollPercentage = 100.0f - scrollPercentage;
        }
        view.setAlpha((f2 / 100.0f) * scrollPercentage);
    }
}
