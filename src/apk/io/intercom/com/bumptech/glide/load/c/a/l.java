package io.intercom.com.bumptech.glide.load.c.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import io.intercom.com.bumptech.glide.h.d;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.b;
import io.intercom.com.bumptech.glide.load.c.a.j.g;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.f;
import io.intercom.com.bumptech.glide.load.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public final class l {

    /* renamed from: a reason: collision with root package name */
    public static final i<b> f9603a = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.f9471d);

    /* renamed from: b reason: collision with root package name */
    public static final i<j> f9604b = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", j.f9599g);

    /* renamed from: c reason: collision with root package name */
    public static final i<Boolean> f9605c = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.valueOf(false));

    /* renamed from: d reason: collision with root package name */
    public static final i<Boolean> f9606d = i.a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);

    /* renamed from: e reason: collision with root package name */
    private static final Set<String> f9607e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: f reason: collision with root package name */
    private static final a f9608f = new k();

    /* renamed from: g reason: collision with root package name */
    private static final Set<io.intercom.com.bumptech.glide.load.e.a> f9609g = Collections.unmodifiableSet(EnumSet.of(io.intercom.com.bumptech.glide.load.e.a.JPEG, io.intercom.com.bumptech.glide.load.e.a.PNG_A, io.intercom.com.bumptech.glide.load.e.a.PNG));

    /* renamed from: h reason: collision with root package name */
    private static final Queue<Options> f9610h = j.a(0);

    /* renamed from: i reason: collision with root package name */
    private final e f9611i;

    /* renamed from: j reason: collision with root package name */
    private final DisplayMetrics f9612j;

    /* renamed from: k reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.a.b f9613k;

    /* renamed from: l reason: collision with root package name */
    private final List<io.intercom.com.bumptech.glide.load.e> f9614l;
    private final q m = q.a();

    /* compiled from: Downsampler */
    public interface a {
        void a();

        void a(e eVar, Bitmap bitmap) throws IOException;
    }

    public l(List<io.intercom.com.bumptech.glide.load.e> list, DisplayMetrics displayMetrics, e eVar, io.intercom.com.bumptech.glide.load.engine.a.b bVar) {
        this.f9614l = list;
        h.a(displayMetrics);
        this.f9612j = displayMetrics;
        h.a(eVar);
        this.f9611i = eVar;
        h.a(bVar);
        this.f9613k = bVar;
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(Options options) {
        d(options);
        synchronized (f9610h) {
            f9610h.offer(options);
        }
    }

    private static void d(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public E<Bitmap> a(InputStream inputStream, int i2, int i3, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        return a(inputStream, i2, i3, jVar, f9608f);
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private static int[] b(InputStream inputStream, Options options, a aVar, e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public E<Bitmap> a(InputStream inputStream, int i2, int i3, io.intercom.com.bumptech.glide.load.j jVar, a aVar) throws IOException {
        io.intercom.com.bumptech.glide.load.j jVar2 = jVar;
        h.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f9613k.b(65536, byte[].class);
        Options a2 = a();
        a2.inTempStorage = bArr;
        b bVar = (b) jVar2.a(f9603a);
        try {
            return d.a(a(inputStream, a2, (j) jVar2.a(f9604b), bVar, bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : jVar2.a(f9606d) != null && ((Boolean) jVar2.a(f9606d)).booleanValue(), i2, i3, ((Boolean) jVar2.a(f9605c)).booleanValue(), aVar), this.f9611i);
        } finally {
            c(a2);
            this.f9613k.put(bArr);
        }
    }

    private static boolean b(Options options) {
        int i2 = options.inTargetDensity;
        if (i2 > 0) {
            int i3 = options.inDensity;
            if (i3 > 0 && i2 != i3) {
                return true;
            }
        }
        return false;
    }

    private Bitmap a(InputStream inputStream, Options options, j jVar, b bVar, boolean z, int i2, int i3, boolean z2, a aVar) throws IOException {
        int i4;
        int i5;
        l lVar;
        int i6;
        int i7;
        int i8;
        InputStream inputStream2 = inputStream;
        Options options2 = options;
        a aVar2 = aVar;
        long a2 = d.a();
        int[] b2 = b(inputStream2, options2, aVar2, this.f9611i);
        boolean z3 = false;
        int i9 = b2[0];
        int i10 = b2[1];
        String str = options2.outMimeType;
        boolean z4 = (i9 == -1 || i10 == -1) ? false : z;
        int a3 = f.a(this.f9614l, inputStream2, this.f9613k);
        int a4 = v.a(a3);
        boolean b3 = v.b(a3);
        int i11 = i2;
        if (i11 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = i9;
        } else {
            i5 = i3;
            i4 = i11;
        }
        int i12 = i5 == Integer.MIN_VALUE ? i10 : i5;
        io.intercom.com.bumptech.glide.load.e.a b4 = f.b(this.f9614l, inputStream2, this.f9613k);
        e eVar = this.f9611i;
        io.intercom.com.bumptech.glide.load.e.a aVar3 = b4;
        a(b4, inputStream, aVar, eVar, jVar, a4, i9, i10, i4, i12, options);
        int i13 = a3;
        String str2 = str;
        int i14 = i10;
        int i15 = i9;
        a aVar4 = aVar2;
        Options options3 = options2;
        a(inputStream, bVar, z4, b3, options, i4, i12);
        if (VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        String str3 = "Downsampler";
        if (options3.inSampleSize == 1 || z3) {
            lVar = this;
            if (lVar.a(aVar3)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z3) {
                    float f2 = b(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f3 = (float) i16;
                    int ceil = (int) Math.ceil((double) (((float) i15) / f3));
                    int ceil2 = (int) Math.ceil((double) (((float) i14) / f3));
                    i8 = Math.round(((float) ceil) * f2);
                    i7 = Math.round(((float) ceil2) * f2);
                    if (Log.isLoggable(str3, 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Calculated target [");
                        sb.append(i8);
                        String str4 = "x";
                        sb.append(str4);
                        sb.append(i7);
                        sb.append("] for source [");
                        sb.append(i15);
                        sb.append(str4);
                        sb.append(i14);
                        sb.append("], sampleSize: ");
                        sb.append(i16);
                        sb.append(", targetDensity: ");
                        sb.append(options3.inTargetDensity);
                        sb.append(", density: ");
                        sb.append(options3.inDensity);
                        sb.append(", density multiplier: ");
                        sb.append(f2);
                        Log.v(str3, sb.toString());
                    }
                } else {
                    i8 = i4;
                    i7 = i12;
                }
                if (i8 > 0 && i7 > 0) {
                    a(options3, lVar.f9611i, i8, i7);
                }
            }
        } else {
            lVar = this;
        }
        Bitmap a5 = a(inputStream, options3, aVar4, lVar.f9611i);
        aVar4.a(lVar.f9611i, a5);
        if (Log.isLoggable(str3, 2)) {
            i6 = i13;
            a(i15, i14, str2, options, a5, i2, i3, a2);
        } else {
            i6 = i13;
        }
        Bitmap bitmap = null;
        if (a5 != null) {
            a5.setDensity(lVar.f9612j.densityDpi);
            bitmap = v.a(lVar.f9611i, a5, i6);
            if (!a5.equals(bitmap)) {
                lVar.f9611i.a(a5);
            }
        }
        return bitmap;
    }

    private static void a(io.intercom.com.bumptech.glide.load.e.a aVar, InputStream inputStream, a aVar2, e eVar, j jVar, int i2, int i3, int i4, int i5, int i6, Options options) throws IOException {
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        double d2;
        io.intercom.com.bumptech.glide.load.e.a aVar3 = aVar;
        j jVar2 = jVar;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        Options options2 = options;
        String str = "]";
        String str2 = "Downsampler";
        String str3 = "x";
        if (i12 <= 0 || i13 <= 0) {
            String str4 = str2;
            String str5 = str3;
            if (Log.isLoggable(str4, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to determine dimensions for: ");
                sb.append(aVar3);
                sb.append(" with target [");
                sb.append(i14);
                sb.append(str5);
                sb.append(i15);
                sb.append(str);
                Log.d(str4, sb.toString());
            }
            return;
        }
        if (i11 == 90 || i11 == 270) {
            f2 = jVar2.b(i13, i12, i14, i15);
        } else {
            f2 = jVar2.b(i12, i13, i14, i15);
        }
        String str6 = "], target: [";
        if (f2 > 0.0f) {
            g a2 = jVar2.a(i12, i13, i14, i15);
            if (a2 != null) {
                float f3 = (float) i12;
                float f4 = (float) i13;
                String str7 = str2;
                String str8 = str3;
                int c2 = i12 / c((double) (f2 * f3));
                int c3 = i13 / c((double) (f2 * f4));
                if (a2 == g.MEMORY) {
                    i7 = Math.max(c2, c3);
                } else {
                    i7 = Math.min(c2, c3);
                }
                if (VERSION.SDK_INT > 23 || !f9607e.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i7));
                    i8 = (a2 != g.MEMORY || ((float) max) >= 1.0f / f2) ? max : max << 1;
                } else {
                    i8 = 1;
                }
                options2.inSampleSize = i8;
                if (aVar3 == io.intercom.com.bumptech.glide.load.e.a.JPEG) {
                    float min = (float) Math.min(i8, 8);
                    i9 = (int) Math.ceil((double) (f3 / min));
                    i10 = (int) Math.ceil((double) (f4 / min));
                    int i16 = i8 / 8;
                    if (i16 > 0) {
                        i9 /= i16;
                        i10 /= i16;
                    }
                } else {
                    if (aVar3 == io.intercom.com.bumptech.glide.load.e.a.PNG || aVar3 == io.intercom.com.bumptech.glide.load.e.a.PNG_A) {
                        float f5 = (float) i8;
                        i9 = (int) Math.floor((double) (f3 / f5));
                        d2 = Math.floor((double) (f4 / f5));
                    } else if (aVar3 == io.intercom.com.bumptech.glide.load.e.a.WEBP || aVar3 == io.intercom.com.bumptech.glide.load.e.a.WEBP_A) {
                        if (VERSION.SDK_INT >= 24) {
                            float f6 = (float) i8;
                            i9 = Math.round(f3 / f6);
                            i10 = Math.round(f4 / f6);
                        } else {
                            float f7 = (float) i8;
                            i9 = (int) Math.floor((double) (f3 / f7));
                            d2 = Math.floor((double) (f4 / f7));
                        }
                    } else if (i12 % i8 == 0 && i13 % i8 == 0) {
                        i9 = i12 / i8;
                        i10 = i13 / i8;
                    } else {
                        int[] b2 = b(inputStream, options2, aVar2, eVar);
                        int i17 = b2[0];
                        i10 = b2[1];
                        i9 = i17;
                    }
                    i10 = (int) d2;
                }
                double b3 = (double) jVar2.b(i9, i10, i14, i15);
                if (VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = a(b3);
                    options2.inDensity = b(b3);
                }
                if (b(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str9 = str7;
                if (Log.isLoggable(str9, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculate scaling, source: [");
                    sb2.append(i12);
                    String str10 = str8;
                    sb2.append(str10);
                    sb2.append(i13);
                    sb2.append(str6);
                    sb2.append(i14);
                    sb2.append(str10);
                    sb2.append(i15);
                    sb2.append("], power of two scaled: [");
                    sb2.append(i9);
                    sb2.append(str10);
                    sb2.append(i10);
                    sb2.append("], exact scale factor: ");
                    sb2.append(f2);
                    sb2.append(", power of 2 sample size: ");
                    sb2.append(i8);
                    sb2.append(", adjusted scale factor: ");
                    sb2.append(b3);
                    sb2.append(", target density: ");
                    sb2.append(options2.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options2.inDensity);
                    Log.v(str9, sb2.toString());
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str11 = str3;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Cannot scale with factor: ");
        sb3.append(f2);
        sb3.append(" from: ");
        sb3.append(jVar2);
        sb3.append(", source: [");
        sb3.append(i12);
        sb3.append(str11);
        sb3.append(i13);
        sb3.append(str6);
        sb3.append(i14);
        sb3.append(str11);
        sb3.append(i15);
        sb3.append(str);
        throw new IllegalArgumentException(sb3.toString());
    }

    private static int a(double d2) {
        int b2 = b(d2);
        int c2 = c(((double) b2) * d2);
        return c((d2 / ((double) (((float) c2) / ((float) b2)))) * ((double) c2));
    }

    private boolean a(io.intercom.com.bumptech.glide.load.e.a aVar) {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return f9609g.contains(aVar);
    }

    private void a(InputStream inputStream, b bVar, boolean z, boolean z2, Options options, int i2, int i3) {
        if (!this.m.a(i2, i3, options, bVar, z, z2)) {
            if (bVar == b.PREFER_ARGB_8888 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = f.b(this.f9614l, inputStream, this.f9613k).a();
            } catch (IOException e2) {
                String str = "Downsampler";
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header, format ");
                    sb.append(bVar);
                    Log.d(str, sb.toString(), e2);
                }
            }
            options.inPreferredConfig = z3 ? Config.ARGB_8888 : Config.RGB_565;
            if (options.inPreferredConfig == Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
    private static Bitmap a(InputStream inputStream, Options options, a aVar, e eVar) throws IOException {
        String str = "Downsampler";
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.a();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str2 = options.outMimeType;
        v.a().lock();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            v.a().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            return decodeStream;
        } catch (IllegalArgumentException e2) {
            IOException a2 = a(e2, i2, i3, str2, options);
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
            }
            if (options.inBitmap != null) {
                inputStream.reset();
                eVar.a(options.inBitmap);
                options.inBitmap = null;
                Bitmap a3 = a(inputStream, options, aVar, eVar);
                v.a().unlock();
                return a3;
            }
            throw a2;
        } catch (Throwable th) {
            v.a().unlock();
            throw th;
        }
    }

    private static void a(int i2, int i3, String str, Options options, Bitmap bitmap, int i4, int i5, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoded ");
        sb.append(a(bitmap));
        sb.append(" from [");
        sb.append(i2);
        String str2 = "x";
        sb.append(str2);
        sb.append(i3);
        sb.append("] ");
        sb.append(str);
        sb.append(" with inBitmap ");
        sb.append(a(options));
        sb.append(" for [");
        sb.append(i4);
        sb.append(str2);
        sb.append(i5);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(d.a(j2));
        Log.v("Downsampler", sb.toString());
    }

    private static String a(Options options) {
        return a(options.inBitmap);
    }

    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 19) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(bitmap.getAllocationByteCount());
            sb.append(")");
            str = sb.toString();
        } else {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(bitmap.getWidth());
        sb2.append("x");
        sb2.append(bitmap.getHeight());
        sb2.append("] ");
        sb2.append(bitmap.getConfig());
        sb2.append(str);
        return sb2.toString();
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, Options options) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception decoding bitmap, outWidth: ");
        sb.append(i2);
        sb.append(", outHeight: ");
        sb.append(i3);
        sb.append(", outMimeType: ");
        sb.append(str);
        sb.append(", inBitmap: ");
        sb.append(a(options));
        return new IOException(sb.toString(), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(Options options, e eVar, int i2, int i3) {
        if (VERSION.SDK_INT < 26 || options.inPreferredConfig != Config.HARDWARE) {
            options.inBitmap = eVar.a(i2, i3, options.inPreferredConfig);
        }
    }

    private static synchronized Options a() {
        Options options;
        synchronized (l.class) {
            synchronized (f9610h) {
                options = (Options) f9610h.poll();
            }
            if (options == null) {
                options = new Options();
                d(options);
            }
        }
        return options;
    }
}
