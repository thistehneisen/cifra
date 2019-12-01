package l.a.d.a.b.a;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: TypefaceSpan */
public class a extends MetricAffectingSpan {

    /* renamed from: a reason: collision with root package name */
    private final Typeface f10412a;

    public a(Typeface typeface) {
        this.f10412a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTypeface(this.f10412a);
        textPaint.setFlags(textPaint.getFlags() | 128);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTypeface(this.f10412a);
        textPaint.setFlags(textPaint.getFlags() | 128);
    }
}
