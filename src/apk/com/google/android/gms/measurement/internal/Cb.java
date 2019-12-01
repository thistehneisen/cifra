package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.C0369hb;
import com.google.android.gms.internal.measurement.Gb;

public final class Cb implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final String f5522a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0606zb f5523b;

    Cb(C0606zb zbVar, String str) {
        this.f5523b = zbVar;
        this.f5522a = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f5523b.f6177a.e().w().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            Gb a2 = C0369hb.a(iBinder);
            if (a2 == null) {
                this.f5523b.f6177a.e().w().a("Install Referrer Service implementation was not found");
                return;
            }
            this.f5523b.f6177a.e().z().a("Install Referrer Service connected");
            this.f5523b.f6177a.d().a((Runnable) new Bb(this, a2, this));
        } catch (Exception e2) {
            this.f5523b.f6177a.e().w().a("Exception occurred while calling Install Referrer API", e2);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5523b.f6177a.e().z().a("Install Referrer Service disconnected");
    }
}
