package com.touchin.vtb.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.h;
import java.util.List;
import kotlin.m;
import l.a.a.f;

/* compiled from: TaskBankConnectionDelegate.kt */
public final class a extends f<h, com.touchin.vtb.a.H.a> {

    /* renamed from: b reason: collision with root package name */
    private final kotlin.e.a.a<m> f6900b;

    public a(kotlin.e.a.a<m> aVar) {
        kotlin.e.b.h.b(aVar, "onBankConnectionItemClickAction");
        this.f6900b = aVar;
    }

    public boolean b(Object obj, int i2, int i3) {
        kotlin.e.b.h.b(obj, "item");
        return obj instanceof com.touchin.vtb.a.H.a;
    }

    public h a(ViewGroup viewGroup) {
        kotlin.e.b.h.b(viewGroup, "parent");
        View a2 = l.a.d.a.b.a.a(R.layout.item_task_bank_connection, viewGroup);
        kotlin.e.b.h.a((Object) a2, "UiUtils.inflate(R.layout…_bank_connection, parent)");
        return new h(a2, this.f6900b);
    }

    public void a(h hVar, com.touchin.vtb.a.H.a aVar, int i2, int i3, List<Object> list) {
        kotlin.e.b.h.b(hVar, "holder");
        kotlin.e.b.h.b(aVar, "item");
        kotlin.e.b.h.b(list, "payloads");
        hVar.a(aVar.a());
    }
}
