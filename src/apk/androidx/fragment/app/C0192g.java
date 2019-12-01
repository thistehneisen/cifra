package androidx.fragment.app;

/* renamed from: androidx.fragment.app.g reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0192g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Fragment f1534a;

    C0192g(Fragment fragment) {
        this.f1534a = fragment;
    }

    public void run() {
        this.f1534a.callStartTransitionListener();
    }
}
