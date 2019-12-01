package c.b.a.c.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import androidx.core.graphics.drawable.a;
import b.g.i.B;
import c.b.a.c.k;
import com.google.android.material.internal.m;

/* compiled from: MaterialButtonHelper */
class c {

    /* renamed from: a reason: collision with root package name */
    private static final boolean f3121a = (VERSION.SDK_INT >= 21);

    /* renamed from: b reason: collision with root package name */
    private final a f3122b;

    /* renamed from: c reason: collision with root package name */
    private int f3123c;

    /* renamed from: d reason: collision with root package name */
    private int f3124d;

    /* renamed from: e reason: collision with root package name */
    private int f3125e;

    /* renamed from: f reason: collision with root package name */
    private int f3126f;

    /* renamed from: g reason: collision with root package name */
    private int f3127g;

    /* renamed from: h reason: collision with root package name */
    private int f3128h;

    /* renamed from: i reason: collision with root package name */
    private Mode f3129i;

    /* renamed from: j reason: collision with root package name */
    private ColorStateList f3130j;

    /* renamed from: k reason: collision with root package name */
    private ColorStateList f3131k;

    /* renamed from: l reason: collision with root package name */
    private ColorStateList f3132l;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private boolean w = false;

    public c(a aVar) {
        this.f3122b = aVar;
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius(((float) this.f3127g) + 1.0E-5f);
        this.p.setColor(-1);
        this.q = a.i(this.p);
        a.a(this.q, this.f3130j);
        Mode mode = this.f3129i;
        if (mode != null) {
            a.a(this.q, mode);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius(((float) this.f3127g) + 1.0E-5f);
        this.r.setColor(-1);
        this.s = a.i(this.r);
        a.a(this.s, this.f3132l);
        return a((Drawable) new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    @TargetApi(21)
    private Drawable j() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius(((float) this.f3127g) + 1.0E-5f);
        this.t.setColor(-1);
        n();
        this.u = new GradientDrawable();
        this.u.setCornerRadius(((float) this.f3127g) + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.f3128h, this.f3131k);
        InsetDrawable a2 = a((Drawable) new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius(((float) this.f3127g) + 1.0E-5f);
        this.v.setColor(-1);
        return new b(c.b.a.c.i.a.a(this.f3132l), a2, this.v);
    }

    private GradientDrawable k() {
        if (!f3121a || this.f3122b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f3122b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable l() {
        if (!f3121a || this.f3122b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f3122b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void m() {
        if (f3121a && this.u != null) {
            this.f3122b.setInternalBackground(j());
        } else if (!f3121a) {
            this.f3122b.invalidate();
        }
    }

    private void n() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            a.a((Drawable) gradientDrawable, this.f3130j);
            Mode mode = this.f3129i;
            if (mode != null) {
                a.a((Drawable) this.t, mode);
            }
        }
    }

    public void a(TypedArray typedArray) {
        int i2 = 0;
        this.f3123c = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetLeft, 0);
        this.f3124d = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetRight, 0);
        this.f3125e = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetTop, 0);
        this.f3126f = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetBottom, 0);
        this.f3127g = typedArray.getDimensionPixelSize(k.MaterialButton_cornerRadius, 0);
        this.f3128h = typedArray.getDimensionPixelSize(k.MaterialButton_strokeWidth, 0);
        this.f3129i = m.a(typedArray.getInt(k.MaterialButton_backgroundTintMode, -1), Mode.SRC_IN);
        this.f3130j = c.b.a.c.h.a.a(this.f3122b.getContext(), typedArray, k.MaterialButton_backgroundTint);
        this.f3131k = c.b.a.c.h.a.a(this.f3122b.getContext(), typedArray, k.MaterialButton_strokeColor);
        this.f3132l = c.b.a.c.h.a.a(this.f3122b.getContext(), typedArray, k.MaterialButton_rippleColor);
        this.m.setStyle(Style.STROKE);
        this.m.setStrokeWidth((float) this.f3128h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.f3131k;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(this.f3122b.getDrawableState(), 0);
        }
        paint.setColor(i2);
        int q2 = B.q(this.f3122b);
        int paddingTop = this.f3122b.getPaddingTop();
        int p2 = B.p(this.f3122b);
        int paddingBottom = this.f3122b.getPaddingBottom();
        this.f3122b.setInternalBackground(f3121a ? j() : i());
        B.a(this.f3122b, q2 + this.f3123c, paddingTop + this.f3125e, p2 + this.f3124d, paddingBottom + this.f3126f);
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList b() {
        return this.f3132l;
    }

    /* access modifiers changed from: 0000 */
    public void c(ColorStateList colorStateList) {
        if (this.f3130j != colorStateList) {
            this.f3130j = colorStateList;
            if (f3121a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                a.a(drawable, this.f3130j);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        return this.f3128h;
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList e() {
        return this.f3130j;
    }

    /* access modifiers changed from: 0000 */
    public Mode f() {
        return this.f3129i;
    }

    /* access modifiers changed from: 0000 */
    public boolean g() {
        return this.w;
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        this.w = true;
        this.f3122b.setSupportBackgroundTintList(this.f3130j);
        this.f3122b.setSupportBackgroundTintMode(this.f3129i);
    }

    /* access modifiers changed from: 0000 */
    public void b(ColorStateList colorStateList) {
        if (this.f3131k != colorStateList) {
            this.f3131k = colorStateList;
            Paint paint = this.m;
            int i2 = 0;
            if (colorStateList != null) {
                i2 = colorStateList.getColorForState(this.f3122b.getDrawableState(), 0);
            }
            paint.setColor(i2);
            m();
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList c() {
        return this.f3131k;
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2) {
        if (this.f3127g != i2) {
            this.f3127g = i2;
            if (f3121a && this.t != null && this.u != null && this.v != null) {
                if (VERSION.SDK_INT == 21) {
                    float f2 = ((float) i2) + 1.0E-5f;
                    k().setCornerRadius(f2);
                    l().setCornerRadius(f2);
                }
                float f3 = ((float) i2) + 1.0E-5f;
                this.t.setCornerRadius(f3);
                this.u.setCornerRadius(f3);
                this.v.setCornerRadius(f3);
            } else if (!f3121a) {
                GradientDrawable gradientDrawable = this.p;
                if (gradientDrawable != null && this.r != null) {
                    float f4 = ((float) i2) + 1.0E-5f;
                    gradientDrawable.setCornerRadius(f4);
                    this.r.setCornerRadius(f4);
                    this.f3122b.invalidate();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(int i2) {
        if (this.f3128h != i2) {
            this.f3128h = i2;
            this.m.setStrokeWidth((float) i2);
            m();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Canvas canvas) {
        if (canvas != null && this.f3131k != null && this.f3128h > 0) {
            this.n.set(this.f3122b.getBackground().getBounds());
            RectF rectF = this.o;
            Rect rect = this.n;
            float f2 = (float) rect.left;
            int i2 = this.f3128h;
            rectF.set(f2 + (((float) i2) / 2.0f) + ((float) this.f3123c), ((float) rect.top) + (((float) i2) / 2.0f) + ((float) this.f3125e), (((float) rect.right) - (((float) i2) / 2.0f)) - ((float) this.f3124d), (((float) rect.bottom) - (((float) i2) / 2.0f)) - ((float) this.f3126f));
            float f3 = ((float) this.f3127g) - (((float) this.f3128h) / 2.0f);
            canvas.drawRoundRect(this.o, f3, f3, this.m);
        }
    }

    private InsetDrawable a(Drawable drawable) {
        InsetDrawable insetDrawable = new InsetDrawable(drawable, this.f3123c, this.f3125e, this.f3124d, this.f3126f);
        return insetDrawable;
    }

    /* access modifiers changed from: 0000 */
    public void a(Mode mode) {
        if (this.f3129i != mode) {
            this.f3129i = mode;
            if (f3121a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                Mode mode2 = this.f3129i;
                if (mode2 != null) {
                    a.a(drawable, mode2);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f3123c, this.f3125e, i3 - this.f3124d, i2 - this.f3126f);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        if (f3121a) {
            GradientDrawable gradientDrawable = this.t;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(i2);
                return;
            }
        }
        if (!f3121a) {
            GradientDrawable gradientDrawable2 = this.p;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(i2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        if (this.f3132l != colorStateList) {
            this.f3132l = colorStateList;
            if (f3121a && (this.f3122b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f3122b.getBackground()).setColor(colorStateList);
            } else if (!f3121a) {
                Drawable drawable = this.s;
                if (drawable != null) {
                    a.a(drawable, colorStateList);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int a() {
        return this.f3127g;
    }
}
