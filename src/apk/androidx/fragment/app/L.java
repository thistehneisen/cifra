package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: FragmentTransitionCompat21 */
class L extends EpicenterCallback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Rect f1482a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ P f1483b;

    L(P p, Rect rect) {
        this.f1483b = p;
        this.f1482a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f1482a;
    }
}
