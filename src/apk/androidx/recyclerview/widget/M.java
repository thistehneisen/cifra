package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.f;

/* compiled from: RecyclerView */
class M implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecyclerView f1729a;

    M(RecyclerView recyclerView) {
        this.f1729a = recyclerView;
    }

    public void run() {
        f fVar = this.f1729a.W;
        if (fVar != null) {
            fVar.i();
        }
        this.f1729a.xa = false;
    }
}
