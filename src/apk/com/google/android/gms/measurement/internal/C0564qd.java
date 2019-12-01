package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.C0307b.C0064b;
import com.google.android.gms.common.internal.C0307b.a;
import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.qd reason: case insensitive filesystem */
public final class C0564qd implements ServiceConnection, a, C0064b {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public volatile boolean f6070a;

    /* renamed from: b reason: collision with root package name */
    private volatile C0517hb f6071b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Zc f6072c;

    protected C0564qd(Zc zc) {
        this.f6072c = zc;
    }

    public final void a(Intent intent) {
        this.f6072c.j();
        Context a2 = this.f6072c.a();
        com.google.android.gms.common.a.a a3 = com.google.android.gms.common.a.a.a();
        synchronized (this) {
            if (this.f6070a) {
                this.f6072c.e().B().a("Connection attempt already in progress");
                return;
            }
            this.f6072c.e().B().a("Using local app measurement service");
            this.f6070a = true;
            a3.a(a2, intent, this.f6072c.f5790c, 129);
        }
    }

    public final void b() {
        this.f6072c.j();
        Context a2 = this.f6072c.a();
        synchronized (this) {
            if (this.f6070a) {
                this.f6072c.e().B().a("Connection attempt already in progress");
            } else if (this.f6071b == null || (!this.f6071b.a() && !this.f6071b.isConnected())) {
                this.f6071b = new C0517hb(a2, Looper.getMainLooper(), this, this);
                this.f6072c.e().B().a("Connecting to remote service");
                this.f6070a = true;
                this.f6071b.h();
            } else {
                this.f6072c.e().B().a("Already awaiting connection attempt");
            }
        }
    }

    public final void c(int i2) {
        q.a("MeasurementServiceConnection.onConnectionSuspended");
        this.f6072c.e().A().a("Service connection suspended");
        this.f6072c.d().a((Runnable) new C0583ud(this));
    }

    public final void e(Bundle bundle) {
        q.a("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f6072c.d().a((Runnable) new C0568rd(this, (C0487bb) this.f6071b.r()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f6071b = null;
                this.f6070a = false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.f6072c.e().t().a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0062 */
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0487bb bbVar;
        q.a("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f6070a = false;
                this.f6072c.e().t().a("Service connected with null binder");
                return;
            }
            C0487bb bbVar2 = null;
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof C0487bb) {
                        bbVar = (C0487bb) queryLocalInterface;
                    } else {
                        bbVar = new C0497db(iBinder);
                    }
                    bbVar2 = bbVar;
                }
                this.f6072c.e().B().a("Bound to IMeasurementService interface");
            } else {
                this.f6072c.e().t().a("Got binder with a wrong descriptor", interfaceDescriptor);
            }
            if (bbVar2 == null) {
                this.f6070a = false;
                try {
                    com.google.android.gms.common.a.a.a().a(this.f6072c.a(), this.f6072c.f5790c);
                } catch (IllegalArgumentException unused) {
                }
            } else {
                this.f6072c.d().a((Runnable) new C0559pd(this, bbVar2));
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        q.a("MeasurementServiceConnection.onServiceDisconnected");
        this.f6072c.e().A().a("Service disconnected");
        this.f6072c.d().a((Runnable) new C0573sd(this, componentName));
    }

    public final void a() {
        if (this.f6071b != null && (this.f6071b.isConnected() || this.f6071b.a())) {
            this.f6071b.c();
        }
        this.f6071b = null;
    }

    public final void a(b bVar) {
        q.a("MeasurementServiceConnection.onConnectionFailed");
        C0532kb j2 = this.f6072c.f5987a.j();
        if (j2 != null) {
            j2.w().a("Service connection failed", bVar);
        }
        synchronized (this) {
            this.f6070a = false;
            this.f6071b = null;
        }
        this.f6072c.d().a((Runnable) new C0578td(this));
    }
}
