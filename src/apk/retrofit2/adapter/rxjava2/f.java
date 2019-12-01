package retrofit2.adapter.rxjava2;

import e.b.a;
import e.b.n;
import java.lang.reflect.Type;
import retrofit2.b;
import retrofit2.c;

/* compiled from: RxJava2CallAdapter */
final class f<R> implements c<R, Object> {

    /* renamed from: a reason: collision with root package name */
    private final Type f10982a;

    /* renamed from: b reason: collision with root package name */
    private final n f10983b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f10984c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f10985d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f10986e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f10987f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f10988g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f10989h;

    /* renamed from: i reason: collision with root package name */
    private final boolean f10990i;

    f(Type type, n nVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f10982a = type;
        this.f10983b = nVar;
        this.f10984c = z;
        this.f10985d = z2;
        this.f10986e = z3;
        this.f10987f = z4;
        this.f10988g = z5;
        this.f10989h = z6;
        this.f10990i = z7;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [e.b.k] */
    /* JADX WARNING: type inference failed for: r2v2, types: [e.b.k] */
    /* JADX WARNING: type inference failed for: r2v3, types: [e.b.k] */
    /* JADX WARNING: type inference failed for: r2v5, types: [e.b.b] */
    /* JADX WARNING: type inference failed for: r2v9, types: [e.b.k] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12, types: [retrofit2.adapter.rxjava2.a] */
    /* JADX WARNING: type inference failed for: r2v13, types: [retrofit2.adapter.rxjava2.e] */
    /* JADX WARNING: type inference failed for: r0v8, types: [retrofit2.adapter.rxjava2.c] */
    /* JADX WARNING: type inference failed for: r0v9, types: [retrofit2.adapter.rxjava2.b] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    public Object a(b<R> bVar) {
        ? r0;
        if (this.f10984c) {
            r0 = new b(bVar);
        } else {
            r0 = new c(bVar);
        }
        Object obj = this.f10985d ? new e(r0) : this.f10986e ? new a(r0) : r0;
        n nVar = this.f10983b;
        if (nVar != null) {
            obj = obj.b(nVar);
        }
        if (this.f10987f) {
            return obj.a(a.LATEST);
        }
        if (this.f10988g) {
            return obj.h();
        }
        if (this.f10989h) {
            return obj.g();
        }
        if (this.f10990i) {
            obj = obj.f();
        }
        return obj;
    }

    public Type responseType() {
        return this.f10982a;
    }
}
