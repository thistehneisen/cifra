package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

/* compiled from: StandardMenuPopup */
class B implements OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C f556a;

    B(C c2) {
        this.f556a = c2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f556a.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f556a.q = view.getViewTreeObserver();
            }
            C c2 = this.f556a;
            c2.q.removeGlobalOnLayoutListener(c2.f566k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
