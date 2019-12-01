package c.b.a.c.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.C0171k;
import androidx.core.widget.j;
import b.g.i.B;
import c.b.a.c.b;
import c.b.a.c.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;

/* compiled from: MaterialButton */
public class a extends C0171k {

    /* renamed from: c reason: collision with root package name */
    private final c f3113c;

    /* renamed from: d reason: collision with root package name */
    private int f3114d;

    /* renamed from: e reason: collision with root package name */
    private Mode f3115e;

    /* renamed from: f reason: collision with root package name */
    private ColorStateList f3116f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f3117g;

    /* renamed from: h reason: collision with root package name */
    private int f3118h;

    /* renamed from: i reason: collision with root package name */
    private int f3119i;

    /* renamed from: j reason: collision with root package name */
    private int f3120j;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.materialButtonStyle);
    }

    private boolean a() {
        return B.m(this) == 1;
    }

    private boolean b() {
        c cVar = this.f3113c;
        return cVar != null && !cVar.g();
    }

    private void c() {
        Drawable drawable = this.f3117g;
        if (drawable != null) {
            this.f3117g = drawable.mutate();
            androidx.core.graphics.drawable.a.a(this.f3117g, this.f3116f);
            Mode mode = this.f3115e;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.f3117g, mode);
            }
            int i2 = this.f3118h;
            if (i2 == 0) {
                i2 = this.f3117g.getIntrinsicWidth();
            }
            int i3 = this.f3118h;
            if (i3 == 0) {
                i3 = this.f3117g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f3117g;
            int i4 = this.f3119i;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        j.a(this, this.f3117g, null, null, null);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f3113c.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f3117g;
    }

    public int getIconGravity() {
        return this.f3120j;
    }

    public int getIconPadding() {
        return this.f3114d;
    }

    public int getIconSize() {
        return this.f3118h;
    }

    public ColorStateList getIconTint() {
        return this.f3116f;
    }

    public Mode getIconTintMode() {
        return this.f3115e;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f3113c.b();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f3113c.c();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f3113c.d();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f3113c.e();
        }
        return super.getSupportBackgroundTintList();
    }

    public Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f3113c.f();
        }
        return super.getSupportBackgroundTintMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (VERSION.SDK_INT < 21 && b()) {
            this.f3113c.a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (VERSION.SDK_INT == 21) {
            c cVar = this.f3113c;
            if (cVar != null) {
                cVar.a(i5 - i3, i4 - i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f3117g != null && this.f3120j == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i4 = this.f3118h;
            if (i4 == 0) {
                i4 = this.f3117g.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - B.p(this)) - i4) - this.f3114d) - B.q(this)) / 2;
            if (a()) {
                measuredWidth = -measuredWidth;
            }
            if (this.f3119i != measuredWidth) {
                this.f3119i = measuredWidth;
                c();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f3113c.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!b()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            this.f3113c.h();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? b.a.a.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f3113c.b(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f3117g != drawable) {
            this.f3117g = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.f3120j = i2;
    }

    public void setIconPadding(int i2) {
        if (this.f3114d != i2) {
            this.f3114d = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? b.a.a.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f3118h != i2) {
            this.f3118h = i2;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f3116f != colorStateList) {
            this.f3116f = colorStateList;
            c();
        }
    }

    public void setIconTintMode(Mode mode) {
        if (this.f3115e != mode) {
            this.f3115e = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(b.a.a.a.a.a(getContext(), i2));
    }

    /* access modifiers changed from: 0000 */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f3113c.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(b.a.a.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f3113c.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(b.a.a.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f3113c.c(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f3113c.c(colorStateList);
        } else if (this.f3113c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (b()) {
            this.f3113c.a(mode);
        } else if (this.f3113c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray a2 = l.a(context, attributeSet, k.MaterialButton, i2, c.b.a.c.j.Widget_MaterialComponents_Button, new int[0]);
        this.f3114d = a2.getDimensionPixelSize(k.MaterialButton_iconPadding, 0);
        this.f3115e = m.a(a2.getInt(k.MaterialButton_iconTintMode, -1), Mode.SRC_IN);
        this.f3116f = c.b.a.c.h.a.a(getContext(), a2, k.MaterialButton_iconTint);
        this.f3117g = c.b.a.c.h.a.b(getContext(), a2, k.MaterialButton_icon);
        this.f3120j = a2.getInteger(k.MaterialButton_iconGravity, 1);
        this.f3118h = a2.getDimensionPixelSize(k.MaterialButton_iconSize, 0);
        this.f3113c = new c(this);
        this.f3113c.a(a2);
        a2.recycle();
        setCompoundDrawablePadding(this.f3114d);
        c();
    }
}
