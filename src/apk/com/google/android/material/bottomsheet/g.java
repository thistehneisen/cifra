package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;

/* compiled from: BottomSheetDialog */
class g extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ h f6363a;

    g(h hVar) {
        this.f6363a = hVar;
    }

    public void a(View view, float f2) {
    }

    public void a(View view, int i2) {
        if (i2 == 5) {
            this.f6363a.cancel();
        }
    }
}
