package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public final class Ia {
    public static <T> Ja<T> a(Ja<T> ja) {
        if ((ja instanceof Ka) || (ja instanceof La)) {
            return ja;
        }
        if (ja instanceof Serializable) {
            return new La(ja);
        }
        return new Ka(ja);
    }

    public static <T> Ja<T> a(T t) {
        return new Ma(t);
    }
}
