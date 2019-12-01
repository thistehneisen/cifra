package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.b.A;
import io.intercom.com.google.gson.b.C0779b;
import io.intercom.com.google.gson.b.q;
import io.intercom.com.google.gson.b.s;
import io.intercom.com.google.gson.b.z;
import io.intercom.com.google.gson.i;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.intercom.com.google.gson.b.a.p reason: case insensitive filesystem */
/* compiled from: ReflectiveTypeAdapterFactory */
public final class C0769p implements E {

    /* renamed from: a reason: collision with root package name */
    private final q f10083a;

    /* renamed from: b reason: collision with root package name */
    private final i f10084b;

    /* renamed from: c reason: collision with root package name */
    private final s f10085c;

    /* renamed from: d reason: collision with root package name */
    private final C0759f f10086d;

    /* renamed from: io.intercom.com.google.gson.b.a.p$a */
    /* compiled from: ReflectiveTypeAdapterFactory */
    public static final class a<T> extends D<T> {

        /* renamed from: a reason: collision with root package name */
        private final z<T> f10087a;

        /* renamed from: b reason: collision with root package name */
        private final Map<String, b> f10088b;

        a(z<T> zVar, Map<String, b> map) {
            this.f10087a = zVar;
            this.f10088b = map;
        }

        public T a(io.intercom.com.google.gson.stream.b bVar) throws IOException {
            if (bVar.G() == c.NULL) {
                bVar.E();
                return null;
            }
            T a2 = this.f10087a.a();
            try {
                bVar.b();
                while (bVar.g()) {
                    b bVar2 = (b) this.f10088b.get(bVar.D());
                    if (bVar2 != null) {
                        if (bVar2.f10091c) {
                            bVar2.a(bVar, (Object) a2);
                        }
                    }
                    bVar.H();
                }
                bVar.e();
                return a2;
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public void a(d dVar, T t) throws IOException {
            if (t == null) {
                dVar.h();
                return;
            }
            dVar.b();
            try {
                for (b bVar : this.f10088b.values()) {
                    if (bVar.a(t)) {
                        dVar.b(bVar.f10089a);
                        bVar.a(dVar, (Object) t);
                    }
                }
                dVar.d();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* renamed from: io.intercom.com.google.gson.b.a.p$b */
    /* compiled from: ReflectiveTypeAdapterFactory */
    static abstract class b {

        /* renamed from: a reason: collision with root package name */
        final String f10089a;

        /* renamed from: b reason: collision with root package name */
        final boolean f10090b;

        /* renamed from: c reason: collision with root package name */
        final boolean f10091c;

        protected b(String str, boolean z, boolean z2) {
            this.f10089a = str;
            this.f10090b = z;
            this.f10091c = z2;
        }

        /* access modifiers changed from: 0000 */
        public abstract void a(io.intercom.com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        public abstract void a(d dVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;
    }

    public C0769p(q qVar, i iVar, s sVar, C0759f fVar) {
        this.f10083a = qVar;
        this.f10084b = iVar;
        this.f10085c = sVar;
        this.f10086d = fVar;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f10085c);
    }

    static boolean a(Field field, boolean z, s sVar) {
        return !sVar.a(field.getType(), z) && !sVar.a(field, z);
    }

    private List<String> a(Field field) {
        io.intercom.com.google.gson.a.c cVar = (io.intercom.com.google.gson.a.c) field.getAnnotation(io.intercom.com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f10084b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String add : alternate) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> D<T> a(o oVar, io.intercom.com.google.gson.c.a<T> aVar) {
        Class a2 = aVar.a();
        if (!Object.class.isAssignableFrom(a2)) {
            return null;
        }
        return new a(this.f10083a.a(aVar), a(oVar, aVar, a2));
    }

    private b a(o oVar, Field field, String str, io.intercom.com.google.gson.c.a<?> aVar, boolean z, boolean z2) {
        o oVar2 = oVar;
        io.intercom.com.google.gson.c.a<?> aVar2 = aVar;
        boolean a2 = A.a((Type) aVar.a());
        Field field2 = field;
        io.intercom.com.google.gson.a.b bVar = (io.intercom.com.google.gson.a.b) field.getAnnotation(io.intercom.com.google.gson.a.b.class);
        D a3 = bVar != null ? this.f10086d.a(this.f10083a, oVar, aVar2, bVar) : null;
        boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = oVar.a(aVar2);
        }
        C0768o oVar3 = new C0768o(this, str, z, z2, field, z3, a3, oVar, aVar, a2);
        return oVar3;
    }

    private Map<String, b> a(o oVar, io.intercom.com.google.gson.c.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        io.intercom.com.google.gson.c.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = C0779b.a(aVar2.b(), cls2, field.getGenericType());
                    List a5 = a(field);
                    int size = a5.size();
                    b bVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = (String) a5.get(i3);
                        boolean z2 = i3 != 0 ? false : a2;
                        String str2 = str;
                        b bVar2 = bVar;
                        int i4 = i3;
                        int i5 = size;
                        List list = a5;
                        Field field2 = field;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str2, a(oVar, field, str2, io.intercom.com.google.gson.c.a.a(a4), z2, a3)) : bVar2;
                        i3 = i4 + 1;
                        a2 = z2;
                        a5 = list;
                        size = i5;
                        field = field2;
                    }
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b2);
                        sb.append(" declares multiple JSON fields named ");
                        sb.append(bVar3.f10089a);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = io.intercom.com.google.gson.c.a.a(C0779b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }
}
