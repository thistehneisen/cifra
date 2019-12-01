package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.v;
import com.touchin.vtb.api.TaxPaymentResponse;
import com.touchin.vtb.f.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: TaskTaxViewController.kt */
final class i<T> implements v<a<? extends TaxPaymentResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskTaxViewController f7669a;

    i(TaskTaxViewController taskTaxViewController) {
        this.f7669a = taskTaxViewController;
    }

    public final void a(a<? extends TaxPaymentResponse> aVar) {
        if (aVar instanceof c) {
            this.f7669a.progressButton.setState(h.LOADING);
        } else if (aVar instanceof d) {
            this.f7669a.progressButton.setState(h.SUCCESS);
            int i2 = e.f7665a[((TaxPaymentResponse) ((d) aVar).a()).c().ordinal()];
        } else {
            boolean z = aVar instanceof b;
        }
    }
}
