package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import c.b.a.b.b.d.e;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.internal.q;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.h reason: case insensitive filesystem */
final class C0619h implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    int f6813a;

    /* renamed from: b reason: collision with root package name */
    final Messenger f6814b;

    /* renamed from: c reason: collision with root package name */
    C0622k f6815c;

    /* renamed from: d reason: collision with root package name */
    final Queue<C0624m<?>> f6816d;

    /* renamed from: e reason: collision with root package name */
    final SparseArray<C0624m<?>> f6817e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ C0617f f6818f;

    private C0619h(C0617f fVar) {
        this.f6818f = fVar;
        this.f6813a = 0;
        this.f6814b = new Messenger(new e(Looper.getMainLooper(), new C0618g(this)));
        this.f6816d = new ArrayDeque();
        this.f6817e = new SparseArray<>();
    }

    private final void c() {
        this.f6818f.f6809c.execute(new C0620i(this));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return true;
     */
    public final synchronized boolean a(C0624m mVar) {
        int i2 = this.f6813a;
        if (i2 == 0) {
            this.f6816d.add(mVar);
            q.b(this.f6813a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f6813a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!a.a().a(this.f6818f.f6808b, intent, this, 1)) {
                a(0, "Unable to bind to service");
            } else {
                this.f6818f.f6809c.schedule(new C0621j(this), 30, TimeUnit.SECONDS);
            }
        } else if (i2 == 1) {
            this.f6816d.add(mVar);
            return true;
        } else if (i2 == 2) {
            this.f6816d.add(mVar);
            c();
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                int i3 = this.f6813a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void b() {
        if (this.f6813a == 2 && this.f6816d.isEmpty() && this.f6817e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f6813a = 3;
            a.a().a(this.f6818f.f6808b, this);
        }
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            a(0, "Null service connection");
            return;
        }
        try {
            this.f6815c = new C0622k(iBinder);
            this.f6813a = 2;
            c();
        } catch (RemoteException e2) {
            a(0, e2.getMessage());
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        a(2, "Service disconnected");
    }

    /* JADX INFO: used method not loaded: com.google.firebase.iid.m.a(com.google.firebase.iid.zzam):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.google.firebase.iid.m.a(android.os.Bundle):null, types can be incorrect */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r1.a(new com.google.firebase.iid.zzam(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        return true;
     */
    public final boolean a(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            C0624m mVar = (C0624m) this.f6817e.get(i2);
            if (mVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f6817e.remove(i2);
            b();
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a(int i2, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        int i3 = this.f6813a;
        if (i3 == 0) {
            throw new IllegalStateException();
        } else if (i3 == 1 || i3 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f6813a = 4;
            a.a().a(this.f6818f.f6808b, this);
            zzam zzam = new zzam(i2, str);
            for (C0624m a2 : this.f6816d) {
                a2.a(zzam);
            }
            this.f6816d.clear();
            for (int i4 = 0; i4 < this.f6817e.size(); i4++) {
                ((C0624m) this.f6817e.valueAt(i4)).a(zzam);
            }
            this.f6817e.clear();
        } else if (i3 == 3) {
            this.f6813a = 4;
        } else if (i3 != 4) {
            int i5 = this.f6813a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i5);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a() {
        if (this.f6813a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a(int i2) {
        C0624m mVar = (C0624m) this.f6817e.get(i2);
        if (mVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f6817e.remove(i2);
            mVar.a(new zzam(3, "Timed out waiting for response"));
            b();
        }
    }
}
