package com.google.android.gms.internal.measurement;

final class Fa<T> extends Da<T> {
    private final T zzabr;

    Fa(T t) {
        this.zzabr = t;
    }

    public final T a() {
        return this.zzabr;
    }

    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Fa)) {
            return false;
        }
        return this.zzabr.equals(((Fa) obj).zzabr);
    }

    public final int hashCode() {
        return this.zzabr.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzabr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
