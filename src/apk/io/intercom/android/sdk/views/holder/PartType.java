package io.intercom.android.sdk.views.holder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PartType {
    public static final int ADMIN_IS_TYPING = 5;
    public static final int ADMIN_MESSAGE = 1;
    public static final int ALT_USER_MESSAGE = 4;
    public static final int ATTRIBUTE_COLLECTOR = 15;
    public static final int CONVERSATION_RATING = 10;
    public static final int DAY_DIVIDER = 6;
    public static final int EVENT = 12;
    public static final int LINK = 8;
    public static final int LINK_LIST = 13;
    public static final int LINK_REPLY = 9;
    public static final int LOADING_LAYOUT = 7;
    public static final int NOTE_CARD = 3;
    public static final int POST_CARD = 2;
    public static final int QUICK_REPLY = 14;
    public static final int USER_MESSAGE = 0;
}
