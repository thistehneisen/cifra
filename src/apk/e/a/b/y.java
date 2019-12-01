package e.a.b;

/* compiled from: SegmentPool */
final class y {

    /* renamed from: a reason: collision with root package name */
    static x f7925a;

    /* renamed from: b reason: collision with root package name */
    static long f7926b;

    private y() {
    }

    static x a() {
        synchronized (y.class) {
            if (f7925a == null) {
                return new x();
            }
            x xVar = f7925a;
            f7925a = xVar.f7923f;
            xVar.f7923f = null;
            f7926b -= 8192;
            return xVar;
        }
    }

    static void a(x xVar) {
        if (xVar.f7923f != null || xVar.f7924g != null) {
            throw new IllegalArgumentException();
        } else if (!xVar.f7921d) {
            synchronized (y.class) {
                if (f7926b + 8192 <= 65536) {
                    f7926b += 8192;
                    xVar.f7923f = f7925a;
                    xVar.f7920c = 0;
                    xVar.f7919b = 0;
                    f7925a = xVar;
                }
            }
        }
    }
}
