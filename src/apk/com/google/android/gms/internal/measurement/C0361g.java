package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.g reason: case insensitive filesystem */
final class C0361g extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Be f5187e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5188f;

    C0361g(Cf cf, Be be) {
        this.f5188f = cf;
        this.f5187e = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5188f.p.getGmpAppId(this.f5187e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5187e.c(null);
    }
}