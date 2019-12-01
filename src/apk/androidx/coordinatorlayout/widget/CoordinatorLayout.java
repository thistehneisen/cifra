package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import b.g.i.B;
import b.g.i.C0243d;
import b.g.i.C0253n;
import b.g.i.O;
import b.g.i.q;
import b.g.i.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0253n {

    /* renamed from: a reason: collision with root package name */
    static final String f1208a;

    /* renamed from: b reason: collision with root package name */
    static final Class<?>[] f1209b = {Context.class, AttributeSet.class};

    /* renamed from: c reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<b>>> f1210c = new ThreadLocal<>();

    /* renamed from: d reason: collision with root package name */
    static final Comparator<View> f1211d;

    /* renamed from: e reason: collision with root package name */
    private static final b.g.h.d<Rect> f1212e = new b.g.h.f(12);

    /* renamed from: f reason: collision with root package name */
    private final List<View> f1213f;

    /* renamed from: g reason: collision with root package name */
    private final c<View> f1214g;

    /* renamed from: h reason: collision with root package name */
    private final List<View> f1215h;

    /* renamed from: i reason: collision with root package name */
    private final List<View> f1216i;

    /* renamed from: j reason: collision with root package name */
    private final int[] f1217j;

    /* renamed from: k reason: collision with root package name */
    private Paint f1218k;

    /* renamed from: l reason: collision with root package name */
    private boolean f1219l;
    private boolean m;
    private int[] n;
    private View o;
    private View p;
    private f q;
    private boolean r;
    private O s;
    private boolean t;
    private Drawable u;
    OnHierarchyChangeListener v;
    private r w;
    private final q x;

    public interface a {
        b getBehavior();
    }

    public static abstract class b<V extends View> {
        public b() {
        }

        public O a(CoordinatorLayout coordinatorLayout, V v, O o) {
            return o;
        }

        public void a() {
        }

        public void a(e eVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return b(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, v, view, view2, i2);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                a(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                a(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends b> value();
    }

    private class d implements OnHierarchyChangeListener {
        d() {
        }

        public void onChildViewAdded(View view, View view2) {
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class e extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        b f1221a;

        /* renamed from: b reason: collision with root package name */
        boolean f1222b = false;

        /* renamed from: c reason: collision with root package name */
        public int f1223c = 0;

        /* renamed from: d reason: collision with root package name */
        public int f1224d = 0;

        /* renamed from: e reason: collision with root package name */
        public int f1225e = -1;

        /* renamed from: f reason: collision with root package name */
        int f1226f = -1;

        /* renamed from: g reason: collision with root package name */
        public int f1227g = 0;

        /* renamed from: h reason: collision with root package name */
        public int f1228h = 0;

        /* renamed from: i reason: collision with root package name */
        int f1229i;

        /* renamed from: j reason: collision with root package name */
        int f1230j;

        /* renamed from: k reason: collision with root package name */
        View f1231k;

        /* renamed from: l reason: collision with root package name */
        View f1232l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q = new Rect();
        Object r;

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public void a(b bVar) {
            b bVar2 = this.f1221a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.a();
                }
                this.f1221a = bVar;
                this.r = null;
                this.f1222b = true;
                if (bVar != null) {
                    bVar.a(this);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean b() {
            if (this.f1221a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f1226f;
        }

        public b d() {
            return this.f1221a;
        }

        /* access modifiers changed from: 0000 */
        public boolean e() {
            return this.p;
        }

        /* access modifiers changed from: 0000 */
        public Rect f() {
            return this.q;
        }

        /* access modifiers changed from: 0000 */
        public void g() {
            this.p = false;
        }

        /* access modifiers changed from: 0000 */
        public void h() {
            this.m = false;
        }

        /* access modifiers changed from: 0000 */
        public boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            b bVar = this.f1221a;
            boolean a2 = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        /* access modifiers changed from: 0000 */
        public void a(Rect rect) {
            this.q.set(rect);
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2) {
            a(i2, false);
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1231k.getId() != this.f1226f) {
                return false;
            }
            View view2 = this.f1231k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1232l = null;
                    this.f1231k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f1232l = view2;
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean a() {
            return this.f1231k == null && this.f1226f != -1;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f.c.CoordinatorLayout_Layout);
            this.f1223c = obtainStyledAttributes.getInteger(b.f.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f1226f = obtainStyledAttributes.getResourceId(b.f.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f1224d = obtainStyledAttributes.getInteger(b.f.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f1225e = obtainStyledAttributes.getInteger(b.f.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f1227g = obtainStyledAttributes.getInt(b.f.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f1228h = obtainStyledAttributes.getInt(b.f.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f1222b = obtainStyledAttributes.hasValue(b.f.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f1222b) {
                this.f1221a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(b.f.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            b bVar = this.f1221a;
            if (bVar != null) {
                bVar.a(this);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        /* access modifiers changed from: 0000 */
        public void a(boolean z) {
            this.p = z;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 != this.f1232l && !a(view2, B.m(coordinatorLayout))) {
                b bVar = this.f1221a;
                if (bVar == null || !bVar.a(coordinatorLayout, view, view2)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: 0000 */
        public View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1226f == -1) {
                this.f1232l = null;
                this.f1231k = null;
                return null;
            }
            if (this.f1231k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.f1231k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.f1231k = coordinatorLayout.findViewById(this.f1226f);
            View view2 = this.f1231k;
            if (view2 != null) {
                if (view2 != coordinatorLayout) {
                    ViewParent parent = view2.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f1232l = null;
                            this.f1231k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1232l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f1232l = null;
                    this.f1231k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f1232l = null;
                this.f1231k = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find CoordinatorLayout descendant view with id ");
                sb.append(coordinatorLayout.getResources().getResourceName(this.f1226f));
                sb.append(" to anchor view ");
                sb.append(view);
                throw new IllegalStateException(sb.toString());
            }
        }

        public e(e eVar) {
            super(eVar);
        }

        private boolean a(View view, int i2) {
            int a2 = C0243d.a(((e) view.getLayoutParams()).f1227g, i2);
            return a2 != 0 && (C0243d.a(this.f1228h, i2) & a2) == a2;
        }

        public e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public e(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class f implements OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    protected static class g extends b.i.a.c {
        public static final Creator<g> CREATOR = new b();

        /* renamed from: c reason: collision with root package name */
        SparseArray<Parcelable> f1234c;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1234c = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f1234c.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f1234c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f1234c.keyAt(i3);
                parcelableArr[i3] = (Parcelable) this.f1234c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float v = B.v(view);
            float v2 = B.v(view2);
            if (v > v2) {
                return -1;
            }
            return v < v2 ? 1 : 0;
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f1208a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f1211d = new h();
        } else {
            f1211d = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f1212e.a(rect);
    }

    private int b(int i2) {
        int[] iArr = this.n;
        String str = "CoordinatorLayout";
        if (iArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
            Log.e(str, sb.toString());
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Keyline index ");
            sb2.append(i2);
            sb2.append(" out of range for ");
            sb2.append(this);
            Log.e(str, sb2.toString());
            return 0;
        }
    }

    private static int c(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int d(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static Rect d() {
        Rect rect = (Rect) f1212e.a();
        return rect == null ? new Rect() : rect;
    }

    private static int e(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void e() {
        this.f1213f.clear();
        this.f1214g.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e d2 = d(childAt);
            d2.a(this, childAt);
            this.f1214g.a(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.f1214g.b(childAt2)) {
                            this.f1214g.a(childAt2);
                        }
                        this.f1214g.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1213f.addAll(this.f1214g.b());
        Collections.reverse(this.f1213f);
    }

    private void f(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.f1230j;
        if (i3 != i2) {
            B.c(view, i2 - i3);
            eVar.f1230j = i2;
        }
    }

    public void c(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.a()) {
            View view2 = eVar.f1231k;
            if (view2 != null) {
                a(view, view2, i2);
                return;
            }
            int i3 = eVar.f1225e;
            if (i3 >= 0) {
                b(view, i3, i2);
            } else {
                d(view, i2);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        e eVar = (e) view.getLayoutParams();
        b bVar = eVar.f1221a;
        if (bVar != null) {
            float c2 = bVar.c(this, view);
            if (c2 > 0.0f) {
                if (this.f1218k == null) {
                    this.f1218k = new Paint();
                }
                this.f1218k.setColor(eVar.f1221a.b(this, view));
                this.f1218k.setAlpha(a(Math.round(c2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f1218k);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    public final List<View> getDependencySortedChildren() {
        e();
        return Collections.unmodifiableList(this.f1213f);
    }

    public final O getLastWindowInsets() {
        return this.s;
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    public Drawable getStatusBarBackground() {
        return this.u;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.r) {
            if (this.q == null) {
                this.q = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        if (this.s == null && B.j(this)) {
            B.H(this);
        }
        this.m = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.r && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        View view = this.p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.m = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t && this.u != null) {
            O o2 = this.s;
            int e2 = o2 != null ? o2.e() : 0;
            if (e2 > 0) {
                this.u.setBounds(0, 0, getWidth(), e2);
                this.u.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int m2 = B.m(this);
        int size = this.f1213f.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) this.f1213f.get(i6);
            if (view.getVisibility() != 8) {
                b d2 = ((e) view.getLayoutParams()).d();
                if (d2 == null || !d2.a(this, view, m2)) {
                    c(view, m2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
        if (r0.a(r30, r20, r11, r21, r23, 0) == false) goto L_0x0126;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a  */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        b d2;
        int i10;
        int i11;
        e eVar;
        int i12;
        e();
        b();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int m2 = B.m(this);
        boolean z = m2 == 1;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        int i13 = paddingLeft + paddingRight;
        int i14 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.s != null && B.j(this);
        int size3 = this.f1213f.size();
        int i15 = suggestedMinimumWidth;
        int i16 = suggestedMinimumHeight;
        int i17 = 0;
        int i18 = 0;
        while (i18 < size3) {
            View view = (View) this.f1213f.get(i18);
            if (view.getVisibility() == 8) {
                i5 = i18;
                i4 = size3;
            } else {
                e eVar2 = (e) view.getLayoutParams();
                int i19 = eVar2.f1225e;
                if (i19 < 0 || mode == 0) {
                    i6 = i16;
                } else {
                    int b2 = b(i19);
                    int a2 = C0243d.a(e(eVar2.f1223c), m2) & 7;
                    i6 = i16;
                    if ((a2 == 3 && !z) || (a2 == 5 && z)) {
                        i7 = Math.max(0, (size - paddingRight) - b2);
                        if (z2) {
                        }
                        i9 = i2;
                        i8 = i3;
                        d2 = eVar2.d();
                        if (d2 != null) {
                        }
                        a(view, i9, i7, i8, 0);
                        e eVar3 = eVar;
                        int max = Math.max(i10, i13 + view.getMeasuredWidth() + eVar3.leftMargin + eVar3.rightMargin);
                        int max2 = Math.max(i12, i14 + view.getMeasuredHeight() + eVar3.topMargin + eVar3.bottomMargin);
                        i15 = max;
                        i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
                        i16 = max2;
                    } else if ((a2 == 5 && !z) || (a2 == 3 && z)) {
                        i7 = Math.max(0, b2 - paddingLeft);
                        if (z2 || B.j(view)) {
                            i9 = i2;
                            i8 = i3;
                        } else {
                            int e2 = this.s.e() + this.s.b();
                            i9 = MeasureSpec.makeMeasureSpec(size - (this.s.c() + this.s.d()), mode);
                            i8 = MeasureSpec.makeMeasureSpec(size2 - e2, mode2);
                        }
                        d2 = eVar2.d();
                        if (d2 != null) {
                            eVar = eVar2;
                            i12 = i6;
                            i11 = i17;
                            i10 = i15;
                            i5 = i18;
                            i4 = size3;
                        } else {
                            eVar = eVar2;
                            i11 = i17;
                            i10 = i15;
                            i4 = size3;
                            i12 = i6;
                            i5 = i18;
                        }
                        a(view, i9, i7, i8, 0);
                        e eVar32 = eVar;
                        int max3 = Math.max(i10, i13 + view.getMeasuredWidth() + eVar32.leftMargin + eVar32.rightMargin);
                        int max22 = Math.max(i12, i14 + view.getMeasuredHeight() + eVar32.topMargin + eVar32.bottomMargin);
                        i15 = max3;
                        i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
                        i16 = max22;
                    }
                }
                i7 = 0;
                if (z2) {
                }
                i9 = i2;
                i8 = i3;
                d2 = eVar2.d();
                if (d2 != null) {
                }
                a(view, i9, i7, i8, 0);
                e eVar322 = eVar;
                int max32 = Math.max(i10, i13 + view.getMeasuredWidth() + eVar322.leftMargin + eVar322.rightMargin);
                int max222 = Math.max(i12, i14 + view.getMeasuredHeight() + eVar322.topMargin + eVar322.bottomMargin);
                i15 = max32;
                i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
                i16 = max222;
            }
            i18 = i5 + 1;
            size3 = i4;
        }
        int i20 = i17;
        setMeasuredDimension(View.resolveSizeAndState(i15, i2, -16777216 & i20), View.resolveSizeAndState(i16, i3, i20 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0)) {
                    b d2 = eVar.d();
                    if (d2 != null) {
                        z2 |= d2.a(this, childAt, view, f2, f3, z);
                    }
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0)) {
                    b d2 = eVar.d();
                    if (d2 != null) {
                        z |= d2.a(this, childAt, view, f2, f3);
                    }
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.n());
        SparseArray<Parcelable> sparseArray = gVar.f1234c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b d2 = d(childAt).d();
            if (!(id == -1 || d2 == null)) {
                Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                if (parcelable2 != null) {
                    d2.a(this, childAt, parcelable2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b d2 = ((e) childAt.getLayoutParams()).d();
            if (!(id == -1 || d2 == null)) {
                Parcelable d3 = d2.d(this, childAt);
                if (d3 != null) {
                    sparseArray.append(id, d3);
                }
            }
        }
        gVar.f1234c = sparseArray;
        return gVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (this.o == null) {
            z2 = a(motionEvent3, 1);
        } else {
            z2 = false;
        }
        b d2 = ((e) this.o.getLayoutParams()).d();
        if (d2 != null) {
            z = d2.b(this, this.o, motionEvent3);
            motionEvent2 = null;
            if (this.o != null) {
                z |= super.onTouchEvent(motionEvent);
            } else if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 || actionMasked == 3) {
                a(false);
            }
            return z;
        }
        z = false;
        motionEvent2 = null;
        if (this.o != null) {
        }
        if (motionEvent2 != null) {
        }
        a(false);
        return z;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b d2 = ((e) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f1219l) {
            a(false);
            this.f1219l = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        f();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.v = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.u = drawable3;
            Drawable drawable4 = this.u;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.u, B.m(this));
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            B.G(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? b.g.a.a.c(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.u;
        if (drawable != null && drawable.isVisible() != z) {
            this.u.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f.a.coordinatorLayoutStyle);
    }

    /* access modifiers changed from: protected */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArray;
        super(context, attributeSet, i2);
        this.f1213f = new ArrayList();
        this.f1214g = new c<>();
        this.f1215h = new ArrayList();
        this.f1216i = new ArrayList();
        this.f1217j = new int[2];
        this.x = new q(this);
        if (i2 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, b.f.c.CoordinatorLayout, 0, b.f.b.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, b.f.c.CoordinatorLayout, i2, 0);
        }
        int resourceId = typedArray.getResourceId(b.f.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.n = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.n.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.n;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.u = typedArray.getDrawable(b.f.c.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        f();
        super.setOnHierarchyChangeListener(new d());
    }

    /* access modifiers changed from: 0000 */
    public final O a(O o2) {
        if (b.g.h.c.a(this.s, o2)) {
            return o2;
        }
        this.s = o2;
        boolean z = true;
        this.t = o2 != null && o2.e() > 0;
        if (this.t || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        O b2 = b(o2);
        requestLayout();
        return b2;
    }

    /* access modifiers changed from: 0000 */
    public e d(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f1222b) {
            String str = "CoordinatorLayout";
            if (view instanceof a) {
                b behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e(str, "Attached behavior class is null");
                }
                eVar.a(behavior);
                eVar.f1222b = true;
            } else {
                c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.a((b) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Default behavior class ");
                        sb.append(cVar.value().getName());
                        sb.append(" could not be instantiated. Did you forget");
                        sb.append(" a default constructor?");
                        Log.e(str, sb.toString(), e2);
                    }
                }
                eVar.f1222b = true;
            }
        }
        return eVar;
    }

    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public e generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new e((MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    private void f() {
        if (VERSION.SDK_INT >= 21) {
            if (B.j(this)) {
                if (this.w == null) {
                    this.w = new a(this);
                }
                B.a((View) this, this.w);
                setSystemUiVisibility(1280);
            } else {
                B.a((View) this, (r) null);
            }
        }
    }

    private O b(O o2) {
        if (o2.f()) {
            return o2;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (B.j(childAt)) {
                b d2 = ((e) childAt.getLayoutParams()).d();
                if (d2 != null) {
                    o2 = d2.a(this, childAt, o2);
                    if (o2.f()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return o2;
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            b d2 = ((e) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    d2.a(this, childAt, obtain);
                } else {
                    d2.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((e) getChildAt(i3).getLayoutParams()).h();
        }
        this.o = null;
        this.f1219l = false;
    }

    /* access modifiers changed from: 0000 */
    public void c(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    public List<View> c(View view) {
        List c2 = this.f1214g.c(view);
        this.f1216i.clear();
        if (c2 != null) {
            this.f1216i.addAll(c2);
        }
        return this.f1216i;
    }

    /* access modifiers changed from: 0000 */
    public void b(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).f());
    }

    private void e(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.f1229i;
        if (i3 != i2) {
            B.b(view, i2 - i3);
            eVar.f1229i = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        if (this.m && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        this.r = false;
    }

    private void b(View view, int i2, int i3) {
        e eVar = (e) view.getLayoutParams();
        int a2 = C0243d.a(e(eVar.f1223c), i3);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int b2 = b(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            b2 += measuredWidth / 2;
        } else if (i4 == 5) {
            b2 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void d(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        Rect d2 = d();
        d2.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.s != null && B.j(this) && !B.j(view)) {
            d2.left += this.s.c();
            d2.top += this.s.e();
            d2.right -= this.s.d();
            d2.bottom -= this.s.b();
        }
        Rect d3 = d();
        C0243d.a(d(eVar.f1223c), view.getMeasuredWidth(), view.getMeasuredHeight(), d2, d3, i2);
        view.layout(d3.left, d3.top, d3.right, d3.bottom);
        a(d2);
        a(d3);
    }

    private boolean e(View view) {
        return this.f1214g.e(view);
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        Comparator<View> comparator = f1211d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f1215h;
        a(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) list.get(i4);
            e eVar = (e) view.getLayoutParams();
            b d2 = eVar.d();
            boolean z3 = true;
            if ((!z && !z2) || actionMasked == 0) {
                if (!z && d2 != null) {
                    if (i3 == 0) {
                        z = d2.a(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        z = d2.b(this, view, motionEvent2);
                    }
                    if (z) {
                        this.o = view;
                    }
                }
                boolean b2 = eVar.b();
                boolean b3 = eVar.b(this, view);
                if (!b3 || b2) {
                    z3 = false;
                }
                if (b3 && !z3) {
                    break;
                }
                z2 = z3;
            } else if (d2 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    d2.a(this, view, motionEvent3);
                } else if (i3 == 1) {
                    d2.b(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z;
    }

    public List<View> b(View view) {
        List d2 = this.f1214g.d(view);
        this.f1216i.clear();
        if (d2 != null) {
            this.f1216i.addAll(d2);
        }
        return this.f1216i;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (e(getChildAt(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z == this.r) {
            return;
        }
        if (z) {
            a();
        } else {
            c();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(View view, int i2) {
        View view2 = view;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f1231k != null) {
            Rect d2 = d();
            Rect d3 = d();
            Rect d4 = d();
            a(eVar.f1231k, d2);
            boolean z = false;
            a(view2, false, d3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = measuredHeight;
            a(view, i2, d2, d4, eVar, measuredWidth, measuredHeight);
            if (!(d4.left == d3.left && d4.top == d3.top)) {
                z = true;
            }
            a(eVar, d4, measuredWidth, i3);
            int i4 = d4.left - d3.left;
            int i5 = d4.top - d3.top;
            if (i4 != 0) {
                B.b(view2, i4);
            }
            if (i5 != 0) {
                B.c(view2, i5);
            }
            if (z) {
                b d5 = eVar.d();
                if (d5 != null) {
                    d5.b(this, view2, eVar.f1231k);
                }
            }
            a(d2);
            a(d3);
            a(d4);
        }
    }

    static b a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            str = sb.toString();
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f1208a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f1208a);
            sb2.append('.');
            sb2.append(str);
            str = sb2.toString();
        }
        try {
            Map map = (Map) f1210c.get();
            if (map == null) {
                map = new HashMap();
                f1210c.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f1209b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not inflate Behavior subclass ");
            sb3.append(str);
            throw new RuntimeException(sb3.toString(), e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, Rect rect) {
        d.a((ViewGroup) this, view, rect);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
            return;
        }
        if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public void b(View view, View view2, int i2, int i3) {
        this.x.a(view, view2, i2, i3);
        this.p = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.a(i3)) {
                b d2 = eVar.d();
                if (d2 != null) {
                    d2.a(this, childAt, view, view2, i2, i3);
                }
            }
        }
    }

    private void a(View view, int i2, Rect rect, Rect rect2, e eVar, int i3, int i4) {
        int i5;
        int i6;
        int a2 = C0243d.a(c(eVar.f1223c), i2);
        int a3 = C0243d.a(d(eVar.f1224d), i2);
        int i7 = a2 & 7;
        int i8 = a2 & 112;
        int i9 = a3 & 7;
        int i10 = a3 & 112;
        if (i9 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i9 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i10 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i10 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i7 == 1) {
            i5 -= i3 / 2;
        } else if (i7 != 5) {
            i5 -= i3;
        }
        if (i8 == 16) {
            i6 -= i4 / 2;
        } else if (i8 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    private void a(e eVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - eVar.bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, eVar, measuredWidth, measuredHeight);
        a(eVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i2) {
        Rect d2 = d();
        Rect d3 = d();
        try {
            a(view2, d2);
            a(view, i2, d2, d3);
            view.layout(d3.left, d3.top, d3.right, d3.bottom);
        } finally {
            a(d2);
            a(d3);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(int i2) {
        boolean z;
        int i3 = i2;
        int m2 = B.m(this);
        int size = this.f1213f.size();
        Rect d2 = d();
        Rect d3 = d();
        Rect d4 = d();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) this.f1213f.get(i4);
            e eVar = (e) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (eVar.f1232l == ((View) this.f1213f.get(i5))) {
                        b(view, m2);
                    }
                }
                a(view, true, d3);
                if (eVar.f1227g != 0 && !d3.isEmpty()) {
                    int a2 = C0243d.a(eVar.f1227g, m2);
                    int i6 = a2 & 112;
                    if (i6 == 48) {
                        d2.top = Math.max(d2.top, d3.bottom);
                    } else if (i6 == 80) {
                        d2.bottom = Math.max(d2.bottom, getHeight() - d3.top);
                    }
                    int i7 = a2 & 7;
                    if (i7 == 3) {
                        d2.left = Math.max(d2.left, d3.right);
                    } else if (i7 == 5) {
                        d2.right = Math.max(d2.right, getWidth() - d3.left);
                    }
                }
                if (eVar.f1228h != 0 && view.getVisibility() == 0) {
                    a(view, d2, m2);
                }
                if (i3 != 2) {
                    b(view, d4);
                    if (!d4.equals(d3)) {
                        c(view, d3);
                    }
                }
                for (int i8 = i4 + 1; i8 < size; i8++) {
                    View view2 = (View) this.f1213f.get(i8);
                    e eVar2 = (e) view2.getLayoutParams();
                    b d5 = eVar2.d();
                    if (d5 != null && d5.a(this, view2, view)) {
                        if (i3 != 0 || !eVar2.e()) {
                            if (i3 != 2) {
                                z = d5.b(this, view2, view);
                            } else {
                                d5.c(this, view2, view);
                                z = true;
                            }
                            if (i3 == 1) {
                                eVar2.a(z);
                            }
                        } else {
                            eVar2.g();
                        }
                    }
                }
            }
        }
        a(d2);
        a(d3);
        a(d4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f6  */
    private void a(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        if (B.C(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b d2 = eVar.d();
            Rect d3 = d();
            Rect d4 = d();
            d4.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 == null || !d2.a(this, view, d3)) {
                d3.set(d4);
            } else if (!d4.contains(d3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Rect should be within the child's bounds. Rect:");
                sb.append(d3.toShortString());
                sb.append(" | Bounds:");
                sb.append(d4.toShortString());
                throw new IllegalArgumentException(sb.toString());
            }
            a(d4);
            if (d3.isEmpty()) {
                a(d3);
                return;
            }
            int a2 = C0243d.a(eVar.f1228h, i2);
            if ((a2 & 48) == 48) {
                int i3 = (d3.top - eVar.topMargin) - eVar.f1230j;
                int i4 = rect.top;
                if (i3 < i4) {
                    f(view, i4 - i3);
                    z = true;
                    if ((a2 & 80) == 80) {
                        int height = ((getHeight() - d3.bottom) - eVar.bottomMargin) + eVar.f1230j;
                        int i5 = rect.bottom;
                        if (height < i5) {
                            f(view, height - i5);
                            z = true;
                        }
                    }
                    if (!z) {
                        f(view, 0);
                    }
                    if ((a2 & 3) == 3) {
                        int i6 = (d3.left - eVar.leftMargin) - eVar.f1229i;
                        int i7 = rect.left;
                        if (i6 < i7) {
                            e(view, i7 - i6);
                            z2 = true;
                            if ((a2 & 5) == 5) {
                                int width = ((getWidth() - d3.right) - eVar.rightMargin) + eVar.f1229i;
                                int i8 = rect.right;
                                if (width < i8) {
                                    e(view, width - i8);
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                e(view, 0);
                            }
                            a(d3);
                        }
                    }
                    z2 = false;
                    if ((a2 & 5) == 5) {
                    }
                    if (!z2) {
                    }
                    a(d3);
                }
            }
            z = false;
            if ((a2 & 80) == 80) {
            }
            if (!z) {
            }
            if ((a2 & 3) == 3) {
            }
            z2 = false;
            if ((a2 & 5) == 5) {
            }
            if (!z2) {
            }
            a(d3);
        }
    }

    public void a(View view) {
        List c2 = this.f1214g.c(view);
        if (c2 != null && !c2.isEmpty()) {
            for (int i2 = 0; i2 < c2.size(); i2++) {
                View view2 = (View) c2.get(i2);
                b d2 = ((e) view2.getLayoutParams()).d();
                if (d2 != null) {
                    d2.b(this, view2, view);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (this.m) {
            if (this.q == null) {
                this.q = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        this.r = true;
    }

    public boolean a(View view, int i2, int i3) {
        Rect d2 = d();
        a(view, d2);
        try {
            return d2.contains(i2, i3);
        } finally {
            a(d2);
        }
    }

    public boolean a(View view, View view2, int i2, int i3) {
        int i4 = i3;
        int childCount = getChildCount();
        boolean z = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b d2 = eVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i2, i3);
                    boolean z2 = z | b2;
                    eVar.a(i4, b2);
                    z = z2;
                } else {
                    eVar.a(i4, false);
                }
            }
        }
        return z;
    }

    public void a(View view, int i2) {
        this.x.a(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.a(i2)) {
                b d2 = eVar.d();
                if (d2 != null) {
                    d2.a(this, childAt, view, i2);
                }
                eVar.b(i2);
                eVar.g();
            }
        }
        this.p = null;
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                int i8 = i6;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i6)) {
                    b d2 = eVar.d();
                    if (d2 != null) {
                        d2.a(this, childAt, view, i2, i3, i4, i5, i6);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                int i10 = i4;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i4)) {
                    b d2 = eVar.d();
                    if (d2 != null) {
                        int[] iArr2 = this.f1217j;
                        iArr2[1] = 0;
                        iArr2[0] = 0;
                        d2.a(this, childAt, view, i2, i3, iArr2, i4);
                        if (i2 > 0) {
                            i5 = Math.max(i7, this.f1217j[0]);
                        } else {
                            i5 = Math.min(i7, this.f1217j[0]);
                        }
                        if (i3 > 0) {
                            i6 = Math.max(i8, this.f1217j[1]);
                        } else {
                            i6 = Math.min(i8, this.f1217j[1]);
                        }
                        i7 = i5;
                        i8 = i6;
                        z = true;
                    }
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z) {
            a(1);
        }
    }
}
