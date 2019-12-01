package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.k;
import b.a.a;

/* renamed from: androidx.appcompat.widget.w reason: case insensitive filesystem */
/* compiled from: AppCompatRadioButton */
public class C0182w extends RadioButton implements k {

    /* renamed from: a reason: collision with root package name */
    private final C0174n f1055a;

    /* renamed from: b reason: collision with root package name */
    private final G f1056b;

    public C0182w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0174n nVar = this.f1055a;
        return nVar != null ? nVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        C0174n nVar = this.f1055a;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public Mode getSupportButtonTintMode() {
        C0174n nVar = this.f1055a;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0174n nVar = this.f1055a;
        if (nVar != null) {
            nVar.d();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0174n nVar = this.f1055a;
        if (nVar != null) {
            nVar.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        C0174n nVar = this.f1055a;
        if (nVar != null) {
            nVar.a(mode);
        }
    }

    public C0182w(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.f1055a = new C0174n(this);
        this.f1055a.a(attributeSet, i2);
        this.f1056b = new G(this);
        this.f1056b.a(attributeSet, i2);
    }

    public void setButtonDrawable(int i2) {
        setButtonDrawable(b.a.a.a.a.b(getContext(), i2));
    }
}
