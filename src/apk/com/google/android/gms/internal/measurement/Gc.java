package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Gc<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a reason: collision with root package name */
    private final int f4946a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public List<Lc> f4947b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public Map<K, V> f4948c;

    /* renamed from: d reason: collision with root package name */
    private boolean f4949d;

    /* renamed from: e reason: collision with root package name */
    private volatile Nc f4950e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public Map<K, V> f4951f;

    /* renamed from: g reason: collision with root package name */
    private volatile Hc f4952g;

    private Gc(int i2) {
        this.f4946a = i2;
        this.f4947b = Collections.emptyList();
        this.f4948c = Collections.emptyMap();
        this.f4951f = Collections.emptyMap();
    }

    static <FieldDescriptorType extends C0458wb<FieldDescriptorType>> Gc<FieldDescriptorType, Object> a(int i2) {
        return new Fc(i2);
    }

    /* access modifiers changed from: private */
    public final void f() {
        if (this.f4949d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f4948c.isEmpty() && !(this.f4948c instanceof TreeMap)) {
            this.f4948c = new TreeMap();
            this.f4951f = ((TreeMap) this.f4948c).descendingMap();
        }
        return (SortedMap) this.f4948c;
    }

    public void b() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f4949d) {
            if (this.f4948c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f4948c);
            }
            this.f4948c = map;
            if (this.f4951f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f4951f);
            }
            this.f4951f = map2;
            this.f4949d = true;
        }
    }

    public final int c() {
        return this.f4947b.size();
    }

    public void clear() {
        f();
        if (!this.f4947b.isEmpty()) {
            this.f4947b.clear();
        }
        if (!this.f4948c.isEmpty()) {
            this.f4948c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((K) comparable) >= 0 || this.f4948c.containsKey(comparable);
    }

    public final Iterable<Entry<K, V>> d() {
        if (this.f4948c.isEmpty()) {
            return Kc.a();
        }
        return this.f4948c.entrySet();
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> e() {
        if (this.f4952g == null) {
            this.f4952g = new Hc(this, null);
        }
        return this.f4952g;
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f4950e == null) {
            this.f4950e = new Nc(this, null);
        }
        return this.f4950e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Gc)) {
            return super.equals(obj);
        }
        Gc gc = (Gc) obj;
        int size = size();
        if (size != gc.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != gc.c()) {
            return entrySet().equals(gc.entrySet());
        }
        for (int i2 = 0; i2 < c2; i2++) {
            if (!b(i2).equals(gc.b(i2))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f4948c.equals(gc.f4948c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((K) comparable);
        if (a2 >= 0) {
            return ((Lc) this.f4947b.get(a2)).getValue();
        }
        return this.f4948c.get(comparable);
    }

    public int hashCode() {
        int i2 = 0;
        for (int i3 = 0; i3 < c(); i3++) {
            i2 += ((Lc) this.f4947b.get(i3)).hashCode();
        }
        return this.f4948c.size() > 0 ? i2 + this.f4948c.hashCode() : i2;
    }

    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((K) comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f4948c.isEmpty()) {
            return null;
        }
        return this.f4948c.remove(comparable);
    }

    public int size() {
        return this.f4947b.size() + this.f4948c.size();
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        f();
        V value = ((Lc) this.f4947b.remove(i2)).getValue();
        if (!this.f4948c.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            this.f4947b.add(new Lc(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public final boolean a() {
        return this.f4949d;
    }

    /* renamed from: a */
    public final V put(K k2, V v) {
        f();
        int a2 = a(k2);
        if (a2 >= 0) {
            return ((Lc) this.f4947b.get(a2)).setValue(v);
        }
        f();
        if (this.f4947b.isEmpty() && !(this.f4947b instanceof ArrayList)) {
            this.f4947b = new ArrayList(this.f4946a);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f4946a) {
            return g().put(k2, v);
        }
        int size = this.f4947b.size();
        int i3 = this.f4946a;
        if (size == i3) {
            Lc lc = (Lc) this.f4947b.remove(i3 - 1);
            g().put((Comparable) lc.getKey(), lc.getValue());
        }
        this.f4947b.add(i2, new Lc(this, k2, v));
        return null;
    }

    /* synthetic */ Gc(int i2, Fc fc) {
        this(i2);
    }

    public final Entry<K, V> b(int i2) {
        return (Entry) this.f4947b.get(i2);
    }

    private final int a(K k2) {
        int size = this.f4947b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) ((Lc) this.f4947b.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo((Comparable) ((Lc) this.f4947b.get(i3)).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }
}
