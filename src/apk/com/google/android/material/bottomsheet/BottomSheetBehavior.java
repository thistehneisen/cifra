package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import b.g.i.B;
import b.i.b.g;
import c.b.a.c.d;
import c.b.a.c.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b<V> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public boolean f6340a = true;

    /* renamed from: b reason: collision with root package name */
    private float f6341b;

    /* renamed from: c reason: collision with root package name */
    private int f6342c;

    /* renamed from: d reason: collision with root package name */
    private boolean f6343d;

    /* renamed from: e reason: collision with root package name */
    private int f6344e;

    /* renamed from: f reason: collision with root package name */
    private int f6345f;

    /* renamed from: g reason: collision with root package name */
    int f6346g;

    /* renamed from: h reason: collision with root package name */
    int f6347h;

    /* renamed from: i reason: collision with root package name */
    int f6348i;

    /* renamed from: j reason: collision with root package name */
    boolean f6349j;

    /* renamed from: k reason: collision with root package name */
    private boolean f6350k;

    /* renamed from: l reason: collision with root package name */
    int f6351l = 4;
    g m;
    private boolean n;
    private int o;
    private boolean p;
    int q;
    WeakReference<V> r;
    WeakReference<View> s;
    private a t;
    private VelocityTracker u;
    int v;
    private int w;
    boolean x;
    private Map<View, Integer> y;
    private final b.i.b.g.a z = new b(this);

    public static abstract class a {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i2);
    }

    protected static class b extends b.i.a.c {
        public static final Creator<b> CREATOR = new c();

        /* renamed from: c reason: collision with root package name */
        final int f6352c;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6352c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6352c);
        }

        public b(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f6352c = i2;
        }
    }

    private class c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final View f6353a;

        /* renamed from: b reason: collision with root package name */
        private final int f6354b;

        c(View view, int i2) {
            this.f6353a = view;
            this.f6354b = i2;
        }

        public void run() {
            g gVar = BottomSheetBehavior.this.m;
            if (gVar == null || !gVar.a(true)) {
                BottomSheetBehavior.this.d(this.f6354b);
            } else {
                B.a(this.f6353a, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    private float e() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f6341b);
        return this.u.getYVelocity(this.v);
    }

    private void f() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    public void c(boolean z2) {
        this.f6350k = z2;
    }

    public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
        return new b(super.d(coordinatorLayout, v2), this.f6351l);
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, v2, bVar.n());
        int i2 = bVar.f6352c;
        if (i2 == 1 || i2 == 2) {
            this.f6351l = 4;
        } else {
            this.f6351l = i2;
        }
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6351l == 1 && actionMasked == 0) {
            return true;
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            f();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.n && Math.abs(((float) this.w) - motionEvent.getY()) > ((float) this.m.b())) {
            this.m.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.n;
    }

    public final void c(int i2) {
        if (i2 != this.f6351l) {
            WeakReference<V> weakReference = this.r;
            if (weakReference == null) {
                if (i2 == 4 || i2 == 3 || i2 == 6 || (this.f6349j && i2 == 5)) {
                    this.f6351l = i2;
                }
                return;
            }
            View view = (View) weakReference.get();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent == null || !parent.isLayoutRequested() || !B.B(view)) {
                    a(view, i2);
                } else {
                    view.post(new a(this, view, i2));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(int i2) {
        if (this.f6351l != i2) {
            this.f6351l = i2;
            if (i2 == 6 || i2 == 3) {
                d(true);
            } else if (i2 == 5 || i2 == 4) {
                d(false);
            }
            View view = (View) this.r.get();
            if (view != null) {
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view, i2);
                }
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null) {
            int i2 = peekValue.data;
            if (i2 == -1) {
                b(i2);
                b(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_hideable, false));
                a(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
                c(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
                obtainStyledAttributes.recycle();
                this.f6341b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            }
        }
        b(obtainStyledAttributes.getDimensionPixelSize(k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        b(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f6341b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        if (B.j(coordinatorLayout) && !B.j(v2)) {
            v2.setFitsSystemWindows(true);
        }
        int top = v2.getTop();
        coordinatorLayout.c((View) v2, i2);
        this.q = coordinatorLayout.getHeight();
        if (this.f6343d) {
            if (this.f6344e == 0) {
                this.f6344e = coordinatorLayout.getResources().getDimensionPixelSize(d.design_bottom_sheet_peek_height_min);
            }
            this.f6345f = Math.max(this.f6344e, this.q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f6345f = this.f6342c;
        }
        this.f6346g = Math.max(0, this.q - v2.getHeight());
        this.f6347h = this.q / 2;
        c();
        int i3 = this.f6351l;
        if (i3 == 3) {
            B.c((View) v2, d());
        } else if (i3 == 6) {
            B.c((View) v2, this.f6347h);
        } else if (!this.f6349j || i3 != 5) {
            int i4 = this.f6351l;
            if (i4 == 4) {
                B.c((View) v2, this.f6348i);
            } else if (i4 == 1 || i4 == 2) {
                B.c((View) v2, top - v2.getTop());
            }
        } else {
            B.c((View) v2, this.q);
        }
        if (this.m == null) {
            this.m = g.a((ViewGroup) coordinatorLayout, this.z);
        }
        this.r = new WeakReference<>(v2);
        this.s = new WeakReference<>(a((View) v2));
        return true;
    }

    /* access modifiers changed from: private */
    public int d() {
        if (this.f6340a) {
            return this.f6346g;
        }
        return 0;
    }

    private void d(boolean z2) {
        WeakReference<V> weakReference = this.r;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (VERSION.SDK_INT >= 16 && z2) {
                    if (this.y == null) {
                        this.y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.r.get()) {
                        if (!z2) {
                            Map<View, Integer> map = this.y;
                            if (map != null && map.containsKey(childAt)) {
                                B.e(childAt, ((Integer) this.y.get(childAt)).intValue());
                            }
                        } else {
                            if (VERSION.SDK_INT >= 16) {
                                this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            B.e(childAt, 4);
                        }
                    }
                }
                if (!z2) {
                    this.y = null;
                }
            }
        }
    }

    private void c() {
        if (this.f6340a) {
            this.f6348i = Math.max(this.q - this.f6345f, this.f6346g);
        } else {
            this.f6348i = this.q - this.f6345f;
        }
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.o = 0;
        this.p = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void b(int i2) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f6343d) {
                this.f6343d = true;
                if (!z2 && this.f6351l == 4) {
                    WeakReference<V> weakReference = this.r;
                    if (weakReference != null) {
                        View view = (View) weakReference.get();
                        if (view != null) {
                            view.requestLayout();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        } else if (this.f6343d || this.f6342c != i2) {
            this.f6343d = false;
            this.f6342c = Math.max(0, i2);
            this.f6348i = this.q - i2;
            if (!z2) {
                return;
            }
            return;
        }
        z2 = false;
        if (!z2) {
        }
    }

    public void b(boolean z2) {
        this.f6349j = z2;
    }

    public final int b() {
        return this.f6351l;
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v2) {
        LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof e) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.b d2 = ((e) layoutParams).d();
            if (d2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) d2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        boolean z2 = false;
        if (!v2.isShown()) {
            this.n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            f();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.s;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && coordinatorLayout.a(view2, x2, this.w)) {
                this.v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.x = true;
            }
            this.n = this.v == -1 && !coordinatorLayout.a((View) v2, x2, this.w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.x = false;
            this.v = -1;
            if (this.n) {
                this.n = false;
                return false;
            }
        }
        if (!this.n) {
            g gVar = this.m;
            if (gVar != null && gVar.b(motionEvent)) {
                return true;
            }
        }
        WeakReference<View> weakReference2 = this.s;
        if (weakReference2 != null) {
            view = (View) weakReference2.get();
        }
        if (actionMasked == 2 && view != null && !this.n && this.f6351l != 1 && !coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.m != null && Math.abs(((float) this.w) - motionEvent.getY()) > ((float) this.m.b())) {
            z2 = true;
        }
        return z2;
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == ((View) this.s.get())) {
            int top = v2.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < d()) {
                    iArr[1] = top - d();
                    B.c((View) v2, -iArr[1]);
                    d(3);
                } else {
                    iArr[1] = i3;
                    B.c((View) v2, -i3);
                    d(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.f6348i;
                if (i5 <= i6 || this.f6349j) {
                    iArr[1] = i3;
                    B.c((View) v2, -i3);
                    d(1);
                } else {
                    iArr[1] = top - i6;
                    B.c((View) v2, -iArr[1]);
                    d(4);
                }
            }
            a(v2.getTop());
            this.o = i3;
            this.p = true;
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == d()) {
            d(3);
            return;
        }
        if (view == this.s.get() && this.p) {
            if (this.o > 0) {
                i3 = d();
            } else if (!this.f6349j || !a((View) v2, e())) {
                if (this.o == 0) {
                    int top = v2.getTop();
                    if (!this.f6340a) {
                        int i6 = this.f6347h;
                        if (top < i6) {
                            if (top < Math.abs(top - this.f6348i)) {
                                i3 = 0;
                            } else {
                                i3 = this.f6347h;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.f6348i)) {
                            i3 = this.f6347h;
                        } else {
                            i4 = this.f6348i;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.f6346g) < Math.abs(top - this.f6348i)) {
                        i3 = this.f6346g;
                    } else {
                        i4 = this.f6348i;
                    }
                } else {
                    i4 = this.f6348i;
                }
                i5 = 4;
            } else {
                i3 = this.q;
                i5 = 5;
            }
            if (this.m.b((View) v2, v2.getLeft(), i3)) {
                d(2);
                B.a((View) v2, (Runnable) new c(v2, i5));
            } else {
                d(i5);
            }
            this.p = false;
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        return view == this.s.get() && (this.f6351l != 3 || super.a(coordinatorLayout, v2, view, f2, f3));
    }

    public void a(boolean z2) {
        if (this.f6340a != z2) {
            this.f6340a = z2;
            if (this.r != null) {
                c();
            }
            d((!this.f6340a || this.f6351l != 6) ? this.f6351l : 3);
        }
    }

    public void a(a aVar) {
        this.t = aVar;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(View view, float f2) {
        boolean z2 = true;
        if (this.f6350k) {
            return true;
        }
        if (view.getTop() < this.f6348i) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f6348i)) / ((float) this.f6342c) <= 0.5f) {
            z2 = false;
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    public View a(View view) {
        if (B.D(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2) {
        int i3;
        if (i2 == 4) {
            i3 = this.f6348i;
        } else if (i2 == 6) {
            int i4 = this.f6347h;
            if (this.f6340a) {
                int i5 = this.f6346g;
                if (i4 <= i5) {
                    i3 = i5;
                    i2 = 3;
                }
            }
            i3 = i4;
        } else if (i2 == 3) {
            i3 = d();
        } else if (!this.f6349j || i2 != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal state argument: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            i3 = this.q;
        }
        if (this.m.b(view, view.getLeft(), i3)) {
            d(2);
            B.a(view, (Runnable) new c(view, i2));
            return;
        }
        d(i2);
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        View view = (View) this.r.get();
        if (view != null) {
            a aVar = this.t;
            if (aVar != null) {
                int i3 = this.f6348i;
                if (i2 > i3) {
                    aVar.a(view, ((float) (i3 - i2)) / ((float) (this.q - i3)));
                } else {
                    aVar.a(view, ((float) (i3 - i2)) / ((float) (i3 - d())));
                }
            }
        }
    }
}
