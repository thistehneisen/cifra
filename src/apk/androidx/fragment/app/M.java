package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransitionCompat21 */
class M implements TransitionListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f1484a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ArrayList f1485b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ P f1486c;

    M(P p, View view, ArrayList arrayList) {
        this.f1486c = p;
        this.f1484a = view;
        this.f1485b = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f1484a.setVisibility(8);
        int size = this.f1485b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((View) this.f1485b.get(i2)).setVisibility(0);
        }
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
