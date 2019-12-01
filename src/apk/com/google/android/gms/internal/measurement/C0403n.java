package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.n reason: case insensitive filesystem */
final class C0403n extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5289e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Be f5290f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Cf f5291g;

    C0403n(Cf cf, String str, Be be) {
        this.f5291g = cf;
        this.f5289e = str;
        this.f5290f = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5291g.p.getMaxUserProperties(this.f5289e, this.f5290f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5290f.c(null);
    }
}
