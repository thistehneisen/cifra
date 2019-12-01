package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.o;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory */
public class c implements g {

    /* renamed from: a reason: collision with root package name */
    private final o f9102a;

    /* renamed from: b reason: collision with root package name */
    private i f9103b;

    /* renamed from: c reason: collision with root package name */
    private SSLSocketFactory f9104c;

    /* renamed from: d reason: collision with root package name */
    private boolean f9105d;

    public c() {
        this(new io.fabric.sdk.android.c());
    }

    private synchronized SSLSocketFactory b() {
        SSLSocketFactory a2;
        this.f9105d = true;
        try {
            a2 = h.a(this.f9103b);
            this.f9102a.d("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e2) {
            this.f9102a.b("Fabric", "Exception while validating pinned certs", e2);
            return null;
        }
        return a2;
    }

    private synchronized void c() {
        this.f9105d = false;
        this.f9104c = null;
    }

    public void a(i iVar) {
        if (this.f9103b != iVar) {
            this.f9103b = iVar;
            c();
        }
    }

    public c(o oVar) {
        this.f9102a = oVar;
    }

    public HttpRequest a(d dVar, String str) {
        return a(dVar, str, Collections.emptyMap());
    }

    public HttpRequest a(d dVar, String str, Map<String, String> map) {
        HttpRequest httpRequest;
        int i2 = b.f9101a[dVar.ordinal()];
        if (i2 == 1) {
            httpRequest = HttpRequest.a((CharSequence) str, map, true);
        } else if (i2 == 2) {
            httpRequest = HttpRequest.b((CharSequence) str, map, true);
        } else if (i2 == 3) {
            httpRequest = HttpRequest.e((CharSequence) str);
        } else if (i2 == 4) {
            httpRequest = HttpRequest.a((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f9103b != null) {
            SSLSocketFactory a2 = a();
            if (a2 != null) {
                ((HttpsURLConnection) httpRequest.j()).setSSLSocketFactory(a2);
            }
        }
        return httpRequest;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory a() {
        if (this.f9104c == null && !this.f9105d) {
            this.f9104c = b();
        }
        return this.f9104c;
    }
}
