package com.google.firebase.a;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class a<T> {

    /* renamed from: a reason: collision with root package name */
    private final Class<T> f6648a;

    /* renamed from: b reason: collision with root package name */
    private final T f6649b;

    public T a() {
        return this.f6649b;
    }

    public Class<T> b() {
        return this.f6648a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f6648a, this.f6649b});
    }
}
