package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.widget.b;
import b.a.j;
import b.g.a.a.h.a;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper */
class G {

    /* renamed from: a reason: collision with root package name */
    private final TextView f787a;

    /* renamed from: b reason: collision with root package name */
    private qa f788b;

    /* renamed from: c reason: collision with root package name */
    private qa f789c;

    /* renamed from: d reason: collision with root package name */
    private qa f790d;

    /* renamed from: e reason: collision with root package name */
    private qa f791e;

    /* renamed from: f reason: collision with root package name */
    private qa f792f;

    /* renamed from: g reason: collision with root package name */
    private qa f793g;

    /* renamed from: h reason: collision with root package name */
    private final H f794h;

    /* renamed from: i reason: collision with root package name */
    private int f795i = 0;

    /* renamed from: j reason: collision with root package name */
    private Typeface f796j;

    /* renamed from: k reason: collision with root package name */
    private boolean f797k;

    G(TextView textView) {
        this.f787a = textView;
        this.f794h = new H(this.f787a);
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        Context context = this.f787a.getContext();
        C0175o a2 = C0175o.a();
        sa a3 = sa.a(context, attributeSet2, j.AppCompatTextHelper, i3, 0);
        int g2 = a3.g(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.f788b = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.f789c = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.f790d = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.f791e = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (VERSION.SDK_INT >= 17) {
            if (a3.g(j.AppCompatTextHelper_android_drawableStart)) {
                this.f792f = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(j.AppCompatTextHelper_android_drawableEnd)) {
                this.f793g = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z3 = this.f787a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        ColorStateList colorStateList3 = null;
        if (g2 != -1) {
            sa a4 = sa.a(context, g2, j.TextAppearance);
            if (z3 || !a4.g(j.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z = a4.a(j.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a(context, a4);
            if (VERSION.SDK_INT < 23) {
                ColorStateList a5 = a4.g(j.TextAppearance_android_textColor) ? a4.a(j.TextAppearance_android_textColor) : null;
                colorStateList = a4.g(j.TextAppearance_android_textColorHint) ? a4.a(j.TextAppearance_android_textColorHint) : null;
                if (a4.g(j.TextAppearance_android_textColorLink)) {
                    colorStateList3 = a4.a(j.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = a5;
                colorStateList2 = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList2 = null;
                colorStateList = null;
            }
            a4.a();
        } else {
            colorStateList2 = null;
            colorStateList = null;
            z2 = false;
            z = false;
        }
        sa a6 = sa.a(context, attributeSet2, j.TextAppearance, i3, 0);
        if (z3 || !a6.g(j.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z = a6.a(j.TextAppearance_textAllCaps, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (a6.g(j.TextAppearance_android_textColor)) {
                colorStateList3 = a6.a(j.TextAppearance_android_textColor);
            }
            if (a6.g(j.TextAppearance_android_textColorHint)) {
                colorStateList = a6.a(j.TextAppearance_android_textColorHint);
            }
            if (a6.g(j.TextAppearance_android_textColorLink)) {
                colorStateList2 = a6.a(j.TextAppearance_android_textColorLink);
            }
        }
        if (VERSION.SDK_INT >= 28 && a6.g(j.TextAppearance_android_textSize) && a6.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f787a.setTextSize(0, 0.0f);
        }
        a(context, a6);
        a6.a();
        if (colorStateList3 != null) {
            this.f787a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f787a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f787a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z4) {
            a(z);
        }
        Typeface typeface = this.f796j;
        if (typeface != null) {
            this.f787a.setTypeface(typeface, this.f795i);
        }
        this.f794h.a(attributeSet2, i3);
        if (b.f1369a && this.f794h.f() != 0) {
            int[] e2 = this.f794h.e();
            if (e2.length > 0) {
                if (((float) this.f787a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.f787a.setAutoSizeTextTypeUniformWithConfiguration(this.f794h.c(), this.f794h.b(), this.f794h.d(), 0);
                } else {
                    this.f787a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        sa a7 = sa.a(context, attributeSet2, j.AppCompatTextView);
        int c2 = a7.c(j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c3 = a7.c(j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c4 = a7.c(j.AppCompatTextView_lineHeight, -1);
        a7.a();
        if (c2 != -1) {
            androidx.core.widget.j.a(this.f787a, c2);
        }
        if (c3 != -1) {
            androidx.core.widget.j.b(this.f787a, c3);
        }
        if (c4 != -1) {
            androidx.core.widget.j.c(this.f787a, c4);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f794h.a();
    }

    /* access modifiers changed from: 0000 */
    public int c() {
        return this.f794h.b();
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        return this.f794h.c();
    }

    /* access modifiers changed from: 0000 */
    public int e() {
        return this.f794h.d();
    }

    /* access modifiers changed from: 0000 */
    public int[] f() {
        return this.f794h.e();
    }

    /* access modifiers changed from: 0000 */
    public int g() {
        return this.f794h.f();
    }

    /* access modifiers changed from: 0000 */
    public boolean h() {
        return this.f794h.g();
    }

    private void b(int i2, float f2) {
        this.f794h.a(i2, f2);
    }

    private void a(Context context, sa saVar) {
        this.f795i = saVar.d(j.TextAppearance_android_textStyle, this.f795i);
        boolean z = false;
        if (saVar.g(j.TextAppearance_android_fontFamily) || saVar.g(j.TextAppearance_fontFamily)) {
            this.f796j = null;
            int i2 = saVar.g(j.TextAppearance_fontFamily) ? j.TextAppearance_fontFamily : j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.f796j = saVar.a(i2, this.f795i, (a) new F(this, new WeakReference(this.f787a)));
                    if (this.f796j == null) {
                        z = true;
                    }
                    this.f797k = z;
                } catch (NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f796j == null) {
                String d2 = saVar.d(i2);
                if (d2 != null) {
                    this.f796j = Typeface.create(d2, this.f795i);
                }
            }
            return;
        }
        if (saVar.g(j.TextAppearance_android_typeface)) {
            this.f797k = false;
            int d3 = saVar.d(j.TextAppearance_android_typeface, 1);
            if (d3 == 1) {
                this.f796j = Typeface.SANS_SERIF;
            } else if (d3 == 2) {
                this.f796j = Typeface.SERIF;
            } else if (d3 == 3) {
                this.f796j = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f797k) {
            this.f796j = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f795i);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Context context, int i2) {
        sa a2 = sa.a(context, i2, j.TextAppearance);
        if (a2.g(j.TextAppearance_textAllCaps)) {
            a(a2.a(j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a2.g(j.TextAppearance_android_textColor)) {
            ColorStateList a3 = a2.a(j.TextAppearance_android_textColor);
            if (a3 != null) {
                this.f787a.setTextColor(a3);
            }
        }
        if (a2.g(j.TextAppearance_android_textSize) && a2.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f787a.setTextSize(0, 0.0f);
        }
        a(context, a2);
        a2.a();
        Typeface typeface = this.f796j;
        if (typeface != null) {
            this.f787a.setTypeface(typeface, this.f795i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        this.f787a.setAllCaps(z);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (!(this.f788b == null && this.f789c == null && this.f790d == null && this.f791e == null)) {
            Drawable[] compoundDrawables = this.f787a.getCompoundDrawables();
            a(compoundDrawables[0], this.f788b);
            a(compoundDrawables[1], this.f789c);
            a(compoundDrawables[2], this.f790d);
            a(compoundDrawables[3], this.f791e);
        }
        if (VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f792f != null || this.f793g != null) {
            Drawable[] compoundDrawablesRelative = this.f787a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f792f);
            a(compoundDrawablesRelative[2], this.f793g);
        }
    }

    private void a(Drawable drawable, qa qaVar) {
        if (drawable != null && qaVar != null) {
            C0175o.a(drawable, qaVar, this.f787a.getDrawableState());
        }
    }

    private static qa a(Context context, C0175o oVar, int i2) {
        ColorStateList b2 = oVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        qa qaVar = new qa();
        qaVar.f1033d = true;
        qaVar.f1030a = b2;
        return qaVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.f1369a) {
            b();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, float f2) {
        if (!b.f1369a && !h()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        this.f794h.a(i2);
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f794h.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: 0000 */
    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        this.f794h.a(iArr, i2);
    }
}
