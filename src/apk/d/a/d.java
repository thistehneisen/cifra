package d.a;

import java.util.Collections;
import java.util.Map;

/* compiled from: MapBuilder */
public final class d<K, V> {

    /* renamed from: a reason: collision with root package name */
    private final Map<K, V> f7852a;

    private d(int i2) {
        this.f7852a = a.a(i2);
    }

    public static <K, V> d<K, V> a(int i2) {
        return new d<>(i2);
    }

    public d<K, V> a(K k2, V v) {
        this.f7852a.put(k2, v);
        return this;
    }

    public Map<K, V> a() {
        if (this.f7852a.size() != 0) {
            return Collections.unmodifiableMap(this.f7852a);
        }
        return Collections.emptyMap();
    }
}
