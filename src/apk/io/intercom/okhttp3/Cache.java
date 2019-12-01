package io.intercom.okhttp3;

import e.a.b.A;
import e.a.b.B;
import e.a.b.g;
import e.a.b.h;
import e.a.b.i;
import e.a.b.j;
import e.a.b.k;
import e.a.b.l;
import e.a.b.t;
import io.intercom.okhttp3.Headers.Builder;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.cache.CacheRequest;
import io.intercom.okhttp3.internal.cache.CacheStrategy;
import io.intercom.okhttp3.internal.cache.DiskLruCache;
import io.intercom.okhttp3.internal.cache.DiskLruCache.Editor;
import io.intercom.okhttp3.internal.cache.DiskLruCache.Snapshot;
import io.intercom.okhttp3.internal.cache.InternalCache;
import io.intercom.okhttp3.internal.http.HttpHeaders;
import io.intercom.okhttp3.internal.http.HttpMethod;
import io.intercom.okhttp3.internal.http.StatusLine;
import io.intercom.okhttp3.internal.io.FileSystem;
import io.intercom.okhttp3.internal.platform.Platform;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    private final class CacheRequestImpl implements CacheRequest {
        private A body;
        private A cacheOut;
        boolean done;
        private final Editor editor;

        CacheRequestImpl(final Editor editor2) {
            this.editor = editor2;
            this.cacheOut = editor2.newSink(1);
            this.body = new k(this.cacheOut, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!CacheRequestImpl.this.done) {
                            CacheRequestImpl.this.done = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            editor2.commit();
                        }
                    }
                }
            };
        }

        /* JADX INFO: used method not loaded: io.intercom.okhttp3.internal.Util.closeQuietly(java.io.Closeable):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4.editor.abort();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            io.intercom.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r4.cacheOut);
         */
        public void abort() {
            synchronized (Cache.this) {
                if (!this.done) {
                    this.done = true;
                    Cache.this.writeAbortCount++;
                }
            }
        }

        public A body() {
            return this.body;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        private final i bodySource;
        private final String contentLength;
        private final String contentType;
        final Snapshot snapshot;

        CacheResponseBody(final Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = t.a((B) new l(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    snapshot2.close();
                    super.close();
                }
            });
        }

        public long contentLength() {
            try {
                if (this.contentLength != null) {
                    return Long.parseLong(this.contentLength);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public i source() {
            return this.bodySource;
        }
    }

    private static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(Platform.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Platform.get().getPrefix());
            sb2.append("-Received-Millis");
            RECEIVED_MILLIS = sb2.toString();
        }

        Entry(B b2) throws IOException {
            TlsVersion tlsVersion;
            try {
                i a2 = t.a(b2);
                this.url = a2.p();
                this.requestMethod = a2.p();
                Builder builder = new Builder();
                int readInt = Cache.readInt(a2);
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.addLenient(a2.p());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(a2.p());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Builder builder2 = new Builder();
                int readInt2 = Cache.readInt(a2);
                for (int i3 = 0; i3 < readInt2; i3++) {
                    builder2.addLenient(a2.p());
                }
                String str = builder2.get(SENT_MILLIS);
                String str2 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                long j2 = 0;
                this.sentRequestMillis = str != null ? Long.parseLong(str) : 0;
                if (str2 != null) {
                    j2 = Long.parseLong(str2);
                }
                this.receivedResponseMillis = j2;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String p = a2.p();
                    if (p.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(a2.p());
                        List readCertificateList = readCertificateList(a2);
                        List readCertificateList2 = readCertificateList(a2);
                        if (!a2.o()) {
                            tlsVersion = TlsVersion.forJavaName(a2.p());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected \"\" but was \"");
                        sb.append(p);
                        sb.append("\"");
                        throw new IOException(sb.toString());
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                b2.close();
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(i iVar) throws IOException {
            int readInt = Cache.readInt(iVar);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    String p = iVar.p();
                    g gVar = new g();
                    gVar.a(j.a(p));
                    arrayList.add(instance.generateCertificate(gVar.t()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void writeCertList(h hVar, List<Certificate> list) throws IOException {
            try {
                hVar.g((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    hVar.a(j.a(((Certificate) list.get(i2)).getEncoded()).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public Response response(Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public void writeTo(Editor editor) throws IOException {
            String str;
            h a2 = t.a(editor.newSink(0));
            a2.a(this.url).writeByte(10);
            a2.a(this.requestMethod).writeByte(10);
            a2.g((long) this.varyHeaders.size()).writeByte(10);
            int size = this.varyHeaders.size();
            int i2 = 0;
            while (true) {
                str = ": ";
                if (i2 >= size) {
                    break;
                }
                a2.a(this.varyHeaders.name(i2)).a(str).a(this.varyHeaders.value(i2)).writeByte(10);
                i2++;
            }
            a2.a(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            a2.g((long) (this.responseHeaders.size() + 2)).writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i3 = 0; i3 < size2; i3++) {
                a2.a(this.responseHeaders.name(i3)).a(str).a(this.responseHeaders.value(i3)).writeByte(10);
            }
            a2.a(SENT_MILLIS).a(str).g(this.sentRequestMillis).writeByte(10);
            a2.a(RECEIVED_MILLIS).a(str).g(this.receivedResponseMillis).writeByte(10);
            if (isHttps()) {
                a2.writeByte(10);
                a2.a(this.handshake.cipherSuite().javaName()).writeByte(10);
                writeCertList(a2, this.handshake.peerCertificates());
                writeCertList(a2, this.handshake.localCertificates());
                a2.a(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            a2.close();
        }

        Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }

    public Cache(File file, long j2) {
        this(file, j2, FileSystem.SYSTEM);
    }

    private void abortQuietly(Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return j.c(httpUrl.toString()).c().b();
    }

    static int readInt(i iVar) throws IOException {
        try {
            long x = iVar.x();
            String p = iVar.p();
            if (x >= 0 && x <= 2147483647L && p.isEmpty()) {
                return (int) x;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected an int but was \"");
            sb.append(x);
            sb.append(p);
            sb.append("\"");
            throw new IOException(sb.toString());
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    /* access modifiers changed from: 0000 */
    public Response get(Request request) {
        try {
            Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly((Closeable) response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    /* access modifiers changed from: 0000 */
    public CacheRequest put(Response response) {
        Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    /* access modifiers changed from: 0000 */
    public void update(Response response, Response response2) {
        Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() {
            boolean canRemove;
            final Iterator<Snapshot> delegate = Cache.this.cache.snapshots();
            String nextUrl;

            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    Snapshot snapshot = (Snapshot) this.delegate.next();
                    try {
                        this.nextUrl = t.a(snapshot.getSource(0)).p();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        snapshot.close();
                    }
                }
                return false;
            }

            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }

            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    Cache(File file, long j2, FileSystem fileSystem) {
        this.internalCache = new InternalCache() {
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }

            public void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j2);
    }
}
