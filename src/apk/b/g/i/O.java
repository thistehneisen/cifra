package b.g.i;

import android.os.Build.VERSION;
import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat */
public class O {

    /* renamed from: a reason: collision with root package name */
    private final Object f2661a;

    private O(Object obj) {
        this.f2661a = obj;
    }

    public O a() {
        if (VERSION.SDK_INT >= 20) {
            return new O(((WindowInsets) this.f2661a).consumeSystemWindowInsets());
        }
        return null;
    }

    public int b() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2661a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2661a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2661a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int e() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2661a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || O.class != obj.getClass()) {
            return false;
        }
        O o = (O) obj;
        Object obj2 = this.f2661a;
        if (obj2 != null) {
            z = obj2.equals(o.f2661a);
        } else if (o.f2661a != null) {
            z = false;
        }
        return z;
    }

    public boolean f() {
        if (VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f2661a).isConsumed();
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f2661a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public O a(int i2, int i3, int i4, int i5) {
        if (VERSION.SDK_INT >= 20) {
            return new O(((WindowInsets) this.f2661a).replaceSystemWindowInsets(i2, i3, i4, i5));
        }
        return null;
    }

    static O a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new O(obj);
    }

    static Object a(O o) {
        if (o == null) {
            return null;
        }
        return o.f2661a;
    }
}
