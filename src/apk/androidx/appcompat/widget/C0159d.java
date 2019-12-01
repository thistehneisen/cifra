package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: androidx.appcompat.widget.d reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0159d extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f955a;

    C0159d(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f955a = actionBarOverlayLayout;
    }

    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f955a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.f725l = false;
    }

    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f955a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.f725l = false;
    }
}
