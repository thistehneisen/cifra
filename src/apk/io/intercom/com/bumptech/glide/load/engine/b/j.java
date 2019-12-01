package io.intercom.com.bumptech.glide.load.engine.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator */
public final class j {

    /* renamed from: a reason: collision with root package name */
    private final int f9821a;

    /* renamed from: b reason: collision with root package name */
    private final int f9822b;

    /* renamed from: c reason: collision with root package name */
    private final Context f9823c;

    /* renamed from: d reason: collision with root package name */
    private final int f9824d;

    /* compiled from: MemorySizeCalculator */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        static final int f9825a = (VERSION.SDK_INT < 26 ? 4 : 1);
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final Context f9826b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public ActivityManager f9827c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public c f9828d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public float f9829e = 2.0f;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public float f9830f = ((float) f9825a);
        /* access modifiers changed from: private */

        /* renamed from: g reason: collision with root package name */
        public float f9831g = 0.4f;
        /* access modifiers changed from: private */

        /* renamed from: h reason: collision with root package name */
        public float f9832h = 0.33f;
        /* access modifiers changed from: private */

        /* renamed from: i reason: collision with root package name */
        public int f9833i = 4194304;

        public a(Context context) {
            this.f9826b = context;
            this.f9827c = (ActivityManager) context.getSystemService("activity");
            this.f9828d = new b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && j.b(this.f9827c)) {
                this.f9830f = 0.0f;
            }
        }

        public j a() {
            return new j(this);
        }
    }

    /* compiled from: MemorySizeCalculator */
    private static final class b implements c {

        /* renamed from: a reason: collision with root package name */
        private final DisplayMetrics f9834a;

        b(DisplayMetrics displayMetrics) {
            this.f9834a = displayMetrics;
        }

        public int a() {
            return this.f9834a.heightPixels;
        }

        public int b() {
            return this.f9834a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator */
    interface c {
        int a();

        int b();
    }

    j(a aVar) {
        int i2;
        this.f9823c = aVar.f9826b;
        if (b(aVar.f9827c)) {
            i2 = aVar.f9833i / 2;
        } else {
            i2 = aVar.f9833i;
        }
        this.f9824d = i2;
        int a2 = a(aVar.f9827c, aVar.f9831g, aVar.f9832h);
        float b2 = (float) (aVar.f9828d.b() * aVar.f9828d.a() * 4);
        int round = Math.round(aVar.f9830f * b2);
        int round2 = Math.round(b2 * aVar.f9829e);
        int i3 = a2 - this.f9824d;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f9822b = round2;
            this.f9821a = round;
        } else {
            float g2 = ((float) i3) / (aVar.f9830f + aVar.f9829e);
            this.f9822b = Math.round(aVar.f9829e * g2);
            this.f9821a = Math.round(g2 * aVar.f9830f);
        }
        String str = "MemorySizeCalculator";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f9822b));
            sb.append(", pool size: ");
            sb.append(a(this.f9821a));
            sb.append(", byte array size: ");
            sb.append(a(this.f9824d));
            sb.append(", memory class limited? ");
            sb.append(i4 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f9827c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(b(aVar.f9827c));
            Log.d(str, sb.toString());
        }
    }

    public int b() {
        return this.f9821a;
    }

    public int c() {
        return this.f9822b;
    }

    /* access modifiers changed from: private */
    public static boolean b(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }

    public int a() {
        return this.f9824d;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (b(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f9823c, (long) i2);
    }
}
