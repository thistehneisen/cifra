package com.bluelinelabs.logansquare;

public class NonNullJsonOptional<T> extends JsonOptional<T> {
    private NonNullJsonOptional(boolean z, T t) {
        super(z, t);
    }

    public static <T> NonNullJsonOptional<T> empty() {
        return new NonNullJsonOptional<>(true, null);
    }

    public static <T> NonNullJsonOptional<T> value(T t) {
        return new NonNullJsonOptional<>(false, t);
    }
}
