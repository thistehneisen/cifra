package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.a.c;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.t;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
public final class ja {
    public static final D<String> A = new D();
    public static final D<BigDecimal> B = new E();
    public static final D<BigInteger> C = new F();
    public static final E D = a(String.class, A);
    public static final D<StringBuilder> E = new G();
    public static final E F = a(StringBuilder.class, E);
    public static final D<StringBuffer> G = new I();
    public static final E H = a(StringBuffer.class, G);
    public static final D<URL> I = new J();
    public static final E J = a(URL.class, I);
    public static final D<URI> K = new K();
    public static final E L = a(URI.class, K);
    public static final D<InetAddress> M = new L();
    public static final E N = b(InetAddress.class, M);
    public static final D<UUID> O = new M();
    public static final E P = a(UUID.class, O);
    public static final D<Currency> Q = new N().a();
    public static final E R = a(Currency.class, Q);
    public static final E S = new P();
    public static final D<Calendar> T = new Q();
    public static final E U = b(Calendar.class, GregorianCalendar.class, T);
    public static final D<Locale> V = new S();
    public static final E W = a(Locale.class, V);
    public static final D<t> X = new T();
    public static final E Y = b(t.class, X);
    public static final E Z = new V();

    /* renamed from: a reason: collision with root package name */
    public static final D<Class> f10053a = new H().a();

    /* renamed from: b reason: collision with root package name */
    public static final E f10054b = a(Class.class, f10053a);

    /* renamed from: c reason: collision with root package name */
    public static final D<BitSet> f10055c = new U().a();

    /* renamed from: d reason: collision with root package name */
    public static final E f10056d = a(BitSet.class, f10055c);

    /* renamed from: e reason: collision with root package name */
    public static final D<Boolean> f10057e = new ca();

    /* renamed from: f reason: collision with root package name */
    public static final D<Boolean> f10058f = new da();

    /* renamed from: g reason: collision with root package name */
    public static final E f10059g = a(Boolean.TYPE, Boolean.class, f10057e);

    /* renamed from: h reason: collision with root package name */
    public static final D<Number> f10060h = new ea();

    /* renamed from: i reason: collision with root package name */
    public static final E f10061i = a(Byte.TYPE, Byte.class, f10060h);

    /* renamed from: j reason: collision with root package name */
    public static final D<Number> f10062j = new fa();

    /* renamed from: k reason: collision with root package name */
    public static final E f10063k = a(Short.TYPE, Short.class, f10062j);

    /* renamed from: l reason: collision with root package name */
    public static final D<Number> f10064l = new ga();
    public static final E m = a(Integer.TYPE, Integer.class, f10064l);
    public static final D<AtomicInteger> n = new ha().a();
    public static final E o = a(AtomicInteger.class, n);
    public static final D<AtomicBoolean> p = new ia().a();
    public static final E q = a(AtomicBoolean.class, p);
    public static final D<AtomicIntegerArray> r = new C0776x().a();
    public static final E s = a(AtomicIntegerArray.class, r);
    public static final D<Number> t = new C0777y();
    public static final D<Number> u = new C0778z();
    public static final D<Number> v = new A();
    public static final D<Number> w = new B();
    public static final E x = a(Number.class, w);
    public static final D<Character> y = new C();
    public static final E z = a(Character.TYPE, Character.class, y);

    /* compiled from: TypeAdapters */
    private static final class a<T extends Enum<T>> extends D<T> {

        /* renamed from: a reason: collision with root package name */
        private final Map<String, T> f10065a = new HashMap();

        /* renamed from: b reason: collision with root package name */
        private final Map<T, String> f10066b = new HashMap();

        public a(Class<T> cls) {
            Enum[] enumArr;
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String put : cVar.alternate()) {
                            this.f10065a.put(put, enumR);
                        }
                    }
                    this.f10065a.put(name, enumR);
                    this.f10066b.put(enumR, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        public T a(b bVar) throws IOException {
            if (bVar.G() != io.intercom.com.google.gson.stream.c.NULL) {
                return (Enum) this.f10065a.get(bVar.F());
            }
            bVar.E();
            return null;
        }

        public void a(d dVar, T t) throws IOException {
            dVar.d(t == null ? null : (String) this.f10066b.get(t));
        }
    }

    public static <TT> E a(Class<TT> cls, D<TT> d2) {
        return new W(cls, d2);
    }

    public static <TT> E b(Class<TT> cls, Class<? extends TT> cls2, D<? super TT> d2) {
        return new Y(cls, cls2, d2);
    }

    public static <TT> E a(Class<TT> cls, Class<TT> cls2, D<? super TT> d2) {
        return new X(cls, cls2, d2);
    }

    public static <T1> E b(Class<T1> cls, D<T1> d2) {
        return new aa(cls, d2);
    }
}
