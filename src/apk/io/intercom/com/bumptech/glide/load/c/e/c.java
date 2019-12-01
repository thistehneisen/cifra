package io.intercom.com.bumptech.glide.load.c.e;

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
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.c.e.g.b;
import io.intercom.com.bumptech.glide.load.m;
import java.nio.ByteBuffer;

/* compiled from: GifDrawable */
public class c extends Drawable implements b, Animatable {

    /* renamed from: a reason: collision with root package name */
    private final a f9666a;

    /* renamed from: b reason: collision with root package name */
    private boolean f9667b;

    /* renamed from: c reason: collision with root package name */
    private boolean f9668c;

    /* renamed from: d reason: collision with root package name */
    private boolean f9669d;

    /* renamed from: e reason: collision with root package name */
    private boolean f9670e;

    /* renamed from: f reason: collision with root package name */
    private int f9671f;

    /* renamed from: g reason: collision with root package name */
    private int f9672g;

    /* renamed from: h reason: collision with root package name */
    private boolean f9673h;

    /* renamed from: i reason: collision with root package name */
    private Paint f9674i;

    /* renamed from: j reason: collision with root package name */
    private Rect f9675j;

    /* compiled from: GifDrawable */
    static final class a extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        final g f9676a;

        a(g gVar) {
            this.f9676a = gVar;
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

    public c(Context context, io.intercom.com.bumptech.glide.b.a aVar, m<Bitmap> mVar, int i2, int i3, Bitmap bitmap) {
        g gVar = new g(io.intercom.com.bumptech.glide.c.a(context), aVar, i2, i3, mVar, bitmap);
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
        if (this.f9675j == null) {
            this.f9675j = new Rect();
        }
        return this.f9675j;
    }

    private Paint j() {
        if (this.f9674i == null) {
            this.f9674i = new Paint(2);
        }
        return this.f9674i;
    }

    private void k() {
        this.f9671f = 0;
    }

    private void l() {
        h.a(!this.f9669d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f9666a.f9676a.f() == 1) {
            invalidateSelf();
        } else if (!this.f9667b) {
            this.f9667b = true;
            this.f9666a.f9676a.a((b) this);
            invalidateSelf();
        }
    }

    private void m() {
        this.f9667b = false;
        this.f9666a.f9676a.b(this);
    }

    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.f9666a.f9676a.a(mVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f9666a.f9676a.b();
    }

    public Bitmap c() {
        return this.f9666a.f9676a.e();
    }

    public int d() {
        return this.f9666a.f9676a.f();
    }

    public void draw(Canvas canvas) {
        if (!this.f9669d) {
            if (this.f9673h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), i());
                this.f9673h = false;
            }
            canvas.drawBitmap(this.f9666a.f9676a.c(), null, i(), j());
        }
    }

    public int e() {
        return this.f9666a.f9676a.d();
    }

    public int f() {
        return this.f9666a.f9676a.h();
    }

    public void g() {
        this.f9669d = true;
        this.f9666a.f9676a.a();
    }

    public ConstantState getConstantState() {
        return this.f9666a;
    }

    public int getIntrinsicHeight() {
        return this.f9666a.f9676a.g();
    }

    public int getIntrinsicWidth() {
        return this.f9666a.f9676a.i();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f9667b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9673h = true;
    }

    public void setAlpha(int i2) {
        j().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        j().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        h.a(!this.f9669d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f9670e = z;
        if (!z) {
            m();
        } else if (this.f9668c) {
            l();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f9668c = true;
        k();
        if (this.f9670e) {
            l();
        }
    }

    public void stop() {
        this.f9668c = false;
        m();
    }

    public void a() {
        if (h() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f9671f++;
        }
        int i2 = this.f9672g;
        if (i2 != -1 && this.f9671f >= i2) {
            stop();
        }
    }

    c(a aVar) {
        this.f9670e = true;
        this.f9672g = -1;
        h.a(aVar);
        this.f9666a = aVar;
    }
}
