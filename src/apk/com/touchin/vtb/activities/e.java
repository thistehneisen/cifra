package com.touchin.vtb.activities;

import android.os.Parcelable;
import androidx.lifecycle.v;
import com.touchin.vtb.f.i;
import com.touchin.vtb.g.o;
import com.touchin.vtb.viewcontrollers.startup.WelcomeViewController;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.d;
import l.a.d.b.a.c;

/* compiled from: StartupActivity.kt */
final class e<T> implements v<a<? extends i>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ StartupActivity f7020a;

    e(StartupActivity startupActivity) {
        this.f7020a = startupActivity;
    }

    public final void a(a<i> aVar) {
        if (aVar instanceof d) {
            this.f7020a.a((i) ((d) aVar).a());
        } else if (aVar instanceof b) {
            c.a(((b) aVar).b());
            ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(this.f7020a.c(), WelcomeViewController.class, (Parcelable) new o(this.f7020a.getIntent().getBooleanExtra("IS_LOGOUT_ACTION", false)), (kotlin.e.a.b) null, 4, (Object) null);
        }
    }
}
