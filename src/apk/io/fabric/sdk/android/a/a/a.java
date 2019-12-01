package io.fabric.sdk.android.a.a;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class a<T> implements c<T> {

    /* renamed from: a reason: collision with root package name */
    private final c<T> f8782a;

    public a(c<T> cVar) {
        this.f8782a = cVar;
    }

    private void b(Context context, T t) {
        if (t != null) {
            a(context, t);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public abstract T a(Context context);

    public final synchronized T a(Context context, d<T> dVar) throws Exception {
        T a2;
        a2 = a(context);
        if (a2 == null) {
            a2 = this.f8782a != null ? this.f8782a.a(context, dVar) : dVar.load(context);
            b(context, a2);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, T t);
}
