package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: WrappedDrawableApi14 */
class d extends Drawable implements Callback, c, b {

    /* renamed from: a reason: collision with root package name */
    static final Mode f1316a = Mode.SRC_IN;

    /* renamed from: b reason: collision with root package name */
    private int f1317b;

    /* renamed from: c reason: collision with root package name */
    private Mode f1318c;

    /* renamed from: d reason: collision with root package name */
    private boolean f1319d;

    /* renamed from: e reason: collision with root package name */
    f f1320e;

    /* renamed from: f reason: collision with root package name */
    private boolean f1321f;

    /* renamed from: g reason: collision with root package name */
    Drawable f1322g;

    d(f fVar, Resources resources) {
        this.f1320e = fVar;
        a(resources);
    }

    private void a(Resources resources) {
        f fVar = this.f1320e;
        if (fVar != null) {
            ConstantState constantState = fVar.f1325b;
            if (constantState != null) {
                a(constantState.newDrawable(resources));
            }
        }
    }

    private f c() {
        return new f(this.f1320e);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f1322g.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f1320e;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f1322g.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        f fVar = this.f1320e;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f1320e.f1324a = getChangingConfigurations();
        return this.f1320e;
    }

    public Drawable getCurrent() {
        return this.f1322g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1322g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1322g.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1322g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1322g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1322g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1322g.getPadding(rect);
    }

    public int[] getState() {
        return this.f1322g.getState();
    }

    public Region getTransparentRegion() {
        return this.f1322g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f1322g.isAutoMirrored();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (b()) {
            f fVar = this.f1320e;
            if (fVar != null) {
                colorStateList = fVar.f1326c;
                return (colorStateList == null && colorStateList.isStateful()) || this.f1322g.isStateful();
            }
        }
        colorStateList = null;
        if (colorStateList == null) {
        }
    }

    public void jumpToCurrentState() {
        this.f1322g.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f1321f && super.mutate() == this) {
            this.f1320e = c();
            Drawable drawable = this.f1322g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f1320e;
            if (fVar != null) {
                Drawable drawable2 = this.f1322g;
                fVar.f1325b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1321f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1322g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f1322g.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f1322g.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.f1322g.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.f1322g.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1322g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1322g.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1322g.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || this.f1322g.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1320e.f1326c = colorStateList;
        a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f1320e.f1327d = mode;
        a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1322g.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        f fVar = this.f1320e;
        ColorStateList colorStateList = fVar.f1326c;
        Mode mode = fVar.f1327d;
        if (colorStateList == null || mode == null) {
            this.f1319d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1319d && colorForState == this.f1317b && mode == this.f1318c)) {
                setColorFilter(colorForState, mode);
                this.f1317b = colorForState;
                this.f1318c = mode;
                this.f1319d = true;
                return true;
            }
        }
        return false;
    }

    d(Drawable drawable) {
        this.f1320e = c();
        a(drawable);
    }

    public final Drawable a() {
        return this.f1322g;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1322g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1322g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f1320e;
            if (fVar != null) {
                fVar.f1325b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
