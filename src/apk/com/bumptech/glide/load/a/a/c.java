package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher */
public class c implements d<InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final Uri f3557a;

    /* renamed from: b reason: collision with root package name */
    private final e f3558b;

    /* renamed from: c reason: collision with root package name */
    private InputStream f3559c;

    /* compiled from: ThumbFetcher */
    static class a implements d {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f3560a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final ContentResolver f3561b;

        a(ContentResolver contentResolver) {
            this.f3561b = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3561b.query(Thumbnails.EXTERNAL_CONTENT_URI, f3560a, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* compiled from: ThumbFetcher */
    static class b implements d {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f3562a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final ContentResolver f3563b;

        b(ContentResolver contentResolver) {
            this.f3563b = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3563b.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f3562a, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f3557a = uri;
        this.f3558b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws FileNotFoundException {
        InputStream b2 = this.f3558b.b(this.f3557a);
        int a2 = b2 != null ? this.f3558b.a(this.f3557a) : -1;
        return a2 != -1 ? new h(b2, a2) : b2;
    }

    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(e.a(context).g().a(), dVar, e.a(context).b(), context.getContentResolver()));
    }

    public void b() {
        InputStream inputStream = this.f3559c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void a(j jVar, com.bumptech.glide.load.a.d.a<? super InputStream> aVar) {
        try {
            this.f3559c = d();
            aVar.a(this.f3559c);
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
