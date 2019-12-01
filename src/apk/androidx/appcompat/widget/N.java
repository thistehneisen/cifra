package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.z;

/* compiled from: ForwardingListener */
public abstract class N implements OnTouchListener, OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    private final float f827a;

    /* renamed from: b reason: collision with root package name */
    private final int f828b;

    /* renamed from: c reason: collision with root package name */
    private final int f829c;

    /* renamed from: d reason: collision with root package name */
    final View f830d;

    /* renamed from: e reason: collision with root package name */
    private Runnable f831e;

    /* renamed from: f reason: collision with root package name */
    private Runnable f832f;

    /* renamed from: g reason: collision with root package name */
    private boolean f833g;

    /* renamed from: h reason: collision with root package name */
    private int f834h;

    /* renamed from: i reason: collision with root package name */
    private final int[] f835i = new int[2];

    /* compiled from: ForwardingListener */
    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = N.this.f830d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener */
    private class b implements Runnable {
        b() {
        }

        public void run() {
            N.this.d();
        }
    }

    public N(View view) {
        this.f830d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f827a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f828b = ViewConfiguration.getTapTimeout();
        this.f829c = (this.f828b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.f830d;
        z a2 = a();
        if (a2 != null && a2.c()) {
            L l2 = (L) a2.d();
            if (l2 != null && l2.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                a(view, obtainNoHistory);
                b(l2, obtainNoHistory);
                boolean a3 = l2.a(obtainNoHistory, this.f834h);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z = true;
                boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (!a3 || !z2) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    private boolean b(MotionEvent motionEvent) {
        View view = this.f830d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f834h);
                    if (findPointerIndex >= 0 && !a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f827a)) {
                        e();
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
            }
            e();
        } else {
            this.f834h = motionEvent.getPointerId(0);
            if (this.f831e == null) {
                this.f831e = new a();
            }
            view.postDelayed(this.f831e, (long) this.f828b);
            if (this.f832f == null) {
                this.f832f = new b();
            }
            view.postDelayed(this.f832f, (long) this.f829c);
        }
        return false;
    }

    private void e() {
        Runnable runnable = this.f832f;
        if (runnable != null) {
            this.f830d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f831e;
        if (runnable2 != null) {
            this.f830d.removeCallbacks(runnable2);
        }
    }

    public abstract z a();

    /* access modifiers changed from: protected */
    public abstract boolean b();

    /* access modifiers changed from: protected */
    public boolean c() {
        z a2 = a();
        if (a2 != null && a2.c()) {
            a2.dismiss();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        e();
        View view = this.f830d;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f833g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f833g;
        if (z2) {
            z = a(motionEvent) || !c();
        } else {
            z = b(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f830d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f833g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f833g = false;
        this.f834h = -1;
        Runnable runnable = this.f831e;
        if (runnable != null) {
            this.f830d.removeCallbacks(runnable);
        }
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f835i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f835i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }
}
