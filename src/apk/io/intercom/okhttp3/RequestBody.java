package io.intercom.okhttp3;

import e.a.b.B;
import e.a.b.h;
import e.a.b.j;
import e.a.b.t;
import io.intercom.okhttp3.internal.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class RequestBody {
    public static RequestBody create(MediaType mediaType, String str) {
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
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(h hVar) throws IOException;

    public static RequestBody create(final MediaType mediaType, final j jVar) {
        return new RequestBody() {
            public long contentLength() throws IOException {
                return (long) jVar.size();
            }

            public MediaType contentType() {
                return MediaType.this;
            }

            public void writeTo(h hVar) throws IOException {
                hVar.a(jVar);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i2, final int i3) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i2, (long) i3);
            return new RequestBody() {
                public long contentLength() {
                    return (long) i3;
                }

                public MediaType contentType() {
                    return MediaType.this;
                }

                public void writeTo(h hVar) throws IOException {
                    hVar.write(bArr, i2, i3);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public long contentLength() {
                    return file.length();
                }

                public MediaType contentType() {
                    return MediaType.this;
                }

                public void writeTo(h hVar) throws IOException {
                    B b2 = null;
                    try {
                        b2 = t.c(file);
                        hVar.a(b2);
                    } finally {
                        Util.closeQuietly((Closeable) b2);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
