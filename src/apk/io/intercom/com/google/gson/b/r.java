package io.intercom.com.google.gson.b;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: Excluder */
class r extends D<T> {

    /* renamed from: a reason: collision with root package name */
    private D<T> f10132a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ boolean f10133b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ boolean f10134c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ o f10135d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ a f10136e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ s f10137f;

    r(s sVar, boolean z, boolean z2, o oVar, a aVar) {
        this.f10137f = sVar;
        this.f10133b = z;
        this.f10134c = z2;
        this.f10135d = oVar;
        this.f10136e = aVar;
    }

    private D<T> b() {
        D<T> d2 = this.f10132a;
        if (d2 != null) {
            return d2;
        }
        D<T> a2 = this.f10135d.a((E) this.f10137f, this.f10136e);
        this.f10132a = a2;
        return a2;
    }

    public T a(b bVar) throws IOException {
        if (!this.f10133b) {
            return b().a(bVar);
        }
        bVar.H();
        return null;
    }

    public void a(d dVar, T t) throws IOException {
        if (this.f10134c) {
            dVar.h();
        } else {
            b().a(dVar, t);
        }
    }
}
