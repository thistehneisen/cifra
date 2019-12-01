package i;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.g;

/* renamed from: i.o reason: case insensitive filesystem */
/* compiled from: ConnectionPool */
public final class C0726o {

    /* renamed from: a reason: collision with root package name */
    final g f8724a;

    public C0726o() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C0726o(int i2, long j2, TimeUnit timeUnit) {
        this.f8724a = new g(i2, j2, timeUnit);
    }
}
