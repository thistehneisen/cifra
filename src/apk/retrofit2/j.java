package retrofit2;

/* compiled from: ExecutorCallAdapterFactory */
class j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Throwable f11000a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ k f11001b;

    j(k kVar, Throwable th) {
        this.f11001b = kVar;
        this.f11000a = th;
    }

    public void run() {
        k kVar = this.f11001b;
        kVar.f11002a.a((b<T>) kVar.f11003b, this.f11000a);
    }
}
