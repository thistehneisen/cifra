package ru.touchin.roboswag.core.utils;

import b.g.h.c;
import java.io.Serializable;

/* compiled from: Optional */
public class b<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final T value;

    public b(T t) {
        this.value = t;
    }

    public T a() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return c.a(this.value, ((b) obj).value);
    }

    public int hashCode() {
        return c.a(this.value);
    }
}
