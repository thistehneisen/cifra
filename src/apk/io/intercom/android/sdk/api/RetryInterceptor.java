package io.intercom.android.sdk.api;

import io.intercom.okhttp3.Interceptor;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class RetryInterceptor implements Interceptor {
    private static final int MAX_RETRIES = 3;
    private final Sleeper sleeper;

    public static class Sleeper {
        public void sleep(int i2) {
            try {
                TimeUnit.SECONDS.sleep((long) i2);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public RetryInterceptor(Sleeper sleeper2) {
        this.sleeper = sleeper2;
    }

    static int getRetryTimer(int i2) {
        return (int) Math.pow(2.0d, (double) i2);
    }

    public Response intercept(Chain chain) throws IOException {
        int i2 = 0;
        while (i2 <= 3) {
            try {
                return chain.proceed(chain.request());
            } catch (IOException e2) {
                if (i2 != 3) {
                    i2++;
                    this.sleeper.sleep(getRetryTimer(i2));
                } else {
                    throw e2;
                }
            }
        }
        throw new IOException("request failed due to network errors");
    }
}
