package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: androidx.recyclerview.widget.p reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0230p extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f1952a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1953b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f1954c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0231q f1955d;

    C0230p(C0231q qVar, a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1955d = qVar;
        this.f1952a = aVar;
        this.f1953b = viewPropertyAnimator;
        this.f1954c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1953b.setListener(null);
        this.f1954c.setAlpha(1.0f);
        this.f1954c.setTranslationX(0.0f);
        this.f1954c.setTranslationY(0.0f);
        this.f1955d.a(this.f1952a.f1962b, false);
        this.f1955d.s.remove(this.f1952a.f1962b);
        this.f1955d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f1955d.b(this.f1952a.f1962b, false);
    }
}
