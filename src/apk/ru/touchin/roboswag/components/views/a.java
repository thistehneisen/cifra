package ru.touchin.roboswag.components.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import l.a.d.a.b.a.C0122a;

/* compiled from: MaterialProgressDrawable */
public class a extends Drawable implements Runnable, Animatable {

    /* renamed from: a reason: collision with root package name */
    private static final C0132a f11119a;

    /* renamed from: b reason: collision with root package name */
    private final int f11120b;

    /* renamed from: c reason: collision with root package name */
    private final Paint f11121c;

    /* renamed from: d reason: collision with root package name */
    private C0132a f11122d = f11119a;

    /* renamed from: e reason: collision with root package name */
    private final RectF f11123e = new RectF();

    /* renamed from: f reason: collision with root package name */
    private float f11124f;

    /* renamed from: g reason: collision with root package name */
    private float f11125g;

    /* renamed from: h reason: collision with root package name */
    private boolean f11126h;

    /* renamed from: ru.touchin.roboswag.components.views.a$a reason: collision with other inner class name */
    /* compiled from: MaterialProgressDrawable */
    public static class C0132a {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public final float f11127a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final float f11128b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public final float f11129c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public final float f11130d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public final float f11131e;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public final float f11132f;

        public C0132a(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.f11127a = f2;
            this.f11128b = f3;
            this.f11129c = f4;
            this.f11130d = f5;
            this.f11131e = f6;
            this.f11132f = f7;
        }
    }

    static {
        C0132a aVar = new C0132a(20.0f, 270.0f, 4.0f, 12.0f, 4.0f, 8.0f);
        f11119a = aVar;
    }

    public a(Context context, int i2) {
        this.f11120b = i2;
        this.f11121c = new Paint(1);
        this.f11121c.setStyle(Style.STROKE);
        this.f11121c.setStrokeWidth(C0122a.a(context, 4.5f));
        this.f11121c.setColor(-16777216);
    }

    public void a(float f2) {
        this.f11121c.setStrokeWidth(f2);
        a();
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        boolean z = ((int) (this.f11125g / this.f11122d.f11128b)) % 2 == 0;
        float a2 = this.f11125g % this.f11122d.f11128b;
        float a3 = (a2 / this.f11122d.f11128b) * this.f11122d.f11127a;
        canvas.drawArc(this.f11123e, z ? this.f11124f + a3 : (this.f11124f + this.f11122d.f11127a) - a3, z ? a2 + this.f11122d.f11127a : (this.f11122d.f11128b - a2) + this.f11122d.f11127a, false, this.f11121c);
        this.f11124f += z ? this.f11122d.f11129c : this.f11122d.f11130d;
        this.f11125g += z ? this.f11122d.f11131e : this.f11122d.f11132f;
        if (this.f11125g < 0.0f) {
            this.f11125g = 0.0f;
        }
        if (isRunning()) {
            scheduleSelf(this, SystemClock.uptimeMillis() + 16);
        }
    }

    public int getIntrinsicHeight() {
        return this.f11120b;
    }

    public int getIntrinsicWidth() {
        return this.f11120b;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f11126h;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    public void run() {
        if (this.f11126h) {
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        this.f11121c.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11121c.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void start() {
        if (!this.f11126h) {
            this.f11126h = true;
            run();
        }
    }

    public void stop() {
        if (this.f11126h) {
            unscheduleSelf(this);
            this.f11126h = false;
        }
    }

    public void a(int i2) {
        this.f11121c.setColor(i2);
        invalidateSelf();
    }

    private void a() {
        this.f11123e.set(getBounds());
        float strokeWidth = (float) (((int) (this.f11121c.getStrokeWidth() / 2.0f)) + 1);
        this.f11123e.inset(strokeWidth, strokeWidth);
    }
}
