package io.intercom.com.bumptech.glide.load.b.a;

import io.intercom.com.bumptech.glide.load.b.l;
import io.intercom.com.bumptech.glide.load.b.t;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.y;
import io.intercom.com.bumptech.glide.load.i;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader */
public class a implements u<l, InputStream> {

    /* renamed from: a reason: collision with root package name */
    public static final i<Integer> f9487a = i.a("io.intercom.com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));

    /* renamed from: b reason: collision with root package name */
    private final t<l, l> f9488b;

    /* renamed from: io.intercom.com.bumptech.glide.load.b.a.a$a reason: collision with other inner class name */
    /* compiled from: HttpGlideUrlLoader */
    public static class C0107a implements v<l, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final t<l, l> f9489a = new t<>(500);

        public u<l, InputStream> a(y yVar) {
            return new a(this.f9489a);
        }
    }

    public a(t<l, l> tVar) {
        this.f9488b = tVar;
    }

    public boolean a(l lVar) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<InputStream> a(l lVar, int i2, int i3, j jVar) {
        t<l, l> tVar = this.f9488b;
        if (tVar != null) {
            l lVar2 = (l) tVar.a(lVar, 0, 0);
            if (lVar2 == null) {
                this.f9488b.a(lVar, 0, 0, lVar);
            } else {
                lVar = lVar2;
            }
        }
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(lVar, new io.intercom.com.bumptech.glide.load.a.i(lVar, ((Integer) jVar.a(f9487a)).intValue()));
    }
}
