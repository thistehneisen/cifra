package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.k reason: case insensitive filesystem */
final class C0385k extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Be f5248e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5249f;

    C0385k(Cf cf, Be be) {
        this.f5249f = cf;
        this.f5248e = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5249f.p.getCurrentScreenName(this.f5248e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5248e.c(null);
    }
}
