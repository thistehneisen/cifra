package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout.a;

/* compiled from: AppCompatDelegateImpl */
class u implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f503a;

    u(y yVar) {
        this.f503a = yVar;
    }

    public void a() {
    }

    public void onDetachedFromWindow() {
        this.f503a.l();
    }
}
