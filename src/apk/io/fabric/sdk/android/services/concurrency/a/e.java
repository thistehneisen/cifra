package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: RetryState */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final int f9043a;

    /* renamed from: b reason: collision with root package name */
    private final a f9044b;

    /* renamed from: c reason: collision with root package name */
    private final d f9045c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public long a() {
        return this.f9044b.getDelayMillis(this.f9043a);
    }

    public e b() {
        return new e(this.f9044b, this.f9045c);
    }

    public e c() {
        return new e(this.f9043a + 1, this.f9044b, this.f9045c);
    }

    public e(int i2, a aVar, d dVar) {
        this.f9043a = i2;
        this.f9044b = aVar;
        this.f9045c = dVar;
    }
}
