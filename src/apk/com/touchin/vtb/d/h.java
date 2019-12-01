package com.touchin.vtb.d;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FingerprintBottomSheetDialog.kt */
final class h implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f7243a;

    h(a aVar) {
        this.f7243a = aVar;
    }

    public final void onClick(View view) {
        a.a(this.f7243a).setEnabled(false);
        a.a(this.f7243a).postDelayed(this.f7243a.t, 700);
    }
}
