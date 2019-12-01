package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.D;
import androidx.recyclerview.widget.I;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.u;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends i implements a, androidx.recyclerview.widget.RecyclerView.t.b {
    private static final Rect s = new Rect();
    /* access modifiers changed from: private */
    public List<c> A = new ArrayList();
    /* access modifiers changed from: private */
    public final e B = new e(this);
    private p C;
    private u D;
    private c E;
    private a F = new a();
    /* access modifiers changed from: private */
    public I G;
    private I H;
    private d I;
    private int J = -1;
    private int K = Integer.MIN_VALUE;
    private int L = Integer.MIN_VALUE;
    private int M = Integer.MIN_VALUE;
    private boolean N;
    private SparseArray<View> O = new SparseArray<>();
    private final Context P;
    private View Q;
    private int R = -1;
    private a S = new a();
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public int u;
    private int v;
    private int w;
    private int x = -1;
    /* access modifiers changed from: private */
    public boolean y;
    private boolean z;

    private class a {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public int f4436a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public int f4437b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public int f4438c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public int f4439d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public boolean f4440e;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public boolean f4441f;
        /* access modifiers changed from: private */

        /* renamed from: g reason: collision with root package name */
        public boolean f4442g;

        private a() {
            this.f4439d = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.f4436a);
            sb.append(", mFlexLinePosition=");
            sb.append(this.f4437b);
            sb.append(", mCoordinate=");
            sb.append(this.f4438c);
            sb.append(", mPerpendicularCoordinate=");
            sb.append(this.f4439d);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.f4440e);
            sb.append(", mValid=");
            sb.append(this.f4441f);
            sb.append(", mAssignedFromSavedState=");
            sb.append(this.f4442g);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f4436a = -1;
            this.f4437b = -1;
            this.f4438c = Integer.MIN_VALUE;
            boolean z = false;
            this.f4441f = false;
            this.f4442g = false;
            if (FlexboxLayoutManager.this.a()) {
                if (FlexboxLayoutManager.this.u == 0) {
                    if (FlexboxLayoutManager.this.t == 1) {
                        z = true;
                    }
                    this.f4440e = z;
                    return;
                }
                if (FlexboxLayoutManager.this.u == 2) {
                    z = true;
                }
                this.f4440e = z;
            } else if (FlexboxLayoutManager.this.u == 0) {
                if (FlexboxLayoutManager.this.t == 3) {
                    z = true;
                }
                this.f4440e = z;
            } else {
                if (FlexboxLayoutManager.this.u == 2) {
                    z = true;
                }
                this.f4440e = z;
            }
        }

        /* access modifiers changed from: private */
        public void a() {
            int i2;
            int i3;
            if (FlexboxLayoutManager.this.a() || !FlexboxLayoutManager.this.y) {
                if (this.f4440e) {
                    i2 = FlexboxLayoutManager.this.G.b();
                } else {
                    i2 = FlexboxLayoutManager.this.G.f();
                }
                this.f4438c = i2;
                return;
            }
            if (this.f4440e) {
                i3 = FlexboxLayoutManager.this.G.b();
            } else {
                i3 = FlexboxLayoutManager.this.o() - FlexboxLayoutManager.this.G.f();
            }
            this.f4438c = i3;
        }

        /* access modifiers changed from: private */
        public void a(View view) {
            if (FlexboxLayoutManager.this.a() || !FlexboxLayoutManager.this.y) {
                if (this.f4440e) {
                    this.f4438c = FlexboxLayoutManager.this.G.a(view) + FlexboxLayoutManager.this.G.h();
                } else {
                    this.f4438c = FlexboxLayoutManager.this.G.d(view);
                }
            } else if (this.f4440e) {
                this.f4438c = FlexboxLayoutManager.this.G.d(view) + FlexboxLayoutManager.this.G.h();
            } else {
                this.f4438c = FlexboxLayoutManager.this.G.a(view);
            }
            this.f4436a = FlexboxLayoutManager.this.m(view);
            int i2 = 0;
            this.f4442g = false;
            int[] iArr = FlexboxLayoutManager.this.B.f4478c;
            int i3 = this.f4436a;
            if (i3 == -1) {
                i3 = 0;
            }
            int i4 = iArr[i3];
            if (i4 != -1) {
                i2 = i4;
            }
            this.f4437b = i2;
            if (FlexboxLayoutManager.this.A.size() > this.f4437b) {
                this.f4436a = ((c) FlexboxLayoutManager.this.A.get(this.f4437b)).o;
            }
        }
    }

    public static class b extends j implements b {
        public static final Creator<b> CREATOR = new h();

        /* renamed from: e reason: collision with root package name */
        private float f4444e = 0.0f;

        /* renamed from: f reason: collision with root package name */
        private float f4445f = 1.0f;

        /* renamed from: g reason: collision with root package name */
        private int f4446g = -1;

        /* renamed from: h reason: collision with root package name */
        private float f4447h = -1.0f;

        /* renamed from: i reason: collision with root package name */
        private int f4448i;

        /* renamed from: j reason: collision with root package name */
        private int f4449j;

        /* renamed from: k reason: collision with root package name */
        private int f4450k = 16777215;

        /* renamed from: l reason: collision with root package name */
        private int f4451l = 16777215;
        private boolean m;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f4446g;
        }

        public float b() {
            return this.f4445f;
        }

        public int c() {
            return this.f4448i;
        }

        public int d() {
            return this.bottomMargin;
        }

        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.leftMargin;
        }

        public int f() {
            return this.topMargin;
        }

        public float g() {
            return this.f4444e;
        }

        public int getHeight() {
            return this.height;
        }

        public int getOrder() {
            return 1;
        }

        public int getWidth() {
            return this.width;
        }

        public float h() {
            return this.f4447h;
        }

        public int i() {
            return this.rightMargin;
        }

        public int j() {
            return this.f4449j;
        }

        public boolean k() {
            return this.m;
        }

        public int l() {
            return this.f4451l;
        }

        public int m() {
            return this.f4450k;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.f4444e);
            parcel.writeFloat(this.f4445f);
            parcel.writeInt(this.f4446g);
            parcel.writeFloat(this.f4447h);
            parcel.writeInt(this.f4448i);
            parcel.writeInt(this.f4449j);
            parcel.writeInt(this.f4450k);
            parcel.writeInt(this.f4451l);
            parcel.writeByte(this.m ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        protected b(Parcel parcel) {
            super(-2, -2);
            this.f4444e = parcel.readFloat();
            this.f4445f = parcel.readFloat();
            this.f4446g = parcel.readInt();
            this.f4447h = parcel.readFloat();
            this.f4448i = parcel.readInt();
            this.f4449j = parcel.readInt();
            this.f4450k = parcel.readInt();
            this.f4451l = parcel.readInt();
            this.m = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public int f4452a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public boolean f4453b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public int f4454c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public int f4455d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public int f4456e;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public int f4457f;
        /* access modifiers changed from: private */

        /* renamed from: g reason: collision with root package name */
        public int f4458g;
        /* access modifiers changed from: private */

        /* renamed from: h reason: collision with root package name */
        public int f4459h;
        /* access modifiers changed from: private */

        /* renamed from: i reason: collision with root package name */
        public int f4460i;
        /* access modifiers changed from: private */

        /* renamed from: j reason: collision with root package name */
        public boolean f4461j;

        private c() {
            this.f4459h = 1;
            this.f4460i = 1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LayoutState{mAvailable=");
            sb.append(this.f4452a);
            sb.append(", mFlexLinePosition=");
            sb.append(this.f4454c);
            sb.append(", mPosition=");
            sb.append(this.f4455d);
            sb.append(", mOffset=");
            sb.append(this.f4456e);
            sb.append(", mScrollingOffset=");
            sb.append(this.f4457f);
            sb.append(", mLastScrollDelta=");
            sb.append(this.f4458g);
            sb.append(", mItemDirection=");
            sb.append(this.f4459h);
            sb.append(", mLayoutDirection=");
            sb.append(this.f4460i);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public boolean a(u uVar, List<c> list) {
            int i2 = this.f4455d;
            if (i2 >= 0 && i2 < uVar.a()) {
                int i3 = this.f4454c;
                if (i3 >= 0 && i3 < list.size()) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class d implements Parcelable {
        public static final Creator<d> CREATOR = new i();
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public int f4462a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public int f4463b;

        /* access modifiers changed from: private */
        public void n() {
            this.f4462a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SavedState{mAnchorPosition=");
            sb.append(this.f4462a);
            sb.append(", mAnchorOffset=");
            sb.append(this.f4463b);
            sb.append('}');
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4462a);
            parcel.writeInt(this.f4463b);
        }

        d() {
        }

        /* access modifiers changed from: private */
        public boolean a(int i2) {
            int i3 = this.f4462a;
            return i3 >= 0 && i3 < i2;
        }

        private d(Parcel parcel) {
            this.f4462a = parcel.readInt();
            this.f4463b = parcel.readInt();
        }

        private d(d dVar) {
            this.f4462a = dVar.f4462a;
            this.f4463b = dVar.f4463b;
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i.b a2 = i.a(context, attributeSet, i2, i3);
        int i4 = a2.f1768a;
        if (i4 != 0) {
            if (i4 == 1) {
                if (a2.f1770c) {
                    m(3);
                } else {
                    m(2);
                }
            }
        } else if (a2.f1770c) {
            m(1);
        } else {
            m(0);
        }
        n(1);
        l(4);
        a(true);
        this.P = context;
    }

    private void F() {
        this.A.clear();
        this.F.b();
        this.F.f4439d = 0;
    }

    private void G() {
        if (this.E == null) {
            this.E = new c();
        }
    }

    private void H() {
        if (this.G == null) {
            if (a()) {
                if (this.u == 0) {
                    this.G = I.a((i) this);
                    this.H = I.b((i) this);
                } else {
                    this.G = I.b((i) this);
                    this.H = I.a((i) this);
                }
            } else if (this.u == 0) {
                this.G = I.b((i) this);
                this.H = I.a((i) this);
            } else {
                this.G = I.a((i) this);
                this.H = I.b((i) this);
            }
        }
    }

    private View I() {
        return f(0);
    }

    private void J() {
        int i2;
        if (a()) {
            i2 = j();
        } else {
            i2 = p();
        }
        this.E.f4453b = i2 == 0 || i2 == Integer.MIN_VALUE;
    }

    private void K() {
        int l2 = l();
        int i2 = this.t;
        boolean z2 = false;
        if (i2 == 0) {
            this.y = l2 == 1;
            if (this.u == 2) {
                z2 = true;
            }
            this.z = z2;
        } else if (i2 == 1) {
            this.y = l2 != 1;
            if (this.u == 2) {
                z2 = true;
            }
            this.z = z2;
        } else if (i2 == 2) {
            this.y = l2 == 1;
            if (this.u == 2) {
                this.y = !this.y;
            }
            this.z = false;
        } else if (i2 != 3) {
            this.y = false;
            this.z = false;
        } else {
            if (l2 == 1) {
                z2 = true;
            }
            this.y = z2;
            if (this.u == 2) {
                this.y = !this.y;
            }
            this.z = true;
        }
    }

    private int h(u uVar) {
        if (f() == 0) {
            return 0;
        }
        int a2 = uVar.a();
        H();
        View o = o(a2);
        View p = p(a2);
        if (uVar.a() == 0 || o == null || p == null) {
            return 0;
        }
        return Math.min(this.G.g(), this.G.a(p) - this.G.d(o));
    }

    private int i(u uVar) {
        if (f() == 0) {
            return 0;
        }
        int a2 = uVar.a();
        View o = o(a2);
        View p = p(a2);
        if (!(uVar.a() == 0 || o == null || p == null)) {
            int m = m(o);
            int m2 = m(p);
            int abs = Math.abs(this.G.a(p) - this.G.d(o));
            int[] iArr = this.B.f4478c;
            int i2 = iArr[m];
            if (!(i2 == 0 || i2 == -1)) {
                return Math.round((((float) i2) * (((float) abs) / ((float) ((iArr[m2] - i2) + 1)))) + ((float) (this.G.f() - this.G.d(o))));
            }
        }
        return 0;
    }

    private int j(u uVar) {
        if (f() == 0) {
            return 0;
        }
        int a2 = uVar.a();
        View o = o(a2);
        View p = p(a2);
        if (uVar.a() == 0 || o == null || p == null) {
            return 0;
        }
        int D2 = D();
        return (int) ((((float) Math.abs(this.G.a(p) - this.G.d(o))) / ((float) ((E() - D2) + 1))) * ((float) uVar.a()));
    }

    private View o(int i2) {
        View e2 = e(0, f(), i2);
        if (e2 == null) {
            return null;
        }
        int i3 = this.B.f4478c[m(e2)];
        if (i3 == -1) {
            return null;
        }
        return a(e2, (c) this.A.get(i3));
    }

    private View p(int i2) {
        View e2 = e(f() - 1, -1, i2);
        if (e2 == null) {
            return null;
        }
        return b(e2, (c) this.A.get(this.B.f4478c[m(e2)]));
    }

    private int q(int i2) {
        int e2;
        boolean z2 = false;
        if (f() == 0 || i2 == 0) {
            return 0;
        }
        H();
        boolean a2 = a();
        int width = a2 ? this.Q.getWidth() : this.Q.getHeight();
        int o = a2 ? o() : i();
        if (l() == 1) {
            z2 = true;
        }
        if (z2) {
            int abs = Math.abs(i2);
            if (i2 < 0) {
                e2 = Math.min((o + this.F.f4439d) - width, abs);
            } else {
                if (this.F.f4439d + i2 > 0) {
                    e2 = this.F.f4439d;
                }
                return i2;
            }
        } else {
            if (i2 > 0) {
                i2 = Math.min((o - this.F.f4439d) - width, i2);
            } else if (this.F.f4439d + i2 < 0) {
                e2 = this.F.f4439d;
            }
            return i2;
        }
        i2 = -e2;
        return i2;
    }

    private void r(int i2) {
        int D2 = D();
        int E2 = E();
        if (i2 < E2) {
            int f2 = f();
            this.B.b(f2);
            this.B.c(f2);
            this.B.a(f2);
            if (i2 < this.B.f4478c.length) {
                this.R = i2;
                View I2 = I();
                if (I2 != null) {
                    if (D2 > i2 || i2 > E2) {
                        this.J = m(I2);
                        if (a() || !this.y) {
                            this.K = this.G.d(I2) - this.G.f();
                        } else {
                            this.K = this.G.a(I2) + this.G.c();
                        }
                    }
                }
            }
        }
    }

    private void s(int i2) {
        int i3;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(o(), p());
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i(), j());
        int o = o();
        int i4 = i();
        boolean z2 = true;
        if (a()) {
            int i5 = this.L;
            if (i5 == Integer.MIN_VALUE || i5 == o) {
                z2 = false;
            }
            if (this.E.f4453b) {
                i3 = this.P.getResources().getDisplayMetrics().heightPixels;
            } else {
                i3 = this.E.f4452a;
            }
        } else {
            int i6 = this.M;
            if (i6 == Integer.MIN_VALUE || i6 == i4) {
                z2 = false;
            }
            if (this.E.f4453b) {
                i3 = this.P.getResources().getDisplayMetrics().widthPixels;
            } else {
                i3 = this.E.f4452a;
            }
        }
        int i7 = i3;
        this.L = o;
        this.M = i4;
        if (this.R != -1 || (this.J == -1 && !z2)) {
            int i8 = this.R;
            int min = i8 != -1 ? Math.min(i8, this.F.f4436a) : this.F.f4436a;
            this.S.a();
            if (a()) {
                if (this.A.size() > 0) {
                    this.B.a(this.A, min);
                    this.B.a(this.S, makeMeasureSpec, makeMeasureSpec2, i7, min, this.F.f4436a, this.A);
                } else {
                    this.B.a(i2);
                    this.B.a(this.S, makeMeasureSpec, makeMeasureSpec2, i7, 0, this.A);
                }
            } else if (this.A.size() > 0) {
                this.B.a(this.A, min);
                this.B.a(this.S, makeMeasureSpec2, makeMeasureSpec, i7, min, this.F.f4436a, this.A);
            } else {
                this.B.a(i2);
                this.B.c(this.S, makeMeasureSpec, makeMeasureSpec2, i7, 0, this.A);
            }
            this.A = this.S.f4481a;
            this.B.b(makeMeasureSpec, makeMeasureSpec2, min);
            this.B.d(min);
        } else if (!this.F.f4440e) {
            this.A.clear();
            this.S.a();
            if (a()) {
                this.B.b(this.S, makeMeasureSpec, makeMeasureSpec2, i7, this.F.f4436a, this.A);
            } else {
                this.B.d(this.S, makeMeasureSpec, makeMeasureSpec2, i7, this.F.f4436a, this.A);
            }
            this.A = this.S.f4481a;
            this.B.a(makeMeasureSpec, makeMeasureSpec2);
            this.B.a();
            a aVar = this.F;
            aVar.f4437b = this.B.f4478c[aVar.f4436a];
            this.E.f4454c = this.F.f4437b;
        }
    }

    private int t(View view) {
        return k(view) - ((j) view.getLayoutParams()).topMargin;
    }

    public int D() {
        View a2 = a(0, f(), false);
        if (a2 == null) {
            return -1;
        }
        return m(a2);
    }

    public int E() {
        View a2 = a(f() - 1, -1, false);
        if (a2 == null) {
            return -1;
        }
        return m(a2);
    }

    public void a(c cVar) {
    }

    public void g(u uVar) {
        super.g(uVar);
        this.I = null;
        this.J = -1;
        this.K = Integer.MIN_VALUE;
        this.R = -1;
        this.F.b();
        this.O.clear();
    }

    public int getAlignContent() {
        return 5;
    }

    public int getAlignItems() {
        return this.w;
    }

    public int getFlexDirection() {
        return this.t;
    }

    public int getFlexItemCount() {
        return this.D.a();
    }

    public List<c> getFlexLinesInternal() {
        return this.A;
    }

    public int getFlexWrap() {
        return this.u;
    }

    public int getLargestMainSize() {
        if (this.A.size() == 0) {
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.A.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, ((c) this.A.get(i3)).f4468e);
        }
        return i2;
    }

    public int getMaxLine() {
        return this.x;
    }

    public int getSumOfCrossSize() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.A.size(); i3++) {
            i2 += ((c) this.A.get(i3)).f4470g;
        }
        return i2;
    }

    public void k(int i2) {
        this.J = i2;
        this.K = Integer.MIN_VALUE;
        d dVar = this.I;
        if (dVar != null) {
            dVar.n();
        }
        y();
    }

    public void l(int i2) {
        int i3 = this.w;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                x();
                F();
            }
            this.w = i2;
            y();
        }
    }

    public void m(int i2) {
        if (this.t != i2) {
            x();
            this.t = i2;
            this.G = null;
            this.H = null;
            F();
            y();
        }
    }

    public void n(int i2) {
        if (i2 != 2) {
            int i3 = this.u;
            if (i3 != i2) {
                if (i3 == 0 || i2 == 0) {
                    x();
                    F();
                }
                this.u = i2;
                this.G = null;
                this.H = null;
                y();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public void setFlexLines(List<c> list) {
        this.A = list;
    }

    public Parcelable w() {
        d dVar = this.I;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (f() > 0) {
            View I2 = I();
            dVar2.f4462a = m(I2);
            dVar2.f4463b = this.G.d(I2) - this.G.f();
        } else {
            dVar2.n();
        }
        return dVar2;
    }

    private boolean f(View view, int i2) {
        boolean z2 = true;
        if (a() || !this.y) {
            if (this.G.a(view) > i2) {
                z2 = false;
            }
            return z2;
        }
        if (this.G.a() - this.G.d(view) > i2) {
            z2 = false;
        }
        return z2;
    }

    public int a(View view, int i2, int i3) {
        int o;
        int e2;
        if (a()) {
            o = l(view);
            e2 = n(view);
        } else {
            o = o(view);
            e2 = e(view);
        }
        return o + e2;
    }

    public View b(int i2) {
        View view = (View) this.O.get(i2);
        if (view != null) {
            return view;
        }
        return this.C.d(i2);
    }

    public PointF c(int i2) {
        if (f() == 0) {
            return null;
        }
        int i3 = i2 < m(f(0)) ? -1 : 1;
        if (a()) {
            return new PointF(0.0f, (float) i3);
        }
        return new PointF((float) i3, 0.0f);
    }

    public j d() {
        return new b(-2, -2);
    }

    public void e(p pVar, u uVar) {
        int i2;
        int i3;
        this.C = pVar;
        this.D = uVar;
        int a2 = uVar.a();
        if (a2 != 0 || !uVar.d()) {
            K();
            H();
            G();
            this.B.b(a2);
            this.B.c(a2);
            this.B.a(a2);
            this.E.f4461j = false;
            d dVar = this.I;
            if (dVar != null && dVar.a(a2)) {
                this.J = this.I.f4462a;
            }
            if (!(this.F.f4441f && this.J == -1 && this.I == null)) {
                this.F.b();
                b(uVar, this.F);
                this.F.f4441f = true;
            }
            a(pVar);
            if (this.F.f4440e) {
                b(this.F, false, true);
            } else {
                a(this.F, false, true);
            }
            s(a2);
            if (this.F.f4440e) {
                a(pVar, uVar, this.E);
                i3 = this.E.f4456e;
                a(this.F, true, false);
                a(pVar, uVar, this.E);
                i2 = this.E.f4456e;
            } else {
                a(pVar, uVar, this.E);
                i2 = this.E.f4456e;
                b(this.F, true, false);
                a(pVar, uVar, this.E);
                i3 = this.E.f4456e;
            }
            if (f() > 0) {
                if (this.F.f4440e) {
                    b(i3 + a(i2, pVar, uVar, true), pVar, uVar, false);
                } else {
                    a(i2 + b(i3, pVar, uVar, true), pVar, uVar, false);
                }
            }
        }
    }

    public int d(u uVar) {
        return h(uVar);
    }

    public int b(int i2, int i3, int i4) {
        return i.a(i(), j(), i3, i4, c());
    }

    public int a(View view) {
        int l2;
        int n;
        if (a()) {
            l2 = o(view);
            n = e(view);
        } else {
            l2 = l(view);
            n = n(view);
        }
        return l2 + n;
    }

    public int f(u uVar) {
        return j(uVar);
    }

    private static boolean f(int i2, int i3, int i4) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        boolean z2 = false;
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            if (size >= i2) {
                z2 = true;
            }
            return z2;
        } else if (mode == 0) {
            return true;
        } else {
            if (mode != 1073741824) {
                return false;
            }
            if (size == i2) {
                z2 = true;
            }
            return z2;
        }
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        super.b(recyclerView, i2, i3);
        r(i2);
    }

    public void c(RecyclerView recyclerView, int i2, int i3) {
        super.c(recyclerView, i2, i3);
        r(i2);
    }

    public void a(View view, int i2, int i3, c cVar) {
        a(view, s);
        if (a()) {
            int l2 = l(view) + n(view);
            cVar.f4468e += l2;
            cVar.f4469f += l2;
            return;
        }
        int o = o(view) + e(view);
        cVar.f4468e += o;
        cVar.f4469f += o;
    }

    private int b(int i2, p pVar, u uVar, boolean z2) {
        int i3;
        if (a() || !this.y) {
            int f2 = i2 - this.G.f();
            if (f2 <= 0) {
                return 0;
            }
            i3 = -c(f2, pVar, uVar);
        } else {
            int b2 = this.G.b() - i2;
            if (b2 <= 0) {
                return 0;
            }
            i3 = c(-b2, pVar, uVar);
        }
        int i4 = i2 + i3;
        if (z2) {
            int f3 = i4 - this.G.f();
            if (f3 > 0) {
                this.G.a(-f3);
                i3 -= f3;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r2 = r5;
     */
    private void c(p pVar, c cVar) {
        if (cVar.f4457f >= 0) {
            int f2 = f();
            if (f2 != 0) {
                int i2 = this.B.f4478c[m(f(0))];
                if (i2 != -1) {
                    c cVar2 = (c) this.A.get(i2);
                    int i3 = i2;
                    int i4 = 0;
                    int i5 = -1;
                    while (true) {
                        if (i4 >= f2) {
                            break;
                        }
                        View f3 = f(i4);
                        if (!f(f3, cVar.f4457f)) {
                            break;
                        }
                        if (cVar2.p == m(f3)) {
                            if (i3 >= this.A.size() - 1) {
                                break;
                            }
                            i3 += cVar.f4460i;
                            cVar2 = (c) this.A.get(i3);
                            i5 = i4;
                        }
                        i4++;
                    }
                    a(pVar, 0, i4);
                }
            }
        }
    }

    private void b(u uVar, a aVar) {
        if (!a(uVar, aVar, this.I) && !a(uVar, aVar)) {
            aVar.a();
            aVar.f4436a = 0;
            aVar.f4437b = 0;
        }
    }

    private int r(View view) {
        return g(view) - ((j) view.getLayoutParams()).leftMargin;
    }

    public View a(int i2) {
        return b(i2);
    }

    public int a(int i2, int i3, int i4) {
        return i.a(o(), p(), i3, i4, b());
    }

    private int q(View view) {
        return f(view) + ((j) view.getLayoutParams()).bottomMargin;
    }

    public void a(int i2, View view) {
        this.O.put(i2, view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r0 = r4;
     */
    private void b(p pVar, c cVar) {
        if (cVar.f4457f >= 0) {
            this.G.a();
            cVar.f4457f;
            int f2 = f();
            if (f2 != 0) {
                int i2 = f2 - 1;
                int i3 = this.B.f4478c[m(f(i2))];
                if (i3 != -1) {
                    c cVar2 = (c) this.A.get(i3);
                    int i4 = f2;
                    int i5 = i2;
                    while (true) {
                        if (i5 < 0) {
                            break;
                        }
                        View f3 = f(i5);
                        if (!e(f3, cVar.f4457f)) {
                            break;
                        }
                        if (cVar2.o == m(f3)) {
                            if (i3 <= 0) {
                                break;
                            }
                            i3 += cVar.f4460i;
                            cVar2 = (c) this.A.get(i3);
                            i4 = i5;
                        }
                        i5--;
                    }
                    a(pVar, i5, i2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d7  */
    private int c(c cVar, c cVar2) {
        float f2;
        float f3;
        float f4;
        int b2;
        int i2;
        int i3;
        float f5;
        View view;
        c cVar3 = cVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i4 = i();
        int a2 = cVar2.f4456e;
        int a3 = cVar2.f4456e;
        if (cVar2.f4460i == -1) {
            int i5 = cVar3.f4470g;
            a2 -= i5;
            a3 += i5;
        }
        int i6 = a2;
        int i7 = a3;
        int h2 = cVar2.f4455d;
        int i8 = this.v;
        if (i8 != 0) {
            if (i8 == 1) {
                int i9 = cVar3.f4468e;
                float f6 = (float) (i9 - paddingTop);
                f2 = 0.0f;
                float f7 = (float) ((i4 - i9) + paddingBottom);
                f3 = f6;
                f4 = f7;
            } else if (i8 == 2) {
                float f8 = (float) paddingTop;
                int i10 = cVar3.f4468e;
                f4 = f8 + (((float) (i4 - i10)) / 2.0f);
                f3 = ((float) (i4 - paddingBottom)) - (((float) (i4 - i10)) / 2.0f);
            } else if (i8 == 3) {
                f4 = (float) paddingTop;
                int i11 = cVar3.f4471h;
                f2 = ((float) (i4 - cVar3.f4468e)) / (i11 != 1 ? (float) (i11 - 1) : 1.0f);
                f3 = (float) (i4 - paddingBottom);
            } else if (i8 == 4) {
                int i12 = cVar3.f4471h;
                f2 = i12 != 0 ? ((float) (i4 - cVar3.f4468e)) / ((float) i12) : 0.0f;
                float f9 = f2 / 2.0f;
                f4 = ((float) paddingTop) + f9;
                f3 = ((float) (i4 - paddingBottom)) - f9;
            } else if (i8 == 5) {
                int i13 = cVar3.f4471h;
                f2 = i13 != 0 ? ((float) (i4 - cVar3.f4468e)) / ((float) (i13 + 1)) : 0.0f;
                f4 = ((float) paddingTop) + f2;
                f3 = ((float) (i4 - paddingBottom)) - f2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid justifyContent is set: ");
                sb.append(this.v);
                throw new IllegalStateException(sb.toString());
            }
            float e2 = f4 - ((float) this.F.f4439d);
            float e3 = f3 - ((float) this.F.f4439d);
            float max = Math.max(f2, 0.0f);
            int i14 = 0;
            b2 = cVar.b();
            i2 = h2;
            while (i2 < h2 + b2) {
                View b3 = b(i2);
                if (b3 == null) {
                    i3 = i2;
                    f5 = max;
                } else {
                    e eVar = this.B;
                    f5 = max;
                    long j2 = eVar.f4479d[i2];
                    int b4 = eVar.b(j2);
                    int a4 = this.B.a(j2);
                    b bVar = (b) b3.getLayoutParams();
                    if (a(b3, b4, a4, (j) bVar)) {
                        b3.measure(b4, a4);
                    }
                    float o = e2 + ((float) (bVar.topMargin + o(b3)));
                    float e4 = e3 - ((float) (bVar.rightMargin + e(b3)));
                    if (cVar2.f4460i == 1) {
                        a(b3, s);
                        c(b3);
                    } else {
                        a(b3, s);
                        b(b3, i14);
                        i14++;
                    }
                    int i15 = i14;
                    int l2 = i6 + l(b3);
                    int n = i7 - n(b3);
                    boolean z2 = this.y;
                    if (!z2) {
                        view = b3;
                        i3 = i2;
                        if (this.z) {
                            this.B.a(view, cVar, z2, l2, Math.round(e4) - view.getMeasuredHeight(), l2 + view.getMeasuredWidth(), Math.round(e4));
                        } else {
                            this.B.a(view, cVar, z2, l2, Math.round(o), l2 + view.getMeasuredWidth(), Math.round(o) + view.getMeasuredHeight());
                        }
                    } else if (this.z) {
                        view = b3;
                        i3 = i2;
                        this.B.a(b3, cVar, z2, n - b3.getMeasuredWidth(), Math.round(e4) - b3.getMeasuredHeight(), n, Math.round(e4));
                    } else {
                        view = b3;
                        i3 = i2;
                        this.B.a(view, cVar, z2, n - view.getMeasuredWidth(), Math.round(o), n, Math.round(o) + view.getMeasuredHeight());
                    }
                    View view2 = view;
                    e2 = o + ((float) (view.getMeasuredHeight() + bVar.topMargin + e(view2))) + f5;
                    i14 = i15;
                    e3 = e4 - (((float) ((view2.getMeasuredHeight() + bVar.bottomMargin) + o(view2))) + f5);
                }
                i2 = i3 + 1;
                max = f5;
            }
            cVar2.f4454c = cVar2.f4454c + this.E.f4460i;
            return cVar.a();
        }
        f4 = (float) paddingTop;
        f3 = (float) (i4 - paddingBottom);
        f2 = 0.0f;
        float e22 = f4 - ((float) this.F.f4439d);
        float e32 = f3 - ((float) this.F.f4439d);
        float max2 = Math.max(f2, 0.0f);
        int i142 = 0;
        b2 = cVar.b();
        i2 = h2;
        while (i2 < h2 + b2) {
        }
        cVar2.f4454c = cVar2.f4454c + this.E.f4460i;
        return cVar.a();
    }

    public j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public boolean a(j jVar) {
        return jVar instanceof b;
    }

    public void a(androidx.recyclerview.widget.RecyclerView.a aVar, androidx.recyclerview.widget.RecyclerView.a aVar2) {
        x();
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.I = (d) parcelable;
            y();
        }
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        super.a(recyclerView, i2, i3);
        r(i2);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.a(recyclerView, i2, i3, obj);
        r(i2);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        super.a(recyclerView, i2, i3, i4);
        r(Math.min(i2, i3));
    }

    private int a(int i2, p pVar, u uVar, boolean z2) {
        int i3;
        if (!a() && this.y) {
            int f2 = i2 - this.G.f();
            if (f2 <= 0) {
                return 0;
            }
            i3 = c(f2, pVar, uVar);
        } else {
            int b2 = this.G.b() - i2;
            if (b2 <= 0) {
                return 0;
            }
            i3 = -c(-b2, pVar, uVar);
        }
        int i4 = i2 + i3;
        if (z2) {
            int b3 = this.G.b() - i4;
            if (b3 > 0) {
                this.G.a(b3);
                return b3 + i3;
            }
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    private int b(c cVar, c cVar2) {
        float f2;
        float f3;
        float f4;
        int b2;
        int i2;
        b bVar;
        c cVar3 = cVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int o = o();
        int a2 = cVar2.f4456e;
        if (cVar2.f4460i == -1) {
            a2 -= cVar3.f4470g;
        }
        int i3 = a2;
        int h2 = cVar2.f4455d;
        int i4 = this.v;
        int i5 = 1;
        if (i4 != 0) {
            if (i4 == 1) {
                int i6 = cVar3.f4468e;
                float f5 = (float) (i6 - paddingLeft);
                f2 = 0.0f;
                float f6 = (float) ((o - i6) + paddingRight);
                f3 = f5;
                f4 = f6;
            } else if (i4 == 2) {
                float f7 = (float) paddingLeft;
                int i7 = cVar3.f4468e;
                f4 = f7 + (((float) (o - i7)) / 2.0f);
                f3 = ((float) (o - paddingRight)) - (((float) (o - i7)) / 2.0f);
            } else if (i4 == 3) {
                f4 = (float) paddingLeft;
                int i8 = cVar3.f4471h;
                f2 = ((float) (o - cVar3.f4468e)) / (i8 != 1 ? (float) (i8 - 1) : 1.0f);
                f3 = (float) (o - paddingRight);
            } else if (i4 == 4) {
                int i9 = cVar3.f4471h;
                f2 = i9 != 0 ? ((float) (o - cVar3.f4468e)) / ((float) i9) : 0.0f;
                float f8 = f2 / 2.0f;
                f4 = ((float) paddingLeft) + f8;
                f3 = ((float) (o - paddingRight)) - f8;
            } else if (i4 == 5) {
                int i10 = cVar3.f4471h;
                f2 = i10 != 0 ? ((float) (o - cVar3.f4468e)) / ((float) (i10 + 1)) : 0.0f;
                f4 = ((float) paddingLeft) + f2;
                f3 = ((float) (o - paddingRight)) - f2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid justifyContent is set: ");
                sb.append(this.v);
                throw new IllegalStateException(sb.toString());
            }
            float e2 = f4 - ((float) this.F.f4439d);
            float e3 = f3 - ((float) this.F.f4439d);
            float max = Math.max(f2, 0.0f);
            int i11 = 0;
            b2 = cVar.b();
            i2 = h2;
            while (i2 < h2 + b2) {
                View b3 = b(i2);
                if (b3 != null) {
                    if (cVar2.f4460i == i5) {
                        a(b3, s);
                        c(b3);
                    } else {
                        a(b3, s);
                        b(b3, i11);
                        i11++;
                    }
                    int i12 = i11;
                    e eVar = this.B;
                    long j2 = eVar.f4479d[i2];
                    int b4 = eVar.b(j2);
                    int a3 = this.B.a(j2);
                    b bVar2 = (b) b3.getLayoutParams();
                    if (a(b3, b4, a3, (j) bVar2)) {
                        b3.measure(b4, a3);
                    }
                    float l2 = e2 + ((float) (bVar2.leftMargin + l(b3)));
                    float n = e3 - ((float) (bVar2.rightMargin + n(b3)));
                    int o2 = i3 + o(b3);
                    if (this.y) {
                        bVar = bVar2;
                        this.B.a(b3, cVar, Math.round(n) - b3.getMeasuredWidth(), o2, Math.round(n), o2 + b3.getMeasuredHeight());
                    } else {
                        bVar = bVar2;
                        this.B.a(b3, cVar, Math.round(l2), o2, Math.round(l2) + b3.getMeasuredWidth(), o2 + b3.getMeasuredHeight());
                    }
                    i11 = i12;
                    e2 = l2 + ((float) (b3.getMeasuredWidth() + bVar.rightMargin + n(b3))) + max;
                    e3 = n - (((float) ((b3.getMeasuredWidth() + bVar.leftMargin) + l(b3))) + max);
                }
                i2++;
                i5 = 1;
            }
            cVar2.f4454c = cVar2.f4454c + this.E.f4460i;
            return cVar.a();
        }
        f4 = (float) paddingLeft;
        f3 = (float) (o - paddingRight);
        f2 = 0.0f;
        float e22 = f4 - ((float) this.F.f4439d);
        float e32 = f3 - ((float) this.F.f4439d);
        float max2 = Math.max(f2, 0.0f);
        int i112 = 0;
        b2 = cVar.b();
        i2 = h2;
        while (i2 < h2 + b2) {
        }
        cVar2.f4454c = cVar2.f4454c + this.E.f4460i;
        return cVar.a();
    }

    private boolean a(u uVar, a aVar, d dVar) {
        int i2;
        boolean z2 = false;
        if (!uVar.d()) {
            int i3 = this.J;
            if (i3 != -1) {
                if (i3 < 0 || i3 >= uVar.a()) {
                    this.J = -1;
                    this.K = Integer.MIN_VALUE;
                } else {
                    aVar.f4436a = this.J;
                    aVar.f4437b = this.B.f4478c[aVar.f4436a];
                    d dVar2 = this.I;
                    if (dVar2 != null && dVar2.a(uVar.a())) {
                        aVar.f4438c = this.G.f() + dVar.f4463b;
                        aVar.f4442g = true;
                        aVar.f4437b = -1;
                        return true;
                    } else if (this.K == Integer.MIN_VALUE) {
                        View e2 = e(this.J);
                        if (e2 == null) {
                            if (f() > 0) {
                                if (this.J < m(f(0))) {
                                    z2 = true;
                                }
                                aVar.f4440e = z2;
                            }
                            aVar.a();
                        } else if (this.G.b(e2) > this.G.g()) {
                            aVar.a();
                            return true;
                        } else if (this.G.d(e2) - this.G.f() < 0) {
                            aVar.f4438c = this.G.f();
                            aVar.f4440e = false;
                            return true;
                        } else if (this.G.b() - this.G.a(e2) < 0) {
                            aVar.f4438c = this.G.b();
                            aVar.f4440e = true;
                            return true;
                        } else {
                            if (aVar.f4440e) {
                                i2 = this.G.a(e2) + this.G.h();
                            } else {
                                i2 = this.G.d(e2);
                            }
                            aVar.f4438c = i2;
                        }
                        return true;
                    } else {
                        if (a() || !this.y) {
                            aVar.f4438c = this.G.f() + this.K;
                        } else {
                            aVar.f4438c = this.K - this.G.c();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private View e(int i2, int i3, int i4) {
        H();
        G();
        int f2 = this.G.f();
        int b2 = this.G.b();
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
                } else if (this.G.d(f3) >= f2 && this.G.a(f3) <= b2) {
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

    private boolean e(View view, int i2) {
        boolean z2 = true;
        if (a() || !this.y) {
            if (this.G.d(view) < this.G.a() - i2) {
                z2 = false;
            }
            return z2;
        }
        if (this.G.a(view) > i2) {
            z2 = false;
        }
        return z2;
    }

    private void e(int i2, int i3) {
        this.E.f4460i = i2;
        boolean a2 = a();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(o(), p());
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i(), j());
        int i4 = 0;
        boolean z2 = !a2 && this.y;
        if (i2 == 1) {
            View f2 = f(f() - 1);
            this.E.f4456e = this.G.a(f2);
            int m = m(f2);
            View b2 = b(f2, (c) this.A.get(this.B.f4478c[m]));
            this.E.f4459h = 1;
            c cVar = this.E;
            cVar.f4455d = m + cVar.f4459h;
            if (this.B.f4478c.length <= this.E.f4455d) {
                this.E.f4454c = -1;
            } else {
                c cVar2 = this.E;
                cVar2.f4454c = this.B.f4478c[cVar2.f4455d];
            }
            if (z2) {
                this.E.f4456e = this.G.d(b2);
                this.E.f4457f = (-this.G.d(b2)) + this.G.f();
                c cVar3 = this.E;
                if (cVar3.f4457f >= 0) {
                    i4 = this.E.f4457f;
                }
                cVar3.f4457f = i4;
            } else {
                this.E.f4456e = this.G.a(b2);
                this.E.f4457f = this.G.a(b2) - this.G.b();
            }
            if ((this.E.f4454c == -1 || this.E.f4454c > this.A.size() - 1) && this.E.f4455d <= getFlexItemCount()) {
                int g2 = i3 - this.E.f4457f;
                this.S.a();
                if (g2 > 0) {
                    if (a2) {
                        this.B.a(this.S, makeMeasureSpec, makeMeasureSpec2, g2, this.E.f4455d, this.A);
                    } else {
                        this.B.c(this.S, makeMeasureSpec, makeMeasureSpec2, g2, this.E.f4455d, this.A);
                    }
                    this.B.b(makeMeasureSpec, makeMeasureSpec2, this.E.f4455d);
                    this.B.d(this.E.f4455d);
                }
            }
        } else {
            View f3 = f(0);
            this.E.f4456e = this.G.d(f3);
            int m2 = m(f3);
            View a3 = a(f3, (c) this.A.get(this.B.f4478c[m2]));
            this.E.f4459h = 1;
            int i5 = this.B.f4478c[m2];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.E.f4455d = m2 - ((c) this.A.get(i5 - 1)).b();
            } else {
                this.E.f4455d = -1;
            }
            this.E.f4454c = i5 > 0 ? i5 - 1 : 0;
            if (z2) {
                this.E.f4456e = this.G.a(a3);
                this.E.f4457f = this.G.a(a3) - this.G.b();
                c cVar4 = this.E;
                if (cVar4.f4457f >= 0) {
                    i4 = this.E.f4457f;
                }
                cVar4.f4457f = i4;
            } else {
                this.E.f4456e = this.G.d(a3);
                this.E.f4457f = (-this.G.d(a3)) + this.G.f();
            }
        }
        c cVar5 = this.E;
        cVar5.f4452a = i3 - cVar5.f4457f;
    }

    private int s(View view) {
        return j(view) + ((j) view.getLayoutParams()).rightMargin;
    }

    private boolean a(u uVar, a aVar) {
        View view;
        int i2;
        boolean z2 = false;
        if (f() == 0) {
            return false;
        }
        if (aVar.f4440e) {
            view = p(uVar.a());
        } else {
            view = o(uVar.a());
        }
        if (view == null) {
            return false;
        }
        aVar.a(view);
        if (!uVar.d() && C()) {
            if (this.G.d(view) >= this.G.b() || this.G.a(view) < this.G.f()) {
                z2 = true;
            }
            if (z2) {
                if (aVar.f4440e) {
                    i2 = this.G.b();
                } else {
                    i2 = this.G.f();
                }
                aVar.f4438c = i2;
            }
        }
        return true;
    }

    private void b(a aVar, boolean z2, boolean z3) {
        if (z3) {
            J();
        } else {
            this.E.f4453b = false;
        }
        if (a() || !this.y) {
            this.E.f4452a = aVar.f4438c - this.G.f();
        } else {
            this.E.f4452a = (this.Q.getWidth() - aVar.f4438c) - this.G.f();
        }
        this.E.f4455d = aVar.f4436a;
        this.E.f4459h = 1;
        this.E.f4460i = -1;
        this.E.f4456e = aVar.f4438c;
        this.E.f4457f = Integer.MIN_VALUE;
        this.E.f4454c = aVar.f4437b;
        if (z2 && aVar.f4437b > 0 && this.A.size() > aVar.f4437b) {
            c cVar = (c) this.A.get(aVar.f4437b);
            this.E.f4454c = this.E.f4454c - 1;
            c cVar2 = this.E;
            cVar2.f4455d = cVar2.f4455d - cVar.b();
        }
    }

    public boolean c() {
        return a() || i() > this.Q.getHeight();
    }

    private int c(int i2, p pVar, u uVar) {
        if (f() == 0 || i2 == 0) {
            return 0;
        }
        H();
        int i3 = 1;
        this.E.f4461j = true;
        boolean z2 = !a() && this.y;
        if (!z2 ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        e(i3, abs);
        int g2 = this.E.f4457f + a(pVar, uVar, this.E);
        if (g2 < 0) {
            return 0;
        }
        if (z2) {
            if (abs > g2) {
                i2 = (-i3) * g2;
            }
        } else if (abs > g2) {
            i2 = i3 * g2;
        }
        this.G.a(-i2);
        this.E.f4458g = i2;
        return i2;
    }

    private int a(p pVar, u uVar, c cVar) {
        if (cVar.f4457f != Integer.MIN_VALUE) {
            if (cVar.f4452a < 0) {
                cVar.f4457f = cVar.f4457f + cVar.f4452a;
            }
            a(pVar, cVar);
        }
        int c2 = cVar.f4452a;
        int c3 = cVar.f4452a;
        int i2 = 0;
        boolean a2 = a();
        while (true) {
            if ((c3 > 0 || this.E.f4453b) && cVar.a(uVar, this.A)) {
                c cVar2 = (c) this.A.get(cVar.f4454c);
                cVar.f4455d = cVar2.o;
                i2 += a(cVar2, cVar);
                if (a2 || !this.y) {
                    cVar.f4456e = cVar.f4456e + (cVar2.a() * cVar.f4460i);
                } else {
                    cVar.f4456e = cVar.f4456e - (cVar2.a() * cVar.f4460i);
                }
                c3 -= cVar2.a();
            }
        }
        cVar.f4452a = cVar.f4452a - i2;
        if (cVar.f4457f != Integer.MIN_VALUE) {
            cVar.f4457f = cVar.f4457f + i2;
            if (cVar.f4452a < 0) {
                cVar.f4457f = cVar.f4457f + cVar.f4452a;
            }
            a(pVar, cVar);
        }
        return c2 - cVar.f4452a;
    }

    public int c(u uVar) {
        return j(uVar);
    }

    public void b(RecyclerView recyclerView) {
        super.b(recyclerView);
        this.Q = (View) recyclerView.getParent();
    }

    public void b(RecyclerView recyclerView, p pVar) {
        super.b(recyclerView, pVar);
        if (this.N) {
            b(pVar);
            pVar.a();
        }
    }

    public boolean b() {
        return !a() || o() > this.Q.getWidth();
    }

    public int b(int i2, p pVar, u uVar) {
        if (a()) {
            int c2 = c(i2, pVar, uVar);
            this.O.clear();
            return c2;
        }
        int q = q(i2);
        a aVar = this.F;
        aVar.f4439d = aVar.f4439d + q;
        this.H.a(-q);
        return q;
    }

    private void a(p pVar, c cVar) {
        if (cVar.f4461j) {
            if (cVar.f4460i == -1) {
                b(pVar, cVar);
            } else {
                c(pVar, cVar);
            }
        }
    }

    private View b(View view, c cVar) {
        boolean a2 = a();
        int f2 = (f() - cVar.f4471h) - 1;
        for (int f3 = f() - 2; f3 > f2; f3--) {
            View f4 = f(f3);
            if (!(f4 == null || f4.getVisibility() == 8)) {
                if (!this.y || a2) {
                    if (this.G.a(view) >= this.G.a(f4)) {
                    }
                } else if (this.G.d(view) <= this.G.d(f4)) {
                }
                view = f4;
            }
        }
        return view;
    }

    private void a(p pVar, int i2, int i3) {
        while (i3 >= i2) {
            a(i3, pVar);
            i3--;
        }
    }

    private int a(c cVar, c cVar2) {
        if (a()) {
            return b(cVar, cVar2);
        }
        return c(cVar, cVar2);
    }

    public int e(u uVar) {
        return i(uVar);
    }

    public boolean a() {
        int i2 = this.t;
        return i2 == 0 || i2 == 1;
    }

    private void a(a aVar, boolean z2, boolean z3) {
        if (z3) {
            J();
        } else {
            this.E.f4453b = false;
        }
        if (a() || !this.y) {
            this.E.f4452a = this.G.b() - aVar.f4438c;
        } else {
            this.E.f4452a = aVar.f4438c - getPaddingRight();
        }
        this.E.f4455d = aVar.f4436a;
        this.E.f4459h = 1;
        this.E.f4460i = 1;
        this.E.f4456e = aVar.f4438c;
        this.E.f4457f = Integer.MIN_VALUE;
        this.E.f4454c = aVar.f4437b;
        if (z2 && this.A.size() > 1 && aVar.f4437b >= 0 && aVar.f4437b < this.A.size() - 1) {
            c cVar = (c) this.A.get(aVar.f4437b);
            this.E.f4454c = this.E.f4454c + 1;
            c cVar2 = this.E;
            cVar2.f4455d = cVar2.f4455d + cVar.b();
        }
    }

    public int b(u uVar) {
        i(uVar);
        return i(uVar);
    }

    public void a(RecyclerView recyclerView, u uVar, int i2) {
        D d2 = new D(recyclerView.getContext());
        d2.c(i2);
        b((t) d2);
    }

    public int a(int i2, p pVar, u uVar) {
        if (!a()) {
            int c2 = c(i2, pVar, uVar);
            this.O.clear();
            return c2;
        }
        int q = q(i2);
        a aVar = this.F;
        aVar.f4439d = aVar.f4439d + q;
        this.H.a(-q);
        return q;
    }

    private View a(View view, c cVar) {
        boolean a2 = a();
        int i2 = cVar.f4471h;
        for (int i3 = 1; i3 < i2; i3++) {
            View f2 = f(i3);
            if (!(f2 == null || f2.getVisibility() == 8)) {
                if (!this.y || a2) {
                    if (this.G.d(view) <= this.G.d(f2)) {
                    }
                } else if (this.G.a(view) >= this.G.a(f2)) {
                }
                view = f2;
            }
        }
        return view;
    }

    public int a(u uVar) {
        return h(uVar);
    }

    private boolean a(View view, int i2, int i3, j jVar) {
        return view.isLayoutRequested() || !u() || !f(view.getWidth(), i2, jVar.width) || !f(view.getHeight(), i3, jVar.height);
    }

    private boolean a(View view, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int o = o() - getPaddingRight();
        int i2 = i() - getPaddingBottom();
        int r = r(view);
        int t2 = t(view);
        int s2 = s(view);
        int q = q(view);
        boolean z3 = true;
        boolean z4 = paddingLeft <= r && o >= s2;
        boolean z5 = r >= o || s2 >= paddingLeft;
        boolean z6 = paddingTop <= t2 && i2 >= q;
        boolean z7 = t2 >= i2 || q >= paddingTop;
        if (z2) {
            if (!z4 || !z6) {
                z3 = false;
            }
            return z3;
        }
        if (!z5 || !z7) {
            z3 = false;
        }
        return z3;
    }

    private View a(int i2, int i3, boolean z2) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View f2 = f(i2);
            if (a(f2, z2)) {
                return f2;
            }
            i2 += i4;
        }
        return null;
    }
}
