package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.c.a.A;
import com.bumptech.glide.load.i;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader */
public class d implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Context f3626a;

    /* compiled from: MediaStoreVideoThumbLoader */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Context f3627a;

        public a(Context context) {
            this.f3627a = context;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new d(this.f3627a);
        }

        public void a() {
        }
    }

    public d(Context context) {
        this.f3626a = context.getApplicationContext();
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, i iVar) {
        if (!b.a(i2, i3) || !a(iVar)) {
            return null;
        }
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(uri), c.b(this.f3626a, uri));
    }

    private boolean a(i iVar) {
        Long l2 = (Long) iVar.a(A.f3710a);
        return l2 != null && l2.longValue() == -1;
    }

    public boolean a(Uri uri) {
        return b.c(uri);
    }
}
