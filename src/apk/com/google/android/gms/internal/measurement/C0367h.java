package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.h reason: case insensitive filesystem */
final class C0367h extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Be f5205e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5206f;

    C0367h(Cf cf, Be be) {
        this.f5206f = cf;
        this.f5205e = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5206f.p.generateEventId(this.f5205e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5205e.c(null);
    }
}
