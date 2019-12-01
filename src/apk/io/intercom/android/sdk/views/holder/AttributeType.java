package io.intercom.android.sdk.views.holder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AttributeType {
    public static final String BOOLEAN = "boolean";
    public static final String DATE = "date";
    public static final String EMAIL = "email";
    public static final String FLOAT = "float";
    public static final String LIST = "list";
    public static final String NUMBER = "number";
    public static final String PHONE = "phone";
    public static final String TEXT = "text";
    public static final String UNKNOWN = "unknown";
    public static final String WEBSITE = "company.website";
}
