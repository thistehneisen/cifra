package com.touchin.vtb.views;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import kotlin.e.b.h;

/* compiled from: BankSwipeButton.kt */
public final class b extends SimpleOnGestureListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BankSwipeButton f7779a;

    b(BankSwipeButton bankSwipeButton) {
        this.f7779a = bankSwipeButton;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        h.b(motionEvent, "motionEventStart");
        h.b(motionEvent2, "motionEventEnd");
        this.f7779a.b();
        if (motionEvent2.getX() > motionEvent.getX() && !this.f7779a.f7750j) {
            return false;
        }
        this.f7779a.setDragProgress(motionEvent2.getX());
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        h.b(motionEvent, "motionEvent");
        if (motionEvent.getX() > ((float) this.f7779a.f7745e.getWidth()) + this.f7779a.f7745e.getX() && motionEvent.getX() < ((float) this.f7779a.f7746f.getWidth()) + this.f7779a.f7746f.getX()) {
            kotlin.e.a.b d2 = BankSwipeButton.d(this.f7779a);
            String c2 = BankSwipeButton.c(this.f7779a).c();
            h.a((Object) c2, "connectedBank.connectedBankId");
            d2.a(c2);
        }
        return true;
    }
}
