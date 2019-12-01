package com.bumptech.glide.load.c.b;

import com.bumptech.glide.load.a.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder */
public class a implements e<ByteBuffer> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f3787a;

    /* renamed from: com.bumptech.glide.load.c.b.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferRewinder */
    public static class C0054a implements com.bumptech.glide.load.a.e.a<ByteBuffer> {
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f3787a = byteBuffer;
    }

    public void b() {
    }

    public ByteBuffer a() {
        this.f3787a.position(0);
        return this.f3787a;
    }
}
