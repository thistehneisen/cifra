package com.touchin.vtb.views;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: TaxesSmartTabLayout.kt */
final class i implements OnTouchListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaxesSmartTabLayout f7811a;

    i(TaxesSmartTabLayout taxesSmartTabLayout) {
        this.f7811a = taxesSmartTabLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f7811a.q.onTouchEvent(motionEvent);
        return true;
    }
}
