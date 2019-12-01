package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.u reason: case insensitive filesystem */
final class C0444u extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5386e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ b f5387f;

    C0444u(b bVar, Activity activity) {
        this.f5387f = bVar;
        this.f5386e = activity;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityStarted(b.a(this.f5386e), this.f4896b);
    }
}
