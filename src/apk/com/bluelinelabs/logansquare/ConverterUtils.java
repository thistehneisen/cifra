package com.bluelinelabs.logansquare;

import java.lang.reflect.Type;

public final class ConverterUtils {
    private ConverterUtils() {
    }

    public static ParameterizedType parameterizedTypeOf(Type type) {
        return new ConcreteParameterizedType(type);
    }
}
