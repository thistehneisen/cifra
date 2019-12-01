package com.touchin.vtb.f.b;

import com.touchin.vtb.api.TaskListResponse;
import com.touchin.vtb.api.TasksTaxInfo;
import com.touchin.vtb.api.TaxPaymentResponse;
import com.touchin.vtb.api.v;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* renamed from: com.touchin.vtb.f.b.w reason: case insensitive filesystem */
/* compiled from: TasksRepository.kt */
public final class C0669w extends com.touchin.vtb.f.a {

    /* renamed from: b reason: collision with root package name */
    public static final a f7381b = new a(null);
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final v f7382c;

    /* renamed from: d reason: collision with root package name */
    private final i<String, String, String> f7383d;

    /* renamed from: com.touchin.vtb.f.b.w$a */
    /* compiled from: TasksRepository.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public C0669w(v vVar, i<String, String, String> iVar) {
        h.b(vVar, "tasksApi");
        h.b(iVar, "sessionStorable");
        super(iVar);
        this.f7382c = vVar;
        this.f7383d = iVar;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.A] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<TaskListResponse> b() {
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new C0672z<Object,Object>(this));
        ? r1 = A.f7274c;
        if (r1 != 0) {
            r1 = new J(r1);
        }
        o<TaskListResponse> c2 = a2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …ListResponse>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.C] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<TaskListResponse> c() {
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new B<Object,Object>(this));
        ? r1 = C.f7276c;
        if (r1 != 0) {
            r1 = new J(r1);
        }
        o<TaskListResponse> c2 = a2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …ListResponse>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.I] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> d(String str) {
        h.b(str, "taskId");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new H<Object,Object>(this, str));
        ? r0 = I.f7285c;
        if (r0 != 0) {
            r0 = new J(r0);
        }
        o<Boolean> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.y] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> a(String str) {
        h.b(str, "taskId");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new C0670x<Object,Object>(this, str));
        ? r0 = C0671y.f7386c;
        if (r0 != 0) {
            r0 = new J(r0);
        }
        o<Boolean> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.touchin.vtb.f.b.E, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<TasksTaxInfo> b(String str) {
        h.b(str, "taskId");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new D<Object,Object>(this, str));
        ? r0 = E.f7279c;
        if (r0 != 0) {
            r0 = new J(r0);
        }
        o<TasksTaxInfo> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …TasksTaxInfo>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.touchin.vtb.f.b.G, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.J] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<TaxPaymentResponse> c(String str) {
        h.b(str, "taskId");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new F<Object,Object>(this, str));
        ? r0 = G.f7282c;
        if (r0 != 0) {
            r0 = new J(r0);
        }
        o<TaxPaymentResponse> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …mentResponse>::getResult)");
        return c2;
    }
}
