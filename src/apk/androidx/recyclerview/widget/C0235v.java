package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.n;

/* renamed from: androidx.recyclerview.widget.v reason: case insensitive filesystem */
/* compiled from: FastScroller */
class C0235v extends n {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0236w f1997a;

    C0235v(C0236w wVar) {
        this.f1997a = wVar;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        this.f1997a.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
