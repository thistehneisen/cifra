package io.intercom.com.google.gson.b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedTreeMap */
public final class x<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a reason: collision with root package name */
    private static final Comparator<Comparable> f10147a = new v();
    Comparator<? super K> comparator;
    private a entrySet;
    final d<K, V> header;
    private b keySet;
    int modCount;
    d<K, V> root;
    int size;

    /* compiled from: LinkedTreeMap */
    class a extends AbstractSet<Entry<K, V>> {
        a() {
        }

        public void clear() {
            x.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && x.this.a((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new w(this);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            d a2 = x.this.a((Entry) obj);
            if (a2 == null) {
                return false;
            }
            x.this.a(a2, true);
            return true;
        }

        public int size() {
            return x.this.size;
        }
    }

    /* compiled from: LinkedTreeMap */
    final class b extends AbstractSet<K> {
        b() {
        }

        public void clear() {
            x.this.clear();
        }

        public boolean contains(Object obj) {
            return x.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new y(this);
        }

        public boolean remove(Object obj) {
            return x.this.b(obj) != null;
        }

        public int size() {
            return x.this.size;
        }
    }

    /* compiled from: LinkedTreeMap */
    private abstract class c<T> implements Iterator<T> {

        /* renamed from: a reason: collision with root package name */
        d<K, V> f10150a;

        /* renamed from: b reason: collision with root package name */
        d<K, V> f10151b = null;

        /* renamed from: c reason: collision with root package name */
        int f10152c;

        c() {
            x xVar = x.this;
            this.f10150a = xVar.header.f10157d;
            this.f10152c = xVar.modCount;
        }

        /* access modifiers changed from: 0000 */
        public final d<K, V> a() {
            d<K, V> dVar = this.f10150a;
            x xVar = x.this;
            if (dVar == xVar.header) {
                throw new NoSuchElementException();
            } else if (xVar.modCount == this.f10152c) {
                this.f10150a = dVar.f10157d;
                this.f10151b = dVar;
                return dVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f10150a != x.this.header;
        }

        public final void remove() {
            d<K, V> dVar = this.f10151b;
            if (dVar != null) {
                x.this.a(dVar, true);
                this.f10151b = null;
                this.f10152c = x.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: LinkedTreeMap */
    static final class d<K, V> implements Entry<K, V> {

        /* renamed from: a reason: collision with root package name */
        d<K, V> f10154a;

        /* renamed from: b reason: collision with root package name */
        d<K, V> f10155b;

        /* renamed from: c reason: collision with root package name */
        d<K, V> f10156c;

        /* renamed from: d reason: collision with root package name */
        d<K, V> f10157d;

        /* renamed from: e reason: collision with root package name */
        d<K, V> f10158e;

        /* renamed from: f reason: collision with root package name */
        final K f10159f;

        /* renamed from: g reason: collision with root package name */
        V f10160g;

        /* renamed from: h reason: collision with root package name */
        int f10161h;

        d() {
            this.f10159f = null;
            this.f10158e = this;
            this.f10157d = this;
        }

        public d<K, V> a() {
            d dVar = this;
            for (d dVar2 = this.f10155b; dVar2 != null; dVar2 = dVar2.f10155b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d dVar = this;
            for (d dVar2 = this.f10156c; dVar2 != null; dVar2 = dVar2.f10156c) {
                dVar = dVar2;
            }
            return dVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            K k2 = this.f10159f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f10160g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f10159f;
        }

        public V getValue() {
            return this.f10160g;
        }

        public int hashCode() {
            K k2 = this.f10159f;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f10160g;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            V v2 = this.f10160g;
            this.f10160g = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10159f);
            sb.append("=");
            sb.append(this.f10160g);
            return sb.toString();
        }

        d(d<K, V> dVar, K k2, d<K, V> dVar2, d<K, V> dVar3) {
            this.f10154a = dVar;
            this.f10159f = k2;
            this.f10161h = 1;
            this.f10157d = dVar2;
            this.f10158e = dVar3;
            dVar3.f10157d = this;
            dVar2.f10158e = this;
        }
    }

    public x() {
        this(f10147a);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* access modifiers changed from: 0000 */
    public d<K, V> a(K k2, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator2 = this.comparator;
        d<K, V> dVar2 = this.root;
        if (dVar2 != null) {
            Comparable comparable = comparator2 == f10147a ? (Comparable) k2 : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar2.f10159f);
                } else {
                    i2 = comparator2.compare(k2, dVar2.f10159f);
                }
                if (i2 == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i2 < 0 ? dVar2.f10155b : dVar2.f10156c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.header;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k2, dVar4, dVar4.f10158e);
            if (i2 < 0) {
                dVar2.f10155b = dVar;
            } else {
                dVar2.f10156c = dVar;
            }
            b(dVar2, true);
        } else if (comparator2 != f10147a || (k2 instanceof Comparable)) {
            dVar = new d<>(dVar2, k2, dVar4, dVar4.f10158e);
            this.root = dVar;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(k2.getClass().getName());
            sb.append(" is not Comparable");
            throw new ClassCastException(sb.toString());
        }
        this.size++;
        this.modCount++;
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    public d<K, V> b(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            a(a2, true);
        }
        return a2;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.f10158e = dVar;
        dVar.f10157d = dVar;
    }

    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a<>();
        this.entrySet = aVar2;
        return aVar2;
    }

    public V get(Object obj) {
        d a2 = a(obj);
        if (a2 != null) {
            return a2.f10160g;
        }
        return null;
    }

    public Set<K> keySet() {
        b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b<>();
        this.keySet = bVar2;
        return bVar2;
    }

    public V put(K k2, V v) {
        if (k2 != null) {
            d a2 = a(k2, true);
            V v2 = a2.f10160g;
            a2.f10160g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        d b2 = b(obj);
        if (b2 != null) {
            return b2.f10160g;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Comparator<? super K>, code=java.util.Comparator, for r2v0, types: [java.util.Comparator<? super K>, java.util.Comparator] */
    public x(Comparator comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        if (comparator2 == null) {
            comparator2 = f10147a;
        }
        this.comparator = comparator2;
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f10155b;
            d<K, V> dVar3 = dVar.f10156c;
            int i2 = 0;
            int i3 = dVar2 != null ? dVar2.f10161h : 0;
            int i4 = dVar3 != null ? dVar3.f10161h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                d<K, V> dVar4 = dVar3.f10155b;
                d<K, V> dVar5 = dVar3.f10156c;
                int i6 = dVar5 != null ? dVar5.f10161h : 0;
                if (dVar4 != null) {
                    i2 = dVar4.f10161h;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    a(dVar);
                } else {
                    b(dVar3);
                    a(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                d<K, V> dVar6 = dVar2.f10155b;
                d<K, V> dVar7 = dVar2.f10156c;
                int i8 = dVar7 != null ? dVar7.f10161h : 0;
                if (dVar6 != null) {
                    i2 = dVar6.f10161h;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    b(dVar);
                } else {
                    a(dVar2);
                    b(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                dVar.f10161h = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                dVar.f10161h = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f10154a;
        }
    }

    /* access modifiers changed from: 0000 */
    public d<K, V> a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return a((K) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public d<K, V> a(Entry<?, ?> entry) {
        d<K, V> a2 = a(entry.getKey());
        if (a2 != null && a((Object) a2.f10160g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: 0000 */
    public void a(d<K, V> dVar, boolean z) {
        int i2;
        if (z) {
            d<K, V> dVar2 = dVar.f10158e;
            dVar2.f10157d = dVar.f10157d;
            dVar.f10157d.f10158e = dVar2;
        }
        d<K, V> dVar3 = dVar.f10155b;
        d<K, V> dVar4 = dVar.f10156c;
        d<K, V> dVar5 = dVar.f10154a;
        int i3 = 0;
        if (dVar3 == null || dVar4 == null) {
            if (dVar3 != null) {
                a(dVar, dVar3);
                dVar.f10155b = null;
            } else if (dVar4 != null) {
                a(dVar, dVar4);
                dVar.f10156c = null;
            } else {
                a(dVar, null);
            }
            b(dVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        d<K, V> b2 = dVar3.f10161h > dVar4.f10161h ? dVar3.b() : dVar4.a();
        a(b2, false);
        d<K, V> dVar6 = dVar.f10155b;
        if (dVar6 != null) {
            i2 = dVar6.f10161h;
            b2.f10155b = dVar6;
            dVar6.f10154a = b2;
            dVar.f10155b = null;
        } else {
            i2 = 0;
        }
        d<K, V> dVar7 = dVar.f10156c;
        if (dVar7 != null) {
            i3 = dVar7.f10161h;
            b2.f10156c = dVar7;
            dVar7.f10154a = b2;
            dVar.f10156c = null;
        }
        b2.f10161h = Math.max(i2, i3) + 1;
        a(dVar, b2);
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f10155b;
        d<K, V> dVar3 = dVar.f10156c;
        d<K, V> dVar4 = dVar2.f10155b;
        d<K, V> dVar5 = dVar2.f10156c;
        dVar.f10155b = dVar5;
        if (dVar5 != null) {
            dVar5.f10154a = dVar;
        }
        a(dVar, dVar2);
        dVar2.f10156c = dVar;
        dVar.f10154a = dVar2;
        int i2 = 0;
        dVar.f10161h = Math.max(dVar3 != null ? dVar3.f10161h : 0, dVar5 != null ? dVar5.f10161h : 0) + 1;
        int i3 = dVar.f10161h;
        if (dVar4 != null) {
            i2 = dVar4.f10161h;
        }
        dVar2.f10161h = Math.max(i3, i2) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f10154a;
        dVar.f10154a = null;
        if (dVar2 != null) {
            dVar2.f10154a = dVar3;
        }
        if (dVar3 == null) {
            this.root = dVar2;
        } else if (dVar3.f10155b == dVar) {
            dVar3.f10155b = dVar2;
        } else {
            dVar3.f10156c = dVar2;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f10155b;
        d<K, V> dVar3 = dVar.f10156c;
        d<K, V> dVar4 = dVar3.f10155b;
        d<K, V> dVar5 = dVar3.f10156c;
        dVar.f10156c = dVar4;
        if (dVar4 != null) {
            dVar4.f10154a = dVar;
        }
        a(dVar, dVar3);
        dVar3.f10155b = dVar;
        dVar.f10154a = dVar3;
        int i2 = 0;
        dVar.f10161h = Math.max(dVar2 != null ? dVar2.f10161h : 0, dVar4 != null ? dVar4.f10161h : 0) + 1;
        int i3 = dVar.f10161h;
        if (dVar5 != null) {
            i2 = dVar5.f10161h;
        }
        dVar3.f10161h = Math.max(i3, i2) + 1;
    }
}
