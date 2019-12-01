package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;

public class BlockUtils {
    private static final int DEFAULT_MARGIN_BOTTOM_DP = 10;
    private static final int LARGE_LINE_SPACING_DP = 4;
    private static final int SMALL_LINE_SPACING_DP = 2;

    public static void createLayoutParams(View view, int i2, int i3) {
        view.setLayoutParams(new LayoutParams(i2, i3));
    }

    public static View getBlockView(ViewGroup viewGroup, LinearLayout linearLayout, Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.intercom_container_layout, viewGroup, false);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.cellLayout);
        if (linearLayout.getParent() != null) {
            ((LinearLayout) linearLayout.getParent()).removeView(linearLayout);
        }
        if (linearLayout2.getChildCount() > 0) {
            linearLayout2.removeAllViews();
        }
        linearLayout2.addView(linearLayout, 0);
        inflate.setFocusable(false);
        linearLayout2.setVisibility(0);
        return inflate;
    }

    public static void setDefaultMarginBottom(View view) {
        setMarginBottom(view, 10);
    }

    public static void setLargeLineSpacing(TextView textView) {
        setLineSpacing(textView, 4);
    }

    public static void setLayoutMarginsAndGravity(View view, int i2, boolean z) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, 0);
        }
        layoutParams.gravity = i2;
    }

    private static void setLineSpacing(TextView textView, int i2) {
        textView.setLineSpacing((float) ScreenUtils.dpToPx((float) i2, textView.getContext()), 1.0f);
    }

    public static void setMarginBottom(View view, int i2) {
        ((MarginLayoutParams) view.getLayoutParams()).bottomMargin = ScreenUtils.dpToPx((float) i2, view.getContext());
    }

    public static void setMarginLeft(View view, int i2) {
        ((MarginLayoutParams) view.getLayoutParams()).leftMargin = ScreenUtils.dpToPx((float) i2, view.getContext());
    }

    public static void setSmallLineSpacing(TextView textView) {
        setLineSpacing(textView, 2);
    }
}
