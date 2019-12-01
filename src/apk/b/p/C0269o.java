package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import b.g.i.B;
import b.p.E.c;

/* renamed from: b.p.o reason: case insensitive filesystem */
/* compiled from: Fade */
public class C0269o extends ha {

    /* renamed from: b.p.o$a */
    /* compiled from: Fade */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        private final View f2921a;

        /* renamed from: b reason: collision with root package name */
        private boolean f2922b = false;

        a(View view) {
            this.f2921a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ba.a(this.f2921a, 1.0f);
            if (this.f2922b) {
                this.f2921a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (B.y(this.f2921a) && this.f2921a.getLayerType() == 0) {
                this.f2922b = true;
                this.f2921a.setLayerType(2, null);
            }
        }
    }

    public C0269o(int i2) {
        a(i2);
    }

    private Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ba.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ba.f2864d, new float[]{f3});
        ofFloat.addListener(new a(view));
        a((c) new C0268n(this, view));
        return ofFloat;
    }

    public Animator b(ViewGroup viewGroup, View view, M m, M m2) {
        ba.e(view);
        return a(view, a(m, 1.0f), 0.0f);
    }

    public void c(M m) {
        super.c(m);
        m.f2839a.put("android:fade:transitionAlpha", Float.valueOf(ba.c(m.f2840b)));
    }

    public Animator a(ViewGroup viewGroup, View view, M m, M m2) {
        float f2 = 0.0f;
        float a2 = a(m, 0.0f);
        if (a2 != 1.0f) {
            f2 = a2;
        }
        return a(view, f2, 1.0f);
    }

    private static float a(M m, float f2) {
        if (m == null) {
            return f2;
        }
        Float f3 = (Float) m.f2839a.get("android:fade:transitionAlpha");
        return f3 != null ? f3.floatValue() : f2;
    }
}
