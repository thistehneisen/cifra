package io.intercom.com.bumptech.glide.load.engine.a;

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
    private static final Config f9783a = Config.ARGB_8888;

    /* renamed from: b reason: collision with root package name */
    private final l f9784b;

    /* renamed from: c reason: collision with root package name */
    private final Set<Config> f9785c;

    /* renamed from: d reason: collision with root package name */
    private final long f9786d;

    /* renamed from: e reason: collision with root package name */
    private final a f9787e;

    /* renamed from: f reason: collision with root package name */
    private long f9788f;

    /* renamed from: g reason: collision with root package name */
    private long f9789g;

    /* renamed from: h reason: collision with root package name */
    private int f9790h;

    /* renamed from: i reason: collision with root package name */
    private int f9791i;

    /* renamed from: j reason: collision with root package name */
    private int f9792j;

    /* renamed from: k reason: collision with root package name */
    private int f9793k;

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
        this.f9786d = j2;
        this.f9788f = j2;
        this.f9784b = lVar;
        this.f9785c = set;
        this.f9787e = new b();
    }

    private synchronized Bitmap b(int i2, int i3, Config config) {
        Bitmap bitmap;
        a(config);
        bitmap = this.f9784b.get(i2, i3, config != null ? config : f9783a);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.f9784b.a(i2, i3, config));
                Log.d("LruBitmapPool", sb.toString());
            }
            this.f9791i++;
        } else {
            this.f9790h++;
            this.f9789g -= (long) this.f9784b.b(bitmap);
            this.f9787e.a(bitmap);
            c(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.f9784b.a(i2, i3, config));
            Log.v("LruBitmapPool", sb2.toString());
        }
        b();
        return bitmap;
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    private void d() {
        a(this.f9788f);
    }

    @TargetApi(26)
    private static Set<Config> e() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l f() {
        if (VERSION.SDK_INT >= 19) {
            return new o();
        }
        return new c();
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f9784b.b(bitmap)) <= this.f9788f) {
                        if (this.f9785c.contains(bitmap.getConfig())) {
                            int b2 = this.f9784b.b(bitmap);
                            this.f9784b.a(bitmap);
                            this.f9787e.b(bitmap);
                            this.f9792j++;
                            this.f9789g += (long) b2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Put bitmap in pool=");
                                sb.append(this.f9784b.c(bitmap));
                                Log.v("LruBitmapPool", sb.toString());
                            }
                            b();
                            d();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f9784b.c(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f9785c.contains(bitmap.getConfig()));
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

    public Bitmap get(int i2, int i3, Config config) {
        Bitmap b2 = b(i2, i3, config);
        if (b2 == null) {
            return Bitmap.createBitmap(i2, i3, config);
        }
        b2.eraseColor(0);
        return b2;
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.f9790h);
        sb.append(", misses=");
        sb.append(this.f9791i);
        sb.append(", puts=");
        sb.append(this.f9792j);
        sb.append(", evictions=");
        sb.append(this.f9793k);
        sb.append(", currentSize=");
        sb.append(this.f9789g);
        sb.append(", maxSize=");
        sb.append(this.f9788f);
        sb.append("\nStrategy=");
        sb.append(this.f9784b);
        Log.v("LruBitmapPool", sb.toString());
    }

    public k(long j2) {
        this(j2, f(), e());
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }

    public Bitmap a(int i2, int i3, Config config) {
        Bitmap b2 = b(i2, i3, config);
        return b2 == null ? Bitmap.createBitmap(i2, i3, config) : b2;
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
        } else if (i2 >= 20) {
            a(this.f9788f / 2);
        }
    }

    private synchronized void a(long j2) {
        while (this.f9789g > j2) {
            Bitmap removeLast = this.f9784b.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.f9789g = 0;
                return;
            }
            this.f9787e.a(removeLast);
            this.f9789g -= (long) this.f9784b.b(removeLast);
            this.f9793k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.f9784b.c(removeLast));
                Log.d("LruBitmapPool", sb.toString());
            }
            b();
            removeLast.recycle();
        }
    }
}
