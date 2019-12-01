package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.j;
import b.a.a;
import b.g.i.v;

/* renamed from: androidx.appcompat.widget.p reason: case insensitive filesystem */
/* compiled from: AppCompatEditText */
public class C0176p extends EditText implements v {

    /* renamed from: a reason: collision with root package name */
    private final C0170j f1024a;

    /* renamed from: b reason: collision with root package name */
    private final G f1025b;

    public C0176p(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            jVar.a();
        }
        G g2 = this.f1025b;
        if (g2 != null) {
            g2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f1024a;
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
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f1024a;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.f1025b;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public C0176p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public Editable getText() {
        if (VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public C0176p(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.f1024a = new C0170j(this);
        this.f1024a.a(attributeSet, i2);
        this.f1025b = new G(this);
        this.f1025b.a(attributeSet, i2);
        this.f1025b.a();
    }
}
