package io.intercom.android.sdk.utilities;

import io.intercom.android.sdk.store.Store.Subscription;

public class StoreUtils {
    public static void safeUnsubscribe(Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
