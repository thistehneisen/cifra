package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import b.g.i.B;

/* renamed from: b.p.k reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0265k extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    private boolean f2901a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f2902b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Rect f2903c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ int f2904d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ int f2905e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ int f2906f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ int f2907g;

    /* renamed from: h reason: collision with root package name */
    final /* synthetic */ C0267m f2908h;

    C0265k(C0267m mVar, View view, Rect rect, int i2, int i3, int i4, int i5) {
        this.f2908h = mVar;
        this.f2902b = view;
        this.f2903c = rect;
        this.f2904d = i2;
        this.f2905e = i3;
        this.f2906f = i4;
        this.f2907g = i5;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2901a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f2901a) {
            B.a(this.f2902b, this.f2903c);
            ba.a(this.f2902b, this.f2904d, this.f2905e, this.f2906f, this.f2907g);
        }
    }
}
