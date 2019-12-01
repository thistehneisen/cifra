package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0299b.a;
import com.google.android.gms.common.d;
import com.google.android.gms.tasks.h;

public final class C extends B<Boolean> {

    /* renamed from: c reason: collision with root package name */
    private final C0303f<?> f4554c;

    public C(C0303f<?> fVar, h<Boolean> hVar) {
        super(4, hVar);
        this.f4554c = fVar;
    }

    public final /* bridge */ /* synthetic */ void a(i iVar, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    public final d[] b(a<?> aVar) {
        t tVar = (t) aVar.i().get(this.f4554c);
        if (tVar == null) {
            return null;
        }
        return tVar.f4624a.b();
    }

    public final boolean c(a<?> aVar) {
        t tVar = (t) aVar.i().get(this.f4554c);
        return tVar != null && tVar.f4624a.c();
    }

    public final void d(a<?> aVar) throws RemoteException {
        t tVar = (t) aVar.i().remove(this.f4554c);
        if (tVar != null) {
            tVar.f4625b.a(aVar.f(), this.f4540b);
            tVar.f4624a.a();
            return;
        }
        this.f4540b.b(Boolean.valueOf(false));
    }

    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }
}
