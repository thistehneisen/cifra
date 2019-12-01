package b.p;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene */
public class A {

    /* renamed from: a reason: collision with root package name */
    private ViewGroup f2804a;

    /* renamed from: b reason: collision with root package name */
    private Runnable f2805b;

    public void a() {
        if (a(this.f2804a) == this) {
            Runnable runnable = this.f2805b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    static void a(View view, A a2) {
        view.setTag(C0278y.transition_current_scene, a2);
    }

    static A a(View view) {
        return (A) view.getTag(C0278y.transition_current_scene);
    }
}
