package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.e reason: case insensitive filesystem */
final class C0349e extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5164e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5165f;

    C0349e(Cf cf, String str) {
        this.f5165f = cf;
        this.f5164e = str;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5165f.p.endAdUnitExposure(this.f5164e, this.f4896b);
    }
}
