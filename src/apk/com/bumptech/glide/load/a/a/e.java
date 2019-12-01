package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener */
class e {

    /* renamed from: a reason: collision with root package name */
    private static final a f3564a = new a();

    /* renamed from: b reason: collision with root package name */
    private final a f3565b;

    /* renamed from: c reason: collision with root package name */
    private final d f3566c;

    /* renamed from: d reason: collision with root package name */
    private final b f3567d;

    /* renamed from: e reason: collision with root package name */
    private final ContentResolver f3568e;

    /* renamed from: f reason: collision with root package name */
    private final List<ImageHeaderParser> f3569f;

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f3564a, dVar, bVar, contentResolver);
    }

    /* JADX INFO: finally extract failed */
    private String c(Uri uri) {
        Cursor a2 = this.f3566c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    String string = a2.getString(0);
                    if (a2 != null) {
                        a2.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.close();
                }
                throw th;
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int a(Uri uri) {
        String str = "ThumbStreamOpener";
        InputStream inputStream = null;
        try {
            inputStream = this.f3568e.openInputStream(uri);
            int a2 = com.bumptech.glide.load.e.a(this.f3569f, inputStream, this.f3567d);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (IOException | NullPointerException e2) {
            inputStream = Log.isLoggable(str, 3);
            if (inputStream) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to open uri: ");
                sb.append(uri);
                Log.d(str, sb.toString(), e2);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            return -1;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    public InputStream b(Uri uri) throws FileNotFoundException {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File a2 = this.f3565b.a(c2);
        if (!a(a2)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(a2);
        try {
            return this.f3568e.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("NPE opening uri: ");
            sb.append(uri);
            sb.append(" -> ");
            sb.append(fromFile);
            throw ((FileNotFoundException) new FileNotFoundException(sb.toString()).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f3565b = aVar;
        this.f3566c = dVar;
        this.f3567d = bVar;
        this.f3568e = contentResolver;
        this.f3569f = list;
    }

    private boolean a(File file) {
        return this.f3565b.a(file) && 0 < this.f3565b.b(file);
    }
}
