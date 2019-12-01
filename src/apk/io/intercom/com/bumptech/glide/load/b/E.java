package io.intercom.com.bumptech.glide.load.b;

import android.net.Uri;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader */
public class E<Data> implements u<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f9482a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b reason: collision with root package name */
    private final u<l, Data> f9483b;

    /* compiled from: UrlUriLoader */
    public static class a implements v<Uri, InputStream> {
        public u<Uri, InputStream> a(y yVar) {
            return new E(yVar.a(l.class, InputStream.class));
        }
    }

    public E(u<l, Data> uVar) {
        this.f9483b = uVar;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(Uri uri, int i2, int i3, j jVar) {
        return this.f9483b.a(new l(uri.toString()), i2, i3, jVar);
    }

    public boolean a(Uri uri) {
        return f9482a.contains(uri.getScheme());
    }
}
