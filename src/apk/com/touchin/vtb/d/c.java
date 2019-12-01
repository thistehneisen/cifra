package com.touchin.vtb.d;

import androidx.fragment.app.Fragment;

/* compiled from: FingerprintBottomSheetDialog.kt */
final class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f7239a;

    c(a aVar) {
        this.f7239a = aVar;
    }

    public final void run() {
        this.f7239a.a();
        Fragment targetFragment = this.f7239a.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(this.f7239a.getTargetRequestCode(), 0, null);
        }
    }
}
