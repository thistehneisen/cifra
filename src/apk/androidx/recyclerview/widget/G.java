package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;

/* compiled from: OrientationHelper */
class G extends I {
    G(i iVar) {
        super(iVar, null);
    }

    public int a() {
        return this.f1699a.o();
    }

    public int b() {
        return this.f1699a.o() - this.f1699a.getPaddingRight();
    }

    public int c(View view) {
        j jVar = (j) view.getLayoutParams();
        return this.f1699a.h(view) + jVar.topMargin + jVar.bottomMargin;
    }

    public int d(View view) {
        return this.f1699a.g(view) - ((j) view.getLayoutParams()).leftMargin;
    }

    public int e(View view) {
        this.f1699a.a(view, true, this.f1701c);
        return this.f1701c.right;
    }

    public int f() {
        return this.f1699a.getPaddingLeft();
    }

    public int g() {
        return (this.f1699a.o() - this.f1699a.getPaddingLeft()) - this.f1699a.getPaddingRight();
    }

    public void a(int i2) {
        this.f1699a.g(i2);
    }

    public int b(View view) {
        j jVar = (j) view.getLayoutParams();
        return this.f1699a.i(view) + jVar.leftMargin + jVar.rightMargin;
    }

    public int f(View view) {
        this.f1699a.a(view, true, this.f1701c);
        return this.f1701c.left;
    }

    public int a(View view) {
        return this.f1699a.j(view) + ((j) view.getLayoutParams()).rightMargin;
    }

    public int c() {
        return this.f1699a.getPaddingRight();
    }

    public int d() {
        return this.f1699a.p();
    }

    public int e() {
        return this.f1699a.j();
    }
}
