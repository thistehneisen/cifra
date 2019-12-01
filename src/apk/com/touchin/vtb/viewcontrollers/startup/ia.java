package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.api.CompanyInfo;
import com.touchin.vtb.g.i;
import com.touchin.vtb.h.c.r;
import java.math.BigDecimal;
import org.joda.time.b;

/* compiled from: SearchCompanyViewController.kt */
final class ia implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchCompanyViewController f7722a;

    ia(SearchCompanyViewController searchCompanyViewController) {
        this.f7722a = searchCompanyViewController;
    }

    public final void onClick(View view) {
        r access$getViewModel$p = this.f7722a.viewModel;
        String p = ((i) this.f7722a.getState()).p();
        String q = ((i) this.f7722a.getState()).q();
        String r = ((i) this.f7722a.getState()).r();
        BigDecimal s = ((i) this.f7722a.getState()).s();
        CompanyInfo companyInfo = new CompanyInfo(p, q, r, new b(s != null ? Long.valueOf(s.longValue()) : null), null, ((i) this.f7722a.getState()).n(), null);
        access$getViewModel$p.a(companyInfo);
    }
}
