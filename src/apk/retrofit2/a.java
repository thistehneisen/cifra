package retrofit2;

import i.L;
import i.O;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.a.t;

/* compiled from: BuiltInConverters */
final class a extends retrofit2.e.a {

    /* renamed from: retrofit2.a$a reason: collision with other inner class name */
    /* compiled from: BuiltInConverters */
    static final class C0128a implements e<O, O> {

        /* renamed from: a reason: collision with root package name */
        static final C0128a f10962a = new C0128a();

        C0128a() {
        }

        /* renamed from: a */
        public O convert(O o) throws IOException {
            try {
                return y.a(o);
            } finally {
                o.close();
            }
        }
    }

    /* compiled from: BuiltInConverters */
    static final class b implements e<L, L> {

        /* renamed from: a reason: collision with root package name */
        static final b f10963a = new b();

        b() {
        }

        public L a(L l2) {
            return l2;
        }

        public /* bridge */ /* synthetic */ Object convert(Object obj) throws IOException {
            L l2 = (L) obj;
            a(l2);
            return l2;
        }
    }

    /* compiled from: BuiltInConverters */
    static final class c implements e<O, O> {

        /* renamed from: a reason: collision with root package name */
        static final c f10964a = new c();

        c() {
        }

        public O a(O o) {
            return o;
        }

        public /* bridge */ /* synthetic */ Object convert(Object obj) throws IOException {
            O o = (O) obj;
            a(o);
            return o;
        }
    }

    /* compiled from: BuiltInConverters */
    static final class d implements e<Object, String> {

        /* renamed from: a reason: collision with root package name */
        static final d f10965a = new d();

        d() {
        }

        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters */
    static final class e implements e<O, Void> {

        /* renamed from: a reason: collision with root package name */
        static final e f10966a = new e();

        e() {
        }

        /* renamed from: a */
        public Void convert(O o) {
            o.close();
            return null;
        }
    }

    a() {
    }

    public e<O, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        e<O, ?> eVar;
        if (type == O.class) {
            if (y.a(annotationArr, t.class)) {
                eVar = c.f10964a;
            } else {
                eVar = C0128a.f10962a;
            }
            return eVar;
        } else if (type == Void.class) {
            return e.f10966a;
        } else {
            return null;
        }
    }

    public e<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
        if (L.class.isAssignableFrom(y.c(type))) {
            return b.f10963a;
        }
        return null;
    }
}
