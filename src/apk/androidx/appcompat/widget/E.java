package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: AppCompatSpinner */
class E implements OnDismissListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ OnGlobalLayoutListener f772a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ b f773b;

    E(b bVar, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f773b = bVar;
        this.f772a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = B.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f772a);
        }
    }
}
