package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import b.c.b;
import b.c.c;

/* compiled from: RoundRectDrawableWithShadow */
class j extends Drawable {

    /* renamed from: a reason: collision with root package name */
    private static final double f1107a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b reason: collision with root package name */
    static a f1108b;

    /* renamed from: c reason: collision with root package name */
    private final int f1109c;

    /* renamed from: d reason: collision with root package name */
    private Paint f1110d;

    /* renamed from: e reason: collision with root package name */
    private Paint f1111e;

    /* renamed from: f reason: collision with root package name */
    private Paint f1112f;

    /* renamed from: g reason: collision with root package name */
    private final RectF f1113g;

    /* renamed from: h reason: collision with root package name */
    private float f1114h;

    /* renamed from: i reason: collision with root package name */
    private Path f1115i;

    /* renamed from: j reason: collision with root package name */
    private float f1116j;

    /* renamed from: k reason: collision with root package name */
    private float f1117k;

    /* renamed from: l reason: collision with root package name */
    private float f1118l;
    private ColorStateList m;
    private boolean n = true;
    private final int o;
    private final int p;
    private boolean q = true;
    private boolean r = false;

    /* compiled from: RoundRectDrawableWithShadow */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    j(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(b.cardview_shadow_start_color);
        this.p = resources.getColor(b.cardview_shadow_end_color);
        this.f1109c = resources.getDimensionPixelSize(c.cardview_compat_inset_shadow);
        this.f1110d = new Paint(5);
        b(colorStateList);
        this.f1111e = new Paint(5);
        this.f1111e.setStyle(Style.FILL);
        this.f1114h = (float) ((int) (f2 + 0.5f));
        this.f1113g = new RectF();
        this.f1112f = new Paint(this.f1111e);
        this.f1112f.setAntiAlias(false);
        a(f3, f4);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.f1110d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    private void g() {
        float f2 = this.f1114h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f1117k;
        rectF2.inset(-f3, -f3);
        Path path = this.f1115i;
        if (path == null) {
            this.f1115i = new Path();
        } else {
            path.reset();
        }
        this.f1115i.setFillType(FillType.EVEN_ODD);
        this.f1115i.moveTo(-this.f1114h, 0.0f);
        this.f1115i.rLineTo(-this.f1117k, 0.0f);
        this.f1115i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1115i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1115i.close();
        float f4 = this.f1114h;
        float f5 = this.f1117k;
        float f6 = f4 / (f4 + f5);
        Paint paint = this.f1111e;
        float f7 = f4 + f5;
        int i2 = this.o;
        RadialGradient radialGradient = new RadialGradient(0.0f, 0.0f, f7, new int[]{i2, i2, this.p}, new float[]{0.0f, f6, 1.0f}, TileMode.CLAMP);
        paint.setShader(radialGradient);
        Paint paint2 = this.f1112f;
        float f8 = this.f1114h;
        float f9 = -f8;
        float f10 = this.f1117k;
        float f11 = f9 + f10;
        float f12 = (-f8) - f10;
        int i3 = this.o;
        LinearGradient linearGradient = new LinearGradient(0.0f, f11, 0.0f, f12, new int[]{i3, i3, this.p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f1112f.setAntiAlias(false);
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public void c(float f2) {
        a(f2, this.f1116j);
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.f1118l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.f1118l) / 2.0f);
        f1108b.a(canvas, this.f1113g, this.f1114h, this.f1110d);
    }

    /* access modifiers changed from: 0000 */
    public float e() {
        float f2 = this.f1116j;
        return (Math.max(f2, this.f1114h + ((float) this.f1109c) + (f2 / 2.0f)) * 2.0f) + ((this.f1116j + ((float) this.f1109c)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    public float f() {
        return this.f1118l;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) b(this.f1116j, this.f1114h, this.q));
        int ceil2 = (int) Math.ceil((double) a(this.f1116j, this.f1114h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1110d.getColor() == colorForState) {
            return false;
        }
        this.f1110d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i2) {
        this.f1110d.setAlpha(i2);
        this.f1111e.setAlpha(i2);
        this.f1112f.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1110d.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: 0000 */
    public float c() {
        return this.f1116j;
    }

    /* access modifiers changed from: 0000 */
    public float d() {
        float f2 = this.f1116j;
        return (Math.max(f2, this.f1114h + ((float) this.f1109c) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1116j * 1.5f) + ((float) this.f1109c)) * 2.0f);
    }

    private void a(float f2, float f3) {
        String str = ". Must be >= 0";
        if (f2 < 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid shadow size ");
            sb.append(f2);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (f3 >= 0.0f) {
            float d2 = (float) d(f2);
            float d3 = (float) d(f3);
            if (d2 > d3) {
                if (!this.r) {
                    this.r = true;
                }
                d2 = d3;
            }
            if (this.f1118l != d2 || this.f1116j != d3) {
                this.f1118l = d2;
                this.f1116j = d3;
                this.f1117k = (float) ((int) ((d2 * 1.5f) + ((float) this.f1109c) + 0.5f));
                this.n = true;
                invalidateSelf();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid max shadow size ");
            sb2.append(f3);
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - f1107a) * ((double) f3))) : f2 * 1.5f;
    }

    private void b(Rect rect) {
        float f2 = this.f1116j;
        float f3 = 1.5f * f2;
        this.f1113g.set(((float) rect.left) + f2, ((float) rect.top) + f3, ((float) rect.right) - f2, ((float) rect.bottom) - f3);
        g();
    }

    /* access modifiers changed from: 0000 */
    public float b() {
        return this.f1114h;
    }

    /* access modifiers changed from: 0000 */
    public void b(float f2) {
        a(this.f1118l, f2);
    }

    static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f1107a) * ((double) f3))) : f2;
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.f1114h != f3) {
                this.f1114h = f3;
                this.n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid radius ");
        sb.append(f2);
        sb.append(". Must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    private void a(Canvas canvas) {
        float f2 = this.f1114h;
        float f3 = (-f2) - this.f1117k;
        float f4 = f2 + ((float) this.f1109c) + (this.f1118l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f1113g.width() - f5 > 0.0f;
        boolean z2 = this.f1113g.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1113g;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f1115i, this.f1111e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1113g.width() - f5, -this.f1114h, this.f1112f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1113g;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1115i, this.f1111e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1113g.width() - f5, (-this.f1114h) + this.f1117k, this.f1112f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1113g;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1115i, this.f1111e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1113g.height() - f5, -this.f1114h, this.f1112f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1113g;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1115i, this.f1111e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1113g.height() - f5, -this.f1114h, this.f1112f);
        }
        canvas.restoreToCount(save4);
    }

    /* access modifiers changed from: 0000 */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList a() {
        return this.m;
    }
}
