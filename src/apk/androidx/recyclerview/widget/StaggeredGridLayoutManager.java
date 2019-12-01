package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends i implements androidx.recyclerview.widget.RecyclerView.t.b {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    c E = new c();
    private int F = 2;
    private boolean G;
    private boolean H;
    private d I;
    private int J;
    private final Rect K = new Rect();
    private final a L = new a();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new aa(this);
    private int s = -1;
    e[] t;
    I u;
    I v;
    private int w;
    private int x;
    private final B y;
    boolean z = false;

    class a {

        /* renamed from: a reason: collision with root package name */
        int f1828a;

        /* renamed from: b reason: collision with root package name */
        int f1829b;

        /* renamed from: c reason: collision with root package name */
        boolean f1830c;

        /* renamed from: d reason: collision with root package name */
        boolean f1831d;

        /* renamed from: e reason: collision with root package name */
        boolean f1832e;

        /* renamed from: f reason: collision with root package name */
        int[] f1833f;

        a() {
            b();
        }

        /* access modifiers changed from: 0000 */
        public void a(e[] eVarArr) {
            int length = eVarArr.length;
            int[] iArr = this.f1833f;
            if (iArr == null || iArr.length < length) {
                this.f1833f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f1833f[i2] = eVarArr[i2].b(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            this.f1828a = -1;
            this.f1829b = Integer.MIN_VALUE;
            this.f1830c = false;
            this.f1831d = false;
            this.f1832e = false;
            int[] iArr = this.f1833f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            int i2;
            if (this.f1830c) {
                i2 = StaggeredGridLayoutManager.this.u.b();
            } else {
                i2 = StaggeredGridLayoutManager.this.u.f();
            }
            this.f1829b = i2;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            if (this.f1830c) {
                this.f1829b = StaggeredGridLayoutManager.this.u.b() - i2;
            } else {
                this.f1829b = StaggeredGridLayoutManager.this.u.f() + i2;
            }
        }
    }

    public static class b extends j {

        /* renamed from: e reason: collision with root package name */
        e f1835e;

        /* renamed from: f reason: collision with root package name */
        boolean f1836f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int r() {
            e eVar = this.f1835e;
            if (eVar == null) {
                return -1;
            }
            return eVar.f1857e;
        }

        public boolean s() {
            return this.f1836f;
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

    static class c {

        /* renamed from: a reason: collision with root package name */
        int[] f1837a;

        /* renamed from: b reason: collision with root package name */
        List<a> f1838b;

        static class a implements Parcelable {
            public static final Creator<a> CREATOR = new ba();

            /* renamed from: a reason: collision with root package name */
            int f1839a;

            /* renamed from: b reason: collision with root package name */
            int f1840b;

            /* renamed from: c reason: collision with root package name */
            int[] f1841c;

            /* renamed from: d reason: collision with root package name */
            boolean f1842d;

            a(Parcel parcel) {
                this.f1839a = parcel.readInt();
                this.f1840b = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1842d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1841c = new int[readInt];
                    parcel.readIntArray(this.f1841c);
                }
            }

            /* access modifiers changed from: 0000 */
            public int a(int i2) {
                int[] iArr = this.f1841c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("FullSpanItem{mPosition=");
                sb.append(this.f1839a);
                sb.append(", mGapDir=");
                sb.append(this.f1840b);
                sb.append(", mHasUnwantedGapAfter=");
                sb.append(this.f1842d);
                sb.append(", mGapPerSpan=");
                sb.append(Arrays.toString(this.f1841c));
                sb.append('}');
                return sb.toString();
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f1839a);
                parcel.writeInt(this.f1840b);
                parcel.writeInt(this.f1842d ? 1 : 0);
                int[] iArr = this.f1841c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f1841c);
            }

            a() {
            }
        }

        c() {
        }

        private void c(int i2, int i3) {
            List<a> list = this.f1838b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.f1838b.get(size);
                    int i4 = aVar.f1839a;
                    if (i4 >= i2) {
                        aVar.f1839a = i4 + i3;
                    }
                }
            }
        }

        private int g(int i2) {
            if (this.f1838b == null) {
                return -1;
            }
            a c2 = c(i2);
            if (c2 != null) {
                this.f1838b.remove(c2);
            }
            int size = this.f1838b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (((a) this.f1838b.get(i3)).f1839a >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            a aVar = (a) this.f1838b.get(i3);
            this.f1838b.remove(i3);
            return aVar.f1839a;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, e eVar) {
            a(i2);
            this.f1837a[i2] = eVar.f1857e;
        }

        /* access modifiers changed from: 0000 */
        public int b(int i2) {
            List<a> list = this.f1838b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f1838b.get(size)).f1839a >= i2) {
                        this.f1838b.remove(size);
                    }
                }
            }
            return e(i2);
        }

        /* access modifiers changed from: 0000 */
        public int d(int i2) {
            int[] iArr = this.f1837a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: 0000 */
        public int e(int i2) {
            int[] iArr = this.f1837a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int g2 = g(i2);
            if (g2 == -1) {
                int[] iArr2 = this.f1837a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f1837a.length;
            }
            int i3 = g2 + 1;
            Arrays.fill(this.f1837a, i2, i3, -1);
            return i3;
        }

        /* access modifiers changed from: 0000 */
        public int f(int i2) {
            int length = this.f1837a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        private void d(int i2, int i3) {
            List<a> list = this.f1838b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.f1838b.get(size);
                    int i5 = aVar.f1839a;
                    if (i5 >= i2) {
                        if (i5 < i4) {
                            this.f1838b.remove(size);
                        } else {
                            aVar.f1839a = i5 - i3;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            int[] iArr = this.f1837a;
            if (iArr == null) {
                this.f1837a = new int[(Math.max(i2, 10) + 1)];
                Arrays.fill(this.f1837a, -1);
            } else if (i2 >= iArr.length) {
                this.f1837a = new int[f(i2)];
                System.arraycopy(iArr, 0, this.f1837a, 0, iArr.length);
                int[] iArr2 = this.f1837a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public a c(int i2) {
            List<a> list = this.f1838b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f1838b.get(size);
                if (aVar.f1839a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2, int i3) {
            int[] iArr = this.f1837a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                a(i4);
                int[] iArr2 = this.f1837a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f1837a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                d(i2, i3);
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            int[] iArr = this.f1837a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1838b = null;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3) {
            int[] iArr = this.f1837a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                a(i4);
                int[] iArr2 = this.f1837a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f1837a, i2, i4, -1);
                c(i2, i3);
            }
        }

        public void a(a aVar) {
            if (this.f1838b == null) {
                this.f1838b = new ArrayList();
            }
            int size = this.f1838b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = (a) this.f1838b.get(i2);
                if (aVar2.f1839a == aVar.f1839a) {
                    this.f1838b.remove(i2);
                }
                if (aVar2.f1839a >= aVar.f1839a) {
                    this.f1838b.add(i2, aVar);
                    return;
                }
            }
            this.f1838b.add(aVar);
        }

        public a a(int i2, int i3, int i4, boolean z) {
            List<a> list = this.f1838b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = (a) this.f1838b.get(i5);
                int i6 = aVar.f1839a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.f1840b == i4 || (z && aVar.f1842d))) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public static class d implements Parcelable {
        public static final Creator<d> CREATOR = new ca();

        /* renamed from: a reason: collision with root package name */
        int f1843a;

        /* renamed from: b reason: collision with root package name */
        int f1844b;

        /* renamed from: c reason: collision with root package name */
        int f1845c;

        /* renamed from: d reason: collision with root package name */
        int[] f1846d;

        /* renamed from: e reason: collision with root package name */
        int f1847e;

        /* renamed from: f reason: collision with root package name */
        int[] f1848f;

        /* renamed from: g reason: collision with root package name */
        List<a> f1849g;

        /* renamed from: h reason: collision with root package name */
        boolean f1850h;

        /* renamed from: i reason: collision with root package name */
        boolean f1851i;

        /* renamed from: j reason: collision with root package name */
        boolean f1852j;

        public d() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public void n() {
            this.f1846d = null;
            this.f1845c = 0;
            this.f1843a = -1;
            this.f1844b = -1;
        }

        /* access modifiers changed from: 0000 */
        public void o() {
            this.f1846d = null;
            this.f1845c = 0;
            this.f1847e = 0;
            this.f1848f = null;
            this.f1849g = null;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1843a);
            parcel.writeInt(this.f1844b);
            parcel.writeInt(this.f1845c);
            if (this.f1845c > 0) {
                parcel.writeIntArray(this.f1846d);
            }
            parcel.writeInt(this.f1847e);
            if (this.f1847e > 0) {
                parcel.writeIntArray(this.f1848f);
            }
            parcel.writeInt(this.f1850h ? 1 : 0);
            parcel.writeInt(this.f1851i ? 1 : 0);
            parcel.writeInt(this.f1852j ? 1 : 0);
            parcel.writeList(this.f1849g);
        }

        d(Parcel parcel) {
            this.f1843a = parcel.readInt();
            this.f1844b = parcel.readInt();
            this.f1845c = parcel.readInt();
            int i2 = this.f1845c;
            if (i2 > 0) {
                this.f1846d = new int[i2];
                parcel.readIntArray(this.f1846d);
            }
            this.f1847e = parcel.readInt();
            int i3 = this.f1847e;
            if (i3 > 0) {
                this.f1848f = new int[i3];
                parcel.readIntArray(this.f1848f);
            }
            boolean z = false;
            this.f1850h = parcel.readInt() == 1;
            this.f1851i = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.f1852j = z;
            this.f1849g = parcel.readArrayList(a.class.getClassLoader());
        }

        public d(d dVar) {
            this.f1845c = dVar.f1845c;
            this.f1843a = dVar.f1843a;
            this.f1844b = dVar.f1844b;
            this.f1846d = dVar.f1846d;
            this.f1847e = dVar.f1847e;
            this.f1848f = dVar.f1848f;
            this.f1850h = dVar.f1850h;
            this.f1851i = dVar.f1851i;
            this.f1852j = dVar.f1852j;
            this.f1849g = dVar.f1849g;
        }
    }

    class e {

        /* renamed from: a reason: collision with root package name */
        ArrayList<View> f1853a = new ArrayList<>();

        /* renamed from: b reason: collision with root package name */
        int f1854b = Integer.MIN_VALUE;

        /* renamed from: c reason: collision with root package name */
        int f1855c = Integer.MIN_VALUE;

        /* renamed from: d reason: collision with root package name */
        int f1856d = 0;

        /* renamed from: e reason: collision with root package name */
        final int f1857e;

        e(int i2) {
            this.f1857e = i2;
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2) {
            int i3 = this.f1855c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f1853a.size() == 0) {
                return i2;
            }
            a();
            return this.f1855c;
        }

        /* access modifiers changed from: 0000 */
        public int b(int i2) {
            int i3 = this.f1854b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f1853a.size() == 0) {
                return i2;
            }
            b();
            return this.f1854b;
        }

        /* access modifiers changed from: 0000 */
        public void c(View view) {
            b b2 = b(view);
            b2.f1835e = this;
            this.f1853a.add(0, view);
            this.f1854b = Integer.MIN_VALUE;
            if (this.f1853a.size() == 1) {
                this.f1855c = Integer.MIN_VALUE;
            }
            if (b2.p() || b2.o()) {
                this.f1856d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: 0000 */
        public void d(int i2) {
            this.f1854b = i2;
            this.f1855c = i2;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f1853a.size(), true);
            }
            return a(this.f1853a.size() - 1, -1, true);
        }

        public int f() {
            return this.f1856d;
        }

        /* access modifiers changed from: 0000 */
        public int g() {
            int i2 = this.f1855c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            a();
            return this.f1855c;
        }

        /* access modifiers changed from: 0000 */
        public int h() {
            int i2 = this.f1854b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            b();
            return this.f1854b;
        }

        /* access modifiers changed from: 0000 */
        public void i() {
            this.f1854b = Integer.MIN_VALUE;
            this.f1855c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: 0000 */
        public void j() {
            int size = this.f1853a.size();
            View view = (View) this.f1853a.remove(size - 1);
            b b2 = b(view);
            b2.f1835e = null;
            if (b2.p() || b2.o()) {
                this.f1856d -= StaggeredGridLayoutManager.this.u.b(view);
            }
            if (size == 1) {
                this.f1854b = Integer.MIN_VALUE;
            }
            this.f1855c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: 0000 */
        public void k() {
            View view = (View) this.f1853a.remove(0);
            b b2 = b(view);
            b2.f1835e = null;
            if (this.f1853a.size() == 0) {
                this.f1855c = Integer.MIN_VALUE;
            }
            if (b2.p() || b2.o()) {
                this.f1856d -= StaggeredGridLayoutManager.this.u.b(view);
            }
            this.f1854b = Integer.MIN_VALUE;
        }

        public int d() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f1853a.size() - 1, -1, true);
            }
            return a(0, this.f1853a.size(), true);
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            ArrayList<View> arrayList = this.f1853a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            b b2 = b(view);
            this.f1855c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f1836f) {
                a c2 = StaggeredGridLayoutManager.this.E.c(b2.n());
                if (c2 != null && c2.f1840b == 1) {
                    this.f1855c += c2.a(this.f1857e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            View view = (View) this.f1853a.get(0);
            b b2 = b(view);
            this.f1854b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f1836f) {
                a c2 = StaggeredGridLayoutManager.this.E.c(b2.n());
                if (c2 != null && c2.f1840b == -1) {
                    this.f1854b -= c2.a(this.f1857e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void c() {
            this.f1853a.clear();
            i();
            this.f1856d = 0;
        }

        /* access modifiers changed from: 0000 */
        public void c(int i2) {
            int i3 = this.f1854b;
            if (i3 != Integer.MIN_VALUE) {
                this.f1854b = i3 + i2;
            }
            int i4 = this.f1855c;
            if (i4 != Integer.MIN_VALUE) {
                this.f1855c = i4 + i2;
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(View view) {
            b b2 = b(view);
            b2.f1835e = this;
            this.f1853a.add(view);
            this.f1855c = Integer.MIN_VALUE;
            if (this.f1853a.size() == 1) {
                this.f1854b = Integer.MIN_VALUE;
            }
            if (b2.p() || b2.o()) {
                this.f1856d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: 0000 */
        public b b(View view) {
            return (b) view.getLayoutParams();
        }

        /* access modifiers changed from: 0000 */
        public void a(boolean z, int i2) {
            int i3;
            if (z) {
                i3 = a(Integer.MIN_VALUE);
            } else {
                i3 = b(Integer.MIN_VALUE);
            }
            c();
            if (i3 != Integer.MIN_VALUE) {
                if ((!z || i3 >= StaggeredGridLayoutManager.this.u.b()) && (z || i3 <= StaggeredGridLayoutManager.this.u.f())) {
                    if (i2 != Integer.MIN_VALUE) {
                        i3 += i2;
                    }
                    this.f1855c = i3;
                    this.f1854b = i3;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int f2 = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = (View) this.f1853a.get(i2);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 < b2 : d2 <= b2;
                if (!z3 ? a2 > f2 : a2 >= f2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.m(view);
                        }
                        if (d2 < f2 || a2 > b2) {
                            return StaggeredGridLayoutManager.this.m(view);
                        }
                    } else if (d2 >= f2 && a2 <= b2) {
                        return StaggeredGridLayoutManager.this.m(view);
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3, boolean z) {
            return a(i2, i3, false, false, z);
        }

        public View a(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f1853a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f1853a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.m(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.m(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1853a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = (View) this.f1853a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.m(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.m(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i.b a2 = i.a(context, attributeSet, i2, i3);
        l(a2.f1768a);
        m(a2.f1769b);
        d(a2.f1770c);
        this.y = new B();
        M();
    }

    private void M() {
        this.u = I.a(this, this.w);
        this.v = I.a(this, 1 - this.w);
    }

    private void N() {
        if (this.v.d() != 1073741824) {
            int f2 = f();
            float f3 = 0.0f;
            for (int i2 = 0; i2 < f2; i2++) {
                View f4 = f(i2);
                float b2 = (float) this.v.b(f4);
                if (b2 >= f3) {
                    if (((b) f4.getLayoutParams()).s()) {
                        b2 = (b2 * 1.0f) / ((float) this.s);
                    }
                    f3 = Math.max(f3, b2);
                }
            }
            int i3 = this.x;
            int round = Math.round(f3 * ((float) this.s));
            if (this.v.d() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.g());
            }
            n(round);
            if (this.x != i3) {
                for (int i4 = 0; i4 < f2; i4++) {
                    View f5 = f(i4);
                    b bVar = (b) f5.getLayoutParams();
                    if (!bVar.f1836f) {
                        if (!L() || this.w != 1) {
                            int i5 = bVar.f1835e.f1857e;
                            int i6 = this.x * i5;
                            int i7 = i5 * i3;
                            if (this.w == 1) {
                                f5.offsetLeftAndRight(i6 - i7);
                            } else {
                                f5.offsetTopAndBottom(i6 - i7);
                            }
                        } else {
                            int i8 = this.s;
                            int i9 = i8 - 1;
                            int i10 = bVar.f1835e.f1857e;
                            f5.offsetLeftAndRight(((-(i9 - i10)) * this.x) - ((-((i8 - 1) - i10)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void O() {
        if (this.w == 1 || !L()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private boolean a(e eVar) {
        if (this.A) {
            if (eVar.g() < this.u.b()) {
                ArrayList<View> arrayList = eVar.f1853a;
                return !eVar.b((View) arrayList.get(arrayList.size() - 1)).f1836f;
            }
        } else if (eVar.h() > this.u.f()) {
            return !eVar.b((View) eVar.f1853a.get(0)).f1836f;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (F() != false) goto L_0x015b;
     */
    private void c(p pVar, u uVar, boolean z2) {
        a aVar = this.L;
        if (!(this.I == null && this.C == -1) && uVar.a() == 0) {
            b(pVar);
            aVar.b();
            return;
        }
        boolean z3 = true;
        boolean z4 = (aVar.f1832e && this.C == -1 && this.I == null) ? false : true;
        if (z4) {
            aVar.b();
            if (this.I != null) {
                a(aVar);
            } else {
                O();
                aVar.f1830c = this.A;
            }
            b(uVar, aVar);
            aVar.f1832e = true;
        }
        if (this.I == null && this.C == -1 && !(aVar.f1830c == this.G && L() == this.H)) {
            this.E.a();
            aVar.f1831d = true;
        }
        if (f() > 0) {
            d dVar = this.I;
            if (dVar == null || dVar.f1845c < 1) {
                if (aVar.f1831d) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        this.t[i2].c();
                        int i3 = aVar.f1829b;
                        if (i3 != Integer.MIN_VALUE) {
                            this.t[i2].d(i3);
                        }
                    }
                } else if (z4 || this.L.f1833f == null) {
                    for (int i4 = 0; i4 < this.s; i4++) {
                        this.t[i4].a(this.A, aVar.f1829b);
                    }
                    this.L.a(this.t);
                } else {
                    for (int i5 = 0; i5 < this.s; i5++) {
                        e eVar = this.t[i5];
                        eVar.c();
                        eVar.d(this.L.f1833f[i5]);
                    }
                }
            }
        }
        a(pVar);
        this.y.f1681a = false;
        this.M = false;
        n(this.v.g());
        b(aVar.f1828a, uVar);
        if (aVar.f1830c) {
            z(-1);
            a(pVar, this.y, uVar);
            z(1);
            B b2 = this.y;
            b2.f1683c = aVar.f1828a + b2.f1684d;
            a(pVar, b2, uVar);
        } else {
            z(1);
            a(pVar, this.y, uVar);
            z(-1);
            B b3 = this.y;
            b3.f1683c = aVar.f1828a + b3.f1684d;
            a(pVar, b3, uVar);
        }
        N();
        if (f() > 0) {
            if (this.A) {
                a(pVar, uVar, true);
                b(pVar, uVar, false);
            } else {
                b(pVar, uVar, true);
                a(pVar, uVar, false);
            }
        }
        if (z2 && !uVar.d()) {
            if (this.F != 0 && f() > 0 && (this.M || J() != null)) {
                a(this.P);
            }
        }
        z3 = false;
        if (uVar.d()) {
            this.L.b();
        }
        this.G = aVar.f1830c;
        this.H = L();
        if (z3) {
            this.L.b();
            c(pVar, uVar, false);
        }
    }

    private int h(u uVar) {
        if (f() == 0) {
            return 0;
        }
        return W.a(uVar, this.u, c(!this.N), b(!this.N), this, this.N);
    }

    private int j(u uVar) {
        if (f() == 0) {
            return 0;
        }
        return W.b(uVar, this.u, c(!this.N), b(!this.N), this, this.N);
    }

    private int o(int i2) {
        int i3 = -1;
        if (f() == 0) {
            if (this.A) {
                i3 = 1;
            }
            return i3;
        }
        if ((i2 < H()) == this.A) {
            i3 = 1;
        }
        return i3;
    }

    private int p(int i2) {
        int i3 = -1;
        int i4 = 1;
        if (i2 == 1) {
            return (this.w != 1 && L()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.w != 1 && L()) ? -1 : 1;
        }
        if (i2 == 17) {
            if (this.w != 0) {
                i3 = Integer.MIN_VALUE;
            }
            return i3;
        } else if (i2 == 33) {
            if (this.w != 1) {
                i3 = Integer.MIN_VALUE;
            }
            return i3;
        } else if (i2 == 66) {
            if (this.w != 0) {
                i4 = Integer.MIN_VALUE;
            }
            return i4;
        } else if (i2 != 130) {
            return Integer.MIN_VALUE;
        } else {
            if (this.w != 1) {
                i4 = Integer.MIN_VALUE;
            }
            return i4;
        }
    }

    private a q(int i2) {
        a aVar = new a();
        aVar.f1841c = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f1841c[i3] = i2 - this.t[i3].a(i2);
        }
        return aVar;
    }

    private a r(int i2) {
        a aVar = new a();
        aVar.f1841c = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f1841c[i3] = this.t[i3].b(i2) - i2;
        }
        return aVar;
    }

    private int t(int i2) {
        for (int f2 = f() - 1; f2 >= 0; f2--) {
            int m = m(f(f2));
            if (m >= 0 && m < i2) {
                return m;
            }
        }
        return 0;
    }

    private int u(int i2) {
        int a2 = this.t[0].a(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int a3 = this.t[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int v(int i2) {
        int b2 = this.t[0].b(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int b3 = this.t[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int x(int i2) {
        int b2 = this.t[0].b(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int b3 = this.t[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private boolean y(int i2) {
        boolean z2 = true;
        if (this.w == 0) {
            if ((i2 == -1) == this.A) {
                z2 = false;
            }
            return z2;
        }
        if (((i2 == -1) == this.A) != L()) {
            z2 = false;
        }
        return z2;
    }

    private void z(int i2) {
        B b2 = this.y;
        b2.f1685e = i2;
        int i3 = 1;
        if (this.A != (i2 == -1)) {
            i3 = -1;
        }
        b2.f1684d = i3;
    }

    public boolean C() {
        return this.I == null;
    }

    /* access modifiers changed from: 0000 */
    public boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean F() {
        int i2;
        int i3;
        if (f() == 0 || this.F == 0 || !r()) {
            return false;
        }
        if (this.A) {
            i3 = I();
            i2 = H();
        } else {
            i3 = H();
            i2 = I();
        }
        if (i3 == 0 && J() != null) {
            this.E.a();
            z();
            y();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i4 = this.A ? -1 : 1;
            int i5 = i2 + 1;
            a a2 = this.E.a(i3, i5, i4, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i5);
                return false;
            }
            a a3 = this.E.a(i3, a2.f1839a, i4 * -1, true);
            if (a3 == null) {
                this.E.b(a2.f1839a);
            } else {
                this.E.b(a3.f1839a + 1);
            }
            z();
            y();
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public int G() {
        View view;
        if (this.A) {
            view = b(true);
        } else {
            view = c(true);
        }
        if (view == null) {
            return -1;
        }
        return m(view);
    }

    /* access modifiers changed from: 0000 */
    public int H() {
        if (f() == 0) {
            return 0;
        }
        return m(f(0));
    }

    /* access modifiers changed from: 0000 */
    public int I() {
        int f2 = f();
        if (f2 == 0) {
            return 0;
        }
        return m(f(f2 - 1));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    public View J() {
        int i2;
        int f2 = f() - 1;
        BitSet bitSet = new BitSet(this.s);
        bitSet.set(0, this.s, true);
        int i3 = -1;
        char c2 = (this.w != 1 || !L()) ? (char) 65535 : 1;
        if (this.A) {
            i2 = -1;
        } else {
            i2 = f2 + 1;
            f2 = 0;
        }
        if (f2 < i2) {
            i3 = 1;
        }
        while (f2 != i2) {
            View f3 = f(f2);
            b bVar = (b) f3.getLayoutParams();
            if (bitSet.get(bVar.f1835e.f1857e)) {
                if (a(bVar.f1835e)) {
                    return f3;
                }
                bitSet.clear(bVar.f1835e.f1857e);
            }
            if (!bVar.f1836f) {
                int i4 = f2 + i3;
                if (i4 != i2) {
                    View f4 = f(i4);
                    if (this.A) {
                        int a2 = this.u.a(f3);
                        int a3 = this.u.a(f4);
                        if (a2 < a3) {
                            return f3;
                        }
                    } else {
                        int d2 = this.u.d(f3);
                        int d3 = this.u.d(f4);
                        if (d2 > d3) {
                            return f3;
                        }
                    }
                    boolean z2 = true;
                    if (z2) {
                        if ((bVar.f1835e.f1857e - ((b) f4.getLayoutParams()).f1835e.f1857e < 0) != (c2 < 0)) {
                            return f3;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            f2 += i3;
        }
        return null;
    }

    public void K() {
        this.E.a();
        y();
    }

    /* access modifiers changed from: 0000 */
    public boolean L() {
        return l() == 1;
    }

    public void b(RecyclerView recyclerView, p pVar) {
        super.b(recyclerView, pVar);
        a(this.P);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c();
        }
        recyclerView.requestLayout();
    }

    public void d(boolean z2) {
        a((String) null);
        d dVar = this.I;
        if (!(dVar == null || dVar.f1850h == z2)) {
            dVar.f1850h = z2;
        }
        this.z = z2;
        y();
    }

    public void e(p pVar, u uVar) {
        c(pVar, uVar, true);
    }

    public int f(u uVar) {
        return j(uVar);
    }

    public void g(u uVar) {
        super.g(uVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public void i(int i2) {
        if (i2 == 0) {
            F();
        }
    }

    public void k(int i2) {
        d dVar = this.I;
        if (!(dVar == null || dVar.f1843a == i2)) {
            dVar.n();
        }
        this.C = i2;
        this.D = Integer.MIN_VALUE;
        y();
    }

    public void l(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.w) {
                this.w = i2;
                I i3 = this.u;
                this.u = this.v;
                this.v = i3;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void m(int i2) {
        a((String) null);
        if (i2 != this.s) {
            K();
            this.s = i2;
            this.B = new BitSet(this.s);
            this.t = new e[this.s];
            for (int i3 = 0; i3 < this.s; i3++) {
                this.t[i3] = new e(i3);
            }
            y();
        }
    }

    /* access modifiers changed from: 0000 */
    public void n(int i2) {
        this.x = i2 / this.s;
        this.J = MeasureSpec.makeMeasureSpec(i2, this.v.d());
    }

    public boolean s() {
        return this.F != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    public Parcelable w() {
        int i2;
        int i3;
        int i4;
        d dVar = this.I;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        dVar2.f1850h = this.z;
        dVar2.f1851i = this.G;
        dVar2.f1852j = this.H;
        c cVar = this.E;
        if (cVar != null) {
            int[] iArr = cVar.f1837a;
            if (iArr != null) {
                dVar2.f1848f = iArr;
                dVar2.f1847e = dVar2.f1848f.length;
                dVar2.f1849g = cVar.f1838b;
                if (f() <= 0) {
                    if (this.G) {
                        i2 = I();
                    } else {
                        i2 = H();
                    }
                    dVar2.f1843a = i2;
                    dVar2.f1844b = G();
                    int i5 = this.s;
                    dVar2.f1845c = i5;
                    dVar2.f1846d = new int[i5];
                    for (int i6 = 0; i6 < this.s; i6++) {
                        if (this.G) {
                            i3 = this.t[i6].a(Integer.MIN_VALUE);
                            if (i3 != Integer.MIN_VALUE) {
                                i4 = this.u.b();
                            } else {
                                dVar2.f1846d[i6] = i3;
                            }
                        } else {
                            i3 = this.t[i6].b(Integer.MIN_VALUE);
                            if (i3 != Integer.MIN_VALUE) {
                                i4 = this.u.f();
                            } else {
                                dVar2.f1846d[i6] = i3;
                            }
                        }
                        i3 -= i4;
                        dVar2.f1846d[i6] = i3;
                    }
                } else {
                    dVar2.f1843a = -1;
                    dVar2.f1844b = -1;
                    dVar2.f1845c = 0;
                }
                return dVar2;
            }
        }
        dVar2.f1847e = 0;
        if (f() <= 0) {
        }
        return dVar2;
    }

    private int f(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    private int i(u uVar) {
        if (f() == 0) {
            return 0;
        }
        return W.a(uVar, this.u, c(!this.N), b(!this.N), this, this.N, this.A);
    }

    private int s(int i2) {
        int f2 = f();
        for (int i3 = 0; i3 < f2; i3++) {
            int m = m(f(i3));
            if (m >= 0 && m < i2) {
                return m;
            }
        }
        return 0;
    }

    public int e(u uVar) {
        return i(uVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    private void e(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int I2 = this.A ? I() : H();
        if (i4 != 8) {
            i7 = i2 + i3;
        } else if (i2 < i3) {
            i7 = i3 + 1;
        } else {
            i5 = i2 + 1;
            i6 = i3;
            this.E.e(i6);
            if (i4 != 1) {
                this.E.a(i2, i3);
            } else if (i4 == 2) {
                this.E.b(i2, i3);
            } else if (i4 == 8) {
                this.E.b(i2, 1);
                this.E.a(i3, 1);
            }
            if (i5 <= I2) {
                if (i6 <= (this.A ? H() : I())) {
                    y();
                }
                return;
            }
            return;
        }
        i5 = i7;
        i6 = i2;
        this.E.e(i6);
        if (i4 != 1) {
        }
        if (i5 <= I2) {
        }
    }

    private void q(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].a(view);
        }
    }

    private void r(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].c(view);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(u uVar, a aVar) {
        if (!a(uVar, aVar) && !c(uVar, aVar)) {
            aVar.a();
            aVar.f1828a = 0;
        }
    }

    public int d(u uVar) {
        return h(uVar);
    }

    public void g(int i2) {
        super.g(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].c(i2);
        }
    }

    public void h(int i2) {
        super.h(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].c(i2);
        }
    }

    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    public j d() {
        if (this.w == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    public int b(u uVar) {
        return i(uVar);
    }

    private void e(int i2, int i3) {
        for (int i4 = 0; i4 < this.s; i4++) {
            if (!this.t[i4].f1853a.isEmpty()) {
                a(this.t[i4], i2, i3);
            }
        }
    }

    public int b(p pVar, u uVar) {
        if (this.w == 0) {
            return this.s;
        }
        return super.b(pVar, uVar);
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.w == 1) {
            i5 = i.c(i3, rect.height() + paddingTop, m());
            i4 = i.c(i2, (this.x * this.s) + paddingLeft, n());
        } else {
            i4 = i.c(i2, rect.width() + paddingLeft, n());
            i5 = i.c(i3, (this.x * this.s) + paddingTop, m());
        }
        c(i4, i5);
    }

    /* access modifiers changed from: 0000 */
    public View b(boolean z2) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int f3 = f() - 1; f3 >= 0; f3--) {
            View f4 = f(f3);
            int d2 = this.u.d(f4);
            int a2 = this.u.a(f4);
            if (a2 > f2 && d2 < b2) {
                if (a2 <= b2 || !z2) {
                    return f4;
                }
                if (view == null) {
                    view = f4;
                }
            }
        }
        return view;
    }

    private void b(p pVar, u uVar, boolean z2) {
        int x2 = x(Integer.MAX_VALUE);
        if (x2 != Integer.MAX_VALUE) {
            int f2 = x2 - this.u.f();
            if (f2 > 0) {
                int c2 = f2 - c(f2, pVar, uVar);
                if (z2 && c2 > 0) {
                    this.u.a(-c2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    private void b(int i2, u uVar) {
        int i3;
        int i4;
        B b2 = this.y;
        boolean z2 = false;
        b2.f1682b = 0;
        b2.f1683c = i2;
        if (v()) {
            int b3 = uVar.b();
            if (b3 != -1) {
                if (this.A == (b3 < i2)) {
                    i4 = this.u.g();
                    i3 = 0;
                    if (g()) {
                        this.y.f1686f = this.u.f() - i3;
                        this.y.f1687g = this.u.b() + i4;
                    } else {
                        this.y.f1687g = this.u.a() + i4;
                        this.y.f1686f = -i3;
                    }
                    B b4 = this.y;
                    b4.f1688h = false;
                    b4.f1681a = true;
                    if (this.u.d() == 0 && this.u.a() == 0) {
                        z2 = true;
                    }
                    b4.f1689i = z2;
                }
                i3 = this.u.g();
                i4 = 0;
                if (g()) {
                }
                B b42 = this.y;
                b42.f1688h = false;
                b42.f1681a = true;
                z2 = true;
                b42.f1689i = z2;
            }
        }
        i4 = 0;
        i3 = 0;
        if (g()) {
        }
        B b422 = this.y;
        b422.f1688h = false;
        b422.f1681a = true;
        z2 = true;
        b422.f1689i = z2;
    }

    private void a(a aVar) {
        int i2;
        d dVar = this.I;
        int i3 = dVar.f1845c;
        if (i3 > 0) {
            if (i3 == this.s) {
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].c();
                    d dVar2 = this.I;
                    int i5 = dVar2.f1846d[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        if (dVar2.f1851i) {
                            i2 = this.u.b();
                        } else {
                            i2 = this.u.f();
                        }
                        i5 += i2;
                    }
                    this.t[i4].d(i5);
                }
            } else {
                dVar.o();
                d dVar3 = this.I;
                dVar3.f1843a = dVar3.f1844b;
            }
        }
        d dVar4 = this.I;
        this.H = dVar4.f1852j;
        d(dVar4.f1850h);
        O();
        d dVar5 = this.I;
        int i6 = dVar5.f1843a;
        if (i6 != -1) {
            this.C = i6;
            aVar.f1830c = dVar5.f1851i;
        } else {
            aVar.f1830c = this.A;
        }
        d dVar6 = this.I;
        if (dVar6.f1847e > 1) {
            c cVar = this.E;
            cVar.f1837a = dVar6.f1848f;
            cVar.f1838b = dVar6.f1849g;
        }
    }

    private int w(int i2) {
        int a2 = this.t[0].a(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int a3 = this.t[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        e(i2, i3, 2);
    }

    private void b(p pVar, int i2) {
        while (f() > 0) {
            View f2 = f(0);
            if (this.u.a(f2) > i2 || this.u.e(f2) > i2) {
                break;
            }
            b bVar = (b) f2.getLayoutParams();
            if (bVar.f1836f) {
                int i3 = 0;
                while (i3 < this.s) {
                    if (this.t[i3].f1853a.size() != 1) {
                        i3++;
                    } else {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].k();
                }
            } else if (bVar.f1835e.f1853a.size() != 1) {
                bVar.f1835e.k();
            } else {
                return;
            }
            a(f2, pVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(u uVar, a aVar) {
        int i2;
        int i3;
        boolean z2 = false;
        if (!uVar.d()) {
            int i4 = this.C;
            if (i4 != -1) {
                if (i4 < 0 || i4 >= uVar.a()) {
                    this.C = -1;
                    this.D = Integer.MIN_VALUE;
                } else {
                    d dVar = this.I;
                    if (dVar == null || dVar.f1843a == -1 || dVar.f1845c < 1) {
                        View e2 = e(this.C);
                        if (e2 != null) {
                            if (this.A) {
                                i2 = I();
                            } else {
                                i2 = H();
                            }
                            aVar.f1828a = i2;
                            if (this.D != Integer.MIN_VALUE) {
                                if (aVar.f1830c) {
                                    aVar.f1829b = (this.u.b() - this.D) - this.u.a(e2);
                                } else {
                                    aVar.f1829b = (this.u.f() + this.D) - this.u.d(e2);
                                }
                                return true;
                            } else if (this.u.b(e2) > this.u.g()) {
                                if (aVar.f1830c) {
                                    i3 = this.u.b();
                                } else {
                                    i3 = this.u.f();
                                }
                                aVar.f1829b = i3;
                                return true;
                            } else {
                                int d2 = this.u.d(e2) - this.u.f();
                                if (d2 < 0) {
                                    aVar.f1829b = -d2;
                                    return true;
                                }
                                int b2 = this.u.b() - this.u.a(e2);
                                if (b2 < 0) {
                                    aVar.f1829b = b2;
                                    return true;
                                }
                                aVar.f1829b = Integer.MIN_VALUE;
                            }
                        } else {
                            aVar.f1828a = this.C;
                            int i5 = this.D;
                            if (i5 == Integer.MIN_VALUE) {
                                if (o(aVar.f1828a) == 1) {
                                    z2 = true;
                                }
                                aVar.f1830c = z2;
                                aVar.a();
                            } else {
                                aVar.a(i5);
                            }
                            aVar.f1831d = true;
                        }
                    } else {
                        aVar.f1829b = Integer.MIN_VALUE;
                        aVar.f1828a = this.C;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b() {
        return this.w == 0;
    }

    public int b(int i2, p pVar, u uVar) {
        return c(i2, pVar, uVar);
    }

    private boolean c(u uVar, a aVar) {
        int i2;
        if (this.G) {
            i2 = t(uVar.a());
        } else {
            i2 = s(uVar.a());
        }
        aVar.f1828a = i2;
        aVar.f1829b = Integer.MIN_VALUE;
        return true;
    }

    public int c(u uVar) {
        return j(uVar);
    }

    /* access modifiers changed from: 0000 */
    public View c(boolean z2) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        int f3 = f();
        View view = null;
        for (int i2 = 0; i2 < f3; i2++) {
            View f4 = f(i2);
            int d2 = this.u.d(f4);
            if (this.u.a(f4) > f2 && d2 < b2) {
                if (d2 >= f2 || !z2) {
                    return f4;
                }
                if (view == null) {
                    view = f4;
                }
            }
        }
        return view;
    }

    public boolean c() {
        return this.w == 1;
    }

    public PointF c(int i2) {
        int o = o(i2);
        PointF pointF = new PointF();
        if (o == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = (float) o;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) o;
        }
        return pointF;
    }

    public int a(u uVar) {
        return h(uVar);
    }

    private void a(View view, b bVar, boolean z2) {
        if (bVar.f1836f) {
            if (this.w == 1) {
                a(view, this.J, i.a(i(), j(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z2);
            } else {
                a(view, i.a(o(), p(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.J, z2);
            }
        } else if (this.w == 1) {
            a(view, i.a(this.x, p(), 0, bVar.width, false), i.a(i(), j(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z2);
        } else {
            a(view, i.a(o(), p(), getPaddingLeft() + getPaddingRight(), bVar.width, true), i.a(this.x, j(), 0, bVar.height, false), z2);
        }
    }

    /* access modifiers changed from: 0000 */
    public int c(int i2, p pVar, u uVar) {
        if (f() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, uVar);
        int a2 = a(pVar, this.y, uVar);
        if (this.y.f1682b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.u.a(-i2);
        this.G = this.A;
        B b2 = this.y;
        b2.f1682b = 0;
        a(pVar, b2);
        return i2;
    }

    private void a(View view, int i2, int i3, boolean z2) {
        boolean z3;
        a(view, this.K);
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.leftMargin;
        Rect rect = this.K;
        int f2 = f(i2, i4 + rect.left, bVar.rightMargin + rect.right);
        int i5 = bVar.topMargin;
        Rect rect2 = this.K;
        int f3 = f(i3, i5 + rect2.top, bVar.bottomMargin + rect2.bottom);
        if (z2) {
            z3 = b(view, f2, f3, (j) bVar);
        } else {
            z3 = a(view, f2, f3, (j) bVar);
        }
        if (z3) {
            view.measure(f2, f3);
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.I = (d) parcelable;
            y();
        }
    }

    public void a(p pVar, u uVar, View view, b.g.i.a.d dVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.w == 0) {
            dVar.b((Object) b.g.i.a.d.c.a(bVar.r(), bVar.f1836f ? this.s : 1, -1, -1, bVar.f1836f, false));
        } else {
            dVar.b((Object) b.g.i.a.d.c.a(-1, -1, bVar.r(), bVar.f1836f ? this.s : 1, bVar.f1836f, false));
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (f() > 0) {
            View c2 = c(false);
            View b2 = b(false);
            if (c2 != null && b2 != null) {
                int m = m(c2);
                int m2 = m(b2);
                if (m < m2) {
                    accessibilityEvent.setFromIndex(m);
                    accessibilityEvent.setToIndex(m2);
                    return;
                }
                accessibilityEvent.setFromIndex(m2);
                accessibilityEvent.setToIndex(m);
            }
        }
    }

    public int a(p pVar, u uVar) {
        if (this.w == 1) {
            return this.s;
        }
        return super.a(pVar, uVar);
    }

    private void a(p pVar, u uVar, boolean z2) {
        int u2 = u(Integer.MIN_VALUE);
        if (u2 != Integer.MIN_VALUE) {
            int b2 = this.u.b() - u2;
            if (b2 > 0) {
                int i2 = b2 - (-c(-b2, pVar, uVar));
                if (z2 && i2 > 0) {
                    this.u.a(i2);
                }
            }
        }
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        e(i2, i3, 1);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        e(i2, i3, 8);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        e(i2, i3, 4);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1, types: [boolean, int]
      assigns: []
      uses: [boolean, int, ?[int, short, byte, char]]
      mth insns count: 222
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    private int a(p pVar, B b2, u uVar) {
        int i2;
        int i3;
        int i4;
        e eVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        p pVar2 = pVar;
        B b3 = b2;
        ? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.f1689i) {
            i2 = b3.f1685e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (b3.f1685e == 1) {
                i13 = b3.f1687g + b3.f1682b;
            } else {
                i13 = b3.f1686f - b3.f1682b;
            }
            i2 = i13;
        }
        e(b3.f1685e, i2);
        if (this.A) {
            i3 = this.u.b();
        } else {
            i3 = this.u.f();
        }
        int i14 = i3;
        boolean z3 = false;
        ? r92 = r9;
        while (b2.a(uVar) && (this.y.f1689i || !this.B.isEmpty())) {
            View a2 = b3.a(pVar2);
            b bVar = (b) a2.getLayoutParams();
            int n = bVar.n();
            int d2 = this.E.d(n);
            boolean z4 = d2 == -1;
            if (z4) {
                eVar = bVar.f1836f ? this.t[r92] : a(b3);
                this.E.a(n, eVar);
            } else {
                eVar = this.t[d2];
            }
            e eVar2 = eVar;
            bVar.f1835e = eVar2;
            if (b3.f1685e == 1) {
                c(a2);
            } else {
                b(a2, (int) r92);
            }
            a(a2, bVar, (boolean) r92);
            if (b3.f1685e == 1) {
                if (bVar.f1836f) {
                    i12 = u(i14);
                } else {
                    i12 = eVar2.a(i14);
                }
                int b4 = this.u.b(a2) + i12;
                if (z4 && bVar.f1836f) {
                    a q = q(i12);
                    q.f1840b = -1;
                    q.f1839a = n;
                    this.E.a(q);
                }
                i5 = b4;
                i6 = i12;
            } else {
                if (bVar.f1836f) {
                    i11 = x(i14);
                } else {
                    i11 = eVar2.b(i14);
                }
                i6 = i11 - this.u.b(a2);
                if (z4 && bVar.f1836f) {
                    a r = r(i11);
                    r.f1840b = 1;
                    r.f1839a = n;
                    this.E.a(r);
                }
                i5 = i11;
            }
            if (bVar.f1836f && b3.f1684d == -1) {
                if (z4) {
                    this.M = true;
                } else {
                    if (b3.f1685e == 1) {
                        z2 = D();
                    } else {
                        z2 = E();
                    }
                    if (!z2) {
                        a c2 = this.E.c(n);
                        if (c2 != null) {
                            c2.f1842d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, bVar, b3);
            if (!L() || this.w != 1) {
                if (bVar.f1836f) {
                    i9 = this.v.f();
                } else {
                    i9 = (eVar2.f1857e * this.x) + this.v.f();
                }
                i8 = i9;
                i7 = this.v.b(a2) + i9;
            } else {
                if (bVar.f1836f) {
                    i10 = this.v.b();
                } else {
                    i10 = this.v.b() - (((this.s - 1) - eVar2.f1857e) * this.x);
                }
                i7 = i10;
                i8 = i10 - this.v.b(a2);
            }
            if (this.w == 1) {
                a(a2, i8, i6, i7, i5);
            } else {
                a(a2, i6, i8, i5, i7);
            }
            if (bVar.f1836f) {
                e(this.y.f1685e, i2);
            } else {
                a(eVar2, this.y.f1685e, i2);
            }
            a(pVar2, this.y);
            if (this.y.f1688h && a2.hasFocusable()) {
                if (bVar.f1836f) {
                    this.B.clear();
                } else {
                    this.B.set(eVar2.f1857e, false);
                    z3 = true;
                    r92 = 0;
                }
            }
            z3 = true;
            r92 = 0;
        }
        if (!z3) {
            a(pVar2, this.y);
        }
        if (this.y.f1685e == -1) {
            i4 = this.u.f() - x(this.u.f());
        } else {
            i4 = u(this.u.b()) - this.u.b();
        }
        if (i4 > 0) {
            return Math.min(b3.f1682b, i4);
        }
        return 0;
    }

    private void a(View view, b bVar, B b2) {
        if (b2.f1685e == 1) {
            if (bVar.f1836f) {
                q(view);
            } else {
                bVar.f1835e.a(view);
            }
        } else if (bVar.f1836f) {
            r(view);
        } else {
            bVar.f1835e.c(view);
        }
    }

    private void a(p pVar, B b2) {
        int i2;
        int i3;
        if (b2.f1681a && !b2.f1689i) {
            if (b2.f1682b == 0) {
                if (b2.f1685e == -1) {
                    a(pVar, b2.f1687g);
                } else {
                    b(pVar, b2.f1686f);
                }
            } else if (b2.f1685e == -1) {
                int i4 = b2.f1686f;
                int v2 = i4 - v(i4);
                if (v2 < 0) {
                    i3 = b2.f1687g;
                } else {
                    i3 = b2.f1687g - Math.min(v2, b2.f1682b);
                }
                a(pVar, i3);
            } else {
                int w2 = w(b2.f1687g) - b2.f1687g;
                if (w2 < 0) {
                    i2 = b2.f1686f;
                } else {
                    i2 = Math.min(w2, b2.f1682b) + b2.f1686f;
                }
                b(pVar, i2);
            }
        }
    }

    private void a(e eVar, int i2, int i3) {
        int f2 = eVar.f();
        if (i2 == -1) {
            if (eVar.h() + f2 <= i3) {
                this.B.set(eVar.f1857e, false);
            }
        } else if (eVar.g() - f2 >= i3) {
            this.B.set(eVar.f1857e, false);
        }
    }

    private void a(p pVar, int i2) {
        for (int f2 = f() - 1; f2 >= 0; f2--) {
            View f3 = f(f2);
            if (this.u.d(f3) < i2 || this.u.f(f3) < i2) {
                break;
            }
            b bVar = (b) f3.getLayoutParams();
            if (bVar.f1836f) {
                int i3 = 0;
                while (i3 < this.s) {
                    if (this.t[i3].f1853a.size() != 1) {
                        i3++;
                    } else {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].j();
                }
            } else if (bVar.f1835e.f1853a.size() != 1) {
                bVar.f1835e.j();
            } else {
                return;
            }
            a(f3, pVar);
        }
    }

    private e a(B b2) {
        int i2;
        int i3;
        int i4 = -1;
        if (y(b2.f1685e)) {
            i3 = this.s - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.s;
            i2 = 1;
        }
        e eVar = null;
        if (b2.f1685e == 1) {
            int i5 = Integer.MAX_VALUE;
            int f2 = this.u.f();
            while (i3 != i4) {
                e eVar2 = this.t[i3];
                int a2 = eVar2.a(f2);
                if (a2 < i5) {
                    eVar = eVar2;
                    i5 = a2;
                }
                i3 += i2;
            }
            return eVar;
        }
        int i6 = Integer.MIN_VALUE;
        int b3 = this.u.b();
        while (i3 != i4) {
            e eVar3 = this.t[i3];
            int b4 = eVar3.b(b3);
            if (b4 > i6) {
                eVar = eVar3;
                i6 = b4;
            }
            i3 += i2;
        }
        return eVar;
    }

    public int a(int i2, p pVar, u uVar) {
        return c(i2, pVar, uVar);
    }

    public void a(RecyclerView recyclerView, u uVar, int i2) {
        D d2 = new D(recyclerView.getContext());
        d2.c(i2);
        b((t) d2);
    }

    public void a(int i2, int i3, u uVar, androidx.recyclerview.widget.RecyclerView.i.a aVar) {
        int i4;
        int i5;
        if (this.w != 0) {
            i2 = i3;
        }
        if (f() != 0 && i2 != 0) {
            a(i2, uVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.s; i7++) {
                B b2 = this.y;
                if (b2.f1684d == -1) {
                    i5 = b2.f1686f;
                    i4 = this.t[i7].b(i5);
                } else {
                    i5 = this.t[i7].a(b2.f1687g);
                    i4 = this.y.f1687g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.O[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.O, 0, i6);
            for (int i9 = 0; i9 < i6 && this.y.a(uVar); i9++) {
                aVar.a(this.y.f1683c, this.O[i9]);
                B b3 = this.y;
                b3.f1683c += b3.f1684d;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, u uVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = I();
            i3 = 1;
        } else {
            i4 = H();
            i3 = -1;
        }
        this.y.f1681a = true;
        b(i4, uVar);
        z(i3);
        B b2 = this.y;
        b2.f1683c = i4 + b2.f1684d;
        b2.f1682b = Math.abs(i2);
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

    public boolean a(j jVar) {
        return jVar instanceof b;
    }

    public View a(View view, int i2, p pVar, u uVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (f() == 0) {
            return null;
        }
        View d2 = d(view);
        if (d2 == null) {
            return null;
        }
        O();
        int p = p(i2);
        if (p == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) d2.getLayoutParams();
        boolean z2 = bVar.f1836f;
        e eVar = bVar.f1835e;
        if (p == 1) {
            i3 = I();
        } else {
            i3 = H();
        }
        b(i3, uVar);
        z(p);
        B b2 = this.y;
        b2.f1683c = b2.f1684d + i3;
        b2.f1682b = (int) (((float) this.u.g()) * 0.33333334f);
        B b3 = this.y;
        b3.f1688h = true;
        b3.f1681a = false;
        a(pVar, b3, uVar);
        this.G = this.A;
        if (!z2) {
            View a2 = eVar.a(i3, p);
            if (!(a2 == null || a2 == d2)) {
                return a2;
            }
        }
        if (y(p)) {
            for (int i7 = this.s - 1; i7 >= 0; i7--) {
                View a3 = this.t[i7].a(i3, p);
                if (a3 != null && a3 != d2) {
                    return a3;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.s; i8++) {
                View a4 = this.t[i8].a(i3, p);
                if (a4 != null && a4 != d2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.z ^ true) == (p == -1);
        if (!z2) {
            if (z3) {
                i6 = eVar.d();
            } else {
                i6 = eVar.e();
            }
            View e2 = e(i6);
            if (!(e2 == null || e2 == d2)) {
                return e2;
            }
        }
        if (y(p)) {
            for (int i9 = this.s - 1; i9 >= 0; i9--) {
                if (i9 != eVar.f1857e) {
                    if (z3) {
                        i5 = this.t[i9].d();
                    } else {
                        i5 = this.t[i9].e();
                    }
                    View e3 = e(i5);
                    if (!(e3 == null || e3 == d2)) {
                        return e3;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.s; i10++) {
                if (z3) {
                    i4 = this.t[i10].d();
                } else {
                    i4 = this.t[i10].e();
                }
                View e4 = e(i4);
                if (e4 != null && e4 != d2) {
                    return e4;
                }
            }
        }
        return null;
    }
}
