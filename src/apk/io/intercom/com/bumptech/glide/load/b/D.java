package io.intercom.com.bumptech.glide.load.b;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import io.intercom.com.bumptech.glide.load.a.h;
import io.intercom.com.bumptech.glide.load.a.m;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader */
public class D<Data> implements u<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f9478a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: b reason: collision with root package name */
    private final b<Data> f9479b;

    /* compiled from: UriLoader */
    public static class a implements v<Uri, ParcelFileDescriptor>, b<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final ContentResolver f9480a;

        public a(ContentResolver contentResolver) {
            this.f9480a = contentResolver;
        }

        public io.intercom.com.bumptech.glide.load.a.b<ParcelFileDescriptor> a(Uri uri) {
            return new h(this.f9480a, uri);
        }

        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new D(this);
        }
    }

    /* compiled from: UriLoader */
    public interface b<Data> {
        io.intercom.com.bumptech.glide.load.a.b<Data> a(Uri uri);
    }

    /* compiled from: UriLoader */
    public static class c implements v<Uri, InputStream>, b<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final ContentResolver f9481a;

        public c(ContentResolver contentResolver) {
            this.f9481a = contentResolver;
        }

        public io.intercom.com.bumptech.glide.load.a.b<InputStream> a(Uri uri) {
            return new m(this.f9481a, uri);
        }

        public u<Uri, InputStream> a(y yVar) {
            return new D(this);
        }
    }

    public D(b<Data> bVar) {
        this.f9479b = bVar;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(Uri uri, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(uri), this.f9479b.a(uri));
    }

    public boolean a(Uri uri) {
        return f9478a.contains(uri.getScheme());
    }
}
