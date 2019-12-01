package com.bumptech.glide.load.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader */
public final class q implements u<Uri, File> {

    /* renamed from: a reason: collision with root package name */
    private final Context f3663a;

    /* compiled from: MediaStoreFileLoader */
    public static final class a implements v<Uri, File> {

        /* renamed from: a reason: collision with root package name */
        private final Context f3664a;

        public a(Context context) {
            this.f3664a = context;
        }

        public u<Uri, File> a(y yVar) {
            return new q(this.f3664a);
        }

        public void a() {
        }
    }

    /* compiled from: MediaStoreFileLoader */
    private static class b implements d<File> {

        /* renamed from: a reason: collision with root package name */
        private static final String[] f3665a = {"_data"};

        /* renamed from: b reason: collision with root package name */
        private final Context f3666b;

        /* renamed from: c reason: collision with root package name */
        private final Uri f3667c;

        b(Context context, Uri uri) {
            this.f3666b = context;
            this.f3667c = uri;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super File> aVar) {
            Cursor query = this.f3666b.getContentResolver().query(this.f3667c, f3665a, null, null, null);
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
                sb.append(this.f3667c);
                aVar.a((Exception) new FileNotFoundException(sb.toString()));
                return;
            }
            aVar.a(new File(str));
        }

        public void b() {
        }

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<File> a() {
            return File.class;
        }
    }

    public q(Context context) {
        this.f3663a = context;
    }

    public com.bumptech.glide.load.b.u.a<File> a(Uri uri, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(uri), new b(this.f3663a, uri));
    }

    public boolean a(Uri uri) {
        return com.bumptech.glide.load.a.a.b.b(uri);
    }
}
