package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.i.B;

/* compiled from: HeaderBehavior */
abstract class f<V extends View> extends h<V> {

    /* renamed from: d reason: collision with root package name */
    private Runnable f6277d;

    /* renamed from: e reason: collision with root package name */
    OverScroller f6278e;

    /* renamed from: f reason: collision with root package name */
    private boolean f6279f;

    /* renamed from: g reason: collision with root package name */
    private int f6280g = -1;

    /* renamed from: h reason: collision with root package name */
    private int f6281h;

    /* renamed from: i reason: collision with root package name */
    private int f6282i = -1;

    /* renamed from: j reason: collision with root package name */
    private VelocityTracker f6283j;

    /* compiled from: HeaderBehavior */
    private class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final CoordinatorLayout f6284a;

        /* renamed from: b reason: collision with root package name */
        private final V f6285b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f6284a = coordinatorLayout;
            this.f6285b = v;
        }

        public void run() {
            if (this.f6285b != null) {
                OverScroller overScroller = f.this.f6278e;
                if (overScroller == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    f fVar = f.this;
                    fVar.c(this.f6284a, this.f6285b, fVar.f6278e.getCurrY());
                    B.a((View) this.f6285b, (Runnable) this);
                    return;
                }
                f.this.e(this.f6284a, this.f6285b);
            }
        }
    }

    public f() {
    }

    private void d() {
        if (this.f6283j == null) {
            this.f6283j = VelocityTracker.obtain();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean a(V v);

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x0083;
     */
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f6282i < 0) {
            this.f6282i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f6279f) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.f6280g;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex != -1) {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f6281h) > this.f6282i) {
                                this.f6279f = true;
                                this.f6281h = y;
                            }
                        }
                    }
                }
            }
            this.f6279f = false;
            this.f6280g = -1;
            VelocityTracker velocityTracker = this.f6283j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f6283j = null;
            }
        } else {
            this.f6279f = false;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (a(v) && coordinatorLayout.a((View) v, x, y2)) {
                this.f6281h = y2;
                this.f6280g = motionEvent.getPointerId(0);
                d();
            }
        }
        VelocityTracker velocityTracker2 = this.f6283j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.f6279f;
    }

    /* access modifiers changed from: 0000 */
    public abstract int b(V v);

    /* access modifiers changed from: 0000 */
    public abstract int b(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0 != 3) goto L_0x00ae;
     */
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f6282i < 0) {
            this.f6282i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f6283j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.f6283j.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -c(v), 0, this.f6283j.getYVelocity(this.f6280g));
                }
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f6280g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                int i2 = this.f6281h - y;
                if (!this.f6279f) {
                    int abs = Math.abs(i2);
                    int i3 = this.f6282i;
                    if (abs > i3) {
                        this.f6279f = true;
                        i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                    }
                }
                int i4 = i2;
                if (this.f6279f) {
                    this.f6281h = y;
                    a(coordinatorLayout, v, i4, b(v), 0);
                }
            }
            this.f6279f = false;
            this.f6280g = -1;
            VelocityTracker velocityTracker2 = this.f6283j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f6283j = null;
            }
        } else {
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.a((View) v, (int) motionEvent.getX(), y2) || !a(v)) {
                return false;
            }
            this.f6281h = y2;
            this.f6280g = motionEvent.getPointerId(0);
            d();
        }
        VelocityTracker velocityTracker3 = this.f6283j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public abstract int c();

    /* access modifiers changed from: 0000 */
    public abstract int c(V v);

    /* access modifiers changed from: 0000 */
    public int c(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return b(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: 0000 */
    public abstract void e(CoordinatorLayout coordinatorLayout, V v);

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: 0000 */
    public final int a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return b(coordinatorLayout, v, c() - i2, i3, i4);
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        V v2 = v;
        Runnable runnable = this.f6277d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f6277d = null;
        }
        if (this.f6278e == null) {
            this.f6278e = new OverScroller(v.getContext());
        }
        this.f6278e.fling(0, b(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f6278e.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            this.f6277d = new a(coordinatorLayout, v);
            B.a((View) v, this.f6277d);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        e(coordinatorLayout, v);
        return false;
    }
}
