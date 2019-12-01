package io.intercom.android.sdk.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ActiveStateDrawable extends Drawable {
    private final Paint paint = new Paint();
    private final RectF roundRect = new RectF();
    private final int stateColor;
    private final int strokeColor;
    private final float strokeWidth;

    public ActiveStateDrawable(int i2, int i3, float f2) {
        this.stateColor = i2;
        this.strokeColor = i3;
        this.strokeWidth = f2;
        this.paint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        this.roundRect.set(getBounds());
        RectF rectF = this.roundRect;
        float f2 = this.strokeWidth;
        rectF.inset(f2, f2);
        this.paint.setColor(this.stateColor);
        this.paint.setStyle(Style.FILL);
        canvas.drawRoundRect(this.roundRect, (float) (canvas.getHeight() / 2), (float) (canvas.getHeight() / 2), this.paint);
        this.paint.setColor(this.strokeColor);
        this.paint.setStyle(Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        canvas.drawRoundRect(this.roundRect, (float) (canvas.getHeight() / 2), (float) (canvas.getHeight() / 2), this.paint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        this.paint.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
