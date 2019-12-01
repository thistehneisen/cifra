package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.i.B;
import b.g.i.C0240a;
import b.g.i.r;
import c.b.a.c.h;
import c.b.a.c.k;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.l;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a reason: collision with root package name */
    static final Handler f6495a = new Handler(Looper.getMainLooper(), new c());
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final boolean f6496b;

    /* renamed from: c reason: collision with root package name */
    private static final int[] f6497c = {c.b.a.c.b.snackbarStyle};

    /* renamed from: d reason: collision with root package name */
    private final ViewGroup f6498d;

    /* renamed from: e reason: collision with root package name */
    private final Context f6499e;

    /* renamed from: f reason: collision with root package name */
    protected final e f6500f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final n f6501g;

    /* renamed from: h reason: collision with root package name */
    private int f6502h;

    /* renamed from: i reason: collision with root package name */
    private List<a<B>> f6503i;

    /* renamed from: j reason: collision with root package name */
    private Behavior f6504j;

    /* renamed from: k reason: collision with root package name */
    private final AccessibilityManager f6505k;

    /* renamed from: l reason: collision with root package name */
    final a f6506l = new f(this);

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k reason: collision with root package name */
        private final b f6507k = new b(this);

        /* access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f6507k.a(baseTransientBottomBar);
        }

        public boolean a(View view) {
            return this.f6507k.a(view);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f6507k.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, view, motionEvent);
        }
    }

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i2) {
        }
    }

    public static class b {

        /* renamed from: a reason: collision with root package name */
        private a f6508a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.b(0.1f);
            swipeDismissBehavior.a(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f6508a = baseTransientBottomBar.f6506l;
        }

        public boolean a(View view) {
            return view instanceof e;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    q.a().e(this.f6508a);
                }
            } else if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                q.a().d(this.f6508a);
            }
        }
    }

    protected interface c {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    protected interface d {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    protected static class e extends FrameLayout {

        /* renamed from: a reason: collision with root package name */
        private final AccessibilityManager f6509a;

        /* renamed from: b reason: collision with root package name */
        private final b.g.i.a.c.a f6510b;

        /* renamed from: c reason: collision with root package name */
        private d f6511c;

        /* renamed from: d reason: collision with root package name */
        private c f6512d;

        protected e(Context context) {
            this(context, null);
        }

        /* access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.f6512d;
            if (cVar != null) {
                cVar.onViewAttachedToWindow(this);
            }
            B.H(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.f6512d;
            if (cVar != null) {
                cVar.onViewDetachedFromWindow(this);
            }
            b.g.i.a.c.b(this.f6509a, this.f6510b);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            d dVar = this.f6511c;
            if (dVar != null) {
                dVar.a(this, i2, i3, i4, i5);
            }
        }

        /* access modifiers changed from: 0000 */
        public void setOnAttachStateChangeListener(c cVar) {
            this.f6512d = cVar;
        }

        /* access modifiers changed from: 0000 */
        public void setOnLayoutChangeListener(d dVar) {
            this.f6511c = dVar;
        }

        protected e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(k.SnackbarLayout_elevation)) {
                B.b((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.f6509a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f6510b = new m(this);
            b.g.i.a.c.a(this.f6509a, this.f6510b);
            setClickableOrFocusableBasedOnAccessibility(this.f6509a.isTouchExplorationEnabled());
        }
    }

    static {
        int i2 = VERSION.SDK_INT;
        f6496b = i2 >= 16 && i2 <= 19;
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, n nVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (nVar != null) {
            this.f6498d = viewGroup;
            this.f6501g = nVar;
            this.f6499e = viewGroup.getContext();
            l.a(this.f6499e);
            this.f6500f = (e) LayoutInflater.from(this.f6499e).inflate(g(), this.f6498d, false);
            this.f6500f.addView(view);
            B.d((View) this.f6500f, 1);
            B.e((View) this.f6500f, 1);
            B.a((View) this.f6500f, true);
            B.a((View) this.f6500f, (r) new d(this));
            B.a((View) this.f6500f, (C0240a) new e(this));
            this.f6505k = (AccessibilityManager) this.f6499e.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private int n() {
        int height = this.f6500f.getHeight();
        LayoutParams layoutParams = this.f6500f.getLayoutParams();
        return layoutParams instanceof MarginLayoutParams ? height + ((MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        int n = n();
        if (f6496b) {
            B.c((View) this.f6500f, n);
        } else {
            this.f6500f.setTranslationY((float) n);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{n, 0});
        valueAnimator.setInterpolator(c.b.a.c.a.a.f3092b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new k(this));
        valueAnimator.addUpdateListener(new l(this, n));
        valueAnimator.start();
    }

    public void c() {
        a(3);
    }

    public B d(int i2) {
        this.f6502h = i2;
        return this;
    }

    public int e() {
        return this.f6502h;
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> f() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    public int g() {
        return h() ? h.mtrl_layout_snackbar : h.design_layout_snackbar;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        TypedArray obtainStyledAttributes = this.f6499e.obtainStyledAttributes(f6497c);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return q.a().a(this.f6506l);
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        q.a().c(this.f6506l);
        List<a<B>> list = this.f6503i;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((a) this.f6503i.get(size)).a(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean k() {
        List enabledAccessibilityServiceList = this.f6505k.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void l() {
        q.a().a(e(), this.f6506l);
    }

    /* access modifiers changed from: 0000 */
    public final void m() {
        if (this.f6500f.getParent() == null) {
            LayoutParams layoutParams = this.f6500f.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e) {
                androidx.coordinatorlayout.widget.CoordinatorLayout.e eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) layoutParams;
                SwipeDismissBehavior swipeDismissBehavior = this.f6504j;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = f();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).a(this);
                }
                swipeDismissBehavior.a((com.google.android.material.behavior.SwipeDismissBehavior.a) new g(this));
                eVar.a((androidx.coordinatorlayout.widget.CoordinatorLayout.b) swipeDismissBehavior);
                eVar.f1227g = 80;
            }
            this.f6498d.addView(this.f6500f);
        }
        this.f6500f.setOnAttachStateChangeListener(new i(this));
        if (!B.C(this.f6500f)) {
            this.f6500f.setOnLayoutChangeListener(new j(this));
        } else if (k()) {
            b();
        } else {
            j();
        }
    }

    private void e(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, n()});
        valueAnimator.setInterpolator(c.b.a.c.a.a.f3092b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new a(this, i2));
        valueAnimator.addUpdateListener(new b(this));
        valueAnimator.start();
    }

    /* access modifiers changed from: 0000 */
    public void c(int i2) {
        q.a().b(this.f6506l);
        List<a<B>> list = this.f6503i;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((a) this.f6503i.get(size)).a(this, i2);
            }
        }
        ViewParent parent = this.f6500f.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f6500f);
        }
    }

    public Context d() {
        return this.f6499e;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        q.a().a(this.f6506l, i2);
    }

    /* access modifiers changed from: 0000 */
    public final void b(int i2) {
        if (!k() || this.f6500f.getVisibility() != 0) {
            c(i2);
        } else {
            e(i2);
        }
    }
}
