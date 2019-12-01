package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;

/* compiled from: WrappedDrawableState */
final class f extends ConstantState {

    /* renamed from: a reason: collision with root package name */
    int f1324a;

    /* renamed from: b reason: collision with root package name */
    ConstantState f1325b;

    /* renamed from: c reason: collision with root package name */
    ColorStateList f1326c = null;

    /* renamed from: d reason: collision with root package name */
    Mode f1327d = d.f1316a;

    f(f fVar) {
        if (fVar != null) {
            this.f1324a = fVar.f1324a;
            this.f1325b = fVar.f1325b;
            this.f1326c = fVar.f1326c;
            this.f1327d = fVar.f1327d;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a() {
        return this.f1325b != null;
    }

    public int getChangingConfigurations() {
        int i2 = this.f1324a;
        ConstantState constantState = this.f1325b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        if (VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }
}
