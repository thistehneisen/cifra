package io.intercom.com.google.gson;

import java.lang.reflect.Field;

/* 'enum' access flag removed */
/* renamed from: io.intercom.com.google.gson.c reason: case insensitive filesystem */
/* compiled from: FieldNamingPolicy */
class C0785c extends h {
    C0785c(String str, int i2) {
        super(str, i2, null);
    }

    public String a(Field field) {
        return field.getName();
    }
}
