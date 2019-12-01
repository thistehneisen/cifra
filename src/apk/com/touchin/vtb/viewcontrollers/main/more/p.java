package com.touchin.vtb.viewcontrollers.main.more;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.viewcontrollers.startup.RulesViewController;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: MoreViewController.kt */
final class p implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ MoreViewController f7656a;

    p(MoreViewController moreViewController) {
        this.f7656a = moreViewController;
    }

    public final void onClick(View view) {
        d.a(((c) this.f7656a.getActivity()).c(), RulesViewController.class, b.f11113a, false, null, null, 28, null);
    }
}
