package androidx.appcompat.widget;

import android.view.View;

/* compiled from: ListPopupWindow */
class P implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ S f852a;

    P(S s) {
        this.f852a = s;
    }

    public void run() {
        View e2 = this.f852a.e();
        if (e2 != null && e2.getWindowToken() != null) {
            this.f852a.b();
        }
    }
}
