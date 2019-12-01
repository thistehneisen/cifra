package com.touchin.vtb.d;

import androidx.fragment.app.Fragment;

/* compiled from: FingerprintBottomSheetDialog.kt */
final class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f7241a;

    f(a aVar) {
        this.f7241a = aVar;
    }

    public final void run() {
        this.f7241a.a();
        Fragment targetFragment = this.f7241a.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(this.f7241a.getTargetRequestCode(), -1, null);
        }
    }
}
