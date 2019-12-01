package retrofit2;

import java.io.IOException;

/* compiled from: ParameterHandler */
class p extends r<Iterable<T>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ r f11020a;

    p(r rVar) {
        this.f11020a = rVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(t tVar, Iterable<T> iterable) throws IOException {
        if (iterable != null) {
            for (T a2 : iterable) {
                this.f11020a.a(tVar, a2);
            }
        }
    }
}
