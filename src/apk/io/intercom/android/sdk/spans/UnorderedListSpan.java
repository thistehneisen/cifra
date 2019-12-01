package io.intercom.android.sdk.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;

public class UnorderedListSpan implements LeadingMarginSpan {
    private static final int BULLET_RADIUS_IN_DP = 2;
    private static final int INDENT_IN_DP = 5;
    private final int bulletRadius;
    private final int gapWidth;
    private final int indent;

    public UnorderedListSpan(int i2, Context context) {
        this.gapWidth = i2;
        this.bulletRadius = ScreenUtils.dpToPx(2.0f, context);
        this.indent = ScreenUtils.dpToPx(5.0f, context);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i7) {
            Style style = paint.getStyle();
            paint.setStyle(Style.FILL);
            int i9 = this.bulletRadius;
            canvas.drawCircle((float) (i2 + (i3 * i9) + this.indent), ((float) (i4 + i6)) / 2.0f, (float) i9, paint);
            paint.setStyle(style);
        }
    }

    public int getLeadingMargin(boolean z) {
        return (this.bulletRadius * 2) + this.gapWidth;
    }
}
