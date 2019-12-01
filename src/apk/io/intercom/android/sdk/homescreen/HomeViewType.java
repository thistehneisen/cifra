package io.intercom.android.sdk.homescreen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface HomeViewType {
    public static final int ERROR_ROW = 4;
    public static final int LOADING_CONVERSATION_CARD = 3;
    public static final int MESSENGER_CARD = 2;
    public static final int NEW_CONVERSATION_CARD = 0;
    public static final int RECENT_CONVERSATION_CARD = 1;
}
