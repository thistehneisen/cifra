package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.t.a;
import androidx.recyclerview.widget.RecyclerView.u;
import io.fabric.sdk.android.a.b.C0730a;

/* compiled from: LinearSmoothScroller */
public class D extends t {

    /* renamed from: i reason: collision with root package name */
    protected final LinearInterpolator f1690i = new LinearInterpolator();

    /* renamed from: j reason: collision with root package name */
    protected final DecelerateInterpolator f1691j = new DecelerateInterpolator();

    /* renamed from: k reason: collision with root package name */
    protected PointF f1692k;

    /* renamed from: l reason: collision with root package name */
    private final float f1693l;
    protected int m = 0;
    protected int n = 0;

    public D(Context context) {
        this.f1693l = a(context.getResources().getDisplayMetrics());
    }

    private int b(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public void a(View view, u uVar, a aVar) {
        int a2 = a(view, i());
        int b2 = b(view, j());
        int d2 = d((int) Math.sqrt((double) ((a2 * a2) + (b2 * b2))));
        if (d2 > 0) {
            aVar.a(-a2, -b2, d2, this.f1691j);
        }
    }

    public int b(View view, int i2) {
        i b2 = b();
        if (b2 == null || !b2.c()) {
            return 0;
        }
        j jVar = (j) view.getLayoutParams();
        return a(b2.k(view) - jVar.topMargin, b2.f(view) + jVar.bottomMargin, b2.getPaddingTop(), b2.i() - b2.getPaddingBottom(), i2);
    }

    /* access modifiers changed from: protected */
    public int d(int i2) {
        return (int) Math.ceil(((double) e(i2)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * this.f1693l));
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.n = 0;
        this.m = 0;
        this.f1692k = null;
    }

    /* access modifiers changed from: protected */
    public int i() {
        PointF pointF = this.f1692k;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int j() {
        PointF pointF = this.f1692k;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, u uVar, a aVar) {
        if (a() == 0) {
            h();
            return;
        }
        this.m = b(this.m, i2);
        this.n = b(this.n, i3);
        if (this.m == 0 && this.n == 0) {
            a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        PointF a2 = a(c());
        if (a2 == null || (a2.x == 0.0f && a2.y == 0.0f)) {
            aVar.a(c());
            h();
            return;
        }
        a(a2);
        this.f1692k = a2;
        this.m = (int) (a2.x * 10000.0f);
        this.n = (int) (a2.y * 10000.0f);
        aVar.a((int) (((float) this.m) * 1.2f), (int) (((float) this.n) * 1.2f), (int) (((float) e(C0730a.DEFAULT_TIMEOUT)) * 1.2f), this.f1690i);
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i2) {
        i b2 = b();
        if (b2 == null || !b2.b()) {
            return 0;
        }
        j jVar = (j) view.getLayoutParams();
        return a(b2.g(view) - jVar.leftMargin, b2.j(view) + jVar.rightMargin, b2.getPaddingLeft(), b2.o() - b2.getPaddingRight(), i2);
    }
}
