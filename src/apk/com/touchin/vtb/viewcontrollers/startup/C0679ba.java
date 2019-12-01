package com.touchin.vtb.viewcontrollers.startup;

import android.view.animation.AnimationUtils;
import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.UserRegisterConfirmResponse;
import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.views.separated_edit_text.SeparatedEditText;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.ba reason: case insensitive filesystem */
/* compiled from: RegistrationConfirmSmsViewController.kt */
final class C0679ba<T> implements v<a<? extends UserRegisterConfirmResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RegistrationConfirmSmsViewController f7708a;

    C0679ba(RegistrationConfirmSmsViewController registrationConfirmSmsViewController) {
        this.f7708a = registrationConfirmSmsViewController;
    }

    public final void a(a<? extends UserRegisterConfirmResponse> aVar) {
        if (aVar instanceof c) {
            this.f7708a.repeatTextView.setVisibility(4);
            this.f7708a.loader.setVisibility(0);
            this.f7708a.separatedEditText.getInvisibleEditText().setEnabled(false);
        } else if (aVar instanceof d) {
            this.f7708a.separatedEditText.b();
            this.f7708a.getView().postDelayed(new Y(this), 1000);
        } else if (aVar instanceof b) {
            SeparatedEditText access$getSeparatedEditText$p = this.f7708a.separatedEditText;
            access$getSeparatedEditText$p.startAnimation(AnimationUtils.loadAnimation(this.f7708a.getActivity(), R.anim.common_shaking_animation));
            access$getSeparatedEditText$p.a();
            access$getSeparatedEditText$p.getInvisibleEditText().setEnabled(true);
            this.f7708a.loader.setVisibility(4);
            this.f7708a.repeatTextView.setVisibility(0);
            Throwable b2 = ((b) aVar).b();
            ApiError apiError = null;
            if (!(b2 instanceof ServerException)) {
                b2 = null;
            }
            ServerException serverException = (ServerException) b2;
            if (serverException != null) {
                apiError = serverException.a();
            }
            if (apiError == ApiError.CONFIRMATION_CODE_RENEWED) {
                com.touchin.vtb.utils.b.a access$getTimer$p = this.f7708a.timer;
                if (access$getTimer$p != null) {
                    access$getTimer$p.a(true);
                }
                this.f7708a.getView().postDelayed(new Z(this), 1000);
                this.f7708a.repeatTextView.setText(this.f7708a.getString(R.string.common_registration_code_renewed_button_title));
                this.f7708a.repeatTextView.setTextColor(this.f7708a.getColor(R.color.common_black));
                if (this.f7708a.timer == null) {
                    this.f7708a.getView().postDelayed(new C0677aa(this), 1000);
                }
            }
        }
    }
}
