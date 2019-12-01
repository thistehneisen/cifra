package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import b.a.j;
import b.g.i.B;

/* renamed from: androidx.appcompat.widget.j reason: case insensitive filesystem */
/* compiled from: AppCompatBackgroundHelper */
class C0170j {

    /* renamed from: a reason: collision with root package name */
    private final View f977a;

    /* renamed from: b reason: collision with root package name */
    private final C0175o f978b;

    /* renamed from: c reason: collision with root package name */
    private int f979c = -1;

    /* renamed from: d reason: collision with root package name */
    private qa f980d;

    /* renamed from: e reason: collision with root package name */
    private qa f981e;

    /* renamed from: f reason: collision with root package name */
    private qa f982f;

    C0170j(View view) {
        this.f977a = view;
        this.f978b = C0175o.a();
    }

    private boolean d() {
        int i2 = VERSION.SDK_INT;
        boolean z = true;
        if (i2 <= 21) {
            return i2 == 21;
        }
        if (this.f980d == null) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public void a(AttributeSet attributeSet, int i2) {
        sa a2 = sa.a(this.f977a.getContext(), attributeSet, j.ViewBackgroundHelper, i2, 0);
        try {
            if (a2.g(j.ViewBackgroundHelper_android_background)) {
                this.f979c = a2.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f978b.b(this.f977a.getContext(), this.f979c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTint)) {
                B.a(this.f977a, a2.a(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                B.a(this.f977a, K.a(a2.d(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(ColorStateList colorStateList) {
        if (this.f981e == null) {
            this.f981e = new qa();
        }
        qa qaVar = this.f981e;
        qaVar.f1030a = colorStateList;
        qaVar.f1033d = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public Mode c() {
        qa qaVar = this.f981e;
        if (qaVar != null) {
            return qaVar.f1031b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList b() {
        qa qaVar = this.f981e;
        if (qaVar != null) {
            return qaVar.f1030a;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f982f == null) {
            this.f982f = new qa();
        }
        qa qaVar = this.f982f;
        qaVar.a();
        ColorStateList e2 = B.e(this.f977a);
        if (e2 != null) {
            qaVar.f1033d = true;
            qaVar.f1030a = e2;
        }
        Mode f2 = B.f(this.f977a);
        if (f2 != null) {
            qaVar.f1032c = true;
            qaVar.f1031b = f2;
        }
        if (!qaVar.f1033d && !qaVar.f1032c) {
            return false;
        }
        C0175o.a(drawable, qaVar, this.f977a.getDrawableState());
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        this.f979c = i2;
        C0175o oVar = this.f978b;
        a(oVar != null ? oVar.b(this.f977a.getContext(), i2) : null);
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(Drawable drawable) {
        this.f979c = -1;
        a((ColorStateList) null);
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(Mode mode) {
        if (this.f981e == null) {
            this.f981e = new qa();
        }
        qa qaVar = this.f981e;
        qaVar.f1031b = mode;
        qaVar.f1032c = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        Drawable background = this.f977a.getBackground();
        if (background != null && (!d() || !b(background))) {
            qa qaVar = this.f981e;
            if (qaVar != null) {
                C0175o.a(background, qaVar, this.f977a.getDrawableState());
            } else {
                qa qaVar2 = this.f980d;
                if (qaVar2 != null) {
                    C0175o.a(background, qaVar2, this.f977a.getDrawableState());
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f980d == null) {
                this.f980d = new qa();
            }
            qa qaVar = this.f980d;
            qaVar.f1030a = colorStateList;
            qaVar.f1033d = true;
        } else {
            this.f980d = null;
        }
        a();
    }
}
