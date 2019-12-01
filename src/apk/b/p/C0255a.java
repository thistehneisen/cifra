package b.p;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import java.util.ArrayList;

/* renamed from: b.p.a reason: case insensitive filesystem */
/* compiled from: AnimatorUtils */
class C0255a {

    /* renamed from: b.p.a$a reason: collision with other inner class name */
    /* compiled from: AnimatorUtils */
    interface C0036a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void b(Animator animator) {
        if (VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i2);
                if (animatorListener instanceof C0036a) {
                    ((C0036a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }

    static void a(Animator animator) {
        if (VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i2);
                if (animatorListener instanceof C0036a) {
                    ((C0036a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }
}
