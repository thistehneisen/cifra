package io.intercom.android.sdk;

import android.content.Context;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.PreferenceKeys;

public class IntercomPushManager {
    public static final String HOST_APP_INTENT = "host_app_intent";
    public static final String INTERCOM_PUSH_KEY = "intercom_push_key";
    public static final String INTERCOM_PUSH_PATH = "intercom_push_notification_path";
    public static final String MULTIPLE_NOTIFICATIONS = "multiple_notifications";
    private static final String PREFS_SENDER_ID = "intercom_sender_id";
    public static final String PUSH_ONLY_ID = "push_only_convo_id";
    private static final Twig TWIG = LumberMill.getLogger();

    public enum IntercomPushIntegrationType {
        FCM,
        NONE
    }

    public static void cacheSenderId(Context context, String str) {
        context.getSharedPreferences(PreferenceKeys.INTERCOM_PREFS, 0).edit().putString(PREFS_SENDER_ID, str).apply();
    }

    private static boolean fcmModuleInstalled() {
        return getFcmServiceClass() != null;
    }

    private static Class getFcmServiceClass() {
        try {
            return Class.forName("io.intercom.android.sdk.fcm.IntercomFcmMessengerService");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static IntercomPushIntegrationType getInstalledModuleType() {
        IntercomPushIntegrationType intercomPushIntegrationType = IntercomPushIntegrationType.NONE;
        if (!fcmModuleInstalled()) {
            return intercomPushIntegrationType;
        }
        TWIG.internal("FCM is installed");
        return IntercomPushIntegrationType.FCM;
    }
}
