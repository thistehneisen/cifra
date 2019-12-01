package io.intercom.android.sdk.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public class OrderedListSpan implements LeadingMarginSpan {
    private final int gapWidth;
    private final String number;

    public OrderedListSpan(int i2, String str) {
        this.gapWidth = i2;
        this.number = str;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i7) {
            Style style = paint.getStyle();
            paint.setStyle(Style.FILL);
            StringBuilder sb = new StringBuilder();
            sb.append(this.number);
            sb.append(" ");
            canvas.drawText(sb.toString(), (float) (i2 + i3), (float) i5, paint);
            paint.setStyle(style);
        }
    }

    public int getLeadingMargin(boolean z) {
        return (int) (new Paint().measureText(this.number) + ((float) this.gapWidth));
    }
}
