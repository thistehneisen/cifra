package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: androidx.appcompat.view.menu.e reason: case insensitive filesystem */
/* compiled from: CascadingMenuPopup */
class C0152e implements OnGlobalLayoutListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f609a;

    C0152e(i iVar) {
        this.f609a = iVar;
    }

    public void onGlobalLayout() {
        if (this.f609a.c() && this.f609a.f624j.size() > 0 && !((a) this.f609a.f624j.get(0)).f627a.k()) {
            View view = this.f609a.q;
            if (view == null || !view.isShown()) {
                this.f609a.dismiss();
                return;
            }
            for (a aVar : this.f609a.f624j) {
                aVar.f627a.b();
            }
        }
    }
}
