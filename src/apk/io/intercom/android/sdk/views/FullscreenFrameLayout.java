package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public final class FullscreenFrameLayout extends FrameLayout {
    public FullscreenFrameLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final boolean fitSystemWindows(Rect rect) {
        if (VERSION.SDK_INT >= 19) {
            rect.top = 0;
        }
        return super.fitSystemWindows(rect);
    }

    public FullscreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullscreenFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
