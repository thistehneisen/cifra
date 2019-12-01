package com.google.android.material.bottomsheet;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BottomSheetDialog */
class d implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ h f6360a;

    d(h hVar) {
        this.f6360a = hVar;
    }

    public void onClick(View view) {
        h hVar = this.f6360a;
        if (hVar.f6365d && hVar.isShowing() && this.f6360a.b()) {
            this.f6360a.cancel();
        }
    }
}
