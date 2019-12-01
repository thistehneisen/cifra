package b.a.d;

import android.view.View;
import b.g.i.L;
import b.g.i.M;

/* compiled from: ViewPropertyAnimatorCompatSet */
class h extends M {

    /* renamed from: a reason: collision with root package name */
    private boolean f2227a = false;

    /* renamed from: b reason: collision with root package name */
    private int f2228b = 0;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ i f2229c;

    h(i iVar) {
        this.f2229c = iVar;
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f2228b = 0;
        this.f2227a = false;
        this.f2229c.b();
    }

    public void b(View view) {
        int i2 = this.f2228b + 1;
        this.f2228b = i2;
        if (i2 == this.f2229c.f2230a.size()) {
            L l2 = this.f2229c.f2233d;
            if (l2 != null) {
                l2.b(null);
            }
            a();
        }
    }

    public void c(View view) {
        if (!this.f2227a) {
            this.f2227a = true;
            L l2 = this.f2229c.f2233d;
            if (l2 != null) {
                l2.c(null);
            }
        }
    }
}
