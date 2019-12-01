package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.i reason: case insensitive filesystem */
final class C0373i extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Be f5217e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5218f;

    C0373i(Cf cf, Be be) {
        this.f5218f = cf;
        this.f5217e = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5218f.p.getCachedAppInstanceId(this.f5217e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5217e.c(null);
    }
}
