package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.q reason: case insensitive filesystem */
final class C0421q extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Long f5333e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5334f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ String f5335g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Bundle f5336h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ boolean f5337i;

    /* renamed from: j reason: collision with root package name */
    private final /* synthetic */ boolean f5338j;

    /* renamed from: k reason: collision with root package name */
    private final /* synthetic */ Cf f5339k;

    C0421q(Cf cf, Long l2, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        this.f5339k = cf;
        this.f5333e = l2;
        this.f5334f = str;
        this.f5335g = str2;
        this.f5336h = bundle;
        this.f5337i = z;
        this.f5338j = z2;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Long l2 = this.f5333e;
        this.f5339k.p.logEvent(this.f5334f, this.f5335g, this.f5336h, this.f5337i, this.f5338j, l2 == null ? this.f4895a : l2.longValue());
    }
}
