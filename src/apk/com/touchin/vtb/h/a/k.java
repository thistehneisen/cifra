package com.touchin.vtb.h.a;

import com.touchin.vtb.f.b.sa;
import io.intercom.android.sdk.Company;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.UserAttributes.Builder;
import io.intercom.android.sdk.identity.Registration;
import kotlin.e.b.h;
import l.a.c.c.s;

/* compiled from: MainActivityViewModel.kt */
public final class k extends s {

    /* renamed from: e reason: collision with root package name */
    private final sa f7493e;

    public k(sa saVar) {
        h.b(saVar, "userProfileRepository");
        super(null, null, 3, null);
        this.f7493e = saVar;
    }

    private final UserAttributes b(String str) {
        String str2 = "UserAttributes.Builder()…\n                .build()";
        if (e().length() > 0) {
            UserAttributes build = new Builder().withCompany(new Company.Builder().withCompanyId(e()).withName(c()).withCustomAttribute(str, e()).build()).withPhone(f()).build();
            h.a((Object) build, str2);
            return build;
        }
        UserAttributes build2 = new Builder().withPhone(f()).build();
        h.a((Object) build2, str2);
        return build2;
    }

    private final String c() {
        return this.f7493e.b();
    }

    private final String d() {
        return this.f7493e.c();
    }

    private final String e() {
        return this.f7493e.d();
    }

    private final String f() {
        return this.f7493e.e();
    }

    public final void a(String str) {
        h.b(str, "innCustomKey");
        Intercom.client().registerIdentifiedUser(Registration.create().withUserId(d()).withUserAttributes(b(str)));
    }
}
