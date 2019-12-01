package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.os.Handler;
import android.os.Looper;

class Debouncer {
    private final Handler handler = new Handler(Looper.getMainLooper());

    Debouncer() {
    }

    /* access modifiers changed from: 0000 */
    public void call(Runnable runnable, long j2) {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(runnable, j2);
    }
}
