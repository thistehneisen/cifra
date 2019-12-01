package com.touchin.vtb.d;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;

/* compiled from: FingerprintBottomSheetDialog.kt */
final class e<T> implements v<Integer> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f7240a;

    e(a aVar) {
        this.f7240a = aVar;
    }

    public final void a(Integer num) {
        if (num != null && num.intValue() == 0) {
            this.f7240a.a();
            Fragment targetFragment = this.f7240a.getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(this.f7240a.getTargetRequestCode(), 201, null);
            }
        }
    }
}
