package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.m reason: case insensitive filesystem */
final class C0397m extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5272e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5273f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ boolean f5274g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Be f5275h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ Cf f5276i;

    C0397m(Cf cf, String str, String str2, boolean z, Be be) {
        this.f5276i = cf;
        this.f5272e = str;
        this.f5273f = str2;
        this.f5274g = z;
        this.f5275h = be;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5276i.p.getUserProperties(this.f5272e, this.f5273f, this.f5274g, this.f5275h);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5275h.c(null);
    }
}
