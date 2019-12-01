package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
class p {

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        private final e<?> f6707a;

        /* renamed from: b reason: collision with root package name */
        private final Set<a> f6708b = new HashSet();

        /* renamed from: c reason: collision with root package name */
        private final Set<a> f6709c = new HashSet();

        a(e<?> eVar) {
            this.f6707a = eVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar) {
            this.f6708b.add(aVar);
        }

        /* access modifiers changed from: 0000 */
        public void b(a aVar) {
            this.f6709c.add(aVar);
        }

        /* access modifiers changed from: 0000 */
        public void c(a aVar) {
            this.f6709c.remove(aVar);
        }

        /* access modifiers changed from: 0000 */
        public boolean d() {
            return this.f6709c.isEmpty();
        }

        /* access modifiers changed from: 0000 */
        public e<?> a() {
            return this.f6707a;
        }

        /* access modifiers changed from: 0000 */
        public Set<a> b() {
            return this.f6708b;
        }

        /* access modifiers changed from: 0000 */
        public boolean c() {
            return this.f6708b.isEmpty();
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        private final Class<?> f6710a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final boolean f6711b;

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.f6710a.equals(this.f6710a) || bVar.f6711b != this.f6711b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f6710a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f6711b).hashCode();
        }

        private b(Class<?> cls, boolean z) {
            this.f6710a = cls;
            this.f6711b = z;
        }
    }

    static void a(List<e<?>> list) {
        Set<a> b2 = b(list);
        Set a2 = a(b2);
        int i2 = 0;
        while (!a2.isEmpty()) {
            a aVar = (a) a2.iterator().next();
            a2.remove(aVar);
            i2++;
            for (a aVar2 : aVar.b()) {
                aVar2.c(aVar);
                if (aVar2.d()) {
                    a2.add(aVar2);
                }
            }
        }
        if (i2 != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar3 : b2) {
                if (!aVar3.d() && !aVar3.c()) {
                    arrayList.add(aVar3.a());
                }
            }
            throw new DependencyCycleException(arrayList);
        }
    }

    private static Set<a> b(List<e<?>> list) {
        HashMap hashMap = new HashMap(list.size());
        for (e eVar : list) {
            a aVar = new a(eVar);
            Iterator it = eVar.c().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    b bVar = new b(cls, !eVar.g());
                    if (!hashMap.containsKey(bVar)) {
                        hashMap.put(bVar, new HashSet());
                    }
                    Set set = (Set) hashMap.get(bVar);
                    if (set.isEmpty() || bVar.f6711b) {
                        set.add(aVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (Set<a> it2 : hashMap.values()) {
            for (a aVar2 : it2) {
                for (q qVar : aVar2.a().a()) {
                    if (qVar.b()) {
                        Set<a> set2 = (Set) hashMap.get(new b(qVar.a(), qVar.d()));
                        if (set2 != null) {
                            for (a aVar3 : set2) {
                                aVar2.a(aVar3);
                                aVar3.b(aVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }

    private static Set<a> a(Set<a> set) {
        HashSet hashSet = new HashSet();
        for (a aVar : set) {
            if (aVar.d()) {
                hashSet.add(aVar);
            }
        }
        return hashSet;
    }
}
