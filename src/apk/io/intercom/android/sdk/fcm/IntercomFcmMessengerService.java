package io.intercom.android.sdk.fcm;

import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.c;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.push.IntercomPushClient;
import io.intercom.android.sdk.twig.Twig;

public class IntercomFcmMessengerService extends FirebaseMessagingService {
    private final IntercomPushClient pushClient = new IntercomPushClient();
    private final Twig twig = LumberMill.getLogger();

    public void onMessageReceived(c cVar) {
        this.pushClient.handlePush(getApplication(), cVar.f());
    }

    public void onNewToken(String str) {
        if (TextUtils.isEmpty(str)) {
            this.twig.e("Intercom push registration failed. Please make sure you have added a google-services.json file", new Object[0]);
            return;
        }
        this.pushClient.sendTokenToIntercom(getApplication(), str);
    }
}
