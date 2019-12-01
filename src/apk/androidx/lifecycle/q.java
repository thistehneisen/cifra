package androidx.lifecycle;

/* compiled from: LiveData */
class q implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ LiveData f1663a;

    q(LiveData liveData) {
        this.f1663a = liveData;
    }

    public void run() {
        Object obj;
        synchronized (this.f1663a.f1615b) {
            obj = this.f1663a.f1619f;
            this.f1663a.f1619f = LiveData.f1614a;
        }
        this.f1663a.b(obj);
    }
}
