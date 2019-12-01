package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.x;

/* renamed from: androidx.recyclerview.widget.l reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0226l extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ x f1934a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1935b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f1936c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0231q f1937d;

    C0226l(C0231q qVar, x xVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1937d = qVar;
        this.f1934a = xVar;
        this.f1935b = viewPropertyAnimator;
        this.f1936c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1935b.setListener(null);
        this.f1936c.setAlpha(1.0f);
        this.f1937d.l(this.f1934a);
        this.f1937d.r.remove(this.f1934a);
        this.f1937d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f1937d.m(this.f1934a);
    }
}
