package androidx.appcompat.app;

import android.view.View;
import b.g.i.N;

/* compiled from: WindowDecorActionBar */
class M implements N {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ N f453a;

    M(N n) {
        this.f453a = n;
    }

    public void a(View view) {
        ((View) this.f453a.f461h.getParent()).invalidate();
    }
}
