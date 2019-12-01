package io.intercom.android.sdk.commons.utilities;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;

public class HtmlCompat {
    public static Spanned fromHtml(String str) {
        if (VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }
}
