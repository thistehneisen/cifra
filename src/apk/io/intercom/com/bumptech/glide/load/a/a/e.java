package io.intercom.com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener */
class e {

    /* renamed from: a reason: collision with root package name */
    private static final a f9441a = new a();

    /* renamed from: b reason: collision with root package name */
    private final a f9442b;

    /* renamed from: c reason: collision with root package name */
    private final d f9443c;

    /* renamed from: d reason: collision with root package name */
    private final b f9444d;

    /* renamed from: e reason: collision with root package name */
    private final ContentResolver f9445e;

    /* renamed from: f reason: collision with root package name */
    private final List<io.intercom.com.bumptech.glide.load.e> f9446f;

    public e(List<io.intercom.com.bumptech.glide.load.e> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f9441a, dVar, bVar, contentResolver);
    }

    public int a(Uri uri) {
        String str = "ThumbStreamOpener";
        InputStream inputStream = null;
        try {
            inputStream = this.f9445e.openInputStream(uri);
            int a2 = f.a(this.f9446f, inputStream, this.f9444d);
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

    /* JADX INFO: finally extract failed */
    public InputStream b(Uri uri) throws FileNotFoundException {
        Cursor a2 = this.f9443c.a(uri);
        InputStream inputStream = null;
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    String string = a2.getString(0);
                    if (TextUtils.isEmpty(string)) {
                        if (a2 != null) {
                            a2.close();
                        }
                        return null;
                    }
                    File a3 = this.f9442b.a(string);
                    Uri fromFile = (!this.f9442b.a(a3) || this.f9442b.b(a3) <= 0) ? null : Uri.fromFile(a3);
                    if (a2 != null) {
                        a2.close();
                    }
                    if (fromFile != null) {
                        try {
                            inputStream = this.f9445e.openInputStream(fromFile);
                        } catch (NullPointerException e2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("NPE opening uri: ");
                            sb.append(fromFile);
                            throw ((FileNotFoundException) new FileNotFoundException(sb.toString()).initCause(e2));
                        }
                    }
                    return inputStream;
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

    public e(List<io.intercom.com.bumptech.glide.load.e> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f9442b = aVar;
        this.f9443c = dVar;
        this.f9444d = bVar;
        this.f9445e = contentResolver;
        this.f9446f = list;
    }
}
