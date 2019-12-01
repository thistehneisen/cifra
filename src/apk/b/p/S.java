package b.p;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class S {
    static Q a(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 18) {
            return new P(viewGroup);
        }
        return O.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 18) {
            V.a(viewGroup, z);
        } else {
            U.a(viewGroup, z);
        }
    }
}
