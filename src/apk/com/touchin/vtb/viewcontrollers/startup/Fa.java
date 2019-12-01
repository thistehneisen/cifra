package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.activities.StartupActivity;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: WelcomeViewController.kt */
final class Fa implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ WelcomeViewController f7692a;

    Fa(WelcomeViewController welcomeViewController) {
        this.f7692a = welcomeViewController;
    }

    public final void onClick(View view) {
        d.a(((StartupActivity) this.f7692a.getActivity()).c(), RulesViewController.class, b.f11113a, false, null, null, 28, null);
    }
}
