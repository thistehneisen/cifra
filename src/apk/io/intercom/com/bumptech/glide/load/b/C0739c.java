package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: io.intercom.com.bumptech.glide.load.b.c reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
public class C0739c<Data> implements u<byte[], Data> {

    /* renamed from: a reason: collision with root package name */
    private final b<Data> f9500a;

    /* renamed from: io.intercom.com.bumptech.glide.load.b.c$a */
    /* compiled from: ByteArrayLoader */
    public static class a implements v<byte[], ByteBuffer> {
        public u<byte[], ByteBuffer> a(y yVar) {
            return new C0739c(new C0738b(this));
        }
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.b.c$b */
    /* compiled from: ByteArrayLoader */
    public interface b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.b.c$c reason: collision with other inner class name */
    /* compiled from: ByteArrayLoader */
    private static class C0108c<Data> implements io.intercom.com.bumptech.glide.load.a.b<Data> {

        /* renamed from: a reason: collision with root package name */
        private final byte[] f9501a;

        /* renamed from: b reason: collision with root package name */
        private final b<Data> f9502b;

        C0108c(byte[] bArr, b<Data> bVar) {
            this.f9501a = bArr;
            this.f9502b = bVar;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super Data> aVar) {
            aVar.a(this.f9502b.a(this.f9501a));
        }

        public void b() {
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f9502b.a();
        }
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.b.c$d */
    /* compiled from: ByteArrayLoader */
    public static class d implements v<byte[], InputStream> {
        public u<byte[], InputStream> a(y yVar) {
            return new C0739c(new C0740d(this));
        }
    }

    public C0739c(b<Data> bVar) {
        this.f9500a = bVar;
    }

    public boolean a(byte[] bArr) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(byte[] bArr, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(bArr), new C0108c(bArr, this.f9500a));
    }
}
