package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import b.g.i.a.d;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean H = false;
    int I = -1;
    int[] J;
    View[] K;
    final SparseIntArray L = new SparseIntArray();
    final SparseIntArray M = new SparseIntArray();
    c N = new a();
    final Rect O = new Rect();

    public static final class a extends c {
        public int a(int i2) {
            return 1;
        }

        public int c(int i2, int i3) {
            return i2 % i3;
        }
    }

    public static class b extends j {

        /* renamed from: e reason: collision with root package name */
        int f1695e = -1;

        /* renamed from: f reason: collision with root package name */
        int f1696f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int r() {
            return this.f1695e;
        }

        public int s() {
            return this.f1696f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static abstract class c {

        /* renamed from: a reason: collision with root package name */
        final SparseIntArray f1697a = new SparseIntArray();

        /* renamed from: b reason: collision with root package name */
        private boolean f1698b = false;

        public abstract int a(int i2);

        public void a() {
            this.f1697a.clear();
        }

        public int b(int i2, int i3) {
            int a2 = a(i2);
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int a3 = a(i6);
                i4 += a3;
                if (i4 == i3) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i3) {
                    i5++;
                    i4 = a3;
                }
            }
            return i4 + a2 > i3 ? i5 + 1 : i5;
        }

        public abstract int c(int i2, int i3);

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3) {
            if (!this.f1698b) {
                return c(i2, i3);
            }
            int i4 = this.f1697a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int c2 = c(i2, i3);
            this.f1697a.put(i2, c2);
            return c2;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        n(i.a(context, attributeSet, i2, i3).f1769b);
    }

    private void O() {
        int f2 = f();
        for (int i2 = 0; i2 < f2; i2++) {
            b bVar = (b) f(i2).getLayoutParams();
            int n = bVar.n();
            this.L.put(n, bVar.s());
            this.M.put(n, bVar.r());
        }
    }

    private void P() {
        this.L.clear();
        this.M.clear();
    }

    private void Q() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private void R() {
        int i2;
        int i3;
        if (I() == 1) {
            i3 = o() - getPaddingRight();
            i2 = getPaddingLeft();
        } else {
            i3 = i() - getPaddingBottom();
            i2 = getPaddingTop();
        }
        o(i3 - i2);
    }

    private void o(int i2) {
        this.J = a(this.J, this.I, i2);
    }

    public boolean C() {
        return this.D == null && !this.H;
    }

    public int a(p pVar, u uVar) {
        if (this.s == 1) {
            return this.I;
        }
        if (uVar.a() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.a() - 1) + 1;
    }

    public int b(p pVar, u uVar) {
        if (this.s == 0) {
            return this.I;
        }
        if (uVar.a() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.a() - 1) + 1;
    }

    public void c(boolean z) {
        if (!z) {
            super.c(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void d(RecyclerView recyclerView) {
        this.N.a();
    }

    public void e(p pVar, u uVar) {
        if (uVar.d()) {
            O();
        }
        super.e(pVar, uVar);
        P();
    }

    /* access modifiers changed from: 0000 */
    public int f(int i2, int i3) {
        if (this.s != 1 || !J()) {
            int[] iArr = this.J;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.J;
        int i4 = this.I;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public void g(u uVar) {
        super.g(uVar);
        this.H = false;
    }

    public void n(int i2) {
        if (i2 != this.I) {
            this.H = true;
            if (i2 >= 1) {
                this.I = i2;
                this.N.a();
                y();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Span count should be at least 1. Provided ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public j d() {
        if (this.s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    private int c(p pVar, u uVar, int i2) {
        if (!uVar.d()) {
            return this.N.a(i2);
        }
        int i3 = this.L.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int a2 = pVar.a(i2);
        if (a2 != -1) {
            return this.N.a(a2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i2);
        Log.w("GridLayoutManager", sb.toString());
        return 1;
    }

    public void a(p pVar, u uVar, View view, d dVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, uVar, bVar.n());
        if (this.s == 0) {
            dVar.b((Object) b.g.i.a.d.c.a(bVar.r(), bVar.s(), a2, 1, this.I > 1 && bVar.s() == this.I, false));
        } else {
            dVar.b((Object) b.g.i.a.d.c.a(a2, 1, bVar.r(), bVar.s(), this.I > 1 && bVar.s() == this.I, false));
        }
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        this.N.a();
    }

    public int b(int i2, p pVar, u uVar) {
        R();
        Q();
        return super.b(i2, pVar, uVar);
    }

    private void b(p pVar, u uVar, a aVar, int i2) {
        boolean z = i2 == 1;
        int b2 = b(pVar, uVar, aVar.f1706b);
        if (z) {
            while (b2 > 0) {
                int i3 = aVar.f1706b;
                if (i3 > 0) {
                    aVar.f1706b = i3 - 1;
                    b2 = b(pVar, uVar, aVar.f1706b);
                } else {
                    return;
                }
            }
            return;
        }
        int a2 = uVar.a() - 1;
        int i4 = aVar.f1706b;
        while (i4 < a2) {
            int i5 = i4 + 1;
            int b3 = b(pVar, uVar, i5);
            if (b3 <= b2) {
                break;
            }
            i4 = i5;
            b2 = b3;
        }
        aVar.f1706b = i4;
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        n(i2);
    }

    private int b(p pVar, u uVar, int i2) {
        if (!uVar.d()) {
            return this.N.a(i2, this.I);
        }
        int i3 = this.M.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int a2 = pVar.a(i2);
        if (a2 != -1) {
            return this.N.a(a2, this.I);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i2);
        Log.w("GridLayoutManager", sb.toString());
        return 0;
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        this.N.a();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.N.a();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.N.a();
    }

    public j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public j a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new b((MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    private void b(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1773b;
        int i5 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i6 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int f2 = f(bVar.f1695e, bVar.f1696f);
        if (this.s == 1) {
            i3 = i.a(f2, i2, i6, bVar.width, false);
            i4 = i.a(this.u.g(), j(), i5, bVar.height, true);
        } else {
            int a2 = i.a(f2, i2, i5, bVar.height, false);
            int a3 = i.a(this.u.g(), p(), i6, bVar.width, true);
            i4 = a2;
            i3 = a3;
        }
        a(view, i3, i4, z);
    }

    public boolean a(j jVar) {
        return jVar instanceof b;
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.J == null) {
            super.a(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.s == 1) {
            i5 = i.c(i3, rect.height() + paddingTop, m());
            int[] iArr = this.J;
            i4 = i.c(i2, iArr[iArr.length - 1] + paddingLeft, n());
        } else {
            i4 = i.c(i2, rect.width() + paddingLeft, n());
            int[] iArr2 = this.J;
            i5 = i.c(i3, iArr2[iArr2.length - 1] + paddingTop, m());
        }
        c(i4, i5);
    }

    static int[] a(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    /* access modifiers changed from: 0000 */
    public void a(p pVar, u uVar, a aVar, int i2) {
        super.a(pVar, uVar, aVar, i2);
        R();
        if (uVar.a() > 0 && !uVar.d()) {
            b(pVar, uVar, aVar, i2);
        }
        Q();
    }

    public int a(int i2, p pVar, u uVar) {
        R();
        Q();
        return super.a(i2, pVar, uVar);
    }

    /* access modifiers changed from: 0000 */
    public View a(p pVar, u uVar, int i2, int i3, int i4) {
        E();
        int f2 = this.u.f();
        int b2 = this.u.b();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View f3 = f(i2);
            int m = m(f3);
            if (m >= 0 && m < i4 && b(pVar, uVar, m) == 0) {
                if (((j) f3.getLayoutParams()).p()) {
                    if (view2 == null) {
                        view2 = f3;
                    }
                } else if (this.u.d(f3) < b2 && this.u.a(f3) >= f2) {
                    return f3;
                } else {
                    if (view == null) {
                        view = f3;
                    }
                }
            }
            i2 += i5;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private int a(p pVar, u uVar, int i2) {
        if (!uVar.d()) {
            return this.N.b(i2, this.I);
        }
        int a2 = pVar.a(i2);
        if (a2 != -1) {
            return this.N.b(a2, this.I);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(i2);
        Log.w("GridLayoutManager", sb.toString());
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public void a(u uVar, c cVar, androidx.recyclerview.widget.RecyclerView.i.a aVar) {
        int i2 = this.I;
        for (int i3 = 0; i3 < this.I && cVar.a(uVar) && i2 > 0; i3++) {
            int i4 = cVar.f1717d;
            aVar.a(i4, Math.max(0, cVar.f1720g));
            i2 -= this.N.a(i4);
            cVar.f1717d += cVar.f1718e;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(p pVar, u uVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        p pVar2 = pVar;
        u uVar2 = uVar;
        c cVar2 = cVar;
        b bVar2 = bVar;
        int e2 = this.u.e();
        boolean z2 = e2 != 1073741824;
        int i10 = f() > 0 ? this.J[this.I] : 0;
        if (z2) {
            R();
        }
        boolean z3 = cVar2.f1718e == 1;
        int i11 = this.I;
        if (!z3) {
            i11 = b(pVar2, uVar2, cVar2.f1717d) + c(pVar2, uVar2, cVar2.f1717d);
        }
        int i12 = 0;
        int i13 = 0;
        while (i13 < this.I && cVar2.a(uVar2) && i11 > 0) {
            int i14 = cVar2.f1717d;
            int c2 = c(pVar2, uVar2, i14);
            if (c2 <= this.I) {
                i11 -= c2;
                if (i11 < 0) {
                    break;
                }
                View a2 = cVar2.a(pVar2);
                if (a2 == null) {
                    break;
                }
                i12 += c2;
                this.K[i13] = a2;
                i13++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(i14);
                sb.append(" requires ");
                sb.append(c2);
                sb.append(" spans but GridLayoutManager has only ");
                sb.append(this.I);
                sb.append(" spans.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i13 == 0) {
            bVar2.f1711b = true;
            return;
        }
        float f2 = 0.0f;
        int i15 = i13;
        a(pVar, uVar, i13, i12, z3);
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            View view = this.K[i17];
            if (cVar2.f1724k != null) {
                z = false;
                if (z3) {
                    b(view);
                } else {
                    a(view, 0);
                }
            } else if (z3) {
                c(view);
                z = false;
            } else {
                z = false;
                b(view, 0);
            }
            a(view, this.O);
            b(view, e2, z);
            int b2 = this.u.b(view);
            if (b2 > i16) {
                i16 = b2;
            }
            float c3 = (((float) this.u.c(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).f1696f);
            if (c3 > f2) {
                f2 = c3;
            }
        }
        if (z2) {
            a(f2, i10);
            i16 = 0;
            for (int i18 = 0; i18 < i15; i18++) {
                View view2 = this.K[i18];
                b(view2, 1073741824, true);
                int b3 = this.u.b(view2);
                if (b3 > i16) {
                    i16 = b3;
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            View view3 = this.K[i19];
            if (this.u.b(view3) != i16) {
                b bVar3 = (b) view3.getLayoutParams();
                Rect rect = bVar3.f1773b;
                int i20 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i21 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int f3 = f(bVar3.f1695e, bVar3.f1696f);
                if (this.s == 1) {
                    i9 = i.a(f3, 1073741824, i21, bVar3.width, false);
                    i8 = MeasureSpec.makeMeasureSpec(i16 - i20, 1073741824);
                } else {
                    int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i16 - i21, 1073741824);
                    i8 = i.a(f3, 1073741824, i20, bVar3.height, false);
                    i9 = makeMeasureSpec;
                }
                a(view3, i9, i8, true);
            }
        }
        int i22 = 0;
        bVar2.f1710a = i16;
        if (this.s == 1) {
            if (cVar2.f1719f == -1) {
                int i23 = cVar2.f1715b;
                i2 = i23;
                i3 = i23 - i16;
            } else {
                int i24 = cVar2.f1715b;
                i3 = i24;
                i2 = i16 + i24;
            }
            i5 = 0;
            i4 = 0;
        } else if (cVar2.f1719f == -1) {
            int i25 = cVar2.f1715b;
            i3 = 0;
            i2 = 0;
            int i26 = i25 - i16;
            i4 = i25;
            i5 = i26;
        } else {
            i5 = cVar2.f1715b;
            i4 = i16 + i5;
            i3 = 0;
            i2 = 0;
        }
        while (i22 < i15) {
            View view4 = this.K[i22];
            b bVar4 = (b) view4.getLayoutParams();
            if (this.s != 1) {
                i3 = getPaddingTop() + this.J[bVar4.f1695e];
                i2 = this.u.c(view4) + i3;
            } else if (J()) {
                int paddingLeft = getPaddingLeft() + this.J[this.I - bVar4.f1695e];
                i6 = paddingLeft;
                i7 = paddingLeft - this.u.c(view4);
                int i27 = i3;
                int i28 = i2;
                a(view4, i7, i27, i6, i28);
                if (!bVar4.p() || bVar4.o()) {
                    bVar2.f1712c = true;
                }
                bVar2.f1713d |= view4.hasFocusable();
                i22++;
                i5 = i7;
                i3 = i27;
                i4 = i6;
                i2 = i28;
            } else {
                i5 = getPaddingLeft() + this.J[bVar4.f1695e];
                i4 = this.u.c(view4) + i5;
            }
            i7 = i5;
            i6 = i4;
            int i272 = i3;
            int i282 = i2;
            a(view4, i7, i272, i6, i282);
            if (!bVar4.p()) {
            }
            bVar2.f1712c = true;
            bVar2.f1713d |= view4.hasFocusable();
            i22++;
            i5 = i7;
            i3 = i272;
            i4 = i6;
            i2 = i282;
        }
        Arrays.fill(this.K, null);
    }

    private void a(float f2, int i2) {
        o(Math.max(Math.round(f2 * ((float) this.I)), i2));
    }

    private void a(View view, int i2, int i3, boolean z) {
        boolean z2;
        j jVar = (j) view.getLayoutParams();
        if (z) {
            z2 = b(view, i2, i3, jVar);
        } else {
            z2 = a(view, i2, i3, jVar);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    private void a(p pVar, u uVar, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = -1;
        if (z) {
            i7 = i2;
            i5 = 0;
            i4 = 1;
        } else {
            i5 = i2 - 1;
            i4 = -1;
        }
        while (i5 != i7) {
            View view = this.K[i5];
            b bVar = (b) view.getLayoutParams();
            bVar.f1696f = c(pVar, uVar, m(view));
            bVar.f1695e = i6;
            i6 += bVar.f1696f;
            i5 += i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f7, code lost:
        if (r13 == r11) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    public View a(View view, int i2, p pVar, u uVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        View view2;
        View view3;
        int i7;
        int i8;
        int i9;
        boolean z;
        p pVar2 = pVar;
        u uVar2 = uVar;
        View d2 = d(view);
        View view4 = null;
        if (d2 == null) {
            return null;
        }
        b bVar = (b) d2.getLayoutParams();
        int i10 = bVar.f1695e;
        int i11 = bVar.f1696f + i10;
        if (super.a(view, i2, pVar, uVar) == null) {
            return null;
        }
        if ((l(i2) == 1) != this.x) {
            i5 = f() - 1;
            i4 = -1;
            i3 = -1;
        } else {
            i4 = f();
            i5 = 0;
            i3 = 1;
        }
        boolean z2 = this.s == 1 && J();
        int a2 = a(pVar2, uVar2, i5);
        View view5 = null;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        while (i5 != i4) {
            int a3 = a(pVar2, uVar2, i5);
            View f2 = f(i5);
            if (f2 == d2) {
                break;
            }
            if (!f2.hasFocusable() || a3 == a2) {
                b bVar2 = (b) f2.getLayoutParams();
                int i16 = bVar2.f1695e;
                view2 = d2;
                int i17 = bVar2.f1696f + i16;
                if (f2.hasFocusable() && i16 == i10 && i17 == i11) {
                    return f2;
                }
                if ((!f2.hasFocusable() || view4 != null) && (f2.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i17, i11) - Math.max(i16, i10);
                    if (f2.hasFocusable()) {
                        if (min <= i13) {
                            if (min == i13) {
                            }
                        }
                        i7 = i12;
                    } else if (view4 == null) {
                        i7 = i12;
                        i6 = i4;
                        z = true;
                        if (a(f2, false, true)) {
                            i9 = i14;
                            if (min > i9) {
                                i8 = i15;
                                if (z) {
                                    if (f2.hasFocusable()) {
                                        i13 = Math.min(i17, i11) - Math.max(i16, i10);
                                        i14 = i9;
                                        i15 = i8;
                                        view5 = view3;
                                        i12 = bVar2.f1695e;
                                        view4 = f2;
                                    } else {
                                        view5 = f2;
                                        i14 = Math.min(i17, i11) - Math.max(i16, i10);
                                        i15 = bVar2.f1695e;
                                        i12 = i7;
                                    }
                                    i5 += i3;
                                    pVar2 = pVar;
                                    uVar2 = uVar;
                                    d2 = view2;
                                    i4 = i6;
                                }
                            } else {
                                if (min == i9) {
                                    i8 = i15;
                                    if (i16 <= i8) {
                                        z = false;
                                    }
                                }
                                i8 = i15;
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        i9 = i14;
                        i8 = i15;
                        z = false;
                        if (z) {
                        }
                    }
                    i7 = i12;
                    i6 = i4;
                    i9 = i14;
                    i8 = i15;
                    z = false;
                    if (z) {
                    }
                } else {
                    i7 = i12;
                    view3 = view5;
                }
                i6 = i4;
                i9 = i14;
                i8 = i15;
                z = true;
                if (z) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = d2;
                i7 = i12;
                view3 = view5;
                i6 = i4;
                i9 = i14;
                i8 = i15;
            }
            i14 = i9;
            i15 = i8;
            i12 = i7;
            view5 = view3;
            i5 += i3;
            pVar2 = pVar;
            uVar2 = uVar;
            d2 = view2;
            i4 = i6;
        }
        View view6 = view5;
        if (view4 == null) {
            view4 = view6;
        }
        return view4;
    }
}
