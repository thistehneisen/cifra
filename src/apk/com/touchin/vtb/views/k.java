package com.touchin.vtb.views;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;

/* compiled from: TaxesSmartTabLayout.kt */
public final class k extends Scroller {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewPager f7813a;

    k(ViewPager viewPager, Context context, Interpolator interpolator) {
        this.f7813a = viewPager;
        super(context, interpolator);
    }

    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, 200);
    }

    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, 200);
    }
}
