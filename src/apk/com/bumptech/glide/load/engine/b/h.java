package com.bumptech.glide.load.engine.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.h.i;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.b.i.a;
import com.bumptech.glide.load.f;

/* compiled from: LruResourceCache */
public class h extends i<f, G<?>> implements i {

    /* renamed from: e reason: collision with root package name */
    private a f3959e;

    public h(long j2) {
        super(j2);
    }

    public /* bridge */ /* synthetic */ G a(f fVar, G g2) {
        return (G) super.b(fVar, g2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(f fVar, G<?> g2) {
        a aVar = this.f3959e;
        if (aVar != null && g2 != null) {
            aVar.a(g2);
        }
    }

    public /* bridge */ /* synthetic */ G a(f fVar) {
        return (G) super.c(fVar);
    }

    public void a(a aVar) {
        this.f3959e = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int b(G<?> g2) {
        if (g2 == null) {
            return super.b(null);
        }
        return g2.b();
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }
}
