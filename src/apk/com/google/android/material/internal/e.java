package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import androidx.appcompat.widget.sa;
import b.a.j;
import b.g.e.a;
import b.g.i.B;
import b.g.i.C0243d;

/* compiled from: CollapsingTextHelper */
public final class e {

    /* renamed from: a reason: collision with root package name */
    private static final boolean f6467a = (VERSION.SDK_INT < 18);

    /* renamed from: b reason: collision with root package name */
    private static final Paint f6468b = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private final TextPaint J;
    private final TextPaint K;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private int U;

    /* renamed from: c reason: collision with root package name */
    private final View f6469c;

    /* renamed from: d reason: collision with root package name */
    private boolean f6470d;

    /* renamed from: e reason: collision with root package name */
    private float f6471e;

    /* renamed from: f reason: collision with root package name */
    private final Rect f6472f;

    /* renamed from: g reason: collision with root package name */
    private final Rect f6473g;

    /* renamed from: h reason: collision with root package name */
    private final RectF f6474h;

    /* renamed from: i reason: collision with root package name */
    private int f6475i = 16;

    /* renamed from: j reason: collision with root package name */
    private int f6476j = 16;

    /* renamed from: k reason: collision with root package name */
    private float f6477k = 15.0f;

    /* renamed from: l reason: collision with root package name */
    private float f6478l = 15.0f;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        Paint paint = f6468b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f6468b.setColor(-65281);
        }
    }

    public e(View view) {
        this.f6469c = view;
        this.J = new TextPaint(129);
        this.K = new TextPaint(this.J);
        this.f6473g = new Rect();
        this.f6472f = new Rect();
        this.f6474h = new RectF();
    }

    private Typeface e(int i2) {
        TypedArray obtainStyledAttributes = this.f6469c.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void j() {
        float f2 = this.G;
        c(this.f6478l);
        CharSequence charSequence = this.y;
        float f3 = 0.0f;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int a2 = C0243d.a(this.f6476j, this.z ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.p = ((float) this.f6473g.top) - this.J.ascent();
        } else if (i2 != 80) {
            this.p = ((float) this.f6473g.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.p = (float) this.f6473g.bottom;
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.r = ((float) this.f6473g.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.r = (float) this.f6473g.left;
        } else {
            this.r = ((float) this.f6473g.right) - measureText;
        }
        c(this.f6477k);
        CharSequence charSequence2 = this.y;
        if (charSequence2 != null) {
            f3 = this.J.measureText(charSequence2, 0, charSequence2.length());
        }
        int a3 = C0243d.a(this.f6475i, this.z ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.o = ((float) this.f6472f.top) - this.J.ascent();
        } else if (i4 != 80) {
            this.o = ((float) this.f6472f.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.o = (float) this.f6472f.bottom;
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.q = ((float) this.f6472f.centerX()) - (f3 / 2.0f);
        } else if (i5 != 5) {
            this.q = (float) this.f6472f.left;
        } else {
            this.q = ((float) this.f6472f.right) - f3;
        }
        l();
        e(f2);
    }

    private void k() {
        b(this.f6471e);
    }

    private void l() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void m() {
        if (this.B == null && !this.f6472f.isEmpty() && !TextUtils.isEmpty(this.y)) {
            b(0.0f);
            this.D = this.J.ascent();
            this.E = this.J.descent();
            TextPaint textPaint = this.J;
            CharSequence charSequence = this.y;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.E - this.D);
            if (round > 0 && round2 > 0) {
                this.B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                Canvas canvas = new Canvas(this.B);
                CharSequence charSequence2 = this.y;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.J.descent(), this.J);
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    private int n() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        i();
    }

    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            i();
        }
    }

    public void c(int i2) {
        sa a2 = sa.a(this.f6469c.getContext(), i2, j.TextAppearance);
        if (a2.g(j.TextAppearance_android_textColor)) {
            this.m = a2.a(j.TextAppearance_android_textColor);
        }
        if (a2.g(j.TextAppearance_android_textSize)) {
            this.f6477k = (float) a2.c(j.TextAppearance_android_textSize, (int) this.f6477k);
        }
        this.U = a2.d(j.TextAppearance_android_shadowColor, 0);
        this.S = a2.a(j.TextAppearance_android_shadowDx, 0.0f);
        this.T = a2.a(j.TextAppearance_android_shadowDy, 0.0f);
        this.R = a2.a(j.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (VERSION.SDK_INT >= 16) {
            this.v = e(i2);
        }
        i();
    }

    public void d(int i2) {
        if (this.f6475i != i2) {
            this.f6475i = i2;
            i();
        }
    }

    public CharSequence f() {
        return this.x;
    }

    public final boolean g() {
        ColorStateList colorStateList = this.n;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.m;
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        this.f6470d = this.f6473g.width() > 0 && this.f6473g.height() > 0 && this.f6472f.width() > 0 && this.f6472f.height() > 0;
    }

    public void i() {
        if (this.f6469c.getHeight() > 0 && this.f6469c.getWidth() > 0) {
            j();
            k();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            i();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (!a(this.f6472f, i2, i3, i4, i5)) {
            this.f6472f.set(i2, i3, i4, i5);
            this.I = true;
            h();
        }
    }

    public int d() {
        return this.f6475i;
    }

    private void d(float f2) {
        this.f6474h.left = a((float) this.f6472f.left, (float) this.f6473g.left, f2, this.L);
        this.f6474h.top = a(this.o, this.p, f2, this.L);
        this.f6474h.right = a((float) this.f6472f.right, (float) this.f6473g.right, f2, this.L);
        this.f6474h.bottom = a((float) this.f6472f.bottom, (float) this.f6473g.bottom, f2, this.L);
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!a(this.f6473g, i2, i3, i4, i5)) {
            this.f6473g.set(i2, i3, i4, i5);
            this.I = true;
            h();
        }
    }

    public Typeface e() {
        Typeface typeface = this.v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    private void e(float f2) {
        c(f2);
        this.A = f6467a && this.F != 1.0f;
        if (this.A) {
            m();
        }
        B.G(this.f6469c);
    }

    public void b(int i2) {
        if (this.f6476j != i2) {
            this.f6476j = i2;
            i();
        }
    }

    public int a() {
        return this.f6476j;
    }

    public void a(int i2) {
        sa a2 = sa.a(this.f6469c.getContext(), i2, j.TextAppearance);
        if (a2.g(j.TextAppearance_android_textColor)) {
            this.n = a2.a(j.TextAppearance_android_textColor);
        }
        if (a2.g(j.TextAppearance_android_textSize)) {
            this.f6478l = (float) a2.c(j.TextAppearance_android_textSize, (int) this.f6478l);
        }
        this.Q = a2.d(j.TextAppearance_android_shadowColor, 0);
        this.O = a2.a(j.TextAppearance_android_shadowDx, 0.0f);
        this.P = a2.a(j.TextAppearance_android_shadowDy, 0.0f);
        this.N = a2.a(j.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (VERSION.SDK_INT >= 16) {
            this.u = e(i2);
        }
        i();
    }

    public void b(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            i();
        }
    }

    public Typeface b() {
        Typeface typeface = this.u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    private void b(float f2) {
        d(f2);
        this.s = a(this.q, this.r, f2, this.L);
        this.t = a(this.o, this.p, f2, this.L);
        e(a(this.f6477k, this.f6478l, f2, this.M));
        if (this.n != this.m) {
            this.J.setColor(a(n(), c(), f2));
        } else {
            this.J.setColor(c());
        }
        this.J.setShadowLayer(a(this.R, this.N, f2, (TimeInterpolator) null), a(this.S, this.O, f2, (TimeInterpolator) null), a(this.T, this.P, f2, (TimeInterpolator) null), a(this.U, this.Q, f2));
        B.G(this.f6469c);
    }

    public int c() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    private void c(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.x != null) {
            float width = (float) this.f6473g.width();
            float width2 = (float) this.f6472f.width();
            boolean z4 = true;
            if (a(f2, this.f6478l)) {
                float f4 = this.f6478l;
                this.F = 1.0f;
                Typeface typeface = this.w;
                Typeface typeface2 = this.u;
                if (typeface != typeface2) {
                    this.w = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.f6477k;
                Typeface typeface3 = this.w;
                Typeface typeface4 = this.v;
                if (typeface3 != typeface4) {
                    this.w = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.f6477k)) {
                    this.F = 1.0f;
                } else {
                    this.F = f2 / this.f6477k;
                }
                float f5 = this.f6478l / this.f6477k;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > 0.0f) {
                z2 = this.G != f3 || this.I || z2;
                this.G = f3;
                this.I = false;
            }
            if (this.y == null || z2) {
                this.J.setTextSize(this.G);
                this.J.setTypeface(this.w);
                TextPaint textPaint = this.J;
                if (this.F == 1.0f) {
                    z4 = false;
                }
                textPaint.setLinearText(z4);
                CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.y)) {
                    this.y = ellipsize;
                    this.z = b(this.y);
                }
            }
        }
    }

    public void a(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            i();
        }
    }

    private boolean b(CharSequence charSequence) {
        boolean z2 = true;
        if (B.m(this.f6469c) != 1) {
            z2 = false;
        }
        return (z2 ? b.g.g.e.f2609d : b.g.g.e.f2608c).isRtl(charSequence, 0, charSequence.length());
    }

    public void a(float f2) {
        float a2 = a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f6471e) {
            this.f6471e = a2;
            k();
        }
    }

    public final boolean a(int[] iArr) {
        this.H = iArr;
        if (!g()) {
            return false;
        }
        i();
        return true;
    }

    public void a(Canvas canvas) {
        float f2;
        int save = canvas.save();
        if (this.y != null && this.f6470d) {
            float f3 = this.s;
            float f4 = this.t;
            boolean z2 = this.A && this.B != null;
            if (z2) {
                f2 = this.D * this.F;
                float f5 = this.E;
            } else {
                f2 = this.J.ascent() * this.F;
                this.J.descent();
                float f6 = this.F;
            }
            if (z2) {
                f4 += f2;
            }
            float f7 = f4;
            float f8 = this.F;
            if (f8 != 1.0f) {
                canvas.scale(f8, f8, f3, f7);
            }
            if (z2) {
                canvas.drawBitmap(this.B, f3, f7, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f3, f7, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            l();
            i();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.b.a.c.a.a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
