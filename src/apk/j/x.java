package j;

/* compiled from: SegmentPool */
final class x {

    /* renamed from: a reason: collision with root package name */
    static w f10289a;

    /* renamed from: b reason: collision with root package name */
    static long f10290b;

    private x() {
    }

    static w a() {
        synchronized (x.class) {
            if (f10289a == null) {
                return new w();
            }
            w wVar = f10289a;
            f10289a = wVar.f10287f;
            wVar.f10287f = null;
            f10290b -= 8192;
            return wVar;
        }
    }

    static void a(w wVar) {
        if (wVar.f10287f != null || wVar.f10288g != null) {
            throw new IllegalArgumentException();
        } else if (!wVar.f10285d) {
            synchronized (x.class) {
                if (f10290b + 8192 <= 65536) {
                    f10290b += 8192;
                    wVar.f10287f = f10289a;
                    wVar.f10284c = 0;
                    wVar.f10283b = 0;
                    f10289a = wVar;
                }
            }
        }
    }
}
