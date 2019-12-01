package io.intercom.okhttp3.internal.connection;

import e.a.b.B;
import e.a.b.h;
import e.a.b.i;
import e.a.b.t;
import io.fabric.sdk.android.a.b.C0730a;
import io.intercom.okhttp3.Address;
import io.intercom.okhttp3.Call;
import io.intercom.okhttp3.CertificatePinner;
import io.intercom.okhttp3.Connection;
import io.intercom.okhttp3.ConnectionPool;
import io.intercom.okhttp3.ConnectionSpec;
import io.intercom.okhttp3.EventListener;
import io.intercom.okhttp3.Handshake;
import io.intercom.okhttp3.HttpUrl;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Protocol;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Request.Builder;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.Route;
import io.intercom.okhttp3.internal.Internal;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.Version;
import io.intercom.okhttp3.internal.http.HttpCodec;
import io.intercom.okhttp3.internal.http.HttpHeaders;
import io.intercom.okhttp3.internal.http1.Http1Codec;
import io.intercom.okhttp3.internal.http2.ErrorCode;
import io.intercom.okhttp3.internal.http2.Http2Codec;
import io.intercom.okhttp3.internal.http2.Http2Connection;
import io.intercom.okhttp3.internal.http2.Http2Connection.Listener;
import io.intercom.okhttp3.internal.http2.Http2Stream;
import io.intercom.okhttp3.internal.platform.Platform;
import io.intercom.okhttp3.internal.tls.OkHostnameVerifier;
import io.intercom.okhttp3.internal.ws.RealWebSocket.Streams;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public final class RealConnection extends Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private h sink;
    private Socket socket;
    private i source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    private void connectSocket(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i3);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i2);
            try {
                this.source = t.a(t.b(this.rawSocket));
                this.sink = t.a(t.a(this.rawSocket));
            } catch (NullPointerException e2) {
                if (NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to connect to ");
            sb.append(this.route.socketAddress());
            ConnectException connectException = new ConnectException(sb.toString());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0111 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        ? r1;
        ? r2;
        Protocol protocol2;
        Address address = this.route.address();
        String str = 0;
        try {
            SSLSocket sSLSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                Handshake handshake2 = Handshake.get(session);
                if (address.hostnameVerifier().verify(address.url().host(), session)) {
                    address.certificatePinner().check(address.url().host(), handshake2.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(sSLSocket);
                    }
                    this.socket = sSLSocket;
                    this.source = t.a(t.b(this.socket));
                    this.sink = t.a(t.a(this.socket));
                    this.handshake = handshake2;
                    if (str != 0) {
                        protocol2 = Protocol.get(str);
                    } else {
                        protocol2 = Protocol.HTTP_1_1;
                    }
                    this.protocol = protocol2;
                    if (sSLSocket != 0) {
                        Platform.get().afterHandshake(sSLSocket);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake2.peerCertificates().get(0);
                StringBuilder sb = new StringBuilder();
                sb.append("Hostname ");
                sb.append(address.url().host());
                sb.append(" not verified:\n    certificate: ");
                sb.append(CertificatePinner.pin(x509Certificate));
                sb.append("\n    DN: ");
                sb.append(x509Certificate.getSubjectDN().getName());
                sb.append("\n    subjectAltNames: ");
                sb.append(OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                throw new SSLPeerUnverifiedException(sb.toString());
            } catch (AssertionError e2) {
                e = e2;
                r2 = sSLSocket;
                try {
                    if (!Util.isAndroidGetsocknameError(e)) {
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = r2;
                    if (r1 != 0) {
                        Platform.get().afterHandshake(r1);
                    }
                    Util.closeQuietly((Socket) r1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = sSLSocket;
                if (r1 != 0) {
                }
                Util.closeQuietly((Socket) r1);
                throw th;
            }
        } catch (AssertionError e3) {
            e = e3;
            r2 = str;
            if (!Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    private void connectTunnel(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i5 = 0;
        while (i5 < 21) {
            connectSocket(i2, i3, call, eventListener);
            createTunnelRequest = createTunnel(i3, i4, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
                i5++;
            } else {
                return;
            }
        }
    }

    private Request createTunnel(int i2, int i3, Request request, HttpUrl httpUrl) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(Util.hostHeader(httpUrl, true));
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), sb2);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            B newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate != null) {
                        if ("close".equalsIgnoreCase(build.header("Connection"))) {
                            return authenticate;
                        }
                        request = authenticate;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected response code for CONNECT: ");
                    sb3.append(build.code());
                    throw new IOException(sb3.toString());
                }
            } else if (this.source.n().o() && this.sink.n().o()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() {
        return new Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header(C0730a.HEADER_USER_AGENT, Version.userAgent()).build();
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i2, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i2);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i2);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private void startHttp2(int i2) throws IOException {
        this.socket.setSoTimeout(0);
        this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i2).build();
        this.http2Connection.start();
    }

    public static RealConnection testConnection(ConnectionPool connectionPool2, Route route2, Socket socket2, long j2) {
        RealConnection realConnection = new RealConnection(connectionPool2, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j2;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0143 A[EDGE_INSN: B:63:0x0143->B:56:0x0143 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void connect(int i2, int i3, int i4, int i5, boolean z, Call call, EventListener eventListener) {
        Call call2 = call;
        EventListener eventListener2 = eventListener;
        if (this.protocol == null) {
            List connectionSpecs = this.route.address().connectionSpecs();
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
            if (this.route.address().sslSocketFactory() == null) {
                if (connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                    String host = this.route.address().url().host();
                    if (!Platform.get().isCleartextTrafficPermitted(host)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("CLEARTEXT communication to ");
                        sb.append(host);
                        sb.append(" not permitted by network security policy");
                        throw new RouteException(new UnknownServiceException(sb.toString()));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    if (this.route.requiresTunnel()) {
                        connectTunnel(i2, i3, i4, call, eventListener);
                        if (this.rawSocket != null) {
                            int i6 = i2;
                            int i7 = i3;
                        } else if (!this.route.requiresTunnel() && this.rawSocket == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        } else if (this.http2Connection == null) {
                            synchronized (this.connectionPool) {
                                this.allocationLimit = this.http2Connection.maxConcurrentStreams();
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        try {
                            connectSocket(i2, i3, call2, eventListener2);
                        } catch (IOException e2) {
                            e = e2;
                            int i8 = i5;
                            Util.closeQuietly(this.socket);
                            Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                            if (routeException != null) {
                            }
                            if (z) {
                            }
                            throw routeException;
                        }
                    }
                    try {
                        establishProtocol(connectionSpecSelector, i5, call2, eventListener2);
                        eventListener2.connectEnd(call2, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (!this.route.requiresTunnel()) {
                        }
                        if (this.http2Connection == null) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (IOException e4) {
                    e = e4;
                    int i9 = i2;
                    int i10 = i3;
                    int i82 = i5;
                    Util.closeQuietly(this.socket);
                    Util.closeQuietly(this.rawSocket);
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                    if (routeException != null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.addConnectException(e);
                    }
                    if (z) {
                        break;
                    } else if (!connectionSpecSelector.connectionFailed(e)) {
                    }
                    throw routeException;
                }
            } while (!connectionSpecSelector.connectionFailed(e));
            throw routeException;
        }
        throw new IllegalStateException("already connected");
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address, Route route2) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route2 == null || route2.proxy().type() != Type.DIRECT || this.route.proxy().type() != Type.DIRECT || !this.route.socketAddress().equals(route2.socketAddress()) || route2.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return !http2Connection2.isShutdown();
        }
        if (z) {
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.o()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Chain chain, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, http2Connection2);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        AnonymousClass1 r0 = new Streams(true, this.source, this.sink) {
            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec(), -1, null);
            }
        };
        return r0;
    }

    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Route route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        boolean z = true;
        if (!httpUrl.host().equals(this.route.address().url().host()) && (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0)))) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        sb.append(handshake2 != null ? handshake2.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
