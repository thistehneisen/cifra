package com.bluelinelabs.logansquare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface JsonEnum {

    public enum ValueNamingPolicy {
        VALUE_NAME,
        LOWER_CASE_WITH_UNDERSCORES
    }

    ValueNamingPolicy valueNamingPolicy() default ValueNamingPolicy.VALUE_NAME;
}
