package io.intercom.android.sdk.utilities;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.widget.TextView;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class FontUtils {
    private static final String ROBOTO_MEDIUM = "fonts/intercom_roboto_medium.ttf";
    private static final Twig twig = LumberMill.getLogger();

    public static void setRobotoLightTypeface(TextView textView) {
        if (VERSION.SDK_INT >= 16) {
            textView.setTypeface(Typeface.create("sans-serif-light", 0));
        } else {
            textView.setTypeface(Typeface.SANS_SERIF);
        }
    }

    public static void setRobotoMediumTypeface(TextView textView) {
        if (VERSION.SDK_INT >= 21) {
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            return;
        }
        try {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), ROBOTO_MEDIUM));
        } catch (RuntimeException unused) {
            twig.e("We could not load our custom font, using the default system font as a backup.", new Object[0]);
        }
    }
}
