package retrofit2;

import java.io.IOException;

/* compiled from: ExecutorCallAdapterFactory */
class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ u f10998a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ k f10999b;

    i(k kVar, u uVar) {
        this.f10999b = kVar;
        this.f10998a = uVar;
    }

    public void run() {
        if (this.f10999b.f11003b.f11006b.isCanceled()) {
            k kVar = this.f10999b;
            kVar.f11002a.a((b<T>) kVar.f11003b, (Throwable) new IOException("Canceled"));
            return;
        }
        k kVar2 = this.f10999b;
        kVar2.f11002a.a((b<T>) kVar2.f11003b, this.f10998a);
    }
}
