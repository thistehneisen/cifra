package io.intercom.com.bumptech.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl */
public class l implements g {

    /* renamed from: a reason: collision with root package name */
    private final n f9516a;

    /* renamed from: b reason: collision with root package name */
    private final URL f9517b;

    /* renamed from: c reason: collision with root package name */
    private final String f9518c;

    /* renamed from: d reason: collision with root package name */
    private String f9519d;

    /* renamed from: e reason: collision with root package name */
    private URL f9520e;

    /* renamed from: f reason: collision with root package name */
    private volatile byte[] f9521f;

    /* renamed from: g reason: collision with root package name */
    private int f9522g;

    public l(URL url) {
        this(url, n.f9524b);
    }

    private byte[] d() {
        if (this.f9521f == null) {
            this.f9521f = a().getBytes(g.f9988a);
        }
        return this.f9521f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f9519d)) {
            String str = this.f9518c;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f9517b;
                h.a(url);
                str = url.toString();
            }
            this.f9519d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f9519d;
    }

    private URL f() throws MalformedURLException {
        if (this.f9520e == null) {
            this.f9520e = new URL(e());
        }
        return this.f9520e;
    }

    public String a() {
        String str = this.f9518c;
        if (str != null) {
            return str;
        }
        URL url = this.f9517b;
        h.a(url);
        return url.toString();
    }

    public Map<String, String> b() {
        return this.f9516a.a();
    }

    public URL c() throws MalformedURLException {
        return f();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!a().equals(lVar.a()) || !this.f9516a.equals(lVar.f9516a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f9522g == 0) {
            this.f9522g = a().hashCode();
            this.f9522g = (this.f9522g * 31) + this.f9516a.hashCode();
        }
        return this.f9522g;
    }

    public String toString() {
        return a();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public l(String str) {
        this(str, n.f9524b);
    }

    public l(URL url, n nVar) {
        h.a(url);
        this.f9517b = url;
        this.f9518c = null;
        h.a(nVar);
        this.f9516a = nVar;
    }

    public l(String str, n nVar) {
        this.f9517b = null;
        h.a(str);
        this.f9518c = str;
        h.a(nVar);
        this.f9516a = nVar;
    }
}
