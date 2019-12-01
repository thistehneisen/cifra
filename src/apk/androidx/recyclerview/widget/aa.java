package androidx.recyclerview.widget;

/* compiled from: StaggeredGridLayoutManager */
class aa implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f1881a;

    aa(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f1881a = staggeredGridLayoutManager;
    }

    public void run() {
        this.f1881a.F();
    }
}
