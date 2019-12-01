package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.b.B;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.r;
import io.intercom.com.google.gson.s;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.t;
import io.intercom.com.google.gson.x;
import io.intercom.com.google.gson.y;
import java.io.IOException;

/* renamed from: io.intercom.com.google.gson.b.a.v reason: case insensitive filesystem */
/* compiled from: TreeTypeAdapter */
public final class C0774v<T> extends D<T> {

    /* renamed from: a reason: collision with root package name */
    private final y<T> f10096a;

    /* renamed from: b reason: collision with root package name */
    private final s<T> f10097b;

    /* renamed from: c reason: collision with root package name */
    final o f10098c;

    /* renamed from: d reason: collision with root package name */
    private final io.intercom.com.google.gson.c.a<T> f10099d;

    /* renamed from: e reason: collision with root package name */
    private final E f10100e;

    /* renamed from: f reason: collision with root package name */
    private final a f10101f = new a<>();

    /* renamed from: g reason: collision with root package name */
    private D<T> f10102g;

    /* renamed from: io.intercom.com.google.gson.b.a.v$a */
    /* compiled from: TreeTypeAdapter */
    private final class a implements x, r {
        private a() {
        }
    }

    public C0774v(y<T> yVar, s<T> sVar, o oVar, io.intercom.com.google.gson.c.a<T> aVar, E e2) {
        this.f10096a = yVar;
        this.f10097b = sVar;
        this.f10098c = oVar;
        this.f10099d = aVar;
        this.f10100e = e2;
    }

    private D<T> b() {
        D<T> d2 = this.f10102g;
        if (d2 != null) {
            return d2;
        }
        D<T> a2 = this.f10098c.a(this.f10100e, this.f10099d);
        this.f10102g = a2;
        return a2;
    }

    public T a(b bVar) throws IOException {
        if (this.f10097b == null) {
            return b().a(bVar);
        }
        t a2 = B.a(bVar);
        if (a2.i()) {
            return null;
        }
        return this.f10097b.a(a2, this.f10099d.b(), this.f10101f);
    }

    public void a(d dVar, T t) throws IOException {
        y<T> yVar = this.f10096a;
        if (yVar == null) {
            b().a(dVar, t);
        } else if (t == null) {
            dVar.h();
        } else {
            B.a(yVar.a(t, this.f10099d.b(), this.f10101f), dVar);
        }
    }
}
