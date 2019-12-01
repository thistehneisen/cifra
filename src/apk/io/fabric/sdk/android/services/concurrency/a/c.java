package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: ExponentialBackoff */
public class c implements a {

    /* renamed from: a reason: collision with root package name */
    private final long f9041a;

    /* renamed from: b reason: collision with root package name */
    private final int f9042b;

    public c(long j2, int i2) {
        this.f9041a = j2;
        this.f9042b = i2;
    }

    public long getDelayMillis(int i2) {
        return (long) (((double) this.f9041a) * Math.pow((double) this.f9042b, (double) i2));
    }
}
