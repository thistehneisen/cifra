package com.google.firebase.components;

import com.google.android.gms.common.internal.q;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import com.google.firebase.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class n extends a {

    /* renamed from: a reason: collision with root package name */
    private static final a<Set<Object>> f6702a = m.a();

    /* renamed from: b reason: collision with root package name */
    private final Map<e<?>, t<?>> f6703b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    private final Map<Class<?>, t<?>> f6704c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    private final Map<Class<?>, t<Set<?>>> f6705d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    private final s f6706e;

    public n(Executor executor, Iterable<j> iterable, e<?>... eVarArr) {
        this.f6706e = new s(executor);
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(e.a(this.f6706e, s.class, d.class, c.class));
        for (j components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, eVarArr);
        p.a((List<e<?>>) arrayList);
        for (e eVar : arrayList) {
            this.f6703b.put(eVar, new t(k.a(this, eVar)));
        }
        a();
        b();
    }

    private void b() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f6703b.entrySet()) {
            e eVar = (e) entry.getKey();
            if (!eVar.g()) {
                t tVar = (t) entry.getValue();
                for (Class cls : eVar.c()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(tVar);
                }
            }
        }
        for (Entry entry2 : hashMap.entrySet()) {
            this.f6705d.put((Class) entry2.getKey(), new t(l.a((Set) entry2.getValue())));
        }
    }

    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    public <T> a<Set<T>> c(Class<T> cls) {
        t tVar = (t) this.f6705d.get(cls);
        if (tVar != null) {
            return tVar;
        }
        return f6702a;
    }

    public /* bridge */ /* synthetic */ Set d(Class cls) {
        return super.d(cls);
    }

    private void a() {
        for (Entry entry : this.f6703b.entrySet()) {
            e eVar = (e) entry.getKey();
            if (eVar.g()) {
                t tVar = (t) entry.getValue();
                for (Class put : eVar.c()) {
                    this.f6704c.put(put, tVar);
                }
            }
        }
        c();
    }

    private void c() {
        for (e eVar : this.f6703b.keySet()) {
            Iterator it = eVar.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    q qVar = (q) it.next();
                    if (qVar.c() && !this.f6704c.containsKey(qVar.a())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{eVar, qVar.a()}));
                    }
                }
            }
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Set, code=java.util.Set<com.google.firebase.components.t>, for r2v0, types: [java.util.Set<com.google.firebase.components.t>, java.util.Set] */
    static /* synthetic */ Set a(Set<t> set) {
        HashSet hashSet = new HashSet();
        for (t tVar : set) {
            hashSet.add(tVar.get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void a(boolean z) {
        for (Entry entry : this.f6703b.entrySet()) {
            e eVar = (e) entry.getKey();
            t tVar = (t) entry.getValue();
            if (eVar.e() || (eVar.f() && z)) {
                tVar.get();
            }
        }
        this.f6706e.a();
    }

    public <T> a<T> b(Class<T> cls) {
        q.a(cls, (Object) "Null interface requested.");
        return (a) this.f6704c.get(cls);
    }
}
