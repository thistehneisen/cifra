package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* compiled from: ExecutorCallAdapterFactory */
final class l extends retrofit2.c.a {

    /* renamed from: a reason: collision with root package name */
    final Executor f11004a;

    /* compiled from: ExecutorCallAdapterFactory */
    static final class a<T> implements b<T> {

        /* renamed from: a reason: collision with root package name */
        final Executor f11005a;

        /* renamed from: b reason: collision with root package name */
        final b<T> f11006b;

        a(Executor executor, b<T> bVar) {
            this.f11005a = executor;
            this.f11006b = bVar;
        }

        public void a(d<T> dVar) {
            y.a(dVar, "callback == null");
            this.f11006b.a(new k(this, dVar));
        }

        public void cancel() {
            this.f11006b.cancel();
        }

        public u<T> execute() throws IOException {
            return this.f11006b.execute();
        }

        public boolean isCanceled() {
            return this.f11006b.isCanceled();
        }

        public b<T> clone() {
            return new a(this.f11005a, this.f11006b.clone());
        }
    }

    l(Executor executor) {
        this.f11004a = executor;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        if (retrofit2.c.a.a(type) != b.class) {
            return null;
        }
        return new h(this, y.b(type));
    }
}
