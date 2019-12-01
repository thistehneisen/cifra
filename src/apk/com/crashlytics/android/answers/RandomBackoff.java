package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.a.a;
import java.util.Random;

class RandomBackoff implements a {
    final a backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(a aVar, double d2) {
        this(aVar, d2, new Random());
    }

    public long getDelayMillis(int i2) {
        return (long) (randomJitter() * ((double) this.backoff.getDelayMillis(i2)));
    }

    /* access modifiers changed from: 0000 */
    public double randomJitter() {
        double d2 = this.jitterPercent;
        double d3 = 1.0d - d2;
        return d3 + (((d2 + 1.0d) - d3) * this.random.nextDouble());
    }

    public RandomBackoff(a aVar, double d2, Random random2) {
        if (d2 < 0.0d || d2 > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random2 != null) {
            this.backoff = aVar;
            this.jitterPercent = d2;
            this.random = random2;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }
}
