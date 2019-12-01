package com.intercom.input.gallery;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PermissionStatus {
    public static final int DENIED_PERMANENTLY = 2;
    public static final int DENIED_TEMPORARILY = 1;
    public static final int GRANTED = 0;
    public static final int NEVER_ASKED = 3;
}
