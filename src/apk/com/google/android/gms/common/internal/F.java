package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class F implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    private final Set<ServiceConnection> f4672a = new HashSet();

    /* renamed from: b reason: collision with root package name */
    private int f4673b = 2;

    /* renamed from: c reason: collision with root package name */
    private boolean f4674c;

    /* renamed from: d reason: collision with root package name */
    private IBinder f4675d;

    /* renamed from: e reason: collision with root package name */
    private final a f4676e;

    /* renamed from: f reason: collision with root package name */
    private ComponentName f4677f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ E f4678g;

    public F(E e2, a aVar) {
        this.f4678g = e2;
        this.f4676e = aVar;
    }

    public final void a(String str) {
        this.f4673b = 3;
        this.f4674c = this.f4678g.f4669f.a(this.f4678g.f4667d, str, this.f4676e.a(this.f4678g.f4667d), this, this.f4676e.c());
        if (this.f4674c) {
            this.f4678g.f4668e.sendMessageDelayed(this.f4678g.f4668e.obtainMessage(1, this.f4676e), this.f4678g.f4671h);
            return;
        }
        this.f4673b = 2;
        try {
            this.f4678g.f4669f.a(this.f4678g.f4667d, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void b(String str) {
        this.f4678g.f4668e.removeMessages(1, this.f4676e);
        this.f4678g.f4669f.a(this.f4678g.f4667d, this);
        this.f4674c = false;
        this.f4673b = 2;
    }

    public final int c() {
        return this.f4673b;
    }

    public final boolean d() {
        return this.f4674c;
    }

    public final boolean e() {
        return this.f4672a.isEmpty();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4678g.f4666c) {
            this.f4678g.f4668e.removeMessages(1, this.f4676e);
            this.f4675d = iBinder;
            this.f4677f = componentName;
            for (ServiceConnection onServiceConnected : this.f4672a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f4673b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f4678g.f4666c) {
            this.f4678g.f4668e.removeMessages(1, this.f4676e);
            this.f4675d = null;
            this.f4677f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f4672a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f4673b = 2;
        }
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        this.f4678g.f4669f;
        this.f4678g.f4667d;
        this.f4672a.remove(serviceConnection);
    }

    public final ComponentName b() {
        return this.f4677f;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        this.f4678g.f4669f;
        this.f4678g.f4667d;
        this.f4676e.a(this.f4678g.f4667d);
        this.f4672a.add(serviceConnection);
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f4672a.contains(serviceConnection);
    }

    public final IBinder a() {
        return this.f4675d;
    }
}
