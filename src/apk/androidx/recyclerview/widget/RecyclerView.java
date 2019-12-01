package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import b.g.i.B;
import b.g.i.C;
import b.g.i.C0240a;
import b.g.i.C0248i;
import b.g.i.C0249j;
import b.g.i.C0252m;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements b.g.i.u, C0249j {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1733a = {16843830};

    /* renamed from: b reason: collision with root package name */
    private static final int[] f1734b = {16842987};

    /* renamed from: c reason: collision with root package name */
    static final boolean f1735c;

    /* renamed from: d reason: collision with root package name */
    static final boolean f1736d = (VERSION.SDK_INT >= 23);

    /* renamed from: e reason: collision with root package name */
    static final boolean f1737e = (VERSION.SDK_INT >= 16);

    /* renamed from: f reason: collision with root package name */
    static final boolean f1738f = (VERSION.SDK_INT >= 21);

    /* renamed from: g reason: collision with root package name */
    private static final boolean f1739g = (VERSION.SDK_INT <= 15);

    /* renamed from: h reason: collision with root package name */
    private static final boolean f1740h = (VERSION.SDK_INT <= 15);

    /* renamed from: i reason: collision with root package name */
    private static final Class<?>[] f1741i;

    /* renamed from: j reason: collision with root package name */
    static final Interpolator f1742j = new N();
    private m A;
    private final int[] Aa;
    boolean B;
    private C0252m Ba;
    boolean C;
    private final int[] Ca;
    boolean D;
    final int[] Da;
    boolean E;
    private final int[] Ea;
    private int F;
    final int[] Fa;
    boolean G;
    final List<x> Ga;
    boolean H;
    private Runnable Ha;
    private boolean I;
    private final b Ia;
    private int J;
    boolean K;
    private final AccessibilityManager L;
    private List<k> M;
    boolean N;
    boolean O;
    private int P;
    private int Q;
    private e R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    private EdgeEffect V;
    f W;
    private int aa;
    private int ba;
    private VelocityTracker ca;
    private int da;
    private int ea;
    private int fa;
    private int ga;
    private int ha;
    private l ia;
    private final int ja;

    /* renamed from: k reason: collision with root package name */
    private final r f1743k;
    private final int ka;

    /* renamed from: l reason: collision with root package name */
    final p f1744l;
    private float la;
    private s m;
    private float ma;
    C0215a n;
    private boolean na;
    C0222h o;
    final w oa;
    final ea p;
    C0238y pa;
    boolean q;
    a qa;
    final Runnable r;
    final u ra;
    final Rect s;
    private n sa;
    private final Rect t;
    private List<n> ta;
    final RectF u;
    boolean ua;
    a v;
    boolean va;
    i w;
    private b wa;
    q x;
    boolean xa;
    final ArrayList<h> y;
    V ya;
    private final ArrayList<m> z;
    private d za;

    public static abstract class a<VH extends x> {
        private boolean mHasStableIds = false;
        private final b mObservable = new b();

        public final void bindViewHolder(VH vh, int i2) {
            vh.mPosition = i2;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i2);
            }
            vh.setFlags(1, 519);
            androidx.core.os.b.a("RV OnBindView");
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).f1774c = true;
            }
            androidx.core.os.b.a();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.os.b.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i2;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.b.a();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i2) {
            return -1;
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.b(i2, 1);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.c(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.a(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.b(i2, i3);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.d(i2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.a(i2, 1, obj);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.a(i2, i3, obj);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b(i2, i3);
            }
        }

        public void d(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i2, i3);
            }
        }

        public void a(int i2, int i3, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i2, i3, obj);
            }
        }

        public void b(int i2, int i3) {
            a(i2, i3, null);
        }

        public void a(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i2, i3, 1);
            }
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i2, int i3) {
        }

        public void a(int i2, int i3, int i4) {
        }

        public void a(int i2, int i3, Object obj) {
            a(i2, i3);
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3) {
        }
    }

    public interface d {
        int a(int i2, int i3);
    }

    public static class e {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class f {

        /* renamed from: a reason: collision with root package name */
        private b f1745a = null;

        /* renamed from: b reason: collision with root package name */
        private ArrayList<a> f1746b = new ArrayList<>();

        /* renamed from: c reason: collision with root package name */
        private long f1747c = 120;

        /* renamed from: d reason: collision with root package name */
        private long f1748d = 120;

        /* renamed from: e reason: collision with root package name */
        private long f1749e = 250;

        /* renamed from: f reason: collision with root package name */
        private long f1750f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(x xVar);
        }

        public static class c {

            /* renamed from: a reason: collision with root package name */
            public int f1751a;

            /* renamed from: b reason: collision with root package name */
            public int f1752b;

            /* renamed from: c reason: collision with root package name */
            public int f1753c;

            /* renamed from: d reason: collision with root package name */
            public int f1754d;

            public c a(x xVar) {
                a(xVar, 0);
                return this;
            }

            public c a(x xVar, int i2) {
                View view = xVar.itemView;
                this.f1751a = view.getLeft();
                this.f1752b = view.getTop();
                this.f1753c = view.getRight();
                this.f1754d = view.getBottom();
                return this;
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(b bVar) {
            this.f1745a = bVar;
        }

        public abstract boolean a(x xVar, c cVar, c cVar2);

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public abstract void b();

        public abstract boolean b(x xVar);

        public abstract boolean b(x xVar, c cVar, c cVar2);

        public long c() {
            return this.f1747c;
        }

        public abstract boolean c(x xVar, c cVar, c cVar2);

        public long d() {
            return this.f1750f;
        }

        public abstract void d(x xVar);

        public long e() {
            return this.f1749e;
        }

        public void e(x xVar) {
        }

        public long f() {
            return this.f1748d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        public c a(u uVar, x xVar, int i2, List<Object> list) {
            c h2 = h();
            h2.a(xVar);
            return h2;
        }

        public final void c(x xVar) {
            e(xVar);
            b bVar = this.f1745a;
            if (bVar != null) {
                bVar.a(xVar);
            }
        }

        public c a(u uVar, x xVar) {
            c h2 = h();
            h2.a(xVar);
            return h2;
        }

        static int a(x xVar) {
            int i2 = xVar.mFlags & 14;
            if (xVar.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) == 0) {
                int oldPosition = xVar.getOldPosition();
                int adapterPosition = xVar.getAdapterPosition();
                if (!(oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition)) {
                    i2 |= 2048;
                }
            }
            return i2;
        }

        public final boolean a(a aVar) {
            boolean g2 = g();
            if (aVar != null) {
                if (!g2) {
                    aVar.a();
                } else {
                    this.f1746b.add(aVar);
                }
            }
            return g2;
        }

        public boolean a(x xVar, List<Object> list) {
            return b(xVar);
        }

        public final void a() {
            int size = this.f1746b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a) this.f1746b.get(i2)).a();
            }
            this.f1746b.clear();
        }
    }

    private class g implements b {
        g() {
        }

        public void a(x xVar) {
            xVar.setIsRecyclable(true);
            if (xVar.mShadowedHolder != null && xVar.mShadowingHolder == null) {
                xVar.mShadowedHolder = null;
            }
            xVar.mShadowingHolder = null;
            if (!xVar.shouldBeKeptAsChild() && !RecyclerView.this.m(xVar.itemView) && xVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(xVar.itemView, false);
            }
        }
    }

    public static abstract class h {
        @Deprecated
        public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, u uVar) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
            getItemOffsets(rect, ((j) view.getLayoutParams()).n(), recyclerView);
        }
    }

    public static abstract class i {

        /* renamed from: a reason: collision with root package name */
        C0222h f1756a;

        /* renamed from: b reason: collision with root package name */
        RecyclerView f1757b;

        /* renamed from: c reason: collision with root package name */
        private final b f1758c = new S(this);

        /* renamed from: d reason: collision with root package name */
        private final b f1759d = new T(this);

        /* renamed from: e reason: collision with root package name */
        da f1760e = new da(this.f1758c);

        /* renamed from: f reason: collision with root package name */
        da f1761f = new da(this.f1759d);

        /* renamed from: g reason: collision with root package name */
        t f1762g;

        /* renamed from: h reason: collision with root package name */
        boolean f1763h = false;

        /* renamed from: i reason: collision with root package name */
        boolean f1764i = false;

        /* renamed from: j reason: collision with root package name */
        boolean f1765j = false;

        /* renamed from: k reason: collision with root package name */
        private boolean f1766k = true;

        /* renamed from: l reason: collision with root package name */
        private boolean f1767l = true;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        public interface a {
            void a(int i2, int i3);
        }

        public static class b {

            /* renamed from: a reason: collision with root package name */
            public int f1768a;

            /* renamed from: b reason: collision with root package name */
            public int f1769b;

            /* renamed from: c reason: collision with root package name */
            public boolean f1770c;

            /* renamed from: d reason: collision with root package name */
            public boolean f1771d;
        }

        public static int c(int i2, int i3, int i4) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i3, i4));
            }
            if (mode != 1073741824) {
                size = Math.max(i3, i4);
            }
            return size;
        }

        /* access modifiers changed from: 0000 */
        public boolean A() {
            return false;
        }

        /* access modifiers changed from: 0000 */
        public void B() {
            t tVar = this.f1762g;
            if (tVar != null) {
                tVar.h();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i2, p pVar, u uVar) {
            return 0;
        }

        public int a(u uVar) {
            return 0;
        }

        public View a(View view, int i2, p pVar, u uVar) {
            return null;
        }

        public void a(int i2, int i3, u uVar, a aVar) {
        }

        public void a(int i2, a aVar) {
        }

        public void a(Rect rect, int i2, int i3) {
            c(c(i2, rect.width() + getPaddingLeft() + getPaddingRight(), n()), c(i3, rect.height() + getPaddingTop() + getPaddingBottom(), m()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        public boolean a(p pVar, u uVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public int b(int i2, p pVar, u uVar) {
            return 0;
        }

        public int b(u uVar) {
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2, int i3) {
            this.q = MeasureSpec.getSize(i2);
            this.o = MeasureSpec.getMode(i2);
            if (this.o == 0 && !RecyclerView.f1736d) {
                this.q = 0;
            }
            this.r = MeasureSpec.getSize(i3);
            this.p = MeasureSpec.getMode(i3);
            if (this.p == 0 && !RecyclerView.f1736d) {
                this.r = 0;
            }
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean b() {
            return false;
        }

        public int c(p pVar, u uVar) {
            return 0;
        }

        public int c(u uVar) {
            return 0;
        }

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean c() {
            return false;
        }

        public int d(u uVar) {
            return 0;
        }

        public View d(View view, int i2) {
            return null;
        }

        public abstract j d();

        /* access modifiers changed from: 0000 */
        public void d(int i2, int i3) {
            int f2 = f();
            if (f2 == 0) {
                this.f1757b.c(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < f2; i8++) {
                View f3 = f(i8);
                Rect rect = this.f1757b.s;
                b(f3, rect);
                int i9 = rect.left;
                if (i9 < i4) {
                    i4 = i9;
                }
                int i10 = rect.right;
                if (i10 > i6) {
                    i6 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f1757b.s.set(i4, i5, i6, i7);
            a(this.f1757b.s, i2, i3);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d(p pVar, u uVar) {
            return false;
        }

        public int e() {
            return -1;
        }

        public int e(u uVar) {
            return 0;
        }

        public void e(p pVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int f(u uVar) {
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public void f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1757b = null;
                this.f1756a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f1757b = recyclerView;
                this.f1756a = recyclerView.o;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void g(u uVar) {
        }

        public boolean g() {
            RecyclerView recyclerView = this.f1757b;
            return recyclerView != null && recyclerView.q;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return B.p(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return B.q(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public View h() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null) {
                return null;
            }
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null || this.f1756a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int i() {
            return this.r;
        }

        public void i(int i2) {
        }

        public void j(int i2) {
            if (f(i2) != null) {
                this.f1756a.e(i2);
            }
        }

        public int k() {
            RecyclerView recyclerView = this.f1757b;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void k(int i2) {
        }

        public int l() {
            return B.m(this.f1757b);
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).n();
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).f1773b.right;
        }

        public int o() {
            return this.q;
        }

        public void p(View view) {
            this.f1756a.d(view);
        }

        /* access modifiers changed from: 0000 */
        public boolean q() {
            int f2 = f();
            for (int i2 = 0; i2 < f2; i2++) {
                LayoutParams layoutParams = f(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean r() {
            return this.f1764i;
        }

        public boolean s() {
            return this.f1765j;
        }

        public final boolean t() {
            return this.f1767l;
        }

        public boolean u() {
            return this.f1766k;
        }

        public boolean v() {
            t tVar = this.f1762g;
            return tVar != null && tVar.e();
        }

        public Parcelable w() {
            return null;
        }

        public void x() {
            for (int f2 = f() - 1; f2 >= 0; f2--) {
                this.f1756a.e(f2);
            }
        }

        public void y() {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.f1763h = true;
        }

        public View e(int i2) {
            int f2 = f();
            for (int i3 = 0; i3 < f2; i3++) {
                View f3 = f(i3);
                x i4 = RecyclerView.i(f3);
                if (i4 != null && i4.getLayoutPosition() == i2 && !i4.shouldIgnore() && (this.f1757b.ra.d() || !i4.isRemoved())) {
                    return f3;
                }
            }
            return null;
        }

        public void g(int i2) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                recyclerView.f(i2);
            }
        }

        public int i(View view) {
            Rect rect = ((j) view.getLayoutParams()).f1773b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).f1773b.left;
        }

        public int m() {
            return B.n(this.f1757b);
        }

        public int n() {
            return B.o(this.f1757b);
        }

        public int o(View view) {
            return ((j) view.getLayoutParams()).f1773b.top;
        }

        public int p() {
            return this.o;
        }

        public int j() {
            return this.p;
        }

        public int k(View view) {
            return view.getTop() - o(view);
        }

        public int g(View view) {
            return view.getLeft() - l(view);
        }

        public void h(int i2) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                recyclerView.g(i2);
            }
        }

        public int j(View view) {
            return view.getRight() + n(view);
        }

        public void c(View view) {
            b(view, -1);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void c(View view, int i2) {
            a(view, i2, (j) view.getLayoutParams());
        }

        public int h(View view) {
            Rect rect = ((j) view.getLayoutParams()).f1773b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* access modifiers changed from: 0000 */
        public void c(p pVar) {
            int e2 = pVar.e();
            for (int i2 = e2 - 1; i2 >= 0; i2--) {
                View c2 = pVar.c(i2);
                x i3 = RecyclerView.i(c2);
                if (!i3.shouldIgnore()) {
                    i3.setIsRecyclable(false);
                    if (i3.isTmpDetached()) {
                        this.f1757b.removeDetachedView(c2, false);
                    }
                    f fVar = this.f1757b.W;
                    if (fVar != null) {
                        fVar.d(i3);
                    }
                    i3.setIsRecyclable(true);
                    pVar.a(c2);
                }
            }
            pVar.c();
            if (e2 > 0) {
                this.f1757b.invalidate();
            }
        }

        public int e(View view) {
            return ((j) view.getLayoutParams()).f1773b.bottom;
        }

        @Deprecated
        public void a(boolean z) {
            this.f1765j = z;
        }

        /* access modifiers changed from: 0000 */
        public void e(RecyclerView recyclerView) {
            b(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: 0000 */
        public void a(RecyclerView recyclerView) {
            this.f1764i = true;
            b(recyclerView);
        }

        public void b(RecyclerView recyclerView, p pVar) {
            c(recyclerView);
        }

        public void b(t tVar) {
            t tVar2 = this.f1762g;
            if (!(tVar2 == null || tVar == tVar2 || !tVar2.e())) {
                this.f1762g.h();
            }
            this.f1762g = tVar;
            this.f1762g.a(this.f1757b, this);
        }

        /* access modifiers changed from: 0000 */
        public void a(RecyclerView recyclerView, p pVar) {
            this.f1764i = false;
            b(recyclerView, pVar);
        }

        public int f() {
            C0222h hVar = this.f1756a;
            if (hVar != null) {
                return hVar.a();
            }
            return 0;
        }

        public View d(View view) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null) {
                return null;
            }
            View c2 = recyclerView.c(view);
            if (c2 != null && !this.f1756a.c(c2)) {
                return c2;
            }
            return null;
        }

        public View f(int i2) {
            C0222h hVar = this.f1756a;
            if (hVar != null) {
                return hVar.c(i2);
            }
            return null;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int f(View view) {
            return view.getBottom() + e(view);
        }

        public j a(LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new j((MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public void b(View view) {
            a(view, -1);
        }

        public void d(int i2) {
            b(i2, f(i2));
        }

        private static boolean d(int i2, int i3, int i4) {
            int mode = MeasureSpec.getMode(i3);
            int size = MeasureSpec.getSize(i3);
            boolean z = false;
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                if (size >= i2) {
                    z = true;
                }
                return z;
            } else if (mode == 0) {
                return true;
            } else {
                if (mode != 1073741824) {
                    return false;
                }
                if (size == i2) {
                    z = true;
                }
                return z;
            }
        }

        public void b(View view, int i2) {
            a(view, i2, false);
        }

        private void b(int i2, View view) {
            this.f1756a.a(i2);
        }

        private boolean d(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int o2 = o() - getPaddingRight();
            int i4 = i() - getPaddingBottom();
            Rect rect = this.f1757b.s;
            b(focusedChild, rect);
            if (rect.left - i2 >= o2 || rect.right - i2 <= paddingLeft || rect.top - i3 >= i4 || rect.bottom - i3 <= paddingTop) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean b(View view, int i2, int i3, j jVar) {
            return !this.f1766k || !d(view.getMeasuredWidth(), i2, jVar.width) || !d(view.getMeasuredHeight(), i3, jVar.height);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void c(int i2, int i3) {
            this.f1757b.setMeasuredDimension(i2, i3);
        }

        public void a(RecyclerView recyclerView, u uVar, int i2) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void b(View view, int i2, int i3) {
            j jVar = (j) view.getLayoutParams();
            Rect j2 = this.f1757b.j(view);
            int i4 = i3 + j2.top + j2.bottom;
            int a2 = a(o(), p(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i2 + j2.left + j2.right, jVar.width, b());
            int a3 = a(i(), j(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, c());
            if (a(view, a2, a3, jVar)) {
                view.measure(a2, a3);
            }
        }

        public void a(View view, int i2) {
            a(view, i2, true);
        }

        private void a(View view, int i2, boolean z) {
            x i3 = RecyclerView.i(view);
            if (z || i3.isRemoved()) {
                this.f1757b.p.a(i3);
            } else {
                this.f1757b.p.g(i3);
            }
            j jVar = (j) view.getLayoutParams();
            if (i3.wasReturnedFromScrap() || i3.isScrap()) {
                if (i3.isScrap()) {
                    i3.unScrap();
                } else {
                    i3.clearReturnedFromScrapFlag();
                }
                this.f1756a.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1757b) {
                int b2 = this.f1756a.b(view);
                if (i2 == -1) {
                    i2 = this.f1756a.a();
                }
                if (b2 == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.f1757b.indexOfChild(view));
                    sb.append(this.f1757b.i());
                    throw new IllegalStateException(sb.toString());
                } else if (b2 != i2) {
                    this.f1757b.w.a(b2, i2);
                }
            } else {
                this.f1756a.a(view, i2, false);
                jVar.f1774c = true;
                t tVar = this.f1762g;
                if (tVar != null && tVar.e()) {
                    this.f1762g.b(view);
                }
            }
            if (jVar.f1775d) {
                i3.itemView.invalidate();
                jVar.f1775d = false;
            }
        }

        public void b(View view, Rect rect) {
            RecyclerView.b(view, rect);
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int o2 = o() - getPaddingRight();
            int i2 = i() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i3 = left - paddingLeft;
            int min = Math.min(0, i3);
            int i4 = top - paddingTop;
            int min2 = Math.min(0, i4);
            int i5 = width - o2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, height - i2);
            if (l() != 1) {
                if (min == 0) {
                    min = Math.min(i3, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i5);
            }
            if (min2 == 0) {
                min2 = Math.min(i4, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public void a(View view, int i2, j jVar) {
            x i3 = RecyclerView.i(view);
            if (i3.isRemoved()) {
                this.f1757b.p.a(i3);
            } else {
                this.f1757b.p.g(i3);
            }
            this.f1756a.a(view, i2, jVar, i3.isRemoved());
        }

        public void a(int i2, int i3) {
            View f2 = f(i2);
            if (f2 != null) {
                d(i2);
                c(f2, i3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot move a child from non-existing index:");
            sb.append(i2);
            sb.append(this.f1757b.toString());
            throw new IllegalArgumentException(sb.toString());
        }

        public void b(p pVar) {
            for (int f2 = f() - 1; f2 >= 0; f2--) {
                if (!RecyclerView.i(f(f2)).shouldIgnore()) {
                    a(f2, pVar);
                }
            }
        }

        public void a(View view, p pVar) {
            p(view);
            pVar.b(view);
        }

        public int b(p pVar, u uVar) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null || recyclerView.v == null || !c()) {
                return 1;
            }
            return this.f1757b.v.getItemCount();
        }

        public void a(int i2, p pVar) {
            View f2 = f(i2);
            j(i2);
            pVar.b(f2);
        }

        public void a(p pVar) {
            for (int f2 = f() - 1; f2 >= 0; f2--) {
                a(pVar, f2, f(f2));
            }
        }

        private void a(p pVar, int i2, View view) {
            x i3 = RecyclerView.i(view);
            if (!i3.shouldIgnore()) {
                if (!i3.isInvalid() || i3.isRemoved() || this.f1757b.v.hasStableIds()) {
                    d(i2);
                    pVar.c(view);
                    this.f1757b.p.d(i3);
                } else {
                    j(i2);
                    pVar.b(i3);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(View view, int i2, int i3, j jVar) {
            return view.isLayoutRequested() || !this.f1766k || !d(view.getWidth(), i2, jVar.width) || !d(view.getHeight(), i3, jVar.height);
        }

        public static int a(int i2, int i3, int i4, int i5, boolean z) {
            int i6;
            int i7 = i2 - i4;
            int i8 = 0;
            int max = Math.max(0, i7);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 == Integer.MIN_VALUE || (i3 != 0 && i3 == 1073741824)) {
                            i6 = max;
                        } else {
                            i3 = 0;
                            i6 = 0;
                        }
                        i8 = i3;
                        max = i6;
                        return MeasureSpec.makeMeasureSpec(max, i8);
                    }
                    max = 0;
                    return MeasureSpec.makeMeasureSpec(max, i8);
                }
            } else if (i5 < 0) {
                if (i5 == -1) {
                    i8 = i3;
                } else {
                    if (i5 == -2) {
                        if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                            i8 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return MeasureSpec.makeMeasureSpec(max, i8);
            }
            max = i5;
            i8 = 1073741824;
            return MeasureSpec.makeMeasureSpec(max, i8);
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.f1773b;
            view.layout(i2 + rect.left + jVar.leftMargin, i3 + rect.top + jVar.topMargin, (i4 - rect.right) - jVar.rightMargin, (i5 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).f1773b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1757b != null) {
                Matrix matrix = view.getMatrix();
                if (matrix != null && !matrix.isIdentity()) {
                    RectF rectF = this.f1757b.u;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j(view));
            }
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i2 = b2[0];
            int i3 = b2[1];
            if ((z2 && !d(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.i(i2, i3);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.f1760e.a(view, 24579) && this.f1761f.a(view, 24579);
            return z ? z3 : !z3;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return v() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, u uVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
            c(recyclerView, i2, i3);
        }

        public void a(p pVar, u uVar, int i2, int i3) {
            this.f1757b.c(i2, i3);
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar) {
            if (this.f1762g == tVar) {
                this.f1762g = null;
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(b.g.i.a.d dVar) {
            RecyclerView recyclerView = this.f1757b;
            a(recyclerView.f1744l, recyclerView.ra, dVar);
        }

        public void a(p pVar, u uVar, b.g.i.a.d dVar) {
            if (this.f1757b.canScrollVertically(-1) || this.f1757b.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.j(true);
            }
            if (this.f1757b.canScrollVertically(1) || this.f1757b.canScrollHorizontally(1)) {
                dVar.a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
                dVar.j(true);
            }
            dVar.a((Object) b.g.i.a.d.b.a(b(pVar, uVar), a(pVar, uVar), d(pVar, uVar), c(pVar, uVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1757b;
            a(recyclerView.f1744l, recyclerView.ra, accessibilityEvent);
        }

        public void a(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f1757b.canScrollVertically(-1) && !this.f1757b.canScrollHorizontally(-1) && !this.f1757b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                a aVar = this.f1757b.v;
                if (aVar != null) {
                    accessibilityEvent.setItemCount(aVar.getItemCount());
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(View view, b.g.i.a.d dVar) {
            x i2 = RecyclerView.i(view);
            if (i2 != null && !i2.isRemoved() && !this.f1756a.c(i2.itemView)) {
                RecyclerView recyclerView = this.f1757b;
                a(recyclerView.f1744l, recyclerView.ra, view, dVar);
            }
        }

        public void a(p pVar, u uVar, View view, b.g.i.a.d dVar) {
            dVar.b((Object) b.g.i.a.d.c.a(c() ? m(view) : 0, 1, b() ? m(view) : 0, 1, false, false));
        }

        public int a(p pVar, u uVar) {
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null || recyclerView.v == null || !b()) {
                return 1;
            }
            return this.f1757b.v.getItemCount();
        }

        /* access modifiers changed from: 0000 */
        public boolean a(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1757b;
            return a(recyclerView.f1744l, recyclerView.ra, i2, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
        public boolean a(p pVar, u uVar, int i2, Bundle bundle) {
            int i3;
            int i4;
            RecyclerView recyclerView = this.f1757b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                i4 = recyclerView.canScrollVertically(1) ? (i() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.f1757b.canScrollHorizontally(1)) {
                    i3 = (o() - getPaddingLeft()) - getPaddingRight();
                    if (i4 != 0) {
                    }
                    this.f1757b.i(i3, i4);
                    return true;
                }
            } else if (i2 != 8192) {
                i4 = 0;
            } else {
                i4 = recyclerView.canScrollVertically(-1) ? -((i() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.f1757b.canScrollHorizontally(-1)) {
                    i3 = -((o() - getPaddingLeft()) - getPaddingRight());
                    if (i4 != 0 && i3 == 0) {
                        return false;
                    }
                    this.f1757b.i(i3, i4);
                    return true;
                }
            }
            i3 = 0;
            if (i4 != 0) {
            }
            this.f1757b.i(i3, i4);
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1757b;
            return a(recyclerView.f1744l, recyclerView.ra, view, i2, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.n.b.RecyclerView, i2, i3);
            bVar.f1768a = obtainStyledAttributes.getInt(b.n.b.RecyclerView_android_orientation, 1);
            bVar.f1769b = obtainStyledAttributes.getInt(b.n.b.RecyclerView_spanCount, 1);
            bVar.f1770c = obtainStyledAttributes.getBoolean(b.n.b.RecyclerView_reverseLayout, false);
            bVar.f1771d = obtainStyledAttributes.getBoolean(b.n.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }
    }

    public static class j extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        x f1772a;

        /* renamed from: b reason: collision with root package name */
        final Rect f1773b = new Rect();

        /* renamed from: c reason: collision with root package name */
        boolean f1774c = true;

        /* renamed from: d reason: collision with root package name */
        boolean f1775d = false;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int n() {
            return this.f1772a.getLayoutPosition();
        }

        public boolean o() {
            return this.f1772a.isUpdated();
        }

        public boolean p() {
            return this.f1772a.isRemoved();
        }

        public boolean q() {
            return this.f1772a.isInvalid();
        }

        public j(int i2, int i3) {
            super(i2, i3);
        }

        public j(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public j(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public j(j jVar) {
            super(jVar);
        }
    }

    public interface k {
        void a(View view);

        void b(View view);
    }

    public static abstract class l {
        public abstract boolean a(int i2, int i3);
    }

    public interface m {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class o {

        /* renamed from: a reason: collision with root package name */
        SparseArray<a> f1776a = new SparseArray<>();

        /* renamed from: b reason: collision with root package name */
        private int f1777b = 0;

        static class a {

            /* renamed from: a reason: collision with root package name */
            final ArrayList<x> f1778a = new ArrayList<>();

            /* renamed from: b reason: collision with root package name */
            int f1779b = 5;

            /* renamed from: c reason: collision with root package name */
            long f1780c = 0;

            /* renamed from: d reason: collision with root package name */
            long f1781d = 0;

            a() {
            }
        }

        public x a(int i2) {
            a aVar = (a) this.f1776a.get(i2);
            if (aVar == null || aVar.f1778a.isEmpty()) {
                return null;
            }
            ArrayList<x> arrayList = aVar.f1778a;
            return (x) arrayList.remove(arrayList.size() - 1);
        }

        public void b() {
            for (int i2 = 0; i2 < this.f1776a.size(); i2++) {
                ((a) this.f1776a.valueAt(i2)).f1778a.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        public void c() {
            this.f1777b--;
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2, long j2) {
            a b2 = b(i2);
            b2.f1780c = a(b2.f1780c, j2);
        }

        public void a(x xVar) {
            int itemViewType = xVar.getItemViewType();
            ArrayList<x> arrayList = b(itemViewType).f1778a;
            if (((a) this.f1776a.get(itemViewType)).f1779b > arrayList.size()) {
                xVar.resetInternal();
                arrayList.add(xVar);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean b(int i2, long j2, long j3) {
            long j4 = b(i2).f1780c;
            return j4 == 0 || j2 + j4 < j3;
        }

        private a b(int i2) {
            a aVar = (a) this.f1776a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1776a.put(i2, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: 0000 */
        public long a(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, long j2) {
            a b2 = b(i2);
            b2.f1781d = a(b2.f1781d, j2);
        }

        /* access modifiers changed from: 0000 */
        public boolean a(int i2, long j2, long j3) {
            long j4 = b(i2).f1781d;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f1777b++;
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f1777b == 0) {
                b();
            }
            if (aVar2 != null) {
                a();
            }
        }
    }

    public final class p {

        /* renamed from: a reason: collision with root package name */
        final ArrayList<x> f1782a = new ArrayList<>();

        /* renamed from: b reason: collision with root package name */
        ArrayList<x> f1783b = null;

        /* renamed from: c reason: collision with root package name */
        final ArrayList<x> f1784c = new ArrayList<>();

        /* renamed from: d reason: collision with root package name */
        private final List<x> f1785d = Collections.unmodifiableList(this.f1782a);

        /* renamed from: e reason: collision with root package name */
        private int f1786e = 2;

        /* renamed from: f reason: collision with root package name */
        int f1787f = 2;

        /* renamed from: g reason: collision with root package name */
        o f1788g;

        /* renamed from: h reason: collision with root package name */
        private v f1789h;

        public p() {
        }

        private void e(x xVar) {
            if (RecyclerView.this.n()) {
                View view = xVar.itemView;
                if (B.k(view) == 0) {
                    B.e(view, 1);
                }
                if (!B.w(view)) {
                    xVar.addFlags(16384);
                    B.a(view, RecyclerView.this.ya.b());
                }
            }
        }

        public void a() {
            this.f1782a.clear();
            i();
        }

        /* access modifiers changed from: 0000 */
        public View b(int i2, boolean z) {
            return a(i2, z, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: 0000 */
        public void c(View view) {
            x i2 = RecyclerView.i(view);
            if (!i2.hasAnyOfTheFlags(12) && i2.isUpdated() && !RecyclerView.this.a(i2)) {
                if (this.f1783b == null) {
                    this.f1783b = new ArrayList<>();
                }
                i2.setScrapContainer(this, true);
                this.f1783b.add(i2);
            } else if (!i2.isInvalid() || i2.isRemoved() || RecyclerView.this.v.hasStableIds()) {
                i2.setScrapContainer(this, false);
                this.f1782a.add(i2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean d(x xVar) {
            if (xVar.isRemoved()) {
                return RecyclerView.this.ra.d();
            }
            int i2 = xVar.mPosition;
            if (i2 < 0 || i2 >= RecyclerView.this.v.getItemCount()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistency detected. Invalid view holder adapter position");
                sb.append(xVar);
                sb.append(RecyclerView.this.i());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            boolean z = false;
            if (!RecyclerView.this.ra.d() && RecyclerView.this.v.getItemViewType(xVar.mPosition) != xVar.getItemViewType()) {
                return false;
            }
            if (!RecyclerView.this.v.hasStableIds()) {
                return true;
            }
            if (xVar.getItemId() == RecyclerView.this.v.getItemId(xVar.mPosition)) {
                z = true;
            }
            return z;
        }

        public void f(int i2) {
            this.f1786e = i2;
            j();
        }

        /* access modifiers changed from: 0000 */
        public void g() {
            int size = this.f1784c.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = (j) ((x) this.f1784c.get(i2)).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.f1774c = true;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void h() {
            int size = this.f1784c.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = (x) this.f1784c.get(i2);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.addChangePayload(null);
                }
            }
            a aVar = RecyclerView.this.v;
            if (aVar == null || !aVar.hasStableIds()) {
                i();
            }
        }

        /* access modifiers changed from: 0000 */
        public void i() {
            for (int size = this.f1784c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.f1784c.clear();
            if (RecyclerView.f1738f) {
                RecyclerView.this.qa.a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void j() {
            i iVar = RecyclerView.this.w;
            this.f1787f = this.f1786e + (iVar != null ? iVar.m : 0);
            for (int size = this.f1784c.size() - 1; size >= 0 && this.f1784c.size() > this.f1787f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            x i2 = RecyclerView.i(view);
            if (i2.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (i2.isScrap()) {
                i2.unScrap();
            } else if (i2.wasReturnedFromScrap()) {
                i2.clearReturnedFromScrapFlag();
            }
            b(i2);
        }

        private boolean a(x xVar, int i2, int i3, long j2) {
            xVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = xVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f1788g.a(itemViewType, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.v.bindViewHolder(xVar, i2);
            this.f1788g.a(xVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(xVar);
            if (RecyclerView.this.ra.d()) {
                xVar.mPreLayoutPosition = i3;
            }
            return true;
        }

        public List<x> f() {
            return this.f1785d;
        }

        private void f(x xVar) {
            View view = xVar.itemView;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        /* access modifiers changed from: 0000 */
        public void b(x xVar) {
            boolean z;
            boolean z2 = false;
            if (xVar.isScrap() || xVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.isScrap());
                sb.append(" isAttached:");
                if (xVar.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            } else if (xVar.isTmpDetached()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(xVar);
                sb2.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb2.toString());
            } else if (!xVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = xVar.doesTransientStatePreventRecycling();
                a aVar = RecyclerView.this.v;
                if ((aVar != null && doesTransientStatePreventRecycling && aVar.onFailedToRecycleView(xVar)) || xVar.isRecyclable()) {
                    if (this.f1787f <= 0 || xVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f1784c.size();
                        if (size >= this.f1787f && size > 0) {
                            e(0);
                            size--;
                        }
                        if (RecyclerView.f1738f && size > 0 && !RecyclerView.this.qa.a(xVar.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.qa.a(((x) this.f1784c.get(i2)).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f1784c.add(size, xVar);
                        z = true;
                    }
                    if (!z) {
                        a(xVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.p.h(xVar);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    xVar.mOwnerRecyclerView = null;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                sb3.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        public void e(int i2) {
            a((x) this.f1784c.get(i2), true);
            this.f1784c.remove(i2);
        }

        public View d(int i2) {
            return b(i2, false);
        }

        /* access modifiers changed from: 0000 */
        public o d() {
            if (this.f1788g == null) {
                this.f1788g = new o();
            }
            return this.f1788g;
        }

        /* access modifiers changed from: 0000 */
        public void c(x xVar) {
            if (xVar.mInChangeScrap) {
                this.f1783b.remove(xVar);
            } else {
                this.f1782a.remove(xVar);
            }
            xVar.mScrapContainer = null;
            xVar.mInChangeScrap = false;
            xVar.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: 0000 */
        public int e() {
            return this.f1782a.size();
        }

        public int a(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.ra.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(i2);
                sb.append(". State ");
                sb.append("item count is ");
                sb.append(RecyclerView.this.ra.a());
                sb.append(RecyclerView.this.i());
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (!RecyclerView.this.ra.d()) {
                return i2;
            } else {
                return RecyclerView.this.n.b(i2);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a6  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01c9  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0210  */
        public x a(int i2, boolean z, long j2) {
            boolean z2;
            x xVar;
            x xVar2;
            boolean z3;
            LayoutParams layoutParams;
            j jVar;
            int i3 = i2;
            boolean z4 = z;
            if (i3 < 0 || i3 >= RecyclerView.this.ra.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i3);
                sb.append("(");
                sb.append(i3);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.ra.a());
                sb.append(RecyclerView.this.i());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            boolean z5 = true;
            if (RecyclerView.this.ra.d()) {
                xVar = b(i2);
                if (xVar != null) {
                    z2 = true;
                    if (xVar == null) {
                        xVar = a(i2, z);
                        if (xVar != null) {
                            if (!d(xVar)) {
                                if (!z4) {
                                    xVar.addFlags(4);
                                    if (xVar.isScrap()) {
                                        RecyclerView.this.removeDetachedView(xVar.itemView, false);
                                        xVar.unScrap();
                                    } else if (xVar.wasReturnedFromScrap()) {
                                        xVar.clearReturnedFromScrapFlag();
                                    }
                                    b(xVar);
                                }
                                xVar = null;
                            } else {
                                z2 = true;
                            }
                        }
                    }
                    if (xVar == null) {
                        int b2 = RecyclerView.this.n.b(i3);
                        if (b2 < 0 || b2 >= RecyclerView.this.v.getItemCount()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Inconsistency detected. Invalid item position ");
                            sb2.append(i3);
                            sb2.append("(offset:");
                            sb2.append(b2);
                            sb2.append(").");
                            sb2.append("state:");
                            sb2.append(RecyclerView.this.ra.a());
                            sb2.append(RecyclerView.this.i());
                            throw new IndexOutOfBoundsException(sb2.toString());
                        }
                        int itemViewType = RecyclerView.this.v.getItemViewType(b2);
                        if (RecyclerView.this.v.hasStableIds()) {
                            xVar = a(RecyclerView.this.v.getItemId(b2), itemViewType, z4);
                            if (xVar != null) {
                                xVar.mPosition = b2;
                                z2 = true;
                            }
                        }
                        if (xVar == null) {
                            v vVar = this.f1789h;
                            if (vVar != null) {
                                View a2 = vVar.a(this, i3, itemViewType);
                                if (a2 != null) {
                                    xVar = RecyclerView.this.h(a2);
                                    if (xVar == null) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                        sb3.append(RecyclerView.this.i());
                                        throw new IllegalArgumentException(sb3.toString());
                                    } else if (xVar.shouldIgnore()) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                        sb4.append(RecyclerView.this.i());
                                        throw new IllegalArgumentException(sb4.toString());
                                    }
                                }
                            }
                        }
                        if (xVar == null) {
                            xVar = d().a(itemViewType);
                            if (xVar != null) {
                                xVar.resetInternal();
                                if (RecyclerView.f1735c) {
                                    f(xVar);
                                }
                            }
                        }
                        if (xVar == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j2 != Long.MAX_VALUE && !this.f1788g.b(itemViewType, nanoTime, j2)) {
                                return null;
                            }
                            RecyclerView recyclerView = RecyclerView.this;
                            x createViewHolder = recyclerView.v.createViewHolder(recyclerView, itemViewType);
                            if (RecyclerView.f1738f) {
                                RecyclerView e2 = RecyclerView.e(createViewHolder.itemView);
                                if (e2 != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference<>(e2);
                                }
                            }
                            this.f1788g.b(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                            xVar2 = createViewHolder;
                            boolean z6 = z2;
                            if (z6 && !RecyclerView.this.ra.d() && xVar2.hasAnyOfTheFlags(8192)) {
                                xVar2.setFlags(0, 8192);
                                if (RecyclerView.this.ra.f1818k) {
                                    int a3 = f.a(xVar2) | CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    RecyclerView recyclerView2 = RecyclerView.this;
                                    RecyclerView.this.a(xVar2, recyclerView2.W.a(recyclerView2.ra, xVar2, a3, xVar2.getUnmodifiedPayloads()));
                                }
                            }
                            if (!RecyclerView.this.ra.d() && xVar2.isBound()) {
                                xVar2.mPreLayoutPosition = i3;
                            } else if (!xVar2.isBound() || xVar2.needsUpdate() || xVar2.isInvalid()) {
                                z3 = a(xVar2, RecyclerView.this.n.b(i3), i2, j2);
                                layoutParams = xVar2.itemView.getLayoutParams();
                                if (layoutParams != null) {
                                    jVar = (j) RecyclerView.this.generateDefaultLayoutParams();
                                    xVar2.itemView.setLayoutParams(jVar);
                                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                    jVar = (j) RecyclerView.this.generateLayoutParams(layoutParams);
                                    xVar2.itemView.setLayoutParams(jVar);
                                } else {
                                    jVar = (j) layoutParams;
                                }
                                jVar.f1772a = xVar2;
                                if (!z6 || !z3) {
                                    z5 = false;
                                }
                                jVar.f1775d = z5;
                                return xVar2;
                            }
                            z3 = false;
                            layoutParams = xVar2.itemView.getLayoutParams();
                            if (layoutParams != null) {
                            }
                            jVar.f1772a = xVar2;
                            z5 = false;
                            jVar.f1775d = z5;
                            return xVar2;
                        }
                    }
                    xVar2 = xVar;
                    boolean z62 = z2;
                    xVar2.setFlags(0, 8192);
                    if (RecyclerView.this.ra.f1818k) {
                    }
                    if (!RecyclerView.this.ra.d()) {
                    }
                    z3 = a(xVar2, RecyclerView.this.n.b(i3), i2, j2);
                    layoutParams = xVar2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    jVar.f1772a = xVar2;
                    z5 = false;
                    jVar.f1775d = z5;
                    return xVar2;
                }
            } else {
                xVar = null;
            }
            z2 = false;
            if (xVar == null) {
            }
            if (xVar == null) {
            }
            xVar2 = xVar;
            boolean z622 = z2;
            xVar2.setFlags(0, 8192);
            if (RecyclerView.this.ra.f1818k) {
            }
            if (!RecyclerView.this.ra.d()) {
            }
            z3 = a(xVar2, RecyclerView.this.n.b(i3), i2, j2);
            layoutParams = xVar2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            jVar.f1772a = xVar2;
            z5 = false;
            jVar.f1775d = z5;
            return xVar2;
        }

        /* access modifiers changed from: 0000 */
        public View c(int i2) {
            return ((x) this.f1782a.get(i2)).itemView;
        }

        /* access modifiers changed from: 0000 */
        public void c() {
            this.f1782a.clear();
            ArrayList<x> arrayList = this.f1783b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        public void c(int i2, int i3) {
            int i4 = i3 + i2;
            for (int size = this.f1784c.size() - 1; size >= 0; size--) {
                x xVar = (x) this.f1784c.get(size);
                if (xVar != null) {
                    int i5 = xVar.mPosition;
                    if (i5 >= i2 && i5 < i4) {
                        xVar.addFlags(2);
                        e(size);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public x b(int i2) {
            ArrayList<x> arrayList = this.f1783b;
            if (arrayList != null) {
                int size = arrayList.size();
                if (size != 0) {
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < size) {
                        x xVar = (x) this.f1783b.get(i4);
                        if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i2) {
                            i4++;
                        } else {
                            xVar.addFlags(32);
                            return xVar;
                        }
                    }
                    if (RecyclerView.this.v.hasStableIds()) {
                        int b2 = RecyclerView.this.n.b(i2);
                        if (b2 > 0 && b2 < RecyclerView.this.v.getItemCount()) {
                            long itemId = RecyclerView.this.v.getItemId(b2);
                            while (i3 < size) {
                                x xVar2 = (x) this.f1783b.get(i3);
                                if (xVar2.wasReturnedFromScrap() || xVar2.getItemId() != itemId) {
                                    i3++;
                                } else {
                                    xVar2.addFlags(32);
                                    return xVar2;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            if (i2 < i3) {
                i6 = i2;
                i5 = i3;
                i4 = -1;
            } else {
                i5 = i2;
                i6 = i3;
                i4 = 1;
            }
            int size = this.f1784c.size();
            for (int i7 = 0; i7 < size; i7++) {
                x xVar = (x) this.f1784c.get(i7);
                if (xVar != null) {
                    int i8 = xVar.mPosition;
                    if (i8 >= i6 && i8 <= i5) {
                        if (i8 == i2) {
                            xVar.offsetPosition(i3 - i2, false);
                        } else {
                            xVar.offsetPosition(i4, false);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            int size = this.f1784c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((x) this.f1784c.get(i2)).clearOldPosition();
            }
            int size2 = this.f1782a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((x) this.f1782a.get(i3)).clearOldPosition();
            }
            ArrayList<x> arrayList = this.f1783b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ((x) this.f1783b.get(i4)).clearOldPosition();
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(x xVar, boolean z) {
            RecyclerView.b(xVar);
            if (xVar.hasAnyOfTheFlags(16384)) {
                xVar.setFlags(0, 16384);
                B.a(xVar.itemView, (C0240a) null);
            }
            if (z) {
                a(xVar);
            }
            xVar.mOwnerRecyclerView = null;
            d().a(xVar);
        }

        /* access modifiers changed from: 0000 */
        public void a(View view) {
            x i2 = RecyclerView.i(view);
            i2.mScrapContainer = null;
            i2.mInChangeScrap = false;
            i2.clearReturnedFromScrapFlag();
            b(i2);
        }

        /* access modifiers changed from: 0000 */
        public x a(int i2, boolean z) {
            int size = this.f1782a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                x xVar = (x) this.f1782a.get(i4);
                if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i2 || xVar.isInvalid() || (!RecyclerView.this.ra.f1815h && xVar.isRemoved())) {
                    i4++;
                } else {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (!z) {
                View b2 = RecyclerView.this.o.b(i2);
                if (b2 != null) {
                    x i5 = RecyclerView.i(b2);
                    RecyclerView.this.o.f(b2);
                    int b3 = RecyclerView.this.o.b(b2);
                    if (b3 != -1) {
                        RecyclerView.this.o.a(b3);
                        c(b2);
                        i5.addFlags(8224);
                        return i5;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("layout index should not be -1 after unhiding a view:");
                    sb.append(i5);
                    sb.append(RecyclerView.this.i());
                    throw new IllegalStateException(sb.toString());
                }
            }
            int size2 = this.f1784c.size();
            while (i3 < size2) {
                x xVar2 = (x) this.f1784c.get(i3);
                if (xVar2.isInvalid() || xVar2.getLayoutPosition() != i2) {
                    i3++;
                } else {
                    if (!z) {
                        this.f1784c.remove(i3);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public x a(long j2, int i2, boolean z) {
            for (int size = this.f1782a.size() - 1; size >= 0; size--) {
                x xVar = (x) this.f1782a.get(size);
                if (xVar.getItemId() == j2 && !xVar.wasReturnedFromScrap()) {
                    if (i2 == xVar.getItemViewType()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !RecyclerView.this.ra.d()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.f1782a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.itemView, false);
                        a(xVar.itemView);
                    }
                }
            }
            int size2 = this.f1784c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = (x) this.f1784c.get(size2);
                if (xVar2.getItemId() == j2) {
                    if (i2 == xVar2.getItemViewType()) {
                        if (!z) {
                            this.f1784c.remove(size2);
                        }
                        return xVar2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(x xVar) {
            q qVar = RecyclerView.this.x;
            if (qVar != null) {
                qVar.a(xVar);
            }
            a aVar = RecyclerView.this.v;
            if (aVar != null) {
                aVar.onViewRecycled(xVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.ra != null) {
                recyclerView.p.h(xVar);
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar, a aVar2, boolean z) {
            a();
            d().a(aVar, aVar2, z);
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3) {
            int size = this.f1784c.size();
            for (int i4 = 0; i4 < size; i4++) {
                x xVar = (x) this.f1784c.get(i4);
                if (xVar != null && xVar.mPosition >= i2) {
                    xVar.offsetPosition(i3, true);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f1784c.size() - 1; size >= 0; size--) {
                x xVar = (x) this.f1784c.get(size);
                if (xVar != null) {
                    int i5 = xVar.mPosition;
                    if (i5 >= i4) {
                        xVar.offsetPosition(-i3, z);
                    } else if (i5 >= i2) {
                        xVar.addFlags(8);
                        e(size);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(v vVar) {
            this.f1789h = vVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(o oVar) {
            o oVar2 = this.f1788g;
            if (oVar2 != null) {
                oVar2.c();
            }
            this.f1788g = oVar;
            if (this.f1788g != null && RecyclerView.this.getAdapter() != null) {
                this.f1788g.a();
            }
        }
    }

    public interface q {
        void a(x xVar);
    }

    private class r extends c {
        r() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.ra.f1814g = true;
            recyclerView.b(true);
            if (!RecyclerView.this.n.c()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void b(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.b(i2, i3)) {
                b();
            }
        }

        public void c(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.c(i2, i3)) {
                b();
            }
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            if (RecyclerView.f1737e) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.C && recyclerView.B) {
                    B.a((View) recyclerView, recyclerView.r);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.K = true;
            recyclerView2.requestLayout();
        }

        public void a(int i2, int i3, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.a(i2, i3, obj)) {
                b();
            }
        }

        public void a(int i2, int i3, int i4) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.a(i2, i3, i4)) {
                b();
            }
        }
    }

    public static class s extends b.i.a.c {
        public static final Creator<s> CREATOR = new U();

        /* renamed from: c reason: collision with root package name */
        Parcelable f1792c;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = i.class.getClassLoader();
            }
            this.f1792c = parcel.readParcelable(classLoader);
        }

        /* access modifiers changed from: 0000 */
        public void a(s sVar) {
            this.f1792c = sVar.f1792c;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f1792c, 0);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static abstract class t {

        /* renamed from: a reason: collision with root package name */
        private int f1793a = -1;

        /* renamed from: b reason: collision with root package name */
        private RecyclerView f1794b;

        /* renamed from: c reason: collision with root package name */
        private i f1795c;

        /* renamed from: d reason: collision with root package name */
        private boolean f1796d;

        /* renamed from: e reason: collision with root package name */
        private boolean f1797e;

        /* renamed from: f reason: collision with root package name */
        private View f1798f;

        /* renamed from: g reason: collision with root package name */
        private final a f1799g = new a(0, 0);

        /* renamed from: h reason: collision with root package name */
        private boolean f1800h;

        public static class a {

            /* renamed from: a reason: collision with root package name */
            private int f1801a;

            /* renamed from: b reason: collision with root package name */
            private int f1802b;

            /* renamed from: c reason: collision with root package name */
            private int f1803c;

            /* renamed from: d reason: collision with root package name */
            private int f1804d;

            /* renamed from: e reason: collision with root package name */
            private Interpolator f1805e;

            /* renamed from: f reason: collision with root package name */
            private boolean f1806f;

            /* renamed from: g reason: collision with root package name */
            private int f1807g;

            public a(int i2, int i3) {
                this(i2, i3, Integer.MIN_VALUE, null);
            }

            private void b() {
                if (this.f1805e != null && this.f1803c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f1803c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i2) {
                this.f1804d = i2;
            }

            public a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f1804d = -1;
                this.f1806f = false;
                this.f1807g = 0;
                this.f1801a = i2;
                this.f1802b = i3;
                this.f1803c = i4;
                this.f1805e = interpolator;
            }

            /* access modifiers changed from: 0000 */
            public boolean a() {
                return this.f1804d >= 0;
            }

            /* access modifiers changed from: 0000 */
            public void a(RecyclerView recyclerView) {
                int i2 = this.f1804d;
                if (i2 >= 0) {
                    this.f1804d = -1;
                    recyclerView.e(i2);
                    this.f1806f = false;
                    return;
                }
                if (this.f1806f) {
                    b();
                    Interpolator interpolator = this.f1805e;
                    if (interpolator == null) {
                        int i3 = this.f1803c;
                        if (i3 == Integer.MIN_VALUE) {
                            recyclerView.oa.b(this.f1801a, this.f1802b);
                        } else {
                            recyclerView.oa.a(this.f1801a, this.f1802b, i3);
                        }
                    } else {
                        recyclerView.oa.a(this.f1801a, this.f1802b, this.f1803c, interpolator);
                    }
                    this.f1807g++;
                    if (this.f1807g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1806f = false;
                } else {
                    this.f1807g = 0;
                }
            }

            public void a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f1801a = i2;
                this.f1802b = i3;
                this.f1803c = i4;
                this.f1805e = interpolator;
                this.f1806f = true;
            }
        }

        public interface b {
            PointF c(int i2);
        }

        /* access modifiers changed from: protected */
        public abstract void a(int i2, int i3, u uVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void a(View view, u uVar, a aVar);

        /* access modifiers changed from: 0000 */
        public void a(RecyclerView recyclerView, i iVar) {
            if (this.f1800h) {
                StringBuilder sb = new StringBuilder();
                sb.append("An instance of ");
                sb.append(getClass().getSimpleName());
                sb.append(" was started ");
                sb.append("more than once. Each instance of");
                sb.append(getClass().getSimpleName());
                sb.append(" ");
                sb.append("is intended to only be used once. You should create a new instance for ");
                sb.append("each use.");
                Log.w("RecyclerView", sb.toString());
            }
            this.f1794b = recyclerView;
            this.f1795c = iVar;
            int i2 = this.f1793a;
            if (i2 != -1) {
                this.f1794b.ra.f1808a = i2;
                this.f1797e = true;
                this.f1796d = true;
                this.f1798f = b(c());
                f();
                this.f1794b.oa.a();
                this.f1800h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public i b() {
            return this.f1795c;
        }

        public void c(int i2) {
            this.f1793a = i2;
        }

        public boolean d() {
            return this.f1796d;
        }

        public boolean e() {
            return this.f1797e;
        }

        /* access modifiers changed from: protected */
        public abstract void f();

        /* access modifiers changed from: protected */
        public abstract void g();

        /* access modifiers changed from: protected */
        public final void h() {
            if (this.f1797e) {
                this.f1797e = false;
                g();
                this.f1794b.ra.f1808a = -1;
                this.f1798f = null;
                this.f1793a = -1;
                this.f1796d = false;
                this.f1795c.a(this);
                this.f1795c = null;
                this.f1794b = null;
            }
        }

        public View b(int i2) {
            return this.f1794b.w.e(i2);
        }

        public int c() {
            return this.f1793a;
        }

        /* access modifiers changed from: protected */
        public void b(View view) {
            if (a(view) == c()) {
                this.f1798f = view;
            }
        }

        public PointF a(int i2) {
            i b2 = b();
            if (b2 instanceof b) {
                return ((b) b2).c(i2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb.append(b.class.getCanonicalName());
            Log.w("RecyclerView", sb.toString());
            return null;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3) {
            RecyclerView recyclerView = this.f1794b;
            if (!this.f1797e || this.f1793a == -1 || recyclerView == null) {
                h();
            }
            if (this.f1796d && this.f1798f == null && this.f1795c != null) {
                PointF a2 = a(this.f1793a);
                if (!(a2 == null || (a2.x == 0.0f && a2.y == 0.0f))) {
                    recyclerView.a((int) Math.signum(a2.x), (int) Math.signum(a2.y), (int[]) null);
                }
            }
            this.f1796d = false;
            View view = this.f1798f;
            if (view != null) {
                if (a(view) == this.f1793a) {
                    a(this.f1798f, recyclerView.ra, this.f1799g);
                    this.f1799g.a(recyclerView);
                    h();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1798f = null;
                }
            }
            if (this.f1797e) {
                a(i2, i3, recyclerView.ra, this.f1799g);
                boolean a3 = this.f1799g.a();
                this.f1799g.a(recyclerView);
                if (!a3) {
                    return;
                }
                if (this.f1797e) {
                    this.f1796d = true;
                    recyclerView.oa.a();
                    return;
                }
                h();
            }
        }

        public int a(View view) {
            return this.f1794b.g(view);
        }

        public int a() {
            return this.f1794b.w.f();
        }

        /* access modifiers changed from: protected */
        public void a(PointF pointF) {
            float f2 = pointF.x;
            float f3 = f2 * f2;
            float f4 = pointF.y;
            float sqrt = (float) Math.sqrt((double) (f3 + (f4 * f4)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    public static class u {

        /* renamed from: a reason: collision with root package name */
        int f1808a = -1;

        /* renamed from: b reason: collision with root package name */
        private SparseArray<Object> f1809b;

        /* renamed from: c reason: collision with root package name */
        int f1810c = 0;

        /* renamed from: d reason: collision with root package name */
        int f1811d = 0;

        /* renamed from: e reason: collision with root package name */
        int f1812e = 1;

        /* renamed from: f reason: collision with root package name */
        int f1813f = 0;

        /* renamed from: g reason: collision with root package name */
        boolean f1814g = false;

        /* renamed from: h reason: collision with root package name */
        boolean f1815h = false;

        /* renamed from: i reason: collision with root package name */
        boolean f1816i = false;

        /* renamed from: j reason: collision with root package name */
        boolean f1817j = false;

        /* renamed from: k reason: collision with root package name */
        boolean f1818k = false;

        /* renamed from: l reason: collision with root package name */
        boolean f1819l = false;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            if ((this.f1812e & i2) == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Layout state should be one of ");
                sb.append(Integer.toBinaryString(i2));
                sb.append(" but it is ");
                sb.append(Integer.toBinaryString(this.f1812e));
                throw new IllegalStateException(sb.toString());
            }
        }

        public int b() {
            return this.f1808a;
        }

        public boolean c() {
            return this.f1808a != -1;
        }

        public boolean d() {
            return this.f1815h;
        }

        public boolean e() {
            return this.f1819l;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State{mTargetPosition=");
            sb.append(this.f1808a);
            sb.append(", mData=");
            sb.append(this.f1809b);
            sb.append(", mItemCount=");
            sb.append(this.f1813f);
            sb.append(", mIsMeasuring=");
            sb.append(this.f1817j);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.f1810c);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.f1811d);
            sb.append(", mStructureChanged=");
            sb.append(this.f1814g);
            sb.append(", mInPreLayout=");
            sb.append(this.f1815h);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.f1818k);
            sb.append(", mRunPredictiveAnimations=");
            sb.append(this.f1819l);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar) {
            this.f1812e = 1;
            this.f1813f = aVar.getItemCount();
            this.f1815h = false;
            this.f1816i = false;
            this.f1817j = false;
        }

        public int a() {
            return this.f1815h ? this.f1810c - this.f1811d : this.f1813f;
        }
    }

    public static abstract class v {
        public abstract View a(p pVar, int i2, int i3);
    }

    class w implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private int f1820a;

        /* renamed from: b reason: collision with root package name */
        private int f1821b;

        /* renamed from: c reason: collision with root package name */
        OverScroller f1822c;

        /* renamed from: d reason: collision with root package name */
        Interpolator f1823d = RecyclerView.f1742j;

        /* renamed from: e reason: collision with root package name */
        private boolean f1824e = false;

        /* renamed from: f reason: collision with root package name */
        private boolean f1825f = false;

        w() {
            this.f1822c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f1742j);
        }

        private void c() {
            this.f1825f = false;
            this.f1824e = true;
        }

        private void d() {
            this.f1824e = false;
            if (this.f1825f) {
                a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            if (this.f1824e) {
                this.f1825f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            B.a((View) RecyclerView.this, (Runnable) this);
        }

        public void b(int i2, int i3) {
            a(i2, i3, 0, 0);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
            if (r8 > 0) goto L_0x00ef;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7  */
        public void run() {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            if (RecyclerView.this.w == null) {
                b();
                return;
            }
            c();
            RecyclerView.this.b();
            OverScroller overScroller = this.f1822c;
            t tVar = RecyclerView.this.w.f1762g;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.Da;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i7 = currX - this.f1820a;
                int i8 = currY - this.f1821b;
                this.f1820a = currX;
                this.f1821b = currY;
                if (RecyclerView.this.a(i7, i8, iArr, (int[]) null, 1)) {
                    i7 -= iArr[0];
                    i8 -= iArr[1];
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.v != null) {
                    recyclerView.a(i7, i8, recyclerView.Fa);
                    int[] iArr2 = RecyclerView.this.Fa;
                    i4 = iArr2[0];
                    i5 = iArr2[1];
                    i3 = i7 - i4;
                    i2 = i8 - i5;
                    if (tVar != null && !tVar.d() && tVar.e()) {
                        int a2 = RecyclerView.this.ra.a();
                        if (a2 == 0) {
                            tVar.h();
                        } else if (tVar.c() >= a2) {
                            tVar.c(a2 - 1);
                            tVar.a(i7 - i3, i8 - i2);
                        } else {
                            tVar.a(i7 - i3, i8 - i2);
                        }
                    }
                } else {
                    i5 = 0;
                    i4 = 0;
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.y.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.b(i7, i8);
                }
                if (!RecyclerView.this.a(i4, i5, i3, i2, (int[]) null, 1) && !(i3 == 0 && i2 == 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 != currX) {
                        if (i3 < 0) {
                            i6 = -currVelocity;
                        } else if (i3 > 0) {
                            i6 = currVelocity;
                        }
                        if (i2 != currY) {
                            if (i2 < 0) {
                                currVelocity = -currVelocity;
                            }
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                                RecyclerView.this.a(i6, currVelocity);
                            }
                            if ((i6 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i2 == currY || overScroller.getFinalY() == 0)) {
                                overScroller.abortAnimation();
                            }
                        }
                        currVelocity = 0;
                        if (RecyclerView.this.getOverScrollMode() != 2) {
                        }
                        overScroller.abortAnimation();
                    }
                    i6 = 0;
                    if (i2 != currY) {
                    }
                    currVelocity = 0;
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                    }
                    overScroller.abortAnimation();
                }
                if (!(i4 == 0 && i5 == 0)) {
                    RecyclerView.this.d(i4, i5);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i7 == 0 && i8 == 0) || (i7 != 0 && RecyclerView.this.w.b() && i4 == i7) || (i8 != 0 && RecyclerView.this.w.c() && i5 == i8);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.d(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.f1738f) {
                        RecyclerView.this.qa.a();
                    }
                    RecyclerView.this.a(1);
                } else {
                    a();
                    RecyclerView recyclerView2 = RecyclerView.this;
                    C0238y yVar = recyclerView2.pa;
                    if (yVar != null) {
                        yVar.a(recyclerView2, i7, i8);
                    }
                }
            }
            if (tVar != null) {
                if (tVar.d()) {
                    tVar.a(0, 0);
                }
                if (!this.f1825f) {
                    tVar.h();
                }
            }
            d();
        }

        private int b(int i2, int i3, int i4, int i5) {
            int i6;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i4 * i4) + (i5 * i5)));
            int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i7 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i7;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i6 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i6, 2000);
        }

        public void a(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f1821b = 0;
            this.f1820a = 0;
            this.f1822c.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i2, int i3, int i4, int i5) {
            a(i2, i3, b(i2, i3, i4, i5));
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        public void a(int i2, int i3, int i4) {
            a(i2, i3, i4, RecyclerView.f1742j);
        }

        public void a(int i2, int i3, Interpolator interpolator) {
            int b2 = b(i2, i3, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f1742j;
            }
            a(i2, i3, b2, interpolator);
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1822c.abortAnimation();
        }

        public void a(int i2, int i3, int i4, Interpolator interpolator) {
            if (this.f1823d != interpolator) {
                this.f1823d = interpolator;
                this.f1822c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f1821b = 0;
            this.f1820a = 0;
            this.f1822c.startScroll(0, 0, i2, i3, i4);
            if (VERSION.SDK_INT < 23) {
                this.f1822c.computeScrollOffset();
            }
            a();
        }
    }

    public static abstract class x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        p mScrapContainer = null;
        x mShadowedHolder = null;
        x mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public x(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: 0000 */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: 0000 */
        public void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        /* access modifiers changed from: 0000 */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: 0000 */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: 0000 */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: 0000 */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: 0000 */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && B.z(this.itemView);
        }

        /* access modifiers changed from: 0000 */
        public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z) {
            addFlags(8);
            offsetPosition(i3, z);
            this.mPosition = i2;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        /* access modifiers changed from: 0000 */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: 0000 */
        public boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        /* access modifiers changed from: 0000 */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !B.z(this.itemView);
        }

        /* access modifiers changed from: 0000 */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: 0000 */
        public boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: 0000 */
        public void offsetPosition(int i2, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((j) this.itemView.getLayoutParams()).f1774c = true;
            }
        }

        /* access modifiers changed from: 0000 */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i2;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = B.k(this.itemView);
            }
            recyclerView.a(this, 4);
        }

        /* access modifiers changed from: 0000 */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: 0000 */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.b(this);
        }

        /* access modifiers changed from: 0000 */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: 0000 */
        public void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i2 = this.mIsRecyclableCount;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb.append(this);
                Log.e("View", sb.toString());
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        /* access modifiers changed from: 0000 */
        public void setScrapContainer(p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        /* access modifiers changed from: 0000 */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewHolder{");
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" position=");
            sb.append(this.mPosition);
            sb.append(" id=");
            sb.append(this.mItemId);
            sb.append(", oldPos=");
            sb.append(this.mOldPosition);
            sb.append(", pLpos:");
            sb.append(this.mPreLayoutPosition);
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" not recyclable(");
                sb3.append(this.mIsRecyclableCount);
                sb3.append(")");
                sb2.append(sb3.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        /* access modifiers changed from: 0000 */
        public void unScrap() {
            this.mScrapContainer.c(this);
        }

        /* access modifiers changed from: 0000 */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        int i2 = VERSION.SDK_INT;
        f1735c = i2 == 18 || i2 == 19 || i2 == 20;
        Class cls = Integer.TYPE;
        f1741i = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void A() {
        int i2 = this.J;
        this.J = 0;
        if (i2 != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            b.g.i.a.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void B() {
        boolean z2 = true;
        this.ra.a(1);
        a(this.ra);
        this.ra.f1817j = false;
        x();
        this.p.a();
        r();
        J();
        O();
        u uVar = this.ra;
        if (!uVar.f1818k || !this.va) {
            z2 = false;
        }
        uVar.f1816i = z2;
        this.va = false;
        this.ua = false;
        u uVar2 = this.ra;
        uVar2.f1815h = uVar2.f1819l;
        uVar2.f1813f = this.v.getItemCount();
        a(this.Aa);
        if (this.ra.f1818k) {
            int a2 = this.o.a();
            for (int i2 = 0; i2 < a2; i2++) {
                x i3 = i(this.o.c(i2));
                if (!i3.shouldIgnore() && (!i3.isInvalid() || this.v.hasStableIds())) {
                    this.p.c(i3, this.W.a(this.ra, i3, f.a(i3), i3.getUnmodifiedPayloads()));
                    if (this.ra.f1816i && i3.isUpdated() && !i3.isRemoved() && !i3.shouldIgnore() && !i3.isInvalid()) {
                        this.p.a(d(i3), i3);
                    }
                }
            }
        }
        if (this.ra.f1819l) {
            w();
            u uVar3 = this.ra;
            boolean z3 = uVar3.f1814g;
            uVar3.f1814g = false;
            this.w.e(this.f1744l, uVar3);
            this.ra.f1814g = z3;
            for (int i4 = 0; i4 < this.o.a(); i4++) {
                x i5 = i(this.o.c(i4));
                if (!i5.shouldIgnore() && !this.p.c(i5)) {
                    int a3 = f.a(i5);
                    boolean hasAnyOfTheFlags = i5.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        a3 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                    }
                    c a4 = this.W.a(this.ra, i5, a3, i5.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        a(i5, a4);
                    } else {
                        this.p.a(i5, a4);
                    }
                }
            }
            a();
        } else {
            a();
        }
        s();
        c(false);
        this.ra.f1812e = 2;
    }

    private void C() {
        x();
        r();
        this.ra.a(6);
        this.n.b();
        this.ra.f1813f = this.v.getItemCount();
        u uVar = this.ra;
        uVar.f1811d = 0;
        uVar.f1815h = false;
        this.w.e(this.f1744l, uVar);
        u uVar2 = this.ra;
        uVar2.f1814g = false;
        this.m = null;
        uVar2.f1818k = uVar2.f1818k && this.W != null;
        this.ra.f1812e = 4;
        s();
        c(false);
    }

    private void D() {
        this.ra.a(4);
        x();
        r();
        u uVar = this.ra;
        uVar.f1812e = 1;
        if (uVar.f1818k) {
            for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
                x i2 = i(this.o.c(a2));
                if (!i2.shouldIgnore()) {
                    long d2 = d(i2);
                    c a3 = this.W.a(this.ra, i2);
                    x a4 = this.p.a(d2);
                    if (a4 == null || a4.shouldIgnore()) {
                        this.p.b(i2, a3);
                    } else {
                        boolean b2 = this.p.b(a4);
                        boolean b3 = this.p.b(i2);
                        if (!b2 || a4 != i2) {
                            c f2 = this.p.f(a4);
                            this.p.b(i2, a3);
                            c e2 = this.p.e(i2);
                            if (f2 == null) {
                                a(d2, i2, a4);
                            } else {
                                a(a4, i2, f2, e2, b2, b3);
                            }
                        } else {
                            this.p.b(i2, a3);
                        }
                    }
                }
            }
            this.p.a(this.Ia);
        }
        this.w.c(this.f1744l);
        u uVar2 = this.ra;
        uVar2.f1810c = uVar2.f1813f;
        this.N = false;
        this.O = false;
        uVar2.f1818k = false;
        uVar2.f1819l = false;
        this.w.f1763h = false;
        ArrayList<x> arrayList = this.f1744l.f1783b;
        if (arrayList != null) {
            arrayList.clear();
        }
        i iVar = this.w;
        if (iVar.n) {
            iVar.m = 0;
            iVar.n = false;
            this.f1744l.j();
        }
        this.w.g(this.ra);
        s();
        c(false);
        this.p.a();
        int[] iArr = this.Aa;
        if (k(iArr[0], iArr[1])) {
            d(0, 0);
        }
        K();
        M();
    }

    private View E() {
        int i2 = this.ra.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.ra.a();
        int i3 = i2;
        while (i3 < a2) {
            x c2 = c(i3);
            if (c2 == null) {
                break;
            } else if (c2.itemView.hasFocusable()) {
                return c2.itemView;
            } else {
                i3++;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0) {
                return null;
            }
            x c3 = c(min);
            if (c3 == null) {
                return null;
            }
            if (c3.itemView.hasFocusable()) {
                return c3.itemView;
            }
        }
    }

    private boolean F() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            x i3 = i(this.o.c(i2));
            if (i3 != null && !i3.shouldIgnore() && i3.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void G() {
        if (B.l(this) == 0) {
            B.f((View) this, 8);
        }
    }

    private void H() {
        this.o = new C0222h(new P(this));
    }

    private boolean I() {
        return this.W != null && this.w.C();
    }

    private void J() {
        if (this.N) {
            this.n.f();
            if (this.O) {
                this.w.d(this);
            }
        }
        if (I()) {
            this.n.e();
        } else {
            this.n.b();
        }
        boolean z2 = false;
        boolean z3 = this.ua || this.va;
        this.ra.f1818k = this.E && this.W != null && (this.N || z3 || this.w.f1763h) && (!this.N || this.v.hasStableIds());
        u uVar = this.ra;
        if (uVar.f1818k && z3 && !this.N && I()) {
            z2 = true;
        }
        uVar.f1819l = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ab, code lost:
        if (r0.isFocusable() != false) goto L_0x00af;
     */
    private void K() {
        View view;
        if (this.na && this.v != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (!isFocused()) {
                View focusedChild = getFocusedChild();
                if (!f1740h || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                    if (!this.o.c(focusedChild)) {
                        return;
                    }
                } else if (this.o.a() == 0) {
                    requestFocus();
                    return;
                }
            }
            View view2 = null;
            x a2 = (this.ra.n == -1 || !this.v.hasStableIds()) ? null : a(this.ra.n);
            if (a2 != null && !this.o.c(a2.itemView) && a2.itemView.hasFocusable()) {
                view2 = a2.itemView;
            } else if (this.o.a() > 0) {
                view2 = E();
            }
            if (view2 != null) {
                int i2 = this.ra.o;
                if (((long) i2) != -1) {
                    view = view2.findViewById(i2);
                    if (view != null) {
                    }
                }
                view = view2;
                view.requestFocus();
            }
        }
    }

    private void L() {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.S.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            B.G(this);
        }
    }

    private void M() {
        u uVar = this.ra;
        uVar.n = -1;
        uVar.m = -1;
        uVar.o = -1;
    }

    private void N() {
        VelocityTracker velocityTracker = this.ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        L();
    }

    private void O() {
        int i2;
        x xVar = null;
        View focusedChild = (!this.na || !hasFocus() || this.v == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            xVar = d(focusedChild);
        }
        if (xVar == null) {
            M();
            return;
        }
        this.ra.n = this.v.hasStableIds() ? xVar.getItemId() : -1;
        u uVar = this.ra;
        if (this.N) {
            i2 = -1;
        } else if (xVar.isRemoved()) {
            i2 = xVar.mOldPosition;
        } else {
            i2 = xVar.getAdapterPosition();
        }
        uVar.m = i2;
        this.ra.o = n(xVar.itemView);
    }

    private void P() {
        this.oa.b();
        i iVar = this.w;
        if (iVar != null) {
            iVar.B();
        }
    }

    private void e(x xVar) {
        View view = xVar.itemView;
        boolean z2 = view.getParent() == this;
        this.f1744l.c(h(view));
        if (xVar.isTmpDetached()) {
            this.o.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.o.a(view, true);
        } else {
            this.o.a(view);
        }
    }

    private C0252m getScrollingChildHelper() {
        if (this.Ba == null) {
            this.Ba = new C0252m(this);
        }
        return this.Ba;
    }

    private void z() {
        N();
        setScrollState(0);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.w;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b(k kVar) {
        List<k> list = this.M;
        if (list != null) {
            list.remove(kVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(boolean z2) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z2 && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z2 && this.G && !this.H && this.w != null && this.v != null) {
                c();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.w.a((j) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.b()) {
            i2 = this.w.a(this.ra);
        }
        return i2;
    }

    public int computeHorizontalScrollOffset() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.b()) {
            i2 = this.w.b(this.ra);
        }
        return i2;
    }

    public int computeHorizontalScrollRange() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.b()) {
            i2 = this.w.c(this.ra);
        }
        return i2;
    }

    public int computeVerticalScrollExtent() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.c()) {
            i2 = this.w.d(this.ra);
        }
        return i2;
    }

    public int computeVerticalScrollOffset() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.c()) {
            i2 = this.w.e(this.ra);
        }
        return i2;
    }

    public int computeVerticalScrollRange() {
        i iVar = this.w;
        int i2 = 0;
        if (iVar == null) {
            return 0;
        }
        if (iVar.c()) {
            i2 = this.w.f(this.ra);
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public long d(x xVar) {
        return this.v.hasStableIds() ? xVar.getItemId() : (long) xVar.mPosition;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.y.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((h) this.y.get(i2)).onDrawOver(canvas, this, this.ra);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.q) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.U;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.q) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.W != null && this.y.size() > 0 && this.W.g()) {
            z3 = true;
        }
        if (z3) {
            B.G(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: 0000 */
    public void f() {
        if (this.S == null) {
            this.S = this.R.a(this, 0);
            if (this.q) {
                this.S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.S.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.w.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.v != null && this.w != null && !o() && !this.H;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                b();
                if (c(view) == null) {
                    return null;
                }
                x();
                view2 = this.w.a(view, i2, this.f1744l, this.ra);
                c(false);
            }
        } else {
            if (this.w.c()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (f1739g) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.w.b()) {
                int i4 = (this.w.l() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (f1739g) {
                    i2 = i4;
                }
            }
            if (z2) {
                b();
                if (c(view) == null) {
                    return null;
                }
                x();
                this.w.a(view, i2, this.f1744l, this.ra);
                c(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (!a(view, view2, i2)) {
                view2 = super.focusSearch(view, i2);
            }
            return view2;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            a(view2, (View) null);
            return view;
        }
    }

    /* access modifiers changed from: 0000 */
    public void g() {
        if (this.U == null) {
            this.U = this.R.a(this, 2);
            if (this.q) {
                this.U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.U.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.d();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(getContext(), attributeSet);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public a getAdapter() {
        return this.v;
    }

    public int getBaseline() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.e();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.za;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.q;
    }

    public V getCompatAccessibilityDelegate() {
        return this.ya;
    }

    public e getEdgeEffectFactory() {
        return this.R;
    }

    public f getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.y.size();
    }

    public i getLayoutManager() {
        return this.w;
    }

    public int getMaxFlingVelocity() {
        return this.ka;
    }

    public int getMinFlingVelocity() {
        return this.ja;
    }

    /* access modifiers changed from: 0000 */
    public long getNanoTime() {
        if (f1738f) {
            return System.nanoTime();
        }
        return 0;
    }

    public l getOnFlingListener() {
        return this.ia;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.na;
    }

    public o getRecycledViewPool() {
        return this.f1744l.d();
    }

    public int getScrollState() {
        return this.aa;
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        if (this.T == null) {
            this.T = this.R.a(this, 1);
            if (this.q) {
                this.T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.T.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void h(int i2) {
    }

    public void h(int i2, int i3) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    /* access modifiers changed from: 0000 */
    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(super.toString());
        sb.append(", adapter:");
        sb.append(this.v);
        sb.append(", layout:");
        sb.append(this.w);
        sb.append(", context:");
        sb.append(getContext());
        return sb.toString();
    }

    public boolean isAttachedToWindow() {
        return this.B;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public void j(int i2) {
        if (!this.H) {
            i iVar = this.w;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                iVar.a(this, this.ra, i2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void k() {
        this.n = new C0215a(new Q(this));
    }

    public void k(View view) {
    }

    /* access modifiers changed from: 0000 */
    public void l() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    public void l(View view) {
    }

    /* access modifiers changed from: 0000 */
    public boolean m(View view) {
        x();
        boolean e2 = this.o.e(view);
        if (e2) {
            x i2 = i(view);
            this.f1744l.c(i2);
            this.f1744l.b(i2);
        }
        c(!e2);
        return e2;
    }

    /* access modifiers changed from: 0000 */
    public boolean n() {
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean o() {
        return this.P > 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    public void onAttachedToWindow() {
        float f2;
        super.onAttachedToWindow();
        this.P = 0;
        boolean z2 = true;
        this.B = true;
        if (!this.E || isLayoutRequested()) {
            z2 = false;
        }
        this.E = z2;
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this);
        }
        this.xa = false;
        if (f1738f) {
            this.pa = (C0238y) C0238y.f2013a.get();
            if (this.pa == null) {
                this.pa = new C0238y();
                Display h2 = B.h(this);
                if (!isInEditMode() && h2 != null) {
                    f2 = h2.getRefreshRate();
                }
                f2 = 60.0f;
                C0238y yVar = this.pa;
                yVar.f2017e = (long) (1.0E9f / f2);
                C0238y.f2013a.set(yVar);
            }
            this.pa.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        y();
        this.B = false;
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this, this.f1744l);
        }
        this.Ga.clear();
        removeCallbacks(this.Ha);
        this.p.b();
        if (f1738f) {
            C0238y yVar = this.pa;
            if (yVar != null) {
                yVar.b(this);
                this.pa = null;
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((h) this.y.get(i2)).onDraw(canvas, this, this.ra);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.w != null && !this.H && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.w.c() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.w.b()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.w.c()) {
                        f3 = -axisValue;
                    } else if (this.w.b()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = false;
        if (this.H) {
            return false;
        }
        if (b(motionEvent)) {
            z();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean b2 = iVar.b();
        boolean c2 = this.w.c();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        this.ca.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            if (this.aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.Ea;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = b2 ? 1 : 0;
            if (c2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.ca.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing scroll; pointer index for id ");
                sb.append(this.ba);
                sb.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sb.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aa != 1) {
                int i3 = x3 - this.da;
                int i4 = y3 - this.ea;
                if (!b2 || Math.abs(i3) <= this.ha) {
                    z2 = false;
                } else {
                    this.fa = x3;
                    z2 = true;
                }
                if (c2 && Math.abs(i4) > this.ha) {
                    this.ga = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            z();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (this.aa == 1) {
            z3 = true;
        }
        return z3;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.os.b.a("RV OnLayout");
        c();
        androidx.core.os.b.a();
        this.E = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (iVar.s()) {
            int mode = MeasureSpec.getMode(i2);
            int mode2 = MeasureSpec.getMode(i3);
            this.w.a(this.f1744l, this.ra, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.v != null) {
                if (this.ra.f1812e == 1) {
                    B();
                }
                this.w.b(i2, i3);
                this.ra.f1817j = true;
                C();
                this.w.d(i2, i3);
                if (this.w.A()) {
                    this.w.b(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.ra.f1817j = true;
                    C();
                    this.w.d(i2, i3);
                }
            }
        } else if (this.C) {
            this.w.a(this.f1744l, this.ra, i2, i3);
        } else {
            if (this.K) {
                x();
                r();
                J();
                s();
                u uVar = this.ra;
                if (uVar.f1819l) {
                    uVar.f1815h = true;
                } else {
                    this.n.b();
                    this.ra.f1815h = false;
                }
                this.K = false;
                c(false);
            } else if (this.ra.f1819l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.v;
            if (aVar != null) {
                this.ra.f1813f = aVar.getItemCount();
            } else {
                this.ra.f1813f = 0;
            }
            x();
            this.w.a(this.f1744l, this.ra, i2, i3);
            c(false);
            this.ra.f1815h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.m = (s) parcelable;
        super.onRestoreInstanceState(this.m.n());
        i iVar = this.w;
        if (iVar != null) {
            Parcelable parcelable2 = this.m.f1792c;
            if (parcelable2 != null) {
                iVar.a(parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        s sVar2 = this.m;
        if (sVar2 != null) {
            sVar.a(sVar2);
        } else {
            i iVar = this.w;
            if (iVar != null) {
                sVar.f1792c = iVar.w();
            } else {
                sVar.f1792c = null;
            }
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            l();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011c  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        boolean z2;
        boolean z3 = false;
        if (this.H || this.I) {
            return false;
        }
        if (a(motionEvent)) {
            z();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean b2 = iVar.b();
        boolean c2 = this.w.c();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.Ea;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.Ea;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            int i4 = b2 ? 1 : 0;
            if (c2) {
                i4 |= 2;
            }
            j(i4, 0);
        } else if (actionMasked == 1) {
            this.ca.addMovement(obtain);
            this.ca.computeCurrentVelocity(1000, (float) this.ka);
            float f2 = b2 ? -this.ca.getXVelocity(this.ba) : 0.0f;
            float f3 = c2 ? -this.ca.getYVelocity(this.ba) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !e((int) f2, (int) f3)) {
                setScrollState(0);
            }
            N();
            z3 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing scroll; pointer index for id ");
                sb.append(this.ba);
                sb.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sb.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i5 = this.fa - x3;
            int i6 = this.ga - y3;
            if (a(i5, i6, this.Da, this.Ca, 0)) {
                int[] iArr3 = this.Da;
                i5 -= iArr3[0];
                i6 -= iArr3[1];
                int[] iArr4 = this.Ca;
                obtain.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                int[] iArr5 = this.Ea;
                int i7 = iArr5[0];
                int[] iArr6 = this.Ca;
                iArr5[0] = i7 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.aa != 1) {
                if (b2) {
                    int abs = Math.abs(i3);
                    int i8 = this.ha;
                    if (abs > i8) {
                        i3 = i3 > 0 ? i3 - i8 : i3 + i8;
                        z2 = true;
                        if (c2) {
                            int abs2 = Math.abs(i2);
                            int i9 = this.ha;
                            if (abs2 > i9) {
                                i2 = i2 > 0 ? i2 - i9 : i2 + i9;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                }
                z2 = false;
                if (c2) {
                }
                if (z2) {
                }
            }
            if (this.aa == 1) {
                int[] iArr7 = this.Ca;
                this.fa = x3 - iArr7[0];
                this.ga = y3 - iArr7[1];
                if (a(b2 ? i3 : 0, c2 ? i2 : 0, obtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.pa == null || (i3 == 0 && i2 == 0))) {
                    this.pa.a(this, i3, i2);
                }
            }
        } else if (actionMasked == 3) {
            z();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (!z3) {
            this.ca.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void p() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((j) this.o.d(i2).getLayoutParams()).f1774c = true;
        }
        this.f1744l.g();
    }

    /* access modifiers changed from: 0000 */
    public void q() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x i3 = i(this.o.d(i2));
            if (i3 != null && !i3.shouldIgnore()) {
                i3.addFlags(6);
            }
        }
        p();
        this.f1744l.h();
    }

    /* access modifiers changed from: 0000 */
    public void r() {
        this.P++;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        x i2 = i(view);
        if (i2 != null) {
            if (i2.isTmpDetached()) {
                i2.clearTmpDetachFlag();
            } else if (!i2.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(i2);
                sb.append(i());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.w.a(this, this.ra, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.w.a(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((m) this.z.get(i2)).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.F != 0 || this.H) {
            this.G = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public void s() {
        a(true);
    }

    public void scrollBy(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            boolean b2 = iVar.b();
            boolean c2 = this.w.c();
            if (b2 || c2) {
                if (!b2) {
                    i2 = 0;
                }
                if (!c2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(V v2) {
        this.ya = v2;
        B.a((View) this, (C0240a) this.ya);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.za) {
            this.za = dVar;
            setChildrenDrawingOrderEnabled(this.za != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.q) {
            l();
        }
        this.q = z2;
        super.setClipToPadding(z2);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        b.g.h.g.a(eVar);
        this.R = eVar;
        l();
    }

    public void setHasFixedSize(boolean z2) {
        this.C = z2;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.b();
            this.W.a((b) null);
        }
        this.W = fVar;
        f fVar3 = this.W;
        if (fVar3 != null) {
            fVar3.a(this.wa);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f1744l.f(i2);
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.H) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.H = false;
                if (!(!this.G || this.w == null || this.v == null)) {
                    requestLayout();
                }
                this.G = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            y();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.w) {
            y();
            if (this.w != null) {
                f fVar = this.W;
                if (fVar != null) {
                    fVar.b();
                }
                this.w.b(this.f1744l);
                this.w.c(this.f1744l);
                this.f1744l.a();
                if (this.B) {
                    this.w.a(this, this.f1744l);
                }
                this.w.f((RecyclerView) null);
                this.w = null;
            } else {
                this.f1744l.a();
            }
            this.o.c();
            this.w = iVar;
            if (iVar != null) {
                if (iVar.f1757b == null) {
                    this.w.f(this);
                    if (this.B) {
                        this.w.a(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(iVar);
                    sb.append(" is already attached to a RecyclerView:");
                    sb.append(iVar.f1757b.i());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            this.f1744l.j();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(l lVar) {
        this.ia = lVar;
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.sa = nVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.na = z2;
    }

    public void setRecycledViewPool(o oVar) {
        this.f1744l.a(oVar);
    }

    public void setRecyclerListener(q qVar) {
        this.x = qVar;
    }

    /* access modifiers changed from: 0000 */
    public void setScrollState(int i2) {
        if (i2 != this.aa) {
            this.aa = i2;
            if (i2 != 2) {
                P();
            }
            b(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("setScrollingTouchSlop(): bad argument constant ");
                sb.append(i2);
                sb.append("; using default value");
                Log.w("RecyclerView", sb.toString());
            } else {
                this.ha = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.ha = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(v vVar) {
        this.f1744l.a(vVar);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    /* access modifiers changed from: 0000 */
    public void t() {
        if (!this.xa && this.B) {
            B.a((View) this, this.Ha);
            this.xa = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void u() {
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.b(this.f1744l);
            this.w.c(this.f1744l);
        }
        this.f1744l.a();
    }

    /* access modifiers changed from: 0000 */
    public void v() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.o.c(i2);
            x h2 = h(c2);
            if (h2 != null) {
                x xVar = h2.mShadowingHolder;
                if (xVar != null) {
                    View view = xVar.itemView;
                    int left = c2.getLeft();
                    int top = c2.getTop();
                    if (left != view.getLeft() || top != view.getTop()) {
                        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void w() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x i3 = i(this.o.d(i2));
            if (!i3.shouldIgnore()) {
                i3.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void x() {
        this.F++;
        if (this.F == 1 && !this.H) {
            this.G = false;
        }
    }

    public void y() {
        setScrollState(0);
        P();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean k(int i2, int i3) {
        a(this.Aa);
        int[] iArr = this.Aa;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private int n(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public x d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return h(c2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1743k = new r();
        this.f1744l = new p();
        this.p = new ea();
        this.r = new L(this);
        this.s = new Rect();
        this.t = new Rect();
        this.u = new RectF();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new e();
        this.W = new C0231q();
        this.aa = 0;
        this.ba = -1;
        this.la = Float.MIN_VALUE;
        this.ma = Float.MIN_VALUE;
        boolean z2 = true;
        this.na = true;
        this.oa = new w();
        this.qa = f1738f ? new a() : null;
        this.ra = new u();
        this.ua = false;
        this.va = false;
        this.wa = new g();
        this.xa = false;
        this.Aa = new int[2];
        this.Ca = new int[2];
        this.Da = new int[2];
        this.Ea = new int[2];
        this.Fa = new int[2];
        this.Ga = new ArrayList();
        this.Ha = new M(this);
        this.Ia = new O(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1734b, i2, 0);
            this.q = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ha = viewConfiguration.getScaledTouchSlop();
        this.la = C.a(viewConfiguration, context);
        this.ma = C.b(viewConfiguration, context);
        this.ja = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ka = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.a(this.wa);
        k();
        H();
        G();
        if (B.k(this) == 0) {
            B.e((View) this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new V(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.n.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(b.n.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(b.n.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.D = obtainStyledAttributes2.getBoolean(b.n.b.RecyclerView_fastScrollEnabled, false);
            if (this.D) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(b.n.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(b.n.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(b.n.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(b.n.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1733a, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public void b(h hVar) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(hVar);
        if (this.y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        p();
        requestLayout();
    }

    public void i(int i2) {
        if (!this.H) {
            y();
            i iVar = this.w;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            iVar.k(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(int i2, int i3) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        n nVar = this.sa;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        List<n> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((n) this.ta.get(size)).onScrolled(this, i2, i3);
            }
        }
        this.Q--;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(layoutParams);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        String str2 = ": Could not instantiate the LayoutManager: ";
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(f1741i);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(attributeSet.getPositionDescription());
                    sb.append(": Error creating LayoutManager ");
                    sb.append(a2);
                    throw new IllegalStateException(sb.toString(), e3);
                } catch (ClassNotFoundException e4) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(attributeSet.getPositionDescription());
                    sb2.append(": Unable to find LayoutManager ");
                    sb2.append(a2);
                    throw new IllegalStateException(sb2.toString(), e4);
                } catch (InvocationTargetException e5) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(attributeSet.getPositionDescription());
                    sb3.append(str2);
                    sb3.append(a2);
                    throw new IllegalStateException(sb3.toString(), e5);
                } catch (InstantiationException e6) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(attributeSet.getPositionDescription());
                    sb4.append(str2);
                    sb4.append(a2);
                    throw new IllegalStateException(sb4.toString(), e6);
                } catch (IllegalAccessException e7) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(attributeSet.getPositionDescription());
                    sb5.append(": Cannot access non-public constructor ");
                    sb5.append(a2);
                    throw new IllegalStateException(sb5.toString(), e7);
                } catch (ClassCastException e8) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(attributeSet.getPositionDescription());
                    sb6.append(": Class is not a LayoutManager ");
                    sb6.append(a2);
                    throw new IllegalStateException(sb6.toString(), e8);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Rect j(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.f1774c) {
            return jVar.f1773b;
        }
        if (this.ra.d() && (jVar.o() || jVar.q())) {
            return jVar.f1773b;
        }
        Rect rect = jVar.f1773b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.set(0, 0, 0, 0);
            ((h) this.y.get(i2)).getItemOffsets(this.s, view, this, this.ra);
            int i3 = rect.left;
            Rect rect2 = this.s;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        jVar.f1774c = false;
        return rect;
    }

    public void m() {
        if (this.y.size() != 0) {
            i iVar = this.w;
            if (iVar != null) {
                iVar.a("Cannot invalidate item decorations during a scroll or layout");
            }
            p();
            requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public void e(int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.k(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: 0000 */
    public void f(int i2, int i3) {
        int b2 = this.o.b();
        for (int i4 = 0; i4 < b2; i4++) {
            x i5 = i(this.o.d(i4));
            if (i5 != null && !i5.shouldIgnore() && i5.mPosition >= i2) {
                i5.offsetPosition(i3, false);
                this.ra.f1814g = true;
            }
        }
        this.f1744l.a(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int b2 = this.o.b();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i7 = 0; i7 < b2; i7++) {
            x i8 = i(this.o.d(i7));
            if (i8 != null) {
                int i9 = i8.mPosition;
                if (i9 >= i6 && i9 <= i5) {
                    if (i9 == i2) {
                        i8.offsetPosition(i3 - i2, false);
                    } else {
                        i8.offsetPosition(i4, false);
                    }
                    this.ra.f1814g = true;
                }
            }
        }
        this.f1744l.b(i2, i3);
        requestLayout();
    }

    public x h(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return i(view);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a direct child of ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    public void i(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    static x i(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).f1772a;
    }

    public void b(n nVar) {
        List<n> list = this.ta;
        if (list != null) {
            list.remove(nVar);
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ba) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ba = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.ga = y2;
            this.ea = y2;
        }
    }

    public boolean e(int i2, int i3) {
        i iVar = this.w;
        int i4 = 0;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.H) {
            return false;
        } else {
            boolean b2 = iVar.b();
            boolean c2 = this.w.c();
            if (!b2 || Math.abs(i2) < this.ja) {
                i2 = 0;
            }
            if (!c2 || Math.abs(i3) < this.ja) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = b2 || c2;
                dispatchNestedFling(f2, f3, z2);
                l lVar = this.ia;
                if (lVar != null && lVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (b2) {
                        i4 = 1;
                    }
                    if (c2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.ka;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.ka;
                    this.oa.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        String str = "RV FullInvalidate";
        if (!this.E || this.N) {
            androidx.core.os.b.a(str);
            c();
            androidx.core.os.b.a();
        } else if (this.n.c()) {
            if (this.n.c(4) && !this.n.c(11)) {
                androidx.core.os.b.a("RV PartialInvalidate");
                x();
                r();
                this.n.e();
                if (!this.G) {
                    if (F()) {
                        c();
                    } else {
                        this.n.a();
                    }
                }
                c(true);
                s();
                androidx.core.os.b.a();
            } else if (this.n.c()) {
                androidx.core.os.b.a(str);
                c();
                androidx.core.os.b.a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        for (int size = this.Ga.size() - 1; size >= 0; size--) {
            x xVar = (x) this.Ga.get(size);
            if (xVar.itemView.getParent() == this && !xVar.shouldIgnore()) {
                int i2 = xVar.mPendingAccessibilityState;
                if (i2 != -1) {
                    B.e(xVar.itemView, i2);
                    xVar.mPendingAccessibilityState = -1;
                }
            }
        }
        this.Ga.clear();
    }

    public int f(View view) {
        x i2 = i(view);
        if (i2 != null) {
            return i2.getAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public void c(int i2, int i3) {
        setMeasuredDimension(i.c(i2, getPaddingLeft() + getPaddingRight(), B.o(this)), i.c(i3, getPaddingTop() + getPaddingBottom(), B.n(this)));
    }

    public int g(View view) {
        x i2 = i(view);
        if (i2 != null) {
            return i2.getLayoutPosition();
        }
        return -1;
    }

    public void f(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetLeftAndRight(i2);
        }
    }

    public void g(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetTopAndBottom(i2);
        }
    }

    public boolean j() {
        return !this.E || this.N || this.n.c();
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        String str = "RecyclerView";
        if (this.v == null) {
            Log.e(str, "No adapter attached; skipping layout");
        } else if (this.w == null) {
            Log.e(str, "No layout manager attached; skipping layout");
        } else {
            u uVar = this.ra;
            uVar.f1817j = false;
            if (uVar.f1812e == 1) {
                B();
                this.w.e(this);
                C();
            } else if (!this.n.d() && this.w.o() == getWidth() && this.w.i() == getHeight()) {
                this.w.e(this);
            } else {
                this.w.e(this);
                C();
            }
            D();
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            return sb.toString();
        } else if (str.contains(".")) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RecyclerView.class.getPackage().getName());
            sb2.append('.');
            sb2.append(str);
            return sb2.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        if (this.V == null) {
            this.V = this.R.a(this, 3);
            if (this.q) {
                this.V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.V.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void a(a aVar, boolean z2, boolean z3) {
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.f1743k);
            this.v.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            u();
        }
        this.n.f();
        a aVar3 = this.v;
        this.v = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.f1743k);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(aVar3, this.v);
        }
        this.f1744l.a(aVar3, this.v, z2);
        this.ra.f1814g = true;
    }

    static RecyclerView e(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView e2 = e(viewGroup.getChildAt(i2));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.S.onRelease();
            z2 = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.U.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.T.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.V.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            B.G(this);
        }
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void a(k kVar) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(kVar);
    }

    public x c(int i2) {
        x xVar = null;
        if (this.N) {
            return null;
        }
        int b2 = this.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            x i4 = i(this.o.d(i3));
            if (i4 != null && !i4.isRemoved() && c(i4) == i2) {
                if (!this.o.c(i4.itemView)) {
                    return i4;
                }
                xVar = i4;
            }
        }
        return xVar;
    }

    public void a(h hVar, int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.y.add(hVar);
        } else {
            this.y.add(i2, hVar);
        }
        p();
        requestLayout();
    }

    public void b(m mVar) {
        this.z.remove(mVar);
        if (this.A == mVar) {
            this.A = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public int c(x xVar) {
        if (xVar.hasAnyOfTheFlags(524) || !xVar.isBound()) {
            return -1;
        }
        return this.n.a(xVar.mPosition);
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.A = null;
        }
        int size = this.z.size();
        int i2 = 0;
        while (i2 < size) {
            m mVar = (m) this.z.get(i2);
            if (!mVar.b(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.A = mVar;
                return true;
            }
        }
        return false;
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public void a(n nVar) {
        if (this.ta == null) {
            this.ta = new ArrayList();
        }
        this.ta.add(nVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(x xVar, c cVar, c cVar2) {
        e(xVar);
        xVar.setIsRecyclable(false);
        if (this.W.b(xVar, cVar, cVar2)) {
            t();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, int[] iArr) {
        x();
        r();
        androidx.core.os.b.a("RV Scroll");
        a(this.ra);
        int a2 = i2 != 0 ? this.w.a(i2, this.f1744l, this.ra) : 0;
        int b2 = i3 != 0 ? this.w.b(i3, this.f1744l, this.ra) : 0;
        androidx.core.os.b.a();
        v();
        s();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(boolean z2) {
        this.O = z2 | this.O;
        this.N = true;
        q();
    }

    static void b(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.f1773b;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009b, code lost:
        if (r0 != 0) goto L_0x00a0;
     */
    public boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        MotionEvent motionEvent2 = motionEvent;
        b();
        if (this.v != null) {
            a(i9, i10, this.Fa);
            int[] iArr = this.Fa;
            int i11 = iArr[0];
            int i12 = iArr[1];
            i7 = i12;
            i4 = i11;
            i6 = i9 - i11;
            i5 = i10 - i12;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.y.isEmpty()) {
            invalidate();
        }
        int i13 = i7;
        if (a(i4, i7, i6, i5, this.Ca, 0)) {
            int i14 = this.fa;
            int[] iArr2 = this.Ca;
            this.fa = i14 - iArr2[0];
            this.ga -= iArr2[1];
            if (motionEvent2 != null) {
                motionEvent2.offsetLocation((float) iArr2[0], (float) iArr2[1]);
            }
            int[] iArr3 = this.Ea;
            int i15 = iArr3[0];
            int[] iArr4 = this.Ca;
            iArr3[0] = i15 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !C0248i.e(motionEvent2, 8194)) {
                a(motionEvent.getX(), (float) i6, motionEvent.getY(), (float) i5);
            }
            b(i2, i3);
        }
        if (i4 == 0) {
            i8 = i13;
        } else {
            i8 = i13;
        }
        d(i4, i8);
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i8 == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.i(i2);
        }
        h(i2);
        n nVar = this.sa;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        List<n> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((n) this.ta.get(size)).onScrollStateChanged(this, i2);
            }
        }
    }

    static void b(x xVar) {
        WeakReference<RecyclerView> weakReference = xVar.mNestedRecyclerView;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != xVar.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            xVar.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(View view) {
        x i2 = i(view);
        l(view);
        a aVar = this.v;
        if (!(aVar == null || i2 == null)) {
            aVar.onViewDetachedFromWindow(i2);
        }
        List<k> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((k) this.M.get(size)).a(view);
            }
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            if (!iVar.b()) {
                i2 = 0;
            }
            if (!this.w.c()) {
                i3 = 0;
            }
            if (!(i2 == 0 && i3 == 0)) {
                this.oa.a(i2, i3, interpolator);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    private void a(float f2, float f3, float f4, float f5) {
        boolean z2;
        boolean z3 = true;
        if (f3 < 0.0f) {
            f();
            androidx.core.widget.d.a(this.S, (-f3) / ((float) getWidth()), 1.0f - (f4 / ((float) getHeight())));
        } else if (f3 > 0.0f) {
            g();
            androidx.core.widget.d.a(this.U, f3 / ((float) getWidth()), f4 / ((float) getHeight()));
        } else {
            z2 = false;
            if (f5 >= 0.0f) {
                h();
                androidx.core.widget.d.a(this.T, (-f5) / ((float) getHeight()), f2 / ((float) getWidth()));
            } else if (f5 > 0.0f) {
                e();
                androidx.core.widget.d.a(this.V, f5 / ((float) getHeight()), 1.0f - (f2 / ((float) getWidth())));
            } else {
                z3 = z2;
            }
            if (!z3 || f3 != 0.0f || f5 != 0.0f) {
                B.G(this);
            }
            return;
        }
        z2 = true;
        if (f5 >= 0.0f) {
        }
        if (!z3) {
        }
        B.G(this);
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3) {
        if (i2 < 0) {
            f();
            this.S.onAbsorb(-i2);
        } else if (i2 > 0) {
            g();
            this.U.onAbsorb(i2);
        }
        if (i3 < 0) {
            h();
            this.T.onAbsorb(-i3);
        } else if (i3 > 0) {
            e();
            this.V.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            B.G(this);
        }
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        boolean z2 = false;
        if (!(view2 == null || view2 == this)) {
            if (c(view2) == null) {
                return false;
            }
            if (view == null || c(view) == null) {
                return true;
            }
            this.s.set(0, 0, view.getWidth(), view.getHeight());
            this.t.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view, this.s);
            offsetDescendantRectToMyCoords(view2, this.t);
            char c2 = 65535;
            int i4 = this.w.l() == 1 ? -1 : 1;
            Rect rect = this.s;
            int i5 = rect.left;
            int i6 = this.t.left;
            if ((i5 < i6 || rect.right <= i6) && this.s.right < this.t.right) {
                i3 = 1;
            } else {
                Rect rect2 = this.s;
                int i7 = rect2.right;
                int i8 = this.t.right;
                i3 = ((i7 > i8 || rect2.left >= i8) && this.s.left > this.t.left) ? -1 : 0;
            }
            Rect rect3 = this.s;
            int i9 = rect3.top;
            int i10 = this.t.top;
            if ((i9 < i10 || rect3.bottom <= i10) && this.s.bottom < this.t.bottom) {
                c2 = 1;
            } else {
                Rect rect4 = this.s;
                int i11 = rect4.bottom;
                int i12 = this.t.bottom;
                if ((i11 <= i12 && rect4.top < i12) || this.s.top <= this.t.top) {
                    c2 = 0;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    if (c2 > 0 || (c2 == 0 && i3 * i4 >= 0)) {
                        z2 = true;
                    }
                    return z2;
                } else if (i2 == 17) {
                    if (i3 < 0) {
                        z2 = true;
                    }
                    return z2;
                } else if (i2 == 33) {
                    if (c2 < 0) {
                        z2 = true;
                    }
                    return z2;
                } else if (i2 == 66) {
                    if (i3 > 0) {
                        z2 = true;
                    }
                    return z2;
                } else if (i2 == 130) {
                    if (c2 > 0) {
                        z2 = true;
                    }
                    return z2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid direction: ");
                    sb.append(i2);
                    sb.append(i());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (c2 < 0 || (c2 == 0 && i3 * i4 <= 0)) {
                z2 = true;
            }
        }
        return z2;
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.s.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.f1774c) {
                Rect rect = jVar.f1773b;
                Rect rect2 = this.s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.s);
            offsetRectIntoDescendantCoords(view, this.s);
        }
        this.w.a(this, view, this.s, !this.E, view2 == null);
    }

    /* access modifiers changed from: 0000 */
    public void a(String str) {
        if (o()) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                sb.append(i());
                throw new IllegalStateException(sb.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.Q > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(i());
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(sb2.toString()));
        }
    }

    public void a(m mVar) {
        this.z.add(mVar);
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        m mVar = this.A;
        if (mVar != null) {
            if (action == 0) {
                this.A = null;
            } else {
                mVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar2 = (m) this.z.get(i2);
                if (mVar2.b(this, motionEvent)) {
                    this.A = mVar2;
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z2) {
        this.P--;
        if (this.P < 1) {
            this.P = 0;
            if (z2) {
                A();
                d();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? b.g.i.a.b.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.J = a2 | this.J;
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final void a(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.oa.f1822c;
            uVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.p = 0;
        uVar.q = 0;
    }

    private void a(long j2, x xVar, x xVar2) {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            x i3 = i(this.o.c(i2));
            if (i3 != xVar && d(i3) == j2) {
                a aVar = this.v;
                String str = " \n View Holder 2:";
                if (aVar == null || !aVar.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(i3);
                    sb.append(str);
                    sb.append(xVar);
                    sb.append(i());
                    throw new IllegalStateException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(i3);
                sb2.append(str);
                sb2.append(xVar);
                sb2.append(i());
                throw new IllegalStateException(sb2.toString());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb3.append(xVar2);
        sb3.append(" cannot be found but it is necessary for ");
        sb3.append(xVar);
        sb3.append(i());
        Log.e("RecyclerView", sb3.toString());
    }

    /* access modifiers changed from: 0000 */
    public void a(x xVar, c cVar) {
        xVar.setFlags(0, 8192);
        if (this.ra.f1816i && xVar.isUpdated() && !xVar.isRemoved() && !xVar.shouldIgnore()) {
            this.p.a(d(xVar), xVar);
        }
        this.p.c(xVar, cVar);
    }

    private void a(int[] iArr) {
        int a2 = this.o.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            x i5 = i(this.o.c(i4));
            if (!i5.shouldIgnore()) {
                int layoutPosition = i5.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    /* access modifiers changed from: 0000 */
    public void a(x xVar, c cVar, c cVar2) {
        xVar.setIsRecyclable(false);
        if (this.W.a(xVar, cVar, cVar2)) {
            t();
        }
    }

    private void a(x xVar, x xVar2, c cVar, c cVar2, boolean z2, boolean z3) {
        xVar.setIsRecyclable(false);
        if (z2) {
            e(xVar);
        }
        if (xVar != xVar2) {
            if (z3) {
                e(xVar2);
            }
            xVar.mShadowedHolder = xVar2;
            e(xVar);
            this.f1744l.c(xVar);
            xVar2.setIsRecyclable(false);
            xVar2.mShadowingHolder = xVar;
        }
        if (this.W.a(xVar, xVar2, cVar, cVar2)) {
            t();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x i3 = i(this.o.d(i2));
            if (!i3.shouldIgnore()) {
                i3.clearOldPosition();
            }
        }
        this.f1744l.b();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.o.b();
        for (int i5 = 0; i5 < b2; i5++) {
            x i6 = i(this.o.d(i5));
            if (i6 != null && !i6.shouldIgnore()) {
                int i7 = i6.mPosition;
                if (i7 >= i4) {
                    i6.offsetPosition(-i3, z2);
                    this.ra.f1814g = true;
                } else if (i7 >= i2) {
                    i6.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.ra.f1814g = true;
                }
            }
        }
        this.f1744l.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, Object obj) {
        int b2 = this.o.b();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < b2; i5++) {
            View d2 = this.o.d(i5);
            x i6 = i(d2);
            if (i6 != null && !i6.shouldIgnore()) {
                int i7 = i6.mPosition;
                if (i7 >= i2 && i7 < i4) {
                    i6.addFlags(2);
                    i6.addChangePayload(obj);
                    ((j) d2.getLayoutParams()).f1774c = true;
                }
            }
        }
        this.f1744l.c(i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(x xVar) {
        f fVar = this.W;
        return fVar == null || fVar.a(xVar, xVar.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: 0000 */
    public x a(int i2, boolean z2) {
        int b2 = this.o.b();
        x xVar = null;
        for (int i3 = 0; i3 < b2; i3++) {
            x i4 = i(this.o.d(i3));
            if (i4 != null && !i4.isRemoved()) {
                if (z2) {
                    if (i4.mPosition != i2) {
                        continue;
                    }
                } else if (i4.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.o.c(i4.itemView)) {
                    return i4;
                }
                xVar = i4;
            }
        }
        return xVar;
    }

    public x a(long j2) {
        a aVar = this.v;
        x xVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int b2 = this.o.b();
            for (int i2 = 0; i2 < b2; i2++) {
                x i3 = i(this.o.d(i2));
                if (i3 != null && !i3.isRemoved() && i3.getItemId() == j2) {
                    if (!this.o.c(i3.itemView)) {
                        return i3;
                    }
                    xVar = i3;
                }
            }
        }
        return xVar;
    }

    public View a(float f2, float f3) {
        for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
            View c2 = this.o.c(a2);
            float translationX = c2.getTranslationX();
            float translationY = c2.getTranslationY();
            if (f2 >= ((float) c2.getLeft()) + translationX && f2 <= ((float) c2.getRight()) + translationX && f3 >= ((float) c2.getTop()) + translationY && f3 <= ((float) c2.getBottom()) + translationY) {
                return c2;
            }
        }
        return null;
    }

    public void a(View view, Rect rect) {
        b(view, rect);
    }

    /* access modifiers changed from: 0000 */
    public void a(View view) {
        x i2 = i(view);
        k(view);
        a aVar = this.v;
        if (!(aVar == null || i2 == null)) {
            aVar.onViewAttachedToWindow(i2);
        }
        List<k> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((k) this.M.get(size)).b(view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(x xVar, int i2) {
        if (o()) {
            xVar.mPendingAccessibilityState = i2;
            this.Ga.add(xVar);
            return false;
        }
        B.e(xVar.itemView, i2);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set fast scroller without both required drawables.");
            sb.append(i());
            throw new IllegalArgumentException(sb.toString());
        }
        Resources resources = getContext().getResources();
        new C0236w(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(b.n.a.fastscroll_default_thickness), resources.getDimensionPixelSize(b.n.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(b.n.a.fastscroll_margin));
    }

    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
