package com.touchin.vtb.h.b;

import androidx.lifecycle.u;
import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.b.sa;
import e.b.c.g;
import e.b.k;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.b;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: MoreViewModel.kt */
public final class i extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<b> f7520e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final u<a<UserProfile>> f7521f = new u<>();

    /* renamed from: g reason: collision with root package name */
    private final qa f7522g;

    public i(qa qaVar, sa saVar) {
        h.b(qaVar, "userInfoRepository");
        h.b(saVar, "userProfileRepository");
        super(null, null, 3, null);
        this.f7522g = qaVar;
        k b2 = saVar.f().b((g<? super T, ? extends R>) h.f7519a);
        h.a((Object) b2, "userProfileRepository\n  …e> -> userProfile.get() }");
        a(b2, this.f7521f);
    }

    public final c<b> c() {
        return this.f7520e;
    }

    public final u<a<UserProfile>> d() {
        return this.f7521f;
    }

    public final void e() {
        a(this.f7522g.f(), (u<b>) this.f7520e);
    }
}
