package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.b.a.b.c.a;
import c.b.a.b.c.a.d;
import c.b.a.b.c.a.k;
import c.b.a.b.c.b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.C0059a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.C0308c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.util.Set;

public final class v extends d implements com.google.android.gms.common.api.d, e {

    /* renamed from: a reason: collision with root package name */
    private static C0059a<? extends c.b.a.b.c.e, a> f4626a = b.f3085c;

    /* renamed from: b reason: collision with root package name */
    private final Context f4627b;

    /* renamed from: c reason: collision with root package name */
    private final Handler f4628c;

    /* renamed from: d reason: collision with root package name */
    private final C0059a<? extends c.b.a.b.c.e, a> f4629d;

    /* renamed from: e reason: collision with root package name */
    private Set<Scope> f4630e;

    /* renamed from: f reason: collision with root package name */
    private C0308c f4631f;

    /* renamed from: g reason: collision with root package name */
    private c.b.a.b.c.e f4632g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public y f4633h;

    public v(Context context, Handler handler, C0308c cVar) {
        this(context, handler, cVar, f4626a);
    }

    /* access modifiers changed from: private */
    public final void b(k kVar) {
        com.google.android.gms.common.b f2 = kVar.f();
        if (f2.j()) {
            s g2 = kVar.g();
            com.google.android.gms.common.b g3 = g2.g();
            if (!g3.j()) {
                String valueOf = String.valueOf(g3);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f4633h.b(g3);
                this.f4632g.c();
                return;
            }
            this.f4633h.a(g2.f(), this.f4630e);
        } else {
            this.f4633h.b(f2);
        }
        this.f4632g.c();
    }

    public final void a(y yVar) {
        c.b.a.b.c.e eVar = this.f4632g;
        if (eVar != null) {
            eVar.c();
        }
        this.f4631f.a(Integer.valueOf(System.identityHashCode(this)));
        C0059a<? extends c.b.a.b.c.e, a> aVar = this.f4629d;
        Context context = this.f4627b;
        Looper looper = this.f4628c.getLooper();
        C0308c cVar = this.f4631f;
        this.f4632g = (c.b.a.b.c.e) aVar.a(context, looper, cVar, cVar.h(), this, this);
        this.f4633h = yVar;
        Set<Scope> set = this.f4630e;
        if (set == null || set.isEmpty()) {
            this.f4628c.post(new w(this));
        } else {
            this.f4632g.connect();
        }
    }

    public final void c(int i2) {
        this.f4632g.c();
    }

    public final void e(Bundle bundle) {
        this.f4632g.a(this);
    }

    public final void h() {
        c.b.a.b.c.e eVar = this.f4632g;
        if (eVar != null) {
            eVar.c();
        }
    }

    public v(Context context, Handler handler, C0308c cVar, C0059a<? extends c.b.a.b.c.e, a> aVar) {
        this.f4627b = context;
        this.f4628c = handler;
        q.a(cVar, (Object) "ClientSettings must not be null");
        this.f4631f = cVar;
        this.f4630e = cVar.g();
        this.f4629d = aVar;
    }

    public final void a(com.google.android.gms.common.b bVar) {
        this.f4633h.b(bVar);
    }

    public final void a(k kVar) {
        this.f4628c.post(new x(this, kVar));
    }
}
