package c.c.a;

import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.a;

/* compiled from: ItemTouchHelperExtension */
class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f3191a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f3192b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ k f3193c;

    g(k kVar, c cVar, int i2) {
        this.f3193c = kVar;
        this.f3191a = cVar;
        this.f3192b = i2;
    }

    public void run() {
        if (this.f3193c.t != null && this.f3193c.t.isAttachedToWindow()) {
            c cVar = this.f3191a;
            if (!cVar.f3223l && cVar.f3216e.getAdapterPosition() != -1) {
                f itemAnimator = this.f3193c.t.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.a((a) null)) && !this.f3193c.f()) {
                    this.f3193c.o.b(this.f3191a.f3216e, this.f3192b);
                } else {
                    this.f3193c.t.post(this);
                }
            }
        }
    }
}
