package com.touchin.vtb.activities;

import android.os.Parcelable;
import androidx.lifecycle.v;
import com.touchin.vtb.g.n;
import com.touchin.vtb.viewcontrollers.startup.UpdateViewController;
import l.a.c.a.a;
import l.a.c.a.a.b;

/* compiled from: StartupActivity.kt */
final class d<T> implements v<a<? extends Boolean>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ StartupActivity f7019a;

    d(StartupActivity startupActivity) {
        this.f7019a = startupActivity;
    }

    public final void a(a<Boolean> aVar) {
        if (aVar instanceof l.a.c.a.a.d) {
            StartupActivity.a(this.f7019a).e();
        } else if (aVar instanceof b) {
            ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(this.f7019a.c(), UpdateViewController.class, (Parcelable) new n(((b) aVar).b()), (kotlin.e.a.b) null, 4, (Object) null);
        }
    }
}
