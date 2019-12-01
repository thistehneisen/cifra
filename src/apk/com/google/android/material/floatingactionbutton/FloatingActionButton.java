package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.C0175o;
import androidx.appcompat.widget.C0178s;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.widget.l;
import b.g.i.B;
import b.g.i.v;
import c.b.a.c.a.h;
import c.b.a.c.d;
import c.b.a.c.j;
import c.b.a.c.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.f;
import com.google.android.material.internal.m;
import com.google.android.material.internal.n;
import java.util.List;

@c(Behavior.class)
public class FloatingActionButton extends n implements v, l, c.b.a.c.f.a {

    /* renamed from: b reason: collision with root package name */
    private ColorStateList f6405b;

    /* renamed from: c reason: collision with root package name */
    private Mode f6406c;

    /* renamed from: d reason: collision with root package name */
    private ColorStateList f6407d;

    /* renamed from: e reason: collision with root package name */
    private Mode f6408e;

    /* renamed from: f reason: collision with root package name */
    private int f6409f;

    /* renamed from: g reason: collision with root package name */
    private ColorStateList f6410g;

    /* renamed from: h reason: collision with root package name */
    private int f6411h;

    /* renamed from: i reason: collision with root package name */
    private int f6412i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public int f6413j;

    /* renamed from: k reason: collision with root package name */
    private int f6414k;

    /* renamed from: l reason: collision with root package name */
    boolean f6415l;
    final Rect m;
    private final Rect n;
    private final C0178s o;
    private final c.b.a.c.f.c p;
    private e q;

    protected static class BaseBehavior<T extends FloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b<T> {

        /* renamed from: a reason: collision with root package name */
        private Rect f6416a;

        /* renamed from: b reason: collision with root package name */
        private a f6417b;

        /* renamed from: c reason: collision with root package name */
        private boolean f6418c;

        public BaseBehavior() {
            this.f6418c = true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.a(this.f6417b, false);
            } else {
                floatingActionButton.b(this.f6417b, false);
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.FloatingActionButton_Behavior_Layout);
            this.f6418c = obtainStyledAttributes.getBoolean(k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void a(e eVar) {
            if (eVar.f1228h == 0) {
                eVar.f1228h = 80;
            }
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (a(view)) {
                b(view, floatingActionButton);
            }
            return false;
        }

        private static boolean a(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof e) {
                return ((e) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            e eVar = (e) floatingActionButton.getLayoutParams();
            if (this.f6418c && eVar.c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f6416a == null) {
                this.f6416a = new Rect();
            }
            Rect rect = this.f6416a;
            f.a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.a(this.f6417b, false);
            } else {
                floatingActionButton.b(this.f6417b, false);
            }
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List b2 = coordinatorLayout.b((View) floatingActionButton);
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) b2.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.c((View) floatingActionButton, i2);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.m;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                e eVar = (e) floatingActionButton.getLayoutParams();
                int i2 = 0;
                int i3 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin ? rect.right : floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    B.c((View) floatingActionButton, i2);
                }
                if (i3 != 0) {
                    B.b((View) floatingActionButton, i3);
                }
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ void a(e eVar) {
            super.a(eVar);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.a(coordinatorLayout, floatingActionButton, i2);
        }
    }

    public static abstract class a {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    private class b implements c.b.a.c.j.b {
        b() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.m.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f6413j, i3 + FloatingActionButton.this.f6413j, i4 + FloatingActionButton.this.f6413j, i5 + FloatingActionButton.this.f6413j);
        }

        public float b() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        public boolean a() {
            return FloatingActionButton.this.f6415l;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private e e() {
        if (VERSION.SDK_INT >= 21) {
            return new f(this, new b());
        }
        return new e(this, new b());
    }

    private void f() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f6407d;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.b(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            Mode mode = this.f6408e;
            if (mode == null) {
                mode = Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(C0175o.a(colorForState, mode));
        }
    }

    private e getImpl() {
        if (this.q == null) {
            this.q = e();
        }
        return this.q;
    }

    public void b(a aVar) {
        b(aVar, true);
    }

    public void c(AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void d() {
        b((a) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f6405b;
    }

    public Mode getBackgroundTintMode() {
        return this.f6406c;
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f();
    }

    public Drawable getContentBackground() {
        return getImpl().b();
    }

    public int getCustomSize() {
        return this.f6412i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.a();
    }

    public h getHideMotionSpec() {
        return getImpl().d();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f6410g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f6410g;
    }

    public h getShowMotionSpec() {
        return getImpl().g();
    }

    public int getSize() {
        return this.f6411h;
    }

    /* access modifiers changed from: 0000 */
    public int getSizeDimension() {
        return a(this.f6411h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f6407d;
    }

    public Mode getSupportImageTintMode() {
        return this.f6408e;
    }

    public boolean getUseCompatPadding() {
        return this.f6415l;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().o();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f6413j = (sizeDimension - this.f6414k) / 2;
        getImpl().s();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c.b.a.c.l.b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c.b.a.c.l.b bVar = (c.b.a.c.l.b) parcelable;
        super.onRestoreInstanceState(bVar.n());
        this.p.a((Bundle) bVar.f3184c.get("expandableWidgetHelper"));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        c.b.a.c.l.b bVar = new c.b.a.c.l.b(super.onSaveInstanceState());
        bVar.f3184c.put("expandableWidgetHelper", this.p.c());
        return bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a(this.n) || this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f6405b != colorStateList) {
            this.f6405b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f6406c != mode) {
            this.f6406c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.f6412i = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i2) {
        this.p.a(i2);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().r();
    }

    public void setImageResource(int i2) {
        this.o.a(i2);
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f6412i = 0;
        if (i2 != this.f6411h) {
            this.f6411h = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f6407d != colorStateList) {
            this.f6407d = colorStateList;
            f();
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f6408e != mode) {
            this.f6408e = mode;
            f();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f6415l != z) {
            this.f6415l = z;
            getImpl().n();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.b.a.c.b.floatingActionButtonStyle);
    }

    private d c(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(this, aVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar, boolean z) {
        getImpl().b(c(aVar), z);
    }

    public void d(AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f6410g != colorStateList) {
            this.f6410g = colorStateList;
            getImpl().b(this.f6410g);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new Rect();
        this.n = new Rect();
        TypedArray a2 = com.google.android.material.internal.l.a(context, attributeSet, k.FloatingActionButton, i2, j.Widget_Design_FloatingActionButton, new int[0]);
        this.f6405b = c.b.a.c.h.a.a(context, a2, k.FloatingActionButton_backgroundTint);
        this.f6406c = m.a(a2.getInt(k.FloatingActionButton_backgroundTintMode, -1), null);
        this.f6410g = c.b.a.c.h.a.a(context, a2, k.FloatingActionButton_rippleColor);
        this.f6411h = a2.getInt(k.FloatingActionButton_fabSize, -1);
        this.f6412i = a2.getDimensionPixelSize(k.FloatingActionButton_fabCustomSize, 0);
        this.f6409f = a2.getDimensionPixelSize(k.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = a2.getDimension(k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = a2.getDimension(k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f6415l = a2.getBoolean(k.FloatingActionButton_useCompatPadding, false);
        this.f6414k = a2.getDimensionPixelSize(k.FloatingActionButton_maxImageSize, 0);
        h a3 = h.a(context, a2, k.FloatingActionButton_showMotionSpec);
        h a4 = h.a(context, a2, k.FloatingActionButton_hideMotionSpec);
        a2.recycle();
        this.o = new C0178s(this);
        this.o.a(attributeSet, i2);
        this.p = new c.b.a.c.f.c(this);
        getImpl().a(this.f6405b, this.f6406c, this.f6410g, this.f6409f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.f6414k);
        getImpl().b(a3);
        getImpl().a(a4);
        setScaleType(ScaleType.MATRIX);
    }

    public void a(a aVar) {
        a(aVar, true);
    }

    public void b(AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public boolean c() {
        return getImpl().i();
    }

    private void c(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar, boolean z) {
        getImpl().a(c(aVar), z);
    }

    public void b() {
        a((a) null);
    }

    public void a(AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    public boolean a() {
        return this.p.b();
    }

    private int a(int i2) {
        int i3;
        int i4 = this.f6412i;
        if (i4 != 0) {
            return i4;
        }
        Resources resources = getResources();
        if (i2 == -1) {
            if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                i3 = a(1);
            } else {
                i3 = a(0);
            }
            return i3;
        } else if (i2 != 1) {
            return resources.getDimensionPixelSize(d.design_fab_size_normal);
        } else {
            return resources.getDimensionPixelSize(d.design_fab_size_mini);
        }
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!B.C(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    private static int a(int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }
}
