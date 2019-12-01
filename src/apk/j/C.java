package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class C {

    /* renamed from: a reason: collision with root package name */
    public static final C f10230a = new B();

    /* renamed from: b reason: collision with root package name */
    private boolean f10231b;

    /* renamed from: c reason: collision with root package name */
    private long f10232c;

    /* renamed from: d reason: collision with root package name */
    private long f10233d;

    public C a(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.f10233d = timeUnit.toNanos(j2);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public C b() {
        this.f10233d = 0;
        return this;
    }

    public long c() {
        if (this.f10231b) {
            return this.f10232c;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f10231b;
    }

    public void e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f10231b && this.f10232c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long f() {
        return this.f10233d;
    }

    public C a(long j2) {
        this.f10231b = true;
        this.f10232c = j2;
        return this;
    }

    public C a() {
        this.f10231b = false;
        return this;
    }
}
