package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;

/* compiled from: OrientationHelper */
class H extends I {
    H(i iVar) {
        super(iVar, null);
    }

    public int a() {
        return this.f1699a.i();
    }

    public int b() {
        return this.f1699a.i() - this.f1699a.getPaddingBottom();
    }

    public int c(View view) {
        j jVar = (j) view.getLayoutParams();
        return this.f1699a.i(view) + jVar.leftMargin + jVar.rightMargin;
    }

    public int d(View view) {
        return this.f1699a.k(view) - ((j) view.getLayoutParams()).topMargin;
    }

    public int e(View view) {
        this.f1699a.a(view, true, this.f1701c);
        return this.f1701c.bottom;
    }

    public int f() {
        return this.f1699a.getPaddingTop();
    }

    public int g() {
        return (this.f1699a.i() - this.f1699a.getPaddingTop()) - this.f1699a.getPaddingBottom();
    }

    public void a(int i2) {
        this.f1699a.h(i2);
    }

    public int b(View view) {
        j jVar = (j) view.getLayoutParams();
        return this.f1699a.h(view) + jVar.topMargin + jVar.bottomMargin;
    }

    public int f(View view) {
        this.f1699a.a(view, true, this.f1701c);
        return this.f1701c.top;
    }

    public int a(View view) {
        return this.f1699a.f(view) + ((j) view.getLayoutParams()).bottomMargin;
    }

    public int c() {
        return this.f1699a.getPaddingBottom();
    }

    public int d() {
        return this.f1699a.j();
    }

    public int e() {
        return this.f1699a.p();
    }
}
