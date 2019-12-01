package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class StringBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract String convertToString(T t);

    public abstract T getFromString(String str);

    public T parse(e eVar) throws IOException {
        return getFromString(eVar.c(null));
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToString(t));
        } else {
            cVar.f(convertToString(t));
        }
    }
}
