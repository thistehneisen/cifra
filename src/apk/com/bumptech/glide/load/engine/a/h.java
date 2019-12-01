package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
class h<K extends m, V> {

    /* renamed from: a reason: collision with root package name */
    private final a<K, V> f3907a = new a<>();

    /* renamed from: b reason: collision with root package name */
    private final Map<K, a<K, V>> f3908b = new HashMap();

    /* compiled from: GroupedLinkedMap */
    private static class a<K, V> {

        /* renamed from: a reason: collision with root package name */
        final K f3909a;

        /* renamed from: b reason: collision with root package name */
        private List<V> f3910b;

        /* renamed from: c reason: collision with root package name */
        a<K, V> f3911c;

        /* renamed from: d reason: collision with root package name */
        a<K, V> f3912d;

        a() {
            this(null);
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f3910b.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f3910b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f3912d = this;
            this.f3911c = this;
            this.f3909a = k2;
        }

        public void a(V v) {
            if (this.f3910b == null) {
                this.f3910b = new ArrayList();
            }
            this.f3910b.add(v);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f3907a;
        aVar.f3912d = aVar2.f3912d;
        aVar.f3911c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f3912d;
        aVar2.f3911c = aVar.f3911c;
        aVar.f3911c.f3912d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f3911c.f3912d = aVar;
        aVar.f3912d.f3911c = aVar;
    }

    public void a(K k2, V v) {
        a aVar = (a) this.f3908b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            b(aVar);
            this.f3908b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f3907a.f3911c; !aVar.equals(this.f3907a); aVar = aVar.f3911c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f3909a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k2) {
        a aVar = (a) this.f3908b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            this.f3908b.put(k2, aVar);
        } else {
            k2.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a<K, V> aVar = this.f3907a.f3912d; !aVar.equals(this.f3907a); aVar = aVar.f3912d) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            c(aVar);
            this.f3908b.remove(aVar.f3909a);
            ((m) aVar.f3909a).a();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f3907a;
        aVar.f3912d = aVar2;
        aVar.f3911c = aVar2.f3911c;
        d(aVar);
    }
}
