package androidx.appcompat.widget;

import b.h.a.a;

/* renamed from: androidx.appcompat.widget.ba reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0156ba implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f951a;

    C0156ba(SearchView searchView) {
        this.f951a = searchView;
    }

    public void run() {
        a aVar = this.f951a.S;
        if (aVar != null && (aVar instanceof la)) {
            aVar.a(null);
        }
    }
}
