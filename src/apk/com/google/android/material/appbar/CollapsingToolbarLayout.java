package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.widget.Toolbar;
import b.a.i;
import b.g.i.B;
import b.g.i.O;
import b.g.i.r;
import c.b.a.c.j;
import c.b.a.c.k;
import com.google.android.material.appbar.AppBarLayout.c;
import com.google.android.material.internal.e;
import com.google.android.material.internal.f;
import com.google.android.material.internal.l;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    private boolean f6256a;

    /* renamed from: b reason: collision with root package name */
    private int f6257b;

    /* renamed from: c reason: collision with root package name */
    private Toolbar f6258c;

    /* renamed from: d reason: collision with root package name */
    private View f6259d;

    /* renamed from: e reason: collision with root package name */
    private View f6260e;

    /* renamed from: f reason: collision with root package name */
    private int f6261f;

    /* renamed from: g reason: collision with root package name */
    private int f6262g;

    /* renamed from: h reason: collision with root package name */
    private int f6263h;

    /* renamed from: i reason: collision with root package name */
    private int f6264i;

    /* renamed from: j reason: collision with root package name */
    private final Rect f6265j;

    /* renamed from: k reason: collision with root package name */
    final e f6266k;

    /* renamed from: l reason: collision with root package name */
    private boolean f6267l;
    private boolean m;
    private Drawable n;
    Drawable o;
    private int p;
    private boolean q;
    private ValueAnimator r;
    private long s;
    private int t;
    private c u;
    int v;
    O w;

    public static class a extends LayoutParams {

        /* renamed from: a reason: collision with root package name */
        int f6268a = 0;

        /* renamed from: b reason: collision with root package name */
        float f6269b = 0.5f;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.CollapsingToolbarLayout_Layout);
            this.f6268a = obtainStyledAttributes.getInt(k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.f6269b = f2;
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class b implements c {
        b() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.v = i2;
            O o = collapsingToolbarLayout.w;
            int e2 = o != null ? o.e() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                a aVar = (a) childAt.getLayoutParams();
                i b2 = CollapsingToolbarLayout.b(childAt);
                int i4 = aVar.f6268a;
                if (i4 == 1) {
                    b2.b(b.g.e.a.a(-i2, 0, CollapsingToolbarLayout.this.a(childAt)));
                } else if (i4 == 2) {
                    b2.b(Math.round(((float) (-i2)) * aVar.f6269b));
                }
            }
            CollapsingToolbarLayout.this.a();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.o != null && e2 > 0) {
                B.G(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.f6266k.a(((float) Math.abs(i2)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - B.n(CollapsingToolbarLayout.this)) - e2)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void b() {
        if (this.f6256a) {
            Toolbar toolbar = null;
            this.f6258c = null;
            this.f6259d = null;
            int i2 = this.f6257b;
            if (i2 != -1) {
                this.f6258c = (Toolbar) findViewById(i2);
                Toolbar toolbar2 = this.f6258c;
                if (toolbar2 != null) {
                    this.f6259d = c(toolbar2);
                }
            }
            if (this.f6258c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.f6258c = toolbar;
            }
            d();
            this.f6256a = false;
        }
    }

    private View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private void d() {
        if (!this.f6267l) {
            View view = this.f6260e;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f6260e);
                }
            }
        }
        if (this.f6267l && this.f6258c != null) {
            if (this.f6260e == null) {
                this.f6260e = new View(getContext());
            }
            if (this.f6260e.getParent() == null) {
                this.f6258c.addView(this.f6260e, -1, -1);
            }
        }
    }

    private boolean e(View view) {
        View view2 = this.f6259d;
        if (view2 == null || view2 == this) {
            if (view == this.f6258c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public O a(O o2) {
        O o3 = B.j(this) ? o2 : null;
        if (!b.g.h.c.a(this.w, o3)) {
            this.w = o3;
            requestLayout();
        }
        return o2.a();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        b();
        if (this.f6258c == null) {
            Drawable drawable = this.n;
            if (drawable != null && this.p > 0) {
                drawable.mutate().setAlpha(this.p);
                this.n.draw(canvas);
            }
        }
        if (this.f6267l && this.m) {
            this.f6266k.a(canvas);
        }
        if (this.o != null && this.p > 0) {
            O o2 = this.w;
            int e2 = o2 != null ? o2.e() : 0;
            if (e2 > 0) {
                this.o.setBounds(0, -this.v, getWidth(), e2 - this.v);
                this.o.mutate().setAlpha(this.p);
                this.o.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.n == null || this.p <= 0 || !e(view)) {
            z = false;
        } else {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j2) || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        e eVar = this.f6266k;
        if (eVar != null) {
            z |= eVar.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.f6266k.a();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f6266k.b();
    }

    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.f6266k.d();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f6264i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f6263h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f6261f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f6262g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f6266k.e();
    }

    /* access modifiers changed from: 0000 */
    public int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.t;
        if (i2 >= 0) {
            return i2;
        }
        O o2 = this.w;
        int e2 = o2 != null ? o2.e() : 0;
        int n2 = B.n(this);
        if (n2 > 0) {
            return Math.min((n2 * 2) + e2, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.o;
    }

    public CharSequence getTitle() {
        if (this.f6267l) {
            return this.f6266k.f();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            B.a((View) this, B.j((View) parent));
            if (this.u == null) {
                this.u = new b();
            }
            ((AppBarLayout) parent).a(this.u);
            B.H(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        c cVar = this.u;
        if (cVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(cVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        O o2 = this.w;
        if (o2 != null) {
            int e2 = o2.e();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!B.j(childAt) && childAt.getTop() < e2) {
                    B.c(childAt, e2);
                }
            }
        }
        if (this.f6267l) {
            View view = this.f6260e;
            if (view != null) {
                boolean z2 = true;
                this.m = B.B(view) && this.f6260e.getVisibility() == 0;
                if (this.m) {
                    if (B.m(this) != 1) {
                        z2 = false;
                    }
                    View view2 = this.f6259d;
                    if (view2 == null) {
                        view2 = this.f6258c;
                    }
                    int a2 = a(view2);
                    f.a((ViewGroup) this, this.f6260e, this.f6265j);
                    this.f6266k.a(this.f6265j.left + (z2 ? this.f6258c.getTitleMarginEnd() : this.f6258c.getTitleMarginStart()), this.f6265j.top + a2 + this.f6258c.getTitleMarginTop(), this.f6265j.right + (z2 ? this.f6258c.getTitleMarginStart() : this.f6258c.getTitleMarginEnd()), (this.f6265j.bottom + a2) - this.f6258c.getTitleMarginBottom());
                    this.f6266k.b(z2 ? this.f6263h : this.f6261f, this.f6265j.top + this.f6262g, (i4 - i2) - (z2 ? this.f6261f : this.f6263h), (i5 - i3) - this.f6264i);
                    this.f6266k.i();
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            b(getChildAt(i7)).c();
        }
        if (this.f6258c != null) {
            if (this.f6267l && TextUtils.isEmpty(this.f6266k.f())) {
                setTitle(this.f6258c.getTitle());
            }
            View view3 = this.f6259d;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f6258c));
            } else {
                setMinimumHeight(d(view3));
            }
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = MeasureSpec.getMode(i3);
        O o2 = this.w;
        int e2 = o2 != null ? o2.e() : 0;
        if (mode == 0 && e2 > 0) {
            super.onMeasure(i2, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + e2, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f6266k.b(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f6266k.a(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f6266k.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.n = drawable3;
            Drawable drawable4 = this.n;
            if (drawable4 != null) {
                drawable4.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            B.G(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(b.g.a.a.c(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f6266k.d(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f6264i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f6263h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f6261f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f6262g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f6266k.c(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f6266k.b(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f6266k.b(typeface);
    }

    /* access modifiers changed from: 0000 */
    public void setScrimAlpha(int i2) {
        if (i2 != this.p) {
            if (this.n != null) {
                Toolbar toolbar = this.f6258c;
                if (toolbar != null) {
                    B.G(toolbar);
                }
            }
            this.p = i2;
            B.G(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.s = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.t != i2) {
            this.t = i2;
            a();
        }
    }

    public void setScrimsShown(boolean z) {
        a(z, B.C(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            Drawable drawable4 = this.o;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.o, B.m(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            B.G(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(b.g.a.a.c(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.f6266k.a(charSequence);
        c();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f6267l) {
            this.f6267l = z;
            c();
            d();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.o.setVisible(z, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.n.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f6266k.a(colorStateList);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6256a = true;
        this.f6265j = new Rect();
        this.t = -1;
        this.f6266k = new e(this);
        this.f6266k.a(c.b.a.c.a.a.f3095e);
        TypedArray a2 = l.a(context, attributeSet, k.CollapsingToolbarLayout, i2, j.Widget_Design_CollapsingToolbar, new int[0]);
        this.f6266k.d(a2.getInt(k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f6266k.b(a2.getInt(k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f6264i = dimensionPixelSize;
        this.f6263h = dimensionPixelSize;
        this.f6262g = dimensionPixelSize;
        this.f6261f = dimensionPixelSize;
        if (a2.hasValue(k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f6261f = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a2.hasValue(k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f6263h = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a2.hasValue(k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f6262g = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a2.hasValue(k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f6264i = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f6267l = a2.getBoolean(k.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a2.getText(k.CollapsingToolbarLayout_title));
        this.f6266k.c(j.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f6266k.a(i.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a2.hasValue(k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f6266k.c(a2.getResourceId(k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a2.hasValue(k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f6266k.a(a2.getResourceId(k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.t = a2.getDimensionPixelSize(k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.s = (long) a2.getInt(k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(a2.getDrawable(k.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a2.getDrawable(k.CollapsingToolbarLayout_statusBarScrim));
        this.f6257b = a2.getResourceId(k.CollapsingToolbarLayout_toolbarId, -1);
        a2.recycle();
        setWillNotDraw(false);
        B.a((View) this, (r) new d(this));
    }

    /* access modifiers changed from: protected */
    public a generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private void c() {
        setContentDescription(getTitle());
    }

    public void a(boolean z, boolean z2) {
        if (this.q != z) {
            int i2 = 255;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.q = z;
        }
    }

    private void a(int i2) {
        b();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator == null) {
            this.r = new ValueAnimator();
            this.r.setDuration(this.s);
            this.r.setInterpolator(i2 > this.p ? c.b.a.c.a.a.f3093c : c.b.a.c.a.a.f3094d);
            this.r.addUpdateListener(new e(this));
        } else if (valueAnimator.isRunning()) {
            this.r.cancel();
        }
        this.r.setIntValues(new int[]{this.p, i2});
        this.r.start();
    }

    private static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static i b(View view) {
        i iVar = (i) view.getTag(c.b.a.c.f.view_offset_helper);
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(view);
        view.setTag(c.b.a.c.f.view_offset_helper, iVar2);
        return iVar2;
    }

    /* access modifiers changed from: 0000 */
    public final void a() {
        if (this.n != null || this.o != null) {
            setScrimsShown(getHeight() + this.v < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: 0000 */
    public final int a(View view) {
        return ((getHeight() - b(view).a()) - view.getHeight()) - ((a) view.getLayoutParams()).bottomMargin;
    }
}
