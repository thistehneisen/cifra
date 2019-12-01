package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.i;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader */
public class c implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Context f3624a;

    /* compiled from: MediaStoreImageThumbLoader */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Context f3625a;

        public a(Context context) {
            this.f3625a = context;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new c(this.f3625a);
        }

        public void a() {
        }
    }

    public c(Context context) {
        this.f3624a = context.getApplicationContext();
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, i iVar) {
        if (b.a(i2, i3)) {
            return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(uri), com.bumptech.glide.load.a.a.c.a(this.f3624a, uri));
        }
        return null;
    }

    public boolean a(Uri uri) {
        return b.a(uri);
    }
}
