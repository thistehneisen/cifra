package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.t.b;

/* compiled from: PagerSnapHelper */
public class K extends Z {

    /* renamed from: d reason: collision with root package name */
    private I f1702d;

    /* renamed from: e reason: collision with root package name */
    private I f1703e;

    private I d(i iVar) {
        I i2 = this.f1703e;
        if (i2 == null || i2.f1699a != iVar) {
            this.f1703e = I.a(iVar);
        }
        return this.f1703e;
    }

    private I e(i iVar) {
        I i2 = this.f1702d;
        if (i2 == null || i2.f1699a != iVar) {
            this.f1702d = I.b(iVar);
        }
        return this.f1702d;
    }

    public int[] a(i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.b()) {
            iArr[0] = a(iVar, view, d(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.c()) {
            iArr[1] = a(iVar, view, e(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public D b(i iVar) {
        if (!(iVar instanceof b)) {
            return null;
        }
        return new J(this, this.f1866a.getContext());
    }

    public View c(i iVar) {
        if (iVar.c()) {
            return a(iVar, e(iVar));
        }
        if (iVar.b()) {
            return a(iVar, d(iVar));
        }
        return null;
    }

    private View b(i iVar, I i2) {
        int f2 = iVar.f();
        View view = null;
        if (f2 == 0) {
            return null;
        }
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < f2; i4++) {
            View f3 = iVar.f(i4);
            int d2 = i2.d(f3);
            if (d2 < i3) {
                view = f3;
                i3 = d2;
            }
        }
        return view;
    }

    public int a(i iVar, int i2, int i3) {
        int k2 = iVar.k();
        if (k2 == 0) {
            return -1;
        }
        View view = null;
        if (iVar.c()) {
            view = b(iVar, e(iVar));
        } else if (iVar.b()) {
            view = b(iVar, d(iVar));
        }
        if (view == null) {
            return -1;
        }
        int m = iVar.m(view);
        if (m == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !iVar.b() ? i3 > 0 : i2 > 0;
        if (iVar instanceof b) {
            PointF c2 = ((b) iVar).c(k2 - 1);
            if (c2 != null && (c2.x < 0.0f || c2.y < 0.0f)) {
                z = true;
            }
        }
        if (z) {
            if (z2) {
                m--;
            }
        } else if (z2) {
            m++;
        }
        return m;
    }

    private int a(i iVar, View view, I i2) {
        int i3;
        int d2 = i2.d(view) + (i2.b(view) / 2);
        if (iVar.g()) {
            i3 = i2.f() + (i2.g() / 2);
        } else {
            i3 = i2.a() / 2;
        }
        return d2 - i3;
    }

    private View a(i iVar, I i2) {
        int i3;
        int f2 = iVar.f();
        View view = null;
        if (f2 == 0) {
            return null;
        }
        if (iVar.g()) {
            i3 = i2.f() + (i2.g() / 2);
        } else {
            i3 = i2.a() / 2;
        }
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < f2; i5++) {
            View f3 = iVar.f(i5);
            int abs = Math.abs((i2.d(f3) + (i2.b(f3) / 2)) - i3);
            if (abs < i4) {
                view = f3;
                i4 = abs;
            }
        }
        return view;
    }
}
