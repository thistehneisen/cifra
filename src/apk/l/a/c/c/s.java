package l.a.c.c;

import androidx.lifecycle.C;
import androidx.lifecycle.u;
import e.b.b.b;
import e.b.k;
import e.b.o;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: RxViewModel.kt */
public class s extends C implements l, r {

    /* renamed from: c reason: collision with root package name */
    private final c f10392c;

    /* renamed from: d reason: collision with root package name */
    private final k f10393d;

    public s() {
        this(null, null, 3, null);
    }

    public /* synthetic */ s(c cVar, k kVar, int i2, e eVar) {
        if ((i2 & 1) != 0) {
            cVar = new c();
        }
        if ((i2 & 2) != 0) {
            kVar = new k(cVar);
        }
        this(cVar, kVar);
    }

    public b a(e.b.b bVar, u<l.a.c.a.b> uVar) {
        h.b(bVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        return this.f10393d.a(bVar, uVar);
    }

    public b a(e.b.b bVar, a<m> aVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(bVar, "$this$untilDestroy");
        h.b(aVar, "onComplete");
        h.b(bVar2, "onError");
        return this.f10392c.a(bVar, aVar, bVar2);
    }

    public <T> b a(k<? extends T> kVar, u<l.a.c.a.a<T>> uVar) {
        h.b(kVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        return this.f10393d.a(kVar, uVar);
    }

    public <T> b a(o<? extends T> oVar, u<l.a.c.a.a<T>> uVar) {
        h.b(oVar, "$this$dispatchTo");
        h.b(uVar, "liveData");
        return this.f10393d.a(oVar, uVar);
    }

    public <T> b a(o<T> oVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2) {
        h.b(oVar, "$this$untilDestroy");
        h.b(bVar, "onSuccess");
        h.b(bVar2, "onError");
        return this.f10392c.a(oVar, bVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public void b() {
        super.b();
        this.f10392c.a();
    }

    public s(c cVar, k kVar) {
        h.b(cVar, "destroyable");
        h.b(kVar, "liveDataDispatcher");
        this.f10392c = cVar;
        this.f10393d = kVar;
    }
}
