package b.g.i;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewParentCompat */
public final class H {
    @Deprecated
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean b(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof C0253n) {
            return ((C0253n) viewParent).a(view, view2, i2, i3);
        }
        if (i3 == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onStartNestedScroll");
                    Log.e("ViewParentCompat", sb.toString(), e2);
                }
            } else if (viewParent instanceof p) {
                return ((p) viewParent).onStartNestedScroll(view, view2, i2);
            }
        }
        return false;
    }

    public static void a(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof C0253n) {
            ((C0253n) viewParent).b(view, view2, i2, i3);
        } else if (i3 != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onNestedScrollAccepted");
                    Log.e("ViewParentCompat", sb.toString(), e2);
                }
            } else if (viewParent instanceof p) {
                ((p) viewParent).onNestedScrollAccepted(view, view2, i2);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof C0253n) {
            ((C0253n) viewParent).a(view, i2);
        } else if (i2 != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onStopNestedScroll");
                    Log.e("ViewParentCompat", sb.toString(), e2);
                }
            } else if (viewParent instanceof p) {
                ((p) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof C0254o) {
            ((C0254o) viewParent2).a(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent2 instanceof C0253n) {
            ((C0253n) viewParent2).a(view, i2, i3, i4, i5, i6);
        } else if (i6 != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError e2) {
                    AbstractMethodError abstractMethodError = e2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onNestedScroll");
                    Log.e("ViewParentCompat", sb.toString(), abstractMethodError);
                }
            } else if (viewParent2 instanceof p) {
                ((p) viewParent2).onNestedScroll(view, i2, i3, i4, i5);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof C0253n) {
            ((C0253n) viewParent).a(view, i2, i3, iArr, i4);
        } else if (i4 != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onNestedPreScroll");
                    Log.e("ViewParentCompat", sb.toString(), e2);
                }
            } else if (viewParent instanceof p) {
                ((p) viewParent).onNestedPreScroll(view, i2, i3, iArr);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedFling");
                Log.e("ViewParentCompat", sb.toString(), e2);
            }
        } else {
            if (viewParent instanceof p) {
                return ((p) viewParent).onNestedFling(view, f2, f3, z);
            }
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedPreFling");
                Log.e("ViewParentCompat", sb.toString(), e2);
            }
        } else {
            if (viewParent instanceof p) {
                return ((p) viewParent).onNestedPreFling(view, f2, f3);
            }
            return false;
        }
    }
}
