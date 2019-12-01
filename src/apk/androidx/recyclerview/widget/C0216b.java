package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0232s.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: androidx.recyclerview.widget.b reason: case insensitive filesystem */
/* compiled from: AsyncDifferConfig */
public final class C0216b<T> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f1882a;

    /* renamed from: b reason: collision with root package name */
    private final Executor f1883b;

    /* renamed from: c reason: collision with root package name */
    private final c<T> f1884c;

    /* renamed from: androidx.recyclerview.widget.b$a */
    /* compiled from: AsyncDifferConfig */
    public static final class a<T> {

        /* renamed from: a reason: collision with root package name */
        private static final Object f1885a = new Object();

        /* renamed from: b reason: collision with root package name */
        private static Executor f1886b = null;

        /* renamed from: c reason: collision with root package name */
        private Executor f1887c;

        /* renamed from: d reason: collision with root package name */
        private Executor f1888d;

        /* renamed from: e reason: collision with root package name */
        private final c<T> f1889e;

        public a(c<T> cVar) {
            this.f1889e = cVar;
        }

        public C0216b<T> a() {
            if (this.f1888d == null) {
                synchronized (f1885a) {
                    if (f1886b == null) {
                        f1886b = Executors.newFixedThreadPool(2);
                    }
                }
                this.f1888d = f1886b;
            }
            return new C0216b<>(this.f1887c, this.f1888d, this.f1889e);
        }
    }

    C0216b(Executor executor, Executor executor2, c<T> cVar) {
        this.f1882a = executor;
        this.f1883b = executor2;
        this.f1884c = cVar;
    }

    public Executor a() {
        return this.f1883b;
    }

    public c<T> b() {
        return this.f1884c;
    }

    public Executor c() {
        return this.f1882a;
    }
}
