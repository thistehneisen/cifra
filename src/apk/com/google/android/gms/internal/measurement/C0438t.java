package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.t reason: case insensitive filesystem */
final class C0438t extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5368e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f5369f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Object f5370g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ boolean f5371h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ Cf f5372i;

    C0438t(Cf cf, String str, String str2, Object obj, boolean z) {
        this.f5372i = cf;
        this.f5368e = str;
        this.f5369f = str2;
        this.f5370g = obj;
        this.f5371h = z;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        this.f5372i.p.setUserProperty(this.f5368e, this.f5369f, b.a(this.f5370g), this.f5371h, this.f4895a);
    }
}
