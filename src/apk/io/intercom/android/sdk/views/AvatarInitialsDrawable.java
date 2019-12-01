package io.intercom.android.sdk.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class AvatarInitialsDrawable extends Drawable {
    private final Paint avatarBackground;
    private final String text;
    private final Rect textBounds = new Rect();
    private final Paint textPaint;

    public AvatarInitialsDrawable(String str, int i2) {
        this.text = str;
        this.avatarBackground = new Paint();
        this.avatarBackground.setAntiAlias(true);
        this.avatarBackground.setColor(i2);
        this.avatarBackground.setStyle(Style.FILL);
        this.textPaint = new Paint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textPaint.setFakeBoldText(true);
        this.textPaint.setTextAlign(Align.LEFT);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.textPaint.setTextSize((float) (bounds.height() / 3));
        Paint paint = this.textPaint;
        String str = this.text;
        paint.getTextBounds(str, 0, str.length(), this.textBounds);
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) (bounds.height() / 2), this.avatarBackground);
        canvas.drawText(this.text, ((float) bounds.centerX()) - this.textBounds.exactCenterX(), ((float) bounds.centerY()) - this.textBounds.exactCenterY(), this.textPaint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        this.textPaint.setAlpha(i2);
        this.avatarBackground.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
