package b.b.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Entry<K, V>> {

    /* renamed from: a reason: collision with root package name */
    c<K, V> f2248a;

    /* renamed from: b reason: collision with root package name */
    private c<K, V> f2249b;

    /* renamed from: c reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2250c = new WeakHashMap<>();

    /* renamed from: d reason: collision with root package name */
    private int f2251d = 0;

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: 0000 */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f2255d;
        }

        /* access modifiers changed from: 0000 */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f2254c;
        }
    }

    /* renamed from: b.b.a.b.b$b reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    private static class C0020b<K, V> extends e<K, V> {
        C0020b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: 0000 */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f2254c;
        }

        /* access modifiers changed from: 0000 */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f2255d;
        }
    }

    /* compiled from: SafeIterableMap */
    static class c<K, V> implements Entry<K, V> {

        /* renamed from: a reason: collision with root package name */
        final K f2252a;

        /* renamed from: b reason: collision with root package name */
        final V f2253b;

        /* renamed from: c reason: collision with root package name */
        c<K, V> f2254c;

        /* renamed from: d reason: collision with root package name */
        c<K, V> f2255d;

        c(K k2, V v) {
            this.f2252a = k2;
            this.f2253b = v;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f2252a.equals(cVar.f2252a) || !this.f2253b.equals(cVar.f2253b)) {
                z = false;
            }
            return z;
        }

        public K getKey() {
            return this.f2252a;
        }

        public V getValue() {
            return this.f2253b;
        }

        public int hashCode() {
            return this.f2252a.hashCode() ^ this.f2253b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2252a);
            sb.append("=");
            sb.append(this.f2253b);
            return sb.toString();
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements Iterator<Entry<K, V>>, f<K, V> {

        /* renamed from: a reason: collision with root package name */
        private c<K, V> f2256a;

        /* renamed from: b reason: collision with root package name */
        private boolean f2257b = true;

        d() {
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2256a;
            if (cVar == cVar2) {
                this.f2256a = cVar2.f2255d;
                this.f2257b = this.f2256a == null;
            }
        }

        public boolean hasNext() {
            boolean z = true;
            if (this.f2257b) {
                if (b.this.f2248a == null) {
                    z = false;
                }
                return z;
            }
            c<K, V> cVar = this.f2256a;
            if (cVar == null || cVar.f2254c == null) {
                z = false;
            }
            return z;
        }

        public Entry<K, V> next() {
            if (this.f2257b) {
                this.f2257b = false;
                this.f2256a = b.this.f2248a;
            } else {
                c<K, V> cVar = this.f2256a;
                this.f2256a = cVar != null ? cVar.f2254c : null;
            }
            return this.f2256a;
        }
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements Iterator<Entry<K, V>>, f<K, V> {

        /* renamed from: a reason: collision with root package name */
        c<K, V> f2259a;

        /* renamed from: b reason: collision with root package name */
        c<K, V> f2260b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2259a = cVar2;
            this.f2260b = cVar;
        }

        public void a(c<K, V> cVar) {
            if (this.f2259a == cVar && cVar == this.f2260b) {
                this.f2260b = null;
                this.f2259a = null;
            }
            c<K, V> cVar2 = this.f2259a;
            if (cVar2 == cVar) {
                this.f2259a = b(cVar2);
            }
            if (this.f2260b == cVar) {
                this.f2260b = a();
            }
        }

        /* access modifiers changed from: 0000 */
        public abstract c<K, V> b(c<K, V> cVar);

        /* access modifiers changed from: 0000 */
        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f2260b != null;
        }

        public Entry<K, V> next() {
            c<K, V> cVar = this.f2260b;
            this.f2260b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f2260b;
            c<K, V> cVar2 = this.f2259a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* compiled from: SafeIterableMap */
    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k2) {
        c<K, V> cVar = this.f2248a;
        while (cVar != null && !cVar.f2252a.equals(k2)) {
            cVar = cVar.f2254c;
        }
        return cVar;
    }

    public V b(K k2, V v) {
        c a2 = a(k2);
        if (a2 != null) {
            return a2.f2253b;
        }
        a(k2, v);
        return null;
    }

    public Iterator<Entry<K, V>> descendingIterator() {
        C0020b bVar = new C0020b(this.f2249b, this.f2248a);
        this.f2250c.put(bVar, Boolean.valueOf(false));
        return bVar;
    }

    public Entry<K, V> e() {
        return this.f2248a;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            z = false;
        }
        return z;
    }

    public d f() {
        d dVar = new d<>();
        this.f2250c.put(dVar, Boolean.valueOf(false));
        return dVar;
    }

    public Entry<K, V> g() {
        return this.f2249b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((Entry) it.next()).hashCode();
        }
        return i2;
    }

    public Iterator<Entry<K, V>> iterator() {
        a aVar = new a(this.f2248a, this.f2249b);
        this.f2250c.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    public V remove(K k2) {
        c a2 = a(k2);
        if (a2 == null) {
            return null;
        }
        this.f2251d--;
        if (!this.f2250c.isEmpty()) {
            for (f a3 : this.f2250c.keySet()) {
                a3.a(a2);
            }
        }
        c<K, V> cVar = a2.f2255d;
        if (cVar != null) {
            cVar.f2254c = a2.f2254c;
        } else {
            this.f2248a = a2.f2254c;
        }
        c<K, V> cVar2 = a2.f2254c;
        if (cVar2 != null) {
            cVar2.f2255d = a2.f2255d;
        } else {
            this.f2249b = a2.f2255d;
        }
        a2.f2254c = null;
        a2.f2255d = null;
        return a2.f2253b;
    }

    public int size() {
        return this.f2251d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.f2251d++;
        c<K, V> cVar2 = this.f2249b;
        if (cVar2 == null) {
            this.f2248a = cVar;
            this.f2249b = this.f2248a;
            return cVar;
        }
        cVar2.f2254c = cVar;
        cVar.f2255d = cVar2;
        this.f2249b = cVar;
        return cVar;
    }
}
