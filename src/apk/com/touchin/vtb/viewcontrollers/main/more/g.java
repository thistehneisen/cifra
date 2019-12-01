package com.touchin.vtb.viewcontrollers.main.more;

import androidx.appcompat.widget.SwitchCompat;
import kotlin.e.a.a;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* compiled from: LoginSettingsViewController.kt */
final /* synthetic */ class g extends kotlin.e.b.g implements a<m> {
    g(SwitchCompat switchCompat) {
        super(0, switchCompat);
    }

    public final String f() {
        return "toggle";
    }

    public final e g() {
        return o.a(SwitchCompat.class);
    }

    public final String i() {
        return "toggle()V";
    }

    public final void b() {
        ((SwitchCompat) this.receiver).toggle();
    }
}
