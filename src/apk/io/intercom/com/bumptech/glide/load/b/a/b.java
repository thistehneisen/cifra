package io.intercom.com.bumptech.glide.load.b.a;

import android.net.Uri;
import io.intercom.com.bumptech.glide.load.b.l;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.y;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader */
public class b implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f9491a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b reason: collision with root package name */
    private final u<l, InputStream> f9492b;

    /* compiled from: HttpUriLoader */
    public static class a implements v<Uri, InputStream> {
        public u<Uri, InputStream> a(y yVar) {
            return new b(yVar.a(l.class, InputStream.class));
        }
    }

    public b(u<l, InputStream> uVar) {
        this.f9492b = uVar;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, j jVar) {
        return this.f9492b.a(new l(uri.toString()), i2, i3, jVar);
    }

    public boolean a(Uri uri) {
        return f9491a.contains(uri.getScheme());
    }
}
