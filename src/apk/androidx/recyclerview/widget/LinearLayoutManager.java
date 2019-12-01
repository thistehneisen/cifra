package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.RecyclerView.x;
import java.util.List;

public class LinearLayoutManager extends i implements C0239z, androidx.recyclerview.widget.RecyclerView.t.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    int s;
    private c t;
    I u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    static class a {

        /* renamed from: a reason: collision with root package name */
        I f1705a;

        /* renamed from: b reason: collision with root package name */
        int f1706b;

        /* renamed from: c reason: collision with root package name */
        int f1707c;

        /* renamed from: d reason: collision with root package name */
        boolean f1708d;

        /* renamed from: e reason: collision with root package name */
        boolean f1709e;

        a() {
            b();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            int i2;
            if (this.f1708d) {
                i2 = this.f1705a.b();
            } else {
                i2 = this.f1705a.f();
            }
            this.f1707c = i2;
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            this.f1706b = -1;
            this.f1707c = Integer.MIN_VALUE;
            this.f1708d = false;
            this.f1709e = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.f1706b);
            sb.append(", mCoordinate=");
            sb.append(this.f1707c);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.f1708d);
            sb.append(", mValid=");
            sb.append(this.f1709e);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        public boolean a(View view, u uVar) {
            j jVar = (j) view.getLayoutParams();
            return !jVar.p() && jVar.n() >= 0 && jVar.n() < uVar.a();
        }

        public void b(View view, int i2) {
            int h2 = this.f1705a.h();
            if (h2 >= 0) {
                a(view, i2);
                return;
            }
            this.f1706b = i2;
            if (this.f1708d) {
                int b2 = (this.f1705a.b() - h2) - this.f1705a.a(view);
                this.f1707c = this.f1705a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.f1707c - this.f1705a.b(view);
                    int f2 = this.f1705a.f();
                    int min = b3 - (f2 + Math.min(this.f1705a.d(view) - f2, 0));
                    if (min < 0) {
                        this.f1707c += Math.min(b2, -min);
                    }
                }
            } else {
                int d2 = this.f1705a.d(view);
                int f3 = d2 - this.f1705a.f();
                this.f1707c = d2;
                if (f3 > 0) {
                    int b4 = (this.f1705a.b() - Math.min(0, (this.f1705a.b() - h2) - this.f1705a.a(view))) - (d2 + this.f1705a.b(view));
                    if (b4 < 0) {
                        this.f1707c -= Math.min(f3, -b4);
                    }
                }
            }
        }

        public void a(View view, int i2) {
            if (this.f1708d) {
                this.f1707c = this.f1705a.a(view) + this.f1705a.h();
            } else {
                this.f1707c = this.f1705a.d(view);
            }
            this.f1706b = i2;
        }
    }

    protected static class b {

        /* renamed from: a reason: collision with root package name */
        public int f1710a;

        /* renamed from: b reason: collision with root package name */
        public boolean f1711b;

        /* renamed from: c reason: collision with root package name */
        public boolean f1712c;

        /* renamed from: d reason: collision with root package name */
        public boolean f1713d;

        protected b() {
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f1710a = 0;
            this.f1711b = false;
            this.f1712c = false;
            this.f1713d = false;
        }
    }

    static class c {

        /* renamed from: a reason: collision with root package name */
        boolean f1714a = true;

        /* renamed from: b reason: collision with root package name */
        int f1715b;

        /* renamed from: c reason: collision with root package name */
        int f1716c;

        /* renamed from: d reason: collision with root package name */
        int f1717d;

        /* renamed from: e reason: collision with root package name */
        int f1718e;

        /* renamed from: f reason: collision with root package name */
        int f1719f;

        /* renamed from: g reason: collision with root package name */
        int f1720g;

        /* renamed from: h reason: collision with root package name */
        int f1721h = 0;

        /* renamed from: i reason: collision with root package name */
        boolean f1722i = false;

        /* renamed from: j reason: collision with root package name */
        int f1723j;

        /* renamed from: k reason: collision with root package name */
        List<x> f1724k = null;

        /* renamed from: l reason: collision with root package name */
        boolean f1725l;

        c() {
        }

        private View b() {
            int size = this.f1724k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = ((x) this.f1724k.get(i2)).itemView;
                j jVar = (j) view.getLayoutParams();
                if (!jVar.p() && this.f1717d == jVar.n()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(u uVar) {
            int i2 = this.f1717d;
            return i2 >= 0 && i2 < uVar.a();
        }

        /* access modifiers changed from: 0000 */
        public View a(p pVar) {
            if (this.f1724k != null) {
                return b();
            }
            View d2 = pVar.d(this.f1717d);
            this.f1717d += this.f1718e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f1717d = -1;
            } else {
                this.f1717d = ((j) b2.getLayoutParams()).n();
            }
        }

        public View b(View view) {
            int size = this.f1724k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = ((x) this.f1724k.get(i3)).itemView;
                j jVar = (j) view3.getLayoutParams();
                if (view3 != view && !jVar.p()) {
                    int n = (jVar.n() - this.f1717d) * this.f1718e;
                    if (n >= 0 && n < i2) {
                        if (n == 0) {
                            return view3;
                        }
                        view2 = view3;
                        i2 = n;
                    }
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Creator<d> CREATOR = new C();

        /* renamed from: a reason: collision with root package name */
        int f1726a;

        /* renamed from: b reason: collision with root package name */
        int f1727b;

        /* renamed from: c reason: collision with root package name */
        boolean f1728c;

        public d() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean n() {
            return this.f1726a >= 0;
        }

        /* access modifiers changed from: 0000 */
        public void o() {
            this.f1726a = -1;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1726a);
            parcel.writeInt(this.f1727b);
            parcel.writeInt(this.f1728c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f1726a = parcel.readInt();
            this.f1727b = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1728c = z;
        }

        public d(d dVar) {
            this.f1726a = dVar.f1726a;
            this.f1727b = dVar.f1727b;
            this.f1728c = dVar.f1728c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private View L() {
        return f(this.x ? 0 : f() - 1);
    }

    private View M() {
        return f(this.x ? f() - 1 : 0);
    }

    private void N() {
        if (this.s == 1 || !J()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    private void f(int i2, int i3) {
        this.t.f1716c = this.u.b() - i3;
        this.t.f1718e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f1717d = i2;
        cVar.f1719f = 1;
        cVar.f1715b = i3;
        cVar.f1720g = Integer.MIN_VALUE;
    }

    private int i(u uVar) {
        if (f() == 0) {
            return 0;
        }
        E();
        I i2 = this.u;
        View b2 = b(!this.z, true);
        return W.a(uVar, i2, b2, a(!this.z, true), this, this.z);
    }

    private int j(u uVar) {
        if (f() == 0) {
            return 0;
        }
        E();
        I i2 = this.u;
        View b2 = b(!this.z, true);
        return W.a(uVar, i2, b2, a(!this.z, true), this, this.z, this.x);
    }

    /* access modifiers changed from: 0000 */
    public boolean A() {
        return (j() == 1073741824 || p() == 1073741824 || !q()) ? false : true;
    }

    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    /* access modifiers changed from: 0000 */
    public c D() {
        return new c();
    }

    /* access modifiers changed from: 0000 */
    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, f(), true, false);
        if (a2 == null) {
            return -1;
        }
        return m(a2);
    }

    public int G() {
        View a2 = a(0, f(), false, true);
        if (a2 == null) {
            return -1;
        }
        return m(a2);
    }

    public int H() {
        View a2 = a(f() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return m(a2);
    }

    public int I() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public boolean J() {
        return l() == 1;
    }

    /* access modifiers changed from: 0000 */
    public boolean K() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (f() > 0) {
            accessibilityEvent.setFromIndex(G());
            accessibilityEvent.setToIndex(H());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(p pVar, u uVar, a aVar, int i2) {
    }

    public void b(RecyclerView recyclerView, p pVar) {
        super.b(recyclerView, pVar);
        if (this.C) {
            b(pVar);
            pVar.a();
        }
    }

    public boolean c() {
        return this.s == 1;
    }

    public j d() {
        return new j(-2, -2);
    }

    public View e(int i2) {
        int f2 = f();
        if (f2 == 0) {
            return null;
        }
        int m = i2 - m(f(0));
        if (m >= 0 && m < f2) {
            View f3 = f(m);
            if (m(f3) == i2) {
                return f3;
            }
        }
        return super.e(i2);
    }

    public void g(u uVar) {
        super.g(uVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    /* access modifiers changed from: protected */
    public int h(u uVar) {
        if (uVar.c()) {
            return this.u.g();
        }
        return 0;
    }

    public void k(int i2) {
        this.A = i2;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.o();
        }
        y();
    }

    /* access modifiers changed from: 0000 */
    public int l(int i2) {
        int i3 = -1;
        int i4 = 1;
        if (i2 == 1) {
            return (this.s != 1 && J()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.s != 1 && J()) ? -1 : 1;
        }
        if (i2 == 17) {
            if (this.s != 0) {
                i3 = Integer.MIN_VALUE;
            }
            return i3;
        } else if (i2 == 33) {
            if (this.s != 1) {
                i3 = Integer.MIN_VALUE;
            }
            return i3;
        } else if (i2 == 66) {
            if (this.s != 0) {
                i4 = Integer.MIN_VALUE;
            }
            return i4;
        } else if (i2 != 130) {
            return Integer.MIN_VALUE;
        } else {
            if (this.s != 1) {
                i4 = Integer.MIN_VALUE;
            }
            return i4;
        }
    }

    public void m(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.s || this.u == null) {
                this.u = I.a(this, i2);
                this.E.f1705a = this.u;
                this.s = i2;
                y();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid orientation:");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean s() {
        return true;
    }

    public Parcelable w() {
        d dVar = this.D;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (f() > 0) {
            E();
            boolean z2 = this.v ^ this.x;
            dVar2.f1728c = z2;
            if (z2) {
                View L = L();
                dVar2.f1727b = this.u.b() - this.u.a(L);
                dVar2.f1726a = m(L);
            } else {
                View M = M();
                dVar2.f1726a = m(M);
                dVar2.f1727b = this.u.d(M) - this.u.f();
            }
        } else {
            dVar2.o();
        }
        return dVar2;
    }

    public LinearLayoutManager(Context context, int i2, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        m(i2);
        b(z2);
    }

    public void c(boolean z2) {
        a((String) null);
        if (this.y != z2) {
            this.y = z2;
            y();
        }
    }

    public int d(u uVar) {
        return i(uVar);
    }

    private View h(p pVar, u uVar) {
        return e(f() - 1, -1);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            y();
        }
    }

    public boolean b() {
        return this.s == 0;
    }

    private void g(int i2, int i3) {
        this.t.f1716c = i3 - this.u.f();
        c cVar = this.t;
        cVar.f1717d = i2;
        cVar.f1718e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f1719f = -1;
        cVar2.f1715b = i3;
        cVar2.f1720g = Integer.MIN_VALUE;
    }

    private int k(u uVar) {
        if (f() == 0) {
            return 0;
        }
        E();
        I i2 = this.u;
        View b2 = b(!this.z, true);
        return W.b(uVar, i2, b2, a(!this.z, true), this, this.z);
    }

    public void b(boolean z2) {
        a((String) null);
        if (z2 != this.w) {
            this.w = z2;
            y();
        }
    }

    public PointF c(int i2) {
        if (f() == 0) {
            return null;
        }
        boolean z2 = false;
        int i3 = 1;
        if (i2 < m(f(0))) {
            z2 = true;
        }
        if (z2 != this.x) {
            i3 = -1;
        }
        if (this.s == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    public void e(p pVar, u uVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.D == null && this.A == -1) && uVar.a() == 0) {
            b(pVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.n()) {
            this.A = this.D.f1726a;
        }
        E();
        this.t.f1714a = false;
        N();
        View h2 = h();
        if (!this.E.f1709e || this.A != -1 || this.D != null) {
            this.E.b();
            a aVar = this.E;
            aVar.f1708d = this.x ^ this.y;
            b(pVar, uVar, aVar);
            this.E.f1709e = true;
        } else if (h2 != null && (this.u.d(h2) >= this.u.b() || this.u.a(h2) <= this.u.f())) {
            this.E.b(h2, m(h2));
        }
        int h3 = h(uVar);
        if (this.t.f1723j >= 0) {
            i2 = h3;
            h3 = 0;
        } else {
            i2 = 0;
        }
        int f2 = h3 + this.u.f();
        int c2 = i2 + this.u.c();
        if (uVar.d()) {
            int i11 = this.A;
            if (!(i11 == -1 || this.B == Integer.MIN_VALUE)) {
                View e2 = e(i11);
                if (e2 != null) {
                    if (this.x) {
                        i8 = this.u.b() - this.u.a(e2);
                        i9 = this.B;
                    } else {
                        i9 = this.u.d(e2) - this.u.f();
                        i8 = this.B;
                    }
                    int i12 = i8 - i9;
                    if (i12 > 0) {
                        f2 += i12;
                    } else {
                        c2 -= i12;
                    }
                }
            }
        }
        if (!this.E.f1708d ? !this.x : this.x) {
            i10 = 1;
        }
        a(pVar, uVar, this.E, i10);
        a(pVar);
        this.t.f1725l = K();
        this.t.f1722i = uVar.d();
        a aVar2 = this.E;
        if (aVar2.f1708d) {
            b(aVar2);
            c cVar = this.t;
            cVar.f1721h = f2;
            a(pVar, cVar, uVar, false);
            c cVar2 = this.t;
            i4 = cVar2.f1715b;
            int i13 = cVar2.f1717d;
            int i14 = cVar2.f1716c;
            if (i14 > 0) {
                c2 += i14;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.f1721h = c2;
            cVar3.f1717d += cVar3.f1718e;
            a(pVar, cVar3, uVar, false);
            c cVar4 = this.t;
            i3 = cVar4.f1715b;
            int i15 = cVar4.f1716c;
            if (i15 > 0) {
                g(i13, i4);
                c cVar5 = this.t;
                cVar5.f1721h = i15;
                a(pVar, cVar5, uVar, false);
                i4 = this.t.f1715b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.f1721h = c2;
            a(pVar, cVar6, uVar, false);
            c cVar7 = this.t;
            i3 = cVar7.f1715b;
            int i16 = cVar7.f1717d;
            int i17 = cVar7.f1716c;
            if (i17 > 0) {
                f2 += i17;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.f1721h = f2;
            cVar8.f1717d += cVar8.f1718e;
            a(pVar, cVar8, uVar, false);
            c cVar9 = this.t;
            i4 = cVar9.f1715b;
            int i18 = cVar9.f1716c;
            if (i18 > 0) {
                f(i16, i3);
                c cVar10 = this.t;
                cVar10.f1721h = i18;
                a(pVar, cVar10, uVar, false);
                i3 = this.t.f1715b;
            }
        }
        if (f() > 0) {
            if (this.x ^ this.y) {
                int a2 = a(i3, pVar, uVar, true);
                i6 = i4 + a2;
                i5 = i3 + a2;
                i7 = b(i6, pVar, uVar, false);
            } else {
                int b2 = b(i4, pVar, uVar, true);
                i6 = i4 + b2;
                i5 = i3 + b2;
                i7 = a(i5, pVar, uVar, false);
            }
            i4 = i6 + i7;
            i3 = i5 + i7;
        }
        b(pVar, uVar, i4, i3);
        if (!uVar.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    private View i(p pVar, u uVar) {
        return a(pVar, uVar, f() - 1, -1, uVar.a());
    }

    private View j(p pVar, u uVar) {
        if (this.x) {
            return f(pVar, uVar);
        }
        return h(pVar, uVar);
    }

    public int f(u uVar) {
        return k(uVar);
    }

    private View f(p pVar, u uVar) {
        return e(0, f());
    }

    private View m(p pVar, u uVar) {
        if (this.x) {
            return i(pVar, uVar);
        }
        return g(pVar, uVar);
    }

    public void a(RecyclerView recyclerView, u uVar, int i2) {
        D d2 = new D(recyclerView.getContext());
        d2.c(i2);
        b((t) d2);
    }

    private View l(p pVar, u uVar) {
        if (this.x) {
            return g(pVar, uVar);
        }
        return i(pVar, uVar);
    }

    private void b(p pVar, u uVar, int i2, int i3) {
        p pVar2 = pVar;
        u uVar2 = uVar;
        if (uVar.e() && f() != 0 && !uVar.d() && C()) {
            List<x> f2 = pVar.f();
            int size = f2.size();
            int m = m(f(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = (x) f2.get(i6);
                if (!xVar.isRemoved()) {
                    char c2 = 1;
                    if ((xVar.getLayoutPosition() < m) != this.x) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i4 += this.u.b(xVar.itemView);
                    } else {
                        i5 += this.u.b(xVar.itemView);
                    }
                }
            }
            this.t.f1724k = f2;
            if (i4 > 0) {
                g(m(M()), i2);
                c cVar = this.t;
                cVar.f1721h = i4;
                cVar.f1716c = 0;
                cVar.a();
                a(pVar2, this.t, uVar2, false);
            }
            if (i5 > 0) {
                f(m(L()), i3);
                c cVar2 = this.t;
                cVar2.f1721h = i5;
                cVar2.f1716c = 0;
                cVar2.a();
                a(pVar2, this.t, uVar2, false);
            }
            this.t.f1724k = null;
        }
    }

    private boolean a(p pVar, u uVar, a aVar) {
        View view;
        int i2;
        boolean z2 = false;
        if (f() == 0) {
            return false;
        }
        View h2 = h();
        if (h2 != null && aVar.a(h2, uVar)) {
            aVar.b(h2, m(h2));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            if (aVar.f1708d) {
                view = l(pVar, uVar);
            } else {
                view = m(pVar, uVar);
            }
            if (view == null) {
                return false;
            }
            aVar.a(view, m(view));
            if (!uVar.d() && C()) {
                if (this.u.d(view) >= this.u.b() || this.u.a(view) < this.u.f()) {
                    z2 = true;
                }
                if (z2) {
                    if (aVar.f1708d) {
                        i2 = this.u.b();
                    } else {
                        i2 = this.u.f();
                    }
                    aVar.f1707c = i2;
                }
            }
            return true;
        }
    }

    private View g(p pVar, u uVar) {
        return a(pVar, uVar, 0, f(), uVar.a());
    }

    private View k(p pVar, u uVar) {
        if (this.x) {
            return h(pVar, uVar);
        }
        return f(pVar, uVar);
    }

    public int c(u uVar) {
        return k(uVar);
    }

    /* access modifiers changed from: 0000 */
    public int c(int i2, p pVar, u uVar) {
        if (f() == 0 || i2 == 0) {
            return 0;
        }
        this.t.f1714a = true;
        E();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, uVar);
        c cVar = this.t;
        int a2 = cVar.f1720g + a(pVar, cVar, uVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.u.a(-i2);
        this.t.f1723j = i2;
        return i2;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        androidx.recyclerview.widget.RecyclerView.i.b a2 = i.a(context, attributeSet, i2, i3);
        m(a2.f1768a);
        b(a2.f1770c);
        c(a2.f1771d);
    }

    private boolean a(u uVar, a aVar) {
        int i2;
        boolean z2 = false;
        if (!uVar.d()) {
            int i3 = this.A;
            if (i3 != -1) {
                if (i3 < 0 || i3 >= uVar.a()) {
                    this.A = -1;
                    this.B = Integer.MIN_VALUE;
                } else {
                    aVar.f1706b = this.A;
                    d dVar = this.D;
                    if (dVar != null && dVar.n()) {
                        aVar.f1708d = this.D.f1728c;
                        if (aVar.f1708d) {
                            aVar.f1707c = this.u.b() - this.D.f1727b;
                        } else {
                            aVar.f1707c = this.u.f() + this.D.f1727b;
                        }
                        return true;
                    } else if (this.B == Integer.MIN_VALUE) {
                        View e2 = e(this.A);
                        if (e2 == null) {
                            if (f() > 0) {
                                if ((this.A < m(f(0))) == this.x) {
                                    z2 = true;
                                }
                                aVar.f1708d = z2;
                            }
                            aVar.a();
                        } else if (this.u.b(e2) > this.u.g()) {
                            aVar.a();
                            return true;
                        } else if (this.u.d(e2) - this.u.f() < 0) {
                            aVar.f1707c = this.u.f();
                            aVar.f1708d = false;
                            return true;
                        } else if (this.u.b() - this.u.a(e2) < 0) {
                            aVar.f1707c = this.u.b();
                            aVar.f1708d = true;
                            return true;
                        } else {
                            if (aVar.f1708d) {
                                i2 = this.u.a(e2) + this.u.h();
                            } else {
                                i2 = this.u.d(e2);
                            }
                            aVar.f1707c = i2;
                        }
                        return true;
                    } else {
                        boolean z3 = this.x;
                        aVar.f1708d = z3;
                        if (z3) {
                            aVar.f1707c = this.u.b() - this.B;
                        } else {
                            aVar.f1707c = this.u.f() + this.B;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void b(p pVar, u uVar, a aVar) {
        if (!a(uVar, aVar) && !a(pVar, uVar, aVar)) {
            aVar.a();
            aVar.f1706b = this.y ? uVar.a() - 1 : 0;
        }
    }

    private int b(int i2, p pVar, u uVar, boolean z2) {
        int f2 = i2 - this.u.f();
        if (f2 <= 0) {
            return 0;
        }
        int i3 = -c(f2, pVar, uVar);
        int i4 = i2 + i3;
        if (z2) {
            int f3 = i4 - this.u.f();
            if (f3 > 0) {
                this.u.a(-f3);
                i3 -= f3;
            }
        }
        return i3;
    }

    private void b(a aVar) {
        g(aVar.f1706b, aVar.f1707c);
    }

    public int b(int i2, p pVar, u uVar) {
        if (this.s == 0) {
            return 0;
        }
        return c(i2, pVar, uVar);
    }

    public int b(u uVar) {
        return j(uVar);
    }

    private void b(p pVar, int i2) {
        if (i2 >= 0) {
            int f2 = f();
            if (!this.x) {
                int i3 = 0;
                while (true) {
                    if (i3 >= f2) {
                        break;
                    }
                    View f3 = f(i3);
                    if (this.u.a(f3) > i2 || this.u.e(f3) > i2) {
                        a(pVar, 0, i3);
                    } else {
                        i3++;
                    }
                }
            } else {
                int i4 = f2 - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View f4 = f(i5);
                    if (this.u.a(f4) > i2 || this.u.e(f4) > i2) {
                        a(pVar, i4, i5);
                        return;
                    }
                }
            }
        }
    }

    private View b(boolean z2, boolean z3) {
        if (this.x) {
            return a(f() - 1, -1, z2, z3);
        }
        return a(0, f(), z2, z3);
    }

    private int a(int i2, p pVar, u uVar, boolean z2) {
        int b2 = this.u.b() - i2;
        if (b2 <= 0) {
            return 0;
        }
        int i3 = -c(-b2, pVar, uVar);
        int i4 = i2 + i3;
        if (z2) {
            int b3 = this.u.b() - i4;
            if (b3 > 0) {
                this.u.a(b3);
                return b3 + i3;
            }
        }
        return i3;
    }

    private void a(a aVar) {
        f(aVar.f1706b, aVar.f1707c);
    }

    public int a(int i2, p pVar, u uVar) {
        if (this.s == 1) {
            return 0;
        }
        return c(i2, pVar, uVar);
    }

    public int a(u uVar) {
        return i(uVar);
    }

    private void a(int i2, int i3, boolean z2, u uVar) {
        int i4;
        this.t.f1725l = K();
        this.t.f1721h = h(uVar);
        c cVar = this.t;
        cVar.f1719f = i2;
        int i5 = -1;
        if (i2 == 1) {
            cVar.f1721h += this.u.c();
            View L = L();
            c cVar2 = this.t;
            if (!this.x) {
                i5 = 1;
            }
            cVar2.f1718e = i5;
            c cVar3 = this.t;
            int m = m(L);
            c cVar4 = this.t;
            cVar3.f1717d = m + cVar4.f1718e;
            cVar4.f1715b = this.u.a(L);
            i4 = this.u.a(L) - this.u.b();
        } else {
            View M = M();
            this.t.f1721h += this.u.f();
            c cVar5 = this.t;
            if (this.x) {
                i5 = 1;
            }
            cVar5.f1718e = i5;
            c cVar6 = this.t;
            int m2 = m(M);
            c cVar7 = this.t;
            cVar6.f1717d = m2 + cVar7.f1718e;
            cVar7.f1715b = this.u.d(M);
            i4 = (-this.u.d(M)) + this.u.f();
        }
        c cVar8 = this.t;
        cVar8.f1716c = i3;
        if (z2) {
            cVar8.f1716c -= i4;
        }
        this.t.f1720g = i4;
    }

    public int e(u uVar) {
        return j(uVar);
    }

    /* access modifiers changed from: 0000 */
    public View e(int i2, int i3) {
        int i4;
        int i5;
        View view;
        E();
        char c2 = i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0;
        if (c2 == 0) {
            return f(i2);
        }
        if (this.u.d(f(i2)) < this.u.f()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        if (this.s == 0) {
            view = this.f1760e.a(i2, i3, i5, i4);
        } else {
            view = this.f1761f.a(i2, i3, i5, i4);
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    public void a(u uVar, c cVar, androidx.recyclerview.widget.RecyclerView.i.a aVar) {
        int i2 = cVar.f1717d;
        if (i2 >= 0 && i2 < uVar.a()) {
            aVar.a(i2, Math.max(0, cVar.f1720g));
        }
    }

    public void a(int i2, androidx.recyclerview.widget.RecyclerView.i.a aVar) {
        boolean z2;
        int i3;
        d dVar = this.D;
        int i4 = -1;
        if (dVar == null || !dVar.n()) {
            N();
            z2 = this.x;
            i3 = this.A;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z2 = dVar2.f1728c;
            i3 = dVar2.f1726a;
        }
        if (!z2) {
            i4 = 1;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < this.G && i5 >= 0 && i5 < i2; i6++) {
            aVar.a(i5, 0);
            i5 += i4;
        }
    }

    public void a(int i2, int i3, u uVar, androidx.recyclerview.widget.RecyclerView.i.a aVar) {
        if (this.s != 0) {
            i2 = i3;
        }
        if (f() != 0 && i2 != 0) {
            E();
            a(i2 > 0 ? 1 : -1, Math.abs(i2), true, uVar);
            a(uVar, this.t, aVar);
        }
    }

    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    private void a(p pVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    a(i4, pVar);
                }
            } else {
                while (i2 > i3) {
                    a(i2, pVar);
                    i2--;
                }
            }
        }
    }

    private void a(p pVar, int i2) {
        int f2 = f();
        if (i2 >= 0) {
            int a2 = this.u.a() - i2;
            if (this.x) {
                for (int i3 = 0; i3 < f2; i3++) {
                    View f3 = f(i3);
                    if (this.u.d(f3) < a2 || this.u.f(f3) < a2) {
                        a(pVar, 0, i3);
                        return;
                    }
                }
            } else {
                int i4 = f2 - 1;
                int i5 = i4;
                while (true) {
                    if (i5 < 0) {
                        break;
                    }
                    View f4 = f(i5);
                    if (this.u.d(f4) < a2 || this.u.f(f4) < a2) {
                        a(pVar, i4, i5);
                    } else {
                        i5--;
                    }
                }
                a(pVar, i4, i5);
            }
        }
    }

    private void a(p pVar, c cVar) {
        if (cVar.f1714a && !cVar.f1725l) {
            if (cVar.f1719f == -1) {
                a(pVar, cVar.f1720g);
            } else {
                b(pVar, cVar.f1720g);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int a(p pVar, c cVar, u uVar, boolean z2) {
        int i2 = cVar.f1716c;
        int i3 = cVar.f1720g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f1720g = i3 + i2;
            }
            a(pVar, cVar);
        }
        int i4 = cVar.f1716c + cVar.f1721h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f1725l && i4 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.a();
            a(pVar, uVar, cVar, bVar);
            if (!bVar.f1711b) {
                cVar.f1715b += bVar.f1710a * cVar.f1719f;
                if (!bVar.f1712c || this.t.f1724k != null || !uVar.d()) {
                    int i5 = cVar.f1716c;
                    int i6 = bVar.f1710a;
                    cVar.f1716c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f1720g;
                if (i7 != Integer.MIN_VALUE) {
                    cVar.f1720g = i7 + bVar.f1710a;
                    int i8 = cVar.f1716c;
                    if (i8 < 0) {
                        cVar.f1720g += i8;
                    }
                    a(pVar, cVar);
                }
                if (z2 && bVar.f1713d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f1716c;
    }

    /* access modifiers changed from: 0000 */
    public void a(p pVar, u uVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.f1711b = true;
            return;
        }
        j jVar = (j) a2.getLayoutParams();
        if (cVar.f1724k == null) {
            if (this.x == (cVar.f1719f == -1)) {
                c(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f1719f == -1)) {
                b(a2);
            } else {
                a(a2, 0);
            }
        }
        b(a2, 0, 0);
        bVar.f1710a = this.u.b(a2);
        if (this.s == 1) {
            if (J()) {
                i6 = o() - getPaddingRight();
                i5 = i6 - this.u.c(a2);
            } else {
                i5 = getPaddingLeft();
                i6 = this.u.c(a2) + i5;
            }
            if (cVar.f1719f == -1) {
                int i7 = cVar.f1715b;
                i2 = i7;
                i3 = i6;
                i4 = i7 - bVar.f1710a;
            } else {
                int i8 = cVar.f1715b;
                i4 = i8;
                i3 = i6;
                i2 = bVar.f1710a + i8;
            }
        } else {
            int paddingTop = getPaddingTop();
            int c2 = this.u.c(a2) + paddingTop;
            if (cVar.f1719f == -1) {
                int i9 = cVar.f1715b;
                i3 = i9;
                i4 = paddingTop;
                i2 = c2;
                i5 = i9 - bVar.f1710a;
            } else {
                int i10 = cVar.f1715b;
                i4 = paddingTop;
                i3 = bVar.f1710a + i10;
                i2 = c2;
                i5 = i10;
            }
        }
        a(a2, i5, i4, i3, i2);
        if (jVar.p() || jVar.o()) {
            bVar.f1712c = true;
        }
        bVar.f1713d = a2.hasFocusable();
    }

    private View a(boolean z2, boolean z3) {
        if (this.x) {
            return a(0, f(), z2, z3);
        }
        return a(f() - 1, -1, z2, z3);
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
            if (m >= 0 && m < i4) {
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

    /* access modifiers changed from: 0000 */
    public View a(int i2, int i3, boolean z2, boolean z3) {
        E();
        int i4 = 320;
        int i5 = z2 ? 24579 : 320;
        if (!z3) {
            i4 = 0;
        }
        if (this.s == 0) {
            return this.f1760e.a(i2, i3, i5, i4);
        }
        return this.f1761f.a(i2, i3, i5, i4);
    }

    public View a(View view, int i2, p pVar, u uVar) {
        View view2;
        View view3;
        N();
        if (f() == 0) {
            return null;
        }
        int l2 = l(i2);
        if (l2 == Integer.MIN_VALUE) {
            return null;
        }
        E();
        E();
        a(l2, (int) (((float) this.u.g()) * 0.33333334f), false, uVar);
        c cVar = this.t;
        cVar.f1720g = Integer.MIN_VALUE;
        cVar.f1714a = false;
        a(pVar, cVar, uVar, true);
        if (l2 == -1) {
            view2 = k(pVar, uVar);
        } else {
            view2 = j(pVar, uVar);
        }
        if (l2 == -1) {
            view3 = M();
        } else {
            view3 = L();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }
}
