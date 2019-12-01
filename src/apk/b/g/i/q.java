package b.g.i;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class q {

    /* renamed from: a reason: collision with root package name */
    private int f2721a;

    /* renamed from: b reason: collision with root package name */
    private int f2722b;

    public q(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    public void a(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f2722b = i2;
        } else {
            this.f2721a = i2;
        }
    }

    public int a() {
        return this.f2721a | this.f2722b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i2) {
        if (i2 == 1) {
            this.f2722b = 0;
        } else {
            this.f2721a = 0;
        }
    }
}
