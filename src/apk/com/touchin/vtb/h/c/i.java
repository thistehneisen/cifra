package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.f.a.c;
import e.b.b.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.c.c.l;
import l.a.c.c.s;

/* compiled from: FingerprintViewModel.kt */
public final class i extends s {

    /* renamed from: e reason: collision with root package name */
    public static final a f7548e = new a(null);

    /* renamed from: f reason: collision with root package name */
    private final u<Integer> f7549f;

    /* renamed from: g reason: collision with root package name */
    private final u<h> f7550g = new u<>();

    /* renamed from: h reason: collision with root package name */
    private final c f7551h;

    /* compiled from: FingerprintViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public i(c cVar) {
        h.b(cVar, "fingerprintInteractor");
        super(null, null, 3, null);
        this.f7551h = cVar;
        u<Integer> uVar = new u<>();
        uVar.b(Integer.valueOf(5));
        this.f7549f = uVar;
    }

    public final b a(boolean z, kotlin.e.a.a<m> aVar) {
        h.b(aVar, "onComplete");
        return l.a.c.c.l.a.a((l) this, this.f7551h.a(z), (kotlin.e.a.a) aVar, (kotlin.e.a.b) null, 2, (Object) null);
    }

    public final u<Integer> c() {
        return this.f7549f;
    }

    public final u<h> d() {
        return this.f7550g;
    }

    public final boolean e() {
        return this.f7551h.b();
    }

    public final boolean f() {
        return this.f7551h.c();
    }

    public final void g() {
        this.f7551h.a((b.g.c.a.b.a) new k(this));
    }

    public static /* synthetic */ b a(i iVar, boolean z, kotlin.e.a.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = j.f7552a;
        }
        return iVar.a(z, aVar);
    }
}
