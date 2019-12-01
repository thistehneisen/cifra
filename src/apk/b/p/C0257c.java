package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: b.p.c reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0257c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewGroup f2866a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f2867b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f2868c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ float f2869d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ C0267m f2870e;

    C0257c(C0267m mVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
        this.f2870e = mVar;
        this.f2866a = viewGroup;
        this.f2867b = bitmapDrawable;
        this.f2868c = view;
        this.f2869d = f2;
    }

    public void onAnimationEnd(Animator animator) {
        ba.b(this.f2866a).b(this.f2867b);
        ba.a(this.f2868c, this.f2869d);
    }
}
