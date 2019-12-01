package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: FragmentTransition */
class G implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1445a;

    G(ArrayList arrayList) {
        this.f1445a = arrayList;
    }

    public void run() {
        K.a(this.f1445a, 4);
    }
}
