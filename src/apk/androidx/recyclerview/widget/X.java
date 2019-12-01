package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: SimpleItemAnimator */
public abstract class X extends f {

    /* renamed from: g reason: collision with root package name */
    boolean f1863g = true;

    public void a(boolean z) {
        this.f1863g = z;
    }

    public abstract boolean a(x xVar, int i2, int i3, int i4, int i5);

    public abstract boolean a(x xVar, x xVar2, int i2, int i3, int i4, int i5);

    public boolean b(x xVar) {
        return !this.f1863g || xVar.isInvalid();
    }

    public void c(x xVar, boolean z) {
    }

    public boolean c(x xVar, c cVar, c cVar2) {
        if (cVar.f1751a == cVar2.f1751a && cVar.f1752b == cVar2.f1752b) {
            j(xVar);
            return false;
        }
        return a(xVar, cVar.f1751a, cVar.f1752b, cVar2.f1751a, cVar2.f1752b);
    }

    public void d(x xVar, boolean z) {
    }

    public abstract boolean f(x xVar);

    public abstract boolean g(x xVar);

    public final void h(x xVar) {
        n(xVar);
        c(xVar);
    }

    public final void i(x xVar) {
        o(xVar);
    }

    public final void j(x xVar) {
        p(xVar);
        c(xVar);
    }

    public final void k(x xVar) {
        q(xVar);
    }

    public final void l(x xVar) {
        r(xVar);
        c(xVar);
    }

    public final void m(x xVar) {
        s(xVar);
    }

    public void n(x xVar) {
    }

    public void o(x xVar) {
    }

    public void p(x xVar) {
    }

    public void q(x xVar) {
    }

    public void r(x xVar) {
    }

    public void s(x xVar) {
    }

    public boolean a(x xVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.f1751a == cVar2.f1751a && cVar.f1752b == cVar2.f1752b)) {
            return f(xVar);
        }
        return a(xVar, cVar.f1751a, cVar.f1752b, cVar2.f1751a, cVar2.f1752b);
    }

    public boolean b(x xVar, c cVar, c cVar2) {
        int i2 = cVar.f1751a;
        int i3 = cVar.f1752b;
        View view = xVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1751a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1752b;
        if (xVar.isRemoved() || (i2 == left && i3 == top)) {
            return g(xVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(xVar, i2, i3, left, top);
    }

    public boolean a(x xVar, x xVar2, c cVar, c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.f1751a;
        int i5 = cVar.f1752b;
        if (xVar2.shouldIgnore()) {
            int i6 = cVar.f1751a;
            i2 = cVar.f1752b;
            i3 = i6;
        } else {
            i3 = cVar2.f1751a;
            i2 = cVar2.f1752b;
        }
        return a(xVar, xVar2, i4, i5, i3, i2);
    }

    public final void a(x xVar, boolean z) {
        c(xVar, z);
        c(xVar);
    }

    public final void b(x xVar, boolean z) {
        d(xVar, z);
    }
}
