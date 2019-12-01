package androidx.appcompat.app;

import android.view.View;
import b.g.i.B;
import b.g.i.O;
import b.g.i.r;

/* compiled from: AppCompatDelegateImpl */
class s implements r {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f501a;

    s(y yVar) {
        this.f501a = yVar;
    }

    public O a(View view, O o) {
        int e2 = o.e();
        int i2 = this.f501a.i(e2);
        if (e2 != i2) {
            o = o.a(o.c(), i2, o.d(), o.b());
        }
        return B.b(view, o);
    }
}
