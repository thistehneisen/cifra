package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.zc reason: case insensitive filesystem */
final class C0477zc<E> extends Ra<E> {

    /* renamed from: b reason: collision with root package name */
    private static final C0477zc<Object> f5461b;

    /* renamed from: c reason: collision with root package name */
    private final List<E> f5462c;

    static {
        C0477zc<Object> zcVar = new C0477zc<>(new ArrayList(0));
        f5461b = zcVar;
        zcVar.a();
    }

    private C0477zc(List<E> list) {
        this.f5462c = list;
    }

    public static <E> C0477zc<E> f() {
        return f5461b;
    }

    public final void add(int i2, E e2) {
        e();
        this.f5462c.add(i2, e2);
        this.modCount++;
    }

    public final /* synthetic */ Mb b(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f5462c);
            return new C0477zc(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final E get(int i2) {
        return this.f5462c.get(i2);
    }

    public final E remove(int i2) {
        e();
        E remove = this.f5462c.remove(i2);
        this.modCount++;
        return remove;
    }

    public final E set(int i2, E e2) {
        e();
        E e3 = this.f5462c.set(i2, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f5462c.size();
    }
}
