package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

/* compiled from: FragmentTransitionCompat21 */
class N implements TransitionListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Object f1487a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ArrayList f1488b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Object f1489c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ ArrayList f1490d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ Object f1491e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ ArrayList f1492f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ P f1493g;

    N(P p, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f1493g = p;
        this.f1487a = obj;
        this.f1488b = arrayList;
        this.f1489c = obj2;
        this.f1490d = arrayList2;
        this.f1491e = obj3;
        this.f1492f = arrayList3;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
        Object obj = this.f1487a;
        if (obj != null) {
            this.f1493g.a(obj, this.f1488b, null);
        }
        Object obj2 = this.f1489c;
        if (obj2 != null) {
            this.f1493g.a(obj2, this.f1490d, null);
        }
        Object obj3 = this.f1491e;
        if (obj3 != null) {
            this.f1493g.a(obj3, this.f1492f, null);
        }
    }
}
