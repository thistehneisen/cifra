package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import io.intercom.android.sdk.R;

public class LockableScrollView extends ScrollView {
    private boolean interceptTouch = false;
    private boolean isExpanded = true;
    private int maxHeight = 0;
    private boolean scrollable = true;

    public LockableScrollView(Context context) {
        super(context);
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.interceptTouch;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.isExpanded) {
            int mode = MeasureSpec.getMode(i3);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i3 = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i3), this.maxHeight), mode);
            } else {
                i3 = MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.scrollable && super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i2, int i3) {
        if (this.scrollable) {
            super.scrollTo(i2, i3);
        }
    }

    public void setExpanded(boolean z) {
        if (z != this.isExpanded) {
            this.isExpanded = z;
            requestLayout();
            invalidate();
        }
    }

    public void setScrollingEnabled(boolean z) {
        this.scrollable = z;
    }

    public void setUp(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LockableScrollView);
        this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LockableScrollView_intercomHeightLimit, 0);
        this.isExpanded = obtainStyledAttributes.getBoolean(R.styleable.LockableScrollView_intercomExpanded, true);
        this.interceptTouch = obtainStyledAttributes.getBoolean(R.styleable.LockableScrollView_intercomInterceptTouch, true);
        obtainStyledAttributes.recycle();
    }

    public void toggleExpanded() {
        setExpanded(!this.isExpanded);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setUp(attributeSet);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setUp(attributeSet);
    }
}
