package io.intercom.com.bumptech.glide.load.b;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader */
public class B<Data> implements u<String, Data> {

    /* renamed from: a reason: collision with root package name */
    private final u<Uri, Data> f9474a;

    /* compiled from: StringLoader */
    public static class a implements v<String, ParcelFileDescriptor> {
        public u<String, ParcelFileDescriptor> a(y yVar) {
            return new B(yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    public static class b implements v<String, InputStream> {
        public u<String, InputStream> a(y yVar) {
            return new B(yVar.a(Uri.class, InputStream.class));
        }
    }

    public B(u<Uri, Data> uVar) {
        this.f9474a = uVar;
    }

    private static Uri b(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
            uri = c(str);
        } else {
            Uri parse = Uri.parse(str);
            uri = parse.getScheme() == null ? c(str) : parse;
        }
        return uri;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    public boolean a(String str) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(String str, int i2, int i3, j jVar) {
        Uri b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return this.f9474a.a(b2, i2, i3, jVar);
    }
}
