package io.intercom.android.sdk.nexus;

import e.a.b.j;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Request.Builder;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.WebSocket;
import io.intercom.okhttp3.WebSocketListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class NexusSocket {
    private static final WebSocket CLOSED_SOCKET = new WebSocket() {
        public void cancel() {
        }

        public boolean close(int i2, String str) {
            return false;
        }

        public long queueSize() {
            return 0;
        }

        public Request request() {
            throw new NullPointerException("ClosedSocket has no request");
        }

        public boolean send(j jVar) {
            return false;
        }

        public boolean send(String str) {
            return false;
        }
    };
    private static final String HEADER = "?X-Nexus-Version=android.5.2.0";
    private static final int MAX_RECONNECT_TIME_SECONDS = 900;
    private static final int N_TIMEOUT_DISCONNECT = 4001;
    private static final int OK_CLIENT_DISCONNECT = 4000;
    private final OkHttpClient client;
    private final long connectionTimeoutSeconds;
    private long lastReconnectAt = 0;
    /* access modifiers changed from: private */
    public final NexusListener listener;
    private int reconnectAttempts = 0;
    /* access modifiers changed from: private */
    public ScheduledFuture reconnectFuture;
    /* access modifiers changed from: private */
    public final boolean shouldSendPresence;
    /* access modifiers changed from: private */
    public WebSocket socket = CLOSED_SOCKET;
    private final ScheduledExecutorService timeoutExecutor;
    private ScheduledFuture timeoutFuture;
    private final Runnable timeoutRunnable = new Runnable() {
        public void run() {
            NexusSocket.this.timedOut();
        }
    };
    /* access modifiers changed from: private */
    public final NexusTopicProvider topicProvider;
    /* access modifiers changed from: private */
    public final Twig twig;
    private final String url;
    private final WebSocketListener webSocketListener = new WebSocketListener() {
        private void parseJsonString(String str) {
            if (!str.isEmpty()) {
                String str2 = " ";
                if (!str.equals(str2) && !str.endsWith("|")) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("eventName");
                        if (!optString.isEmpty()) {
                            if (!optString.equals("ACK")) {
                                Twig access$200 = NexusSocket.this.twig;
                                StringBuilder sb = new StringBuilder();
                                sb.append("onMessage TEXT: ");
                                sb.append(str);
                                access$200.internal(sb.toString());
                                NexusSocket.this.listener.notifyEvent(new NexusEvent(jSONObject));
                                return;
                            }
                        }
                        Twig access$2002 = NexusSocket.this.twig;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onMessage ACK: ");
                        sb2.append(str);
                        access$2002.internal(sb2.toString());
                    } catch (JSONException e2) {
                        Twig access$2003 = NexusSocket.this.twig;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onMessage: json parse exception for message: '");
                        sb3.append(str);
                        sb3.append(str2);
                        sb3.append(e2);
                        access$2003.internal(sb3.toString());
                    }
                }
            }
        }

        public void onClosed(WebSocket webSocket, int i2, String str) {
            if (i2 != NexusSocket.OK_CLIENT_DISCONNECT) {
                NexusSocket.this.scheduleReconnect();
            } else {
                NexusSocket.this.shutdown();
            }
            Twig access$200 = NexusSocket.this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("onClose code: ");
            sb.append(i2);
            sb.append(" reason: ");
            sb.append(str);
            access$200.internal(sb.toString());
        }

        public void onClosing(WebSocket webSocket, int i2, String str) {
            Twig access$200 = NexusSocket.this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Server requested close:  ");
            sb.append(i2);
            sb.append(" - '");
            sb.append(str);
            sb.append("'");
            access$200.internal(sb.toString());
            webSocket.close(i2, str);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (NexusSocket.shouldReconnectFromFailure(response)) {
                NexusSocket.this.scheduleReconnect();
            } else {
                NexusSocket.this.shutdown();
            }
            Twig access$200 = NexusSocket.this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("onFailure: ");
            sb.append(th.getMessage());
            access$200.internal(sb.toString());
            NexusSocket.this.listener.onConnectFailed();
        }

        public void onMessage(WebSocket webSocket, String str) {
            NexusSocket.this.resetTimeout();
            parseJsonString(str);
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Twig access$200 = NexusSocket.this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("onOpen: ");
            sb.append(response.message());
            access$200.internal(sb.toString());
            NexusSocket.this.socket = webSocket;
            NexusSocket.this.resetTimeout();
            List topics = NexusSocket.this.topicProvider.getTopics();
            if (!topics.isEmpty()) {
                NexusSocket.this.fire(NexusEvent.getSubscribeEvent(topics).toStringEncodedJsonObject());
            }
            if (NexusSocket.this.shouldSendPresence) {
                NexusSocket.this.fire(NexusEvent.getUserPresenceEvent().toStringEncodedJsonObject());
            }
            NexusSocket.this.listener.onConnect();
        }

        public void onMessage(WebSocket webSocket, j jVar) {
            Twig access$200 = NexusSocket.this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Received bytes message ");
            sb.append(jVar);
            sb.append(", resetting timeout");
            access$200.internal(sb.toString());
            NexusSocket.this.resetTimeout();
        }
    };

    NexusSocket(String str, int i2, boolean z, Twig twig2, ScheduledExecutorService scheduledExecutorService, OkHttpClient okHttpClient, NexusListener nexusListener, NexusTopicProvider nexusTopicProvider) {
        this.url = str;
        this.connectionTimeoutSeconds = (long) i2;
        this.shouldSendPresence = z;
        this.twig = twig2;
        this.listener = nexusListener;
        this.topicProvider = nexusTopicProvider;
        this.client = okHttpClient;
        this.timeoutExecutor = scheduledExecutorService;
    }

    static long calculateReconnectTimerInSeconds(int i2) {
        int min = (int) Math.min(Math.pow(2.0d, (double) i2), 900.0d);
        return (long) (min + new Random().nextInt(min + 1));
    }

    private void modifyReconnectAttempts() {
        if (System.currentTimeMillis() - this.lastReconnectAt > TimeUnit.SECONDS.toMillis(900) * 2) {
            this.twig.d("resetting reconnection attempts", new Object[0]);
            this.reconnectAttempts = 1;
        } else {
            this.twig.d("incrementing reconnection attempts", new Object[0]);
            this.reconnectAttempts++;
        }
        this.lastReconnectAt = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void resetTimeout() {
        ScheduledFuture scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.timeoutFuture = this.timeoutExecutor.schedule(this.timeoutRunnable, this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void scheduleReconnect() {
        if (this.reconnectFuture == null) {
            modifyReconnectAttempts();
            long calculateReconnectTimerInSeconds = calculateReconnectTimerInSeconds(this.reconnectAttempts);
            Twig twig2 = this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling reconnect in: ");
            sb.append(calculateReconnectTimerInSeconds);
            sb.append(" for attempt: ");
            sb.append(this.reconnectAttempts);
            twig2.internal(sb.toString());
            this.reconnectFuture = this.timeoutExecutor.schedule(new Runnable() {
                public void run() {
                    NexusSocket.this.connect();
                    NexusSocket.this.reconnectFuture = null;
                }
            }, calculateReconnectTimerInSeconds, TimeUnit.SECONDS);
        }
    }

    static boolean shouldReconnectFromFailure(Response response) {
        if (response == null) {
            return true;
        }
        int code = response.code();
        return code >= 500 && code <= 599;
    }

    /* access modifiers changed from: private */
    public void shutdown() {
        this.socket = CLOSED_SOCKET;
        ScheduledFuture scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.listener.onShutdown();
    }

    /* access modifiers changed from: private */
    public void timedOut() {
        if (this.socket == CLOSED_SOCKET) {
            scheduleReconnect();
        } else {
            disconnect(N_TIMEOUT_DISCONNECT, "Socket timed out");
        }
        this.listener.onConnectFailed();
    }

    /* access modifiers changed from: 0000 */
    public void connect() {
        this.twig.d("connecting to a socket...", new Object[0]);
        Builder builder = new Builder();
        StringBuilder sb = new StringBuilder();
        sb.append(this.url);
        sb.append(HEADER);
        this.client.newWebSocket(builder.url(sb.toString()).build(), this.webSocketListener);
        this.timeoutFuture = this.timeoutExecutor.schedule(this.timeoutRunnable, this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: 0000 */
    public void disconnect() {
        disconnect(OK_CLIENT_DISCONNECT, "Disconnect called by client");
    }

    /* access modifiers changed from: 0000 */
    public void fire(String str) {
        if (!str.isEmpty()) {
            try {
                Twig twig2 = this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("firing: ");
                sb.append(str);
                twig2.internal(sb.toString());
                this.socket.send(str);
            } catch (IllegalStateException e2) {
                Twig twig3 = this.twig;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error when firing '");
                sb2.append(str);
                sb2.append("': ");
                sb2.append(e2);
                twig3.internal(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isConnected() {
        return this.socket != CLOSED_SOCKET;
    }

    private void disconnect(int i2, String str) {
        if (!this.socket.close(i2, str)) {
            this.twig.internal("Could not close socket while disconnecting, it may be already closed");
        }
    }
}
