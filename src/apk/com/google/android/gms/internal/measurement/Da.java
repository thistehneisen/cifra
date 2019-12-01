package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public abstract class Da<T> implements Serializable {
    Da() {
    }

    public static <T> Da<T> a(T t) {
        Ga.a(t);
        return new Fa(t);
    }

    public static <T> Da<T> c() {
        return Ba.f4860a;
    }

    public abstract T a();

    public abstract boolean b();
}
