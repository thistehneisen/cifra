package androidx.appcompat.widget;

import android.view.View;

/* compiled from: ScrollingTabContainerView */
class X implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f917a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Y f918b;

    X(Y y, View view) {
        this.f918b = y;
        this.f917a = view;
    }

    public void run() {
        this.f918b.smoothScrollTo(this.f917a.getLeft() - ((this.f918b.getWidth() - this.f917a.getWidth()) / 2), 0);
        this.f918b.f920b = null;
    }
}
