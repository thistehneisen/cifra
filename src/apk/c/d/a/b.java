package c.d.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: SmartTabIndicationInterpolator */
public abstract class b {

    /* renamed from: a reason: collision with root package name */
    public static final b f3226a = new C0040b();

    /* renamed from: b reason: collision with root package name */
    public static final b f3227b = new a();

    /* compiled from: SmartTabIndicationInterpolator */
    public static class a extends b {
        public float a(float f2) {
            return f2;
        }

        public float b(float f2) {
            return f2;
        }
    }

    /* renamed from: c.d.a.b$b reason: collision with other inner class name */
    /* compiled from: SmartTabIndicationInterpolator */
    public static class C0040b extends b {

        /* renamed from: c reason: collision with root package name */
        private final Interpolator f3228c;

        /* renamed from: d reason: collision with root package name */
        private final Interpolator f3229d;

        public C0040b() {
            this(3.0f);
        }

        public float a(float f2) {
            return this.f3228c.getInterpolation(f2);
        }

        public float b(float f2) {
            return this.f3229d.getInterpolation(f2);
        }

        public float c(float f2) {
            return 1.0f / ((1.0f - a(f2)) + b(f2));
        }

        public C0040b(float f2) {
            this.f3228c = new AccelerateInterpolator(f2);
            this.f3229d = new DecelerateInterpolator(f2);
        }
    }

    public static b a(int i2) {
        if (i2 == 0) {
            return f3226a;
        }
        if (i2 == 1) {
            return f3227b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown id: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract float a(float f2);

    public abstract float b(float f2);

    public float c(float f2) {
        return 1.0f;
    }
}
