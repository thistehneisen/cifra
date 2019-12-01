package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: TooltipCompat */
public class Aa {
    public static void a(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            Da.a(view, charSequence);
        }
    }
}
