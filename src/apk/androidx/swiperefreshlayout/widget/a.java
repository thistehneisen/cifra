package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import b.g.i.B;

/* compiled from: CircleImageView */
class a extends ImageView {

    /* renamed from: a reason: collision with root package name */
    private AnimationListener f2074a;

    /* renamed from: b reason: collision with root package name */
    int f2075b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a reason: collision with other inner class name */
    /* compiled from: CircleImageView */
    private class C0017a extends OvalShape {

        /* renamed from: a reason: collision with root package name */
        private RadialGradient f2076a;

        /* renamed from: b reason: collision with root package name */
        private Paint f2077b = new Paint();

        C0017a(int i2) {
            a.this.f2075b = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = (float) (i2 / 2);
            RadialGradient radialGradient = new RadialGradient(f2, f2, (float) a.this.f2075b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f2076a = radialGradient;
            this.f2077b.setShader(this.f2076a);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f2 = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f2, height, f2, this.f2077b);
            canvas.drawCircle(f2, height, (float) (width - a.this.f2075b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    a(Context context, int i2) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f2075b = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            B.b((View) this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0017a(this.f2075b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f2075b, (float) i4, (float) i3, 503316480);
            int i5 = this.f2075b;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        B.a((View) this, (Drawable) shapeDrawable);
    }

    private boolean a() {
        return VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        AnimationListener animationListener = this.f2074a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        AnimationListener animationListener = this.f2074a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f2075b * 2), getMeasuredHeight() + (this.f2075b * 2));
        }
    }

    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void a(AnimationListener animationListener) {
        this.f2074a = animationListener;
    }
}
