package com.bumptech.glide.load.engine.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool */
public class k implements e {

    /* renamed from: a reason: collision with root package name */
    private static final Config f3922a = Config.ARGB_8888;

    /* renamed from: b reason: collision with root package name */
    private final l f3923b;

    /* renamed from: c reason: collision with root package name */
    private final Set<Config> f3924c;

    /* renamed from: d reason: collision with root package name */
    private final long f3925d;

    /* renamed from: e reason: collision with root package name */
    private final a f3926e;

    /* renamed from: f reason: collision with root package name */
    private long f3927f;

    /* renamed from: g reason: collision with root package name */
    private long f3928g;

    /* renamed from: h reason: collision with root package name */
    private int f3929h;

    /* renamed from: i reason: collision with root package name */
    private int f3930i;

    /* renamed from: j reason: collision with root package name */
    private int f3931j;

    /* renamed from: k reason: collision with root package name */
    private int f3932k;

    /* compiled from: LruBitmapPool */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool */
    private static final class b implements a {
        b() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    k(long j2, l lVar, Set<Config> set) {
        this.f3925d = j2;
        this.f3927f = j2;
        this.f3923b = lVar;
        this.f3924c = set;
        this.f3926e = new b();
    }

    private synchronized Bitmap c(int i2, int i3, Config config) {
        Bitmap bitmap;
        a(config);
        bitmap = this.f3923b.get(i2, i3, config != null ? config : f3922a);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.f3923b.a(i2, i3, config));
                Log.d("LruBitmapPool", sb.toString());
            }
            this.f3930i++;
        } else {
            this.f3929h++;
            this.f3928g -= (long) this.f3923b.b(bitmap);
            this.f3926e.a(bitmap);
            c(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.f3923b.a(i2, i3, config));
            Log.v("LruBitmapPool", sb2.toString());
        }
        c();
        return bitmap;
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.f3929h);
        sb.append(", misses=");
        sb.append(this.f3930i);
        sb.append(", puts=");
        sb.append(this.f3931j);
        sb.append(", evictions=");
        sb.append(this.f3932k);
        sb.append(", currentSize=");
        sb.append(this.f3928g);
        sb.append(", maxSize=");
        sb.append(this.f3927f);
        sb.append("\nStrategy=");
        sb.append(this.f3923b);
        Log.v("LruBitmapPool", sb.toString());
    }

    private void e() {
        a(this.f3927f);
    }

    @TargetApi(26)
    private static Set<Config> f() {
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l g() {
        if (VERSION.SDK_INT >= 19) {
            return new o();
        }
        return new c();
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f3923b.b(bitmap)) <= this.f3927f) {
                        if (this.f3924c.contains(bitmap.getConfig())) {
                            int b2 = this.f3923b.b(bitmap);
                            this.f3923b.a(bitmap);
                            this.f3926e.b(bitmap);
                            this.f3931j++;
                            this.f3928g += (long) b2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Put bitmap in pool=");
                                sb.append(this.f3923b.c(bitmap));
                                Log.v("LruBitmapPool", sb.toString());
                            }
                            c();
                            e();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f3923b.c(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f3924c.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } finally {
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public long b() {
        return this.f3927f;
    }

    public Bitmap get(int i2, int i3, Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 == null) {
            return b(i2, i3, config);
        }
        c2.eraseColor(0);
        return c2;
    }

    private static Bitmap b(int i2, int i3, Config config) {
        if (config == null) {
            config = f3922a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public k(long j2) {
        this(j2, g(), f());
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    public Bitmap a(int i2, int i3, Config config) {
        Bitmap c2 = c(i2, i3, config);
        return c2 == null ? b(i2, i3, config) : c2;
    }

    @TargetApi(26)
    private static void a(Config config) {
        if (VERSION.SDK_INT >= 26 && config == Config.HARDWARE) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a mutable Bitmap with config: ");
            sb.append(config);
            sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a() {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        a(0);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i2);
            Log.d(str, sb.toString());
        }
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j2) {
        while (this.f3928g > j2) {
            Bitmap removeLast = this.f3923b.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.f3928g = 0;
                return;
            }
            this.f3926e.a(removeLast);
            this.f3928g -= (long) this.f3923b.b(removeLast);
            this.f3932k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.f3923b.c(removeLast));
                Log.d("LruBitmapPool", sb.toString());
            }
            c();
            removeLast.recycle();
        }
    }
}
