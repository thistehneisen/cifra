package io.intercom.android.sdk.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.Object;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.user.DeviceData;

class PushHandler {
    private static final String TAG = "PushHandler";
    private final Twig twig = LumberMill.getLogger();

    PushHandler() {
    }

    private boolean hasUserHashIfNeeded(UserIdentity userIdentity, AppConfig appConfig) {
        return appConfig.isReceivedFromServer() && (!appConfig.isIdentityVerificationEnabled() || (appConfig.isIdentityVerificationEnabled() && !TextUtils.isEmpty(userIdentity.getHmac())));
    }

    private void sendNotification(Bundle bundle, SystemNotificationManager systemNotificationManager, boolean z, Context context, MetricTracker metricTracker, AppConfig appConfig) {
        if (bundle.isEmpty()) {
            this.twig.e("The push intent contained no data", new Object[0]);
            return;
        }
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("Notification Data Json :");
        sb.append(bundle.getString(Object.MESSAGE));
        twig2.internal(TAG, sb.toString());
        PushPayload create = PushPayload.create(bundle);
        if (!create.isIntercomPush()) {
            this.twig.i("This is not a Intercom push message", new Object[0]);
        } else if (create.isPushOnly()) {
            metricTracker.receivedPushOnlyNotification(create.getPushOnlyConversationId());
            systemNotificationManager.createPushOnlyNotification(create, context);
        } else if (z) {
            metricTracker.receivedPushNotification(create.getConversationId());
            systemNotificationManager.createNotification(create, context, appConfig);
        } else {
            this.twig.i("Intercom message received but not displayed in notification bar. This happened because the host app was in the foreground.", new Object[0]);
        }
    }

    /* access modifiers changed from: 0000 */
    public void handlePush(Bundle bundle, UserIdentity userIdentity, SystemNotificationManager systemNotificationManager, boolean z, Context context, MetricTracker metricTracker, AppConfig appConfig) {
        if (userIdentity.identityExists()) {
            sendNotification(bundle, systemNotificationManager, z, context, metricTracker, appConfig);
            return;
        }
        systemNotificationManager.clear();
        this.twig.i("Can't create push message as we have no user identity. This can be caused by messages being sent to a logged out user.", new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void sendTokenToIntercom(Context context, String str, Api api, UserIdentity userIdentity, Provider<AppConfig> provider) {
        if (userIdentity.identityExists() && hasUserHashIfNeeded(userIdentity, (AppConfig) provider.get())) {
            api.setDeviceToken(str);
        }
        DeviceData.cacheDeviceToken(context, str);
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldSendDeviceToken(Context context, String str) {
        return !DeviceData.hasCachedDeviceToken(context, str);
    }
}
