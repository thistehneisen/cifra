package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.widget.g;
import b.g.i.B;
import b.g.i.C0251l;
import b.g.i.C0252m;
import b.g.i.p;
import b.g.i.q;

public class SwipeRefreshLayout extends ViewGroup implements p, C0251l {

    /* renamed from: a reason: collision with root package name */
    private static final String f2062a = "SwipeRefreshLayout";

    /* renamed from: b reason: collision with root package name */
    private static final int[] f2063b = {16842766};
    protected int A;
    int B;
    int C;
    d D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    private Animation I;
    boolean J;
    private int K;
    boolean L;
    private a M;
    private AnimationListener N;
    private final Animation O;
    private final Animation P;

    /* renamed from: c reason: collision with root package name */
    private View f2064c;

    /* renamed from: d reason: collision with root package name */
    b f2065d;

    /* renamed from: e reason: collision with root package name */
    boolean f2066e;

    /* renamed from: f reason: collision with root package name */
    private int f2067f;

    /* renamed from: g reason: collision with root package name */
    private float f2068g;

    /* renamed from: h reason: collision with root package name */
    private float f2069h;

    /* renamed from: i reason: collision with root package name */
    private final q f2070i;

    /* renamed from: j reason: collision with root package name */
    private final C0252m f2071j;

    /* renamed from: k reason: collision with root package name */
    private final int[] f2072k;

    /* renamed from: l reason: collision with root package name */
    private final int[] f2073l;
    private boolean m;
    private int n;
    int o;
    private float p;
    private float q;
    private boolean r;
    private int s;
    boolean t;
    private boolean u;
    private final DecelerateInterpolator v;
    a w;
    private int x;
    protected int y;
    float z;

    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface b {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f2066e != z2) {
            this.J = z3;
            d();
            this.f2066e = z2;
            if (this.f2066e) {
                a(this.o, this.N);
            } else {
                a(this.N);
            }
        }
    }

    private void c() {
        this.w = new a(getContext(), -328966);
        this.D = new d(getContext());
        this.D.a(1);
        this.w.setImageDrawable(this.D);
        this.w.setVisibility(8);
        addView(this.w);
    }

    private void d() {
        if (this.f2064c == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.w)) {
                    this.f2064c = childAt;
                    return;
                }
            }
        }
    }

    private void e() {
        this.H = a(this.D.getAlpha(), 255);
    }

    private void f() {
        this.G = a(this.D.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i2) {
        this.w.getBackground().setAlpha(i2);
        this.D.setAlpha(i2);
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.w.clearAnimation();
        this.D.stop();
        this.w.setVisibility(8);
        setColorViewAlpha(255);
        if (this.t) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.A - this.o);
        }
        this.o = this.w.getTop();
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f2071j.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2071j.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f2071j.a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2071j.a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.x;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        if (i3 >= i4) {
            i3++;
        }
        return i3;
    }

    public int getNestedScrollAxes() {
        return this.f2070i.a();
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public int getProgressViewEndOffset() {
        return this.B;
    }

    public int getProgressViewStartOffset() {
        return this.A;
    }

    public boolean hasNestedScrollingParent() {
        return this.f2071j.a();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2071j.b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || a() || this.f2066e || this.m) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.s;
                    if (i2 == -1) {
                        Log.e(f2062a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.r = false;
            this.s = -1;
        } else {
            setTargetOffsetTopAndBottom(this.A - this.w.getTop());
            this.s = motionEvent.getPointerId(0);
            this.r = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.q = motionEvent.getY(findPointerIndex2);
        }
        return this.r;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f2064c == null) {
                d();
            }
            View view = this.f2064c;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.w.getMeasuredWidth();
                int measuredHeight2 = this.w.getMeasuredHeight();
                a aVar = this.w;
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = i6 - i7;
                int i9 = this.o;
                aVar.layout(i8, i9, i6 + i7, measuredHeight2 + i9);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2064c == null) {
            d();
        }
        View view = this.f2064c;
        if (view != null) {
            view.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.w.measure(MeasureSpec.makeMeasureSpec(this.K, 1073741824), MeasureSpec.makeMeasureSpec(this.K, 1073741824));
            this.x = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount()) {
                    break;
                } else if (getChildAt(i4) == this.w) {
                    this.x = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f2069h;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f2069h = 0.0f;
                } else {
                    this.f2069h = f2 - f3;
                    iArr[1] = i3;
                }
                c(this.f2069h);
            }
        }
        if (this.L && i3 > 0 && this.f2069h == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.w.setVisibility(8);
        }
        int[] iArr2 = this.f2072k;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.f2073l);
        int i6 = i5 + this.f2073l[1];
        if (i6 < 0 && !a()) {
            this.f2069h += (float) Math.abs(i6);
            c(this.f2069h);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2070i.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f2069h = 0.0f;
        this.m = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.u && !this.f2066e && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f2070i.a(view);
        this.m = false;
        float f2 = this.f2069h;
        if (f2 > 0.0f) {
            b(f2);
            this.f2069h = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || a() || this.f2066e || this.m) {
            return false;
        }
        if (actionMasked == 0) {
            this.s = motionEvent.getPointerId(0);
            this.r = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex < 0) {
                Log.e(f2062a, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.r) {
                float y2 = (motionEvent.getY(findPointerIndex) - this.p) * 0.5f;
                this.r = false;
                b(y2);
            }
            this.s = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex2 < 0) {
                Log.e(f2062a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y3 = motionEvent.getY(findPointerIndex2);
            d(y3);
            if (this.r) {
                float f2 = (y3 - this.p) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                c(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f2062a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (VERSION.SDK_INT >= 21 || !(this.f2064c instanceof AbsListView)) {
            View view = this.f2064c;
            if (view == null || B.D(view)) {
                super.requestDisallowInterceptTouchEvent(z2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAnimationProgress(float f2) {
        this.w.setScaleX(f2);
        this.w.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.D.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = b.g.a.a.a(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f2068g = (float) i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            b();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.f2071j.a(z2);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.M = aVar;
    }

    public void setOnRefreshListener(b bVar) {
        this.f2065d = bVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.w.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(b.g.a.a.a(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.f2066e == z2) {
            a(z2, false);
            return;
        }
        this.f2066e = z2;
        if (!this.L) {
            i2 = this.B + this.A;
        } else {
            i2 = this.B;
        }
        setTargetOffsetTopAndBottom(i2 - this.o);
        this.J = false;
        b(this.N);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.w.setImageDrawable(null);
            this.D.a(i2);
            this.w.setImageDrawable(this.D);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.C = i2;
    }

    /* access modifiers changed from: 0000 */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.w.bringToFront();
        B.c((View) this.w, i2);
        this.o = this.w.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.f2071j.b(i2);
    }

    public void stopNestedScroll() {
        this.f2071j.c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2066e = false;
        this.f2068g = -1.0f;
        this.f2072k = new int[2];
        this.f2073l = new int[2];
        this.s = -1;
        this.x = -1;
        this.N = new e(this);
        this.O = new j(this);
        this.P = new k(this);
        this.f2067f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.v = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        this.B = (int) (displayMetrics.density * 64.0f);
        this.f2068g = (float) this.B;
        this.f2070i = new q(this);
        this.f2071j = new C0252m(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.K;
        this.o = i2;
        this.A = i2;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2063b);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void d(float f2) {
        float f3 = this.q;
        float f4 = f2 - f3;
        int i2 = this.f2067f;
        if (f4 > ((float) i2) && !this.r) {
            this.p = f3 + ((float) i2);
            this.r = true;
            this.D.setAlpha(76);
        }
    }

    private void c(float f2) {
        this.D.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f2068g));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f2068g;
        int i2 = this.C;
        if (i2 <= 0) {
            i2 = this.L ? this.B - this.A : this.B;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.A + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.w.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        if (!this.t) {
            this.w.setScaleX(1.0f);
            this.w.setScaleY(1.0f);
        }
        if (this.t) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f2068g));
        }
        if (f2 < this.f2068g) {
            if (this.D.getAlpha() > 76 && !a(this.G)) {
                f();
            }
        } else if (this.D.getAlpha() < 255 && !a(this.H)) {
            e();
        }
        this.D.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.D.a(Math.min(1.0f, max));
        this.D.b((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.o);
    }

    /* access modifiers changed from: 0000 */
    public void a(AnimationListener animationListener) {
        this.F = new g(this);
        this.F.setDuration(150);
        this.w.a(animationListener);
        this.w.clearAnimation();
        this.w.startAnimation(this.F);
    }

    private void b(AnimationListener animationListener) {
        this.w.setVisibility(0);
        this.D.setAlpha(255);
        this.E = new f(this);
        this.E.setDuration((long) this.n);
        if (animationListener != null) {
            this.w.a(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.E);
    }

    private Animation a(int i2, int i3) {
        h hVar = new h(this, i2, i3);
        hVar.setDuration(300);
        this.w.a(null);
        this.w.clearAnimation();
        this.w.startAnimation(hVar);
        return hVar;
    }

    private void b(float f2) {
        if (f2 > this.f2068g) {
            a(true, true);
            return;
        }
        this.f2066e = false;
        this.D.a(0.0f, 0.0f);
        i iVar = null;
        if (!this.t) {
            iVar = new i(this);
        }
        b(this.o, iVar);
        this.D.a(false);
    }

    public boolean a() {
        a aVar = this.M;
        if (aVar != null) {
            return aVar.a(this, this.f2064c);
        }
        View view = this.f2064c;
        if (view instanceof ListView) {
            return g.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    private boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void a(int i2, AnimationListener animationListener) {
        this.y = i2;
        this.O.reset();
        this.O.setDuration(200);
        this.O.setInterpolator(this.v);
        if (animationListener != null) {
            this.w.a(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.O);
    }

    private void b(int i2, AnimationListener animationListener) {
        if (this.t) {
            c(i2, animationListener);
            return;
        }
        this.y = i2;
        this.P.reset();
        this.P.setDuration(200);
        this.P.setInterpolator(this.v);
        if (animationListener != null) {
            this.w.a(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.P);
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        int i2 = this.y;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.A - i2)) * f2))) - this.w.getTop());
    }

    private void c(int i2, AnimationListener animationListener) {
        this.y = i2;
        this.z = this.w.getScaleX();
        this.I = new l(this);
        this.I.setDuration(150);
        if (animationListener != null) {
            this.w.a(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.I);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.s) {
            this.s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
