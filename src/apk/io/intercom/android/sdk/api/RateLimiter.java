package io.intercom.android.sdk.api;

import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

class RateLimiter {
    private final AppConfig appConfig;
    private int limitedRequestCount;
    private long periodStartTimestamp;
    private final TimeProvider timeProvider;
    private final Twig twig;

    RateLimiter(AppConfig appConfig2) {
        this(appConfig2, TimeProvider.SYSTEM);
    }

    private boolean hasReachedMaxCount() {
        return this.limitedRequestCount >= this.appConfig.getRateLimitCount();
    }

    private boolean isInsideCurrentTimePeriod() {
        return this.timeProvider.currentTimeMillis() - this.periodStartTimestamp < this.appConfig.getRateLimitPeriodMs();
    }

    /* access modifiers changed from: 0000 */
    public boolean isLimited() {
        return isInsideCurrentTimePeriod() && hasReachedMaxCount();
    }

    /* access modifiers changed from: 0000 */
    public void logError() {
        this.twig.e("Your app is being rate limited because you're performing too many requests per minute", new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void recordRequest() {
        if (!isInsideCurrentTimePeriod()) {
            this.periodStartTimestamp = this.timeProvider.currentTimeMillis();
            this.limitedRequestCount = 0;
        }
        this.limitedRequestCount++;
    }

    RateLimiter(AppConfig appConfig2, TimeProvider timeProvider2) {
        this.twig = LumberMill.getLogger();
        this.appConfig = appConfig2;
        this.timeProvider = timeProvider2;
    }
}
