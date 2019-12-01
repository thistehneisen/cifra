package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.x;

/* renamed from: androidx.recyclerview.widget.n reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0228n extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ x f1942a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f1943b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f1944c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ int f1945d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1946e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ C0231q f1947f;

    C0228n(C0231q qVar, x xVar, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1947f = qVar;
        this.f1942a = xVar;
        this.f1943b = i2;
        this.f1944c = view;
        this.f1945d = i3;
        this.f1946e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f1943b != 0) {
            this.f1944c.setTranslationX(0.0f);
        }
        if (this.f1945d != 0) {
            this.f1944c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f1946e.setListener(null);
        this.f1947f.j(this.f1942a);
        this.f1947f.q.remove(this.f1942a);
        this.f1947f.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f1947f.k(this.f1942a);
    }
}
