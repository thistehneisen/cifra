package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;

/* compiled from: RecyclerView */
class S implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f1827a;

    S(i iVar) {
        this.f1827a = iVar;
    }

    public View a(int i2) {
        return this.f1827a.f(i2);
    }

    public int b() {
        return this.f1827a.o() - this.f1827a.getPaddingRight();
    }

    public int a() {
        return this.f1827a.getPaddingLeft();
    }

    public int b(View view) {
        return this.f1827a.j(view) + ((j) view.getLayoutParams()).rightMargin;
    }

    public int a(View view) {
        return this.f1827a.g(view) - ((j) view.getLayoutParams()).leftMargin;
    }
}
