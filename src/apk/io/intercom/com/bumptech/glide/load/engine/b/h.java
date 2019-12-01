package io.intercom.com.bumptech.glide.load.engine.b;

import android.annotation.SuppressLint;
import io.intercom.com.bumptech.glide.h.e;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.b.i.a;
import io.intercom.com.bumptech.glide.load.g;

/* compiled from: LruResourceCache */
public class h extends e<g, E<?>> implements i {

    /* renamed from: e reason: collision with root package name */
    private a f9820e;

    public h(long j2) {
        super(j2);
    }

    public /* bridge */ /* synthetic */ E a(g gVar, E e2) {
        return (E) super.b(gVar, e2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(g gVar, E<?> e2) {
        a aVar = this.f9820e;
        if (aVar != null && e2 != null) {
            aVar.a(e2);
        }
    }

    public /* bridge */ /* synthetic */ E a(g gVar) {
        return (E) super.c(gVar);
    }

    public void a(a aVar) {
        this.f9820e = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int b(E<?> e2) {
        return e2.b();
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20) {
            a(b() / 2);
        }
    }
}
