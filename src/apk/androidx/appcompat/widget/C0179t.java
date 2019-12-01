package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import b.a.a;
import b.g.i.v;

/* renamed from: androidx.appcompat.widget.t reason: case insensitive filesystem */
/* compiled from: AppCompatMultiAutoCompleteTextView */
public class C0179t extends MultiAutoCompleteTextView implements v {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1044a = {16843126};

    /* renamed from: b reason: collision with root package name */
    private final C0170j f1045b;

    /* renamed from: c reason: collision with root package name */
    private final G f1046c;

    public C0179t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            jVar.a();
        }
        G g2 = this.f1046c;
        if (g2 != null) {
            g2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0177q.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(b.a.a.a.a.b(getContext(), i2));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f1045b;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.f1046c;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public C0179t(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        sa a2 = sa.a(getContext(), attributeSet, f1044a, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f1045b = new C0170j(this);
        this.f1045b.a(attributeSet, i2);
        this.f1046c = new G(this);
        this.f1046c.a(attributeSet, i2);
        this.f1046c.a();
    }
}
