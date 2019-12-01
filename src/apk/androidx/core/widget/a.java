package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import b.g.i.B;

/* compiled from: AutoScrollHelper */
public abstract class a implements OnTouchListener {

    /* renamed from: a reason: collision with root package name */
    private static final int f1345a = ViewConfiguration.getTapTimeout();

    /* renamed from: b reason: collision with root package name */
    final C0011a f1346b = new C0011a();

    /* renamed from: c reason: collision with root package name */
    private final Interpolator f1347c = new AccelerateInterpolator();

    /* renamed from: d reason: collision with root package name */
    final View f1348d;

    /* renamed from: e reason: collision with root package name */
    private Runnable f1349e;

    /* renamed from: f reason: collision with root package name */
    private float[] f1350f = {0.0f, 0.0f};

    /* renamed from: g reason: collision with root package name */
    private float[] f1351g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h reason: collision with root package name */
    private int f1352h;

    /* renamed from: i reason: collision with root package name */
    private int f1353i;

    /* renamed from: j reason: collision with root package name */
    private float[] f1354j = {0.0f, 0.0f};

    /* renamed from: k reason: collision with root package name */
    private float[] f1355k = {0.0f, 0.0f};

    /* renamed from: l reason: collision with root package name */
    private float[] f1356l = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: androidx.core.widget.a$a reason: collision with other inner class name */
    /* compiled from: AutoScrollHelper */
    private static class C0011a {

        /* renamed from: a reason: collision with root package name */
        private int f1357a;

        /* renamed from: b reason: collision with root package name */
        private int f1358b;

        /* renamed from: c reason: collision with root package name */
        private float f1359c;

        /* renamed from: d reason: collision with root package name */
        private float f1360d;

        /* renamed from: e reason: collision with root package name */
        private long f1361e = Long.MIN_VALUE;

        /* renamed from: f reason: collision with root package name */
        private long f1362f = 0;

        /* renamed from: g reason: collision with root package name */
        private int f1363g = 0;

        /* renamed from: h reason: collision with root package name */
        private int f1364h = 0;

        /* renamed from: i reason: collision with root package name */
        private long f1365i = -1;

        /* renamed from: j reason: collision with root package name */
        private float f1366j;

        /* renamed from: k reason: collision with root package name */
        private int f1367k;

        C0011a() {
        }

        private float a(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        public void a(int i2) {
            this.f1358b = i2;
        }

        public void b(int i2) {
            this.f1357a = i2;
        }

        public int c() {
            return this.f1364h;
        }

        public int d() {
            float f2 = this.f1359c;
            return (int) (f2 / Math.abs(f2));
        }

        public int e() {
            float f2 = this.f1360d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean f() {
            return this.f1365i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1365i + ((long) this.f1367k);
        }

        public void g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1367k = a.a((int) (currentAnimationTimeMillis - this.f1361e), 0, this.f1358b);
            this.f1366j = a(currentAnimationTimeMillis);
            this.f1365i = currentAnimationTimeMillis;
        }

        public void h() {
            this.f1361e = AnimationUtils.currentAnimationTimeMillis();
            this.f1365i = -1;
            this.f1362f = this.f1361e;
            this.f1366j = 0.5f;
            this.f1363g = 0;
            this.f1364h = 0;
        }

        private float a(long j2) {
            if (j2 < this.f1361e) {
                return 0.0f;
            }
            long j3 = this.f1365i;
            if (j3 < 0 || j2 < j3) {
                return a.a(((float) (j2 - this.f1361e)) / ((float) this.f1357a), 0.0f, 1.0f) * 0.5f;
            }
            long j4 = j2 - j3;
            float f2 = this.f1366j;
            return (1.0f - f2) + (f2 * a.a(((float) j4) / ((float) this.f1367k), 0.0f, 1.0f));
        }

        public int b() {
            return this.f1363g;
        }

        public void a() {
            if (this.f1362f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                long j2 = currentAnimationTimeMillis - this.f1362f;
                this.f1362f = currentAnimationTimeMillis;
                float f2 = ((float) j2) * a2;
                this.f1363g = (int) (this.f1359c * f2);
                this.f1364h = (int) (f2 * this.f1360d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.f1359c = f2;
            this.f1360d = f3;
        }
    }

    /* compiled from: AutoScrollHelper */
    private class b implements Runnable {
        b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.f1346b.h();
                }
                C0011a aVar2 = a.this.f1346b;
                if (aVar2.f() || !a.this.b()) {
                    a.this.p = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.o) {
                    aVar3.o = false;
                    aVar3.a();
                }
                aVar2.a();
                a.this.a(aVar2.b(), aVar2.c());
                B.a(a.this.f1348d, (Runnable) this);
            }
        }
    }

    public a(View view) {
        this.f1348d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        int i2 = (int) ((f2 * 315.0f) + 0.5f);
        float f3 = (float) ((int) ((1575.0f * f2) + 0.5f));
        b(f3, f3);
        float f4 = (float) i2;
        c(f4, f4);
        d(1);
        a(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        e(1.0f, 1.0f);
        c(f1345a);
        f(500);
        e(500);
    }

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public a a(boolean z) {
        if (this.q && !z) {
            c();
        }
        this.q = z;
        return this;
    }

    public abstract void a(int i2, int i3);

    public abstract boolean a(int i2);

    public a b(float f2, float f3) {
        float[] fArr = this.f1356l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public abstract boolean b(int i2);

    public a c(float f2, float f3) {
        float[] fArr = this.f1355k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a d(int i2) {
        this.f1352h = i2;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.f1354j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a f(int i2) {
        this.f1346b.b(i2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (!this.q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            c();
            if (this.r && this.p) {
                z = true;
            }
            return z;
        }
        this.o = true;
        this.m = false;
        this.f1346b.a(a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1348d.getWidth()), a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1348d.getHeight()));
        if (!this.p && b()) {
            d();
        }
        z = true;
        return z;
    }

    private float f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1352h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.p || this.f1352h != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    public a d(float f2, float f3) {
        float[] fArr = this.f1350f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        C0011a aVar = this.f1346b;
        int e2 = aVar.e();
        int d2 = aVar.d();
        return (e2 != 0 && b(e2)) || (d2 != 0 && a(d2));
    }

    public a c(int i2) {
        this.f1353i = i2;
        return this;
    }

    public a e(int i2) {
        this.f1346b.a(i2);
        return this;
    }

    private void c() {
        if (this.n) {
            this.p = false;
        } else {
            this.f1346b.g();
        }
    }

    private void d() {
        if (this.f1349e == null) {
            this.f1349e = new b();
        }
        this.p = true;
        this.n = true;
        if (!this.m) {
            int i2 = this.f1353i;
            if (i2 > 0) {
                B.a(this.f1348d, this.f1349e, (long) i2);
                this.m = true;
            }
        }
        this.f1349e.run();
        this.m = true;
    }

    public a a(float f2, float f3) {
        float[] fArr = this.f1351g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    private float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.f1350f[i2], f3, this.f1351g[i2], f2);
        int i3 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.f1354j[i2];
        float f6 = this.f1355k[i2];
        float f7 = this.f1356l[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float a2 = a(f2 * f3, 0.0f, f4);
        float f7 = f(f3 - f5, a2) - f(f5, a2);
        if (f7 < 0.0f) {
            f6 = -this.f1347c.getInterpolation(-f7);
        } else if (f7 <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.f1347c.getInterpolation(f7);
        }
        return a(f6, -1.0f, 1.0f);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1348d.onTouchEvent(obtain);
        obtain.recycle();
    }
}
