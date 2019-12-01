package com.bumptech.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl */
public class l implements f {

    /* renamed from: a reason: collision with root package name */
    private final n f3646a;

    /* renamed from: b reason: collision with root package name */
    private final URL f3647b;

    /* renamed from: c reason: collision with root package name */
    private final String f3648c;

    /* renamed from: d reason: collision with root package name */
    private String f3649d;

    /* renamed from: e reason: collision with root package name */
    private URL f3650e;

    /* renamed from: f reason: collision with root package name */
    private volatile byte[] f3651f;

    /* renamed from: g reason: collision with root package name */
    private int f3652g;

    public l(URL url) {
        this(url, n.f3654b);
    }

    private byte[] e() {
        if (this.f3651f == null) {
            this.f3651f = a().getBytes(f.f4130a);
        }
        return this.f3651f;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f3649d)) {
            String str = this.f3648c;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f3647b;
                com.bumptech.glide.h.l.a(url);
                str = url.toString();
            }
            this.f3649d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f3649d;
    }

    private URL g() throws MalformedURLException {
        if (this.f3650e == null) {
            this.f3650e = new URL(f());
        }
        return this.f3650e;
    }

    public String a() {
        String str = this.f3648c;
        if (str != null) {
            return str;
        }
        URL url = this.f3647b;
        com.bumptech.glide.h.l.a(url);
        return url.toString();
    }

    public Map<String, String> b() {
        return this.f3646a.a();
    }

    public String c() {
        return f();
    }

    public URL d() throws MalformedURLException {
        return g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!a().equals(lVar.a()) || !this.f3646a.equals(lVar.f3646a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f3652g == 0) {
            this.f3652g = a().hashCode();
            this.f3652g = (this.f3652g * 31) + this.f3646a.hashCode();
        }
        return this.f3652g;
    }

    public String toString() {
        return a();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(e());
    }

    public l(String str) {
        this(str, n.f3654b);
    }

    public l(URL url, n nVar) {
        com.bumptech.glide.h.l.a(url);
        this.f3647b = url;
        this.f3648c = null;
        com.bumptech.glide.h.l.a(nVar);
        this.f3646a = nVar;
    }

    public l(String str, n nVar) {
        this.f3647b = null;
        com.bumptech.glide.h.l.a(str);
        this.f3648c = str;
        com.bumptech.glide.h.l.a(nVar);
        this.f3646a = nVar;
    }
}
