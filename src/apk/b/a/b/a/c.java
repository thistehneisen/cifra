package b.a.b.a;

/* compiled from: DrawableContainer */
class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f2157a;

    c(d dVar) {
        this.f2157a = dVar;
    }

    public void run() {
        this.f2157a.a(true);
        this.f2157a.invalidateSelf();
    }
}
