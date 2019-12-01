package com.touchin.vtb.utils;

import androidx.appcompat.app.C0146m;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: DialogManager.kt */
final class f extends i implements a<m> {
    final /* synthetic */ C0146m $dialog$inlined;
    final /* synthetic */ a $negativeButtonAction$inlined;
    final /* synthetic */ CharSequence $negativeButtonText$inlined;

    f(CharSequence charSequence, a aVar, C0146m mVar) {
        this.$negativeButtonText$inlined = charSequence;
        this.$negativeButtonAction$inlined = aVar;
        this.$dialog$inlined = mVar;
        super(0);
    }

    public final void b() {
        this.$negativeButtonAction$inlined.b();
        this.$dialog$inlined.dismiss();
    }
}
