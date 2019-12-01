package com.touchin.vtb.e;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import kotlin.e.a.a;
import kotlin.e.b.h;

/* compiled from: View.kt */
final class j implements OnKeyListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f7252a;

    j(a aVar) {
        this.f7252a = aVar;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        h.a((Object) keyEvent, "keyEvent");
        if (keyEvent.getAction() != 0 || i2 != 66) {
            return false;
        }
        this.f7252a.b();
        return true;
    }
}
