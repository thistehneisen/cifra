package com.bumptech.glide.load.b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.j;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader */
public class D<Data> implements u<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f3607a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: b reason: collision with root package name */
    private final c<Data> f3608b;

    /* compiled from: UriLoader */
    public static final class a implements v<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final ContentResolver f3609a;

        public a(ContentResolver contentResolver) {
            this.f3609a = contentResolver;
        }

        public u<Uri, AssetFileDescriptor> a(y yVar) {
            return new D(this);
        }

        public void a() {
        }

        public com.bumptech.glide.load.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.a(this.f3609a, uri);
        }
    }

    /* compiled from: UriLoader */
    public static class b implements v<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final ContentResolver f3610a;

        public b(ContentResolver contentResolver) {
            this.f3610a = contentResolver;
        }

        public com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new j(this.f3610a, uri);
        }

        public void a() {
        }

        public u<Uri, ParcelFileDescriptor> a(y yVar) {
            return new D(this);
        }
    }

    /* compiled from: UriLoader */
    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader */
    public static class d implements v<Uri, InputStream>, c<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final ContentResolver f3611a;

        public d(ContentResolver contentResolver) {
            this.f3611a = contentResolver;
        }

        public com.bumptech.glide.load.a.d<InputStream> a(Uri uri) {
            return new o(this.f3611a, uri);
        }

        public void a() {
        }

        public u<Uri, InputStream> a(y yVar) {
            return new D(this);
        }
    }

    public D(c<Data> cVar) {
        this.f3608b = cVar;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(Uri uri, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(uri), this.f3608b.a(uri));
    }

    public boolean a(Uri uri) {
        return f3607a.contains(uri.getScheme());
    }
}
