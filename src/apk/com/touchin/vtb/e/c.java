package com.touchin.vtb.e;

import android.content.Context;
import com.touchin.vtb.R;
import com.touchin.vtb.api.BankType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e.b.h;

/* compiled from: BankType.kt */
public final class c {
    public static final String a(BankType bankType, Context context) {
        int i2;
        h.b(bankType, "$this$getNameString");
        h.b(context, "context");
        int i3 = b.f7245a[bankType.ordinal()];
        if (i3 == 1) {
            i2 = R.string.common_registration_choose_bank_sber;
        } else if (i3 == 2) {
            i2 = R.string.common_registration_choose_bank_openbank;
        } else if (i3 == 3) {
            i2 = R.string.common_registration_choose_bank_tinkoff;
        } else if (i3 == 4) {
            i2 = R.string.common_registration_choose_bank_vtb;
        } else if (i3 == 5) {
            i2 = R.string.common_registration_choose_bank_alpha;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String string = context.getString(i2);
        h.a((Object) string, "context.getString(when (…tion_choose_bank_alpha\n})");
        return string;
    }

    public static final int b(BankType bankType) {
        h.b(bankType, "$this$getCardNumberColorResId");
        int i2 = b.f7248d[bankType.ordinal()];
        if (i2 == 1) {
            return R.color.common_card_number_dark_color;
        }
        if (i2 == 2 || i2 == 3) {
            return R.color.common_card_number_light_color;
        }
        if (i2 == 4 || i2 == 5) {
            return R.color.common_card_number_dark_color;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int c(BankType bankType) {
        h.b(bankType, "$this$getCardTitleColorResId");
        int i2 = b.f7247c[bankType.ordinal()];
        if (i2 == 1) {
            return R.color.common_card_title_dark_color;
        }
        if (i2 == 2 || i2 == 3) {
            return R.color.common_card_title_light_color;
        }
        if (i2 == 4 || i2 == 5) {
            return R.color.common_card_title_dark_color;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int d(BankType bankType) {
        h.b(bankType, "$this$getIconResId");
        int i2 = b.f7249e[bankType.ordinal()];
        if (i2 == 1) {
            return R.drawable.common_bank_type_vtb_normal;
        }
        if (i2 == 2) {
            return R.drawable.common_bank_type_sber_normal;
        }
        if (i2 == 3) {
            return R.drawable.common_bank_type_alpha_normal;
        }
        if (i2 == 4) {
            return R.drawable.common_bank_type_tinkoff_normal;
        }
        if (i2 == 5) {
            return R.drawable.common_bank_type_openbank_normal;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(BankType bankType, Context context) {
        int i2;
        h.b(bankType, "$this$getUrl");
        h.b(context, "context");
        int i3 = b.f7250f[bankType.ordinal()];
        if (i3 == 1) {
            i2 = R.string.common_global_url_bank_vtb;
        } else if (i3 == 2) {
            i2 = R.string.common_global_url_bank_sber;
        } else if (i3 == 3) {
            i2 = R.string.common_global_url_bank_alfa;
        } else if (i3 == 4) {
            i2 = R.string.common_global_url_bank_tinkoff;
        } else if (i3 == 5) {
            i2 = R.string.common_global_url_bank_open;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String string = context.getString(i2);
        h.a((Object) string, "context.getString(when (…n_global_url_bank_open\n})");
        return string;
    }

    public static final int a(BankType bankType) {
        h.b(bankType, "$this$getCardColorResId");
        int i2 = b.f7246b[bankType.ordinal()];
        if (i2 == 1) {
            return R.color.common_card_sber_color;
        }
        if (i2 == 2) {
            return R.color.common_card_openbank_color;
        }
        if (i2 == 3) {
            return R.color.common_card_tinkoff_color;
        }
        if (i2 == 4) {
            return R.color.common_card_vtb_color;
        }
        if (i2 == 5) {
            return R.color.common_card_alpha_color;
        }
        throw new NoWhenBranchMatchedException();
    }
}
