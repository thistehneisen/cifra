package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.x reason: case insensitive filesystem */
final class C0462x extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5415e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ b f5416f;

    C0462x(b bVar, Activity activity) {
        this.f5416f = bVar;
        this.f5415e = activity;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityResumed(b.a(this.f5415e), this.f4896b);
    }
}
