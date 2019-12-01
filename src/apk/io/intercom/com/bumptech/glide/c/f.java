package io.intercom.com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import io.intercom.com.bumptech.glide.c.c.a;
import io.intercom.com.bumptech.glide.h.h;

/* compiled from: DefaultConnectivityMonitor */
final class f implements c {

    /* renamed from: a reason: collision with root package name */
    private final Context f9225a;

    /* renamed from: b reason: collision with root package name */
    final a f9226b;

    /* renamed from: c reason: collision with root package name */
    boolean f9227c;

    /* renamed from: d reason: collision with root package name */
    private boolean f9228d;

    /* renamed from: e reason: collision with root package name */
    private final BroadcastReceiver f9229e = new e(this);

    f(Context context, a aVar) {
        this.f9225a = context.getApplicationContext();
        this.f9226b = aVar;
    }

    private void a() {
        if (!this.f9228d) {
            try {
                this.f9227c = a(this.f9225a);
                this.f9225a.registerReceiver(this.f9229e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f9228d = true;
            } catch (SecurityException e2) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to register", e2);
                }
            }
        }
    }

    private void b() {
        if (this.f9228d) {
            this.f9225a.unregisterReceiver(this.f9229e);
            this.f9228d = false;
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
        h.a(connectivityManager);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
