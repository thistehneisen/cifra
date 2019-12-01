package io.intercom.com.google.gson;

import java.lang.reflect.Field;

/* 'enum' access flag removed */
/* renamed from: io.intercom.com.google.gson.e reason: case insensitive filesystem */
/* compiled from: FieldNamingPolicy */
class C0787e extends h {
    C0787e(String str, int i2) {
        super(str, i2, null);
    }

    public String a(Field field) {
        return h.a(h.a(field.getName(), " "));
    }
}
