package io.intercom.com.bumptech.glide.load.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader */
public final class q implements u<Uri, File> {

    /* renamed from: a reason: collision with root package name */
    private final Context f9533a;

    /* compiled from: MediaStoreFileLoader */
    public static final class a implements v<Uri, File> {

        /* renamed from: a reason: collision with root package name */
        private final Context f9534a;

        public a(Context context) {
            this.f9534a = context;
        }

        public u<Uri, File> a(y yVar) {
            return new q(this.f9534a);
        }
    }

    /* compiled from: MediaStoreFileLoader */
    private static class b implements io.intercom.com.bumptech.glide.load.a.b<File> {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f9535a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final Context f9536b;

        /* renamed from: c reason: collision with root package name */
        private final Uri f9537c;

        b(Context context, Uri uri) {
            this.f9536b = context;
            this.f9537c = uri;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super File> aVar) {
            Cursor query = this.f9536b.getContentResolver().query(this.f9537c, f9535a, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find file path for: ");
                sb.append(this.f9537c);
                aVar.a((Exception) new FileNotFoundException(sb.toString()));
                return;
            }
            aVar.a(new File(str));
        }

        public void b() {
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<File> a() {
            return File.class;
        }
    }

    public q(Context context) {
        this.f9533a = context;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<File> a(Uri uri, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(uri), new b(this.f9533a, uri));
    }

    public boolean a(Uri uri) {
        return io.intercom.com.bumptech.glide.load.a.a.b.b(uri);
    }
}
