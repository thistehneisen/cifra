package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class Vd extends SSLSocketFactory {

    /* renamed from: a reason: collision with root package name */
    private final SSLSocketFactory f5747a;

    Vd() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private final SSLSocket a(SSLSocket sSLSocket) {
        return new Xd(this, sSLSocket);
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a((SSLSocket) this.f5747a.createSocket(socket, str, i2, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f5747a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f5747a.getSupportedCipherSuites();
    }

    private Vd(SSLSocketFactory sSLSocketFactory) {
        this.f5747a = sSLSocketFactory;
    }

    public final Socket createSocket(String str, int i2) throws IOException {
        return a((SSLSocket) this.f5747a.createSocket(str, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a((SSLSocket) this.f5747a.createSocket(inetAddress, i2));
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return a((SSLSocket) this.f5747a.createSocket(str, i2, inetAddress, i3));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a((SSLSocket) this.f5747a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    public final Socket createSocket() throws IOException {
        return a((SSLSocket) this.f5747a.createSocket());
    }
}
