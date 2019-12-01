package io.intercom.com.bumptech.glide.load.b.a;

import io.intercom.com.bumptech.glide.load.b.l;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.y;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader */
public class e implements u<URL, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final u<l, InputStream> f9498a;

    /* compiled from: UrlLoader */
    public static class a implements v<URL, InputStream> {
        public u<URL, InputStream> a(y yVar) {
            return new e(yVar.a(l.class, InputStream.class));
        }
    }

    public e(u<l, InputStream> uVar) {
        this.f9498a = uVar;
    }

    public boolean a(URL url) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<InputStream> a(URL url, int i2, int i3, j jVar) {
        return this.f9498a.a(new l(url), i2, i3, jVar);
    }
}
