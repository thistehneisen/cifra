package io.intercom.android.sdk.utilities.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ConnectivityBroadcastReceiver extends BroadcastReceiver {
    private final ConnectivityUpdateListener connectivityUpdateListener;

    interface ConnectivityUpdateListener {
        void onUpdate(NetworkState networkState);
    }

    ConnectivityBroadcastReceiver(ConnectivityUpdateListener connectivityUpdateListener2) {
        this.connectivityUpdateListener = connectivityUpdateListener2;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                this.connectivityUpdateListener.onUpdate(intent.getBooleanExtra("noConnectivity", false) ? NetworkState.NOT_CONNECTED : NetworkState.CONNECTED);
            }
        }
    }
}
