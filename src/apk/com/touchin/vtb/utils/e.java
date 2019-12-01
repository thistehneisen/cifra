package com.touchin.vtb.utils;

import androidx.appcompat.app.C0146m;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: DialogManager.kt */
final class e extends i implements a<m> {
    final /* synthetic */ C0146m $dialog$inlined;
    final /* synthetic */ a $positiveButtonAction$inlined;
    final /* synthetic */ CharSequence $positiveButtonText$inlined;

    e(CharSequence charSequence, a aVar, C0146m mVar) {
        this.$positiveButtonText$inlined = charSequence;
        this.$positiveButtonAction$inlined = aVar;
        this.$dialog$inlined = mVar;
        super(0);
    }

    public final void b() {
        this.$positiveButtonAction$inlined.b();
        this.$dialog$inlined.dismiss();
    }
}
