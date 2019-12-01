package io.intercom.android.sdk.conversation.composer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ComposerInputIndentifier {
    public static final String GALLERY = "gallery_input";
    public static final String GIF = "gif_input";
    public static final String TEXT = "text_input";
}
