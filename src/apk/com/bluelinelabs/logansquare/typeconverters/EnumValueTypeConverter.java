package com.bluelinelabs.logansquare.typeconverters;

import java.lang.Enum;

public class EnumValueTypeConverter<T extends Enum<T>> extends StringBasedTypeConverter<T> {
    private Class<T> mClass;

    public EnumValueTypeConverter(Class<T> cls) {
        this.mClass = cls;
    }

    public String convertString(String str, boolean z) {
        return str;
    }

    public String convertToString(T t) {
        return convertString(t.toString(), false);
    }

    public T getFromString(String str) {
        return Enum.valueOf(this.mClass, convertString(str, true));
    }
}
