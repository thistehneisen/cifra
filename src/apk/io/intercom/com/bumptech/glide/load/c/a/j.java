package io.intercom.com.bumptech.glide.load.c.a;

/* compiled from: DownsampleStrategy */
public abstract class j {

    /* renamed from: a reason: collision with root package name */
    public static final j f9593a = new e();

    /* renamed from: b reason: collision with root package name */
    public static final j f9594b = new d();

    /* renamed from: c reason: collision with root package name */
    public static final j f9595c = new a();

    /* renamed from: d reason: collision with root package name */
    public static final j f9596d = new b();

    /* renamed from: e reason: collision with root package name */
    public static final j f9597e = new c();

    /* renamed from: f reason: collision with root package name */
    public static final j f9598f = new f();

    /* renamed from: g reason: collision with root package name */
    public static final j f9599g = f9594b;

    /* compiled from: DownsampleStrategy */
    private static class a extends j {
        a() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class b extends j {
        b() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i3) / ((float) i5), ((float) i2) / ((float) i4)));
            int i6 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i6 = 0;
            }
            return 1.0f / ((float) (max << i6));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class c extends j {
        c() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, j.f9593a.b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class d extends j {
        d() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class e extends j {
        e() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class f extends j {
        f() {
        }

        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy */
    public enum g {
        MEMORY,
        QUALITY
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}