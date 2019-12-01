package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.b reason: case insensitive filesystem */
final class C0329b extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5123e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5124f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Be f5125g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Cf f5126h;

    C0329b(Cf cf, String str, String str2, Be be) {
        this.f5126h = cf;
        this.f5123e = str;
        this.f5124f = str2;
        this.f5125g = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5126h.p.getConditionalUserProperties(this.f5123e, this.f5124f, this.f5125g);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5125g.c(null);
    }
}
