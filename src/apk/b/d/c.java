package b.d;

import java.util.Map;

/* compiled from: ArraySet */
class c extends h<E, E> {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ d f2263d;

    c(d dVar) {
        this.f2263d = dVar;
    }

    /* access modifiers changed from: protected */
    public Object a(int i2, int i3) {
        return this.f2263d.f2271h[i2];
    }

    /* access modifiers changed from: protected */
    public int b(Object obj) {
        return this.f2263d.indexOf(obj);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f2263d.f2272i;
    }

    /* access modifiers changed from: protected */
    public int a(Object obj) {
        return this.f2263d.indexOf(obj);
    }

    /* access modifiers changed from: protected */
    public Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    public void a(E e2, E e3) {
        this.f2263d.add(e2);
    }

    /* access modifiers changed from: protected */
    public E a(int i2, E e2) {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f2263d.f(i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f2263d.clear();
    }
}
