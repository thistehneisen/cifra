package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.f reason: case insensitive filesystem */
final class C0355f extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5177e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5178f;

    C0355f(Cf cf, String str) {
        this.f5178f = cf;
        this.f5177e = str;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5178f.p.beginAdUnitExposure(this.f5177e, this.f4896b);
    }
}
