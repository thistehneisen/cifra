package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import b.c.a;
import b.c.b;
import b.c.d;
import b.c.e;

public class CardView extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1082a = {16842801};

    /* renamed from: b reason: collision with root package name */
    private static final h f1083b;

    /* renamed from: c reason: collision with root package name */
    private boolean f1084c;

    /* renamed from: d reason: collision with root package name */
    private boolean f1085d;

    /* renamed from: e reason: collision with root package name */
    int f1086e;

    /* renamed from: f reason: collision with root package name */
    int f1087f;

    /* renamed from: g reason: collision with root package name */
    final Rect f1088g;

    /* renamed from: h reason: collision with root package name */
    final Rect f1089h;

    /* renamed from: i reason: collision with root package name */
    private final g f1090i;

    static {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            f1083b = new d();
        } else if (i2 >= 17) {
            f1083b = new c();
        } else {
            f1083b = new f();
        }
        f1083b.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1083b.e(this.f1090i);
    }

    public float getCardElevation() {
        return f1083b.a(this.f1090i);
    }

    public int getContentPaddingBottom() {
        return this.f1088g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1088g.left;
    }

    public int getContentPaddingRight() {
        return this.f1088g.right;
    }

    public int getContentPaddingTop() {
        return this.f1088g.top;
    }

    public float getMaxCardElevation() {
        return f1083b.d(this.f1090i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1085d;
    }

    public float getRadius() {
        return f1083b.b(this.f1090i);
    }

    public boolean getUseCompatPadding() {
        return this.f1084c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(f1083b instanceof d)) {
            int mode = MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1083b.g(this.f1090i)), MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1083b.f(this.f1090i)), MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f1083b.a(this.f1090i, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f1083b.b(this.f1090i, f2);
    }

    public void setMaxCardElevation(float f2) {
        f1083b.c(this.f1090i, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f1087f = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f1086e = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1085d) {
            this.f1085d = z;
            f1083b.h(this.f1090i);
        }
    }

    public void setRadius(float f2) {
        f1083b.a(this.f1090i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1084c != z) {
            this.f1084c = z;
            f1083b.c(this.f1090i);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1083b.a(this.f1090i, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        int i3;
        ColorStateList valueOf;
        super(context, attributeSet, i2);
        this.f1088g = new Rect();
        this.f1089h = new Rect();
        this.f1090i = new a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.CardView, i2, d.CardView);
        if (obtainStyledAttributes.hasValue(e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1082a);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(b.cardview_light_background);
            } else {
                i3 = getResources().getColor(b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(e.CardView_cardMaxElevation, 0.0f);
        this.f1084c = obtainStyledAttributes.getBoolean(e.CardView_cardUseCompatPadding, false);
        this.f1085d = obtainStyledAttributes.getBoolean(e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPadding, 0);
        this.f1088g.left = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1088g.top = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1088g.right = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1088g.bottom = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1086e = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minWidth, 0);
        this.f1087f = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1083b.a(this.f1090i, context, colorStateList, dimension, dimension2, f2);
    }
}
