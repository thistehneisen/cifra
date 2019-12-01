package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader */
public class f implements u<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader */
    private static final class a implements d<ByteBuffer> {

        /* renamed from: a reason: collision with root package name */
        private final File f3634a;

        a(File file) {
            this.f3634a = file;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.bumptech.glide.h.a.a(this.f3634a));
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

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
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

        public void a() {
        }
    }

    public boolean a(File file) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<ByteBuffer> a(File file, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(file), new a(file));
    }
}
