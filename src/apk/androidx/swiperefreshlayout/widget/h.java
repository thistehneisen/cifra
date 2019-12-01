package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class h extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ int f2107a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f2108b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2109c;

    h(SwipeRefreshLayout swipeRefreshLayout, int i2, int i3) {
        this.f2109c = swipeRefreshLayout;
        this.f2107a = i2;
        this.f2108b = i3;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        d dVar = this.f2109c.D;
        int i2 = this.f2107a;
        dVar.setAlpha((int) (((float) i2) + (((float) (this.f2108b - i2)) * f2)));
    }
}
