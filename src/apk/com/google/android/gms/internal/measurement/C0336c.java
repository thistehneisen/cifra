package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.c reason: case insensitive filesystem */
final class C0336c extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5130e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5131f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Bundle f5132g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Cf f5133h;

    C0336c(Cf cf, String str, String str2, Bundle bundle) {
        this.f5133h = cf;
        this.f5130e = str;
        this.f5131f = str2;
        this.f5132g = bundle;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5133h.p.clearConditionalUserProperty(this.f5130e, this.f5131f, this.f5132g);
    }
}
