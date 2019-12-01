package com.touchin.vtb.views.pincode;

import com.touchin.vtb.f.g;

/* compiled from: View.kt */
public final class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ PinView f7841a;

    public c(PinView pinView) {
        this.f7841a = pinView;
    }

    public final void run() {
        if (this.f7841a.getDigitView().getVisibility() == 0) {
            PinView.a(this.f7841a, g.DOT_VISIBLE, null, 2, null);
        }
    }
}
