package com.touchin.vtb.viewcontrollers.startup;

import androidx.fragment.app.C0195j;
import com.touchin.vtb.activities.StartupActivity;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: UpdateViewController.kt */
final class qa extends i implements a<m> {
    final /* synthetic */ UpdateViewController this$0;

    qa(UpdateViewController updateViewController) {
        this.this$0 = updateViewController;
        super(0);
    }

    public final void b() {
        C0195j activity = this.this$0.getActivity();
        String packageName = ((StartupActivity) this.this$0.getActivity()).getPackageName();
        h.a((Object) packageName, "activity.packageName");
        l.a.b.a.a(activity, packageName);
    }
}
