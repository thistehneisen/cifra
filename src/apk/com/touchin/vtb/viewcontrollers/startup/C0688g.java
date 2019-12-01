package com.touchin.vtb.viewcontrollers.startup;

import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.g.c;
import com.touchin.vtb.utils.h;
import l.a.c.a.b;
import l.a.c.a.b.C0119b;
import l.a.c.a.b.a;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.g reason: case insensitive filesystem */
/* compiled from: CreatePinViewController.kt */
final class C0688g<T> implements v<b> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ CreatePinViewController f7717a;

    C0688g(CreatePinViewController createPinViewController) {
        this.f7717a = createPinViewController;
    }

    public final void a(b bVar) {
        if (!(bVar instanceof a)) {
            boolean z = bVar instanceof C0119b;
        } else if (!this.f7717a.fingerprintViewModel.e() || ((c) this.f7717a.getState()).p()) {
            this.f7717a.onPinSetSuccessfully();
        } else {
            h hVar = h.f7619a;
            C0200o requireFragmentManager = this.f7717a.getFragment().requireFragmentManager();
            kotlin.e.b.h.a((Object) requireFragmentManager, "fragment.requireFragmentManager()");
            h.a(hVar, requireFragmentManager, 0, (Fragment) this.f7717a.getFragment(), (String) null, this.f7717a.getString(R.string.android_fingerprint_title), this.f7717a.getString(R.string.android_fingerprint_action), 10, (Object) null);
        }
    }
}
