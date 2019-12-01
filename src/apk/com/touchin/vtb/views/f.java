package com.touchin.vtb.views;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: OnSwipeListener.kt */
public abstract class f extends SimpleOnGestureListener {

    /* compiled from: OnSwipeListener.kt */
    public enum a {
        UP,
        DOWN,
        LEFT,
        RIGHT;
        

        /* renamed from: f reason: collision with root package name */
        public static final C0082a f7788f = null;

        /* renamed from: com.touchin.vtb.views.f$a$a reason: collision with other inner class name */
        /* compiled from: OnSwipeListener.kt */
        public static final class C0082a {
            private C0082a() {
            }

            private final boolean a(double d2, float f2, float f3) {
                return d2 >= ((double) f2) && d2 < ((double) f3);
            }

            public final a a(double d2) {
                if (a(d2, 45.0f, 135.0f)) {
                    return a.UP;
                }
                if (a(d2, 0.0f, 45.0f) || a(d2, 315.0f, 360.0f)) {
                    return a.RIGHT;
                }
                if (a(d2, 225.0f, 315.0f)) {
                    return a.DOWN;
                }
                return a.LEFT;
            }

            public /* synthetic */ C0082a(e eVar) {
                this();
            }
        }

        static {
            f7788f = new C0082a(null);
        }
    }

    private final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        return a(b(motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY()), Math.abs(motionEvent.getX() - motionEvent2.getX()));
    }

    private final a b(float f2, float f3, float f4, float f5) {
        return a.f7788f.a(a(f2, f3, f4, f5));
    }

    public abstract boolean a(a aVar, float f2);

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return a(motionEvent, motionEvent2);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return a(motionEvent, motionEvent2);
    }

    private final double a(float f2, float f3, float f4, float f5) {
        double d2 = (double) 180;
        return ((((Math.atan2((double) (f3 - f5), (double) (f4 - f2)) + 3.141592653589793d) * d2) / 3.141592653589793d) + d2) % ((double) 360);
    }
}
