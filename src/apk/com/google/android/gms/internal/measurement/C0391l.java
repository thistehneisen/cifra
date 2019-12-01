package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.l reason: case insensitive filesystem */
final class C0391l extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ int f5256e = 5;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5257f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Object f5258g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Object f5259h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ Object f5260i;

    /* renamed from: j reason: collision with root package name */
    private final /* synthetic */ Cf f5261j;

    C0391l(Cf cf, boolean z, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f5261j = cf;
        this.f5257f = str;
        this.f5258g = obj;
        this.f5259h = null;
        this.f5260i = null;
        super(false);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5261j.p.logHealthData(this.f5256e, this.f5257f, b.a(this.f5258g), b.a(this.f5259h), b.a(this.f5260i));
    }
}
