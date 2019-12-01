package com.bumptech.glide.load.c.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.e;
import com.bumptech.glide.load.c.e.g.b;
import com.bumptech.glide.load.l;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: GifDrawable */
public class c extends Drawable implements b, Animatable, b.q.a.a.b {

    /* renamed from: a reason: collision with root package name */
    private final a f3802a;

    /* renamed from: b reason: collision with root package name */
    private boolean f3803b;

    /* renamed from: c reason: collision with root package name */
    private boolean f3804c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3805d;

    /* renamed from: e reason: collision with root package name */
    private boolean f3806e;

    /* renamed from: f reason: collision with root package name */
    private int f3807f;

    /* renamed from: g reason: collision with root package name */
    private int f3808g;

    /* renamed from: h reason: collision with root package name */
    private boolean f3809h;

    /* renamed from: i reason: collision with root package name */
    private Paint f3810i;

    /* renamed from: j reason: collision with root package name */
    private Rect f3811j;

    /* renamed from: k reason: collision with root package name */
    private List<b.q.a.a.b.a> f3812k;

    /* compiled from: GifDrawable */
    static final class a extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        final g f3813a;

        a(g gVar) {
            this.f3813a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, com.bumptech.glide.b.a aVar, l<Bitmap> lVar, int i2, int i3, Bitmap bitmap) {
        g gVar = new g(e.a(context), aVar, i2, i3, lVar, bitmap);
        this(new a(gVar));
    }

    private Callback h() {
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect i() {
        if (this.f3811j == null) {
            this.f3811j = new Rect();
        }
        return this.f3811j;
    }

    private Paint j() {
        if (this.f3810i == null) {
            this.f3810i = new Paint(2);
        }
        return this.f3810i;
    }

    private void k() {
        List<b.q.a.a.b.a> list = this.f3812k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((b.q.a.a.b.a) this.f3812k.get(i2)).a(this);
            }
        }
    }

    private void l() {
        this.f3807f = 0;
    }

    private void m() {
        com.bumptech.glide.h.l.a(!this.f3805d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f3802a.f3813a.f() == 1) {
            invalidateSelf();
        } else if (!this.f3803b) {
            this.f3803b = true;
            this.f3802a.f3813a.a((b) this);
            invalidateSelf();
        }
    }

    private void n() {
        this.f3803b = false;
        this.f3802a.f3813a.b(this);
    }

    public void a(l<Bitmap> lVar, Bitmap bitmap) {
        this.f3802a.f3813a.a(lVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f3802a.f3813a.b();
    }

    public Bitmap c() {
        return this.f3802a.f3813a.e();
    }

    public int d() {
        return this.f3802a.f3813a.f();
    }

    public void draw(Canvas canvas) {
        if (!this.f3805d) {
            if (this.f3809h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), i());
                this.f3809h = false;
            }
            canvas.drawBitmap(this.f3802a.f3813a.c(), null, i(), j());
        }
    }

    public int e() {
        return this.f3802a.f3813a.d();
    }

    public int f() {
        return this.f3802a.f3813a.h();
    }

    public void g() {
        this.f3805d = true;
        this.f3802a.f3813a.a();
    }

    public ConstantState getConstantState() {
        return this.f3802a;
    }

    public int getIntrinsicHeight() {
        return this.f3802a.f3813a.g();
    }

    public int getIntrinsicWidth() {
        return this.f3802a.f3813a.i();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f3803b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3809h = true;
    }

    public void setAlpha(int i2) {
        j().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        j().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        com.bumptech.glide.h.l.a(!this.f3805d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f3806e = z;
        if (!z) {
            n();
        } else if (this.f3804c) {
            m();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f3804c = true;
        l();
        if (this.f3806e) {
            m();
        }
    }

    public void stop() {
        this.f3804c = false;
        n();
    }

    public void a() {
        if (h() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f3807f++;
        }
        int i2 = this.f3808g;
        if (i2 != -1 && this.f3807f >= i2) {
            k();
            stop();
        }
    }

    c(a aVar) {
        this.f3806e = true;
        this.f3808g = -1;
        com.bumptech.glide.h.l.a(aVar);
        this.f3802a = aVar;
    }
}
