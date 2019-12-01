package ru.touchin.roboswag.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import l.a.d.a.b.a.C0122a;

public class MaterialLoadingBar extends AppCompatImageView {

    /* renamed from: a reason: collision with root package name */
    private a f11118a;

    public MaterialLoadingBar(Context context) {
        this(context, null);
    }

    private static int a(Context context) {
        int i2;
        if (VERSION.SDK_INT >= 21) {
            i2 = 16843827;
        } else {
            i2 = context.getResources().getIdentifier("colorPrimary", "attr", context.getPackageName());
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.data;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11118a.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f11118a.stop();
        super.onDetachedFromWindow();
    }

    public void setColor(int i2) {
        this.f11118a.a(i2);
    }

    public MaterialLoadingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.materialLoadingBarStyle);
    }

    public MaterialLoadingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.MaterialLoadingBar, i2, 0);
        int dimension = (int) obtainStyledAttributes.getDimension(d.MaterialLoadingBar_size, C0122a.a(context, 48.0f));
        int color = obtainStyledAttributes.getColor(d.MaterialLoadingBar_color, a(context));
        float dimension2 = obtainStyledAttributes.getDimension(d.MaterialLoadingBar_strokeWidth, C0122a.a(context, 4.0f));
        obtainStyledAttributes.recycle();
        this.f11118a = new a(context, dimension);
        setColor(color);
        this.f11118a.a(dimension2);
        setScaleType(ScaleType.CENTER);
        setImageDrawable(this.f11118a);
    }
}
