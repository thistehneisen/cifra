package com.touchin.vtb.api.a;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.e.b.h;

/* compiled from: SslMockUtils.kt */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private static final X509TrustManager f7109a = new b();

    /* renamed from: b reason: collision with root package name */
    private static final SSLSocketFactory f7110b;

    /* renamed from: c reason: collision with root package name */
    private static final HostnameVerifier f7111c = a.f7108a;

    /* renamed from: d reason: collision with root package name */
    public static final c f7112d;

    static {
        c cVar = new c();
        f7112d = cVar;
        f7110b = cVar.d();
    }

    private c() {
    }

    private final SSLSocketFactory d() {
        SSLContext instance = SSLContext.getInstance("SSL");
        instance.init(null, new TrustManager[]{f7109a}, new SecureRandom());
        h.a((Object) instance, "context");
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        h.a((Object) socketFactory, "context.socketFactory");
        return socketFactory;
    }

    public final HostnameVerifier a() {
        return f7111c;
    }

    public final SSLSocketFactory b() {
        return f7110b;
    }

    public final X509TrustManager c() {
        return f7109a;
    }
}
