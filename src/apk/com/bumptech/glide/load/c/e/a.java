package com.bumptech.glide.load.c.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.b.a.C0044a;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.e;
import com.bumptech.glide.h.h;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder */
public class a implements j<ByteBuffer, c> {

    /* renamed from: a reason: collision with root package name */
    private static final C0055a f3792a = new C0055a();

    /* renamed from: b reason: collision with root package name */
    private static final b f3793b = new b();

    /* renamed from: c reason: collision with root package name */
    private final Context f3794c;

    /* renamed from: d reason: collision with root package name */
    private final List<ImageHeaderParser> f3795d;

    /* renamed from: e reason: collision with root package name */
    private final b f3796e;

    /* renamed from: f reason: collision with root package name */
    private final C0055a f3797f;

    /* renamed from: g reason: collision with root package name */
    private final b f3798g;

    /* renamed from: com.bumptech.glide.load.c.e.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferGifDecoder */
    static class C0055a {
        C0055a() {
        }

        /* access modifiers changed from: 0000 */
        public com.bumptech.glide.b.a a(C0044a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
            return new e(aVar, cVar, byteBuffer, i2);
        }
    }

    /* compiled from: ByteBufferGifDecoder */
    static class b {

        /* renamed from: a reason: collision with root package name */
        private final Queue<d> f3799a = n.a(0);

        b() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized d a(ByteBuffer byteBuffer) {
            d dVar;
            dVar = (d) this.f3799a.poll();
            if (dVar == null) {
                dVar = new d();
            }
            dVar.a(byteBuffer);
            return dVar;
        }

        /* access modifiers changed from: 0000 */
        public synchronized void a(d dVar) {
            dVar.a();
            this.f3799a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this(context, list, eVar, bVar, f3793b, f3792a);
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar, b bVar2, C0055a aVar) {
        this.f3794c = context.getApplicationContext();
        this.f3795d = list;
        this.f3797f = aVar;
        this.f3798g = new b(eVar, bVar);
        this.f3796e = bVar2;
    }

    public boolean a(ByteBuffer byteBuffer, i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f3834b)).booleanValue() && com.bumptech.glide.load.e.a(this.f3795d, byteBuffer) == ImageType.GIF;
    }

    public e a(ByteBuffer byteBuffer, int i2, int i3, i iVar) {
        d a2 = this.f3796e.a(byteBuffer);
        try {
            e a3 = a(byteBuffer, i2, i3, a2, iVar);
            return a3;
        } finally {
            this.f3796e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, i iVar) {
        String str = "Decoded GIF from stream in ";
        String str2 = "BufferGifDecoder";
        long a2 = h.a();
        try {
            c b2 = dVar.b();
            if (b2.b() > 0) {
                if (b2.c() == 0) {
                    Config config = iVar.a(i.f3833a) == com.bumptech.glide.load.b.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
                    com.bumptech.glide.b.a a3 = this.f3797f.a(this.f3798g, b2, byteBuffer, a(b2, i2, i3));
                    a3.a(config);
                    a3.advance();
                    Bitmap a4 = a3.a();
                    if (a4 == null) {
                        if (Log.isLoggable(str2, 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(h.a(a2));
                            Log.v(str2, sb.toString());
                        }
                        return null;
                    }
                    c cVar = new c(this.f3794c, a3, com.bumptech.glide.load.c.b.a(), i2, i3, a4);
                    e eVar = new e(cVar);
                    if (Log.isLoggable(str2, 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(h.a(a2));
                        Log.v(str2, sb2.toString());
                    }
                    return eVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(h.a(a2));
                Log.v(str2, sb3.toString());
            }
        }
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
