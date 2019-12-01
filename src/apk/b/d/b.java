package b.d;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class b<K, V> extends i<K, V> implements Map<K, V> {

    /* renamed from: h reason: collision with root package name */
    h<K, V> f2262h;

    public b() {
    }

    private h<K, V> b() {
        if (this.f2262h == null) {
            this.f2262h = new a(this);
        }
        return this.f2262h;
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.f2311g + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }

    public b(int i2) {
        super(i2);
    }

    public b(i iVar) {
        super(iVar);
    }
}
