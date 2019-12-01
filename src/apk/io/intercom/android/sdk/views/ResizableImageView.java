package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.utilities.ImageUtils;

public class ResizableImageView extends AppCompatImageView {
    private int imageHeight;
    private int imageWidth;
    private int totalViewPadding;

    public ResizableImageView(Context context) {
        this(context, null);
    }

    private int calculateContainerWidth() {
        Point screenDimensions = ScreenUtils.getScreenDimensions(getContext());
        if (!getResources().getBoolean(R.bool.intercom_is_two_pane)) {
            return screenDimensions.x;
        }
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.intercom_two_pane_conversation_percentage, typedValue, true);
        return (int) (((float) screenDimensions.x) * typedValue.getFloat());
    }

    public Point getImageDimens() {
        double aspectRatio = ImageUtils.getAspectRatio(this.imageWidth, this.imageHeight);
        int min = Math.min(this.imageWidth, calculateContainerWidth() - this.totalViewPadding);
        return new Point(min, ImageUtils.getAspectHeight(min, aspectRatio));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Point imageDimens = getImageDimens();
        if (this.imageWidth <= 0 || this.imageHeight <= 0) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(imageDimens.x, imageDimens.y);
        }
    }

    public void setDisplayImageDimensions(int i2, int i3) {
        this.imageHeight = i3;
        this.imageWidth = i2;
    }

    public void setTotalViewPadding(int i2) {
        this.totalViewPadding = i2;
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
