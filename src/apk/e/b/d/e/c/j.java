package e.b.d.e.c;

import e.b.d.b.b;
import e.b.d.d.c;
import e.b.k;
import e.b.m;

/* compiled from: ObservableFromArray */
public final class j<T> extends k<T> {

    /* renamed from: a reason: collision with root package name */
    final T[] f8088a;

    /* compiled from: ObservableFromArray */
    static final class a<T> extends c<T> {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8089a;

        /* renamed from: b reason: collision with root package name */
        final T[] f8090b;

        /* renamed from: c reason: collision with root package name */
        int f8091c;

        /* renamed from: d reason: collision with root package name */
        boolean f8092d;

        /* renamed from: e reason: collision with root package name */
        volatile boolean f8093e;

        a(m<? super T> mVar, T[] tArr) {
            this.f8089a = mVar;
            this.f8090b = tArr;
        }

        public boolean a() {
            return this.f8093e;
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f8092d = true;
            return 1;
        }

        /* access modifiers changed from: 0000 */
        public void c() {
            T[] tArr = this.f8090b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !a(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    m<? super T> mVar = this.f8089a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("The ");
                    sb.append(i2);
                    sb.append("th element is null");
                    mVar.a((Throwable) new NullPointerException(sb.toString()));
                    return;
                }
                this.f8089a.a(t);
            }
            if (!a()) {
                this.f8089a.c();
            }
        }

        public void clear() {
            this.f8091c = this.f8090b.length;
        }

        public boolean isEmpty() {
            return this.f8091c == this.f8090b.length;
        }

        public T poll() {
            int i2 = this.f8091c;
            T[] tArr = this.f8090b;
            if (i2 == tArr.length) {
                return null;
            }
            this.f8091c = i2 + 1;
            T t = tArr[i2];
            b.a(t, "The array element is null");
            return t;
        }

        public void b() {
            this.f8093e = true;
        }
    }

    public j(T[] tArr) {
        this.f8088a = tArr;
    }

    public void b(m<? super T> mVar) {
        a aVar = new a(mVar, this.f8088a);
        mVar.a((e.b.b.b) aVar);
        if (!aVar.f8092d) {
            aVar.c();
        }
    }
}
