package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import b.a.a;

/* renamed from: androidx.appcompat.widget.x reason: case insensitive filesystem */
/* compiled from: AppCompatRatingBar */
public class C0183x extends RatingBar {

    /* renamed from: a reason: collision with root package name */
    private final C0181v f1057a;

    public C0183x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap a2 = this.f1057a.a();
        if (a2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(a2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public C0183x(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1057a = new C0181v(this);
        this.f1057a.a(attributeSet, i2);
    }
}
