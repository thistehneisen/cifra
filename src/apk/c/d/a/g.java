package c.d.a;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import b.g.i.B;
import b.g.i.C0246g;

/* compiled from: Utils */
final class g {
    static int a(View view) {
        return a(view, false);
    }

    static int b(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        if (l(view)) {
            return z ? view.getRight() - h(view) : view.getRight();
        }
        return z ? view.getLeft() + h(view) : view.getLeft();
    }

    static int c(View view) {
        if (view == null) {
            return 0;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0246g.b(marginLayoutParams) + C0246g.a(marginLayoutParams);
    }

    static int d(View view) {
        if (view == null) {
            return 0;
        }
        return C0246g.b((MarginLayoutParams) view.getLayoutParams());
    }

    static int e(View view) {
        if (view == null) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    static int f(View view) {
        if (view == null) {
            return 0;
        }
        return B.p(view);
    }

    static int g(View view) {
        if (view == null) {
            return 0;
        }
        return view.getPaddingLeft() + view.getPaddingRight();
    }

    static int h(View view) {
        if (view == null) {
            return 0;
        }
        return B.q(view);
    }

    static int i(View view) {
        return b(view, false);
    }

    static int j(View view) {
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    static int k(View view) {
        return j(view) + c(view);
    }

    static boolean l(View view) {
        return B.m(view) == 1;
    }

    static int a(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        if (l(view)) {
            return z ? view.getLeft() + f(view) : view.getLeft();
        }
        return z ? view.getRight() - f(view) : view.getRight();
    }

    static int b(View view) {
        if (view == null) {
            return 0;
        }
        return C0246g.a((MarginLayoutParams) view.getLayoutParams());
    }
}
