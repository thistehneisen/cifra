package androidx.appcompat.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: AppCompatSpinner */
class D implements OnGlobalLayoutListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f760a;

    D(b bVar) {
        this.f760a = bVar;
    }

    public void onGlobalLayout() {
        b bVar = this.f760a;
        if (!bVar.b(B.this)) {
            this.f760a.dismiss();
            return;
        }
        this.f760a.l();
        D.super.b();
    }
}
