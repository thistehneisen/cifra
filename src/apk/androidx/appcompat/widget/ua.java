package androidx.appcompat.widget;

/* compiled from: Toolbar */
class ua implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Toolbar f1050a;

    ua(Toolbar toolbar) {
        this.f1050a = toolbar;
    }

    public void run() {
        this.f1050a.showOverflowMenu();
    }
}
