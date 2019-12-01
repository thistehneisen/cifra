package com.touchin.vtb.views.maskededittext;

import android.text.Editable;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* compiled from: FocusawarePhoneMaskedEditText.kt */
final /* synthetic */ class a extends g implements b<Editable, m> {
    a(FocusawarePhoneMaskedEditText focusawarePhoneMaskedEditText) {
        super(1, focusawarePhoneMaskedEditText);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final String f() {
        return "moveCursor";
    }

    public final e g() {
        return o.a(FocusawarePhoneMaskedEditText.class);
    }

    public final String i() {
        return "moveCursor(Landroid/text/Editable;)V";
    }

    public final void a(Editable editable) {
        h.b(editable, "p1");
        ((FocusawarePhoneMaskedEditText) this.receiver).a(editable);
    }
}
