package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.n;

/* compiled from: SnapHelper */
class Y extends n {

    /* renamed from: a reason: collision with root package name */
    boolean f1864a = false;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Z f1865b;

    Y(Z z) {
        this.f1865b = z;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        if (i2 == 0 && this.f1864a) {
            this.f1864a = false;
            this.f1865b.a();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        if (i2 != 0 || i3 != 0) {
            this.f1864a = true;
        }
    }
}
