package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.c.c.a;
import com.bumptech.glide.h.l;

/* compiled from: DefaultConnectivityMonitor */
final class f implements c {

    /* renamed from: a reason: collision with root package name */
    private final Context f3356a;

    /* renamed from: b reason: collision with root package name */
    final a f3357b;

    /* renamed from: c reason: collision with root package name */
    boolean f3358c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3359d;

    /* renamed from: e reason: collision with root package name */
    private final BroadcastReceiver f3360e = new e(this);

    f(Context context, a aVar) {
        this.f3356a = context.getApplicationContext();
        this.f3357b = aVar;
    }

    private void a() {
        if (!this.f3359d) {
            this.f3358c = a(this.f3356a);
            try {
                this.f3356a.registerReceiver(this.f3360e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f3359d = true;
            } catch (SecurityException e2) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to register", e2);
                }
            }
        }
    }

    private void b() {
        if (this.f3359d) {
            this.f3356a.unregisterReceiver(this.f3360e);
            this.f3359d = false;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        a();
    }

    public void onStop() {
        b();
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        l.a(connectivityManager);
        boolean z = true;
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return z;
        } catch (RuntimeException e2) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}
