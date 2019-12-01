package com.touchin.vtb.a.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: BaseSwapTouchHelperCallback.kt */
public abstract class a extends c.c.a.k.a {

    /* renamed from: e reason: collision with root package name */
    private final b<Integer, m> f6898e;

    public a(b<? super Integer, m> bVar) {
        this.f6898e = bVar;
    }

    public void a(x xVar, int i2) {
        super.a(xVar, i2);
        b<Integer, m> bVar = this.f6898e;
        if (bVar != null) {
            m mVar = (m) bVar.a(Integer.valueOf(i2));
        }
    }

    public boolean a(RecyclerView recyclerView, x xVar, x xVar2) {
        return false;
    }

    public void b(x xVar, int i2) {
        h.b(xVar, "viewHolder");
    }

    public boolean b(RecyclerView recyclerView, x xVar, x xVar2) {
        h.b(recyclerView, "recyclerView");
        h.b(xVar, "viewHolder");
        h.b(xVar2, "target");
        return false;
    }

    public int c(RecyclerView recyclerView, x xVar) {
        h.b(recyclerView, "recyclerView");
        h.b(xVar, "viewHolder");
        return c.c.a.k.a.d(0, 16);
    }

    public boolean c() {
        return false;
    }
}
