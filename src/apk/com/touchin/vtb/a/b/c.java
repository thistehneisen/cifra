package com.touchin.vtb.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.o;
import java.util.List;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;
import l.a.a.f;

/* compiled from: TaskRegistrationDelegate.kt */
public final class c extends f<o, com.touchin.vtb.a.H.c> {

    /* renamed from: b reason: collision with root package name */
    private final a<m> f6904b;

    public c(a<m> aVar) {
        h.b(aVar, "onRegistrationClickAction");
        this.f6904b = aVar;
    }

    public boolean b(Object obj, int i2, int i3) {
        h.b(obj, "item");
        return obj instanceof com.touchin.vtb.a.H.c;
    }

    public o a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = l.a.d.a.b.a.a(R.layout.item_task_registration, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout…ask_registration, parent)");
        return new o(a2, this.f6904b);
    }

    public void a(o oVar, com.touchin.vtb.a.H.c cVar, int i2, int i3, List<Object> list) {
        h.b(oVar, "holder");
        h.b(cVar, "item");
        h.b(list, "payloads");
        oVar.a(cVar.a());
    }
}
