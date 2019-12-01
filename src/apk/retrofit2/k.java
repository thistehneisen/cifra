package retrofit2;

/* compiled from: ExecutorCallAdapterFactory */
class k implements d<T> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f11002a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f11003b;

    k(a aVar, d dVar) {
        this.f11003b = aVar;
        this.f11002a = dVar;
    }

    public void a(b<T> bVar, u<T> uVar) {
        this.f11003b.f11005a.execute(new i(this, uVar));
    }

    public void a(b<T> bVar, Throwable th) {
        this.f11003b.f11005a.execute(new j(this, th));
    }
}
