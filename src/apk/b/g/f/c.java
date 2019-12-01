package b.g.f;

import android.os.Handler;
import b.g.a.a.h;
import b.g.f.k.a;

/* compiled from: FontsContractCompat */
class c implements a<c> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ h.a f2536a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Handler f2537b;

    c(h.a aVar, Handler handler) {
        this.f2536a = aVar;
        this.f2537b = handler;
    }

    public void a(c cVar) {
        if (cVar == null) {
            this.f2536a.a(1, this.f2537b);
            return;
        }
        int i2 = cVar.f2552b;
        if (i2 == 0) {
            this.f2536a.a(cVar.f2551a, this.f2537b);
        } else {
            this.f2536a.a(i2, this.f2537b);
        }
    }
}
