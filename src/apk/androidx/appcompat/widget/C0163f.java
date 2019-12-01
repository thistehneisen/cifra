package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.f reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0163f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f959a;

    C0163f(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f959a = actionBarOverlayLayout;
    }

    public void run() {
        this.f959a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f959a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.f718e.animate().translationY((float) (-this.f959a.f718e.getHeight())).setListener(this.f959a.y);
    }
}
