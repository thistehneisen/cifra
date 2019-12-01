package i.a.b;

import i.D;
import i.O;
import j.h;

/* compiled from: RealResponseBody */
public final class i extends O {

    /* renamed from: a reason: collision with root package name */
    private final String f8594a;

    /* renamed from: b reason: collision with root package name */
    private final long f8595b;

    /* renamed from: c reason: collision with root package name */
    private final h f8596c;

    public i(String str, long j2, h hVar) {
        this.f8594a = str;
        this.f8595b = j2;
        this.f8596c = hVar;
    }

    public long b() {
        return this.f8595b;
    }

    public D c() {
        String str = this.f8594a;
        if (str != null) {
            return D.b(str);
        }
        return null;
    }

    public h d() {
        return this.f8596c;
    }
}
