package io.intercom.android.sdk.utilities.connectivity;

import android.content.Context;
import android.content.IntentFilter;

public class NetworkConnectivityMonitor implements ConnectivityUpdateListener {
    private boolean didRegister = false;
    private NetworkState lastState = NetworkState.UNKNOWN;
    private ConnectivityEventListener listener;
    private final ConnectivityBroadcastReceiver receiver = new ConnectivityBroadcastReceiver(this);

    public interface ConnectivityEventListener {
        void onDisconnect();

        void onReconnect();
    }

    /* access modifiers changed from: 0000 */
    public ConnectivityEventListener getListener() {
        return this.listener;
    }

    public void onUpdate(NetworkState networkState) {
        NetworkState networkState2 = this.lastState;
        if (networkState != networkState2) {
            ConnectivityEventListener connectivityEventListener = this.listener;
            if (connectivityEventListener != null) {
                if (networkState == NetworkState.NOT_CONNECTED) {
                    connectivityEventListener.onDisconnect();
                } else if (networkState == NetworkState.CONNECTED && networkState2 == NetworkState.NOT_CONNECTED) {
                    connectivityEventListener.onReconnect();
                }
            }
            this.lastState = networkState;
        }
    }

    public void setListener(ConnectivityEventListener connectivityEventListener) {
        this.listener = connectivityEventListener;
    }

    public synchronized void startListening(Context context) {
        if (!this.didRegister) {
            context.registerReceiver(this.receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.didRegister = true;
        }
    }

    public synchronized void stopListening(Context context) {
        if (this.didRegister) {
            context.unregisterReceiver(this.receiver);
            this.didRegister = false;
        }
    }
}
