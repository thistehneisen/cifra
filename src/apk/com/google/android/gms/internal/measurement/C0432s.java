package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.s reason: case insensitive filesystem */
final class C0432s extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Bundle f5363e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5364f;

    C0432s(Cf cf, Bundle bundle) {
        this.f5364f = cf;
        this.f5363e = bundle;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5364f.p.setConditionalUserProperty(this.f5363e, this.f4895a);
    }
}
