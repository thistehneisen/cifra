package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

final class Ma<T> implements Ja<T>, Serializable {
    private final T zzaby;

    Ma(T t) {
        this.zzaby = t;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Ma)) {
            return false;
        }
        Ma ma = (Ma) obj;
        T t = this.zzaby;
        T t2 = ma.zzaby;
        if (t == t2 || (t != null && t.equals(t2))) {
            return true;
        }
        return false;
    }

    public final T get() {
        return this.zzaby;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzaby});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzaby);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
