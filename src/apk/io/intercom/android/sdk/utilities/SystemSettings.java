package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class SystemSettings {
    private static final Twig twig = LumberMill.getLogger();

    public static float getTransitionScale(Context context) {
        if (VERSION.SDK_INT >= 17) {
            try {
                return Global.getFloat(context.getContentResolver(), "transition_animation_scale");
            } catch (Exception e2) {
                Twig twig2 = twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't get animation scale: ");
                sb.append(e2.getMessage());
                twig2.internal(sb.toString());
            }
        }
        return 1.0f;
    }
}
