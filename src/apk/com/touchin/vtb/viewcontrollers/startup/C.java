package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.f.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C<T> implements v<a<? extends Boolean>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessConfirmSmsViewController f7686a;

    C(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.f7686a = getAccessConfirmSmsViewController;
    }

    public final void a(a<Boolean> aVar) {
        if (aVar instanceof c) {
            this.f7686a.progressButton.setState(h.LOADING);
        } else if (aVar instanceof d) {
            this.f7686a.progressButton.setState(h.SUCCESS);
            this.f7686a.editText.setBackground(this.f7686a.getDrawable(R.drawable.common_startup_edit_text_background_success));
            this.f7686a.getView().postDelayed(new A(this), 1000);
        } else if (aVar instanceof b) {
            this.f7686a.editText.setBackground(this.f7686a.getDrawable(R.drawable.common_startup_edit_text_error_selector));
            this.f7686a.progressButton.setState(h.FAIL);
            this.f7686a.getView().postDelayed(new B(this), 1000);
        }
    }
}
