package com.bumptech.glide.load.engine.a;

import android.util.Log;
import com.bumptech.glide.h.l;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool */
public final class j implements b {

    /* renamed from: a reason: collision with root package name */
    private final h<a, Object> f3913a = new h<>();

    /* renamed from: b reason: collision with root package name */
    private final b f3914b = new b();

    /* renamed from: c reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f3915c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    private final Map<Class<?>, a<?>> f3916d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    private final int f3917e;

    /* renamed from: f reason: collision with root package name */
    private int f3918f;

    /* compiled from: LruArrayPool */
    private static final class a implements m {

        /* renamed from: a reason: collision with root package name */
        private final b f3919a;

        /* renamed from: b reason: collision with root package name */
        int f3920b;

        /* renamed from: c reason: collision with root package name */
        private Class<?> f3921c;

        a(b bVar) {
            this.f3919a = bVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, Class<?> cls) {
            this.f3920b = i2;
            this.f3921c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3920b == aVar.f3920b && this.f3921c == aVar.f3921c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f3920b * 31;
            Class<?> cls = this.f3921c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.f3920b);
            sb.append("array=");
            sb.append(this.f3921c);
            sb.append('}');
            return sb.toString();
        }

        public void a() {
            this.f3919a.a(this);
        }
    }

    /* compiled from: LruArrayPool */
    private static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: 0000 */
        public a a(int i2, Class<?> cls) {
            a aVar = (a) b();
            aVar.a(i2, cls);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public a a() {
            return new a(this);
        }
    }

    public j(int i2) {
        this.f3917e = i2;
    }

    private boolean c(int i2) {
        return i2 <= this.f3917e / 2;
    }

    public synchronized <T> T a(int i2, Class<T> cls) {
        return a(this.f3914b.a(i2, cls), cls);
    }

    public synchronized <T> T b(int i2, Class<T> cls) {
        a aVar;
        Integer num = (Integer) b(cls).ceilingKey(Integer.valueOf(i2));
        if (a(i2, num)) {
            aVar = this.f3914b.a(num.intValue(), cls);
        } else {
            aVar = this.f3914b.a(i2, cls);
        }
        return a(aVar, cls);
    }

    public synchronized <T> void put(T t) {
        Class cls = t.getClass();
        a a2 = a(cls);
        int a3 = a2.a(t);
        int a4 = a2.a() * a3;
        if (c(a4)) {
            a a5 = this.f3914b.a(a3, cls);
            this.f3913a.a(a5, t);
            NavigableMap b2 = b(cls);
            Integer num = (Integer) b2.get(Integer.valueOf(a5.f3920b));
            Integer valueOf = Integer.valueOf(a5.f3920b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            b2.put(valueOf, Integer.valueOf(i2));
            this.f3918f += a4;
            b();
        }
    }

    private boolean c() {
        int i2 = this.f3918f;
        return i2 == 0 || this.f3917e / i2 >= 2;
    }

    private <T> T a(a aVar, Class<T> cls) {
        a a2 = a(cls);
        T a3 = a(aVar);
        if (a3 != null) {
            this.f3918f -= a2.a(a3) * a2.a();
            c(a2.a(a3), cls);
        }
        if (a3 != null) {
            return a3;
        }
        if (Log.isLoggable(a2.getTag(), 2)) {
            String tag = a2.getTag();
            StringBuilder sb = new StringBuilder();
            sb.append("Allocated ");
            sb.append(aVar.f3920b);
            sb.append(" bytes");
            Log.v(tag, sb.toString());
        }
        return a2.newArray(aVar.f3920b);
    }

    private void c(int i2, Class<?> cls) {
        NavigableMap b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i2));
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(i2);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num.intValue() == 1) {
            b2.remove(Integer.valueOf(i2));
        } else {
            b2.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void b() {
        b(this.f3917e);
    }

    private void b(int i2) {
        while (this.f3918f > i2) {
            Object a2 = this.f3913a.a();
            l.a(a2);
            a a3 = a((T) a2);
            this.f3918f -= a3.a(a2) * a3.a();
            c(a3.a(a2), a2.getClass());
            if (Log.isLoggable(a3.getTag(), 2)) {
                String tag = a3.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(a3.a(a2));
                Log.v(tag, sb.toString());
            }
        }
    }

    private <T> T a(a aVar) {
        return this.f3913a.a(aVar);
    }

    private boolean a(int i2, Integer num) {
        return num != null && (c() || num.intValue() <= i2 * 8);
    }

    public synchronized void a() {
        b(0);
    }

    public synchronized void a(int i2) {
        if (i2 >= 40) {
            try {
                a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 >= 20 || i2 == 15) {
            b(this.f3917e / 2);
        }
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f3915c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f3915c.put(cls, treeMap);
        return treeMap;
    }

    private <T> a<T> a(T t) {
        return a(t.getClass());
    }

    private <T> a<T> a(Class<T> cls) {
        a<T> aVar = (a) this.f3916d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i<>();
            } else if (cls.equals(byte[].class)) {
                aVar = new g<>();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("No array pool found for: ");
                sb.append(cls.getSimpleName());
                throw new IllegalArgumentException(sb.toString());
            }
            this.f3916d.put(cls, aVar);
        }
        return aVar;
    }
}
