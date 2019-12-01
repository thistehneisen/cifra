package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import b.g.c.a.b.C0023b;
import b.g.c.a.b.a;
import com.touchin.vtb.h.c.h.b;
import com.touchin.vtb.h.c.h.c;
import com.touchin.vtb.h.c.h.d;
import kotlin.e.b.h;

/* compiled from: FingerprintViewModel.kt */
public final class k extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f7553a;

    k(i iVar) {
        this.f7553a = iVar;
    }

    public void a(C0023b bVar) {
        h.b(bVar, "result");
        this.f7553a.d().a(d.f7547a);
    }

    public void b(int i2, CharSequence charSequence) {
        this.f7553a.d().a(new c(charSequence));
        u c2 = this.f7553a.c();
        Integer num = (Integer) this.f7553a.c().a();
        if (num == null) {
            num = Integer.valueOf(5);
        }
        c2.a(Integer.valueOf(num.intValue() - 1));
    }

    public void a() {
        this.f7553a.d().a(b.f7545a);
        u c2 = this.f7553a.c();
        Integer num = (Integer) this.f7553a.c().a();
        if (num == null) {
            num = Integer.valueOf(5);
        }
        c2.a(Integer.valueOf(num.intValue() - 1));
    }

    public void a(int i2, CharSequence charSequence) {
        g gVar;
        if (i2 != 5) {
            if (i2 == 7) {
                gVar = g.LOCKOUT;
            } else if (i2 != 9) {
                gVar = g.OTHER;
            } else {
                gVar = g.PERMANENT_LOCKOUT;
            }
            this.f7553a.d().a(new h.a(gVar, charSequence));
        }
    }
}
