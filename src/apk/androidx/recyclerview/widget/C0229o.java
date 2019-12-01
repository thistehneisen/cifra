package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: androidx.recyclerview.widget.o reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0229o extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f1948a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1949b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f1950c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0231q f1951d;

    C0229o(C0231q qVar, a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1951d = qVar;
        this.f1948a = aVar;
        this.f1949b = viewPropertyAnimator;
        this.f1950c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1949b.setListener(null);
        this.f1950c.setAlpha(1.0f);
        this.f1950c.setTranslationX(0.0f);
        this.f1950c.setTranslationY(0.0f);
        this.f1951d.a(this.f1948a.f1961a, true);
        this.f1951d.s.remove(this.f1948a.f1961a);
        this.f1951d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f1951d.b(this.f1948a.f1961a, true);
    }
}
