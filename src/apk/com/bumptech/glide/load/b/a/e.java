package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader */
public class e implements u<URL, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final u<l, InputStream> f3628a;

    /* compiled from: UrlLoader */
    public static class a implements v<URL, InputStream> {
        public u<URL, InputStream> a(y yVar) {
            return new e(yVar.a(l.class, InputStream.class));
        }

        public void a() {
        }
    }

    public e(u<l, InputStream> uVar) {
        this.f3628a = uVar;
    }

    public boolean a(URL url) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(URL url, int i2, int i3, i iVar) {
        return this.f3628a.a(new l(url), i2, i3, iVar);
    }
}
