package com.touchin.vtb.viewcontrollers.startup;

import android.text.Editable;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: GetAccessViewController.kt */
final class N extends i implements b<Editable, m> {
    final /* synthetic */ GetAccessViewController this$0;

    N(GetAccessViewController getAccessViewController) {
        this.this$0 = getAccessViewController;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final void a(Editable editable) {
        h.b(editable, "it");
        this.this$0.progressButton.setVisibility(n.a(this.this$0.passwordFocusawareEditText.getText()) ^ true ? 0 : 8);
    }
}
