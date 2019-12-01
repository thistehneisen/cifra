package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.e reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0161e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f957a;

    C0161e(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f957a = actionBarOverlayLayout;
    }

    public void run() {
        this.f957a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f957a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.f718e.animate().translationY(0.0f).setListener(this.f957a.y);
    }
}
