package androidx.fragment.app;

import android.view.View;
import b.g.i.B;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionImpl */
class T implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1505a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Map f1506b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ U f1507c;

    T(U u, ArrayList arrayList, Map map) {
        this.f1507c = u;
        this.f1505a = arrayList;
        this.f1506b = map;
    }

    public void run() {
        int size = this.f1505a.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f1505a.get(i2);
            B.a(view, (String) this.f1506b.get(B.r(view)));
        }
    }
}
