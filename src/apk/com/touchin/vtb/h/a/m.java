package com.touchin.vtb.h.a;

import androidx.lifecycle.u;
import e.b.k;
import java.util.concurrent.TimeUnit;
import kotlin.e.b.h;
import l.a.c.a.b;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: SuccessViewModel.kt */
public final class m extends s {

    /* renamed from: e reason: collision with root package name */
    public static final a f7495e = new a(null);

    /* renamed from: f reason: collision with root package name */
    private final c<b> f7496f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private e.b.b.b f7497g;

    /* compiled from: SuccessViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public m() {
        super(null, null, 3, null);
    }

    public final c<b> c() {
        return this.f7496f;
    }

    public final void d() {
        e.b.b.b bVar = this.f7497g;
        if (bVar != null) {
            bVar.b();
        }
        e.b.b f2 = k.b(5000, TimeUnit.MILLISECONDS).f();
        h.a((Object) f2, "Observable\n             …        .ignoreElements()");
        this.f7497g = a(f2, (u<b>) this.f7496f);
    }
}
