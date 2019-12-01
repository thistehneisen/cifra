package io.intercom.com.google.gson.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JsonAdapter */
public @interface b {
    boolean nullSafe() default true;

    Class<?> value();
}
