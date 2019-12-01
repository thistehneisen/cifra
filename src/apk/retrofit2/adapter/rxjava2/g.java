package retrofit2.adapter.rxjava2;

import e.b.b;
import e.b.e;
import e.b.k;
import e.b.n;
import e.b.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.c;
import retrofit2.c.a;
import retrofit2.u;
import retrofit2.w;

/* compiled from: RxJava2CallAdapterFactory */
public final class g extends a {

    /* renamed from: a reason: collision with root package name */
    private final n f10991a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f10992b;

    private g(n nVar, boolean z) {
        this.f10991a = nVar;
        this.f10992b = z;
    }

    public static g a(n nVar) {
        if (nVar != null) {
            return new g(nVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        boolean z;
        boolean z2;
        Type type2;
        Class<k> a2 = a.a(type);
        if (a2 == b.class) {
            f fVar = new f(Void.class, this.f10991a, this.f10992b, false, true, false, false, false, true);
            return fVar;
        }
        boolean z3 = a2 == e.class;
        boolean z4 = a2 == o.class;
        boolean z5 = a2 == e.b.g.class;
        if (a2 != k.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" return type must be parameterized as ");
            sb.append(str);
            sb.append("<Foo> or ");
            sb.append(str);
            sb.append("<? extends Foo>");
            throw new IllegalStateException(sb.toString());
        }
        Type a3 = a.a(0, (ParameterizedType) type);
        Class<d> a4 = a.a(a3);
        if (a4 == u.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = a.a(0, (ParameterizedType) a3);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (a4 != d.class) {
            type2 = a3;
            z2 = false;
            z = true;
            f fVar2 = new f(type2, this.f10991a, this.f10992b, z2, z, z3, z4, z5, false);
            return fVar2;
        } else if (a3 instanceof ParameterizedType) {
            type2 = a.a(0, (ParameterizedType) a3);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        f fVar22 = new f(type2, this.f10991a, this.f10992b, z2, z, z3, z4, z5, false);
        return fVar22;
    }
}
