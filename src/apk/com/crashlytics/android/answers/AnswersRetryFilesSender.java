package com.crashlytics.android.answers;

import io.fabric.sdk.android.a.c.g;
import io.fabric.sdk.android.services.concurrency.a.b;
import io.fabric.sdk.android.services.concurrency.a.c;
import io.fabric.sdk.android.services.concurrency.a.e;
import java.io.File;
import java.util.List;

class AnswersRetryFilesSender implements g {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager2) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager2;
    }

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new e(new RandomBackoff(new c(1000, 8), JITTER_PERCENT), new b(5))));
    }

    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.retryManager.canRetry(nanoTime)) {
            if (this.filesSender.send(list)) {
                this.retryManager.reset();
                return true;
            }
            this.retryManager.recordRetry(nanoTime);
        }
        return false;
    }
}
