package io.intercom.com.bumptech.glide.load.engine.a;

import io.intercom.com.bumptech.glide.load.engine.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
class h<K extends m, V> {

    /* renamed from: a reason: collision with root package name */
    private final a<K, V> f9768a = new a<>();

    /* renamed from: b reason: collision with root package name */
    private final Map<K, a<K, V>> f9769b = new HashMap();

    /* compiled from: GroupedLinkedMap */
    private static class a<K, V> {

        /* renamed from: a reason: collision with root package name */
        final K f9770a;

        /* renamed from: b reason: collision with root package name */
        private List<V> f9771b;

        /* renamed from: c reason: collision with root package name */
        a<K, V> f9772c;

        /* renamed from: d reason: collision with root package name */
        a<K, V> f9773d;

        a() {
            this(null);
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f9771b.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f9771b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f9773d = this;
            this.f9772c = this;
            this.f9770a = k2;
        }

        public void a(V v) {
            if (this.f9771b == null) {
                this.f9771b = new ArrayList();
            }
            this.f9771b.add(v);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f9768a;
        aVar.f9773d = aVar2.f9773d;
        aVar.f9772c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f9773d;
        aVar2.f9772c = aVar.f9772c;
        aVar.f9772c.f9773d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f9772c.f9773d = aVar;
        aVar.f9773d.f9772c = aVar;
    }

    public void a(K k2, V v) {
        a aVar = (a) this.f9769b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            b(aVar);
            this.f9769b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f9768a.f9772c; !aVar.equals(this.f9768a); aVar = aVar.f9772c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f9770a);
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
        a aVar = (a) this.f9769b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            this.f9769b.put(k2, aVar);
        } else {
            k2.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a<K, V> aVar = this.f9768a.f9773d; !aVar.equals(this.f9768a); aVar = aVar.f9773d) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            c(aVar);
            this.f9769b.remove(aVar.f9770a);
            ((m) aVar.f9770a).a();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f9768a;
        aVar.f9773d = aVar2;
        aVar.f9772c = aVar2.f9772c;
        d(aVar);
    }
}
