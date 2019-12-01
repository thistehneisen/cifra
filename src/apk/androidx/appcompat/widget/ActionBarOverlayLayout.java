package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import b.a.f;
import b.g.i.B;
import b.g.i.p;
import b.g.i.q;

public class ActionBarOverlayLayout extends ViewGroup implements I, p {

    /* renamed from: a reason: collision with root package name */
    static final int[] f714a = {b.a.a.actionBarSize, 16842841};
    private final Runnable A;
    private final q B;

    /* renamed from: b reason: collision with root package name */
    private int f715b;

    /* renamed from: c reason: collision with root package name */
    private int f716c;

    /* renamed from: d reason: collision with root package name */
    private ContentFrameLayout f717d;

    /* renamed from: e reason: collision with root package name */
    ActionBarContainer f718e;

    /* renamed from: f reason: collision with root package name */
    private J f719f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f720g;

    /* renamed from: h reason: collision with root package name */
    private boolean f721h;

    /* renamed from: i reason: collision with root package name */
    private boolean f722i;

    /* renamed from: j reason: collision with root package name */
    private boolean f723j;

    /* renamed from: k reason: collision with root package name */
    private boolean f724k;

    /* renamed from: l reason: collision with root package name */
    boolean f725l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private a v;
    private OverScroller w;
    ViewPropertyAnimator x;
    final AnimatorListenerAdapter y;
    private final Runnable z;

    public interface a {
        void a();

        void a(int i2);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    public static class b extends MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f714a);
        boolean z2 = false;
        this.f715b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f720g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f720g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f721h = z2;
        this.w = new OverScroller(context);
    }

    private void k() {
        a();
        this.A.run();
    }

    private void l() {
        a();
        postDelayed(this.A, 600);
    }

    private void m() {
        a();
        postDelayed(this.z, 600);
    }

    private void n() {
        a();
        this.z.run();
    }

    public boolean b() {
        j();
        return this.f719f.b();
    }

    public void c() {
        j();
        this.f719f.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d() {
        j();
        return this.f719f.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f720g != null && !this.f721h) {
            int bottom = this.f718e.getVisibility() == 0 ? (int) (((float) this.f718e.getBottom()) + this.f718e.getTranslationY() + 0.5f) : 0;
            this.f720g.setBounds(0, bottom, getWidth(), this.f720g.getIntrinsicHeight() + bottom);
            this.f720g.draw(canvas);
        }
    }

    public boolean e() {
        j();
        return this.f719f.e();
    }

    public boolean f() {
        j();
        return this.f719f.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        j();
        int u2 = B.u(this) & 256;
        boolean a2 = a(this.f718e, rect, true, true, false, true);
        this.r.set(rect);
        Ga.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            a2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        j();
        return this.f719f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f718e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        j();
        return this.f719f.getTitle();
    }

    public void h() {
        j();
        this.f719f.h();
    }

    public boolean i() {
        return this.f722i;
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        if (this.f717d == null) {
            this.f717d = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f718e = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f719f = a(findViewById(f.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        B.H(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int i7 = bVar.leftMargin + paddingLeft;
                int i8 = bVar.topMargin + paddingTop;
                childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        j();
        measureChildWithMargins(this.f718e, i2, 0, i3, 0);
        b bVar = (b) this.f718e.getLayoutParams();
        int max = Math.max(0, this.f718e.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f718e.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f718e.getMeasuredState());
        boolean z2 = (B.u(this) & 256) != 0;
        if (z2) {
            i4 = this.f715b;
            if (this.f723j && this.f718e.getTabContainer() != null) {
                i4 += this.f715b;
            }
        } else {
            i4 = this.f718e.getVisibility() != 8 ? this.f718e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.t.set(this.r);
        if (this.f722i || z2) {
            Rect rect = this.t;
            rect.top += i4;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.q;
            rect2.top += i4;
            rect2.bottom += 0;
        }
        a(this.f717d, this.q, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.f717d.a(this.t);
        }
        measureChildWithMargins(this.f717d, i2, 0, i3, 0);
        b bVar2 = (b) this.f717d.getLayoutParams();
        int max3 = Math.max(max, this.f717d.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.f717d.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f717d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f724k || !z2) {
            return false;
        }
        if (a(f2, f3)) {
            k();
        } else {
            n();
        }
        this.f725l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.m += i3;
        setActionBarHideOffset(this.m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.B.a(view, view2, i2);
        this.m = getActionBarHideOffset();
        a();
        a aVar = this.v;
        if (aVar != null) {
            aVar.d();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f718e.getVisibility() != 0) {
            return false;
        }
        return this.f724k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f724k && !this.f725l) {
            if (this.m <= this.f718e.getHeight()) {
                m();
            } else {
                l();
            }
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        j();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(!z2);
            if (z3 || !z2) {
                this.v.a();
            } else {
                this.v.c();
            }
        }
        if ((i3 & 256) != 0 && this.v != null) {
            B.H(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f716c = i2;
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        a();
        this.f718e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f718e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.v = aVar;
        if (getWindowToken() != null) {
            this.v.a(this.f716c);
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                B.H(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f723j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f724k) {
            this.f724k = z2;
            if (!z2) {
                a();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        j();
        this.f719f.setIcon(i2);
    }

    public void setLogo(int i2) {
        j();
        this.f719f.b(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f722i = z2;
        this.f721h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Callback callback) {
        j();
        this.f719f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        j();
        this.f719f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f716c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.y = new C0159d(this);
        this.z = new C0161e(this);
        this.A = new C0163f(this);
        a(context);
        this.B = new q(this);
    }

    /* access modifiers changed from: protected */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        j();
        this.f719f.setIcon(drawable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    private boolean a(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        b bVar = (b) view.getLayoutParams();
        if (z2) {
            int i2 = bVar.leftMargin;
            int i3 = rect.left;
            if (i2 != i3) {
                bVar.leftMargin = i3;
                z6 = true;
                if (z3) {
                    int i4 = bVar.topMargin;
                    int i5 = rect.top;
                    if (i4 != i5) {
                        bVar.topMargin = i5;
                        z6 = true;
                    }
                }
                if (z5) {
                    int i6 = bVar.rightMargin;
                    int i7 = rect.right;
                    if (i6 != i7) {
                        bVar.rightMargin = i7;
                        z6 = true;
                    }
                }
                if (z4) {
                    return z6;
                }
                int i8 = bVar.bottomMargin;
                int i9 = rect.bottom;
                if (i8 == i9) {
                    return z6;
                }
                bVar.bottomMargin = i9;
                return true;
            }
        }
        z6 = false;
        if (z3) {
        }
        if (z5) {
        }
        if (z4) {
        }
    }

    private J a(View view) {
        if (view instanceof J) {
            return (J) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view.getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private boolean a(float f2, float f3) {
        this.w.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.getFinalY() > this.f718e.getHeight();
    }

    public void a(int i2) {
        j();
        if (i2 == 2) {
            this.f719f.n();
        } else if (i2 == 5) {
            this.f719f.o();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void a(Menu menu, androidx.appcompat.view.menu.v.a aVar) {
        j();
        this.f719f.a(menu, aVar);
    }
}
