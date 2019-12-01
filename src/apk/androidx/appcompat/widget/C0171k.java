package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.j;
import b.a.a;
import b.g.i.v;

/* renamed from: androidx.appcompat.widget.k reason: case insensitive filesystem */
/* compiled from: AppCompatButton */
public class C0171k extends Button implements v, b {

    /* renamed from: a reason: collision with root package name */
    private final C0170j f983a;

    /* renamed from: b reason: collision with root package name */
    private final G f984b;

    public C0171k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f983a;
        if (jVar != null) {
            jVar.a();
        }
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1369a) {
            return super.getAutoSizeMaxTextSize();
        }
        G g2 = this.f984b;
        if (g2 != null) {
            return g2.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1369a) {
            return super.getAutoSizeMinTextSize();
        }
        G g2 = this.f984b;
        if (g2 != null) {
            return g2.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1369a) {
            return super.getAutoSizeStepGranularity();
        }
        G g2 = this.f984b;
        if (g2 != null) {
            return g2.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1369a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        G g2 = this.f984b;
        if (g2 != null) {
            return g2.f();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        int i2 = 0;
        if (b.f1369a) {
            if (super.getAutoSizeTextType() == 1) {
                i2 = 1;
            }
            return i2;
        }
        G g2 = this.f984b;
        if (g2 != null) {
            return g2.g();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f983a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f983a;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(z, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        G g2 = this.f984b;
        if (g2 != null && !b.f1369a && g2.h()) {
            this.f984b.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.f1369a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.f1369a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.f1369a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0170j jVar = this.f983a;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f983a;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f983a;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f983a;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        if (b.f1369a) {
            super.setTextSize(i2, f2);
            return;
        }
        G g2 = this.f984b;
        if (g2 != null) {
            g2.a(i2, f2);
        }
    }

    public C0171k(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.f983a = new C0170j(this);
        this.f983a.a(attributeSet, i2);
        this.f984b = new G(this);
        this.f984b.a(attributeSet, i2);
        this.f984b.a();
    }
}
