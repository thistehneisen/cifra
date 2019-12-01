package io.intercom.com.bumptech.glide.load;

import io.intercom.com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ImageHeaderParser */
public interface e {

    /* compiled from: ImageHeaderParser */
    public enum a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private a(boolean z) {
            this.hasAlpha = z;
        }

        public boolean a() {
            return this.hasAlpha;
        }
    }

    int a(InputStream inputStream, b bVar) throws IOException;

    a a(InputStream inputStream) throws IOException;

    a a(ByteBuffer byteBuffer) throws IOException;
}
