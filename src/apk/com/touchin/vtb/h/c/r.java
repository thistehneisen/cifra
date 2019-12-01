package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.api.CompanyInfo;
import com.touchin.vtb.f.b.qa;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: SearchCompanyViewModel.kt */
public final class r extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<Boolean>> f7565e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final qa f7566f;

    public r(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7566f = qaVar;
    }

    public final b a(CompanyInfo companyInfo) {
        h.b(companyInfo, "companyInfo");
        return a(this.f7566f.a(companyInfo), (u<a<T>>) this.f7565e);
    }

    public final c<a<Boolean>> c() {
        return this.f7565e;
    }
}
