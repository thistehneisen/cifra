package io.intercom.android.sdk.identity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface FeatureFlag {
    public static final String DISABLE_ERROR_REPORTING = "disable-error-reporting";
    public static final String DISABLE_FORCE_SHOW_HELP_CENTER_MESSENGER = "disable-force-show-help-center-messenger";
    public static final String IMAGE_ANNOTATION = "image-annotation";
}
