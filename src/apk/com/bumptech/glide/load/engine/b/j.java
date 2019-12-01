package com.bumptech.glide.load.engine.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator */
public final class j {

    /* renamed from: a reason: collision with root package name */
    private final int f3960a;

    /* renamed from: b reason: collision with root package name */
    private final int f3961b;

    /* renamed from: c reason: collision with root package name */
    private final Context f3962c;

    /* renamed from: d reason: collision with root package name */
    private final int f3963d;

    /* compiled from: MemorySizeCalculator */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        static final int f3964a = (VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: b reason: collision with root package name */
        final Context f3965b;

        /* renamed from: c reason: collision with root package name */
        ActivityManager f3966c;

        /* renamed from: d reason: collision with root package name */
        c f3967d;

        /* renamed from: e reason: collision with root package name */
        float f3968e = 2.0f;

        /* renamed from: f reason: collision with root package name */
        float f3969f = ((float) f3964a);

        /* renamed from: g reason: collision with root package name */
        float f3970g = 0.4f;

        /* renamed from: h reason: collision with root package name */
        float f3971h = 0.33f;

        /* renamed from: i reason: collision with root package name */
        int f3972i = 4194304;

        public a(Context context) {
            this.f3965b = context;
            this.f3966c = (ActivityManager) context.getSystemService("activity");
            this.f3967d = new b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && j.a(this.f3966c)) {
                this.f3969f = 0.0f;
            }
        }

        public j a() {
            return new j(this);
        }
    }

    /* compiled from: MemorySizeCalculator */
    private static final class b implements c {

        /* renamed from: a reason: collision with root package name */
        private final DisplayMetrics f3973a;

        b(DisplayMetrics displayMetrics) {
            this.f3973a = displayMetrics;
        }

        public int a() {
            return this.f3973a.heightPixels;
        }

        public int b() {
            return this.f3973a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator */
    interface c {
        int a();

        int b();
    }

    j(a aVar) {
        int i2;
        this.f3962c = aVar.f3965b;
        if (a(aVar.f3966c)) {
            i2 = aVar.f3972i / 2;
        } else {
            i2 = aVar.f3972i;
        }
        this.f3963d = i2;
        int a2 = a(aVar.f3966c, aVar.f3970g, aVar.f3971h);
        float b2 = (float) (aVar.f3967d.b() * aVar.f3967d.a() * 4);
        int round = Math.round(aVar.f3969f * b2);
        int round2 = Math.round(b2 * aVar.f3968e);
        int i3 = a2 - this.f3963d;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f3961b = round2;
            this.f3960a = round;
        } else {
            float f2 = (float) i3;
            float f3 = aVar.f3969f;
            float f4 = aVar.f3968e;
            float f5 = f2 / (f3 + f4);
            this.f3961b = Math.round(f4 * f5);
            this.f3960a = Math.round(f5 * aVar.f3969f);
        }
        String str = "MemorySizeCalculator";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f3961b));
            sb.append(", pool size: ");
            sb.append(a(this.f3960a));
            sb.append(", byte array size: ");
            sb.append(a(this.f3963d));
            sb.append(", memory class limited? ");
            sb.append(i4 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f3966c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f3966c));
            Log.d(str, sb.toString());
        }
    }

    public int a() {
        return this.f3963d;
    }

    public int b() {
        return this.f3960a;
    }

    public int c() {
        return this.f3961b;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f3962c, (long) i2);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
