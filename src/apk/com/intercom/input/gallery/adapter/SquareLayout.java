package com.intercom.input.gallery.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.intercom.input.gallery.R;

public class SquareLayout extends FrameLayout {
    private static final int WIDTH_TYPE = 0;
    private int measureType;

    public SquareLayout(Context context) {
        super(context);
    }

    private void checkAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.intercom_composer_square_layout, 0, 0);
        try {
            this.measureType = obtainStyledAttributes.getInteger(R.styleable.intercom_composer_square_layout_intercom_composer_measure_type, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.measureType == 0) {
            super.onMeasure(i2, i2);
        } else {
            super.onMeasure(i3, i3);
        }
    }

    public SquareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        checkAttributes(context, attributeSet);
    }

    public SquareLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        checkAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public SquareLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        checkAttributes(context, attributeSet);
    }
}
