package com.touchin.vtb.activities.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.viewcontrollers.main.chat.ChatViewController;
import io.intercom.android.sdk.Intercom;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: BottomNavigationController.kt */
final class b implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f6998a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Class f6999b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f7000c;

    b(c cVar, Class cls, View view) {
        this.f6998a = cVar;
        this.f6999b = cls;
        this.f7000c = view;
    }

    public final void onClick(View view) {
        if (h.a((Object) this.f6999b, (Object) ChatViewController.class)) {
            Intercom.client().displayMessenger();
            return;
        }
        c cVar = this.f6998a;
        if (!cVar.a(cVar.f7004d.e(), this.f6999b)) {
            c.a(this.f6998a, this.f7000c.getId(), null, 2, null);
            return;
        }
        try {
            a b2 = this.f6998a.f7006f;
            if (b2 != null) {
                m mVar = (m) b2.b();
            }
        } catch (IllegalStateException unused) {
        }
    }
}
