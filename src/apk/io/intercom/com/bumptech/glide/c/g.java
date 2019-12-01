package io.intercom.com.bumptech.glide.c;

import android.content.Context;
import android.util.Log;
import io.intercom.com.bumptech.glide.c.c.a;

/* compiled from: DefaultConnectivityMonitorFactory */
public class g implements d {
    public c a(Context context, a aVar) {
        boolean z = b.g.a.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        String str = "ConnectivityMonitor";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new f(context, aVar) : new k();
    }
}
