package com.bluelinelabs.logansquare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface JsonIgnore {

    public enum IgnorePolicy {
        PARSE_AND_SERIALIZE,
        PARSE_ONLY,
        SERIALIZE_ONLY
    }

    IgnorePolicy ignorePolicy() default IgnorePolicy.PARSE_AND_SERIALIZE;
}
