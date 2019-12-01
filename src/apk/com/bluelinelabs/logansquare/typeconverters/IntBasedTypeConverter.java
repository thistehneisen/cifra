package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class IntBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract int convertToInt(T t);

    public abstract T getFromInt(int i2);

    public T parse(e eVar) throws IOException {
        return getFromInt(eVar.m());
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToInt(t));
        } else {
            cVar.a(convertToInt(t));
        }
    }
}
