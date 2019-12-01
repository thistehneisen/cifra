package com.touchin.vtb.utils;

import android.content.Context;
import com.touchin.vtb.R;
import com.touchin.vtb.api.BankType;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: BankTypeUtils.kt */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final a f7607a = new a();

    private a() {
    }

    public final BankType a(Context context, String str) {
        h.b(context, "context");
        h.b(str, "bankName");
        String string = context.getString(R.string.common_registration_choose_bank_sber);
        h.a((Object) string, "context.getString(R.stri…tration_choose_bank_sber)");
        String str2 = "null cannot be cast to non-null type java.lang.String";
        if (string != null) {
            String upperCase = string.toUpperCase();
            String str3 = "(this as java.lang.String).toUpperCase()";
            h.a((Object) upperCase, str3);
            if (h.a((Object) str, (Object) upperCase)) {
                return BankType.SBER;
            }
            String string2 = context.getString(R.string.common_registration_choose_bank_vtb);
            h.a((Object) string2, "context.getString(R.stri…stration_choose_bank_vtb)");
            if (string2 != null) {
                String upperCase2 = string2.toUpperCase();
                h.a((Object) upperCase2, str3);
                if (h.a((Object) str, (Object) upperCase2)) {
                    return BankType.VTB;
                }
                String string3 = context.getString(R.string.common_registration_choose_bank_alpha);
                h.a((Object) string3, "context.getString(R.stri…ration_choose_bank_alpha)");
                if (string3 != null) {
                    String upperCase3 = string3.toUpperCase();
                    h.a((Object) upperCase3, str3);
                    if (h.a((Object) str, (Object) upperCase3)) {
                        return BankType.ALPHA;
                    }
                    String string4 = context.getString(R.string.common_registration_choose_bank_tinkoff);
                    h.a((Object) string4, "context.getString(R.stri…tion_choose_bank_tinkoff)");
                    if (string4 != null) {
                        String upperCase4 = string4.toUpperCase();
                        h.a((Object) upperCase4, str3);
                        if (h.a((Object) str, (Object) upperCase4)) {
                            return BankType.TINKOFF;
                        }
                        String string5 = context.getString(R.string.common_registration_choose_bank_openbank);
                        h.a((Object) string5, "context.getString(R.stri…ion_choose_bank_openbank)");
                        if (string5 != null) {
                            String upperCase5 = string5.toUpperCase();
                            h.a((Object) upperCase5, str3);
                            if (h.a((Object) str, (Object) upperCase5)) {
                                return BankType.OPENBANK;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("No expected bank name: ");
                            sb.append(str);
                            throw new ShouldNotHappenException(sb.toString());
                        }
                        throw new TypeCastException(str2);
                    }
                    throw new TypeCastException(str2);
                }
                throw new TypeCastException(str2);
            }
            throw new TypeCastException(str2);
        }
        throw new TypeCastException(str2);
    }
}
