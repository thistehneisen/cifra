package io.intercom.android.sdk.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SystemNotificationManager {
    static final String ACTIONS_CHANNEL = "intercom_actions_channel";
    static final String CHAT_REPLIES_CHANNEL = "intercom_chat_replies_channel";
    static final String NEW_CHATS_CHANNEL = "intercom_new_chats_channel";
    private static final int NOTIFICATION_ID = 9999997;
    private final NotificationManager androidNotificationManager;
    final List<PushPayload> receivedPayloads;
    private final SystemNotificationFactory systemNotificationFactory;
    private final Twig twig;

    public SystemNotificationManager(NotificationManager notificationManager) {
        this(notificationManager, new SystemNotificationFactory());
    }

    @TargetApi(26)
    private void setUpNotificationChannels(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel(CHAT_REPLIES_CHANNEL, context.getString(R.string.intercom_notification_channel_chat_replies_title), 4);
        notificationChannel.setDescription(context.getString(R.string.intercom_notification_channel_chat_replies_description));
        NotificationChannel notificationChannel2 = new NotificationChannel(NEW_CHATS_CHANNEL, context.getString(R.string.intercom_notification_channel_new_chats_title), 4);
        notificationChannel2.setDescription(context.getString(R.string.intercom_notification_channel_new_chats_description));
        NotificationChannel notificationChannel3 = new NotificationChannel(ACTIONS_CHANNEL, context.getString(R.string.intercom_notification_channel_actions_title), 4);
        notificationChannel3.setDescription(context.getString(R.string.intercom_notification_channel_actions_description));
        this.androidNotificationManager.createNotificationChannels(Arrays.asList(new NotificationChannel[]{notificationChannel, notificationChannel2, notificationChannel3}));
    }

    public void clear() {
        if (!this.receivedPayloads.isEmpty()) {
            this.twig.i("Removing Intercom push notifications.", new Object[0]);
        }
        this.androidNotificationManager.cancel(NOTIFICATION_ID);
        this.receivedPayloads.clear();
    }

    /* access modifiers changed from: 0000 */
    public void createNotification(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Notification notification;
        if (!this.receivedPayloads.contains(pushPayload)) {
            this.receivedPayloads.add(pushPayload);
            if (this.receivedPayloads.size() == 1) {
                notification = this.systemNotificationFactory.createSingleNotification(pushPayload, context, appConfig);
            } else {
                notification = this.systemNotificationFactory.createGroupedNotification(this.receivedPayloads, context);
            }
            this.androidNotificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    /* access modifiers changed from: 0000 */
    public void createPushOnlyNotification(PushPayload pushPayload, Context context) {
        Notification createPushOnlyNotification = this.systemNotificationFactory.createPushOnlyNotification(pushPayload, context);
        String pushOnlyConversationId = pushPayload.getPushOnlyConversationId();
        this.androidNotificationManager.notify(pushOnlyConversationId, pushOnlyConversationId.hashCode(), createPushOnlyNotification);
    }

    public void deleteNotificationChannels() {
        if (VERSION.SDK_INT >= 26) {
            this.androidNotificationManager.deleteNotificationChannel(CHAT_REPLIES_CHANNEL);
            this.androidNotificationManager.deleteNotificationChannel(NEW_CHATS_CHANNEL);
            this.androidNotificationManager.deleteNotificationChannel(ACTIONS_CHANNEL);
        }
    }

    public void setUpNotificationChannelsIfSupported(Context context) {
        if (VERSION.SDK_INT >= 26) {
            setUpNotificationChannels(context);
        }
    }

    SystemNotificationManager(NotificationManager notificationManager, SystemNotificationFactory systemNotificationFactory2) {
        this.receivedPayloads = Collections.synchronizedList(new ArrayList());
        this.twig = LumberMill.getLogger();
        this.androidNotificationManager = notificationManager;
        this.systemNotificationFactory = systemNotificationFactory2;
    }
}
