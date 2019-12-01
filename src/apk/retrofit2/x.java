package retrofit2;

import i.A;
import i.B;
import i.C0721j;
import i.D;
import i.E;
import i.M;
import i.O;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.a.b;
import retrofit2.a.c;
import retrofit2.a.d;
import retrofit2.a.e;
import retrofit2.a.f;
import retrofit2.a.g;
import retrofit2.a.h;
import retrofit2.a.i;
import retrofit2.a.j;
import retrofit2.a.k;
import retrofit2.a.l;
import retrofit2.a.m;
import retrofit2.a.n;
import retrofit2.a.o;
import retrofit2.a.p;
import retrofit2.a.q;
import retrofit2.a.r;
import retrofit2.a.s;

/* compiled from: ServiceMethod */
final class x<R, T> {

    /* renamed from: a reason: collision with root package name */
    static final Pattern f11080a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: b reason: collision with root package name */
    static final Pattern f11081b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: c reason: collision with root package name */
    private final i.C0721j.a f11082c;

    /* renamed from: d reason: collision with root package name */
    private final c<R, T> f11083d;

    /* renamed from: e reason: collision with root package name */
    private final B f11084e;

    /* renamed from: f reason: collision with root package name */
    private final e<O, R> f11085f;

    /* renamed from: g reason: collision with root package name */
    private final String f11086g;

    /* renamed from: h reason: collision with root package name */
    private final String f11087h;

    /* renamed from: i reason: collision with root package name */
    private final A f11088i;

    /* renamed from: j reason: collision with root package name */
    private final D f11089j;

    /* renamed from: k reason: collision with root package name */
    private final boolean f11090k;

    /* renamed from: l reason: collision with root package name */
    private final boolean f11091l;
    private final boolean m;
    private final r<?>[] n;

    /* compiled from: ServiceMethod */
    static final class a<T, R> {

        /* renamed from: a reason: collision with root package name */
        final w f11092a;

        /* renamed from: b reason: collision with root package name */
        final Method f11093b;

        /* renamed from: c reason: collision with root package name */
        final Annotation[] f11094c;

        /* renamed from: d reason: collision with root package name */
        final Annotation[][] f11095d;

        /* renamed from: e reason: collision with root package name */
        final Type[] f11096e;

        /* renamed from: f reason: collision with root package name */
        Type f11097f;

        /* renamed from: g reason: collision with root package name */
        boolean f11098g;

        /* renamed from: h reason: collision with root package name */
        boolean f11099h;

        /* renamed from: i reason: collision with root package name */
        boolean f11100i;

        /* renamed from: j reason: collision with root package name */
        boolean f11101j;

        /* renamed from: k reason: collision with root package name */
        boolean f11102k;

        /* renamed from: l reason: collision with root package name */
        boolean f11103l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        A r;
        D s;
        Set<String> t;
        r<?>[] u;
        e<O, T> v;
        c<T, R> w;

        a(w wVar, Method method) {
            this.f11092a = wVar;
            this.f11093b = method;
            this.f11094c = method.getAnnotations();
            this.f11096e = method.getGenericParameterTypes();
            this.f11095d = method.getParameterAnnotations();
        }

        private c<T, R> b() {
            Type genericReturnType = this.f11093b.getGenericReturnType();
            if (y.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    return this.f11092a.a(genericReturnType, this.f11093b.getAnnotations());
                } catch (RuntimeException e2) {
                    throw a((Throwable) e2, "Unable to create call adapter for %s", genericReturnType);
                }
            } else {
                throw a("Service methods cannot return void.", new Object[0]);
            }
        }

        private e<O, T> c() {
            try {
                return this.f11092a.b(this.f11097f, this.f11093b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a((Throwable) e2, "Unable to create converter for %s", this.f11097f);
            }
        }

        public x a() {
            this.w = b();
            this.f11097f = this.w.responseType();
            Type type = this.f11097f;
            if (type == u.class || type == M.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(y.c(this.f11097f).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw a(sb.toString(), new Object[0]);
            }
            this.v = c();
            for (Annotation a2 : this.f11094c) {
                a(a2);
            }
            if (this.m != null) {
                if (!this.n) {
                    if (this.p) {
                        throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.o) {
                        throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f11095d.length;
                this.u = new r[length];
                int i2 = 0;
                while (i2 < length) {
                    Type type2 = this.f11096e[i2];
                    if (!y.d(type2)) {
                        Annotation[] annotationArr = this.f11095d[i2];
                        if (annotationArr != null) {
                            this.u[i2] = a(i2, type2, annotationArr);
                            i2++;
                        } else {
                            throw a(i2, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                    }
                }
                if (this.q == null && !this.f11103l) {
                    throw a("Missing either @%s URL or @Url parameter.", this.m);
                } else if (!this.o && !this.p && !this.n && this.f11100i) {
                    throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.o && !this.f11098g) {
                    throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.p || this.f11099h) {
                    return new x(this);
                } else {
                    throw a("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private void a(Annotation annotation) {
            if (annotation instanceof b) {
                a("DELETE", ((b) annotation).value(), false);
            } else if (annotation instanceof e) {
                a("GET", ((e) annotation).value(), false);
            } else if (annotation instanceof f) {
                a("HEAD", ((f) annotation).value(), false);
                if (!Void.class.equals(this.f11097f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof k) {
                a("PATCH", ((k) annotation).value(), true);
            } else if (annotation instanceof l) {
                a("POST", ((l) annotation).value(), true);
            } else if (annotation instanceof m) {
                a("PUT", ((m) annotation).value(), true);
            } else if (annotation instanceof j) {
                a("OPTIONS", ((j) annotation).value(), false);
            } else if (annotation instanceof g) {
                g gVar = (g) annotation;
                a(gVar.method(), gVar.path(), gVar.hasBody());
            } else if (annotation instanceof i) {
                String[] value = ((i) annotation).value();
                if (value.length != 0) {
                    this.r = a(value);
                } else {
                    throw a("@Headers annotation is empty.", new Object[0]);
                }
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.m;
            if (str3 == null) {
                this.m = str;
                this.n = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (x.f11080a.matcher(substring).find()) {
                            throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.q = str2;
                    this.t = x.a(str2);
                    return;
                }
                return;
            }
            throw a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private A a(String[] strArr) {
            i.A.a aVar = new i.A.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    D b2 = D.b(trim);
                    if (b2 != null) {
                        this.s = b2;
                    } else {
                        throw a("Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        private r<?> a(int i2, Type type, Annotation[] annotationArr) {
            r<?> rVar = null;
            for (Annotation a2 : annotationArr) {
                r<?> a3 = a(i2, type, annotationArr, a2);
                if (a3 != null) {
                    if (rVar == null) {
                        rVar = a3;
                    } else {
                        throw a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (rVar != null) {
                return rVar;
            }
            throw a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        private r<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (!(annotation instanceof p)) {
                String str = "<String>)";
                String str2 = " must include generic type (e.g., ";
                if (annotation instanceof q) {
                    q qVar = (q) annotation;
                    String value = qVar.value();
                    boolean encoded = qVar.encoded();
                    Class c2 = y.c(type);
                    this.f11102k = true;
                    if (Iterable.class.isAssignableFrom(c2)) {
                        if (type instanceof ParameterizedType) {
                            return new h(value, this.f11092a.c(y.a(0, (ParameterizedType) type), annotationArr), encoded).b();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(c2.getSimpleName());
                        sb.append(str2);
                        sb.append(c2.getSimpleName());
                        sb.append(str);
                        throw a(i2, sb.toString(), new Object[0]);
                    } else if (!c2.isArray()) {
                        return new h(value, this.f11092a.c(type, annotationArr), encoded);
                    } else {
                        return new h(value, this.f11092a.c(x.a(c2.getComponentType()), annotationArr), encoded).a();
                    }
                } else if (annotation instanceof s) {
                    boolean encoded2 = ((s) annotation).encoded();
                    Class c3 = y.c(type);
                    this.f11102k = true;
                    if (Iterable.class.isAssignableFrom(c3)) {
                        if (type instanceof ParameterizedType) {
                            return new j(this.f11092a.c(y.a(0, (ParameterizedType) type), annotationArr), encoded2).b();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c3.getSimpleName());
                        sb2.append(str2);
                        sb2.append(c3.getSimpleName());
                        sb2.append(str);
                        throw a(i2, sb2.toString(), new Object[0]);
                    } else if (!c3.isArray()) {
                        return new j(this.f11092a.c(type, annotationArr), encoded2);
                    } else {
                        return new j(this.f11092a.c(x.a(c3.getComponentType()), annotationArr), encoded2).a();
                    }
                } else {
                    String str3 = "Map must include generic types (e.g., Map<String, String>)";
                    if (annotation instanceof r) {
                        Class c4 = y.c(type);
                        if (Map.class.isAssignableFrom(c4)) {
                            Type b2 = y.b(type, c4, Map.class);
                            if (b2 instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) b2;
                                Type a2 = y.a(0, parameterizedType);
                                if (String.class == a2) {
                                    return new i(this.f11092a.c(y.a(1, parameterizedType), annotationArr), ((r) annotation).encoded());
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("@QueryMap keys must be of type String: ");
                                sb3.append(a2);
                                throw a(i2, sb3.toString(), new Object[0]);
                            }
                            throw a(i2, str3, new Object[0]);
                        }
                        throw a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
                    } else if (annotation instanceof h) {
                        String value2 = ((h) annotation).value();
                        Class c5 = y.c(type);
                        if (Iterable.class.isAssignableFrom(c5)) {
                            if (type instanceof ParameterizedType) {
                                return new d(value2, this.f11092a.c(y.a(0, (ParameterizedType) type), annotationArr)).b();
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(c5.getSimpleName());
                            sb4.append(str2);
                            sb4.append(c5.getSimpleName());
                            sb4.append(str);
                            throw a(i2, sb4.toString(), new Object[0]);
                        } else if (!c5.isArray()) {
                            return new d(value2, this.f11092a.c(type, annotationArr));
                        } else {
                            return new d(value2, this.f11092a.c(x.a(c5.getComponentType()), annotationArr)).a();
                        }
                    } else if (annotation instanceof c) {
                        if (this.o) {
                            c cVar = (c) annotation;
                            String value3 = cVar.value();
                            boolean encoded3 = cVar.encoded();
                            this.f11098g = true;
                            Class c6 = y.c(type);
                            if (Iterable.class.isAssignableFrom(c6)) {
                                if (type instanceof ParameterizedType) {
                                    return new b(value3, this.f11092a.c(y.a(0, (ParameterizedType) type), annotationArr), encoded3).b();
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(c6.getSimpleName());
                                sb5.append(str2);
                                sb5.append(c6.getSimpleName());
                                sb5.append(str);
                                throw a(i2, sb5.toString(), new Object[0]);
                            } else if (!c6.isArray()) {
                                return new b(value3, this.f11092a.c(type, annotationArr), encoded3);
                            } else {
                                return new b(value3, this.f11092a.c(x.a(c6.getComponentType()), annotationArr), encoded3).a();
                            }
                        } else {
                            throw a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                        }
                    } else if (annotation instanceof d) {
                        if (this.o) {
                            Class c7 = y.c(type);
                            if (Map.class.isAssignableFrom(c7)) {
                                Type b3 = y.b(type, c7, Map.class);
                                if (b3 instanceof ParameterizedType) {
                                    ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                                    Type a3 = y.a(0, parameterizedType2);
                                    if (String.class == a3) {
                                        e c8 = this.f11092a.c(y.a(1, parameterizedType2), annotationArr);
                                        this.f11098g = true;
                                        return new c(c8, ((d) annotation).encoded());
                                    }
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("@FieldMap keys must be of type String: ");
                                    sb6.append(a3);
                                    throw a(i2, sb6.toString(), new Object[0]);
                                }
                                throw a(i2, str3, new Object[0]);
                            }
                            throw a(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                        }
                        throw a(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                    } else if (annotation instanceof n) {
                        if (this.p) {
                            n nVar = (n) annotation;
                            this.f11099h = true;
                            String value4 = nVar.value();
                            Class c9 = y.c(type);
                            if (value4.isEmpty()) {
                                String str4 = "@Part annotation must supply a name or use MultipartBody.Part parameter type.";
                                if (Iterable.class.isAssignableFrom(c9)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(c9.getSimpleName());
                                        sb7.append(str2);
                                        sb7.append(c9.getSimpleName());
                                        sb7.append(str);
                                        throw a(i2, sb7.toString(), new Object[0]);
                                    } else if (E.b.class.isAssignableFrom(y.c(y.a(0, (ParameterizedType) type)))) {
                                        return k.f11044a.b();
                                    } else {
                                        throw a(i2, str4, new Object[0]);
                                    }
                                } else if (c9.isArray()) {
                                    if (E.b.class.isAssignableFrom(c9.getComponentType())) {
                                        return k.f11044a.a();
                                    }
                                    throw a(i2, str4, new Object[0]);
                                } else if (E.b.class.isAssignableFrom(c9)) {
                                    return k.f11044a;
                                } else {
                                    throw a(i2, str4, new Object[0]);
                                }
                            } else {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("form-data; name=\"");
                                sb8.append(value4);
                                sb8.append("\"");
                                A a4 = A.a("Content-Disposition", sb8.toString(), "Content-Transfer-Encoding", nVar.encoding());
                                String str5 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.";
                                if (Iterable.class.isAssignableFrom(c9)) {
                                    if (type instanceof ParameterizedType) {
                                        Type a5 = y.a(0, (ParameterizedType) type);
                                        if (!E.b.class.isAssignableFrom(y.c(a5))) {
                                            return new e(a4, this.f11092a.a(a5, annotationArr, this.f11094c)).b();
                                        }
                                        throw a(i2, str5, new Object[0]);
                                    }
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append(c9.getSimpleName());
                                    sb9.append(str2);
                                    sb9.append(c9.getSimpleName());
                                    sb9.append(str);
                                    throw a(i2, sb9.toString(), new Object[0]);
                                } else if (c9.isArray()) {
                                    Class a6 = x.a(c9.getComponentType());
                                    if (!E.b.class.isAssignableFrom(a6)) {
                                        return new e(a4, this.f11092a.a((Type) a6, annotationArr, this.f11094c)).a();
                                    }
                                    throw a(i2, str5, new Object[0]);
                                } else if (!E.b.class.isAssignableFrom(c9)) {
                                    return new e(a4, this.f11092a.a(type, annotationArr, this.f11094c));
                                } else {
                                    throw a(i2, str5, new Object[0]);
                                }
                            }
                        } else {
                            throw a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                        }
                    } else if (annotation instanceof o) {
                        if (this.p) {
                            this.f11099h = true;
                            Class c10 = y.c(type);
                            if (Map.class.isAssignableFrom(c10)) {
                                Type b4 = y.b(type, c10, Map.class);
                                if (b4 instanceof ParameterizedType) {
                                    ParameterizedType parameterizedType3 = (ParameterizedType) b4;
                                    Type a7 = y.a(0, parameterizedType3);
                                    if (String.class == a7) {
                                        Type a8 = y.a(1, parameterizedType3);
                                        if (!E.b.class.isAssignableFrom(y.c(a8))) {
                                            return new f(this.f11092a.a(a8, annotationArr, this.f11094c), ((o) annotation).encoding());
                                        }
                                        throw a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                    }
                                    StringBuilder sb10 = new StringBuilder();
                                    sb10.append("@PartMap keys must be of type String: ");
                                    sb10.append(a7);
                                    throw a(i2, sb10.toString(), new Object[0]);
                                }
                                throw a(i2, str3, new Object[0]);
                            }
                            throw a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                        }
                        throw a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                    } else if (!(annotation instanceof retrofit2.a.a)) {
                        return null;
                    } else {
                        if (this.o || this.p) {
                            throw a(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                        } else if (!this.f11100i) {
                            try {
                                e a9 = this.f11092a.a(type, annotationArr, this.f11094c);
                                this.f11100i = true;
                                return new a(a9);
                            } catch (RuntimeException e2) {
                                throw a((Throwable) e2, i2, "Unable to create @Body converter for %s", type);
                            }
                        } else {
                            throw a(i2, "Multiple @Body method annotations found.", new Object[0]);
                        }
                    }
                }
            } else if (this.f11102k) {
                throw a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (this.f11103l) {
                throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
            } else if (this.q != null) {
                this.f11101j = true;
                p pVar = (p) annotation;
                String value5 = pVar.value();
                a(i2, value5);
                return new g(value5, this.f11092a.c(type, annotationArr), pVar.encoded());
            } else {
                throw a(i2, "@Path can only be used with relative url on @%s", this.m);
            }
        }

        private void a(int i2, String str) {
            if (!x.f11081b.matcher(str).matches()) {
                throw a(i2, "@Path parameter name must match %s. Found: %s", x.f11080a.pattern(), str);
            } else if (!this.t.contains(str)) {
                throw a(i2, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
            }
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("\n    for method ");
            sb.append(this.f11093b.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.f11093b.getName());
            return new IllegalArgumentException(sb.toString(), th);
        }

        private RuntimeException a(Throwable th, int i2, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i2 + 1);
            sb.append(")");
            return a(th, sb.toString(), objArr);
        }

        private RuntimeException a(int i2, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i2 + 1);
            sb.append(")");
            return a(sb.toString(), objArr);
        }
    }

    x(a<R, T> aVar) {
        this.f11082c = aVar.f11092a.b();
        this.f11083d = aVar.w;
        this.f11084e = aVar.f11092a.a();
        this.f11085f = aVar.v;
        this.f11086g = aVar.m;
        this.f11087h = aVar.q;
        this.f11088i = aVar.r;
        this.f11089j = aVar.s;
        this.f11090k = aVar.n;
        this.f11091l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.u;
    }

    /* access modifiers changed from: 0000 */
    public C0721j a(Object... objArr) throws IOException {
        t tVar = new t(this.f11086g, this.f11084e, this.f11087h, this.f11088i, this.f11089j, this.f11090k, this.f11091l, this.m);
        r<?>[] rVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length == rVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                rVarArr[i2].a(tVar, objArr[i2]);
            }
            return this.f11082c.a(tVar.a());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(rVarArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public T a(b<R> bVar) {
        return this.f11083d.a(bVar);
    }

    /* access modifiers changed from: 0000 */
    public R a(O o) throws IOException {
        return this.f11085f.convert(o);
    }

    static Set<String> a(String str) {
        Matcher matcher = f11080a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    static Class<?> a(Class cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            cls = Short.class;
        }
        return cls;
    }
}
