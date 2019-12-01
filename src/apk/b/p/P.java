package b.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18 */
class P implements Q {

    /* renamed from: a reason: collision with root package name */
    private final ViewGroupOverlay f2846a;

    P(ViewGroup viewGroup) {
        this.f2846a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f2846a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f2846a.remove(drawable);
    }

    public void a(View view) {
        this.f2846a.add(view);
    }

    public void b(View view) {
        this.f2846a.remove(view);
    }
}
