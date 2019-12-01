package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class BooleanBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract boolean convertToBoolean(T t);

    public abstract T getFromBoolean(boolean z);

    public T parse(e eVar) throws IOException {
        return getFromBoolean(eVar.k());
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToBoolean(t));
        } else {
            cVar.a(convertToBoolean(t));
        }
    }
}
