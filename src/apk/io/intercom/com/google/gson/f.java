package io.intercom.com.google.gson;

import io.fabric.sdk.android.a.c.c;
import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' access flag removed */
/* compiled from: FieldNamingPolicy */
class f extends h {
    f(String str, int i2) {
        super(str, i2, null);
    }

    public String a(Field field) {
        return h.a(field.getName(), c.ROLL_OVER_FILE_NAME_SEPARATOR).toLowerCase(Locale.ENGLISH);
    }
}
