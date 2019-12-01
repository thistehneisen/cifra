package io.intercom.com.bumptech.glide.load.c.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import io.intercom.com.bumptech.glide.b.a.C0100a;
import io.intercom.com.bumptech.glide.b.c;
import io.intercom.com.bumptech.glide.b.d;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.e;
import io.intercom.com.bumptech.glide.load.f;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder */
public class a implements k<ByteBuffer, c> {

    /* renamed from: a reason: collision with root package name */
    private static final C0111a f9656a = new C0111a();

    /* renamed from: b reason: collision with root package name */
    private static final b f9657b = new b();

    /* renamed from: c reason: collision with root package name */
    private final Context f9658c;

    /* renamed from: d reason: collision with root package name */
    private final List<e> f9659d;

    /* renamed from: e reason: collision with root package name */
    private final b f9660e;

    /* renamed from: f reason: collision with root package name */
    private final C0111a f9661f;

    /* renamed from: g reason: collision with root package name */
    private final b f9662g;

    /* renamed from: io.intercom.com.bumptech.glide.load.c.e.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferGifDecoder */
    static class C0111a {
        C0111a() {
        }

        /* access modifiers changed from: 0000 */
        public io.intercom.com.bumptech.glide.b.a a(C0100a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
            return new io.intercom.com.bumptech.glide.b.e(aVar, cVar, byteBuffer, i2);
        }
    }

    /* compiled from: ByteBufferGifDecoder */
    static class b {

        /* renamed from: a reason: collision with root package name */
        private final Queue<d> f9663a = j.a(0);

        b() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized d a(ByteBuffer byteBuffer) {
            d dVar;
            dVar = (d) this.f9663a.poll();
            if (dVar == null) {
                dVar = new d();
            }
            dVar.a(byteBuffer);
            return dVar;
        }

        /* access modifiers changed from: 0000 */
        public synchronized void a(d dVar) {
            dVar.a();
            this.f9663a.offer(dVar);
        }
    }

    public a(Context context, List<e> list, io.intercom.com.bumptech.glide.load.engine.a.e eVar, io.intercom.com.bumptech.glide.load.engine.a.b bVar) {
        this(context, list, eVar, bVar, f9657b, f9656a);
    }

    a(Context context, List<e> list, io.intercom.com.bumptech.glide.load.engine.a.e eVar, io.intercom.com.bumptech.glide.load.engine.a.b bVar, b bVar2, C0111a aVar) {
        this.f9658c = context.getApplicationContext();
        this.f9659d = list;
        this.f9661f = aVar;
        this.f9662g = new b(eVar, bVar);
        this.f9660e = bVar2;
    }

    public boolean a(ByteBuffer byteBuffer, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f9697b)).booleanValue() && f.a(this.f9659d, byteBuffer) == io.intercom.com.bumptech.glide.load.e.a.GIF;
    }

    public e a(ByteBuffer byteBuffer, int i2, int i3, io.intercom.com.bumptech.glide.load.j jVar) {
        d a2 = this.f9660e.a(byteBuffer);
        try {
            e a3 = a(byteBuffer, i2, i3, a2, jVar);
            return a3;
        } finally {
            this.f9660e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, io.intercom.com.bumptech.glide.load.j jVar) {
        long a2 = io.intercom.com.bumptech.glide.h.d.a();
        c b2 = dVar.b();
        if (b2.b() <= 0 || b2.c() != 0) {
            return null;
        }
        Config config = jVar.a(i.f9696a) == io.intercom.com.bumptech.glide.load.b.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        io.intercom.com.bumptech.glide.b.a a3 = this.f9661f.a(this.f9662g, b2, byteBuffer, a(b2, i2, i3));
        a3.a(config);
        a3.advance();
        Bitmap a4 = a3.a();
        if (a4 == null) {
            return null;
        }
        c cVar = new c(this.f9658c, a3, io.intercom.com.bumptech.glide.load.c.b.a(), i2, i3, a4);
        String str = "BufferGifDecoder";
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Decoded GIF from stream in ");
            sb.append(io.intercom.com.bumptech.glide.h.d.a(a2));
            Log.v(str, sb.toString());
        }
        return new e(cVar);
    }

    private static int a(c cVar, int i2, int i3) {
        int i4;
        int min = Math.min(cVar.a() / i3, cVar.d() / i2);
        if (min == 0) {
            i4 = 0;
        } else {
            i4 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i4);
        String str = "BufferGifDecoder";
        if (Log.isLoggable(str, 2) && max > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(i2);
            String str2 = "x";
            sb.append(str2);
            sb.append(i3);
            sb.append("], actual dimens: [");
            sb.append(cVar.d());
            sb.append(str2);
            sb.append(cVar.a());
            sb.append("]");
            Log.v(str, sb.toString());
        }
        return max;
    }
}
