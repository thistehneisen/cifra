package com.touchin.vtb.h.d;

import androidx.lifecycle.u;
import com.touchin.vtb.api.TaskListResponse;
import com.touchin.vtb.f.b.C0669w;
import com.touchin.vtb.f.b.sa;
import e.b.b.b;
import e.b.k;
import java.util.concurrent.TimeUnit;
import kotlin.e.b.h;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: TasksViewModel.kt */
public final class g extends s {

    /* renamed from: e reason: collision with root package name */
    public static final a f7593e = new a(null);

    /* renamed from: f reason: collision with root package name */
    private final u<l.a.c.a.a<TaskListResponse>> f7594f = new u<>();

    /* renamed from: g reason: collision with root package name */
    private final c<l.a.c.a.a<Boolean>> f7595g = new c<>();

    /* renamed from: h reason: collision with root package name */
    private final c<l.a.c.a.a<Boolean>> f7596h = new c<>();

    /* renamed from: i reason: collision with root package name */
    private final u<l.a.c.a.a<String>> f7597i = new u<>();

    /* renamed from: j reason: collision with root package name */
    private u<Boolean> f7598j = new u<>();

    /* renamed from: k reason: collision with root package name */
    private b f7599k;

    /* renamed from: l reason: collision with root package name */
    private b f7600l;
    private final sa m;
    private final C0669w n;

    /* compiled from: TasksViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public g(sa saVar, C0669w wVar) {
        h.b(saVar, "userProfileRepository");
        h.b(wVar, "tasksRepository");
        super(null, null, 3, null);
        this.m = saVar;
        this.n = wVar;
        h();
    }

    public final b a(String str) {
        h.b(str, "taskId");
        b a2 = a(this.n.a(str), (u<l.a.c.a.a<T>>) this.f7595g);
        b(str);
        return a2;
    }

    public final void b(String str) {
        h.b(str, "taskId");
        b bVar = this.f7600l;
        if (bVar != null) {
            bVar.b();
        }
        k b2 = k.b(5000, TimeUnit.MILLISECONDS).b((e.b.c.g<? super T, ? extends R>) new h<Object,Object>(str));
        h.a((Object) b2, "Observable\n             …          .map { taskId }");
        this.f7600l = a(b2, this.f7597i);
    }

    public final c<l.a.c.a.a<Boolean>> c() {
        return this.f7595g;
    }

    public final u<l.a.c.a.a<TaskListResponse>> d() {
        return this.f7594f;
    }

    public final u<l.a.c.a.a<String>> e() {
        return this.f7597i;
    }

    public final String f() {
        return this.m.b();
    }

    public final c<l.a.c.a.a<Boolean>> g() {
        return this.f7596h;
    }

    public final void h() {
        b bVar = this.f7599k;
        if (bVar != null) {
            bVar.b();
        }
        this.f7599k = a(this.n.c(), this.f7594f);
    }

    public final u<Boolean> i() {
        return this.f7598j;
    }

    public final b c(String str) {
        h.b(str, "taskId");
        b a2 = a(this.n.d(str), (u<l.a.c.a.a<T>>) this.f7596h);
        b bVar = this.f7600l;
        if (bVar != null) {
            bVar.b();
        }
        return a2;
    }
}
