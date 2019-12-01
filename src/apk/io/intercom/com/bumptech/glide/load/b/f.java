package io.intercom.com.bumptech.glide.load.b;

import android.util.Log;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader */
public class f implements u<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader */
    private static class a implements io.intercom.com.bumptech.glide.load.a.b<ByteBuffer> {

        /* renamed from: a reason: collision with root package name */
        private final File f9504a;

        a(File file) {
            this.f9504a = file;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(io.intercom.com.bumptech.glide.h.a.a(this.f9504a));
            } catch (IOException e2) {
                String str = "ByteBufferFileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    /* compiled from: ByteBufferFileLoader */
    public static class b implements v<File, ByteBuffer> {
        public u<File, ByteBuffer> a(y yVar) {
            return new f();
        }
    }

    public boolean a(File file) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<ByteBuffer> a(File file, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(file), new a(file));
    }
}
