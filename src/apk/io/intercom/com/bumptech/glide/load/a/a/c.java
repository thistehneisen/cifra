package io.intercom.com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher */
public class c implements io.intercom.com.bumptech.glide.load.a.b<InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Uri f9434a;

    /* renamed from: b reason: collision with root package name */
    private final e f9435b;

    /* renamed from: c reason: collision with root package name */
    private InputStream f9436c;

    /* compiled from: ThumbFetcher */
    static class a implements d {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f9437a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final ContentResolver f9438b;

        a(ContentResolver contentResolver) {
            this.f9438b = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f9438b.query(Thumbnails.EXTERNAL_CONTENT_URI, f9437a, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* compiled from: ThumbFetcher */
    static class b implements d {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f9439a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final ContentResolver f9440b;

        b(ContentResolver contentResolver) {
            this.f9440b = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f9440b.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f9439a, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f9434a = uri;
        this.f9435b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws FileNotFoundException {
        InputStream b2 = this.f9435b.b(this.f9434a);
        int a2 = b2 != null ? this.f9435b.a(this.f9434a) : -1;
        return a2 != -1 ? new f(b2, a2) : b2;
    }

    public io.intercom.com.bumptech.glide.load.a c() {
        return io.intercom.com.bumptech.glide.load.a.LOCAL;
    }

    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(io.intercom.com.bumptech.glide.c.a(context).g().a(), dVar, io.intercom.com.bumptech.glide.c.a(context).b(), context.getContentResolver()));
    }

    public void b() {
        InputStream inputStream = this.f9436c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super InputStream> aVar) {
        try {
            this.f9436c = d();
            aVar.a(this.f9436c);
        } catch (FileNotFoundException e2) {
            String str = "MediaStoreThumbFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to find thumbnail file", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
