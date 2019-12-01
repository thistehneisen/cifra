package retrofit2;

import i.B;
import i.G;
import i.L;
import i.O;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: Retrofit */
public final class w {

    /* renamed from: a reason: collision with root package name */
    private final Map<Method, x<?, ?>> f11066a = new ConcurrentHashMap();

    /* renamed from: b reason: collision with root package name */
    final i.C0721j.a f11067b;

    /* renamed from: c reason: collision with root package name */
    final B f11068c;

    /* renamed from: d reason: collision with root package name */
    final List<retrofit2.e.a> f11069d;

    /* renamed from: e reason: collision with root package name */
    final List<retrofit2.c.a> f11070e;

    /* renamed from: f reason: collision with root package name */
    final Executor f11071f;

    /* renamed from: g reason: collision with root package name */
    final boolean f11072g;

    /* compiled from: Retrofit */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final s f11073a;

        /* renamed from: b reason: collision with root package name */
        private i.C0721j.a f11074b;

        /* renamed from: c reason: collision with root package name */
        private B f11075c;

        /* renamed from: d reason: collision with root package name */
        private final List<retrofit2.e.a> f11076d;

        /* renamed from: e reason: collision with root package name */
        private final List<retrofit2.c.a> f11077e;

        /* renamed from: f reason: collision with root package name */
        private Executor f11078f;

        /* renamed from: g reason: collision with root package name */
        private boolean f11079g;

        a(s sVar) {
            this.f11076d = new ArrayList();
            this.f11077e = new ArrayList();
            this.f11073a = sVar;
        }

        public a a(G g2) {
            y.a(g2, "client == null");
            a((i.C0721j.a) g2);
            return this;
        }

        public a a(i.C0721j.a aVar) {
            y.a(aVar, "factory == null");
            this.f11074b = aVar;
            return this;
        }

        public a a(String str) {
            y.a(str, "baseUrl == null");
            B d2 = B.d(str);
            if (d2 != null) {
                a(d2);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal URL: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }

        public a() {
            this(s.b());
        }

        public a a(B b2) {
            y.a(b2, "baseUrl == null");
            List j2 = b2.j();
            if ("".equals(j2.get(j2.size() - 1))) {
                this.f11075c = b2;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("baseUrl must end in /: ");
            sb.append(b2);
            throw new IllegalArgumentException(sb.toString());
        }

        public a a(retrofit2.e.a aVar) {
            List<retrofit2.e.a> list = this.f11076d;
            y.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public a a(retrofit2.c.a aVar) {
            List<retrofit2.c.a> list = this.f11077e;
            y.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public w a() {
            if (this.f11075c != null) {
                i.C0721j.a aVar = this.f11074b;
                if (aVar == null) {
                    aVar = new G();
                }
                i.C0721j.a aVar2 = aVar;
                Executor executor = this.f11078f;
                if (executor == null) {
                    executor = this.f11073a.a();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f11077e);
                arrayList.add(this.f11073a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f11076d.size() + 1);
                arrayList2.add(new a());
                arrayList2.addAll(this.f11076d);
                w wVar = new w(aVar2, this.f11075c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f11079g);
                return wVar;
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    w(i.C0721j.a aVar, B b2, List<retrofit2.e.a> list, List<retrofit2.c.a> list2, Executor executor, boolean z) {
        this.f11067b = aVar;
        this.f11068c = b2;
        this.f11069d = list;
        this.f11070e = list2;
        this.f11071f = executor;
        this.f11072g = z;
    }

    private void b(Class<?> cls) {
        Method[] declaredMethods;
        s b2 = s.b();
        for (Method method : cls.getDeclaredMethods()) {
            if (!b2.a(method)) {
                a(method);
            }
        }
    }

    public <T> T a(Class<T> cls) {
        y.a(cls);
        if (this.f11072g) {
            b(cls);
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new v(this, cls));
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        y.a(type, "type == null");
        y.a(annotationArr, "annotations == null");
        int size = this.f11069d.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<T, String> b2 = ((retrofit2.e.a) this.f11069d.get(i2)).b(type, annotationArr, this);
            if (b2 != null) {
                return b2;
            }
        }
        return d.f10965a;
    }

    /* access modifiers changed from: 0000 */
    public x<?, ?> a(Method method) {
        x<?, ?> xVar;
        x<?, ?> xVar2 = (x) this.f11066a.get(method);
        if (xVar2 != null) {
            return xVar2;
        }
        synchronized (this.f11066a) {
            xVar = (x) this.f11066a.get(method);
            if (xVar == null) {
                xVar = new a(this, method).a();
                this.f11066a.put(method, xVar);
            }
        }
        return xVar;
    }

    public i.C0721j.a b() {
        return this.f11067b;
    }

    public <T> e<O, T> b(Type type, Annotation[] annotationArr) {
        return a((retrofit2.e.a) null, type, annotationArr);
    }

    public B a() {
        return this.f11068c;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((retrofit2.c.a) null, type, annotationArr);
    }

    public c<?, ?> a(retrofit2.c.a aVar, Type type, Annotation[] annotationArr) {
        y.a(type, "returnType == null");
        y.a(annotationArr, "annotations == null");
        int indexOf = this.f11070e.indexOf(aVar) + 1;
        int size = this.f11070e.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            c<?, ?> a2 = ((retrofit2.c.a) this.f11070e.get(i2)).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append(str);
                sb.append(((retrofit2.c.a) this.f11070e.get(i3)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f11070e.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((retrofit2.c.a) this.f11070e.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> e<T, L> a(retrofit2.e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        y.a(type, "type == null");
        y.a(annotationArr, "parameterAnnotations == null");
        y.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f11069d.indexOf(aVar) + 1;
        int size = this.f11069d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<T, L> a2 = ((retrofit2.e.a) this.f11069d.get(i2)).a(type, annotationArr, annotationArr2, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append(str);
                sb.append(((retrofit2.e.a) this.f11069d.get(i3)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f11069d.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((retrofit2.e.a) this.f11069d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<O, T> a(retrofit2.e.a aVar, Type type, Annotation[] annotationArr) {
        y.a(type, "type == null");
        y.a(annotationArr, "annotations == null");
        int indexOf = this.f11069d.indexOf(aVar) + 1;
        int size = this.f11069d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<O, T> a2 = ((retrofit2.e.a) this.f11069d.get(i2)).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append(str);
                sb.append(((retrofit2.e.a) this.f11069d.get(i3)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f11069d.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((retrofit2.e.a) this.f11069d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
