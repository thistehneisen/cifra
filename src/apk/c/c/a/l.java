package c.c.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ItemTouchHelperExtension */
class l implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f3224a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ c f3225b;

    l(c cVar, k kVar) {
        this.f3225b = cVar;
        this.f3224a = kVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3225b.a(valueAnimator.getAnimatedFraction());
    }
}
