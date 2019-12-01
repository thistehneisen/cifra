package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.z reason: case insensitive filesystem */
final class C0474z extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5441e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ b f5442f;

    C0474z(b bVar, Activity activity) {
        this.f5442f = bVar;
        this.f5441e = activity;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityStopped(b.a(this.f5441e), this.f4896b);
    }
}
