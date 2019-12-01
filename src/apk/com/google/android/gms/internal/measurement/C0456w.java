package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.w reason: case insensitive filesystem */
final class C0456w extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5410e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ b f5411f;

    C0456w(b bVar, Activity activity) {
        this.f5411f = bVar;
        this.f5410e = activity;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityPaused(b.a(this.f5410e), this.f4896b);
    }
}
