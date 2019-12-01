package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.core.widget.j;
import b.a.a.a.a;
import b.g.i.v;

/* renamed from: androidx.appcompat.widget.i reason: case insensitive filesystem */
/* compiled from: AppCompatAutoCompleteTextView */
public class C0169i extends AutoCompleteTextView implements v {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f973a = {16843126};

    /* renamed from: b reason: collision with root package name */
    private final C0170j f974b;

    /* renamed from: c reason: collision with root package name */
    private final G f975c;

    public C0169i(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f974b;
        if (jVar != null) {
            jVar.a();
        }
        G g2 = this.f975c;
        if (g2 != null) {
            g2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f974b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f974b;
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
        C0170j jVar = this.f974b;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f974b;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b(getContext(), i2));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f974b;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f974b;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.f975c;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public C0169i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.autoCompleteTextViewStyle);
    }

    public C0169i(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        sa a2 = sa.a(getContext(), attributeSet, f973a, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f974b = new C0170j(this);
        this.f974b.a(attributeSet, i2);
        this.f975c = new G(this);
        this.f975c.a(attributeSet, i2);
        this.f975c.a();
    }
}
