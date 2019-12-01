package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class DoubleBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract double convertToDouble(T t);

    public abstract T getFromDouble(double d2);

    public T parse(e eVar) throws IOException {
        return getFromDouble(eVar.l());
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToDouble(t));
        } else {
            cVar.a(convertToDouble(t));
        }
    }
}
