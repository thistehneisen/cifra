package com.google.firebase.components;

import com.google.android.gms.common.internal.q;
import com.google.firebase.a.a;
import com.google.firebase.a.b;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
class s implements d, c {

    /* renamed from: a reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> f6717a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private Queue<a<?>> f6718b = new ArrayDeque();

    /* renamed from: c reason: collision with root package name */
    private final Executor f6719c;

    s(Executor executor) {
        this.f6719c = executor;
    }

    private synchronized Set<Entry<b<Object>, Executor>> b(a<?> aVar) {
        Map map;
        map = (Map) this.f6717a.get(aVar.b());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r1 = (java.util.Map.Entry) r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(com.google.firebase.components.r.a(r1, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = b(r4).iterator();
     */
    public void a(a<?> aVar) {
        q.a(aVar);
        synchronized (this) {
            if (this.f6718b != null) {
                this.f6718b.add(aVar);
            }
        }
    }

    public synchronized <T> void a(Class<T> cls, Executor executor, b<? super T> bVar) {
        q.a(cls);
        q.a(bVar);
        q.a(executor);
        if (!this.f6717a.containsKey(cls)) {
            this.f6717a.put(cls, new ConcurrentHashMap());
        }
        ((ConcurrentHashMap) this.f6717a.get(cls)).put(bVar, executor);
    }

    public <T> void a(Class<T> cls, b<? super T> bVar) {
        a(cls, this.f6719c, bVar);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        Queue<a> queue;
        synchronized (this) {
            if (this.f6718b != null) {
                queue = this.f6718b;
                this.f6718b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (a a2 : queue) {
                a(a2);
            }
        }
    }
}
