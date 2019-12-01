package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import c.b.a.b.b.c.d;
import com.google.android.gms.common.a.a;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.HashMap;

final class E extends C0314i implements Callback {
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final HashMap<a, F> f4666c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final Context f4667d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final Handler f4668e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final a f4669f;

    /* renamed from: g reason: collision with root package name */
    private final long f4670g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final long f4671h;

    E(Context context) {
        this.f4667d = context.getApplicationContext();
        this.f4668e = new d(context.getMainLooper(), this);
        this.f4669f = a.a();
        this.f4670g = 5000;
        this.f4671h = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        q.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4666c) {
            F f2 = (F) this.f4666c.get(aVar);
            if (f2 == null) {
                f2 = new F(this, aVar);
                f2.a(serviceConnection, str);
                f2.a(str);
                this.f4666c.put(aVar, f2);
            } else {
                this.f4668e.removeMessages(0, aVar);
                if (!f2.a(serviceConnection)) {
                    f2.a(serviceConnection, str);
                    int c2 = f2.c();
                    if (c2 == 1) {
                        serviceConnection.onServiceConnected(f2.b(), f2.a());
                    } else if (c2 == 2) {
                        f2.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = f2.d();
        }
        return d2;
    }

    /* access modifiers changed from: protected */
    public final void b(a aVar, ServiceConnection serviceConnection, String str) {
        q.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4666c) {
            F f2 = (F) this.f4666c.get(aVar);
            if (f2 == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (f2.a(serviceConnection)) {
                f2.b(serviceConnection, str);
                if (f2.e()) {
                    this.f4668e.sendMessageDelayed(this.f4668e.obtainMessage(0, aVar), this.f4670g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f4666c) {
                a aVar = (a) message.obj;
                F f2 = (F) this.f4666c.get(aVar);
                if (f2 != null && f2.e()) {
                    if (f2.d()) {
                        f2.b("GmsClientSupervisor");
                    }
                    this.f4666c.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f4666c) {
                a aVar2 = (a) message.obj;
                F f3 = (F) this.f4666c.get(aVar2);
                if (f3 != null && f3.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = f3.b();
                    if (b2 == null) {
                        b2 = aVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(aVar2.b(), AttributeType.UNKNOWN);
                    }
                    f3.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
