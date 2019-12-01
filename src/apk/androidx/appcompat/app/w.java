package androidx.appcompat.app;

import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: AppCompatDelegateImpl */
class w implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f505a;

    w(y yVar) {
        this.f505a = yVar;
    }

    public void run() {
        y yVar = this.f505a;
        yVar.r.showAtLocation(yVar.q, 55, 0, 0);
        this.f505a.m();
        if (this.f505a.t()) {
            this.f505a.q.setAlpha(0.0f);
            y yVar2 = this.f505a;
            K a2 = B.a(yVar2.q);
            a2.a(1.0f);
            yVar2.t = a2;
            this.f505a.t.a((L) new v(this));
            return;
        }
        this.f505a.q.setAlpha(1.0f);
        this.f505a.q.setVisibility(0);
    }
}
