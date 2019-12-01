package b.b.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: FastSafeIterableMap */
public class a<K, V> extends b<K, V> {

    /* renamed from: e reason: collision with root package name */
    private HashMap<K, c<K, V>> f2247e = new HashMap<>();

    /* access modifiers changed from: protected */
    public c<K, V> a(K k2) {
        return (c) this.f2247e.get(k2);
    }

    public V b(K k2, V v) {
        c a2 = a(k2);
        if (a2 != null) {
            return a2.f2253b;
        }
        this.f2247e.put(k2, a(k2, v));
        return null;
    }

    public boolean contains(K k2) {
        return this.f2247e.containsKey(k2);
    }

    public V remove(K k2) {
        V remove = super.remove(k2);
        this.f2247e.remove(k2);
        return remove;
    }

    public Entry<K, V> b(K k2) {
        if (contains(k2)) {
            return ((c) this.f2247e.get(k2)).f2255d;
        }
        return null;
    }
}
