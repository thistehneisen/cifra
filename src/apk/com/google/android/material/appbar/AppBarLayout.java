package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import b.g.i.B;
import b.g.i.C0251l;
import b.g.i.O;
import b.g.i.r;
import c.b.a.c.j;
import c.b.a.c.k;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@androidx.coordinatorlayout.widget.CoordinatorLayout.c(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a reason: collision with root package name */
    private int f6237a;

    /* renamed from: b reason: collision with root package name */
    private int f6238b;

    /* renamed from: c reason: collision with root package name */
    private int f6239c;

    /* renamed from: d reason: collision with root package name */
    private boolean f6240d;

    /* renamed from: e reason: collision with root package name */
    private int f6241e;

    /* renamed from: f reason: collision with root package name */
    private O f6242f;

    /* renamed from: g reason: collision with root package name */
    private List<a> f6243g;

    /* renamed from: h reason: collision with root package name */
    private boolean f6244h;

    /* renamed from: i reason: collision with root package name */
    private boolean f6245i;

    /* renamed from: j reason: collision with root package name */
    private boolean f6246j;

    /* renamed from: k reason: collision with root package name */
    private boolean f6247k;

    /* renamed from: l reason: collision with root package name */
    private int[] f6248l;

    protected static class BaseBehavior<T extends AppBarLayout> extends f<T> {
        /* access modifiers changed from: private */

        /* renamed from: k reason: collision with root package name */
        public int f6249k;

        /* renamed from: l reason: collision with root package name */
        private int f6250l;
        private ValueAnimator m;
        private int n = -1;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private a r;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        protected static class b extends b.i.a.c {
            public static final Creator<b> CREATOR = new c();

            /* renamed from: c reason: collision with root package name */
            int f6251c;

            /* renamed from: d reason: collision with root package name */
            float f6252d;

            /* renamed from: e reason: collision with root package name */
            boolean f6253e;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f6251c = parcel.readInt();
                this.f6252d = parcel.readFloat();
                this.f6253e = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f6251c);
                parcel.writeFloat(this.f6252d);
                parcel.writeByte(this.f6253e ? (byte) 1 : 0);
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior() {
        }

        private static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private void d(CoordinatorLayout coordinatorLayout, T t) {
            int c2 = c();
            int b2 = b(t, c2);
            if (b2 >= 0) {
                View childAt = t.getChildAt(b2);
                b bVar = (b) childAt.getLayoutParams();
                int a2 = bVar.a();
                if ((a2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (b2 == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (a(a2, 2)) {
                        i3 += B.n(childAt);
                    } else if (a(a2, 5)) {
                        int n2 = B.n(childAt) + i3;
                        if (c2 < n2) {
                            i2 = n2;
                        } else {
                            i3 = n2;
                        }
                    }
                    if (a(a2, 32)) {
                        i2 += bVar.topMargin;
                        i3 -= bVar.bottomMargin;
                    }
                    if (c2 < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    a(coordinatorLayout, t, b.g.e.a.a(i2, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int c(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator b2 = bVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = bVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= B.n(childAt);
                        }
                    }
                    if (B.j(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        private int b(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            boolean z = (i2 & 2) != 0 && (t.c() || a(coordinatorLayout, t, view));
            if (z) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
            }
            this.q = null;
            this.f6250l = i3;
            return z;
        }

        /* access modifiers changed from: 0000 */
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d2 = super.d(coordinatorLayout, t);
            int b2 = b();
            int childCount = t.getChildCount();
            boolean z = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i2++;
                } else {
                    b bVar = new b(d2);
                    bVar.f6251c = i2;
                    if (bottom == B.n(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    bVar.f6253e = z;
                    bVar.f6252d = ((float) bottom) / ((float) childAt.getHeight());
                    return bVar;
                }
            }
            return d2;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.b() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i6 = i7;
                    i5 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = a(coordinatorLayout, t, i3, i6, i5);
                    a(i3, t, view, i4);
                }
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List c2 = coordinatorLayout.c((View) t);
            int size = c2.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                androidx.coordinatorlayout.widget.CoordinatorLayout.b d2 = ((e) ((View) c2.get(i2)).getLayoutParams()).d();
                if (d2 instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) d2).c() != 0) {
                        z = true;
                    }
                    return z;
                }
            }
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i5 < 0) {
                a(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                a(i5, t, view, i6);
            }
            if (t.c()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i2, T t, View view, int i3) {
            if (i3 == 1) {
                int c2 = c();
                if ((i2 < 0 && c2 == 0) || (i2 > 0 && c2 == (-t.getDownNestedScrollRange()))) {
                    B.g(view, 1);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public int c() {
            return b() + this.f6249k;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.f6250l == 0 || i2 == 1) {
                d(coordinatorLayout, t);
            }
            this.q = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int i3;
            int abs = Math.abs(c() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                i3 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i3 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, t, i2, i3);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int c2 = c();
            if (c2 == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(c.b.a.c.a.a.f3095e);
                this.m.addUpdateListener(new b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(i3, 600));
            this.m.setIntValues(new int[]{c2, i2});
            this.m.start();
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((e) t.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, t, i2, i3, i4, i5);
            }
            coordinatorLayout.a((View) t, i2, i3, MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int i3;
            boolean a2 = super.a(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i4 = this.n;
            if (i4 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i4);
                int i5 = -childAt.getBottom();
                if (this.o) {
                    i3 = B.n(childAt) + t.getTopInset();
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.p);
                }
                c(coordinatorLayout, t, i5 + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i6 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, t, i6, 0.0f);
                    } else {
                        c(coordinatorLayout, t, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, t, 0);
                    }
                }
            }
            t.d();
            this.n = -1;
            a(b.g.e.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, t, b(), 0, true);
            t.a(b());
            return a2;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(T t) {
            a aVar = this.r;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            boolean z = true;
            if (weakReference != null) {
                View view = (View) weakReference.get();
                if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                    z = false;
                }
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, t);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int b(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int c2 = c();
            int i5 = 0;
            if (i3 == 0 || c2 < i3 || c2 > i4) {
                this.f6249k = 0;
            } else {
                int a2 = b.g.e.a.a(i2, i3, i4);
                if (c2 != a2) {
                    int c3 = t.a() ? c(t, a2) : a2;
                    boolean a3 = a(c3);
                    i5 = c2 - a2;
                    this.f6249k = a2 - c3;
                    if (!a3 && t.a()) {
                        coordinatorLayout.a((View) t);
                    }
                    t.a(b());
                    a(coordinatorLayout, t, a2, a2 < c2 ? -1 : 1, false);
                }
            }
            return i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        private void a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            boolean z2;
            View a2 = a((AppBarLayout) t, i2);
            if (a2 != null) {
                int a3 = ((b) a2.getLayoutParams()).a();
                if ((a3 & 1) != 0) {
                    int n2 = B.n(a2);
                    if (i3 <= 0 || (a3 & 12) == 0 ? !((a3 & 2) == 0 || (-i2) < (a2.getBottom() - n2) - t.getTopInset()) : (-i2) >= (a2.getBottom() - n2) - t.getTopInset()) {
                        z2 = true;
                        if (t.c()) {
                            View a4 = a(coordinatorLayout);
                            if (a4 != null) {
                                z2 = a4.getScrollY() > 0;
                            }
                        }
                        boolean a5 = t.a(z2);
                        if (VERSION.SDK_INT >= 11) {
                            return;
                        }
                        if (z || (a5 && c(coordinatorLayout, t))) {
                            t.jumpDrawablesToCurrentState();
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                if (t.c()) {
                }
                boolean a52 = t.a(z2);
                if (VERSION.SDK_INT >= 11) {
                }
            }
        }

        private static View a(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof C0251l) {
                    return childAt;
                }
            }
            return null;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, t, bVar.n());
                this.n = bVar.f6251c;
                this.p = bVar.f6252d;
                this.o = bVar.f6253e;
                return;
            }
            super.a(coordinatorLayout, t, parcelable);
            this.n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.a(coordinatorLayout, appBarLayout, i2);
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.b(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.a(coordinatorLayout, appBarLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean a(int i2) {
            return super.a(i2);
        }
    }

    public static class ScrollingViewBehavior extends g {
        public ScrollingViewBehavior() {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        /* access modifiers changed from: 0000 */
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.a(coordinatorLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, view, i2, i3, i4, i5);
        }

        /* access modifiers changed from: 0000 */
        public float b(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + a2 <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                int i2 = totalScrollRange - downNestedPreScrollRange;
                if (i2 != 0) {
                    return (((float) a2) / ((float) i2)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f6287d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.c()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }

        private void a(View view, View view2) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.b d2 = ((e) view2.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                B.c(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d2).f6249k) + d()) - a(view2));
            }
        }

        private static int a(AppBarLayout appBarLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.b d2 = ((e) appBarLayout.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                return ((BaseBehavior) d2).c();
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public interface a<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i2);
    }

    public static class b extends LayoutParams {

        /* renamed from: a reason: collision with root package name */
        int f6254a = 1;

        /* renamed from: b reason: collision with root package name */
        Interpolator f6255b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppBarLayout_Layout);
            this.f6254a = obtainStyledAttributes.getInt(k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f6255b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f6254a;
        }

        public Interpolator b() {
            return this.f6255b;
        }

        /* access modifiers changed from: 0000 */
        public boolean c() {
            int i2 = this.f6254a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface c extends a<AppBarLayout> {
        void onOffsetChanged(AppBarLayout appBarLayout, int i2);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private boolean e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((b) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.f6237a = -1;
        this.f6238b = -1;
        this.f6239c = -1;
    }

    public void a(a aVar) {
        if (this.f6243g == null) {
            this.f6243g = new ArrayList();
        }
        if (aVar != null && !this.f6243g.contains(aVar)) {
            this.f6243g.add(aVar);
        }
    }

    public void b(a aVar) {
        List<a> list = this.f6243g;
        if (list != null && aVar != null) {
            list.remove(aVar);
        }
    }

    public boolean c() {
        return this.f6247k;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        this.f6241e = 0;
    }

    /* access modifiers changed from: 0000 */
    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.f6238b;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f6254a;
            if ((i5 & 5) == 5) {
                int i6 = i4 + bVar.topMargin + bVar.bottomMargin;
                if ((i5 & 8) != 0) {
                    i4 = i6 + B.n(childAt);
                } else {
                    if ((i5 & 2) != 0) {
                        i2 = B.n(childAt);
                    } else {
                        i2 = getTopInset();
                    }
                    i4 = i6 + (measuredHeight - i2);
                }
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f6238b = max;
        return max;
    }

    /* access modifiers changed from: 0000 */
    public int getDownNestedScrollRange() {
        int i2 = this.f6239c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i5 = bVar.f6254a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= B.n(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f6239c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int n = B.n(this);
        if (n == 0) {
            int childCount = getChildCount();
            n = childCount >= 1 ? B.n(getChildAt(childCount - 1)) : 0;
            if (n == 0) {
                return getHeight() / 3;
            }
        }
        return (n * 2) + topInset;
    }

    /* access modifiers changed from: 0000 */
    public int getPendingAction() {
        return this.f6241e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: 0000 */
    public final int getTopInset() {
        O o = this.f6242f;
        if (o != null) {
            return o.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f6237a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f6254a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= B.n(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.f6237a = max;
        return max;
    }

    /* access modifiers changed from: 0000 */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.f6248l == null) {
            this.f6248l = new int[4];
        }
        int[] iArr = this.f6248l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.f6245i ? c.b.a.c.b.state_liftable : -c.b.a.c.b.state_liftable;
        iArr[1] = (!this.f6245i || !this.f6246j) ? -c.b.a.c.b.state_lifted : c.b.a.c.b.state_lifted;
        iArr[2] = this.f6245i ? c.b.a.c.b.state_collapsible : -c.b.a.c.b.state_collapsible;
        iArr[3] = (!this.f6245i || !this.f6246j) ? -c.b.a.c.b.state_collapsed : c.b.a.c.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        f();
        boolean z2 = false;
        this.f6240d = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((b) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f6240d = true;
                break;
            } else {
                i6++;
            }
        }
        if (!this.f6244h) {
            if (this.f6247k || e()) {
                z2 = true;
            }
            b(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        f();
    }

    public void setExpanded(boolean z) {
        a(z, B.C(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f6247k = z;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (VERSION.SDK_INT >= 21) {
            j.a(this, f2);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6237a = -1;
        this.f6238b = -1;
        this.f6239c = -1;
        this.f6241e = 0;
        setOrientation(1);
        if (VERSION.SDK_INT >= 21) {
            j.a(this);
            j.a(this, attributeSet, 0, j.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = l.a(context, attributeSet, k.AppBarLayout, 0, j.Widget_Design_AppBarLayout, new int[0]);
        B.a((View) this, a2.getDrawable(k.AppBarLayout_android_background));
        if (a2.hasValue(k.AppBarLayout_expanded)) {
            a(a2.getBoolean(k.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && a2.hasValue(k.AppBarLayout_elevation)) {
            j.a(this, (float) a2.getDimensionPixelSize(k.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (a2.hasValue(k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f6247k = a2.getBoolean(k.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        B.a((View) this, (r) new a(this));
    }

    public void b(c cVar) {
        b((a) cVar);
    }

    /* access modifiers changed from: protected */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        return getTotalScrollRange() != 0;
    }

    private boolean b(boolean z) {
        if (this.f6245i == z) {
            return false;
        }
        this.f6245i = z;
        refreshDrawableState();
        return true;
    }

    public void a(c cVar) {
        a((a) cVar);
    }

    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    /* access modifiers changed from: protected */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof LayoutParams)) {
            return new b((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new b((MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.f6241e = i3 | i2;
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public boolean a() {
        return this.f6240d;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        List<a> list = this.f6243g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = (a) this.f6243g.get(i3);
                if (aVar != null) {
                    aVar.onOffsetChanged(this, i2);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(boolean z) {
        if (this.f6246j == z) {
            return false;
        }
        this.f6246j = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public O a(O o) {
        O o2 = B.j(this) ? o : null;
        if (!b.g.h.c.a(this.f6242f, o2)) {
            this.f6242f = o2;
            f();
        }
        return o;
    }
}
