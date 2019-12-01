package io.intercom.okhttp3.internal.http2;

import e.a.b.A;
import e.a.b.B;
import e.a.b.g;
import e.a.b.j;
import e.a.b.l;
import e.a.b.t;
import io.intercom.okhttp3.Headers;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Protocol;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.Response.Builder;
import io.intercom.okhttp3.ResponseBody;
import io.intercom.okhttp3.internal.Internal;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.connection.StreamAllocation;
import io.intercom.okhttp3.internal.http.HttpCodec;
import io.intercom.okhttp3.internal.http.HttpHeaders;
import io.intercom.okhttp3.internal.http.RealResponseBody;
import io.intercom.okhttp3.internal.http.RequestLine;
import io.intercom.okhttp3.internal.http.StatusLine;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Http2Codec implements HttpCodec {
    private static final j CONNECTION = j.c("connection");
    private static final j ENCODING = j.c("encoding");
    private static final j HOST = j.c("host");
    private static final List<j> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new j[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY});
    private static final List<j> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new j[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    private static final j KEEP_ALIVE = j.c("keep-alive");
    private static final j PROXY_CONNECTION = j.c("proxy-connection");
    private static final j TE = j.c("te");
    private static final j TRANSFER_ENCODING = j.c("transfer-encoding");
    private static final j UPGRADE = j.c("upgrade");
    private final Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class StreamFinishingSource extends l {
        long bytesRead = 0;
        boolean completed = false;

        StreamFinishingSource(B b2) {
            super(b2);
        }

        private void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        public long read(g gVar, long j2) throws IOException {
            try {
                long read = delegate().read(gVar, j2);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e2) {
                endOfInput(e2);
                throw e2;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Chain chain2, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        Protocol protocol2;
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
        if (okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol2 = Protocol.HTTP_2;
        }
        this.protocol = protocol2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            j c2 = j.c(headers.name(i2).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(c2)) {
                arrayList.add(new Header(c2, headers.value(i2)));
            }
        }
        return arrayList;
    }

    public static Builder readHttp2HeadersList(List<Header> list, Protocol protocol2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        Headers.Builder builder2 = builder;
        StatusLine statusLine = null;
        for (int i2 = 0; i2 < size; i2++) {
            Header header = (Header) list.get(i2);
            if (header != null) {
                j jVar = header.name;
                String h2 = header.value.h();
                if (jVar.equals(Header.RESPONSE_STATUS)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(h2);
                    statusLine = StatusLine.parse(sb.toString());
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(jVar)) {
                    Internal.instance.addLenient(builder2, jVar.h(), h2);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder2 = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Builder().protocol(protocol2).code(statusLine.code).message(statusLine.message).headers(builder2.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public A createRequestBody(Request request, long j2) {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), t.a((B) new StreamFinishingSource(this.stream.getSource())));
    }

    public Builder readResponseHeaders(boolean z) throws IOException {
        Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders(), this.protocol);
        if (!z || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }
}
