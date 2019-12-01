package kotlin;

import java.io.Serializable;

/* compiled from: Lazy.kt */
public final class b<T> implements c<T>, Serializable {
    private final T value;

    public b(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
