package com.touchin.vtb.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.q;
import com.touchin.vtb.api.TaskInfo;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.a.f;
import l.a.d.a.b.a;

/* compiled from: TaskTaxDelegate.kt */
public final class d extends f<q, com.touchin.vtb.a.H.d> {

    /* renamed from: b reason: collision with root package name */
    private final b<TaskInfo, m> f6905b;

    public d(b<? super TaskInfo, m> bVar) {
        h.b(bVar, "onTaxesItemClickAction");
        this.f6905b = bVar;
    }

    public boolean b(Object obj, int i2, int i3) {
        h.b(obj, "item");
        return obj instanceof com.touchin.vtb.a.H.d;
    }

    public q a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = a.a(R.layout.item_task_tax, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout.item_task_tax, parent)");
        return new q(a2, this.f6905b);
    }

    public void a(q qVar, com.touchin.vtb.a.H.d dVar, int i2, int i3, List<Object> list) {
        h.b(qVar, "holder");
        h.b(dVar, "item");
        h.b(list, "payloads");
        qVar.a(dVar.a());
    }
}
