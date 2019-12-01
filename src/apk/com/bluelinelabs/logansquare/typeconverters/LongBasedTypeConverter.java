package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class LongBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract Long convertToLong(T t);

    public abstract T getFromLong(Long l2);

    public T parse(e eVar) throws IOException {
        return getFromLong(Long.valueOf(eVar.D()));
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToLong(t).longValue());
        } else {
            cVar.h(convertToLong(t).longValue());
        }
    }
}
