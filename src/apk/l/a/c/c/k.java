package l.a.c.c;

import androidx.lifecycle.u;
import e.b.b.b;
import e.b.o;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;
import l.a.c.a.a.c;

/* compiled from: BaseLiveDataDispatcher.kt */
public final class k implements r, l {

    /* renamed from: a reason: collision with root package name */
    private final c f10388a;

    public k(c cVar) {
        h.b(cVar, "destroyable");
        this.f10388a = cVar;
    }

    public b a(e.b.b bVar, a<m> aVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(bVar, "$this$untilDestroy");
        h.b(aVar, "onComplete");
        h.b(bVar2, "onError");
        return this.f10388a.a(bVar, aVar, bVar2);
    }

    public <T> b a(e.b.k<? extends T> kVar, u<l.a.c.a.a<T>> uVar) {
        h.b(kVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        l.a.c.a.a aVar = (l.a.c.a.a) uVar.a();
        uVar.b(new c(aVar != null ? aVar.a() : null));
        return a(kVar, new f(uVar), new g(uVar), new h(uVar));
    }

    public <T> b a(e.b.k<T> kVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2, a<m> aVar) {
        h.b(kVar, "$this$untilDestroy");
        h.b(bVar, "onNext");
        h.b(bVar2, "onError");
        h.b(aVar, "onComplete");
        return this.f10388a.a(kVar, bVar, bVar2, aVar);
    }

    public <T> b a(o<T> oVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(oVar, "$this$untilDestroy");
        h.b(bVar, "onSuccess");
        h.b(bVar2, "onError");
        return this.f10388a.a(oVar, bVar, bVar2);
    }

    public <T> b a(o<? extends T> oVar, u<l.a.c.a.a<T>> uVar) {
        h.b(oVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        l.a.c.a.a aVar = (l.a.c.a.a) uVar.a();
        uVar.b(new c(aVar != null ? aVar.a() : null));
        return a(oVar, (kotlin.e.a.b<? super T, m>) new i<Object,m>(uVar), (kotlin.e.a.b<? super Throwable, m>) new j<Object,m>(uVar));
    }

    public b a(e.b.b bVar, u<l.a.c.a.b> uVar) {
        h.b(bVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        uVar.b(l.a.c.a.b.c.f10381a);
        return a(bVar, (a<m>) new d<m>(uVar), (kotlin.e.a.b<? super Throwable, m>) new e<Object,m>(uVar));
    }
}
