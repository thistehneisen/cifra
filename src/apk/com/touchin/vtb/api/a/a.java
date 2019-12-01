package com.touchin.vtb.api.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: SslMockUtils.kt */
final class a implements HostnameVerifier {

    /* renamed from: a reason: collision with root package name */
    public static final a f7108a = new a();

    a() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
