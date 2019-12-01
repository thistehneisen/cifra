package com.touchin.vtb.viewcontrollers.startup;

import android.os.Parcelable;
import androidx.fragment.app.C0200o;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.g.i;
import kotlin.e.b.h;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.f reason: case insensitive filesystem */
/* compiled from: ConnectBankViewController.kt */
final class C0686f implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ConnectBankViewController f7715a;

    C0686f(ConnectBankViewController connectBankViewController) {
        this.f7715a = connectBankViewController;
    }

    public final boolean a() {
        C0200o requireFragmentManager = this.f7715a.getFragment().requireFragmentManager();
        h.a((Object) requireFragmentManager, "fragment.requireFragmentManager()");
        if (requireFragmentManager.b() > 1) {
            return ((c) this.f7715a.getActivity()).c().a();
        }
        i iVar = new i(null, null, null, null, null, null, 63, null);
        d.a(((c) this.f7715a.getActivity()).c(), SearchCompanyViewController.class, (Parcelable) iVar, (kotlin.e.a.b) null, 4, (Object) null);
        return true;
    }
}
