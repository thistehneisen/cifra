package retrofit2;

import j.A;
import j.f;
import j.k;
import java.io.IOException;

/* compiled from: OkHttpCall */
class n extends k {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f11009b;

    n(a aVar, A a2) {
        this.f11009b = aVar;
        super(a2);
    }

    public long b(f fVar, long j2) throws IOException {
        try {
            return super.b(fVar, j2);
        } catch (IOException e2) {
            this.f11009b.f11017b = e2;
            throw e2;
        }
    }
}
