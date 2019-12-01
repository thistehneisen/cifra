package com.google.firebase.components;

import com.google.android.gms.common.internal.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public final class e<T> {

    /* renamed from: a reason: collision with root package name */
    private final Set<Class<? super T>> f6684a;

    /* renamed from: b reason: collision with root package name */
    private final Set<q> f6685b;

    /* renamed from: c reason: collision with root package name */
    private final int f6686c;

    /* renamed from: d reason: collision with root package name */
    private final int f6687d;

    /* renamed from: e reason: collision with root package name */
    private final i<T> f6688e;

    /* renamed from: f reason: collision with root package name */
    private final Set<Class<?>> f6689f;

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    public static class a<T> {

        /* renamed from: a reason: collision with root package name */
        private final Set<Class<? super T>> f6690a;

        /* renamed from: b reason: collision with root package name */
        private final Set<q> f6691b;

        /* renamed from: c reason: collision with root package name */
        private int f6692c;

        /* renamed from: d reason: collision with root package name */
        private int f6693d;

        /* renamed from: e reason: collision with root package name */
        private i<T> f6694e;

        /* renamed from: f reason: collision with root package name */
        private Set<Class<?>> f6695f;

        /* access modifiers changed from: private */
        public a<T> d() {
            this.f6693d = 1;
            return this;
        }

        public e<T> b() {
            q.b(this.f6694e != null, "Missing required property: factory.");
            e eVar = new e(new HashSet(this.f6690a), new HashSet(this.f6691b), this.f6692c, this.f6693d, this.f6694e, this.f6695f);
            return eVar;
        }

        public a<T> c() {
            a(2);
            return this;
        }

        @SafeVarargs
        private a(Class<T> cls, Class<? super T>... clsArr) {
            this.f6690a = new HashSet();
            this.f6691b = new HashSet();
            this.f6692c = 0;
            this.f6693d = 0;
            this.f6695f = new HashSet();
            String str = "Null interface";
            q.a(cls, (Object) str);
            this.f6690a.add(cls);
            for (Class<? super T> a2 : clsArr) {
                q.a(a2, (Object) str);
            }
            Collections.addAll(this.f6690a, clsArr);
        }

        public a<T> a(q qVar) {
            q.a(qVar, (Object) "Null dependency");
            a(qVar.a());
            this.f6691b.add(qVar);
            return this;
        }

        public a<T> a() {
            a(1);
            return this;
        }

        private a<T> a(int i2) {
            q.b(this.f6692c == 0, "Instantiation type has already been set.");
            this.f6692c = i2;
            return this;
        }

        private void a(Class<?> cls) {
            q.a(!this.f6690a.contains(cls), (Object) "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public a<T> a(i<T> iVar) {
            q.a(iVar, (Object) "Null factory");
            this.f6694e = iVar;
            return this;
        }
    }

    static /* synthetic */ Object a(Object obj, f fVar) {
        return obj;
    }

    static /* synthetic */ Object b(Object obj, f fVar) {
        return obj;
    }

    public Set<q> a() {
        return this.f6685b;
    }

    public i<T> b() {
        return this.f6688e;
    }

    public Set<Class<? super T>> c() {
        return this.f6684a;
    }

    public Set<Class<?>> d() {
        return this.f6689f;
    }

    public boolean e() {
        return this.f6686c == 1;
    }

    public boolean f() {
        return this.f6686c == 2;
    }

    public boolean g() {
        return this.f6687d == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Component<");
        sb.append(Arrays.toString(this.f6684a.toArray()));
        sb.append(">{");
        sb.append(this.f6686c);
        sb.append(", type=");
        sb.append(this.f6687d);
        sb.append(", deps=");
        sb.append(Arrays.toString(this.f6685b.toArray()));
        sb.append("}");
        return sb.toString();
    }

    private e(Set<Class<? super T>> set, Set<q> set2, int i2, int i3, i<T> iVar, Set<Class<?>> set3) {
        this.f6684a = Collections.unmodifiableSet(set);
        this.f6685b = Collections.unmodifiableSet(set2);
        this.f6686c = i2;
        this.f6687d = i3;
        this.f6688e = iVar;
        this.f6689f = Collections.unmodifiableSet(set3);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls, new Class[0]);
    }

    public static <T> a<T> b(Class<T> cls) {
        a<T> a2 = a(cls);
        a2.d();
        return a2;
    }

    @SafeVarargs
    public static <T> a<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr);
    }

    @SafeVarargs
    public static <T> e<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        a a2 = a(cls, clsArr);
        a2.a(b.a((Object) t));
        return a2.b();
    }

    public static <T> e<T> a(T t, Class<T> cls) {
        a b2 = b(cls);
        b2.a(c.a((Object) t));
        return b2.b();
    }
}
