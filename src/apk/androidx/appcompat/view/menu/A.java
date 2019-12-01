package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: StandardMenuPopup */
class A implements OnGlobalLayoutListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C f543a;

    A(C c2) {
        this.f543a = c2;
    }

    public void onGlobalLayout() {
        if (this.f543a.c() && !this.f543a.f565j.k()) {
            View view = this.f543a.o;
            if (view == null || !view.isShown()) {
                this.f543a.dismiss();
            } else {
                this.f543a.f565j.b();
            }
        }
    }
}
