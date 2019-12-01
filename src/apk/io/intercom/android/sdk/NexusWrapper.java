package io.intercom.android.sdk;

import e.a.a.a.a.d;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.conversation.events.AdminIsTypingEvent;
import io.intercom.android.sdk.models.events.realtime.UserContentSeenByAdminEvent;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.nexus.NexusConfig;
import io.intercom.android.sdk.nexus.NexusEvent;
import io.intercom.android.sdk.nexus.NexusEventType;
import io.intercom.android.sdk.nexus.NexusListener;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.okhttp3.OkHttpClient;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class NexusWrapper extends NexusClient implements NexusListener {
    private static final String ADMIN_AVATAR = "adminAvatar";
    private static final String ADMIN_ID = "adminId";
    private static final String ADMIN_NAME = "adminName";
    private static final String CONVERSATION_ID = "conversationId";
    private ScheduledFuture actionFuture;
    private final d bus;
    private final long debouncePeriodMs;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final Store<State> store;
    private final Twig twig;

    /* renamed from: io.intercom.android.sdk.NexusWrapper$3 reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$nexus$NexusEventType = new int[NexusEventType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$nexus$NexusEventType[NexusEventType.AdminIsTyping.ordinal()] = 1;
            $SwitchMap$io$intercom$android$nexus$NexusEventType[NexusEventType.NewComment.ordinal()] = 2;
            $SwitchMap$io$intercom$android$nexus$NexusEventType[NexusEventType.UserContentSeenByAdmin.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$nexus$NexusEventType[NexusEventType.ConversationSeen.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    NexusWrapper(Twig twig2, OkHttpClient okHttpClient, d dVar, Store<State> store2, long j2) {
        super(twig2, okHttpClient);
        this.twig = twig2;
        this.bus = dVar;
        this.store = store2;
        this.debouncePeriodMs = j2;
    }

    private void logKnownEvent(NexusEvent nexusEvent) {
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("Received ");
        sb.append(nexusEvent.getEventType());
        sb.append(" event");
        twig2.internal("Nexus", sb.toString());
    }

    private void removeCallbacks() {
        ScheduledFuture scheduledFuture = this.actionFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void connect(final NexusConfig nexusConfig, final boolean z) {
        if (nexusConfig.getEndpoints().isEmpty()) {
            this.twig.w("No realtime endpoints present so we can't connect", new Object[0]);
            return;
        }
        removeCallbacks();
        this.actionFuture = this.executor.schedule(new Runnable() {
            public void run() {
                NexusWrapper.this.connectNow(nexusConfig, z);
            }
        }, this.debouncePeriodMs, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public void connectNow(NexusConfig nexusConfig, boolean z) {
        if (!isConnected()) {
            super.connect(nexusConfig, z);
            setTopics(Collections.singletonList("*"));
            addEventListener(this);
        }
    }

    public void disconnect() {
        removeCallbacks();
        this.actionFuture = this.executor.schedule(new Runnable() {
            public void run() {
                NexusWrapper.this.disconnectNow();
            }
        }, this.debouncePeriodMs, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public void disconnectNow() {
        removeEventListener(this);
        super.disconnect();
    }

    public void notifyEvent(NexusEvent nexusEvent) {
        String optString = nexusEvent.getEventData().optString(CONVERSATION_ID);
        int i2 = AnonymousClass3.$SwitchMap$io$intercom$android$nexus$NexusEventType[nexusEvent.getEventType().ordinal()];
        if (i2 == 1) {
            logKnownEvent(nexusEvent);
            this.bus.post(new AdminIsTypingEvent(nexusEvent.getEventData().optString(ADMIN_ID), optString, nexusEvent.getEventData().optString(ADMIN_NAME), nexusEvent.getEventData().optString(ADMIN_AVATAR)));
        } else if (i2 == 2) {
            logKnownEvent(nexusEvent);
            this.store.dispatch(Actions.newCommentEventReceived(optString));
        } else if (i2 == 3) {
            logKnownEvent(nexusEvent);
            this.bus.post(new UserContentSeenByAdminEvent(optString));
        } else if (i2 != 4) {
            Twig twig2 = this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected event: ");
            sb.append(nexusEvent.getEventType());
            twig2.internal("Nexus", sb.toString());
        } else {
            logKnownEvent(nexusEvent);
            this.store.dispatch(Actions.conversationMarkedAsRead(optString));
        }
    }

    public void onConnect() {
    }

    public void onConnectFailed() {
    }

    public void onShutdown() {
    }
}
