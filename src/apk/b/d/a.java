package b.d;

import java.util.Map;

/* compiled from: ArrayMap */
class a extends h<K, V> {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ b f2261d;

    a(b bVar) {
        this.f2261d = bVar;
    }

    /* access modifiers changed from: protected */
    public Object a(int i2, int i3) {
        return this.f2261d.f2310f[(i2 << 1) + i3];
    }

    /* access modifiers changed from: protected */
    public int b(Object obj) {
        return this.f2261d.b(obj);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f2261d.f2311g;
    }

    /* access modifiers changed from: protected */
    public int a(Object obj) {
        return this.f2261d.a(obj);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> b() {
        return this.f2261d;
    }

    /* access modifiers changed from: protected */
    public void a(K k2, V v) {
        this.f2261d.put(k2, v);
    }

    /* access modifiers changed from: protected */
    public V a(int i2, V v) {
        return this.f2261d.a(i2, v);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f2261d.c(i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f2261d.clear();
    }
}
