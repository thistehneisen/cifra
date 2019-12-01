package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.j reason: case insensitive filesystem */
final class C0379j extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Be f5226e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5227f;

    C0379j(Cf cf, Be be) {
        this.f5227f = cf;
        this.f5226e = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5227f.p.getCurrentScreenClass(this.f5226e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5226e.c(null);
    }
}
