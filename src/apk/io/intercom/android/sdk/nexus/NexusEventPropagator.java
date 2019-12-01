package io.intercom.android.sdk.nexus;

import android.util.LruCache;
import io.intercom.android.sdk.twig.Twig;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class NexusEventPropagator implements NexusListener {
    private final LruCache<String, Boolean> cache = new LruCache<>(100);
    private final List<NexusListener> listeners = new CopyOnWriteArrayList();
    private final Twig twig;

    public NexusEventPropagator(Twig twig2) {
        this.twig = twig2;
    }

    /* access modifiers changed from: 0000 */
    public void addListener(NexusListener nexusListener) {
        this.listeners.add(nexusListener);
    }

    /* access modifiers changed from: 0000 */
    public void cacheEvent(NexusEvent nexusEvent) {
        this.cache.put(nexusEvent.getGuid(), Boolean.valueOf(true));
    }

    public void notifyEvent(NexusEvent nexusEvent) {
        if (nexusEvent.getEventType() != NexusEventType.UNKNOWN) {
            synchronized (this.cache) {
                if (this.cache.get(nexusEvent.getGuid()) == null) {
                    this.cache.put(nexusEvent.getGuid(), Boolean.valueOf(true));
                    Twig twig2 = this.twig;
                    StringBuilder sb = new StringBuilder();
                    sb.append("notifying listeners of event: ");
                    sb.append(nexusEvent.getEventType());
                    twig2.internal(sb.toString());
                    for (NexusListener notifyEvent : this.listeners) {
                        notifyEvent.notifyEvent(nexusEvent);
                    }
                } else {
                    Twig twig3 = this.twig;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("dropping event, already in cache: ");
                    sb2.append(nexusEvent.toStringEncodedJsonObject());
                    twig3.internal(sb2.toString());
                }
            }
        }
    }

    public void onConnect() {
        this.twig.d("notifying listeners that a connection opened", new Object[0]);
        for (NexusListener onConnect : this.listeners) {
            onConnect.onConnect();
        }
    }

    public void onConnectFailed() {
        this.twig.d("notifying listeners that a connection failed to open", new Object[0]);
        for (NexusListener onConnectFailed : this.listeners) {
            onConnectFailed.onConnectFailed();
        }
    }

    public void onShutdown() {
        this.twig.d("notifying listeners that a connection has shutdown", new Object[0]);
        for (NexusListener onShutdown : this.listeners) {
            onShutdown.onShutdown();
        }
    }

    /* access modifiers changed from: 0000 */
    public void removeListener(NexusListener nexusListener) {
        this.listeners.remove(nexusListener);
    }
}
