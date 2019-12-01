package io.intercom.com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import io.intercom.com.bumptech.glide.load.a.a.b;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.y;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader */
public class c implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Context f9494a;

    /* compiled from: MediaStoreImageThumbLoader */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Context f9495a;

        public a(Context context) {
            this.f9495a = context;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new c(this.f9495a);
        }
    }

    public c(Context context) {
        this.f9494a = context.getApplicationContext();
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, j jVar) {
        if (b.a(i2, i3)) {
            return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(uri), io.intercom.com.bumptech.glide.load.a.a.c.a(this.f9494a, uri));
        }
        return null;
    }

    public boolean a(Uri uri) {
        return b.a(uri);
    }
}
