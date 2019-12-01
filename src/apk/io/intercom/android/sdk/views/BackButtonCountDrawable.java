package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;

class BackButtonCountDrawable extends Drawable {
    private static final String COUNT_BACKGROUND_COLOR = "#FE536C";
    private static final int COUNT_BACKGROUND_RADIUS_DP = 8;
    private static final int COUNT_TEXT_PADDING_TOP = 4;
    private static final int COUNT_TEXT_SIZE_DP = 11;
    private static final int ICON_PADDING_DP = 16;
    private static final int ICON_SIZE_DP = 24;
    private final Drawable backIcon;
    private final Paint countBackgroundPaint = new Paint();
    private final int countBackgroundRadius;
    private final int iconPadding;
    private final int iconSize;
    private String text;
    private final Paint textPaint;
    private final int textTopPadding;

    BackButtonCountDrawable(Context context, String str) {
        this.text = str;
        this.backIcon = a.c(context, R.drawable.intercom_back);
        this.iconPadding = ScreenUtils.dpToPx(16.0f, context);
        this.iconSize = ScreenUtils.dpToPx(24.0f, context);
        this.countBackgroundPaint.setAntiAlias(true);
        this.countBackgroundPaint.setColor(Color.parseColor(COUNT_BACKGROUND_COLOR));
        this.countBackgroundPaint.setStyle(Style.FILL);
        this.countBackgroundRadius = ScreenUtils.dpToPx(8.0f, context);
        this.textPaint = new Paint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textPaint.setTextSize((float) ScreenUtils.dpToPx(11.0f, context));
        this.textPaint.setFakeBoldText(true);
        this.textPaint.setStyle(Style.FILL);
        this.textPaint.setTextAlign(Align.CENTER);
        this.textTopPadding = ScreenUtils.dpToPx(4.0f, context);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = bounds.left;
        int i3 = this.iconPadding;
        int i4 = i2 + i3;
        int i5 = bounds.top + i3;
        int i6 = this.iconSize;
        int i7 = i4 + i6;
        this.backIcon.setBounds(i4, i5, i7, i6 + i5);
        this.backIcon.draw(canvas);
        if (!TextUtils.isEmpty(this.text)) {
            float f2 = (float) i7;
            canvas.drawCircle(f2, (float) i5, (float) this.countBackgroundRadius, this.countBackgroundPaint);
            canvas.drawText(this.text, f2, (float) (i5 + this.textTopPadding), this.textPaint);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        this.textPaint.setAlpha(i2);
        this.countBackgroundPaint.setAlpha(i2);
        this.backIcon.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.backIcon.setColorFilter(colorFilter);
    }

    public void setText(String str) {
        this.text = str;
        invalidateSelf();
    }
}
