package io.intercom.com.bumptech.glide.load.c.b;

import io.intercom.com.bumptech.glide.load.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder */
public class a implements c<ByteBuffer> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f9651a;

    /* renamed from: io.intercom.com.bumptech.glide.load.c.b.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferRewinder */
    public static class C0110a implements io.intercom.com.bumptech.glide.load.a.c.a<ByteBuffer> {
        public c<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f9651a = byteBuffer;
    }

    public void b() {
    }

    public ByteBuffer a() throws IOException {
        this.f9651a.position(0);
        return this.f9651a;
    }
}
