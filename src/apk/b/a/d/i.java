package b.a.d;

import android.view.animation.Interpolator;
import b.g.i.K;
import b.g.i.L;
import b.g.i.M;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class i {

    /* renamed from: a reason: collision with root package name */
    final ArrayList<K> f2230a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    private long f2231b = -1;

    /* renamed from: c reason: collision with root package name */
    private Interpolator f2232c;

    /* renamed from: d reason: collision with root package name */
    L f2233d;

    /* renamed from: e reason: collision with root package name */
    private boolean f2234e;

    /* renamed from: f reason: collision with root package name */
    private final M f2235f = new h(this);

    public i a(K k2) {
        if (!this.f2234e) {
            this.f2230a.add(k2);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f2234e = false;
    }

    public void c() {
        if (!this.f2234e) {
            Iterator it = this.f2230a.iterator();
            while (it.hasNext()) {
                K k2 = (K) it.next();
                long j2 = this.f2231b;
                if (j2 >= 0) {
                    k2.a(j2);
                }
                Interpolator interpolator = this.f2232c;
                if (interpolator != null) {
                    k2.a(interpolator);
                }
                if (this.f2233d != null) {
                    k2.a((L) this.f2235f);
                }
                k2.c();
            }
            this.f2234e = true;
        }
    }

    public i a(K k2, K k3) {
        this.f2230a.add(k2);
        k3.b(k2.b());
        this.f2230a.add(k3);
        return this;
    }

    public void a() {
        if (this.f2234e) {
            Iterator it = this.f2230a.iterator();
            while (it.hasNext()) {
                ((K) it.next()).a();
            }
            this.f2234e = false;
        }
    }

    public i a(long j2) {
        if (!this.f2234e) {
            this.f2231b = j2;
        }
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.f2234e) {
            this.f2232c = interpolator;
        }
        return this;
    }

    public i a(L l2) {
        if (!this.f2234e) {
            this.f2233d = l2;
        }
        return this;
    }
}
