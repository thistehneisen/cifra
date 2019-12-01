package io.intercom.android.sdk.utilities;

import android.content.Context;
import io.intercom.android.sdk.R;

public class GroupConversationTextFormatter {
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=java.lang.CharSequence, for r2v0, types: [java.lang.CharSequence, java.lang.String] */
    public static CharSequence groupConversationTitle(CharSequence charSequence, int i2, Context context) {
        String str = "name";
        if (i2 == 1) {
            return Phrase.from(context, R.string.intercom_name_and_1_other).put(str, charSequence).format();
        }
        if (i2 > 1) {
            charSequence = Phrase.from(context, R.string.intercom_name_and_x_others).put(str, charSequence).put("count", i2).format();
        }
        return charSequence;
    }
}
