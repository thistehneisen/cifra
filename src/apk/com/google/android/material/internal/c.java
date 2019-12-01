package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: CircularBorderDrawable */
public class c extends Drawable {

    /* renamed from: a reason: collision with root package name */
    final Paint f6454a = new Paint(1);

    /* renamed from: b reason: collision with root package name */
    final Rect f6455b = new Rect();

    /* renamed from: c reason: collision with root package name */
    final RectF f6456c = new RectF();

    /* renamed from: d reason: collision with root package name */
    final a f6457d = new a();

    /* renamed from: e reason: collision with root package name */
    float f6458e;

    /* renamed from: f reason: collision with root package name */
    private int f6459f;

    /* renamed from: g reason: collision with root package name */
    private int f6460g;

    /* renamed from: h reason: collision with root package name */
    private int f6461h;

    /* renamed from: i reason: collision with root package name */
    private int f6462i;

    /* renamed from: j reason: collision with root package name */
    private ColorStateList f6463j;

    /* renamed from: k reason: collision with root package name */
    private int f6464k;

    /* renamed from: l reason: collision with root package name */
    private boolean f6465l = true;
    private float m;

    /* compiled from: CircularBorderDrawable */
    private class a extends ConstantState {
        private a() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c() {
        this.f6454a.setStyle(Style.STROKE);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f6459f = i2;
        this.f6460g = i3;
        this.f6461h = i4;
        this.f6462i = i5;
    }

    public final void b(float f2) {
        if (f2 != this.m) {
            this.m = f2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f6465l) {
            this.f6454a.setShader(a());
            this.f6465l = false;
        }
        float strokeWidth = this.f6454a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f6456c;
        copyBounds(this.f6455b);
        rectF.set(this.f6455b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f6454a);
        canvas.restore();
    }

    public ConstantState getConstantState() {
        return this.f6457d;
    }

    public int getOpacity() {
        return this.f6458e > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f6458e);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f6463j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f6465l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f6463j;
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(iArr, this.f6464k);
            if (colorForState != this.f6464k) {
                this.f6465l = true;
                this.f6464k = colorForState;
            }
        }
        if (this.f6465l) {
            invalidateSelf();
        }
        return this.f6465l;
    }

    public void setAlpha(int i2) {
        this.f6454a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6454a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void a(float f2) {
        if (this.f6458e != f2) {
            this.f6458e = f2;
            this.f6454a.setStrokeWidth(f2 * 1.3333f);
            this.f6465l = true;
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f6464k = colorStateList.getColorForState(getState(), this.f6464k);
        }
        this.f6463j = colorStateList;
        this.f6465l = true;
        invalidateSelf();
    }

    private Shader a() {
        Rect rect = this.f6455b;
        copyBounds(rect);
        float height = this.f6458e / ((float) rect.height());
        LinearGradient linearGradient = new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{b.g.b.a.a(this.f6459f, this.f6464k), b.g.b.a.a(this.f6460g, this.f6464k), b.g.b.a.a(b.g.b.a.b(this.f6460g, 0), this.f6464k), b.g.b.a.a(b.g.b.a.b(this.f6462i, 0), this.f6464k), b.g.b.a.a(this.f6462i, this.f6464k), b.g.b.a.a(this.f6461h, this.f6464k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
        return linearGradient;
    }
}
