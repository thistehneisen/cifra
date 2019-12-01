package io.intercom.okhttp3;

import e.a.b.g;
import e.a.b.i;
import e.a.b.j;
import io.intercom.okhttp3.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final i source;

        BomAwareReader(i iVar, Charset charset2) {
            this.source = iVar;
            this.charset = charset2;
        }

        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        public int read(char[] cArr, int i2, int i3) throws IOException {
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    Reader inputStreamReader = new InputStreamReader(this.source.t(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                StringBuilder sb = new StringBuilder();
                sb.append(mediaType);
                sb.append("; charset=utf-8");
                mediaType = MediaType.parse(sb.toString());
            }
        }
        g gVar = new g();
        gVar.a(str, charset);
        return create(mediaType, gVar.size(), gVar);
    }

    public final InputStream byteStream() {
        return source().t();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            i source = source();
            try {
                byte[] w = source.w();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) w.length)) {
                    return w;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Length (");
                sb.append(contentLength);
                sb.append(") and stream length (");
                sb.append(w.length);
                sb.append(") disagree");
                throw new IOException(sb.toString());
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot buffer entire body for content length: ");
            sb2.append(contentLength);
            throw new IOException(sb2.toString());
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract i source();

    public final String string() throws IOException {
        i source = source();
        try {
            return source.a(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        g gVar = new g();
        gVar.write(bArr);
        return create(mediaType, (long) bArr.length, gVar);
    }

    public static ResponseBody create(MediaType mediaType, j jVar) {
        g gVar = new g();
        gVar.a(jVar);
        return create(mediaType, (long) jVar.size(), gVar);
    }

    public static ResponseBody create(final MediaType mediaType, final long j2, final i iVar) {
        if (iVar != null) {
            return new ResponseBody() {
                public long contentLength() {
                    return j2;
                }

                public MediaType contentType() {
                    return MediaType.this;
                }

                public i source() {
                    return iVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
