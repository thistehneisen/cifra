package io.fabric.sdk.android.a.a;

import android.content.Context;

/* compiled from: MemoryValueCache */
public class b<T> extends a<T> {

    /* renamed from: b reason: collision with root package name */
    private T f8783b;

    public b() {
        this(null);
    }

    /* access modifiers changed from: protected */
    public T a(Context context) {
        return this.f8783b;
    }

    public b(c<T> cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, T t) {
        this.f8783b = t;
    }
}
