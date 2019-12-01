package retrofit2;

import java.lang.reflect.Type;

/* compiled from: ExecutorCallAdapterFactory */
class h implements c<Object, b<?>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Type f10996a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ l f10997b;

    h(l lVar, Type type) {
        this.f10997b = lVar;
        this.f10996a = type;
    }

    public Type responseType() {
        return this.f10996a;
    }

    public b<Object> a(b<Object> bVar) {
        return new a(this.f10997b.f11004a, bVar);
    }
}
