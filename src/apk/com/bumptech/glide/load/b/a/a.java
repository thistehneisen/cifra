package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader */
public class a implements u<l, InputStream> {

    /* renamed from: a reason: collision with root package name */
    public static final h<Integer> f3617a = h.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));

    /* renamed from: b reason: collision with root package name */
    private final t<l, l> f3618b;

    /* renamed from: com.bumptech.glide.load.b.a.a$a reason: collision with other inner class name */
    /* compiled from: HttpGlideUrlLoader */
    public static class C0051a implements v<l, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final t<l, l> f3619a = new t<>(500);

        public u<l, InputStream> a(y yVar) {
            return new a(this.f3619a);
        }

        public void a() {
        }
    }

    public a(t<l, l> tVar) {
        this.f3618b = tVar;
    }

    public boolean a(l lVar) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(l lVar, int i2, int i3, i iVar) {
        t<l, l> tVar = this.f3618b;
        if (tVar != null) {
            l lVar2 = (l) tVar.a(lVar, 0, 0);
            if (lVar2 == null) {
                this.f3618b.a(lVar, 0, 0, lVar);
            } else {
                lVar = lVar2;
            }
        }
        return new com.bumptech.glide.load.b.u.a<>(lVar, new k(lVar, ((Integer) iVar.a(f3617a)).intValue()));
    }
}
