package b.g.i;

import android.view.MotionEvent;

/* renamed from: b.g.i.i reason: case insensitive filesystem */
/* compiled from: MotionEventCompat */
public final class C0248i {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static float c(MotionEvent motionEvent, int i2) {
        return motionEvent.getX(i2);
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i2) {
        return motionEvent.getY(i2);
    }

    public static boolean e(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }

    @Deprecated
    public static int a(MotionEvent motionEvent, int i2) {
        return motionEvent.findPointerIndex(i2);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent, int i2) {
        return motionEvent.getPointerId(i2);
    }
}
