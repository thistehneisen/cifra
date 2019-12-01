package io.intercom.android.sdk.nexus;

import io.intercom.android.sdk.twig.Twig;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.OkHttpClient.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NexusClient implements NexusTopicProvider {
    private ScheduledExecutorService backgroundTaskExecutor;
    private final OkHttpClient client;
    private final NexusEventPropagator eventPropagator;
    private ScheduledFuture future;
    private long presenceInterval;
    private final List<NexusSocket> sockets;
    private final List<String> topics;
    private final Twig twig;

    private static class NexusThreadFactory implements ThreadFactory {
        private final ThreadFactory defaultFactory;
        private int threadCount;

        private NexusThreadFactory() {
            this.defaultFactory = Executors.defaultThreadFactory();
            this.threadCount = 0;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.defaultFactory.newThread(runnable);
            this.threadCount++;
            StringBuilder sb = new StringBuilder();
            sb.append("IntercomNexus-");
            sb.append(this.threadCount);
            newThread.setName(sb.toString());
            return newThread;
        }
    }

    public NexusClient(Twig twig2) {
        this(twig2, defaultOkHttpClientBuilder().build());
    }

    public static Builder defaultOkHttpClientBuilder() {
        return new Builder().readTimeout(130, TimeUnit.SECONDS).writeTimeout(130, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void schedulePresence() {
        if (this.presenceInterval > 0) {
            this.future = this.backgroundTaskExecutor.schedule(new Runnable() {
                public void run() {
                    NexusClient.this.fire(NexusEvent.getUserPresenceEvent());
                    NexusClient.this.schedulePresence();
                }
            }, this.presenceInterval, TimeUnit.SECONDS);
        }
    }

    private void subscribeToTopics(List<String> list) {
        if (!list.isEmpty()) {
            fire(NexusEvent.getSubscribeEvent(list));
        }
    }

    private void unSubscribeFromTopics(List<String> list) {
        if (!list.isEmpty()) {
            fire(NexusEvent.getUnsubscribeEvent(list));
        }
    }

    public void addEventListener(NexusListener nexusListener) {
        this.eventPropagator.addListener(nexusListener);
    }

    public synchronized void addTopics(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(this.topics);
        subscribeToTopics(arrayList);
        this.topics.addAll(arrayList);
    }

    public synchronized void clearTopics() {
        unSubscribeFromTopics(this.topics);
        this.topics.clear();
    }

    public void connect(NexusConfig nexusConfig, boolean z) {
        if (nexusConfig.getEndpoints().isEmpty()) {
            this.twig.e("No endpoints present", new Object[0]);
            return;
        }
        if (this.backgroundTaskExecutor == null) {
            this.backgroundTaskExecutor = Executors.newScheduledThreadPool(nexusConfig.getEndpoints().size() + 1, new NexusThreadFactory());
        }
        for (String str : nexusConfig.getEndpoints()) {
            this.twig.i("Adding socket", new Object[0]);
            NexusSocket nexusSocket = new NexusSocket(str, nexusConfig.getConnectionTimeout(), z, this.twig, this.backgroundTaskExecutor, this.client, this.eventPropagator, this);
            nexusSocket.connect();
            this.sockets.add(nexusSocket);
        }
        this.presenceInterval = (long) nexusConfig.getPresenceHeartbeatInterval();
        if (z) {
            schedulePresence();
        }
    }

    public synchronized void disconnect() {
        if (!this.sockets.isEmpty()) {
            for (NexusSocket nexusSocket : this.sockets) {
                this.twig.i("disconnecting socket", new Object[0]);
                nexusSocket.disconnect();
            }
            this.sockets.clear();
            this.twig.i("client disconnected", new Object[0]);
        }
        if (this.future != null) {
            this.future.cancel(true);
        }
    }

    public synchronized void fire(NexusEvent nexusEvent) {
        this.eventPropagator.cacheEvent(nexusEvent);
        String stringEncodedJsonObject = nexusEvent.toStringEncodedJsonObject();
        if (!stringEncodedJsonObject.isEmpty()) {
            for (NexusSocket fire : this.sockets) {
                fire.fire(stringEncodedJsonObject);
            }
        }
    }

    public synchronized List<String> getTopics() {
        return this.topics;
    }

    public synchronized boolean isConnected() {
        for (NexusSocket isConnected : this.sockets) {
            if (isConnected.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void localUpdate(NexusEvent nexusEvent) {
        this.eventPropagator.notifyEvent(nexusEvent);
    }

    public void removeEventListener(NexusListener nexusListener) {
        this.eventPropagator.removeListener(nexusListener);
    }

    public synchronized void removeTopics(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.topics.contains(str)) {
                arrayList.add(str);
            }
        }
        unSubscribeFromTopics(arrayList);
        this.topics.removeAll(arrayList);
    }

    public synchronized void setTopics(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(this.topics);
        ArrayList arrayList2 = new ArrayList(this.topics);
        arrayList2.removeAll(list);
        subscribeToTopics(arrayList);
        unSubscribeFromTopics(arrayList2);
        this.topics.clear();
        this.topics.addAll(list);
    }

    public NexusClient(Twig twig2, OkHttpClient okHttpClient) {
        this(twig2, okHttpClient, new NexusEventPropagator(twig2));
    }

    NexusClient(Twig twig2, OkHttpClient okHttpClient, NexusEventPropagator nexusEventPropagator) {
        this.sockets = new ArrayList();
        this.topics = new ArrayList();
        this.twig = twig2;
        this.eventPropagator = nexusEventPropagator;
        this.client = okHttpClient;
    }
}
