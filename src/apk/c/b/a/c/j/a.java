package c.b.a.c.j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import b.a.b.a.e;
import c.b.a.c.c;

/* compiled from: ShadowDrawableWrapper */
public class a extends e {

    /* renamed from: b reason: collision with root package name */
    static final double f3173b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c reason: collision with root package name */
    final Paint f3174c;

    /* renamed from: d reason: collision with root package name */
    final Paint f3175d;

    /* renamed from: e reason: collision with root package name */
    final RectF f3176e;

    /* renamed from: f reason: collision with root package name */
    float f3177f;

    /* renamed from: g reason: collision with root package name */
    Path f3178g;

    /* renamed from: h reason: collision with root package name */
    float f3179h;

    /* renamed from: i reason: collision with root package name */
    float f3180i;

    /* renamed from: j reason: collision with root package name */
    float f3181j;

    /* renamed from: k reason: collision with root package name */
    float f3182k;

    /* renamed from: l reason: collision with root package name */
    private boolean f3183l = true;
    private final int m;
    private final int n;
    private final int o;
    private boolean p = true;
    private float q;
    private boolean r = false;

    public a(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.m = b.g.a.a.a(context, c.design_fab_shadow_start_color);
        this.n = b.g.a.a.a(context, c.design_fab_shadow_mid_color);
        this.o = b.g.a.a.a(context, c.design_fab_shadow_end_color);
        this.f3174c = new Paint(5);
        this.f3174c.setStyle(Style.FILL);
        this.f3177f = (float) Math.round(f2);
        this.f3176e = new RectF();
        this.f3175d = new Paint(this.f3174c);
        this.f3175d.setAntiAlias(false);
        a(f3, f4);
    }

    private static int c(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void a(boolean z) {
        this.p = z;
        invalidateSelf();
    }

    public void b(float f2) {
        a(f2, this.f3180i);
    }

    public void draw(Canvas canvas) {
        if (this.f3183l) {
            a(getBounds());
            this.f3183l = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) b(this.f3180i, this.f3177f, this.p));
        int ceil2 = (int) Math.ceil((double) a(this.f3180i, this.f3177f, this.p));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f3183l = true;
    }

    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.f3174c.setAlpha(i2);
        this.f3175d.setAlpha(i2);
    }

    public float b() {
        return this.f3182k;
    }

    public static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - f3173b) * ((double) f3))) : f2 * 1.5f;
    }

    private void c() {
        float f2 = this.f3177f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f3181j;
        rectF2.inset(-f3, -f3);
        Path path = this.f3178g;
        if (path == null) {
            this.f3178g = new Path();
        } else {
            path.reset();
        }
        this.f3178g.setFillType(FillType.EVEN_ODD);
        this.f3178g.moveTo(-this.f3177f, 0.0f);
        this.f3178g.rLineTo(-this.f3181j, 0.0f);
        this.f3178g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f3178g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f3178g.close();
        float f4 = -rectF2.top;
        if (f4 > 0.0f) {
            float f5 = this.f3177f / f4;
            float f6 = ((1.0f - f5) / 2.0f) + f5;
            Paint paint = this.f3174c;
            RadialGradient radialGradient = r8;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f4, new int[]{0, this.m, this.n, this.o}, new float[]{0.0f, f5, f6, 1.0f}, TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        Paint paint2 = this.f3175d;
        LinearGradient linearGradient = new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.m, this.n, this.o}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f3175d.setAntiAlias(false);
    }

    public void a(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c2 = (float) c(f2);
        float c3 = (float) c(f3);
        if (c2 > c3) {
            if (!this.r) {
                this.r = true;
            }
            c2 = c3;
        }
        if (this.f3182k != c2 || this.f3180i != c3) {
            this.f3182k = c2;
            this.f3180i = c3;
            this.f3181j = (float) Math.round(c2 * 1.5f);
            this.f3179h = c3;
            this.f3183l = true;
            invalidateSelf();
        }
    }

    public static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f3173b) * ((double) f3))) : f2;
    }

    public final void a(float f2) {
        if (this.q != f2) {
            this.q = f2;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        float f2;
        int i2;
        int i3;
        float f3;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.q, this.f3176e.centerX(), this.f3176e.centerY());
        float f6 = this.f3177f;
        float f7 = (-f6) - this.f3181j;
        float f8 = f6 * 2.0f;
        boolean z = this.f3176e.width() - f8 > 0.0f;
        boolean z2 = this.f3176e.height() - f8 > 0.0f;
        float f9 = this.f3182k;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (0.25f * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas.save();
        RectF rectF = this.f3176e;
        canvas2.translate(rectF.left + f6, rectF.top + f6);
        canvas2.scale(f10, f11);
        canvas2.drawPath(this.f3178g, this.f3174c);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            i3 = save2;
            f2 = f12;
            i2 = save;
            f3 = f11;
            canvas.drawRect(0.0f, f7, this.f3176e.width() - f8, -this.f3177f, this.f3175d);
        } else {
            i3 = save2;
            f2 = f12;
            i2 = save;
            f3 = f11;
        }
        canvas2.restoreToCount(i3);
        int save3 = canvas.save();
        RectF rectF2 = this.f3176e;
        canvas2.translate(rectF2.right - f6, rectF2.bottom - f6);
        float f13 = f2;
        canvas2.scale(f10, f13);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.f3178g, this.f3174c);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            f4 = f3;
            f5 = f13;
            canvas.drawRect(0.0f, f7, this.f3176e.width() - f8, (-this.f3177f) + this.f3181j, this.f3175d);
        } else {
            f4 = f3;
            f5 = f13;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f3176e;
        canvas2.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas2.scale(f10, f5);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.f3178g, this.f3174c);
        if (z2) {
            canvas2.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f7, this.f3176e.height() - f8, -this.f3177f, this.f3175d);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f3176e;
        canvas2.translate(rectF4.right - f6, rectF4.top + f6);
        float f14 = f4;
        canvas2.scale(f10, f14);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.f3178g, this.f3174c);
        if (z2) {
            canvas2.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f7, this.f3176e.height() - f8, -this.f3177f, this.f3175d);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i2);
    }

    private void a(Rect rect) {
        float f2 = this.f3180i;
        float f3 = 1.5f * f2;
        this.f3176e.set(((float) rect.left) + f2, ((float) rect.top) + f3, ((float) rect.right) - f2, ((float) rect.bottom) - f3);
        Drawable a2 = a();
        RectF rectF = this.f3176e;
        a2.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        c();
    }
}
