package com.google.android.gms.internal.measurement;

final class Ba<T> extends Da<T> {

    /* renamed from: a reason: collision with root package name */
    static final Ba<Object> f4860a = new Ba<>();

    private Ba() {
    }

    public final T a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean b() {
        return false;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
