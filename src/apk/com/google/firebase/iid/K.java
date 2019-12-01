package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.a.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class K implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    private final Context f6769a;

    /* renamed from: b reason: collision with root package name */
    private final Intent f6770b;

    /* renamed from: c reason: collision with root package name */
    private final ScheduledExecutorService f6771c;

    /* renamed from: d reason: collision with root package name */
    private final Queue<G> f6772d;

    /* renamed from: e reason: collision with root package name */
    private I f6773e;

    /* renamed from: f reason: collision with root package name */
    private boolean f6774f;

    public K(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new a("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private final void b() {
        while (!this.f6772d.isEmpty()) {
            ((G) this.f6772d.poll()).a();
        }
    }

    public final synchronized void a(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f6772d.add(new G(intent, pendingResult, this.f6771c));
        a();
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("EnhancedIntentService", sb.toString());
        }
        this.f6774f = false;
        if (!(iBinder instanceof I)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("EnhancedIntentService", sb2.toString());
            b();
            return;
        }
        this.f6773e = (I) iBinder;
        a();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        String str = "EnhancedIntentService";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d(str, sb.toString());
        }
        a();
    }

    private K(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f6772d = new ArrayDeque();
        this.f6774f = false;
        this.f6769a = context.getApplicationContext();
        this.f6770b = new Intent(str).setPackage(this.f6769a.getPackageName());
        this.f6771c = scheduledExecutorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        return;
     */
    private final synchronized void a() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.f6772d.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.f6773e == null || !this.f6773e.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String str = "EnhancedIntentService";
                    boolean z = !this.f6774f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d(str, sb.toString());
                }
                if (!this.f6774f) {
                    this.f6774f = true;
                    try {
                        if (!com.google.android.gms.common.a.a.a().a(this.f6769a, this.f6770b, this, 65)) {
                            Log.e("EnhancedIntentService", "binding to the service failed");
                            this.f6774f = false;
                            b();
                        } else {
                            return;
                        }
                    } catch (SecurityException e2) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e2);
                    }
                }
            } else {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.f6773e.a((G) this.f6772d.poll());
            }
        }
    }
}
