package io.intercom.android.sdk.push;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.twig.Twig;

public class IntercomPushBroadcastReceiver extends BroadcastReceiver {
    static final String INTERCOM_PUSH_DISMISSED = "io.intercom.android.sdk.INTERCOM_PUSH_DISMISSED";
    static final String INTERCOM_PUSH_OPENED = "io.intercom.android.sdk.INTERCOM_PUSH_OPENED";
    private static final Twig TWIG = LumberMill.getLogger();
    private final PushReceiverDelegate pushReceiverDelegate = new PushReceiverDelegate();

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r2.equals(INTERCOM_PUSH_DISMISSED) == false) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    public void onReceive(Context context, Intent intent) {
        Injector.initIfCachedCredentials((Application) context.getApplicationContext());
        char c2 = 0;
        if (Injector.isNotInitialised()) {
            TWIG.w("Push not handled because Intercom is not initialised", new Object[0]);
            return;
        }
        Injector injector = Injector.get();
        UserIdentity userIdentity = injector.getUserIdentity();
        MetricTracker metricTracker = injector.getMetricTracker();
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -1466442296) {
            if (hashCode == 233030346) {
            }
        } else if (action.equals(INTERCOM_PUSH_OPENED)) {
            c2 = 2;
            if (c2 == 0) {
                this.pushReceiverDelegate.handlePushTap(context, intent, injector.getApi(), userIdentity, metricTracker);
            } else {
                this.pushReceiverDelegate.trackDismiss(intent, userIdentity, metricTracker);
            }
        }
        c2 = 65535;
        if (c2 == 0) {
        }
    }
}
