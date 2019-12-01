package com.touchin.vtb.h.b;

import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.api.UserProfile;
import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: BanksManagementViewModel.kt */
final /* synthetic */ class b extends g implements kotlin.e.a.b<UserProfile, List<ConnectedBank>> {

    /* renamed from: c reason: collision with root package name */
    public static final b f7504c = new b();

    b() {
        super(1);
    }

    public final String f() {
        return "getConnectedBanksList";
    }

    public final e g() {
        return o.a(UserProfile.class);
    }

    public final String i() {
        return "getConnectedBanksList()Ljava/util/List;";
    }

    public final List<ConnectedBank> a(UserProfile userProfile) {
        h.b(userProfile, "p1");
        return userProfile.c();
    }
}
