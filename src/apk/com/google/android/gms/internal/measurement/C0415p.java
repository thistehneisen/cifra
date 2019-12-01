package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.p reason: case insensitive filesystem */
final class C0415p extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ boolean f5315e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5316f;

    C0415p(Cf cf, boolean z) {
        this.f5316f = cf;
        this.f5315e = z;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5316f.p.setDataCollectionEnabled(this.f5315e);
    }
}
