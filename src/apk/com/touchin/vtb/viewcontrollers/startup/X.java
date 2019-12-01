package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.api.UserRegisterResponse;
import com.touchin.vtb.g.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: RegistrationConfirmSmsViewController.kt */
final class X<T> implements v<a<? extends UserRegisterResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RegistrationConfirmSmsViewController f7702a;

    X(RegistrationConfirmSmsViewController registrationConfirmSmsViewController) {
        this.f7702a = registrationConfirmSmsViewController;
    }

    public final void a(a<? extends UserRegisterResponse> aVar) {
        if (aVar instanceof c) {
            this.f7702a.repeatTextView.setText(this.f7702a.getString(R.string.common_registration_code_sent_button_title));
        } else if (aVar instanceof d) {
            h hVar = (h) this.f7702a.getState();
            String b2 = ((UserRegisterResponse) ((d) aVar).a()).b();
            kotlin.e.b.h.a((Object) b2, "event.data.smsOperationId");
            hVar.a(b2);
            ((h) this.f7702a.getState()).a(System.currentTimeMillis());
            this.f7702a.startTimer();
        } else {
            boolean z = aVar instanceof b;
        }
    }
}
