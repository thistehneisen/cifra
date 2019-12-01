package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.core.widget.j;
import b.a.a.a.a;

/* renamed from: androidx.appcompat.widget.m reason: case insensitive filesystem */
/* compiled from: AppCompatCheckedTextView */
public class C0173m extends CheckedTextView {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f994a = {16843016};

    /* renamed from: b reason: collision with root package name */
    private final G f995b;

    public C0173m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        G g2 = this.f995b;
        if (g2 != null) {
            g2.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0177q.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.b(getContext(), i2));
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.f995b;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public C0173m(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.f995b = new G(this);
        this.f995b.a(attributeSet, i2);
        this.f995b.a();
        sa a2 = sa.a(getContext(), attributeSet, f994a, i2, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.a();
    }
}
