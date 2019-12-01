package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.d reason: case insensitive filesystem */
final class C0343d extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5150e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5151f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ String f5152g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Cf f5153h;

    C0343d(Cf cf, Activity activity, String str, String str2) {
        this.f5153h = cf;
        this.f5150e = activity;
        this.f5151f = str;
        this.f5152g = str2;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5153h.p.setCurrentScreen(b.a(this.f5150e), this.f5151f, this.f5152g, this.f4895a);
    }
}
