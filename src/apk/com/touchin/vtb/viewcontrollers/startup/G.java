package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.e.c;
import com.touchin.vtb.g.f;
import l.a.b.b;

/* compiled from: GetAccessViewController.kt */
final class G implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessViewController f7693a;

    G(GetAccessViewController getAccessViewController) {
        this.f7693a = getAccessViewController;
    }

    public final void onClick(View view) {
        b.b(this.f7693a.getActivity(), c.b(((f) this.f7693a.getState()).q(), this.f7693a.getActivity()));
    }
}
