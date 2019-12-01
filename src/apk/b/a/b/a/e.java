package b.a.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.core.graphics.drawable.a;

/* compiled from: DrawableWrapper */
public class e extends Drawable implements Callback {

    /* renamed from: a reason: collision with root package name */
    private Drawable f2183a;

    public e(Drawable drawable) {
        a(drawable);
    }

    public Drawable a() {
        return this.f2183a;
    }

    public void draw(Canvas canvas) {
        this.f2183a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f2183a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f2183a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2183a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2183a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f2183a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2183a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2183a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2183a.getPadding(rect);
    }

    public int[] getState() {
        return this.f2183a.getState();
    }

    public Region getTransparentRegion() {
        return this.f2183a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.f(this.f2183a);
    }

    public boolean isStateful() {
        return this.f2183a.isStateful();
    }

    public void jumpToCurrentState() {
        a.g(this.f2183a);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f2183a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f2183a.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f2183a.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        a.a(this.f2183a, z);
    }

    public void setChangingConfigurations(int i2) {
        this.f2183a.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2183a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2183a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2183a.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.f2183a, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        a.a(this.f2183a, i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.f2183a.setState(iArr);
    }

    public void setTint(int i2) {
        a.b(this.f2183a, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.f2183a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        a.a(this.f2183a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2183a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f2183a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2183a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
