package com.bluelinelabs.logansquare;

import java.io.Serializable;
import java.util.Arrays;

public class JsonOptional<T> implements Serializable {
    private final boolean empty;
    private final T value;

    protected JsonOptional(boolean z, T t) {
        this.empty = z;
        this.value = t;
    }

    public static <T> JsonOptional<T> empty() {
        return new JsonOptional<>(true, null);
    }

    public static <T> JsonOptional<T> value(T t) {
        return new JsonOptional<>(false, t);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonOptional jsonOptional = (JsonOptional) obj;
        if (!(this.empty == jsonOptional.empty && this.value == jsonOptional.value)) {
            T t = this.value;
            if (t == null || !t.equals(jsonOptional.value)) {
                z = false;
            }
        }
        return z;
    }

    public T get() {
        return this.value;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.empty), this.value});
    }

    public boolean isEmpty() {
        return this.empty;
    }
}
