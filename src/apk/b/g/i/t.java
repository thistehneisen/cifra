package b.g.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat */
public final class t {

    /* renamed from: a reason: collision with root package name */
    private Object f2726a;

    private t(Object obj) {
        this.f2726a = obj;
    }

    public Object a() {
        return this.f2726a;
    }

    public static t a(Context context, int i2) {
        if (VERSION.SDK_INT >= 24) {
            return new t(PointerIcon.getSystemIcon(context, i2));
        }
        return new t(null);
    }
}
