package io.intercom.android.sdk.push;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

class PushBroadcast {
    private final Uri pushData;
    private final String pushOnlyId;
    private final Twig twig;

    PushBroadcast() {
        this.twig = LumberMill.getLogger();
        this.pushData = Uri.EMPTY;
        this.pushOnlyId = "";
    }

    /* access modifiers changed from: 0000 */
    public Uri getPushData() {
        return this.pushData;
    }

    /* access modifiers changed from: 0000 */
    public String getPushOnlyId() {
        return this.pushOnlyId;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasPushOnlyId() {
        return !TextUtils.isEmpty(this.pushOnlyId);
    }

    /* access modifiers changed from: 0000 */
    public boolean isEmpty() {
        return Uri.EMPTY.equals(this.pushData) && this.pushOnlyId.isEmpty();
    }

    PushBroadcast(Intent intent) {
        this.twig = LumberMill.getLogger();
        String stringExtra = intent.getStringExtra(IntercomPushManager.PUSH_ONLY_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            this.twig.internal("The uri had no push only id");
            this.pushOnlyId = "";
        } else {
            this.pushOnlyId = stringExtra;
        }
        Uri data = intent.getData();
        if (data == null) {
            this.twig.internal("The uri had no push data");
            this.pushData = Uri.EMPTY;
            return;
        }
        this.pushData = data;
    }
}
