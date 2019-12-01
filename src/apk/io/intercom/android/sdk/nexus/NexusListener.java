package io.intercom.android.sdk.nexus;

public interface NexusListener {
    void notifyEvent(NexusEvent nexusEvent);

    void onConnect();

    void onConnectFailed();

    void onShutdown();
}
