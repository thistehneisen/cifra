package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.f.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.fa reason: case insensitive filesystem */
/* compiled from: SearchCompanyViewController.kt */
final class C0687fa<T> implements v<a<? extends Boolean>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchCompanyViewController f7716a;

    C0687fa(SearchCompanyViewController searchCompanyViewController) {
        this.f7716a = searchCompanyViewController;
    }

    public final void a(a<Boolean> aVar) {
        if (aVar instanceof c) {
            this.f7716a.progressButton.setState(h.LOADING);
        } else if (aVar instanceof d) {
            this.f7716a.progressButton.setState(h.SUCCESS);
            ((com.touchin.vtb.activities.c) this.f7716a.getActivity()).d().a(com.touchin.vtb.b.h.SELECT_COMPANY_CONFIRM);
            this.f7716a.getView().postDelayed(new C0683da(this), 1000);
        } else if (aVar instanceof b) {
            this.f7716a.getView().postDelayed(new C0685ea(this), 1000);
        }
    }
}
