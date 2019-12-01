package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.v reason: case insensitive filesystem */
final class C0450v extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5400e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Bundle f5401f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ b f5402g;

    C0450v(b bVar, Activity activity, Bundle bundle) {
        this.f5402g = bVar;
        this.f5400e = activity;
        this.f5401f = bundle;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivityCreated(b.a(this.f5400e), this.f5401f, this.f4896b);
    }
}
