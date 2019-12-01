package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21 */
class e extends d {

    /* renamed from: h reason: collision with root package name */
    private static Method f1323h;

    e(Drawable drawable) {
        super(drawable);
        d();
    }

    private void d() {
        if (f1323h == null) {
            try {
                f1323h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1322g;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public Rect getDirtyBounds() {
        return this.f1322g.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f1322g.getOutline(outline);
    }

    public void setHotspot(float f2, float f3) {
        this.f1322g.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f1322g.setHotspotBounds(i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i2) {
        if (b()) {
            super.setTint(i2);
        } else {
            this.f1322g.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f1322g.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f1322g.setTintMode(mode);
        }
    }

    e(f fVar, Resources resources) {
        super(fVar, resources);
        d();
    }
}
