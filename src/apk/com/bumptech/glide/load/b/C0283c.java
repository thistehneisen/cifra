package com.bumptech.glide.load.b;

import com.bumptech.glide.j;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.c reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
public class C0283c<Data> implements u<byte[], Data> {

    /* renamed from: a reason: collision with root package name */
    private final b<Data> f3630a;

    /* renamed from: com.bumptech.glide.load.b.c$a */
    /* compiled from: ByteArrayLoader */
    public static class a implements v<byte[], ByteBuffer> {
        public u<byte[], ByteBuffer> a(y yVar) {
            return new C0283c(new C0282b(this));
        }

        public void a() {
        }
    }

    /* renamed from: com.bumptech.glide.load.b.c$b */
    /* compiled from: ByteArrayLoader */
    public interface b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* renamed from: com.bumptech.glide.load.b.c$c reason: collision with other inner class name */
    /* compiled from: ByteArrayLoader */
    private static class C0052c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a reason: collision with root package name */
        private final byte[] f3631a;

        /* renamed from: b reason: collision with root package name */
        private final b<Data> f3632b;

        C0052c(byte[] bArr, b<Data> bVar) {
            this.f3631a = bArr;
            this.f3632b = bVar;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super Data> aVar) {
            aVar.a(this.f3632b.a(this.f3631a));
        }

        public void b() {
        }

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f3632b.a();
        }
    }

    /* renamed from: com.bumptech.glide.load.b.c$d */
    /* compiled from: ByteArrayLoader */
    public static class d implements v<byte[], InputStream> {
        public u<byte[], InputStream> a(y yVar) {
            return new C0283c(new C0284d(this));
        }

        public void a() {
        }
    }

    public C0283c(b<Data> bVar) {
        this.f3630a = bVar;
    }

    public boolean a(byte[] bArr) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(byte[] bArr, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(bArr), new C0052c(bArr, this.f3630a));
    }
}
