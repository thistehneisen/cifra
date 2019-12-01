package io.intercom.com.bumptech.glide.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: DefaultConnectivityMonitor */
class e extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f9224a;

    e(f fVar) {
        this.f9224a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        String str = "ConnectivityMonitor";
        f fVar = this.f9224a;
        boolean z = fVar.f9227c;
        try {
            fVar.f9227c = fVar.a(context);
        } catch (SecurityException e2) {
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to determine connectivity status when connectivity changed", e2);
            }
            this.f9224a.f9227c = true;
        }
        if (z != this.f9224a.f9227c) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("connectivity changed, isConnected: ");
                sb.append(this.f9224a.f9227c);
                Log.d(str, sb.toString());
            }
            f fVar2 = this.f9224a;
            fVar2.f9226b.a(fVar2.f9227c);
        }
    }
}
