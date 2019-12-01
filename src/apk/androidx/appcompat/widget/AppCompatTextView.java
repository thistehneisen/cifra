package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.j;
import b.g.g.c;
import b.g.g.c.a;
import b.g.i.v;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements v, b {
    private final C0170j mBackgroundTintHelper;
    private Future<c> mPrecomputedTextFuture;
    private final G mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                j.a((TextView) this, (c) future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            jVar.a();
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1369a) {
            return super.getAutoSizeMaxTextSize();
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            return g2.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1369a) {
            return super.getAutoSizeMinTextSize();
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            return g2.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1369a) {
            return super.getAutoSizeStepGranularity();
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            return g2.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1369a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        G g2 = this.mTextHelper;
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
        G g2 = this.mTextHelper;
        if (g2 != null) {
            return g2.g();
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return j.a((TextView) this);
    }

    public int getLastBaselineToBottomHeight() {
        return j.b(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public a getTextMetricsParamsCompat() {
        return j.d(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0177q.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(z, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        G g2 = this.mTextHelper;
        if (g2 != null && !b.f1369a && g2.h()) {
            this.mTextHelper.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.f1369a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.f1369a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.f1369a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            j.a((TextView) this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            j.b(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        j.c(this, i2);
    }

    public void setPrecomputedText(c cVar) {
        j.a((TextView) this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.mBackgroundTintHelper;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(context, i2);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.mPrecomputedTextFuture = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(a aVar) {
        j.a((TextView) this, aVar);
    }

    public void setTextSize(int i2, float f2) {
        if (b.f1369a) {
            super.setTextSize(i2, f2);
            return;
        }
        G g2 = this.mTextHelper;
        if (g2 != null) {
            g2.a(i2, f2);
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.mBackgroundTintHelper = new C0170j(this);
        this.mBackgroundTintHelper.a(attributeSet, i2);
        this.mTextHelper = new G(this);
        this.mTextHelper.a(attributeSet, i2);
        this.mTextHelper.a();
    }
}
