package io.intercom.com.bumptech.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import io.intercom.com.bumptech.glide.load.a.g;
import io.intercom.com.bumptech.glide.load.a.l;
import io.intercom.com.bumptech.glide.load.b.u.a;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;

/* renamed from: io.intercom.com.bumptech.glide.load.b.a reason: case insensitive filesystem */
/* compiled from: AssetUriLoader */
public class C0737a<Data> implements u<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    private static final int f9484a = 22;

    /* renamed from: b reason: collision with root package name */
    private final AssetManager f9485b;

    /* renamed from: c reason: collision with root package name */
    private final C0106a<Data> f9486c;

    /* renamed from: io.intercom.com.bumptech.glide.load.b.a$a reason: collision with other inner class name */
    /* compiled from: AssetUriLoader */
    public interface C0106a<Data> {
        io.intercom.com.bumptech.glide.load.a.b<Data> a(AssetManager assetManager, String str);
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.b.a$b */
    /* compiled from: AssetUriLoader */
    public static class b implements v<Uri, ParcelFileDescriptor>, C0106a<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final AssetManager f9490a;

        public b(AssetManager assetManager) {
            this.f9490a = assetManager;
        }

        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new C0737a(this.f9490a, this);
        }

        public io.intercom.com.bumptech.glide.load.a.b<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new g(assetManager, str);
        }
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.b.a$c */
    /* compiled from: AssetUriLoader */
    public static class c implements v<Uri, InputStream>, C0106a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final AssetManager f9493a;

        public c(AssetManager assetManager) {
            this.f9493a = assetManager;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new C0737a(this.f9493a, this);
        }

        public io.intercom.com.bumptech.glide.load.a.b<InputStream> a(AssetManager assetManager, String str) {
            return new l(assetManager, str);
        }
    }

    public C0737a(AssetManager assetManager, C0106a<Data> aVar) {
        this.f9485b = assetManager;
        this.f9486c = aVar;
    }

    public a<Data> a(Uri uri, int i2, int i3, j jVar) {
        return new a<>(new io.intercom.com.bumptech.glide.g.b(uri), this.f9486c.a(this.f9485b, uri.toString().substring(f9484a)));
    }

    public boolean a(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty()) {
            return false;
        }
        if ("android_asset".equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }
}
