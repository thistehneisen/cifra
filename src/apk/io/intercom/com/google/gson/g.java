package io.intercom.com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' access flag removed */
/* compiled from: FieldNamingPolicy */
class g extends h {
    g(String str, int i2) {
        super(str, i2, null);
    }

    public String a(Field field) {
        return h.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
}
