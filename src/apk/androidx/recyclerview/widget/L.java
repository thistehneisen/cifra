package androidx.recyclerview.widget;

/* compiled from: RecyclerView */
class L implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecyclerView f1704a;

    L(RecyclerView recyclerView) {
        this.f1704a = recyclerView;
    }

    public void run() {
        RecyclerView recyclerView = this.f1704a;
        if (recyclerView.E && !recyclerView.isLayoutRequested()) {
            RecyclerView recyclerView2 = this.f1704a;
            if (!recyclerView2.B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.H) {
                recyclerView2.G = true;
            } else {
                recyclerView2.b();
            }
        }
    }
}
