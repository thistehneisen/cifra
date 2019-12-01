package io.intercom.android.sdk.utilities;

import android.app.Activity;
import android.os.Bundle;
import com.intercom.composer.ComposerFragment;
import com.intercom.input.gallery.GalleryInput;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.activities.IntercomHelpCenterActivity;

public class ActivityUtils {
    private static final String COMPOSER_INPUT_PACKAGE_NAME = GalleryInput.class.getPackage().getName();
    private static final String COMPOSER_PACKAGE_NAME = ComposerFragment.class.getPackage().getName();
    private static final String[] INTERCOM_PACKAGES = {PACKAGE_NAME, COMPOSER_PACKAGE_NAME, COMPOSER_INPUT_PACKAGE_NAME};
    private static final String PACKAGE_NAME = Intercom.class.getPackage().getName();

    public static boolean isFullScreenHelpCenter(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return false;
        }
        Bundle extras = activity.getIntent().getExtras();
        int i2 = extras != null ? extras.getInt(IntercomHelpCenterActivity.PARCEL_DISPLAY_MODE, 1) : 1;
        if (!(activity instanceof IntercomHelpCenterActivity) || i2 != 1) {
            return false;
        }
        return true;
    }

    public static boolean isHostActivity(Activity activity) {
        return activity != null && isInHostAppPackage(activity.getClass().getName());
    }

    private static boolean isInHostAppPackage(String str) {
        for (String startsWith : INTERCOM_PACKAGES) {
            if (str.startsWith(startsWith)) {
                return false;
            }
        }
        return true;
    }
}
