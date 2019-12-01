package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.h.a;

/* compiled from: ProcessLifecycleOwner */
public class A implements l {

    /* renamed from: a reason: collision with root package name */
    private static final A f1593a = new A();

    /* renamed from: b reason: collision with root package name */
    private int f1594b = 0;

    /* renamed from: c reason: collision with root package name */
    private int f1595c = 0;

    /* renamed from: d reason: collision with root package name */
    private boolean f1596d = true;

    /* renamed from: e reason: collision with root package name */
    private boolean f1597e = true;

    /* renamed from: f reason: collision with root package name */
    private Handler f1598f;

    /* renamed from: g reason: collision with root package name */
    private final n f1599g = new n(this);

    /* renamed from: h reason: collision with root package name */
    private Runnable f1600h = new x(this);

    /* renamed from: i reason: collision with root package name */
    a f1601i = new y(this);

    private A() {
    }

    static void b(Context context) {
        f1593a.a(context);
    }

    public static l g() {
        return f1593a;
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f1595c--;
        if (this.f1595c == 0) {
            this.f1598f.postDelayed(this.f1600h, 700);
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.f1594b++;
        if (this.f1594b == 1 && this.f1597e) {
            this.f1599g.b(a.ON_START);
            this.f1597e = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        this.f1594b--;
        f();
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        if (this.f1595c == 0) {
            this.f1596d = true;
            this.f1599g.b(a.ON_PAUSE);
        }
    }

    /* access modifiers changed from: 0000 */
    public void f() {
        if (this.f1594b == 0 && this.f1596d) {
            this.f1599g.b(a.ON_STOP);
            this.f1597e = true;
        }
    }

    public h getLifecycle() {
        return this.f1599g;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f1595c++;
        if (this.f1595c != 1) {
            return;
        }
        if (this.f1596d) {
            this.f1599g.b(a.ON_RESUME);
            this.f1596d = false;
            return;
        }
        this.f1598f.removeCallbacks(this.f1600h);
    }

    /* access modifiers changed from: 0000 */
    public void a(Context context) {
        this.f1598f = new Handler();
        this.f1599g.b(a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new z(this));
    }
}
