package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import b.g.i.B;
import b.g.i.C0240a;
import b.g.i.C0250k;
import b.g.i.C0252m;
import b.g.i.C0254o;
import b.g.i.a.d;
import b.g.i.a.f;
import b.g.i.q;
import b.g.i.u;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements C0254o, C0250k, u {

    /* renamed from: a reason: collision with root package name */
    private static final a f1332a = new a();

    /* renamed from: b reason: collision with root package name */
    private static final int[] f1333b = {16843130};
    private float A;
    private b B;

    /* renamed from: c reason: collision with root package name */
    private long f1334c;

    /* renamed from: d reason: collision with root package name */
    private final Rect f1335d;

    /* renamed from: e reason: collision with root package name */
    private OverScroller f1336e;

    /* renamed from: f reason: collision with root package name */
    private EdgeEffect f1337f;

    /* renamed from: g reason: collision with root package name */
    private EdgeEffect f1338g;

    /* renamed from: h reason: collision with root package name */
    private int f1339h;

    /* renamed from: i reason: collision with root package name */
    private boolean f1340i;

    /* renamed from: j reason: collision with root package name */
    private boolean f1341j;

    /* renamed from: k reason: collision with root package name */
    private View f1342k;

    /* renamed from: l reason: collision with root package name */
    private boolean f1343l;
    private VelocityTracker m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final int[] t;
    private final int[] u;
    private int v;
    private int w;
    private c x;
    private final q y;
    private final C0252m z;

    static class a extends C0240a {
        a() {
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i2 == 4096) {
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, min);
                return true;
            } else if (i2 != 8192) {
                return false;
            } else {
                int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (max == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, max);
                return true;
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            f.a(accessibilityEvent, nestedScrollView.getScrollX());
            f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void a(View view, d dVar) {
            super.a(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.b((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    dVar.j(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        dVar.a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        dVar.a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
                    }
                }
            }
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class c extends BaseSavedState {
        public static final Creator<c> CREATOR = new h();

        /* renamed from: a reason: collision with root package name */
        public int f1344a;

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            sb.append(this.f1344a);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1344a);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f1344a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private boolean d(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i3 < childAt.getTop() - scrollY || i3 >= childAt.getBottom() - scrollY || i2 < childAt.getLeft() || i2 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void f() {
        this.f1336e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.p = viewConfiguration.getScaledTouchSlop();
        this.q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void g() {
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.A;
    }

    private void h() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.z.a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean a(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void b(View view, View view2, int i2, int i3) {
        this.y.a(view, view2, i2, i3);
        c(2, i3);
    }

    public boolean c(int i2, int i3) {
        return this.z.a(i2, i3);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.f1336e.isFinished()) {
            this.f1336e.computeScrollOffset();
            int currY = this.f1336e.getCurrY();
            int i2 = currY - this.w;
            this.w = currY;
            int[] iArr = this.u;
            boolean z2 = false;
            iArr[1] = 0;
            a(0, i2, iArr, (int[]) null, 1);
            int i3 = i2 - this.u[1];
            int scrollRange = getScrollRange();
            if (i3 != 0) {
                int scrollY = getScrollY();
                a(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i3 - scrollY2;
                int[] iArr2 = this.u;
                iArr2[1] = 0;
                a(0, scrollY2, 0, i4, this.t, 1, iArr2);
                i3 = i4 - this.u[1];
            }
            if (i3 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    d();
                    if (i3 < 0) {
                        if (this.f1337f.isFinished()) {
                            this.f1337f.onAbsorb((int) this.f1336e.getCurrVelocity());
                        }
                    } else if (this.f1338g.isFinished()) {
                        this.f1338g.onAbsorb((int) this.f1336e.getCurrVelocity());
                    }
                }
                a();
            }
            if (!this.f1336e.isFinished()) {
                B.G(this);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.z.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.z.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.z.a(i2, i3, i4, i5, iArr);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f1337f != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.f1337f.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.f1337f.setSize(width, height);
                if (this.f1337f.draw(canvas)) {
                    B.G(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1338g.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i3 = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f1338g.setSize(width2, height2);
                if (this.f1338g.draw(canvas)) {
                    B.G(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean e(int i2) {
        return this.z.a(i2);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    /* access modifiers changed from: 0000 */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return e(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.z.b();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1341j = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f1343l) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i2 = scrollY - verticalScrollFactorCompat;
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > scrollRange) {
                    i2 = scrollRange;
                }
                if (i2 != scrollY) {
                    super.scrollTo(getScrollX(), i2);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f1343l) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.s;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid pointerId=");
                            sb.append(i3);
                            sb.append(" in onInterceptTouchEvent");
                            Log.e("NestedScrollView", sb.toString());
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f1339h) > this.p && (2 & getNestedScrollAxes()) == 0) {
                                this.f1343l = true;
                                this.f1339h = y2;
                                g();
                                this.m.addMovement(motionEvent);
                                this.v = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.f1343l = false;
            this.s = -1;
            h();
            if (this.f1336e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                B.G(this);
            }
            a(0);
        } else {
            int y3 = (int) motionEvent.getY();
            if (!d((int) motionEvent.getX(), y3)) {
                this.f1343l = false;
                h();
            } else {
                this.f1339h = y3;
                this.s = motionEvent.getPointerId(0);
                e();
                this.m.addMovement(motionEvent);
                this.f1336e.computeScrollOffset();
                this.f1343l = !this.f1336e.isFinished();
                c(2, 0);
            }
        }
        return this.f1343l;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.f1340i = false;
        View view = this.f1342k;
        if (view != null && a(view, (View) this)) {
            b(this.f1342k);
        }
        this.f1342k = null;
        if (!this.f1341j) {
            if (this.x != null) {
                scrollTo(getScrollX(), this.x.f1344a);
                this.x = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int a2 = a(scrollY, paddingTop, i6);
            if (a2 != scrollY) {
                scrollTo(getScrollX(), a2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1341j = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.n && MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        c((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(i5, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !a(view)) {
            return view.requestFocus(i2, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.x = cVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f1344a = getScrollY();
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.B;
        if (bVar != null) {
            bVar.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && a(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.f1335d);
            offsetDescendantRectToMyCoords(findFocus, this.f1335d);
            g(a(this.f1335d));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        g();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.v = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.v);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.m;
                velocityTracker.computeCurrentVelocity(1000, (float) this.r);
                int yVelocity = (int) velocityTracker.getYVelocity(this.s);
                if (Math.abs(yVelocity) > this.q) {
                    int i2 = -yVelocity;
                    float f2 = (float) i2;
                    if (!dispatchNestedPreFling(0.0f, f2)) {
                        dispatchNestedFling(0.0f, f2, true);
                        c(i2);
                    }
                } else if (this.f1336e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    B.G(this);
                }
                this.s = -1;
                c();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent2.findPointerIndex(this.s);
                if (findPointerIndex == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid pointerId=");
                    sb.append(this.s);
                    sb.append(" in onTouchEvent");
                    Log.e("NestedScrollView", sb.toString());
                } else {
                    int y2 = (int) motionEvent2.getY(findPointerIndex);
                    int i3 = this.f1339h - y2;
                    if (a(0, i3, this.u, this.t, 0)) {
                        i3 -= this.u[1];
                        this.v += this.t[1];
                    }
                    if (!this.f1343l && Math.abs(i3) > this.p) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1343l = true;
                        if (i3 > 0) {
                            i3 -= this.p;
                        } else {
                            i3 += this.p;
                        }
                    }
                    int i4 = i3;
                    if (this.f1343l) {
                        this.f1339h = y2 - this.t[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        int i5 = scrollRange;
                        if (a(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !e(0)) {
                            this.m.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int i6 = i4 - scrollY2;
                        int[] iArr = this.u;
                        iArr[1] = 0;
                        a(0, scrollY2, 0, i6, this.t, 0, iArr);
                        int i7 = this.f1339h;
                        int[] iArr2 = this.t;
                        this.f1339h = i7 - iArr2[1];
                        this.v += iArr2[1];
                        if (z2) {
                            int i8 = i4 - this.u[1];
                            d();
                            int i9 = scrollY + i8;
                            if (i9 < 0) {
                                d.a(this.f1337f, ((float) i8) / ((float) getHeight()), motionEvent2.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.f1338g.isFinished()) {
                                    this.f1338g.onRelease();
                                }
                            } else if (i9 > i5) {
                                d.a(this.f1338g, ((float) i8) / ((float) getHeight()), 1.0f - (motionEvent2.getX(findPointerIndex) / ((float) getWidth())));
                                if (!this.f1337f.isFinished()) {
                                    this.f1337f.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f1337f;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f1338g.isFinished())) {
                                B.G(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f1343l && getChildCount() > 0 && this.f1336e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    B.G(this);
                }
                this.s = -1;
                c();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f1339h = (int) motionEvent2.getY(actionIndex);
                this.s = motionEvent2.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
                this.f1339h = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.s));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z3 = !this.f1336e.isFinished();
            this.f1343l = z3;
            if (z3) {
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (!this.f1336e.isFinished()) {
                a();
            }
            this.f1339h = (int) motionEvent.getY();
            this.s = motionEvent2.getPointerId(0);
            c(2, 0);
        }
        VelocityTracker velocityTracker2 = this.m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f1340i) {
            b(view2);
        } else {
            this.f1342k = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            h();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.f1340i = true;
        super.requestLayout();
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int width = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int a2 = a(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), width);
            int a3 = a(i3, height, height2);
            if (a2 != getScrollX() || a3 != getScrollY()) {
                super.scrollTo(a2, a3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.n) {
            this.n = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.z.a(z2);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.B = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.o = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return c(i2, 0);
    }

    public void stopNestedScroll() {
        a(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker == null) {
            this.m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public void a(int i2) {
        this.z.c(i2);
    }

    public void c(int i2) {
        if (getChildCount() > 0) {
            this.f1336e.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            a(true);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1335d = new Rect();
        this.f1340i = true;
        this.f1341j = false;
        this.f1342k = null;
        this.f1343l = false;
        this.o = true;
        this.s = -1;
        this.t = new int[2];
        this.u = new int[2];
        f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1333b, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.y = new q(this);
        this.z = new C0252m(this);
        setNestedScrollingEnabled(true);
        B.a((View) this, (C0240a) f1332a);
    }

    private boolean b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    private void g(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.o) {
            a(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.z.a(i2, i3, iArr, iArr2, i4);
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(i5, i6, iArr);
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    private void a(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.z.a(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    private void c() {
        this.f1343l = false;
        h();
        a(0);
        EdgeEffect edgeEffect = this.f1337f;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1338g.onRelease();
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    private boolean b(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View a2 = a(z3, i3, i4);
        if (a2 == null) {
            a2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            g(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        }
        if (a2 != findFocus()) {
            a2.requestFocus(i2);
        }
        return z2;
    }

    public boolean d(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f1335d;
        rect.top = 0;
        rect.bottom = height;
        if (z2) {
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                this.f1335d.bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect2 = this.f1335d;
                rect2.top = rect2.bottom - height;
            }
        }
        Rect rect3 = this.f1335d;
        return b(i2, rect3.top, rect3.bottom);
    }

    public boolean f(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.f1335d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f1335d;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f1335d.top = getScrollY() - height;
            Rect rect2 = this.f1335d;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f1335d;
        int i3 = rect3.top;
        rect3.bottom = height + i3;
        return b(i2, i3, rect3.bottom);
    }

    public void a(View view, int i2) {
        this.y.a(view, i2);
        a(i2);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(i5, i6, (int[]) null);
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        a(i2, i3, iArr, (int[]) null, i4);
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1335d);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1335d);
            g(a(this.f1335d));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public boolean a(KeyEvent keyEvent) {
        this.f1335d.setEmpty();
        boolean z2 = false;
        int i2 = 130;
        if (!b()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                if (!(findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130))) {
                    z2 = true;
                }
            }
            return z2;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                z2 = !keyEvent.isAltPressed() ? b(33) : d(33);
            } else if (keyCode == 20) {
                z2 = !keyEvent.isAltPressed() ? b(130) : d(130);
            } else if (keyCode == 62) {
                if (keyEvent.isShiftPressed()) {
                    i2 = 33;
                }
                f(i2);
            }
        }
        return z2;
    }

    private void d() {
        if (getOverScrollMode() == 2) {
            this.f1337f = null;
            this.f1338g = null;
        } else if (this.f1337f == null) {
            Context context = getContext();
            this.f1337f = new EdgeEffect(context);
            this.f1338g = new EdgeEffect(context);
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.s) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f1339h = (int) motionEvent.getY(i2);
            this.s = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083 A[ADDED_TO_REGION] */
    public boolean a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        boolean z3;
        boolean z4;
        int overScrollMode = getOverScrollMode();
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i10 = i4 + i2;
        int i11 = !z7 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z8 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i14 = i15;
        } else if (i10 >= i14) {
            i14 = i10;
            z3 = false;
            if (i12 <= i17) {
                i12 = i17;
            } else if (i12 < i16) {
                i12 = i16;
            } else {
                z4 = false;
                if (z4 && !e(1)) {
                    this.f1336e.springBack(i14, i12, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i14, i12, z3, z4);
                if (!z3 || z4) {
                    return true;
                }
                return false;
            }
            z4 = true;
            this.f1336e.springBack(i14, i12, 0, 0, 0, getScrollRange());
            onOverScrolled(i14, i12, z3, z4);
            if (!z3) {
            }
            return true;
        }
        z3 = true;
        if (i12 <= i17) {
        }
        z4 = true;
        this.f1336e.springBack(i14, i12, 0, 0, 0, getScrollRange());
        onOverScrolled(i14, i12, z3, z4);
        if (!z3) {
        }
        return true;
    }

    public final void b(int i2, int i3) {
        a(i2 - getScrollX(), i3 - getScrollY());
    }

    private void b(View view) {
        view.getDrawingRect(this.f1335d);
        offsetDescendantRectToMyCoords(view, this.f1335d);
        int a2 = a(this.f1335d);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    private View a(boolean z2, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i2, int i3) {
        view.getDrawingRect(this.f1335d);
        offsetDescendantRectToMyCoords(view, this.f1335d);
        return this.f1335d.bottom + i2 >= getScrollY() && this.f1335d.top - i2 <= getScrollY() + i3;
    }

    public final void a(int i2, int i3) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1334c > 250) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                this.f1336e.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY);
                a(false);
            } else {
                if (!this.f1336e.isFinished()) {
                    a();
                }
                scrollBy(i2, i3);
            }
            this.f1334c = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private void a(boolean z2) {
        if (z2) {
            c(2, 1);
        } else {
            a(1);
        }
        this.w = getScrollY();
        B.G(this);
    }

    private void a() {
        this.f1336e.abortAnimation();
        a(1);
    }

    private boolean a(Rect rect, boolean z2) {
        int a2 = a(rect);
        boolean z3 = a2 != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, a2);
            } else {
                a(0, a2);
            }
        }
        return z3;
    }

    /* access modifiers changed from: protected */
    public int a(Rect rect) {
        int i2;
        int i3;
        int i4 = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i5 - verticalFadingEdgeLength : i5;
        if (rect.bottom > i6 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i6;
            }
            i4 = Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        } else if (rect.top < scrollY && rect.bottom < i6) {
            if (rect.height() > height) {
                i2 = 0 - (i6 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            i4 = Math.max(i2, -getScrollY());
        }
        return i4;
    }

    private static boolean a(View view, View view2) {
        boolean z2 = true;
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !a((View) parent, view2)) {
            z2 = false;
        }
        return z2;
    }
}
