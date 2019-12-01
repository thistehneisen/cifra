package com.google.firebase.components;

import com.google.firebase.a.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
final class u extends a {

    /* renamed from: a reason: collision with root package name */
    private final Set<Class<?>> f6723a;

    /* renamed from: b reason: collision with root package name */
    private final Set<Class<?>> f6724b;

    /* renamed from: c reason: collision with root package name */
    private final Set<Class<?>> f6725c;

    /* renamed from: d reason: collision with root package name */
    private final Set<Class<?>> f6726d;

    /* renamed from: e reason: collision with root package name */
    private final Set<Class<?>> f6727e;

    /* renamed from: f reason: collision with root package name */
    private final f f6728f;

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class a implements c {

        /* renamed from: a reason: collision with root package name */
        private final Set<Class<?>> f6729a;

        /* renamed from: b reason: collision with root package name */
        private final c f6730b;

        public a(Set<Class<?>> set, c cVar) {
            this.f6729a = set;
            this.f6730b = cVar;
        }
    }

    u(e<?> eVar, f fVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (q qVar : eVar.a()) {
            if (qVar.b()) {
                if (qVar.d()) {
                    hashSet3.add(qVar.a());
                } else {
                    hashSet.add(qVar.a());
                }
            } else if (qVar.d()) {
                hashSet4.add(qVar.a());
            } else {
                hashSet2.add(qVar.a());
            }
        }
        if (!eVar.d().isEmpty()) {
            hashSet.add(c.class);
        }
        this.f6723a = Collections.unmodifiableSet(hashSet);
        this.f6724b = Collections.unmodifiableSet(hashSet2);
        this.f6725c = Collections.unmodifiableSet(hashSet3);
        this.f6726d = Collections.unmodifiableSet(hashSet4);
        this.f6727e = eVar.d();
        this.f6728f = fVar;
    }

    public <T> T a(Class<T> cls) {
        if (this.f6723a.contains(cls)) {
            T a2 = this.f6728f.a(cls);
            if (!cls.equals(c.class)) {
                return a2;
            }
            return new a(this.f6727e, (c) a2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> com.google.firebase.b.a<T> b(Class<T> cls) {
        if (this.f6724b.contains(cls)) {
            return this.f6728f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> com.google.firebase.b.a<Set<T>> c(Class<T> cls) {
        if (this.f6726d.contains(cls)) {
            return this.f6728f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }

    public <T> Set<T> d(Class<T> cls) {
        if (this.f6725c.contains(cls)) {
            return this.f6728f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }
}
