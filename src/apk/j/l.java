package j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class l extends C {

    /* renamed from: e reason: collision with root package name */
    private C f10257e;

    public l(C c2) {
        if (c2 != null) {
            this.f10257e = c2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final l a(C c2) {
        if (c2 != null) {
            this.f10257e = c2;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public C b() {
        return this.f10257e.b();
    }

    public long c() {
        return this.f10257e.c();
    }

    public boolean d() {
        return this.f10257e.d();
    }

    public void e() throws IOException {
        this.f10257e.e();
    }

    public final C g() {
        return this.f10257e;
    }

    public C a(long j2, TimeUnit timeUnit) {
        return this.f10257e.a(j2, timeUnit);
    }

    public C a(long j2) {
        return this.f10257e.a(j2);
    }

    public C a() {
        return this.f10257e.a();
    }
}
