package retrofit2;

import java.lang.reflect.Type;

/* compiled from: DefaultCallAdapterFactory */
class f implements c<Object, b<?>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Type f10993a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ g f10994b;

    f(g gVar, Type type) {
        this.f10994b = gVar;
        this.f10993a = type;
    }

    public b<Object> a(b<Object> bVar) {
        return bVar;
    }

    public Type responseType() {
        return this.f10993a;
    }
}
