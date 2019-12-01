package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.x;

/* renamed from: androidx.recyclerview.widget.m reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0227m extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ x f1938a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f1939b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1940c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0231q f1941d;

    C0227m(C0231q qVar, x xVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1941d = qVar;
        this.f1938a = xVar;
        this.f1939b = view;
        this.f1940c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1939b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1940c.setListener(null);
        this.f1941d.h(this.f1938a);
        this.f1941d.p.remove(this.f1938a);
        this.f1941d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f1941d.i(this.f1938a);
    }
}
