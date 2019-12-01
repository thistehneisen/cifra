package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;

/* compiled from: RecyclerView */
class T implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f1859a;

    T(i iVar) {
        this.f1859a = iVar;
    }

    public View a(int i2) {
        return this.f1859a.f(i2);
    }

    public int b() {
        return this.f1859a.i() - this.f1859a.getPaddingBottom();
    }

    public int a() {
        return this.f1859a.getPaddingTop();
    }

    public int a(View view) {
        return this.f1859a.k(view) - ((j) view.getLayoutParams()).topMargin;
    }

    public int b(View view) {
        return this.f1859a.f(view) + ((j) view.getLayoutParams()).bottomMargin;
    }
}
