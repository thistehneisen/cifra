package com.touchin.vtb.h.c;

import com.google.android.gms.tasks.C0611c;
import com.google.android.gms.tasks.g;
import com.google.firebase.iid.C0612a;
import com.touchin.vtb.utils.c;
import kotlin.e.b.h;

/* compiled from: StartupViewModel.kt */
final class y<TResult> implements C0611c<C0612a> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ z f7577a;

    y(z zVar) {
        this.f7577a = zVar;
    }

    public final void a(g<C0612a> gVar) {
        h.b(gVar, "task");
        z zVar = this.f7577a;
        String a2 = c.f7616a.a();
        C0612a aVar = (C0612a) gVar.b();
        String a3 = aVar != null ? aVar.a() : null;
        if (a3 == null) {
            a3 = "";
        }
        zVar.a(a2, a3);
    }
}
