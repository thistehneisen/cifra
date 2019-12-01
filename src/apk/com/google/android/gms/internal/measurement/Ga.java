package com.google.android.gms.internal.measurement;

public final class Ga {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
