package com.bumptech.glide.load.b.a;

import android.net.Uri;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader */
public class b implements u<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f3621a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b reason: collision with root package name */
    private final u<l, InputStream> f3622b;

    /* compiled from: HttpUriLoader */
    public static class a implements v<Uri, InputStream> {
        public u<Uri, InputStream> a(y yVar) {
            return new b(yVar.a(l.class, InputStream.class));
        }

        public void a() {
        }
    }

    public b(u<l, InputStream> uVar) {
        this.f3622b = uVar;
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(Uri uri, int i2, int i3, i iVar) {
        return this.f3622b.a(new l(uri.toString()), i2, i3, iVar);
    }

    public boolean a(Uri uri) {
        return f3621a.contains(uri.getScheme());
    }
}
