package io.intercom.android.sdk.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.IntentUtils;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.List;

class PushReceiverDelegate {
    private static final String CONSUMED_BY_INTERCOM = "consumed_by_intercom";
    private final Twig twig = LumberMill.getLogger();

    PushReceiverDelegate() {
    }

    private PushBroadcast createPushFromIntent(Intent intent) {
        PushBroadcast pushBroadcast = new PushBroadcast();
        if (intent == null) {
            this.twig.internal("Host app intent was null.");
            return pushBroadcast;
        }
        if (notLaunchedFromHistory(intent) && notConsumedByIntercom(intent) && isIntercomIntent(intent.getExtras())) {
            pushBroadcast = new PushBroadcast(intent);
            intent.putExtra(CONSUMED_BY_INTERCOM, true);
        }
        return pushBroadcast;
    }

    private String extractNotificationId(Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return "";
        }
        String str = (String) pathSegments.get(1);
        String str2 = IntercomPushManager.MULTIPLE_NOTIFICATIONS;
        if (str.equals(str2)) {
            return str2;
        }
        return str.substring(str.lastIndexOf(61) + 1);
    }

    private Intent getLaunchActivityIntent(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                return launchIntentForPackage;
            }
            throw new NameNotFoundException();
        } catch (NameNotFoundException unused) {
            return new Intent();
        }
    }

    private void handlePushMessage(Context context, Api api, Uri uri, String str, MetricTracker metricTracker) {
        Intent intent;
        api.markConversationAsRead(str);
        if (Uri.EMPTY.equals(uri)) {
            this.twig.i("There was no URI in the push message. Defaulting to launch activity", new Object[0]);
            intent = getLaunchActivityIntent(context);
        } else {
            intent = new Intent("android.intent.action.VIEW", uri);
        }
        intent.addFlags(268435456);
        metricTracker.openedPushOnlyNotification(str);
        IntentUtils.safelyOpenIntent(context, intent);
    }

    private boolean isIntercomIntent(Bundle bundle) {
        return bundle != null && bundle.containsKey(IntercomPushManager.INTERCOM_PUSH_KEY);
    }

    private boolean notConsumedByIntercom(Intent intent) {
        return !intent.getBooleanExtra(CONSUMED_BY_INTERCOM, false);
    }

    private boolean notLaunchedFromHistory(Intent intent) {
        return (intent.getFlags() & 1048576) == 0;
    }

    private void openHostAppIntent(Context context, Intent intent, String str) {
        context.getSharedPreferences(PreferenceKeys.INTERCOM_PUSH_PREFS, 0).edit().putString(IntercomPushManager.INTERCOM_PUSH_PATH, str).apply();
        IntentUtils.safelyOpenIntent(context, intent);
    }

    /* access modifiers changed from: 0000 */
    public void handlePushTap(Context context, Intent intent, Api api, UserIdentity userIdentity, MetricTracker metricTracker) {
        if (userIdentity.identityExists()) {
            Intent intent2 = (Intent) intent.getParcelableExtra(IntercomPushManager.HOST_APP_INTENT);
            if (intent2 != null) {
                PushBroadcast createPushFromIntent = createPushFromIntent(intent2);
                if (createPushFromIntent.isEmpty()) {
                    this.twig.internal("Could not open push. No Uri and conversation id found.");
                } else {
                    Uri pushData = createPushFromIntent.getPushData();
                    String pushOnlyId = createPushFromIntent.getPushOnlyId();
                    if (createPushFromIntent.hasPushOnlyId()) {
                        handlePushMessage(context, api, pushData, pushOnlyId, metricTracker);
                    } else {
                        openHostAppIntent(context, intent2, extractNotificationId(pushData));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void trackDismiss(Intent intent, UserIdentity userIdentity, MetricTracker metricTracker) {
        String str;
        if (userIdentity.identityExists()) {
            Intent intent2 = (Intent) intent.getParcelableExtra(IntercomPushManager.HOST_APP_INTENT);
            if (intent2 != null) {
                PushBroadcast pushBroadcast = new PushBroadcast(intent2);
                if (pushBroadcast.isEmpty()) {
                    this.twig.internal("Could not track push dismiss. No Uri found");
                } else {
                    boolean hasPushOnlyId = pushBroadcast.hasPushOnlyId();
                    if (hasPushOnlyId) {
                        str = pushBroadcast.getPushOnlyId();
                    } else {
                        str = extractNotificationId(pushBroadcast.getPushData());
                    }
                    metricTracker.dismissedPushNotification(str, hasPushOnlyId);
                }
            }
        }
    }
}
