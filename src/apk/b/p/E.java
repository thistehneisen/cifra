package b.p;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import b.d.f;
import b.d.i;
import b.g.i.B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Transition */
public abstract class E implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f2809a = {2, 1, 3, 4};

    /* renamed from: b reason: collision with root package name */
    private static final C0275v f2810b = new B();

    /* renamed from: c reason: collision with root package name */
    private static ThreadLocal<b.d.b<Animator, a>> f2811c = new ThreadLocal<>();
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    I G;
    private b H;
    private b.d.b<String, String> I;
    private C0275v J = f2810b;

    /* renamed from: d reason: collision with root package name */
    private String f2812d = getClass().getName();

    /* renamed from: e reason: collision with root package name */
    private long f2813e = -1;

    /* renamed from: f reason: collision with root package name */
    long f2814f = -1;

    /* renamed from: g reason: collision with root package name */
    private TimeInterpolator f2815g = null;

    /* renamed from: h reason: collision with root package name */
    ArrayList<Integer> f2816h = new ArrayList<>();

    /* renamed from: i reason: collision with root package name */
    ArrayList<View> f2817i = new ArrayList<>();

    /* renamed from: j reason: collision with root package name */
    private ArrayList<String> f2818j = null;

    /* renamed from: k reason: collision with root package name */
    private ArrayList<Class> f2819k = null;

    /* renamed from: l reason: collision with root package name */
    private ArrayList<Integer> f2820l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class> r = null;
    private N s = new N();
    private N t = new N();
    K u = null;
    private int[] v = f2809a;
    private ArrayList<M> w;
    private ArrayList<M> x;
    private ViewGroup y = null;
    boolean z = false;

    /* compiled from: Transition */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        View f2821a;

        /* renamed from: b reason: collision with root package name */
        String f2822b;

        /* renamed from: c reason: collision with root package name */
        M f2823c;

        /* renamed from: d reason: collision with root package name */
        ka f2824d;

        /* renamed from: e reason: collision with root package name */
        E f2825e;

        a(View view, String str, E e2, ka kaVar, M m) {
            this.f2821a = view;
            this.f2822b = str;
            this.f2823c = m;
            this.f2824d = kaVar;
            this.f2825e = e2;
        }
    }

    /* compiled from: Transition */
    public static abstract class b {
    }

    /* compiled from: Transition */
    public interface c {
        void a(E e2);

        void b(E e2);

        void c(E e2);

        void d(E e2);
    }

    private void c(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f2820l;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.m;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.n;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!((Class) this.n.get(i2)).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        M m2 = new M();
                        m2.f2840b = view;
                        if (z2) {
                            c(m2);
                        } else {
                            a(m2);
                        }
                        m2.f2841c.add(this);
                        b(m2);
                        if (z2) {
                            a(this.s, view, m2);
                        } else {
                            a(this.t, view, m2);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.p;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.q;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.r;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!((Class) this.r.get(i3)).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    c(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static b.d.b<Animator, a> p() {
        b.d.b<Animator, a> bVar = (b.d.b) f2811c.get();
        if (bVar != null) {
            return bVar;
        }
        b.d.b<Animator, a> bVar2 = new b.d.b<>();
        f2811c.set(bVar2);
        return bVar2;
    }

    public Animator a(ViewGroup viewGroup, M m2, M m3) {
        return null;
    }

    public E a(long j2) {
        this.f2814f = j2;
        return this;
    }

    public abstract void a(M m2);

    public long b() {
        return this.f2814f;
    }

    public abstract void c(M m2);

    public TimeInterpolator d() {
        return this.f2815g;
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                b.d.b p2 = p();
                int size = p2.size();
                ka d2 = ba.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a aVar = (a) p2.d(i2);
                    if (aVar.f2821a != null && d2.equals(aVar.f2824d)) {
                        C0255a.b((Animator) p2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public C0275v f() {
        return this.J;
    }

    public I g() {
        return this.G;
    }

    public long h() {
        return this.f2813e;
    }

    public List<Integer> i() {
        return this.f2816h;
    }

    public List<String> j() {
        return this.f2818j;
    }

    public List<Class> k() {
        return this.f2819k;
    }

    public List<View> l() {
        return this.f2817i;
    }

    public String[] m() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void n() {
        o();
        b.d.b p2 = p();
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (p2.containsKey(animator)) {
                o();
                a(animator, p2);
            }
        }
        this.F.clear();
        a();
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).a(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public String toString() {
        return a("");
    }

    public E a(TimeInterpolator timeInterpolator) {
        this.f2815g = timeInterpolator;
        return this;
    }

    public E b(long j2) {
        this.f2813e = j2;
        return this;
    }

    public E clone() {
        try {
            E e2 = (E) super.clone();
            e2.F = new ArrayList<>();
            e2.s = new N();
            e2.t = new N();
            e2.w = null;
            e2.x = null;
            return e2;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public E d(View view) {
        this.f2817i.remove(view);
        return this;
    }

    private void a(b.d.b<View, M> bVar, b.d.b<View, M> bVar2, f<View> fVar, f<View> fVar2) {
        int b2 = fVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View view = (View) fVar.c(i2);
            if (view != null && b(view)) {
                View view2 = (View) fVar2.b(fVar.a(i2));
                if (view2 != null && b(view2)) {
                    M m2 = (M) bVar.get(view);
                    M m3 = (M) bVar2.get(view2);
                    if (!(m2 == null || m3 == null)) {
                        this.w.add(m2);
                        this.x.add(m3);
                        bVar.remove(view);
                        bVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void b(b.d.b<View, M> bVar, b.d.b<View, M> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View view = (View) bVar.b(size);
            if (view != null && b(view)) {
                M m2 = (M) bVar2.remove(view);
                if (m2 != null) {
                    View view2 = m2.f2840b;
                    if (view2 != null && b(view2)) {
                        this.w.add((M) bVar.c(size));
                        this.x.add(m2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean b(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f2820l;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList2 = this.m;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList3 = this.n;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((Class) this.n.get(i2)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.o != null && B.r(view) != null && this.o.contains(B.r(view))) {
            return false;
        }
        if (this.f2816h.size() == 0 && this.f2817i.size() == 0) {
            ArrayList<Class> arrayList4 = this.f2819k;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                ArrayList<String> arrayList5 = this.f2818j;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.f2816h.contains(Integer.valueOf(id)) || this.f2817i.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f2818j;
        if (arrayList6 != null && arrayList6.contains(B.r(view))) {
            return true;
        }
        if (this.f2819k != null) {
            for (int i3 = 0; i3 < this.f2819k.size(); i3++) {
                if (((Class) this.f2819k.get(i3)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(b.d.b<View, M> bVar, b.d.b<View, M> bVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) sparseArray.valueAt(i2);
            if (view != null && b(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i2));
                if (view2 != null && b(view2)) {
                    M m2 = (M) bVar.get(view);
                    M m3 = (M) bVar2.get(view2);
                    if (!(m2 == null || m3 == null)) {
                        this.w.add(m2);
                        this.x.add(m3);
                        bVar.remove(view);
                        bVar2.remove(view2);
                    }
                }
            }
        }
    }

    public String e() {
        return this.f2812d;
    }

    private void a(b.d.b<View, M> bVar, b.d.b<View, M> bVar2, b.d.b<String, View> bVar3, b.d.b<String, View> bVar4) {
        int size = bVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) bVar3.d(i2);
            if (view != null && b(view)) {
                View view2 = (View) bVar4.get(bVar3.b(i2));
                if (view2 != null && b(view2)) {
                    M m2 = (M) bVar.get(view);
                    M m3 = (M) bVar2.get(view2);
                    if (!(m2 == null || m3 == null)) {
                        this.w.add(m2);
                        this.x.add(m3);
                        bVar.remove(view);
                        bVar2.remove(view2);
                    }
                }
            }
        }
    }

    public void c(View view) {
        if (!this.D) {
            b.d.b p2 = p();
            int size = p2.size();
            ka d2 = ba.d(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = (a) p2.d(i2);
                if (aVar.f2821a != null && d2.equals(aVar.f2824d)) {
                    C0255a.a((Animator) p2.b(i2));
                }
            }
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).b(this);
                }
            }
            this.C = true;
        }
    }

    public M b(View view, boolean z2) {
        K k2 = this.u;
        if (k2 != null) {
            return k2.b(view, z2);
        }
        return (M) (z2 ? this.s : this.t).f2842a.get(view);
    }

    public E b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    private void a(b.d.b<View, M> bVar, b.d.b<View, M> bVar2) {
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            M m2 = (M) bVar.d(i2);
            if (b(m2.f2840b)) {
                this.w.add(m2);
                this.x.add(null);
            }
        }
        for (int i3 = 0; i3 < bVar2.size(); i3++) {
            M m3 = (M) bVar2.d(i3);
            if (b(m3.f2840b)) {
                this.x.add(m3);
                this.w.add(null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(M m2) {
        if (this.G != null && !m2.f2839a.isEmpty()) {
            String[] a2 = this.G.a();
            if (a2 != null) {
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= a2.length) {
                        z2 = true;
                        break;
                    } else if (!m2.f2839a.containsKey(a2[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    this.G.a(m2);
                }
            }
        }
    }

    public b c() {
        return this.H;
    }

    private void a(N n2, N n3) {
        b.d.b bVar = new b.d.b((i) n2.f2842a);
        b.d.b bVar2 = new b.d.b((i) n3.f2842a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.v;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    b(bVar, bVar2);
                } else if (i3 == 2) {
                    a(bVar, bVar2, n2.f2845d, n3.f2845d);
                } else if (i3 == 3) {
                    a(bVar, bVar2, n2.f2843b, n3.f2843b);
                } else if (i3 == 4) {
                    a(bVar, bVar2, n2.f2844c, n3.f2844c);
                }
                i2++;
            } else {
                a(bVar, bVar2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, N n2, N n3, ArrayList<M> arrayList, ArrayList<M> arrayList2) {
        int i2;
        int i3;
        View view;
        Animator animator;
        M m2;
        M m3;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        b.d.b p2 = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            M m4 = (M) arrayList.get(i4);
            M m5 = (M) arrayList2.get(i4);
            if (m4 != null && !m4.f2841c.contains(this)) {
                m4 = null;
            }
            if (m5 != null && !m5.f2841c.contains(this)) {
                m5 = null;
            }
            if (!(m4 == null && m5 == null)) {
                if (m4 == null || m5 == null || a(m4, m5)) {
                    Animator a2 = a(viewGroup2, m4, m5);
                    if (a2 != null) {
                        if (m5 != null) {
                            view = m5.f2840b;
                            String[] m6 = m();
                            if (view != null && m6 != null && m6.length > 0) {
                                m3 = new M();
                                m3.f2840b = view;
                                Animator animator3 = a2;
                                i3 = size;
                                M m7 = (M) n3.f2842a.get(view);
                                if (m7 != null) {
                                    int i5 = 0;
                                    while (i5 < m6.length) {
                                        int i6 = i4;
                                        M m8 = m7;
                                        m3.f2839a.put(m6[i5], m7.f2839a.get(m6[i5]));
                                        i5++;
                                        ArrayList<M> arrayList3 = arrayList2;
                                        i4 = i6;
                                        m7 = m8;
                                    }
                                }
                                i2 = i4;
                                int size2 = p2.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    a aVar = (a) p2.get((Animator) p2.b(i7));
                                    if (aVar.f2823c != null && aVar.f2821a == view && aVar.f2822b.equals(e()) && aVar.f2823c.equals(m3)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i7++;
                                }
                            } else {
                                i3 = size;
                                i2 = i4;
                                animator2 = a2;
                                m3 = null;
                            }
                            animator = animator2;
                            m2 = m3;
                        } else {
                            Animator animator4 = a2;
                            i3 = size;
                            i2 = i4;
                            view = m4.f2840b;
                            animator = animator4;
                            m2 = null;
                        }
                        if (animator != null) {
                            I i8 = this.G;
                            if (i8 != null) {
                                long a3 = i8.a(viewGroup2, this, m4, m5);
                                sparseIntArray.put(this.F.size(), (int) a3);
                                j2 = Math.min(a3, j2);
                            }
                            long j3 = j2;
                            a aVar2 = new a(view, e(), this, ba.d(viewGroup), m2);
                            p2.put(animator, aVar2);
                            this.F.add(animator);
                            j2 = j3;
                        }
                        i4 = i2 + 1;
                        size = i3;
                    }
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (j2 != 0) {
            for (int i9 = 0; i9 < sparseIntArray.size(); i9++) {
                Animator animator5 = (Animator) this.F.get(sparseIntArray.keyAt(i9));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i9)) - j2) + animator5.getStartDelay());
            }
        }
    }

    private void a(Animator animator, b.d.b<Animator, a> bVar) {
        if (animator != null) {
            animator.addListener(new C(this, bVar));
            a(animator);
        }
    }

    public E a(View view) {
        this.f2817i.add(view);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void a(ViewGroup viewGroup, boolean z2) {
        a(z2);
        if (this.f2816h.size() > 0 || this.f2817i.size() > 0) {
            ArrayList<String> arrayList = this.f2818j;
            if (arrayList == null || arrayList.isEmpty()) {
                ArrayList<Class> arrayList2 = this.f2819k;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    for (int i2 = 0; i2 < this.f2816h.size(); i2++) {
                        View findViewById = viewGroup.findViewById(((Integer) this.f2816h.get(i2)).intValue());
                        if (findViewById != null) {
                            M m2 = new M();
                            m2.f2840b = findViewById;
                            if (z2) {
                                c(m2);
                            } else {
                                a(m2);
                            }
                            m2.f2841c.add(this);
                            b(m2);
                            if (z2) {
                                a(this.s, findViewById, m2);
                            } else {
                                a(this.t, findViewById, m2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f2817i.size(); i3++) {
                        View view = (View) this.f2817i.get(i3);
                        M m3 = new M();
                        m3.f2840b = view;
                        if (z2) {
                            c(m3);
                        } else {
                            a(m3);
                        }
                        m3.f2841c.add(this);
                        b(m3);
                        if (z2) {
                            a(this.s, view, m3);
                        } else {
                            a(this.t, view, m3);
                        }
                    }
                    if (z2) {
                        b.d.b<String, String> bVar = this.I;
                        if (bVar != null) {
                            int size = bVar.size();
                            ArrayList arrayList3 = new ArrayList(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                arrayList3.add(this.s.f2845d.remove((String) this.I.b(i4)));
                            }
                            for (int i5 = 0; i5 < size; i5++) {
                                View view2 = (View) arrayList3.get(i5);
                                if (view2 != null) {
                                    this.s.f2845d.put((String) this.I.d(i5), view2);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        c(viewGroup, z2);
        if (z2) {
        }
    }

    private static void a(N n2, View view, M m2) {
        n2.f2842a.put(view, m2);
        int id = view.getId();
        if (id >= 0) {
            if (n2.f2843b.indexOfKey(id) >= 0) {
                n2.f2843b.put(id, null);
            } else {
                n2.f2843b.put(id, view);
            }
        }
        String r2 = B.r(view);
        if (r2 != null) {
            if (n2.f2845d.containsKey(r2)) {
                n2.f2845d.put(r2, null);
            } else {
                n2.f2845d.put(r2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (n2.f2844c.c(itemIdAtPosition) >= 0) {
                    View view2 = (View) n2.f2844c.b(itemIdAtPosition);
                    if (view2 != null) {
                        B.b(view2, false);
                        n2.f2844c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                B.b(view, true);
                n2.f2844c.c(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z2) {
        if (z2) {
            this.s.f2842a.clear();
            this.s.f2843b.clear();
            this.s.f2844c.a();
            return;
        }
        this.t.f2842a.clear();
        this.t.f2843b.clear();
        this.t.f2844c.a();
    }

    /* access modifiers changed from: 0000 */
    public M a(View view, boolean z2) {
        K k2 = this.u;
        if (k2 != null) {
            return k2.a(view, z2);
        }
        ArrayList<M> arrayList = z2 ? this.w : this.x;
        M m2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            M m3 = (M) arrayList.get(i3);
            if (m3 == null) {
                return null;
            }
            if (m3.f2840b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            m2 = (M) (z2 ? this.x : this.w).get(i2);
        }
        return m2;
    }

    /* access modifiers changed from: 0000 */
    public void a(ViewGroup viewGroup) {
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        b.d.b p2 = p();
        int size = p2.size();
        ka d2 = ba.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animator = (Animator) p2.b(i2);
            if (animator != null) {
                a aVar = (a) p2.get(animator);
                if (!(aVar == null || aVar.f2821a == null || !d2.equals(aVar.f2824d))) {
                    M m2 = aVar.f2823c;
                    View view = aVar.f2821a;
                    M b2 = b(view, true);
                    M a2 = a(view, true);
                    if (!(b2 == null && a2 == null) && aVar.f2825e.a(m2, a2)) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            p2.remove(animator);
                        }
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        n();
    }

    public boolean a(M m2, M m3) {
        if (m2 == null || m3 == null) {
            return false;
        }
        String[] m4 = m();
        if (m4 != null) {
            int length = m4.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(m2, m3, m4[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a2 : m2.f2839a.keySet()) {
            if (a(m2, m3, a2)) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(M m2, M m3, String str) {
        Object obj = m2.f2839a.get(str);
        Object obj2 = m3.f2839a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (h() >= 0) {
            animator.setStartDelay(h());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new D(this));
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.s.f2844c.b(); i3++) {
                View view = (View) this.s.f2844c.c(i3);
                if (view != null) {
                    B.b(view, false);
                }
            }
            for (int i4 = 0; i4 < this.t.f2844c.b(); i4++) {
                View view2 = (View) this.t.f2844c.c(i4);
                if (view2 != null) {
                    B.b(view2, false);
                }
            }
            this.D = true;
        }
    }

    public E a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(C0275v vVar) {
        if (vVar == null) {
            this.J = f2810b;
        } else {
            this.J = vVar;
        }
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public void a(I i2) {
        this.G = i2;
    }

    /* access modifiers changed from: 0000 */
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        String sb2 = sb.toString();
        String str2 = ") ";
        if (this.f2814f != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("dur(");
            sb3.append(this.f2814f);
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        if (this.f2813e != -1) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append("dly(");
            sb4.append(this.f2813e);
            sb4.append(str2);
            sb2 = sb4.toString();
        }
        if (this.f2815g != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append("interp(");
            sb5.append(this.f2815g);
            sb5.append(str2);
            sb2 = sb5.toString();
        }
        if (this.f2816h.size() <= 0 && this.f2817i.size() <= 0) {
            return sb2;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sb2);
        sb6.append("tgts(");
        String sb7 = sb6.toString();
        String str3 = ", ";
        if (this.f2816h.size() > 0) {
            String str4 = sb7;
            for (int i2 = 0; i2 < this.f2816h.size(); i2++) {
                if (i2 > 0) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str4);
                    sb8.append(str3);
                    str4 = sb8.toString();
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str4);
                sb9.append(this.f2816h.get(i2));
                str4 = sb9.toString();
            }
            sb7 = str4;
        }
        if (this.f2817i.size() > 0) {
            for (int i3 = 0; i3 < this.f2817i.size(); i3++) {
                if (i3 > 0) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(sb7);
                    sb10.append(str3);
                    sb7 = sb10.toString();
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append(sb7);
                sb11.append(this.f2817i.get(i3));
                sb7 = sb11.toString();
            }
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append(sb7);
        sb12.append(")");
        return sb12.toString();
    }
}
