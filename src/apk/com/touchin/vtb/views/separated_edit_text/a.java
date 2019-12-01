package com.touchin.vtb.views.separated_edit_text;

import android.text.Editable;
import com.touchin.vtb.f.j;
import io.intercom.android.sdk.utilities.SimpleTextWatcher;

/* compiled from: SeparatedEditText.kt */
public final class a extends SimpleTextWatcher {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SeparatedEditText f7845a;

    a(SeparatedEditText separatedEditText) {
        this.f7845a = separatedEditText;
    }

    public void afterTextChanged(Editable editable) {
        String valueOf = String.valueOf(editable);
        UnderlinedDigitView[] a2 = this.f7845a.A;
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            UnderlinedDigitView underlinedDigitView = a2[i2];
            int i4 = i3 + 1;
            if (i3 < valueOf.length()) {
                underlinedDigitView.a(j.UNDERLINE_INVISIBLE, String.valueOf(valueOf.charAt(i3)));
            } else {
                String str = "";
                if (i3 == valueOf.length()) {
                    underlinedDigitView.a(j.UNDERLINE_FOCUSED, str);
                } else {
                    underlinedDigitView.a(j.UNDERLINE_UNFOCUSED, str);
                }
            }
            i2++;
            i3 = i4;
        }
        if (valueOf.length() == 4) {
            this.f7845a.getOnCodeEnteredAction().b();
        }
    }
}
