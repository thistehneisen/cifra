package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.C0307b.C0064b;
import com.google.android.gms.common.internal.C0307b.a;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.g reason: case insensitive filesystem */
public abstract class C0312g<T extends IInterface> extends C0307b<T> implements f, C0313h {
    private final C0308c D;
    private final Set<Scope> E;
    private final Account F;

    protected C0312g(Context context, Looper looper, int i2, C0308c cVar, d dVar, e eVar) {
        C0314i a2 = C0314i.a(context);
        com.google.android.gms.common.e a3 = com.google.android.gms.common.e.a();
        q.a(dVar);
        d dVar2 = dVar;
        q.a(eVar);
        this(context, looper, a2, a3, i2, cVar, dVar2, eVar);
    }

    private static a a(d dVar) {
        if (dVar == null) {
            return null;
        }
        return new x(dVar);
    }

    private final Set<Scope> b(Set<Scope> set) {
        a(set);
        for (Scope contains : set) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public int e() {
        return super.e();
    }

    public final Account k() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> q() {
        return this.E;
    }

    private static C0064b a(e eVar) {
        if (eVar == null) {
            return null;
        }
        return new y(eVar);
    }

    protected C0312g(Context context, Looper looper, C0314i iVar, com.google.android.gms.common.e eVar, int i2, C0308c cVar, d dVar, e eVar2) {
        super(context, looper, iVar, eVar, i2, a(dVar), a(eVar2), cVar.e());
        this.D = cVar;
        this.F = cVar.a();
        Set<Scope> c2 = cVar.c();
        b(c2);
        this.E = c2;
    }
}
