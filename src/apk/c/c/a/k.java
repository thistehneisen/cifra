package c.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.A;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.B;
import b.g.i.C0242c;
import b.g.i.C0248i;
import b.g.i.w;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ItemTouchHelperExtension */
public class k extends h implements androidx.recyclerview.widget.RecyclerView.k {
    /* access modifiers changed from: private */
    public int A = -1;
    /* access modifiers changed from: private */
    public C0242c B;
    private final m C = new c(this);
    private Rect D;
    private long E;

    /* renamed from: a reason: collision with root package name */
    private boolean f3195a = true;

    /* renamed from: b reason: collision with root package name */
    final List<View> f3196b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private final float[] f3197c = new float[2];

    /* renamed from: d reason: collision with root package name */
    x f3198d = null;

    /* renamed from: e reason: collision with root package name */
    x f3199e = null;

    /* renamed from: f reason: collision with root package name */
    float f3200f;

    /* renamed from: g reason: collision with root package name */
    float f3201g;

    /* renamed from: h reason: collision with root package name */
    float f3202h;

    /* renamed from: i reason: collision with root package name */
    float f3203i;

    /* renamed from: j reason: collision with root package name */
    float f3204j;

    /* renamed from: k reason: collision with root package name */
    float f3205k;

    /* renamed from: l reason: collision with root package name */
    float f3206l;
    float m;
    int n = -1;
    a o;
    int p = 0;
    int q;
    List<c> r = new ArrayList();
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public RecyclerView t;
    /* access modifiers changed from: private */
    public final Runnable u = new b(this);
    /* access modifiers changed from: private */
    public VelocityTracker v;
    private List<x> w;
    private List<Integer> x;
    private androidx.recyclerview.widget.RecyclerView.d y = null;
    /* access modifiers changed from: private */
    public View z = null;

    /* compiled from: ItemTouchHelperExtension */
    public static abstract class a {

        /* renamed from: a reason: collision with root package name */
        private static final A f3207a;

        /* renamed from: b reason: collision with root package name */
        private static final Interpolator f3208b = new i();

        /* renamed from: c reason: collision with root package name */
        private static final Interpolator f3209c = new j();

        /* renamed from: d reason: collision with root package name */
        private int f3210d = -1;

        static {
            int i2 = VERSION.SDK_INT;
            if (i2 >= 21) {
                f3207a = new o();
            } else if (i2 >= 11) {
                f3207a = new n();
            } else {
                f3207a = new m();
            }
        }

        public static int b(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        public static int c(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int d(int i2, int i3) {
            return c(2, i2) | c(1, i3) | c(0, i3 | i2);
        }

        public float a(float f2) {
            return f2;
        }

        public int a() {
            return 0;
        }

        public int a(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        public abstract void a(Canvas canvas, RecyclerView recyclerView, x xVar, float f2, float f3, int i2, boolean z);

        public abstract boolean a(RecyclerView recyclerView, x xVar, x xVar2);

        public float b(float f2) {
            return f2;
        }

        public float b(x xVar) {
            return 0.5f;
        }

        public abstract void b(x xVar, int i2);

        public boolean b() {
            return true;
        }

        public abstract boolean b(RecyclerView recyclerView, x xVar, x xVar2);

        public float c(x xVar) {
            return 0.5f;
        }

        public abstract int c(RecyclerView recyclerView, x xVar);

        public abstract boolean c();

        /* access modifiers changed from: 0000 */
        public final int b(RecyclerView recyclerView, x xVar) {
            return a(c(recyclerView, xVar), B.m(recyclerView));
        }

        /* access modifiers changed from: private */
        public boolean d(RecyclerView recyclerView, x xVar) {
            return (b(recyclerView, xVar) & 16711680) != 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
        public x a(x xVar, List<x> list, int i2, int i3) {
            int i4;
            x xVar2 = xVar;
            int width = i2 + xVar2.itemView.getWidth();
            int height = i3 + xVar2.itemView.getHeight();
            int left = i2 - xVar2.itemView.getLeft();
            int top = i3 - xVar2.itemView.getTop();
            int size = list.size();
            x xVar3 = null;
            int i5 = -1;
            for (int i6 = 0; i6 < size; i6++) {
                x xVar4 = (x) list.get(i6);
                if (left > 0) {
                    int right = xVar4.itemView.getRight() - width;
                    if (right < 0 && xVar4.itemView.getRight() > xVar2.itemView.getRight()) {
                        i4 = Math.abs(right);
                        if (i4 > i5) {
                            xVar3 = xVar4;
                            if (left < 0) {
                                int left2 = xVar4.itemView.getLeft() - i2;
                                if (left2 > 0 && xVar4.itemView.getLeft() < xVar2.itemView.getLeft()) {
                                    int abs = Math.abs(left2);
                                    if (abs > i4) {
                                        i4 = abs;
                                        xVar3 = xVar4;
                                    }
                                }
                            }
                            if (top < 0) {
                                int top2 = xVar4.itemView.getTop() - i3;
                                if (top2 > 0 && xVar4.itemView.getTop() < xVar2.itemView.getTop()) {
                                    int abs2 = Math.abs(top2);
                                    if (abs2 > i4) {
                                        i4 = abs2;
                                        xVar3 = xVar4;
                                    }
                                }
                            }
                            if (top > 0) {
                                int bottom = xVar4.itemView.getBottom() - height;
                                if (bottom < 0 && xVar4.itemView.getBottom() > xVar2.itemView.getBottom()) {
                                    i5 = Math.abs(bottom);
                                    if (i5 > i4) {
                                        xVar3 = xVar4;
                                    }
                                }
                            }
                            i5 = i4;
                        }
                    }
                }
                i4 = i5;
                if (left < 0) {
                }
                if (top < 0) {
                }
                if (top > 0) {
                }
                i5 = i4;
            }
            return xVar3;
        }

        /* access modifiers changed from: private */
        public void b(Canvas canvas, RecyclerView recyclerView, x xVar, List<c> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            List<c> list2 = list;
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = (c) list2.get(i3);
                int save = canvas.save();
                b(canvas, recyclerView, cVar.f3216e, cVar.f3221j, cVar.f3222k, cVar.f3217f, false);
                canvas.restoreToCount(save);
            }
            if (xVar != null) {
                int save2 = canvas.save();
                b(canvas, recyclerView, xVar, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                c cVar2 = (c) list2.get(i4);
                if (cVar2.m && !cVar2.f3220i) {
                    list2.remove(i4);
                } else if (!cVar2.m) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public void b(Canvas canvas, RecyclerView recyclerView, x xVar, float f2, float f3, int i2, boolean z) {
            f3207a.a(canvas, recyclerView, xVar.itemView, f2, f3, i2, z);
        }

        public View a(x xVar) {
            if (xVar == null) {
                return null;
            }
            View view = xVar.itemView;
            if (!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 1) {
                return xVar.itemView;
            }
            ViewGroup viewGroup = (ViewGroup) xVar.itemView;
            return viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        }

        public void a(x xVar, int i2) {
            if (xVar != null) {
                f3207a.b(xVar.itemView);
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.f3210d == -1) {
                this.f3210d = recyclerView.getResources().getDimensionPixelSize(p.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f3210d;
        }

        public void a(RecyclerView recyclerView, x xVar, int i2, x xVar2, int i3, int i4, int i5) {
            i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).a(xVar.itemView, xVar2.itemView, i4, i5);
                return;
            }
            if (layoutManager.b()) {
                if (layoutManager.g(xVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.i(i3);
                }
                if (layoutManager.j(xVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.i(i3);
                }
            }
            if (layoutManager.c()) {
                if (layoutManager.k(xVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.i(i3);
                }
                if (layoutManager.f(xVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.i(i3);
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(Canvas canvas, RecyclerView recyclerView, x xVar, List<c> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = (c) list.get(i3);
                cVar.e();
                int save = canvas.save();
                a(canvas, recyclerView, cVar.f3216e, cVar.f3221j, cVar.f3222k, cVar.f3217f, false);
                canvas.restoreToCount(save);
            }
            if (xVar != null) {
                int save2 = canvas.save();
                a(canvas, recyclerView, xVar, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        public void a(RecyclerView recyclerView, x xVar) {
            f3207a.a(xVar.itemView);
        }

        public long a(RecyclerView recyclerView, int i2, float f2, float f3) {
            long j2;
            f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i2 == 8 ? 200 : 250;
            }
            if (i2 == 8) {
                j2 = itemAnimator.e();
            } else {
                j2 = itemAnimator.f();
            }
            return j2;
        }

        public int a(RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * a(recyclerView))) * f3209c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f3208b.getInterpolation(f2));
            if (interpolation == 0) {
                return i3 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    /* compiled from: ItemTouchHelperExtension */
    private class b extends SimpleOnGestureListener {
        private b() {
        }

        public boolean onContextClick(MotionEvent motionEvent) {
            return super.onContextClick(motionEvent);
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View a2 = k.this.b(motionEvent);
            if (a2 != null) {
                x h2 = k.this.t.h(a2);
                if (h2 != null) {
                    k kVar = k.this;
                    if (kVar.o.d(kVar.t, h2)) {
                        int b2 = C0248i.b(motionEvent, 0);
                        int i2 = k.this.n;
                        if (b2 == i2) {
                            int a3 = C0248i.a(motionEvent, i2);
                            float c2 = C0248i.c(motionEvent, a3);
                            float d2 = C0248i.d(motionEvent, a3);
                            k kVar2 = k.this;
                            kVar2.f3200f = c2;
                            kVar2.f3201g = d2;
                            kVar2.f3205k = 0.0f;
                            kVar2.f3204j = 0.0f;
                            if (kVar2.o.c()) {
                                k.this.c(h2, 2);
                            }
                        }
                    }
                }
            }
        }

        /* synthetic */ b(k kVar, b bVar) {
            this();
        }
    }

    /* compiled from: ItemTouchHelperExtension */
    private class c implements AnimatorListener {

        /* renamed from: a reason: collision with root package name */
        final float f3212a;

        /* renamed from: b reason: collision with root package name */
        final float f3213b;

        /* renamed from: c reason: collision with root package name */
        final float f3214c;

        /* renamed from: d reason: collision with root package name */
        final float f3215d;

        /* renamed from: e reason: collision with root package name */
        final x f3216e;

        /* renamed from: f reason: collision with root package name */
        final int f3217f;

        /* renamed from: g reason: collision with root package name */
        private final ValueAnimator f3218g;
        /* access modifiers changed from: private */

        /* renamed from: h reason: collision with root package name */
        public final int f3219h;

        /* renamed from: i reason: collision with root package name */
        public boolean f3220i;

        /* renamed from: j reason: collision with root package name */
        float f3221j;

        /* renamed from: k reason: collision with root package name */
        float f3222k;

        /* renamed from: l reason: collision with root package name */
        boolean f3223l = false;
        /* access modifiers changed from: private */
        public boolean m = false;
        private float n;

        public c(x xVar, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f3217f = i3;
            this.f3219h = i2;
            this.f3216e = xVar;
            this.f3212a = f2;
            this.f3213b = f3;
            this.f3214c = f4;
            this.f3215d = f5;
            this.f3218g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f3218g.addUpdateListener(new l(this, k.this));
            this.f3218g.setTarget(xVar.itemView);
            this.f3218g.addListener(this);
            a(0.0f);
        }

        public float c() {
            return this.f3216e.itemView.getY() + this.f3222k;
        }

        public void d() {
            this.f3216e.setIsRecyclable(false);
            this.f3218g.start();
        }

        public void e() {
            float f2 = this.f3212a;
            float f3 = this.n;
            this.f3221j = f2 + ((this.f3214c - f2) * f3);
            float f4 = this.f3213b;
            float f5 = this.f3215d;
            if (f4 == f5) {
                this.f3222k = B.t(this.f3216e.itemView);
            } else {
                this.f3222k = f4 + (f3 * (f5 - f4));
            }
        }

        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.f3216e.setIsRecyclable(true);
            }
            this.m = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void a(long j2) {
            this.f3218g.setDuration(j2);
        }

        public float b() {
            return this.f3221j;
        }

        public void a() {
            this.f3218g.cancel();
        }

        public void a(float f2) {
            this.n = f2;
        }
    }

    /* compiled from: ItemTouchHelperExtension */
    public interface d {
        void a(View view, View view2, int i2, int i3);
    }

    public k(a aVar) {
        this.o = aVar;
    }

    public void b(View view) {
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        rect.setEmpty();
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
        float f2;
        float f3;
        this.A = -1;
        if (this.f3198d != null) {
            a(this.f3197c);
            float[] fArr = this.f3197c;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.o.a(canvas, recyclerView, this.f3198d, this.r, this.p, f3, f2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, u uVar) {
        float f2;
        float f3;
        if (this.f3198d != null) {
            a(this.f3197c);
            float[] fArr = this.f3197c;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.o.b(canvas, recyclerView, this.f3198d, this.r, this.p, f3, f2);
    }

    /* access modifiers changed from: private */
    public void c() {
        View a2 = this.o.a(this.f3199e);
        if (this.f3199e != null && a2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2, "translationX", new float[]{a2.getTranslationX(), 0.0f});
            ofFloat.addListener(new d(this));
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
    }

    private void d() {
        this.t.b((h) this);
        this.t.b(this.C);
        this.t.b((androidx.recyclerview.widget.RecyclerView.k) this);
        for (int size = this.r.size() - 1; size >= 0; size--) {
            this.o.a(this.t, ((c) this.r.get(0)).f3216e);
        }
        this.r.clear();
        this.z = null;
        this.A = -1;
        i();
    }

    private float e() {
        x xVar = this.f3198d;
        if (xVar instanceof a) {
            return ((a) xVar).a();
        }
        return (float) this.t.getWidth();
    }

    /* access modifiers changed from: private */
    public boolean f() {
        int size = this.r.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!((c) this.r.get(i2)).m) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        if (this.B == null) {
            this.B = new C0242c(this.t.getContext(), new b(this, null));
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.v = VelocityTracker.obtain();
    }

    private void i() {
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.v = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (r1 > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    public boolean j() {
        int i2;
        int i3;
        int i4;
        if (this.f3198d == null) {
            this.E = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.E;
        long j3 = j2 == Long.MIN_VALUE ? 0 : currentTimeMillis - j2;
        i layoutManager = this.t.getLayoutManager();
        if (this.D == null) {
            this.D = new Rect();
        }
        layoutManager.a(this.f3198d.itemView, this.D);
        if (layoutManager.b()) {
            int i5 = (int) (this.f3206l + this.f3204j);
            int paddingLeft = (i5 - this.D.left) - this.t.getPaddingLeft();
            if (this.f3204j < 0.0f && paddingLeft < 0) {
                i2 = paddingLeft;
                if (layoutManager.c()) {
                }
                i3 = 0;
                if (i2 != 0) {
                }
                int i6 = i2;
                if (i3 == 0) {
                }
                if (i4 == 0) {
                }
                if (this.E == Long.MIN_VALUE) {
                }
                this.t.scrollBy(i4, i3);
                return true;
            } else if (this.f3204j > 0.0f) {
                int width = ((i5 + this.f3198d.itemView.getWidth()) + this.D.right) - (this.t.getWidth() - this.t.getPaddingRight());
                if (width > 0) {
                    i2 = width;
                    if (layoutManager.c()) {
                        int i7 = (int) (this.m + this.f3205k);
                        int paddingTop = (i7 - this.D.top) - this.t.getPaddingTop();
                        if (this.f3205k < 0.0f && paddingTop < 0) {
                            i3 = paddingTop;
                            if (i2 != 0) {
                                i2 = this.o.a(this.t, this.f3198d.itemView.getWidth(), i2, this.t.getWidth(), j3);
                            }
                            int i62 = i2;
                            if (i3 == 0) {
                                int i8 = i3;
                                int i9 = i62;
                                int a2 = this.o.a(this.t, this.f3198d.itemView.getHeight(), i8, this.t.getHeight(), j3);
                                i4 = i9;
                                i3 = a2;
                            } else {
                                i4 = i62;
                            }
                            if (i4 == 0 || i3 != 0) {
                                if (this.E == Long.MIN_VALUE) {
                                    this.E = currentTimeMillis;
                                }
                                this.t.scrollBy(i4, i3);
                                return true;
                            }
                            this.E = Long.MIN_VALUE;
                            return false;
                        } else if (this.f3205k > 0.0f) {
                            i3 = ((i7 + this.f3198d.itemView.getHeight()) + this.D.bottom) - (this.t.getHeight() - this.t.getPaddingBottom());
                        }
                    }
                    i3 = 0;
                    if (i2 != 0) {
                    }
                    int i622 = i2;
                    if (i3 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (this.E == Long.MIN_VALUE) {
                    }
                    this.t.scrollBy(i4, i3);
                    return true;
                }
            }
        }
        i2 = 0;
        if (layoutManager.c()) {
        }
        i3 = 0;
        if (i2 != 0) {
        }
        int i6222 = i2;
        if (i3 == 0) {
        }
        if (i4 == 0) {
        }
        if (this.E == Long.MIN_VALUE) {
        }
        this.t.scrollBy(i4, i3);
        return true;
    }

    private void k() {
        this.s = ViewConfiguration.get(this.t.getContext()).getScaledTouchSlop();
        this.t.a((h) this);
        this.t.a(this.C);
        this.t.a((androidx.recyclerview.widget.RecyclerView.k) this);
        g();
    }

    /* access modifiers changed from: private */
    public void b(x xVar) {
        if (!this.t.isLayoutRequested() && this.p == 2) {
            float b2 = this.o.b(xVar);
            int i2 = (int) (this.f3206l + this.f3204j);
            int i3 = (int) (this.m + this.f3205k);
            if (((float) Math.abs(i3 - xVar.itemView.getTop())) >= ((float) xVar.itemView.getHeight()) * b2 || ((float) Math.abs(i2 - xVar.itemView.getLeft())) >= ((float) xVar.itemView.getWidth()) * b2) {
                List a2 = a(xVar);
                if (a2.size() != 0) {
                    x a3 = this.o.a(xVar, a2, i2, i3);
                    if (a3 == null) {
                        this.w.clear();
                        this.x.clear();
                        return;
                    }
                    int adapterPosition = a3.getAdapterPosition();
                    int adapterPosition2 = xVar.getAdapterPosition();
                    if (this.o.b(this.t, xVar, a3)) {
                        this.o.a(this.t, xVar, adapterPosition2, a3, adapterPosition, i2, i3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129  */
    public void c(x xVar, int i2) {
        boolean z2;
        boolean z3;
        ViewParent parent;
        int i3;
        float f2;
        float f3;
        x xVar2 = xVar;
        int i4 = i2;
        if (xVar2 != this.f3198d || i4 != this.p) {
            this.E = Long.MIN_VALUE;
            int i5 = this.p;
            a(xVar2, true);
            this.p = i4;
            if (i4 == 2) {
                this.z = xVar2.itemView;
                b();
            }
            int i6 = (1 << ((i4 * 8) + 8)) - 1;
            x xVar3 = this.f3198d;
            if (xVar3 != null) {
                if (xVar3.itemView.getParent() != null) {
                    if (i5 == 2) {
                        i3 = 0;
                    } else {
                        i3 = c(xVar3);
                    }
                    i();
                    if (i3 == 1 || i3 == 2) {
                        f2 = Math.signum(this.f3205k) * ((float) this.t.getHeight());
                        f3 = 0.0f;
                    } else {
                        if (i3 == 4 || i3 == 8 || i3 == 16 || i3 == 32) {
                            f3 = Math.signum(this.f3204j) * e();
                        } else {
                            f3 = 0.0f;
                        }
                        f2 = 0.0f;
                    }
                    int i7 = i5 == 2 ? 8 : i3 > 0 ? 2 : 4;
                    a(this.f3197c);
                    float[] fArr = this.f3197c;
                    float f4 = fArr[0];
                    float f5 = fArr[1];
                    f fVar = r0;
                    int i8 = i7;
                    f fVar2 = new f(this, xVar3, i7, i5, f4, f5, f3, f2, i3, xVar3);
                    fVar.a(this.o.a(this.t, i8, f3 - f4, f2 - f5));
                    this.r.add(fVar);
                    fVar.d();
                    z2 = true;
                } else {
                    x xVar4 = xVar3;
                    c(xVar4.itemView);
                    this.o.a(this.t, xVar4);
                    z2 = false;
                }
                this.f3198d = null;
            } else {
                z2 = false;
            }
            if (xVar2 != null) {
                this.q = (this.o.b(this.t, xVar2) & i6) >> (this.p * 8);
                this.f3206l = (float) xVar2.itemView.getLeft();
                this.m = (float) xVar2.itemView.getTop();
                this.f3198d = xVar2;
                if (i4 == 2) {
                    z3 = false;
                    this.f3198d.itemView.performHapticFeedback(0);
                    parent = this.t.getParent();
                    if (parent != null) {
                        if (this.f3198d != null) {
                            z3 = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z3);
                    }
                    if (!z2) {
                        this.t.getLayoutManager().z();
                    }
                    this.o.a(this.f3198d, this.p);
                    this.t.invalidate();
                }
            }
            z3 = false;
            parent = this.t.getParent();
            if (parent != null) {
            }
            if (!z2) {
            }
            this.o.a(this.f3198d, this.p);
            this.t.invalidate();
        }
    }

    public void a() {
        c();
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3) {
        x xVar = this.f3198d;
        if (xVar != null) {
            View view = xVar.itemView;
            if (view instanceof ViewGroup) {
                view = a((ViewGroup) view, f2, f3);
            }
            if (view != null) {
                view.performClick();
            }
        }
    }

    private View a(ViewGroup viewGroup, float f2, float f3) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ViewGroup) && childAt.getVisibility() == 0) {
                View a2 = a((ViewGroup) childAt, f2, f3);
                if (a2 != null) {
                    return a2;
                }
            } else if (a((int) f2, (int) f3, childAt)) {
                return childAt;
            }
        }
        if (a((int) f2, (int) f3, (View) viewGroup)) {
            return viewGroup;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public View b(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        x xVar = this.f3198d;
        if (xVar != null) {
            View view = xVar.itemView;
            if (a(view, x2, y2, this.f3206l + this.f3204j, this.m + this.f3205k)) {
                return view;
            }
        }
        for (int size = this.r.size() - 1; size >= 0; size--) {
            c cVar = (c) this.r.get(size);
            View view2 = cVar.f3216e.itemView;
            if (a(view2, x2, y2, cVar.b(), cVar.c())) {
                return view2;
            }
        }
        return this.t.a(x2, y2);
    }

    private boolean a(int i2, int i3, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()).contains(i2, i3) && B.x(view) && view.getVisibility() == 0;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private int b(x xVar, int i2) {
        if ((i2 & 3) != 0) {
            int i3 = 2;
            int i4 = this.f3205k > 0.0f ? 2 : 1;
            VelocityTracker velocityTracker = this.v;
            if (velocityTracker != null && this.n > -1) {
                a aVar = this.o;
                float f2 = this.f3203i;
                aVar.b(f2);
                velocityTracker.computeCurrentVelocity(1000, f2);
                float a2 = w.a(this.v, this.n);
                float b2 = w.b(this.v, this.n);
                if (b2 <= 0.0f) {
                    i3 = 1;
                }
                float abs = Math.abs(b2);
                if ((i3 & i2) != 0 && i3 == i4) {
                    a aVar2 = this.o;
                    float f3 = this.f3202h;
                    aVar2.a(f3);
                    if (abs >= f3 && abs > Math.abs(a2)) {
                        return i3;
                    }
                }
            }
            float height = ((float) this.t.getHeight()) * this.o.c(xVar);
            if ((i2 & i4) != 0 && Math.abs(this.f3205k) > height) {
                return i4;
            }
        }
        return 0;
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.t;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                d();
            }
            this.t = recyclerView;
            if (this.t != null) {
                Resources resources = recyclerView.getResources();
                this.f3202h = resources.getDimension(p.item_touch_helper_swipe_escape_velocity);
                this.f3203i = resources.getDimension(p.item_touch_helper_swipe_escape_max_velocity);
                k();
                this.t.a((n) new e(this));
            }
        }
    }

    private void a(float[] fArr) {
        if ((this.q & 12) != 0) {
            fArr[0] = (this.f3206l + this.f3204j) - ((float) this.f3198d.itemView.getLeft());
        } else {
            fArr[0] = B.s(this.f3198d.itemView);
        }
        if ((this.q & 3) != 0) {
            fArr[1] = (this.m + this.f3205k) - ((float) this.f3198d.itemView.getTop());
        } else {
            fArr[1] = B.t(this.f3198d.itemView);
        }
    }

    private x c(MotionEvent motionEvent) {
        i layoutManager = this.t.getLayoutManager();
        int i2 = this.n;
        if (i2 == -1) {
            return null;
        }
        int a2 = C0248i.a(motionEvent, i2);
        float c2 = C0248i.c(motionEvent, a2) - this.f3200f;
        float d2 = C0248i.d(motionEvent, a2) - this.f3201g;
        float abs = Math.abs(c2);
        float abs2 = Math.abs(d2);
        int i3 = this.s;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return null;
        }
        if (abs > abs2 && layoutManager.b()) {
            return null;
        }
        if (abs2 > abs && layoutManager.c()) {
            return null;
        }
        View b2 = b(motionEvent);
        if (b2 == null) {
            return null;
        }
        return this.t.h(b2);
    }

    private void b() {
        if (VERSION.SDK_INT < 21) {
            if (this.y == null) {
                this.y = new h(this);
            }
            this.t.setChildDrawingOrderCallback(this.y);
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar, int i2) {
        this.t.post(new g(this, cVar, i2));
    }

    private List<x> a(x xVar) {
        x xVar2 = xVar;
        List<x> list = this.w;
        if (list == null) {
            this.w = new ArrayList();
            this.x = new ArrayList();
        } else {
            list.clear();
            this.x.clear();
        }
        int a2 = this.o.a();
        int round = Math.round(this.f3206l + this.f3204j) - a2;
        int round2 = Math.round(this.m + this.f3205k) - a2;
        int i2 = a2 * 2;
        int width = xVar2.itemView.getWidth() + round + i2;
        int height = xVar2.itemView.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        i layoutManager = this.t.getLayoutManager();
        int f2 = layoutManager.f();
        int i5 = 0;
        while (i5 < f2) {
            View f3 = layoutManager.f(i5);
            if (f3 != xVar2.itemView && f3.getBottom() >= round2 && f3.getTop() <= height && f3.getRight() >= round && f3.getLeft() <= width) {
                x h2 = this.t.h(f3);
                if (this.o.a(this.t, this.f3198d, h2)) {
                    int abs = Math.abs(i3 - ((f3.getLeft() + f3.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((f3.getTop() + f3.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.w.size();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < size && i6 > ((Integer) this.x.get(i7)).intValue()) {
                        i8++;
                        i7++;
                        x xVar3 = xVar;
                    }
                    this.w.add(i8, h2);
                    this.x.add(i8, Integer.valueOf(i6));
                }
            }
            i5++;
            xVar2 = xVar;
        }
        return this.w;
    }

    private int c(x xVar) {
        if (this.p == 2) {
            return 0;
        }
        int c2 = this.o.c(this.t, xVar);
        int a2 = (this.o.a(c2, B.m(this.t)) & 65280) >> 8;
        if (a2 == 0) {
            return 0;
        }
        int i2 = (c2 & 65280) >> 8;
        if (Math.abs(this.f3204j) > Math.abs(this.f3205k)) {
            int a3 = a(xVar, a2);
            if (a3 > 0) {
                return (i2 & a3) == 0 ? a.b(a3, B.m(this.t)) : a3;
            }
            int b2 = b(xVar, a2);
            if (b2 > 0) {
                return b2;
            }
        } else {
            int b3 = b(xVar, a2);
            if (b3 > 0) {
                return b3;
            }
            int a4 = a(xVar, a2);
            if (a4 > 0) {
                if ((i2 & a4) == 0) {
                    a4 = a.b(a4, B.m(this.t));
                }
                return a4;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        if (view == this.z) {
            this.z = null;
            if (this.y != null) {
                this.t.setChildDrawingOrderCallback(null);
            }
        }
    }

    public void a(View view) {
        c(view);
        x h2 = this.t.h(view);
        if (h2 != null) {
            x xVar = this.f3198d;
            if (xVar == null || h2 != xVar) {
                a(h2, false);
                if (this.f3196b.remove(h2.itemView)) {
                    this.o.a(this.t, h2);
                }
            } else {
                c(null, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public int a(x xVar, boolean z2) {
        for (int size = this.r.size() - 1; size >= 0; size--) {
            c cVar = (c) this.r.get(size);
            if (cVar.f3216e == xVar) {
                cVar.f3223l |= z2;
                if (!cVar.m) {
                    cVar.a();
                }
                this.r.remove(size);
                return cVar.f3219h;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, MotionEvent motionEvent, int i3) {
        if (this.f3198d != null || i2 != 2 || this.p == 2 || !this.o.b() || this.t.getScrollState() == 1) {
            return false;
        }
        x c2 = c(motionEvent);
        if (c2 == null) {
            return false;
        }
        int b2 = (this.o.b(this.t, c2) & 65280) >> 8;
        if (b2 == 0) {
            return false;
        }
        float c3 = C0248i.c(motionEvent, i3);
        float f2 = c3 - this.f3200f;
        float d2 = C0248i.d(motionEvent, i3) - this.f3201g;
        float abs = Math.abs(f2);
        float abs2 = Math.abs(d2);
        int i4 = this.s;
        if (abs < ((float) i4) && abs2 < ((float) i4)) {
            return false;
        }
        if (abs > abs2) {
            if (f2 < 0.0f && (b2 & 4) == 0) {
                return false;
            }
            if (f2 > 0.0f && (b2 & 8) == 0) {
                return false;
            }
        } else if (d2 < 0.0f && (b2 & 1) == 0) {
            return false;
        } else {
            if (d2 > 0.0f && (b2 & 2) == 0) {
                return false;
            }
        }
        this.f3205k = 0.0f;
        this.f3204j = 0.0f;
        this.n = C0248i.b(motionEvent, 0);
        c(c2, 1);
        x xVar = this.f3199e;
        if (!(xVar == null || xVar == c2 || c2 == null)) {
            c();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public c a(MotionEvent motionEvent) {
        if (this.r.isEmpty()) {
            return null;
        }
        View b2 = b(motionEvent);
        for (int size = this.r.size() - 1; size >= 0; size--) {
            c cVar = (c) this.r.get(size);
            if (cVar.f3216e.itemView == b2) {
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        this.f3204j = x2 - this.f3200f;
        this.f3205k = y2 - this.f3201g;
        if ((i2 & 4) == 0) {
            this.f3204j = Math.max(0.0f, this.f3204j);
        }
        if ((i2 & 8) == 0) {
            this.f3204j = Math.min(0.0f, this.f3204j);
        }
        if ((i2 & 1) == 0) {
            this.f3205k = Math.max(0.0f, this.f3205k);
        }
        if ((i2 & 2) == 0) {
            this.f3205k = Math.min(0.0f, this.f3205k);
        }
    }

    private int a(x xVar, int i2) {
        if ((i2 & 12) != 0) {
            int i3 = 8;
            int i4 = this.f3204j > 0.0f ? 8 : 4;
            VelocityTracker velocityTracker = this.v;
            if (velocityTracker != null && this.n > -1) {
                a aVar = this.o;
                float f2 = this.f3203i;
                aVar.b(f2);
                velocityTracker.computeCurrentVelocity(1000, f2);
                float a2 = w.a(this.v, this.n);
                float b2 = w.b(this.v, this.n);
                if (a2 <= 0.0f) {
                    i3 = 4;
                }
                float abs = Math.abs(a2);
                if ((i3 & i2) != 0 && i4 == i3) {
                    a aVar2 = this.o;
                    float f3 = this.f3202h;
                    aVar2.a(f3);
                    if (abs >= f3 && abs > Math.abs(b2)) {
                        return i3;
                    }
                }
            }
            float e2 = e() * this.o.c(xVar);
            if ((i2 & i4) != 0 && Math.abs(this.f3204j) > e2) {
                return i4;
            }
        }
        return 0;
    }
}
