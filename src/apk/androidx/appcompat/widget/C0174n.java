package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.c;
import b.a.a.a.a;
import b.a.j;

/* renamed from: androidx.appcompat.widget.n reason: case insensitive filesystem */
/* compiled from: AppCompatCompoundButtonHelper */
class C0174n {

    /* renamed from: a reason: collision with root package name */
    private final CompoundButton f996a;

    /* renamed from: b reason: collision with root package name */
    private ColorStateList f997b = null;

    /* renamed from: c reason: collision with root package name */
    private Mode f998c = null;

    /* renamed from: d reason: collision with root package name */
    private boolean f999d = false;

    /* renamed from: e reason: collision with root package name */
    private boolean f1000e = false;

    /* renamed from: f reason: collision with root package name */
    private boolean f1001f;

    C0174n(CompoundButton compoundButton) {
        this.f996a = compoundButton;
    }

    /* access modifiers changed from: 0000 */
    public void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f996a.getContext().obtainStyledAttributes(attributeSet, j.CompoundButton, i2, 0);
        try {
            if (obtainStyledAttributes.hasValue(j.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(j.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f996a.setButtonDrawable(a.b(this.f996a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(j.CompoundButton_buttonTint)) {
                c.a(this.f996a, obtainStyledAttributes.getColorStateList(j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(j.CompoundButton_buttonTintMode)) {
                c.a(this.f996a, K.a(obtainStyledAttributes.getInt(j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList b() {
        return this.f997b;
    }

    /* access modifiers changed from: 0000 */
    public Mode c() {
        return this.f998c;
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        if (this.f1001f) {
            this.f1001f = false;
            return;
        }
        this.f1001f = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        this.f997b = colorStateList;
        this.f999d = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(Mode mode) {
        this.f998c = mode;
        this.f1000e = true;
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        Drawable a2 = c.a(this.f996a);
        if (a2 == null) {
            return;
        }
        if (this.f999d || this.f1000e) {
            Drawable mutate = androidx.core.graphics.drawable.a.i(a2).mutate();
            if (this.f999d) {
                androidx.core.graphics.drawable.a.a(mutate, this.f997b);
            }
            if (this.f1000e) {
                androidx.core.graphics.drawable.a.a(mutate, this.f998c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f996a.getDrawableState());
            }
            this.f996a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: 0000 */
    public int a(int i2) {
        if (VERSION.SDK_INT >= 17) {
            return i2;
        }
        Drawable a2 = c.a(this.f996a);
        return a2 != null ? i2 + a2.getIntrinsicWidth() : i2;
    }
}
