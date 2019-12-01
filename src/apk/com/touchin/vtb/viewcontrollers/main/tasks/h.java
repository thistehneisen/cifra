package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.api.TasksTaxInfo;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: TaskTaxViewController.kt */
final class h<T> implements v<a<? extends TasksTaxInfo>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskTaxViewController f7668a;

    h(TaskTaxViewController taskTaxViewController) {
        this.f7668a = taskTaxViewController;
    }

    public final void a(a<? extends TasksTaxInfo> aVar) {
        if (aVar instanceof c) {
            this.f7668a.switcher.a(R.id.global_loader);
        } else if (aVar instanceof d) {
            this.f7668a.switcher.a(R.id.view_controller_task_tax_content_container);
            this.f7668a.setData((TasksTaxInfo) ((d) aVar).a());
        } else {
            boolean z = aVar instanceof b;
        }
    }
}
