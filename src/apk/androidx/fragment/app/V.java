package androidx.fragment.app;

import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;
import androidx.lifecycle.n;

/* compiled from: FragmentViewLifecycleOwner */
class V implements l {

    /* renamed from: a reason: collision with root package name */
    private n f1508a = null;

    V() {
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (this.f1508a == null) {
            this.f1508a = new n(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        return this.f1508a != null;
    }

    public h getLifecycle() {
        a();
        return this.f1508a;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.f1508a.b(aVar);
    }
}
