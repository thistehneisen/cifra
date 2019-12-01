package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.f.d;
import com.touchin.vtb.utils.h;
import com.touchin.vtb.viewcontrollers.startup.EnterPinViewController;
import l.a.c.a.a;

/* compiled from: TaskTaxViewController.kt */
final class f<T> implements v<a<? extends d>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskTaxViewController f7666a;

    f(TaskTaxViewController taskTaxViewController) {
        this.f7666a = taskTaxViewController;
    }

    public final void a(a<d> aVar) {
        a<d> aVar2 = aVar;
        if (aVar2 instanceof a.d) {
            a.d dVar = (a.d) aVar2;
            if (((d) dVar.a()).b()) {
                h hVar = h.f7619a;
                C0200o requireFragmentManager = this.f7666a.getFragment().requireFragmentManager();
                kotlin.e.b.h.a((Object) requireFragmentManager, "fragment.requireFragmentManager()");
                h.a(hVar, requireFragmentManager, 0, (Fragment) this.f7666a.getFragment(), (String) null, this.f7666a.getString(R.string.android_confirm_task_pay_title), this.f7666a.getString(R.string.common_pin_code_touch_action), 10, (Object) null);
                return;
            }
            com.touchin.vtb.g.d dVar2 = new com.touchin.vtb.g.d(((d) dVar.a()).a(), false, 0, false, false, null, null, 0, null, null, R.string.android_confirm_task_pay_title, R.string.android_confirm_task_pay_title, 1012, null);
            ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(((MainActivity) this.f7666a.getActivity()).c(), EnterPinViewController.class, dVar2, this.f7666a.getFragment(), 301, null, null, 48, null);
        }
    }
}
