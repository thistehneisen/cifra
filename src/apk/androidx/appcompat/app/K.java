package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import b.g.i.B;
import b.g.i.M;

/* compiled from: WindowDecorActionBar */
class K extends M {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ N f451a;

    K(N n) {
        this.f451a = n;
    }

    public void b(View view) {
        N n = this.f451a;
        if (n.w) {
            View view2 = n.f464k;
            if (view2 != null) {
                view2.setTranslationY(0.0f);
                this.f451a.f461h.setTranslationY(0.0f);
            }
        }
        this.f451a.f461h.setVisibility(8);
        this.f451a.f461h.setTransitioning(false);
        N n2 = this.f451a;
        n2.B = null;
        n2.l();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f451a.f460g;
        if (actionBarOverlayLayout != null) {
            B.H(actionBarOverlayLayout);
        }
    }
}
