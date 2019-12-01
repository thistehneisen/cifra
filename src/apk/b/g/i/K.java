package b.g.i;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class K {

    /* renamed from: a reason: collision with root package name */
    private WeakReference<View> f2655a;

    /* renamed from: b reason: collision with root package name */
    Runnable f2656b = null;

    /* renamed from: c reason: collision with root package name */
    Runnable f2657c = null;

    /* renamed from: d reason: collision with root package name */
    int f2658d = -1;

    /* compiled from: ViewPropertyAnimatorCompat */
    static class a implements L {

        /* renamed from: a reason: collision with root package name */
        K f2659a;

        /* renamed from: b reason: collision with root package name */
        boolean f2660b;

        a(K k2) {
            this.f2659a = k2;
        }

        public void a(View view) {
            Object tag = view.getTag(2113929216);
            L l2 = tag instanceof L ? (L) tag : null;
            if (l2 != null) {
                l2.a(view);
            }
        }

        public void b(View view) {
            int i2 = this.f2659a.f2658d;
            L l2 = null;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.f2659a.f2658d = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f2660b) {
                K k2 = this.f2659a;
                Runnable runnable = k2.f2657c;
                if (runnable != null) {
                    k2.f2657c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof L) {
                    l2 = (L) tag;
                }
                if (l2 != null) {
                    l2.b(view);
                }
                this.f2660b = true;
            }
        }

        public void c(View view) {
            this.f2660b = false;
            L l2 = null;
            if (this.f2659a.f2658d > -1) {
                view.setLayerType(2, null);
            }
            K k2 = this.f2659a;
            Runnable runnable = k2.f2656b;
            if (runnable != null) {
                k2.f2656b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof L) {
                l2 = (L) tag;
            }
            if (l2 != null) {
                l2.c(view);
            }
        }
    }

    K(View view) {
        this.f2655a = new WeakReference<>(view);
    }

    public K a(long j2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public K b(float f2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }

    public K c(float f2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public K a(float f2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public long b() {
        View view = (View) this.f2655a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public void c() {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public K a(Interpolator interpolator) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public K b(long j2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public void a() {
        View view = (View) this.f2655a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public K a(L l2) {
        View view = (View) this.f2655a.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                a(view, l2);
            } else {
                view.setTag(2113929216, l2);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(View view, L l2) {
        if (l2 != null) {
            view.animate().setListener(new I(this, l2, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public K a(N n) {
        View view = (View) this.f2655a.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            J j2 = null;
            if (n != null) {
                j2 = new J(this, n, view);
            }
            view.animate().setUpdateListener(j2);
        }
        return this;
    }
}
