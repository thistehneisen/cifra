package com.touchin.vtb.utils;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.e.a.a;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: SimpleTextWatcher.kt */
public final class q implements TextWatcher {

    /* renamed from: a reason: collision with root package name */
    private boolean f7631a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final b<Editable, m> f7632b;

    public q(b<? super Editable, m> bVar) {
        h.b(bVar, "onTextChanged");
        this.f7632b = bVar;
    }

    public void afterTextChanged(Editable editable) {
        h.b(editable, "s");
        a((a<m>) new p<m>(this, editable));
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        h.b(charSequence, "s");
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        h.b(charSequence, "s");
    }

    private final void a(a<m> aVar) {
        if (!this.f7631a) {
            this.f7631a = true;
            aVar.b();
            this.f7631a = false;
        }
    }
}
