package l.a.c.c;

import e.b.b.a;
import e.b.b.b;
import e.b.c.e;
import e.b.k;
import e.b.o;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: BaseDestroyable.kt */
public class c implements l {

    /* renamed from: a reason: collision with root package name */
    private final a f10387a = new a();

    public final void a() {
        this.f10387a.b();
    }

    public <T> b a(k<T> kVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2, kotlin.e.a.a<m> aVar) {
        h.b(kVar, "$this$untilDestroy");
        h.b(bVar, "onNext");
        h.b(bVar2, "onError");
        h.b(aVar, "onComplete");
        b a2 = kVar.a(e.b.a.b.b.a()).a((e<? super T>) new b<Object>(bVar), (e<? super Throwable>) new b<Object>(bVar2), (e.b.c.a) new a(aVar));
        this.f10387a.b(a2);
        h.a((Object) a2, "observeOn(AndroidSchedul…{ subscriptions.add(it) }");
        return a2;
    }

    public <T> b a(o<T> oVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(oVar, "$this$untilDestroy");
        h.b(bVar, "onSuccess");
        h.b(bVar2, "onError");
        b a2 = oVar.a(e.b.a.b.b.a()).a((e<? super T>) new b<Object>(bVar), (e<? super Throwable>) new b<Object>(bVar2));
        this.f10387a.b(a2);
        h.a((Object) a2, "observeOn(AndroidSchedul…{ subscriptions.add(it) }");
        return a2;
    }

    public b a(e.b.b bVar, kotlin.e.a.a<m> aVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(bVar, "$this$untilDestroy");
        h.b(aVar, "onComplete");
        h.b(bVar2, "onError");
        b a2 = bVar.a(e.b.a.b.b.a()).a(new a(aVar), new b(bVar2));
        this.f10387a.b(a2);
        h.a((Object) a2, "observeOn(AndroidSchedul…{ subscriptions.add(it) }");
        return a2;
    }
}
