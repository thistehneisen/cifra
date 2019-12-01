package ru.touchin.roboswag.core.utils;

/* compiled from: ThreadLocalValue */
public class c<T> extends ThreadLocal<T> {

    /* renamed from: a reason: collision with root package name */
    private final a<T> f11173a;

    /* compiled from: ThreadLocalValue */
    public interface a<T> {
        T create();
    }

    public c(a<T> aVar) {
        this.f11173a = aVar;
    }

    /* access modifiers changed from: protected */
    public T initialValue() {
        return this.f11173a.create();
    }
}
