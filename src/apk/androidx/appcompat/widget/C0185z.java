package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import b.a.j;
import b.g.i.B;

/* renamed from: androidx.appcompat.widget.z reason: case insensitive filesystem */
/* compiled from: AppCompatSeekBarHelper */
class C0185z extends C0181v {

    /* renamed from: d reason: collision with root package name */
    private final SeekBar f1064d;

    /* renamed from: e reason: collision with root package name */
    private Drawable f1065e;

    /* renamed from: f reason: collision with root package name */
    private ColorStateList f1066f = null;

    /* renamed from: g reason: collision with root package name */
    private Mode f1067g = null;

    /* renamed from: h reason: collision with root package name */
    private boolean f1068h = false;

    /* renamed from: i reason: collision with root package name */
    private boolean f1069i = false;

    C0185z(SeekBar seekBar) {
        super(seekBar);
        this.f1064d = seekBar;
    }

    private void d() {
        if (this.f1065e == null) {
            return;
        }
        if (this.f1068h || this.f1069i) {
            this.f1065e = a.i(this.f1065e.mutate());
            if (this.f1068h) {
                a.a(this.f1065e, this.f1066f);
            }
            if (this.f1069i) {
                a.a(this.f1065e, this.f1067g);
            }
            if (this.f1065e.isStateful()) {
                this.f1065e.setState(this.f1064d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        sa a2 = sa.a(this.f1064d.getContext(), attributeSet, j.AppCompatSeekBar, i2, 0);
        Drawable c2 = a2.c(j.AppCompatSeekBar_android_thumb);
        if (c2 != null) {
            this.f1064d.setThumb(c2);
        }
        a(a2.b(j.AppCompatSeekBar_tickMark));
        if (a2.g(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1067g = K.a(a2.d(j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1067g);
            this.f1069i = true;
        }
        if (a2.g(j.AppCompatSeekBar_tickMarkTint)) {
            this.f1066f = a2.a(j.AppCompatSeekBar_tickMarkTint);
            this.f1068h = true;
        }
        a2.a();
        d();
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        Drawable drawable = this.f1065e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1064d.getDrawableState())) {
            this.f1064d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        Drawable drawable = this.f1065e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Drawable drawable) {
        Drawable drawable2 = this.f1065e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1065e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1064d);
            a.a(drawable, B.m(this.f1064d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1064d.getDrawableState());
            }
            d();
        }
        this.f1064d.invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void a(Canvas canvas) {
        if (this.f1065e != null) {
            int max = this.f1064d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1065e.getIntrinsicWidth();
                int intrinsicHeight = this.f1065e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f1065e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f1064d.getWidth() - this.f1064d.getPaddingLeft()) - this.f1064d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1064d.getPaddingLeft(), (float) (this.f1064d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1065e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
