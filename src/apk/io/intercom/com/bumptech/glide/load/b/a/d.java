package io.intercom.com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import io.intercom.com.bumptech.glide.load.a.a.b;
import io.intercom.com.bumptech.glide.load.a.a.c;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.y;
import io.intercom.com.bumptech.glide.load.c.a.z;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader */
public class d implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Context f9496a;

    /* compiled from: MediaStoreVideoThumbLoader */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Context f9497a;

        public a(Context context) {
            this.f9497a = context;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new d(this.f9497a);
        }
    }

    public d(Context context) {
        this.f9496a = context.getApplicationContext();
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, j jVar) {
        if (!b.a(i2, i3) || !a(jVar)) {
            return null;
        }
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(uri), c.b(this.f9496a, uri));
    }

    private boolean a(j jVar) {
        Long l2 = (Long) jVar.a(z.f9645a);
        return l2 != null && l2.longValue() == -1;
    }

    public boolean a(Uri uri) {
        return b.c(uri);
    }
}
