package b.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18 */
class X implements Y {

    /* renamed from: a reason: collision with root package name */
    private final ViewOverlay f2860a;

    X(View view) {
        this.f2860a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f2860a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f2860a.remove(drawable);
    }
}
