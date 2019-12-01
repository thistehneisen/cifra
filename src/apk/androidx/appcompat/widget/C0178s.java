package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.e;
import b.a.a.a.a;
import b.a.j;

/* renamed from: androidx.appcompat.widget.s reason: case insensitive filesystem */
/* compiled from: AppCompatImageHelper */
public class C0178s {

    /* renamed from: a reason: collision with root package name */
    private final ImageView f1037a;

    /* renamed from: b reason: collision with root package name */
    private qa f1038b;

    /* renamed from: c reason: collision with root package name */
    private qa f1039c;

    /* renamed from: d reason: collision with root package name */
    private qa f1040d;

    public C0178s(ImageView imageView) {
        this.f1037a = imageView;
    }

    private boolean e() {
        int i2 = VERSION.SDK_INT;
        boolean z = true;
        if (i2 <= 21) {
            return i2 == 21;
        }
        if (this.f1038b == null) {
            z = false;
        }
        return z;
    }

    public void a(AttributeSet attributeSet, int i2) {
        sa a2 = sa.a(this.f1037a.getContext(), attributeSet, j.AppCompatImageView, i2, 0);
        try {
            Drawable drawable = this.f1037a.getDrawable();
            if (drawable == null) {
                int g2 = a2.g(j.AppCompatImageView_srcCompat, -1);
                if (g2 != -1) {
                    drawable = a.b(this.f1037a.getContext(), g2);
                    if (drawable != null) {
                        this.f1037a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                K.b(drawable);
            }
            if (a2.g(j.AppCompatImageView_tint)) {
                e.a(this.f1037a, a2.a(j.AppCompatImageView_tint));
            }
            if (a2.g(j.AppCompatImageView_tintMode)) {
                e.a(this.f1037a, K.a(a2.d(j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList b() {
        qa qaVar = this.f1039c;
        if (qaVar != null) {
            return qaVar.f1030a;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Mode c() {
        qa qaVar = this.f1039c;
        if (qaVar != null) {
            return qaVar.f1031b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean d() {
        return VERSION.SDK_INT < 21 || !(this.f1037a.getBackground() instanceof RippleDrawable);
    }

    public void a(int i2) {
        if (i2 != 0) {
            Drawable b2 = a.b(this.f1037a.getContext(), i2);
            if (b2 != null) {
                K.b(b2);
            }
            this.f1037a.setImageDrawable(b2);
        } else {
            this.f1037a.setImageDrawable(null);
        }
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        if (this.f1039c == null) {
            this.f1039c = new qa();
        }
        qa qaVar = this.f1039c;
        qaVar.f1030a = colorStateList;
        qaVar.f1033d = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(Mode mode) {
        if (this.f1039c == null) {
            this.f1039c = new qa();
        }
        qa qaVar = this.f1039c;
        qaVar.f1031b = mode;
        qaVar.f1032c = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        Drawable drawable = this.f1037a.getDrawable();
        if (drawable != null) {
            K.b(drawable);
        }
        if (drawable != null && (!e() || !a(drawable))) {
            qa qaVar = this.f1039c;
            if (qaVar != null) {
                C0175o.a(drawable, qaVar, this.f1037a.getDrawableState());
            } else {
                qa qaVar2 = this.f1038b;
                if (qaVar2 != null) {
                    C0175o.a(drawable, qaVar2, this.f1037a.getDrawableState());
                }
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.f1040d == null) {
            this.f1040d = new qa();
        }
        qa qaVar = this.f1040d;
        qaVar.a();
        ColorStateList a2 = e.a(this.f1037a);
        if (a2 != null) {
            qaVar.f1033d = true;
            qaVar.f1030a = a2;
        }
        Mode b2 = e.b(this.f1037a);
        if (b2 != null) {
            qaVar.f1032c = true;
            qaVar.f1031b = b2;
        }
        if (!qaVar.f1033d && !qaVar.f1032c) {
            return false;
        }
        C0175o.a(drawable, qaVar, this.f1037a.getDrawableState());
        return true;
    }
}
