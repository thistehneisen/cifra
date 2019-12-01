package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.google.android.gms.tasks.C0611c;
import com.google.android.gms.tasks.g;
import com.google.firebase.iid.C0612a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.i;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: StartupViewModel.kt */
public final class z extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<i>> f7578e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final c<a<Boolean>> f7579f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private final qa f7580g;

    public z(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7580g = qaVar;
        c();
    }

    public final b c() {
        return a(this.f7580g.b(), (u<a<T>>) this.f7579f);
    }

    public final c<a<Boolean>> d() {
        return this.f7579f;
    }

    public final g<C0612a> e() {
        FirebaseInstanceId b2 = FirebaseInstanceId.b();
        h.a((Object) b2, "FirebaseInstanceId.getInstance()");
        g<C0612a> c2 = b2.c();
        c2.a((C0611c<TResult>) new y<TResult>(this));
        h.a((Object) c2, "FirebaseInstanceId.getIn…esult?.token.orEmpty()) }");
        return c2;
    }

    public final c<a<i>> f() {
        return this.f7578e;
    }

    /* access modifiers changed from: private */
    public final b a(String str, String str2) {
        return a(this.f7580g.b(str, str2), (u<a<T>>) this.f7578e);
    }
}
