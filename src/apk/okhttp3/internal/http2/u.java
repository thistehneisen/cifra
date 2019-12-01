package okhttp3.internal.http2;

import j.h;
import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver */
class u implements v {
    u() {
    }

    public void a(int i2, a aVar) {
    }

    public boolean a(int i2, h hVar, int i3, boolean z) throws IOException {
        hVar.skip((long) i3);
        return true;
    }

    public boolean onHeaders(int i2, List<b> list, boolean z) {
        return true;
    }

    public boolean onRequest(int i2, List<b> list) {
        return true;
    }
}
