package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: CircularProgressDrawable */
class b implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f2079a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ d f2080b;

    b(d dVar, a aVar) {
        this.f2080b = dVar;
        this.f2079a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f2080b.a(floatValue, this.f2079a);
        this.f2080b.a(floatValue, this.f2079a, false);
        this.f2080b.invalidateSelf();
    }
}
