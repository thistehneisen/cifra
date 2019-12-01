package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import b.g.h.g;
import b.j.a.a.b;

/* compiled from: CircularProgressDrawable */
public class d extends Drawable implements Animatable {

    /* renamed from: a reason: collision with root package name */
    private static final Interpolator f2083a = new LinearInterpolator();

    /* renamed from: b reason: collision with root package name */
    private static final Interpolator f2084b = new b();

    /* renamed from: c reason: collision with root package name */
    private static final int[] f2085c = {-16777216};

    /* renamed from: d reason: collision with root package name */
    private final a f2086d = new a();

    /* renamed from: e reason: collision with root package name */
    private float f2087e;

    /* renamed from: f reason: collision with root package name */
    private Resources f2088f;

    /* renamed from: g reason: collision with root package name */
    private Animator f2089g;

    /* renamed from: h reason: collision with root package name */
    float f2090h;

    /* renamed from: i reason: collision with root package name */
    boolean f2091i;

    /* compiled from: CircularProgressDrawable */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        final RectF f2092a = new RectF();

        /* renamed from: b reason: collision with root package name */
        final Paint f2093b = new Paint();

        /* renamed from: c reason: collision with root package name */
        final Paint f2094c = new Paint();

        /* renamed from: d reason: collision with root package name */
        final Paint f2095d = new Paint();

        /* renamed from: e reason: collision with root package name */
        float f2096e = 0.0f;

        /* renamed from: f reason: collision with root package name */
        float f2097f = 0.0f;

        /* renamed from: g reason: collision with root package name */
        float f2098g = 0.0f;

        /* renamed from: h reason: collision with root package name */
        float f2099h = 5.0f;

        /* renamed from: i reason: collision with root package name */
        int[] f2100i;

        /* renamed from: j reason: collision with root package name */
        int f2101j;

        /* renamed from: k reason: collision with root package name */
        float f2102k;

        /* renamed from: l reason: collision with root package name */
        float f2103l;
        float m;
        boolean n;
        Path o;
        float p = 1.0f;
        float q;
        int r;
        int s;
        int t = 255;
        int u;

        a() {
            this.f2093b.setStrokeCap(Cap.SQUARE);
            this.f2093b.setAntiAlias(true);
            this.f2093b.setStyle(Style.STROKE);
            this.f2094c.setStyle(Style.FILL);
            this.f2094c.setAntiAlias(true);
            this.f2095d.setColor(0);
        }

        /* access modifiers changed from: 0000 */
        public void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2) {
            this.u = i2;
        }

        /* access modifiers changed from: 0000 */
        public void c(int i2) {
            this.f2101j = i2;
            this.u = this.f2100i[this.f2101j];
        }

        /* access modifiers changed from: 0000 */
        public int d() {
            return (this.f2101j + 1) % this.f2100i.length;
        }

        /* access modifiers changed from: 0000 */
        public void e(float f2) {
            this.f2096e = f2;
        }

        /* access modifiers changed from: 0000 */
        public void f(float f2) {
            this.f2099h = f2;
            this.f2093b.setStrokeWidth(f2);
        }

        /* access modifiers changed from: 0000 */
        public float g() {
            return this.f2103l;
        }

        /* access modifiers changed from: 0000 */
        public float h() {
            return this.m;
        }

        /* access modifiers changed from: 0000 */
        public float i() {
            return this.f2102k;
        }

        /* access modifiers changed from: 0000 */
        public void j() {
            c(d());
        }

        /* access modifiers changed from: 0000 */
        public void k() {
            this.f2102k = 0.0f;
            this.f2103l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        /* access modifiers changed from: 0000 */
        public void l() {
            this.f2102k = this.f2096e;
            this.f2103l = this.f2097f;
            this.m = this.f2098g;
        }

        /* access modifiers changed from: 0000 */
        public float b() {
            return this.f2097f;
        }

        /* access modifiers changed from: 0000 */
        public void d(float f2) {
            this.f2098g = f2;
        }

        /* access modifiers changed from: 0000 */
        public float e() {
            return this.f2096e;
        }

        /* access modifiers changed from: 0000 */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f2092a;
            float f2 = this.q;
            float f3 = (this.f2099h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.r) * this.p) / 2.0f, this.f2099h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f3, ((float) rect.centerY()) - f3, ((float) rect.centerX()) + f3, ((float) rect.centerY()) + f3);
            float f4 = this.f2096e;
            float f5 = this.f2098g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f2097f + f5) * 360.0f) - f6;
            this.f2093b.setColor(this.u);
            this.f2093b.setAlpha(this.t);
            float f8 = this.f2099h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f2095d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f2093b);
            a(canvas, f6, f7, rectF);
        }

        /* access modifiers changed from: 0000 */
        public void b(float f2) {
            this.q = f2;
        }

        /* access modifiers changed from: 0000 */
        public int c() {
            return this.f2100i[d()];
        }

        /* access modifiers changed from: 0000 */
        public int f() {
            return this.f2100i[this.f2101j];
        }

        /* access modifiers changed from: 0000 */
        public void c(float f2) {
            this.f2097f = f2;
        }

        /* access modifiers changed from: 0000 */
        public void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (((float) this.r) * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(((float) this.r) * this.p, 0.0f);
                Path path2 = this.o;
                float f5 = (float) this.r;
                float f6 = this.p;
                path2.lineTo((f5 * f6) / 2.0f, ((float) this.s) * f6);
                this.o.offset((min + rectF.centerX()) - f4, rectF.centerY() + (this.f2099h / 2.0f));
                this.o.close();
                this.f2094c.setColor(this.u);
                this.f2094c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f2094c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int[] iArr) {
            this.f2100i = iArr;
            c(0);
        }

        /* access modifiers changed from: 0000 */
        public void a(ColorFilter colorFilter) {
            this.f2093b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            this.t = i2;
        }

        /* access modifiers changed from: 0000 */
        public int a() {
            return this.t;
        }

        /* access modifiers changed from: 0000 */
        public void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public d(Context context) {
        g.a(context);
        this.f2088f = context.getResources();
        this.f2086d.a(f2085c);
        c(2.5f);
        a();
    }

    private int a(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) (((float) (((i3 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & 255) - i7)))));
    }

    private void a(float f2, float f3, float f4, float f5) {
        a aVar = this.f2086d;
        float f6 = this.f2088f.getDisplayMetrics().density;
        aVar.f(f3 * f6);
        aVar.b(f2 * f6);
        aVar.c(0);
        aVar.a(f4 * f6, f5 * f6);
    }

    private void d(float f2) {
        this.f2087e = f2;
    }

    public void b(float f2) {
        this.f2086d.d(f2);
        invalidateSelf();
    }

    public void c(float f2) {
        this.f2086d.f(f2);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2087e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2086d.a(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.f2086d.a();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f2089g.isRunning();
    }

    public void setAlpha(int i2) {
        this.f2086d.a(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2086d.a(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.f2089g.cancel();
        this.f2086d.l();
        if (this.f2086d.b() != this.f2086d.e()) {
            this.f2091i = true;
            this.f2089g.setDuration(666);
            this.f2089g.start();
            return;
        }
        this.f2086d.c(0);
        this.f2086d.k();
        this.f2089g.setDuration(1332);
        this.f2089g.start();
    }

    public void stop() {
        this.f2089g.cancel();
        d(0.0f);
        this.f2086d.a(false);
        this.f2086d.c(0);
        this.f2086d.k();
        invalidateSelf();
    }

    private void b(float f2, a aVar) {
        a(f2, aVar);
        float floor = (float) (Math.floor((double) (aVar.h() / 0.8f)) + 1.0d);
        aVar.e(aVar.i() + (((aVar.g() - 0.01f) - aVar.i()) * f2));
        aVar.c(aVar.g());
        aVar.d(aVar.h() + ((floor - aVar.h()) * f2));
    }

    public void a(int i2) {
        if (i2 == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f2086d.a(z);
        invalidateSelf();
    }

    public void a(float f2) {
        this.f2086d.a(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f2086d.e(f2);
        this.f2086d.c(f3);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f2086d.a(iArr);
        this.f2086d.c(0);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, a aVar) {
        if (f2 > 0.75f) {
            aVar.b(a((f2 - 0.75f) / 0.25f, aVar.f(), aVar.c()));
        } else {
            aVar.b(aVar.f());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, a aVar, boolean z) {
        float f3;
        float f4;
        if (this.f2091i) {
            b(f2, aVar);
        } else if (f2 != 1.0f || z) {
            float h2 = aVar.h();
            if (f2 < 0.5f) {
                float f5 = f2 / 0.5f;
                float i2 = aVar.i();
                float f6 = i2;
                f3 = (f2084b.getInterpolation(f5) * 0.79f) + 0.01f + i2;
                f4 = f6;
            } else {
                f3 = aVar.i() + 0.79f;
                f4 = f3 - (((1.0f - f2084b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f7 = h2 + (0.20999998f * f2);
            float f8 = (f2 + this.f2090h) * 216.0f;
            aVar.e(f4);
            aVar.c(f3);
            aVar.d(f7);
            d(f8);
        }
    }

    private void a() {
        a aVar = this.f2086d;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new b(this, aVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f2083a);
        ofFloat.addListener(new c(this, aVar));
        this.f2089g = ofFloat;
    }
}
