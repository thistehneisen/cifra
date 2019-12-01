package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: FragmentTransitionCompat21 */
class O extends EpicenterCallback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Rect f1494a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ P f1495b;

    O(P p, Rect rect) {
        this.f1495b = p;
        this.f1494a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f1494a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f1494a;
    }
}
