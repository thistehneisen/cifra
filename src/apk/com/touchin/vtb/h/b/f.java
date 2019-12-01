package com.touchin.vtb.h.b;

import androidx.lifecycle.u;
import com.touchin.vtb.f.b.qa;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.c.s;

/* compiled from: LoginSettingsViewModel.kt */
public final class f extends s {

    /* renamed from: e reason: collision with root package name */
    private final u<a<String>> f7516e = new u<>();

    /* renamed from: f reason: collision with root package name */
    private final qa f7517f;

    public f(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7517f = qaVar;
        c();
    }

    public final void c() {
        a(this.f7517f.d(), this.f7516e);
    }

    public final u<a<String>> d() {
        return this.f7516e;
    }
}
