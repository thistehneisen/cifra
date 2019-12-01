package c.d.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: SmartTabStrip */
class f extends LinearLayout {

    /* renamed from: a reason: collision with root package name */
    private final int f3248a;

    /* renamed from: b reason: collision with root package name */
    private final int f3249b;

    /* renamed from: c reason: collision with root package name */
    private final int f3250c;

    /* renamed from: d reason: collision with root package name */
    private final int f3251d;

    /* renamed from: e reason: collision with root package name */
    private final Paint f3252e;

    /* renamed from: f reason: collision with root package name */
    private final RectF f3253f = new RectF();

    /* renamed from: g reason: collision with root package name */
    private final boolean f3254g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f3255h;

    /* renamed from: i reason: collision with root package name */
    private final boolean f3256i;

    /* renamed from: j reason: collision with root package name */
    private final int f3257j;

    /* renamed from: k reason: collision with root package name */
    private final int f3258k;

    /* renamed from: l reason: collision with root package name */
    private final int f3259l;
    private final float m;
    private final Paint n;
    private final int o;
    private final Paint p;
    private final float q;
    private final a r;
    private final boolean s;
    private int t;
    private int u;
    private float v;
    private b w;
    private c.d.a.d.f x;

    /* compiled from: SmartTabStrip */
    private static class a implements c.d.a.d.f {

        /* renamed from: a reason: collision with root package name */
        private int[] f3260a;

        /* renamed from: b reason: collision with root package name */
        private int[] f3261b;

        private a() {
        }

        public final int a(int i2) {
            int[] iArr = this.f3260a;
            return iArr[i2 % iArr.length];
        }

        public final int b(int i2) {
            int[] iArr = this.f3261b;
            return iArr[i2 % iArr.length];
        }

        /* access modifiers changed from: 0000 */
        public void a(int... iArr) {
            this.f3261b = iArr;
        }

        /* access modifiers changed from: 0000 */
        public void b(int... iArr) {
            this.f3260a = iArr;
        }
    }

    f(Context context, AttributeSet attributeSet) {
        int[] iArr;
        int i2;
        int[] iArr2;
        super(context);
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i3 = typedValue.data;
        int i4 = (int) (8.0f * f2);
        float f3 = 0.0f * f2;
        int a2 = a(i3, 38);
        int i5 = (int) f3;
        int a3 = a(i3, 38);
        int i6 = (int) (2.0f * f2);
        int a4 = a(i3, 32);
        int i7 = (int) (f2 * 1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.stl_SmartTabLayout);
        boolean z = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_indicatorAlwaysInCenter, false);
        boolean z2 = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_indicatorWithoutPadding, false);
        boolean z3 = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_indicatorInFront, false);
        int i8 = obtainStyledAttributes.getInt(a.stl_SmartTabLayout_stl_indicatorInterpolation, 0);
        int i9 = obtainStyledAttributes.getInt(a.stl_SmartTabLayout_stl_indicatorGravity, 0);
        int i10 = i8;
        int color = obtainStyledAttributes.getColor(a.stl_SmartTabLayout_stl_indicatorColor, -13388315);
        int i11 = i9;
        int resourceId = obtainStyledAttributes.getResourceId(a.stl_SmartTabLayout_stl_indicatorColors, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_indicatorThickness, i4);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(a.stl_SmartTabLayout_stl_indicatorWidth, -1);
        float dimension = obtainStyledAttributes.getDimension(a.stl_SmartTabLayout_stl_indicatorCornerRadius, f3);
        int color2 = obtainStyledAttributes.getColor(a.stl_SmartTabLayout_stl_overlineColor, a2);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_overlineThickness, i5);
        int color3 = obtainStyledAttributes.getColor(a.stl_SmartTabLayout_stl_underlineColor, a3);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_underlineThickness, i6);
        int color4 = obtainStyledAttributes.getColor(a.stl_SmartTabLayout_stl_dividerColor, a4);
        float f4 = dimension;
        int resourceId2 = obtainStyledAttributes.getResourceId(a.stl_SmartTabLayout_stl_dividerColors, -1);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_dividerThickness, i7);
        boolean z4 = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_drawDecorationAfterTab, false);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            i2 = 1;
            iArr = new int[]{color};
        } else {
            i2 = 1;
            iArr = getResources().getIntArray(resourceId);
        }
        if (resourceId2 == -1) {
            iArr2 = new int[i2];
            iArr2[0] = color4;
        } else {
            iArr2 = getResources().getIntArray(resourceId2);
        }
        this.r = new a();
        this.r.b(iArr);
        this.r.a(iArr2);
        this.f3248a = dimensionPixelSize2;
        this.f3249b = color2;
        this.f3250c = dimensionPixelSize3;
        this.f3251d = color3;
        this.f3252e = new Paint(1);
        this.f3255h = z;
        this.f3254g = z2;
        this.f3256i = z3;
        this.f3257j = dimensionPixelSize;
        this.f3258k = layoutDimension;
        this.n = new Paint(1);
        this.m = f4;
        this.f3259l = i11;
        this.q = 0.5f;
        this.p = new Paint(1);
        int i12 = dimensionPixelSize4;
        this.p.setStrokeWidth((float) i12);
        this.o = i12;
        this.s = z4;
        this.w = b.a(i10);
    }

    private static int a(int i2, byte b2) {
        return Color.argb(b2, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    /* access modifiers changed from: 0000 */
    public void b(int... iArr) {
        this.x = null;
        this.r.b(iArr);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.s) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.s) {
            a(canvas);
        }
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.rgb((int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i3)) * f3)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i3)) * f3)), (int) ((((float) Color.blue(i2)) * f2) + (((float) Color.blue(i3)) * f3)));
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        return this.f3255h;
    }

    private void b(Canvas canvas, int i2, int i3) {
        int i4 = i2;
        if (this.o > 0) {
            int min = (int) (Math.min(Math.max(0.0f, this.q), 1.0f) * ((float) i4));
            c.d.a.d.f a2 = a();
            int i5 = (i4 - min) / 2;
            int i6 = min + i5;
            boolean l2 = g.l(this);
            for (int i7 = 0; i7 < i3 - 1; i7++) {
                View childAt = getChildAt(i7);
                int a3 = g.a(childAt);
                int b2 = g.b(childAt);
                int i8 = l2 ? a3 - b2 : a3 + b2;
                this.p.setColor(a2.b(i7));
                float f2 = (float) i8;
                canvas.drawLine(f2, (float) i5, f2, (float) i6, this.p);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        this.w = bVar;
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void a(c.d.a.d.f fVar) {
        this.x = fVar;
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void a(int... iArr) {
        this.x = null;
        this.r.a(iArr);
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, float f2) {
        this.u = i2;
        this.v = f2;
        if (f2 == 0.0f) {
            int i3 = this.t;
            int i4 = this.u;
            if (i3 != i4) {
                this.t = i4;
            }
        }
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public c.d.a.d.f a() {
        c.d.a.d.f fVar = this.x;
        return fVar != null ? fVar : this.r;
    }

    private void a(Canvas canvas) {
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        int height = getHeight();
        int width = getWidth();
        int childCount = getChildCount();
        c.d.a.d.f a2 = a();
        boolean l2 = g.l(this);
        if (this.f3256i) {
            a(canvas2, 0, width);
            a(canvas2, 0, width, height);
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.u);
            int b2 = g.b(childAt, this.f3254g);
            int a3 = g.a(childAt, this.f3254g);
            if (!l2) {
                int i4 = b2;
                b2 = a3;
                a3 = i4;
            }
            int a4 = a2.a(this.u);
            float f2 = (float) this.f3257j;
            if (this.v > 0.0f && this.u < getChildCount() - 1) {
                int a5 = a2.a(this.u + 1);
                if (a4 != a5) {
                    a4 = a(a5, a4, this.v);
                }
                float a6 = this.w.a(this.v);
                float b3 = this.w.b(this.v);
                float c2 = this.w.c(this.v);
                View childAt2 = getChildAt(this.u + 1);
                int b4 = g.b(childAt2, this.f3254g);
                int a7 = g.a(childAt2, this.f3254g);
                if (l2) {
                    i2 = (int) ((((float) a7) * b3) + ((1.0f - b3) * ((float) a3)));
                    i3 = (int) ((((float) b4) * a6) + ((1.0f - a6) * ((float) b2)));
                } else {
                    i2 = (int) ((((float) b4) * a6) + ((1.0f - a6) * ((float) a3)));
                    i3 = (int) ((((float) a7) * b3) + ((1.0f - b3) * ((float) b2)));
                }
                f2 *= c2;
                b2 = i3;
                a3 = i2;
            }
            a(canvas, a3, b2, height, f2, a4);
        }
        if (!this.f3256i) {
            a(canvas2, 0, width);
            a(canvas2, 0, getWidth(), height);
        }
        b(canvas2, height, childCount);
    }

    private void a(Canvas canvas, int i2, int i3, int i4, float f2, int i5) {
        float f3;
        float f4;
        int i6 = this.f3257j;
        if (i6 > 0 && this.f3258k != 0) {
            int i7 = this.f3259l;
            if (i7 == 1) {
                f3 = (float) i6;
                f4 = f3 / 2.0f;
            } else if (i7 != 2) {
                f4 = ((float) i4) - (((float) i6) / 2.0f);
            } else {
                f3 = (float) i4;
                f4 = f3 / 2.0f;
            }
            float f5 = f2 / 2.0f;
            float f6 = f4 - f5;
            float f7 = f4 + f5;
            this.n.setColor(i5);
            if (this.f3258k == -1) {
                this.f3253f.set((float) i2, f6, (float) i3, f7);
            } else {
                float abs = ((float) (Math.abs(i2 - i3) - this.f3258k)) / 2.0f;
                this.f3253f.set(((float) i2) + abs, f6, ((float) i3) - abs, f7);
            }
            float f8 = this.m;
            if (f8 > 0.0f) {
                canvas.drawRoundRect(this.f3253f, f8, f8, this.n);
            } else {
                canvas.drawRect(this.f3253f, this.n);
            }
        }
    }

    private void a(Canvas canvas, int i2, int i3) {
        if (this.f3248a > 0) {
            this.f3252e.setColor(this.f3249b);
            canvas.drawRect((float) i2, 0.0f, (float) i3, (float) this.f3248a, this.f3252e);
        }
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        if (this.f3250c > 0) {
            this.f3252e.setColor(this.f3251d);
            canvas.drawRect((float) i2, (float) (i4 - this.f3250c), (float) i3, (float) i4, this.f3252e);
        }
    }
}
