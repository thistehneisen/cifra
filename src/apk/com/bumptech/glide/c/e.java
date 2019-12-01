package com.bumptech.glide.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: DefaultConnectivityMonitor */
class e extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f3355a;

    e(f fVar) {
        this.f3355a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        f fVar = this.f3355a;
        boolean z = fVar.f3358c;
        fVar.f3358c = fVar.a(context);
        if (z != this.f3355a.f3358c) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("connectivity changed, isConnected: ");
                sb.append(this.f3355a.f3358c);
                Log.d(str, sb.toString());
            }
            f fVar2 = this.f3355a;
            fVar2.f3357b.a(fVar2.f3358c);
        }
    }
}
