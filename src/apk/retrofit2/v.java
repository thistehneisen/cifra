package retrofit2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: Retrofit */
class v implements InvocationHandler {

    /* renamed from: a reason: collision with root package name */
    private final s f11063a = s.b();

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Class f11064b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ w f11065c;

    v(w wVar, Class cls) {
        this.f11065c = wVar;
        this.f11064b = cls;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (this.f11063a.a(method)) {
            return this.f11063a.a(method, this.f11064b, obj, objArr);
        }
        x a2 = this.f11065c.a(method);
        return a2.a((b<R>) new o<R>(a2, objArr));
    }
}
