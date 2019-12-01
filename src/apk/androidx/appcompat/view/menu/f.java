package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

/* compiled from: CascadingMenuPopup */
class f implements OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f610a;

    f(i iVar) {
        this.f610a = iVar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f610a.z;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f610a.z = view.getViewTreeObserver();
            }
            i iVar = this.f610a;
            iVar.z.removeGlobalOnLayoutListener(iVar.f625k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
