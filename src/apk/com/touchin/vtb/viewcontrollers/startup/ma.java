package com.touchin.vtb.viewcontrollers.startup;

import android.text.Editable;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: SearchViewController.kt */
final class ma extends i implements b<Editable, m> {
    final /* synthetic */ SearchViewController this$0;

    ma(SearchViewController searchViewController) {
        this.this$0 = searchViewController;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final void a(Editable editable) {
        h.b(editable, "it");
        if (!n.a(this.this$0.editText.getText().toString())) {
            this.this$0.viewModel.a(this.this$0.editText.getText().toString());
        }
    }
}
