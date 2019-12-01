package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public abstract class FloatBasedTypeConverter<T> implements TypeConverter<T> {
    public abstract float convertToFloat(T t);

    public abstract T getFromFloat(float f2);

    public T parse(e eVar) throws IOException {
        return getFromFloat((float) eVar.l());
    }

    public void serialize(T t, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, convertToFloat(t));
        } else {
            cVar.a(convertToFloat(t));
        }
    }
}
