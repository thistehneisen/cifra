package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;

/* compiled from: OrientationHelper */
public abstract class I {

    /* renamed from: a reason: collision with root package name */
    protected final i f1699a;

    /* renamed from: b reason: collision with root package name */
    private int f1700b;

    /* renamed from: c reason: collision with root package name */
    final Rect f1701c;

    /* synthetic */ I(i iVar, G g2) {
        this(iVar);
    }

    public static I a(i iVar, int i2) {
        if (i2 == 0) {
            return a(iVar);
        }
        if (i2 == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static I b(i iVar) {
        return new H(iVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f1700b) {
            return 0;
        }
        return g() - this.f1700b;
    }

    public void i() {
        this.f1700b = g();
    }

    private I(i iVar) {
        this.f1700b = Integer.MIN_VALUE;
        this.f1701c = new Rect();
        this.f1699a = iVar;
    }

    public static I a(i iVar) {
        return new G(iVar);
    }
}
