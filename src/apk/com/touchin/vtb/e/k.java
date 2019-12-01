package com.touchin.vtb.e;

import android.view.View;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: View.kt */
public final class k {
    public static final void a(View view, a<m> aVar) {
        h.b(view, "$this$setEnterKeyAction");
        h.b(aVar, "action");
        view.setOnKeyListener(new j(aVar));
    }
}
