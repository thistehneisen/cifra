package io.intercom.com.google.gson;

import io.intercom.com.google.gson.b.A;
import io.intercom.com.google.gson.b.B;
import io.intercom.com.google.gson.b.a.C0755b;
import io.intercom.com.google.gson.b.a.C0756c;
import io.intercom.com.google.gson.b.a.C0758e;
import io.intercom.com.google.gson.b.a.C0759f;
import io.intercom.com.google.gson.b.a.C0764k;
import io.intercom.com.google.gson.b.a.C0767n;
import io.intercom.com.google.gson.b.a.C0769p;
import io.intercom.com.google.gson.b.a.C0772t;
import io.intercom.com.google.gson.b.a.ja;
import io.intercom.com.google.gson.b.a.r;
import io.intercom.com.google.gson.b.q;
import io.intercom.com.google.gson.b.s;
import io.intercom.com.google.gson.stream.MalformedJsonException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class o {

    /* renamed from: a reason: collision with root package name */
    private static final io.intercom.com.google.gson.c.a<?> f10176a = io.intercom.com.google.gson.c.a.a(Object.class);

    /* renamed from: b reason: collision with root package name */
    private final ThreadLocal<Map<io.intercom.com.google.gson.c.a<?>, a<?>>> f10177b;

    /* renamed from: c reason: collision with root package name */
    private final Map<io.intercom.com.google.gson.c.a<?>, D<?>> f10178c;

    /* renamed from: d reason: collision with root package name */
    private final List<E> f10179d;

    /* renamed from: e reason: collision with root package name */
    private final q f10180e;

    /* renamed from: f reason: collision with root package name */
    private final s f10181f;

    /* renamed from: g reason: collision with root package name */
    private final i f10182g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f10183h;

    /* renamed from: i reason: collision with root package name */
    private final boolean f10184i;

    /* renamed from: j reason: collision with root package name */
    private final boolean f10185j;

    /* renamed from: k reason: collision with root package name */
    private final boolean f10186k;

    /* renamed from: l reason: collision with root package name */
    private final boolean f10187l;
    private final C0759f m;

    /* compiled from: Gson */
    static class a<T> extends D<T> {

        /* renamed from: a reason: collision with root package name */
        private D<T> f10188a;

        a() {
        }

        public void a(D<T> d2) {
            if (this.f10188a == null) {
                this.f10188a = d2;
                return;
            }
            throw new AssertionError();
        }

        public T a(b bVar) throws IOException {
            D<T> d2 = this.f10188a;
            if (d2 != null) {
                return d2.a(bVar);
            }
            throw new IllegalStateException();
        }

        public void a(d dVar, T t) throws IOException {
            D<T> d2 = this.f10188a;
            if (d2 != null) {
                d2.a(dVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public o() {
        this(s.f10138a, h.f10166a, Collections.emptyMap(), false, false, false, true, false, false, false, B.DEFAULT, Collections.emptyList());
    }

    private D<Number> a(boolean z) {
        if (z) {
            return ja.v;
        }
        return new j(this);
    }

    private D<Number> b(boolean z) {
        if (z) {
            return ja.u;
        }
        return new k(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{serializeNulls:");
        sb.append(this.f10183h);
        sb.append(",factories:");
        sb.append(this.f10179d);
        sb.append(",instanceCreators:");
        sb.append(this.f10180e);
        sb.append("}");
        return sb.toString();
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(d2);
            sb.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static D<AtomicLongArray> b(D<Number> d2) {
        return new n(d2).a();
    }

    o(s sVar, i iVar, Map<Type, p<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, B b2, List<E> list) {
        this.f10177b = new ThreadLocal<>();
        this.f10178c = new ConcurrentHashMap();
        this.f10180e = new q(map);
        this.f10181f = sVar;
        this.f10182g = iVar;
        this.f10183h = z;
        this.f10185j = z3;
        this.f10184i = z4;
        this.f10186k = z5;
        this.f10187l = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ja.Y);
        arrayList.add(C0767n.f10074a);
        arrayList.add(sVar);
        arrayList.addAll(list);
        arrayList.add(ja.D);
        arrayList.add(ja.m);
        arrayList.add(ja.f10059g);
        arrayList.add(ja.f10061i);
        arrayList.add(ja.f10063k);
        D a2 = a(b2);
        arrayList.add(ja.a(Long.TYPE, Long.class, a2));
        arrayList.add(ja.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(ja.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(ja.x);
        arrayList.add(ja.o);
        arrayList.add(ja.q);
        arrayList.add(ja.a(AtomicLong.class, a(a2)));
        arrayList.add(ja.a(AtomicLongArray.class, b(a2)));
        arrayList.add(ja.s);
        arrayList.add(ja.z);
        arrayList.add(ja.F);
        arrayList.add(ja.H);
        arrayList.add(ja.a(BigDecimal.class, ja.B));
        arrayList.add(ja.a(BigInteger.class, ja.C));
        arrayList.add(ja.J);
        arrayList.add(ja.L);
        arrayList.add(ja.P);
        arrayList.add(ja.R);
        arrayList.add(ja.W);
        arrayList.add(ja.N);
        arrayList.add(ja.f10056d);
        arrayList.add(C0758e.f10048a);
        arrayList.add(ja.U);
        arrayList.add(C0772t.f10094a);
        arrayList.add(r.f10092a);
        arrayList.add(ja.S);
        arrayList.add(C0755b.f10041a);
        arrayList.add(ja.f10054b);
        arrayList.add(new C0756c(this.f10180e));
        arrayList.add(new C0764k(this.f10180e, z2));
        this.m = new C0759f(this.f10180e);
        arrayList.add(this.m);
        arrayList.add(ja.Z);
        arrayList.add(new C0769p(this.f10180e, iVar, sVar, this.m));
        this.f10179d = Collections.unmodifiableList(arrayList);
    }

    private static D<Number> a(B b2) {
        if (b2 == B.DEFAULT) {
            return ja.t;
        }
        return new l();
    }

    private static D<AtomicLong> a(D<Number> d2) {
        return new m(d2).a();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=io.intercom.com.google.gson.c.a<T>, code=io.intercom.com.google.gson.c.a, for r6v0, types: [io.intercom.com.google.gson.c.a<T>, io.intercom.com.google.gson.c.a, java.lang.Object] */
    public <T> D<T> a(io.intercom.com.google.gson.c.a aVar) {
        D<T> d2 = (D) this.f10178c.get(aVar == null ? f10176a : aVar);
        if (d2 != null) {
            return d2;
        }
        Map map = (Map) this.f10177b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap();
            this.f10177b.set(map);
            z = true;
        }
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a aVar3 = new a();
            map.put(aVar, aVar3);
            for (E a2 : this.f10179d) {
                D<T> a3 = a2.a(this, aVar);
                if (a3 != null) {
                    aVar3.a(a3);
                    this.f10178c.put(aVar, a3);
                    return a3;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("GSON cannot handle ");
            sb.append(aVar);
            throw new IllegalArgumentException(sb.toString());
        } finally {
            map.remove(aVar);
            if (z) {
                this.f10177b.remove();
            }
        }
    }

    public <T> D<T> a(E e2, io.intercom.com.google.gson.c.a<T> aVar) {
        if (!this.f10179d.contains(e2)) {
            e2 = this.m;
        }
        boolean z = false;
        for (E e3 : this.f10179d) {
            if (z) {
                D<T> a2 = e3.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (e3 == e2) {
                z = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("GSON cannot serialize ");
        sb.append(aVar);
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> D<T> a(Class<T> cls) {
        return a(io.intercom.com.google.gson.c.a.a(cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((t) u.f10224a);
        }
        return a(obj, (Type) obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            a(obj, (Type) obj.getClass(), appendable);
        } else {
            a((t) u.f10224a, appendable);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, a(B.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public void a(Object obj, Type type, d dVar) throws JsonIOException {
        D a2 = a(io.intercom.com.google.gson.c.a.a(type));
        boolean g2 = dVar.g();
        dVar.b(true);
        boolean f2 = dVar.f();
        dVar.a(this.f10184i);
        boolean e2 = dVar.e();
        dVar.c(this.f10183h);
        try {
            a2.a(dVar, obj);
            dVar.b(g2);
            dVar.a(f2);
            dVar.c(e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (Throwable th) {
            dVar.b(g2);
            dVar.a(f2);
            dVar.c(e2);
            throw th;
        }
    }

    public String a(t tVar) {
        StringWriter stringWriter = new StringWriter();
        a(tVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(t tVar, Appendable appendable) throws JsonIOException {
        try {
            a(tVar, a(B.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public d a(Writer writer) throws IOException {
        if (this.f10185j) {
            writer.write(")]}'\n");
        }
        d dVar = new d(writer);
        if (this.f10186k) {
            dVar.c("  ");
        }
        dVar.c(this.f10183h);
        return dVar;
    }

    public b a(Reader reader) {
        b bVar = new b(reader);
        bVar.a(this.f10187l);
        return bVar;
    }

    public void a(t tVar, d dVar) throws JsonIOException {
        boolean g2 = dVar.g();
        dVar.b(true);
        boolean f2 = dVar.f();
        dVar.a(this.f10184i);
        boolean e2 = dVar.e();
        dVar.c(this.f10183h);
        try {
            B.a(tVar, dVar);
            dVar.b(g2);
            dVar.a(f2);
            dVar.c(e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (Throwable th) {
            dVar.b(g2);
            dVar.a(f2);
            dVar.c(e2);
            throw th;
        }
    }

    public <T> T a(String str, Class<T> cls) throws JsonSyntaxException {
        return A.a(cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        b a2 = a(reader);
        Object a3 = a(a2, (Type) cls);
        a(a3, a2);
        return A.a(cls).cast(a3);
    }

    public <T> T a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        b a2 = a(reader);
        T a3 = a(a2, type);
        a((Object) a3, a2);
        return a3;
    }

    private static void a(Object obj, b bVar) {
        if (obj != null) {
            try {
                if (bVar.G() != c.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IOException e3) {
                throw new JsonIOException((Throwable) e3);
            }
        }
    }

    public <T> T a(b bVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean h2 = bVar.h();
        bVar.a(true);
        try {
            bVar.G();
            T a2 = a(io.intercom.com.google.gson.c.a.a(type)).a(bVar);
            bVar.a(h2);
            return a2;
        } catch (EOFException e2) {
            if (1 != 0) {
                bVar.a(h2);
                return null;
            }
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        } catch (IOException e4) {
            throw new JsonSyntaxException((Throwable) e4);
        } catch (Throwable th) {
            bVar.a(h2);
            throw th;
        }
    }
}
