package com.bumptech.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.a.n;
import com.bumptech.glide.load.b.u.a;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a reason: case insensitive filesystem */
/* compiled from: AssetUriLoader */
public class C0281a<Data> implements u<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    private static final int f3614a = 22;

    /* renamed from: b reason: collision with root package name */
    private final AssetManager f3615b;

    /* renamed from: c reason: collision with root package name */
    private final C0050a<Data> f3616c;

    /* renamed from: com.bumptech.glide.load.b.a$a reason: collision with other inner class name */
    /* compiled from: AssetUriLoader */
    public interface C0050a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    /* renamed from: com.bumptech.glide.load.b.a$b */
    /* compiled from: AssetUriLoader */
    public static class b implements v<Uri, ParcelFileDescriptor>, C0050a<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final AssetManager f3620a;

        public b(AssetManager assetManager) {
            this.f3620a = assetManager;
        }

        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new C0281a(this.f3620a, this);
        }

        public void a() {
        }

        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new i(assetManager, str);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.a$c */
    /* compiled from: AssetUriLoader */
    public static class c implements v<Uri, InputStream>, C0050a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final AssetManager f3623a;

        public c(AssetManager assetManager) {
            this.f3623a = assetManager;
        }

        public u<Uri, InputStream> a(y yVar) {
            return new C0281a(this.f3623a, this);
        }

        public void a() {
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new n(assetManager, str);
        }
    }

    public C0281a(AssetManager assetManager, C0050a<Data> aVar) {
        this.f3615b = assetManager;
        this.f3616c = aVar;
    }

    public a<Data> a(Uri uri, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new a<>(new com.bumptech.glide.g.b(uri), this.f3616c.a(this.f3615b, uri.toString().substring(f3614a)));
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
