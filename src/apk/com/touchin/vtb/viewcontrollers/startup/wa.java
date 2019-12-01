package com.touchin.vtb.viewcontrollers.startup;

import android.text.Editable;
import android.view.View;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;
import l.a.d.a.b.a;

/* compiled from: WelcomeViewController.kt */
final class wa extends i implements b<Editable, m> {
    final /* synthetic */ WelcomeViewController this$0;

    wa(WelcomeViewController welcomeViewController) {
        this.this$0 = welcomeViewController;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final void a(Editable editable) {
        h.b(editable, "it");
        if (this.this$0.phoneMaskedEditText.getRaw().length() == 10) {
            this.this$0.progressButton.setVisibility(0);
            a.b.a((View) this.this$0.phoneMaskedEditText);
            return;
        }
        this.this$0.progressButton.setVisibility(4);
    }
}
