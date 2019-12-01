package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

/* renamed from: com.google.android.gms.internal.measurement.y reason: case insensitive filesystem */
final class C0468y extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Activity f5422e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Be f5423f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ b f5424g;

    C0468y(b bVar, Activity activity, Be be) {
        this.f5424g = bVar;
        this.f5422e = activity;
        this.f5423f = be;
        super(Cf.this);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        Cf.this.p.onActivitySaveInstanceState(b.a(this.f5422e), this.f5423f, this.f4896b);
    }
}
