package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

final class A extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f4837e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ b f4838f;

    A(b bVar, Activity activity) {
        this.f4838f = bVar;
        this.f4837e = activity;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityDestroyed(b.a(this.f4837e), this.f4896b);
    }
}
