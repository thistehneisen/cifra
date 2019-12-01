package androidx.fragment.app;

import android.view.View;
import b.g.i.B;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionImpl */
class S implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1502a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Map f1503b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ U f1504c;

    S(U u, ArrayList arrayList, Map map) {
        this.f1504c = u;
        this.f1502a = arrayList;
        this.f1503b = map;
    }

    public void run() {
        int size = this.f1502a.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f1502a.get(i2);
            String r = B.r(view);
            if (r != null) {
                B.a(view, U.a(this.f1503b, r));
            }
        }
    }
}
