package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.c.a;

/* compiled from: DefaultCallAdapterFactory */
final class g extends a {

    /* renamed from: a reason: collision with root package name */
    static final a f10995a = new g();

    g() {
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        if (a.a(type) != b.class) {
            return null;
        }
        return new f(this, y.b(type));
    }
}
