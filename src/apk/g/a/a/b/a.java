package g.a.a.b;

import android.view.View;
import android.view.animation.Interpolator;
import b.g.i.B;
import b.g.i.K;

/* compiled from: ViewHelper */
public final class a {
    public static void a(View view) {
        B.a(view, 1.0f);
        B.i(view, 1.0f);
        B.h(view, 1.0f);
        B.k(view, 0.0f);
        B.j(view, 0.0f);
        B.e(view, 0.0f);
        B.g(view, 0.0f);
        B.f(view, 0.0f);
        B.d(view, (float) (view.getMeasuredHeight() / 2));
        B.c(view, (float) (view.getMeasuredWidth() / 2));
        K a2 = B.a(view);
        a2.a((Interpolator) null);
        a2.b(0);
    }
}
