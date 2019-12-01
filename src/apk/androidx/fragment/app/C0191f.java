package androidx.fragment.app;

/* renamed from: androidx.fragment.app.f reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0191f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Fragment f1533a;

    C0191f(Fragment fragment) {
        this.f1533a = fragment;
    }

    public void run() {
        this.f1533a.startPostponedEnterTransition();
    }
}
