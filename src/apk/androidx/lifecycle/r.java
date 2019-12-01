package androidx.lifecycle;

/* compiled from: LiveDataReactiveStreams */
class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Throwable f1664a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0013a f1665b;

    r(C0013a aVar, Throwable th) {
        this.f1665b = aVar;
        this.f1664a = th;
    }

    public void run() {
        throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", this.f1664a);
    }
}
