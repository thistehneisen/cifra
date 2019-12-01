package com.bluelinelabs.logansquare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface JsonObject {

    public enum FieldDetectionPolicy {
        ANNOTATIONS_ONLY,
        NONPRIVATE_FIELDS,
        NONPRIVATE_FIELDS_AND_ACCESSORS
    }

    public enum FieldNamingPolicy {
        FIELD_NAME,
        LOWER_CASE_WITH_UNDERSCORES
    }

    FieldDetectionPolicy fieldDetectionPolicy() default FieldDetectionPolicy.ANNOTATIONS_ONLY;

    FieldNamingPolicy fieldNamingPolicy() default FieldNamingPolicy.FIELD_NAME;

    boolean serializeNullCollectionElements() default false;

    boolean serializeNullObjects() default false;
}
