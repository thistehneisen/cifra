package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Vb extends Ra<String> implements Ub, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final Vb f5058b;

    /* renamed from: c reason: collision with root package name */
    private static final Ub f5059c = f5058b;

    /* renamed from: d reason: collision with root package name */
    private final List<Object> f5060d;

    static {
        Vb vb = new Vb();
        f5058b = vb;
        vb.a();
    }

    public Vb() {
        this(10);
    }

    public final void a(Xa xa) {
        e();
        this.f5060d.add(xa);
        this.modCount++;
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        String str = (String) obj;
        e();
        this.f5060d.add(i2, str);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    public final Ub c() {
        return b() ? new Xc(this) : this;
    }

    public final void clear() {
        e();
        this.f5060d.clear();
        this.modCount++;
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f5060d);
    }

    public final Object e(int i2) {
        return this.f5060d.get(i2);
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f5060d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Xa) {
            Xa xa = (Xa) obj;
            String e2 = xa.e();
            if (xa.f()) {
                this.f5060d.set(i2, e2);
            }
            return e2;
        }
        byte[] bArr = (byte[]) obj;
        String c2 = Fb.c(bArr);
        if (Fb.b(bArr)) {
            this.f5060d.set(i2, c2);
        }
        return c2;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        String str = (String) obj;
        e();
        return a(this.f5060d.set(i2, str));
    }

    public final int size() {
        return this.f5060d.size();
    }

    public Vb(int i2) {
        this(new ArrayList<>(i2));
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        e();
        if (collection instanceof Ub) {
            collection = ((Ub) collection).d();
        }
        boolean addAll = this.f5060d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Mb b(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f5060d);
            return new Vb(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        Object remove = this.f5060d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    private Vb(ArrayList<Object> arrayList) {
        this.f5060d = arrayList;
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Xa) {
            return ((Xa) obj).e();
        }
        return Fb.c((byte[]) obj);
    }
}
