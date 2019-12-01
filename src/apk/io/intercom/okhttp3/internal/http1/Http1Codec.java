package io.intercom.okhttp3.internal.http1;

import e.a.b.A;
import e.a.b.B;
import e.a.b.D;
import e.a.b.g;
import e.a.b.h;
import e.a.b.i;
import e.a.b.m;
import e.a.b.t;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import io.intercom.okhttp3.Headers;
import io.intercom.okhttp3.Headers.Builder;
import io.intercom.okhttp3.HttpUrl;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.ResponseBody;
import io.intercom.okhttp3.internal.Internal;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.connection.RealConnection;
import io.intercom.okhttp3.internal.connection.StreamAllocation;
import io.intercom.okhttp3.internal.http.HttpCodec;
import io.intercom.okhttp3.internal.http.HttpHeaders;
import io.intercom.okhttp3.internal.http.RealResponseBody;
import io.intercom.okhttp3.internal.http.RequestLine;
import io.intercom.okhttp3.internal.http.StatusLine;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final h sink;
    final i source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class AbstractSource implements B {
        protected long bytesRead;
        protected boolean closed;
        protected final m timeout;

        private AbstractSource() {
            this.timeout = new m(Http1Codec.this.source.timeout());
            this.bytesRead = 0;
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i2 = http1Codec.state;
            if (i2 != 6) {
                if (i2 == 5) {
                    http1Codec.detachTimeout(this.timeout);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.state = 6;
                    StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!z, http1Codec2, this.bytesRead, iOException);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(Http1Codec.this.state);
                throw new IllegalStateException(sb.toString());
            }
        }

        public long read(g gVar, long j2) throws IOException {
            try {
                long read = Http1Codec.this.source.read(gVar, j2);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e2) {
                endOfInput(false, e2);
                throw e2;
            }
        }

        public D timeout() {
            return this.timeout;
        }
    }

    private final class ChunkedSink implements A {
        private boolean closed;
        private final m timeout = new m(Http1Codec.this.sink.timeout());

        ChunkedSink() {
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.a("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public D timeout() {
            return this.timeout;
        }

        public void write(g gVar, long j2) throws IOException {
            if (this.closed) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (j2 != 0) {
                Http1Codec.this.sink.f(j2);
                String str = "\r\n";
                Http1Codec.this.sink.a(str);
                Http1Codec.this.sink.write(gVar, j2);
                Http1Codec.this.sink.a(str);
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = NO_CHUNK_YET;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != NO_CHUNK_YET) {
                Http1Codec.this.source.p();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.s();
                String trim = Http1Codec.this.source.p().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.bytesRemainingInChunk);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }

        public long read(g gVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (!this.hasMoreChunks) {
                return NO_CHUNK_YET;
            } else {
                long j3 = this.bytesRemainingInChunk;
                if (j3 == 0 || j3 == NO_CHUNK_YET) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return NO_CHUNK_YET;
                    }
                }
                long read = super.read(gVar, Math.min(j2, this.bytesRemainingInChunk));
                if (read != NO_CHUNK_YET) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
        }
    }

    private final class FixedLengthSink implements A {
        private long bytesRemaining;
        private boolean closed;
        private final m timeout = new m(Http1Codec.this.sink.timeout());

        FixedLengthSink(long j2) {
            this.bytesRemaining = j2;
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public D timeout() {
            return this.timeout;
        }

        public void write(g gVar, long j2) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(gVar.size(), 0, j2);
                if (j2 <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(gVar, j2);
                    this.bytesRemaining -= j2;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.bytesRemaining);
                sb.append(" bytes but received ");
                sb.append(j2);
                throw new ProtocolException(sb.toString());
            }
            throw new IllegalStateException(Action.CLOSED);
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j2) throws IOException {
            super();
            this.bytesRemaining = j2;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }

        public long read(g gVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.closed) {
                long j3 = this.bytesRemaining;
                if (j3 == 0) {
                    return -1;
                }
                long read = super.read(gVar, Math.min(j3, j2));
                if (read != -1) {
                    this.bytesRemaining -= read;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true, null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException(Action.CLOSED);
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }

        public long read(g gVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = super.read(gVar, j2);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true, null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, i iVar, h hVar) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = iVar;
        this.sink = hVar;
    }

    private String readHeaderLine() throws IOException {
        String c2 = this.source.c(this.headerLimit);
        this.headerLimit -= (long) c2.length();
        return c2;
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public A createRequestBody(Request request, long j2) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j2 != -1) {
            return newFixedLengthSink(j2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* access modifiers changed from: 0000 */
    public void detachTimeout(m mVar) {
        D a2 = mVar.a();
        mVar.a(D.NONE);
        a2.clearDeadline();
        a2.clearTimeout();
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public A newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public B newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public A newFixedLengthSink(long j2) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public B newFixedLengthSource(long j2) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public B newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, t.a(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, t.a(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, t.a(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, t.a(newUnknownLengthSource()));
    }

    public Headers readHeaders() throws IOException {
        Builder builder = new Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.streamAllocation);
                IOException iOException = new IOException(sb.toString());
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.state);
            throw new IllegalStateException(sb2.toString());
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            String str2 = "\r\n";
            this.sink.a(str).a(str2);
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.sink.a(headers.name(i2)).a(": ").a(headers.value(i2)).a(str2);
            }
            this.sink.a(str2);
            this.state = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }
}
