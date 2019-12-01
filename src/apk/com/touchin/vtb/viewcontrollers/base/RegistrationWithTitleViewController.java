package com.touchin.vtb.viewcontrollers.base;

import android.graphics.Typeface;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: RegistrationWithTitleViewController.kt */
public class RegistrationWithTitleViewController<TActivity extends c, TState extends Parcelable> extends VTBViewController<TActivity, TState> {
    private final TextView registrationTitleContainer = ((TextView) findViewById(R.id.registration_title));

    public RegistrationWithTitleViewController(a aVar, int i2) {
        h.b(aVar, "creationContext");
        super(aVar, i2);
        initSpannableTitle();
    }

    private final void initSpannableTitle() {
        String string = getString(R.string.android_registration_header_title);
        int a2 = s.a((CharSequence) string, getString(R.string.common_global_app_name), 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.common_black)), a2, string.length(), 33);
        spannableString.setSpan(new l.a.d.a.b.a.a(Typeface.create(b.g.a.a.h.a(getActivity(), R.font.montserrat_bold), 1)), a2, string.length(), 33);
        this.registrationTitleContainer.setText(spannableString);
    }

    /* access modifiers changed from: protected */
    public final void setRegistrationToolbarVisible(boolean z) {
        this.registrationTitleContainer.setVisibility(z ? 0 : 8);
    }
}
