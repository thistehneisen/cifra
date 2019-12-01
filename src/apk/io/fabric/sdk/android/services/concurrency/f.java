package io.fabric.sdk.android.services.concurrency;

/* compiled from: AsyncTask */
class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Runnable f9070a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ c f9071b;

    f(c cVar, Runnable runnable) {
        this.f9071b = cVar;
        this.f9070a = runnable;
    }

    public void run() {
        try {
            this.f9070a.run();
        } finally {
            this.f9071b.a();
        }
    }
}
