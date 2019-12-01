package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public interface TypeConverter<T> {
    T parse(e eVar) throws IOException;

    void serialize(T t, String str, boolean z, c cVar) throws IOException;
}
