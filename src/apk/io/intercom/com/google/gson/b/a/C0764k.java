package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.b.B;
import io.intercom.com.google.gson.b.C0779b;
import io.intercom.com.google.gson.b.q;
import io.intercom.com.google.gson.b.t;
import io.intercom.com.google.gson.b.z;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: io.intercom.com.google.gson.b.a.k reason: case insensitive filesystem */
/* compiled from: MapTypeAdapterFactory */
public final class C0764k implements E {

    /* renamed from: a reason: collision with root package name */
    private final q f10067a;

    /* renamed from: b reason: collision with root package name */
    final boolean f10068b;

    /* renamed from: io.intercom.com.google.gson.b.a.k$a */
    /* compiled from: MapTypeAdapterFactory */
    private final class a<K, V> extends D<Map<K, V>> {

        /* renamed from: a reason: collision with root package name */
        private final D<K> f10069a;

        /* renamed from: b reason: collision with root package name */
        private final D<V> f10070b;

        /* renamed from: c reason: collision with root package name */
        private final z<? extends Map<K, V>> f10071c;

        public a(o oVar, Type type, D<K> d2, Type type2, D<V> d3, z<? extends Map<K, V>> zVar) {
            this.f10069a = new C0775w(oVar, d2, type);
            this.f10070b = new C0775w(oVar, d3, type2);
            this.f10071c = zVar;
        }

        public Map<K, V> a(b bVar) throws IOException {
            c G = bVar.G();
            if (G == c.NULL) {
                bVar.E();
                return null;
            }
            Map<K, V> map = (Map) this.f10071c.a();
            String str = "duplicate key: ";
            if (G == c.BEGIN_ARRAY) {
                bVar.a();
                while (bVar.g()) {
                    bVar.a();
                    Object a2 = this.f10069a.a(bVar);
                    if (map.put(a2, this.f10070b.a(bVar)) == null) {
                        bVar.d();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(a2);
                        throw new JsonSyntaxException(sb.toString());
                    }
                }
                bVar.d();
            } else {
                bVar.b();
                while (bVar.g()) {
                    t.f10145a.a(bVar);
                    Object a3 = this.f10069a.a(bVar);
                    if (map.put(a3, this.f10070b.a(bVar)) != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(a3);
                        throw new JsonSyntaxException(sb2.toString());
                    }
                }
                bVar.e();
            }
            return map;
        }

        public void a(d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.h();
            } else if (!C0764k.this.f10068b) {
                dVar.b();
                for (Entry entry : map.entrySet()) {
                    dVar.b(String.valueOf(entry.getKey()));
                    this.f10070b.a(dVar, entry.getValue());
                }
                dVar.d();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Entry entry2 : map.entrySet()) {
                    io.intercom.com.google.gson.t a2 = this.f10069a.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= a2.h() || a2.j();
                }
                if (z) {
                    dVar.a();
                    int size = arrayList.size();
                    while (i2 < size) {
                        dVar.a();
                        B.a((io.intercom.com.google.gson.t) arrayList.get(i2), dVar);
                        this.f10070b.a(dVar, arrayList2.get(i2));
                        dVar.c();
                        i2++;
                    }
                    dVar.c();
                } else {
                    dVar.b();
                    int size2 = arrayList.size();
                    while (i2 < size2) {
                        dVar.b(a((io.intercom.com.google.gson.t) arrayList.get(i2)));
                        this.f10070b.a(dVar, arrayList2.get(i2));
                        i2++;
                    }
                    dVar.d();
                }
            }
        }

        private String a(io.intercom.com.google.gson.t tVar) {
            if (tVar.k()) {
                w g2 = tVar.g();
                if (g2.t()) {
                    return String.valueOf(g2.q());
                }
                if (g2.s()) {
                    return Boolean.toString(g2.l());
                }
                if (g2.u()) {
                    return g2.r();
                }
                throw new AssertionError();
            } else if (tVar.i()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public C0764k(q qVar, boolean z) {
        this.f10067a = qVar;
        this.f10068b = z;
    }

    public <T> D<T> a(o oVar, io.intercom.com.google.gson.c.a<T> aVar) {
        Type b2 = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b3 = C0779b.b(b2, C0779b.e(b2));
        o oVar2 = oVar;
        a aVar2 = new a(oVar2, b3[0], a(oVar, b3[0]), b3[1], oVar.a(io.intercom.com.google.gson.c.a.a(b3[1])), this.f10067a.a(aVar));
        return aVar2;
    }

    private D<?> a(o oVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return ja.f10058f;
        }
        return oVar.a(io.intercom.com.google.gson.c.a.a(type));
    }
}
