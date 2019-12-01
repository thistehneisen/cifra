package g.a.a.a;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView.x;
import androidx.recyclerview.widget.X;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseItemAnimator */
public abstract class g extends X {

    /* renamed from: h reason: collision with root package name */
    private ArrayList<x> f8396h = new ArrayList<>();

    /* renamed from: i reason: collision with root package name */
    private ArrayList<x> f8397i = new ArrayList<>();

    /* renamed from: j reason: collision with root package name */
    private ArrayList<d> f8398j = new ArrayList<>();

    /* renamed from: k reason: collision with root package name */
    private ArrayList<a> f8399k = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public ArrayList<ArrayList<x>> f8400l = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<d>> m = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<a>> n = new ArrayList<>();
    protected ArrayList<x> o = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<x> p = new ArrayList<>();
    protected ArrayList<x> q = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<x> r = new ArrayList<>();
    protected Interpolator s = new DecelerateInterpolator();

    /* compiled from: BaseItemAnimator */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        public x f8401a;

        /* renamed from: b reason: collision with root package name */
        public x f8402b;

        /* renamed from: c reason: collision with root package name */
        public int f8403c;

        /* renamed from: d reason: collision with root package name */
        public int f8404d;

        /* renamed from: e reason: collision with root package name */
        public int f8405e;

        /* renamed from: f reason: collision with root package name */
        public int f8406f;

        /* synthetic */ a(x xVar, x xVar2, int i2, int i3, int i4, int i5, a aVar) {
            this(xVar, xVar2, i2, i3, i4, i5);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.f8401a);
            sb.append(", newHolder=");
            sb.append(this.f8402b);
            sb.append(", fromX=");
            sb.append(this.f8403c);
            sb.append(", fromY=");
            sb.append(this.f8404d);
            sb.append(", toX=");
            sb.append(this.f8405e);
            sb.append(", toY=");
            sb.append(this.f8406f);
            sb.append('}');
            return sb.toString();
        }

        private a(x xVar, x xVar2) {
            this.f8401a = xVar;
            this.f8402b = xVar2;
        }

        private a(x xVar, x xVar2, int i2, int i3, int i4, int i5) {
            this(xVar, xVar2);
            this.f8403c = i2;
            this.f8404d = i3;
            this.f8405e = i4;
            this.f8406f = i5;
        }
    }

    /* compiled from: BaseItemAnimator */
    protected class b extends e {

        /* renamed from: a reason: collision with root package name */
        x f8407a;

        public b(x xVar) {
            super(null);
            this.f8407a = xVar;
        }

        public void a(View view) {
            g.a.a.b.a.a(view);
        }

        public void b(View view) {
            g.a.a.b.a.a(view);
            g.this.h(this.f8407a);
            g.this.o.remove(this.f8407a);
            g.this.j();
        }

        public void c(View view) {
            g.this.i(this.f8407a);
        }
    }

    /* compiled from: BaseItemAnimator */
    protected class c extends e {

        /* renamed from: a reason: collision with root package name */
        x f8409a;

        public c(x xVar) {
            super(null);
            this.f8409a = xVar;
        }

        public void a(View view) {
            g.a.a.b.a.a(view);
        }

        public void b(View view) {
            g.a.a.b.a.a(view);
            g.this.l(this.f8409a);
            g.this.q.remove(this.f8409a);
            g.this.j();
        }

        public void c(View view) {
            g.this.m(this.f8409a);
        }
    }

    /* compiled from: BaseItemAnimator */
    private static class d {

        /* renamed from: a reason: collision with root package name */
        public x f8411a;

        /* renamed from: b reason: collision with root package name */
        public int f8412b;

        /* renamed from: c reason: collision with root package name */
        public int f8413c;

        /* renamed from: d reason: collision with root package name */
        public int f8414d;

        /* renamed from: e reason: collision with root package name */
        public int f8415e;

        /* synthetic */ d(x xVar, int i2, int i3, int i4, int i5, a aVar) {
            this(xVar, i2, i3, i4, i5);
        }

        private d(x xVar, int i2, int i3, int i4, int i5) {
            this.f8411a = xVar;
            this.f8412b = i2;
            this.f8413c = i3;
            this.f8414d = i4;
            this.f8415e = i5;
        }
    }

    /* compiled from: BaseItemAnimator */
    private static class e implements L {
        private e() {
        }

        public void a(View view) {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public g() {
        a(false);
    }

    private void A(x xVar) {
        if (xVar instanceof g.a.a.a.a.a) {
            ((g.a.a.a.a.a) xVar).b(xVar, new c(xVar));
        } else {
            u(xVar);
        }
        this.q.add(xVar);
    }

    private void B(x xVar) {
        g.a.a.b.a.a(xVar.itemView);
        if (xVar instanceof g.a.a.a.a.a) {
            ((g.a.a.a.a.a) xVar).a(xVar);
        } else {
            x(xVar);
        }
    }

    private void C(x xVar) {
        g.a.a.b.a.a(xVar.itemView);
        if (xVar instanceof g.a.a.a.a.a) {
            ((g.a.a.a.a.a) xVar).b(xVar);
        } else {
            y(xVar);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!g()) {
            a();
        }
    }

    /* access modifiers changed from: private */
    public void z(x xVar) {
        if (xVar instanceof g.a.a.a.a.a) {
            ((g.a.a.a.a.a) xVar).a(xVar, new b(xVar));
        } else {
            t(xVar);
        }
        this.o.add(xVar);
    }

    public boolean g(x xVar) {
        d(xVar);
        C(xVar);
        this.f8396h.add(xVar);
        return true;
    }

    public void i() {
        boolean z = !this.f8396h.isEmpty();
        boolean z2 = !this.f8398j.isEmpty();
        boolean z3 = !this.f8399k.isEmpty();
        boolean z4 = !this.f8397i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator it = this.f8396h.iterator();
            while (it.hasNext()) {
                A((x) it.next());
            }
            this.f8396h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f8398j);
                this.m.add(arrayList);
                this.f8398j.clear();
                a aVar = new a(this, arrayList);
                if (z) {
                    B.a(((d) arrayList.get(0)).f8411a.itemView, (Runnable) aVar, f());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f8399k);
                this.n.add(arrayList2);
                this.f8399k.clear();
                b bVar = new b(this, arrayList2);
                if (z) {
                    B.a(((a) arrayList2.get(0)).f8401a.itemView, (Runnable) bVar, f());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f8397i);
                this.f8400l.add(arrayList3);
                this.f8397i.clear();
                c cVar = new c(this, arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long f2 = z ? f() : 0;
                    long e2 = z2 ? e() : 0;
                    if (z3) {
                        j2 = d();
                    }
                    B.a(((x) arrayList3.get(0)).itemView, (Runnable) cVar, f2 + Math.max(e2, j2));
                } else {
                    cVar.run();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void t(x xVar);

    /* access modifiers changed from: protected */
    public abstract void u(x xVar);

    /* access modifiers changed from: protected */
    public long v(x xVar) {
        return Math.abs((((long) xVar.getAdapterPosition()) * c()) / 4);
    }

    /* access modifiers changed from: protected */
    public long w(x xVar) {
        return Math.abs((((long) xVar.getOldPosition()) * f()) / 4);
    }

    /* access modifiers changed from: protected */
    public abstract void x(x xVar);

    /* access modifiers changed from: protected */
    public void y(x xVar) {
    }

    /* access modifiers changed from: private */
    public void b(x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            B.a(view).b(0.0f);
        }
        if (i7 != 0) {
            B.a(view).c(0.0f);
        }
        this.p.add(xVar);
        K a2 = B.a(view);
        a2.a(e());
        d dVar = new d(this, xVar, i6, i7, a2);
        a2.a((L) dVar);
        a2.c();
    }

    public void d(x xVar) {
        View view = xVar.itemView;
        B.a(view).a();
        int size = this.f8398j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((d) this.f8398j.get(size)).f8411a == xVar) {
                B.k(view, 0.0f);
                B.j(view, 0.0f);
                j(xVar);
                this.f8398j.remove(size);
            }
        }
        a((List<a>) this.f8399k, xVar);
        if (this.f8396h.remove(xVar)) {
            g.a.a.b.a.a(xVar.itemView);
            l(xVar);
        }
        if (this.f8397i.remove(xVar)) {
            g.a.a.b.a.a(xVar.itemView);
            h(xVar);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.n.get(size2);
            a((List<a>) arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((d) arrayList2.get(size4)).f8411a == xVar) {
                    B.k(view, 0.0f);
                    B.j(view, 0.0f);
                    j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f8400l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f8400l.get(size5);
            if (arrayList3.remove(xVar)) {
                g.a.a.b.a.a(xVar.itemView);
                h(xVar);
                if (arrayList3.isEmpty()) {
                    this.f8400l.remove(size5);
                }
            }
        }
        this.q.remove(xVar);
        this.o.remove(xVar);
        this.r.remove(xVar);
        this.p.remove(xVar);
        j();
    }

    public boolean f(x xVar) {
        d(xVar);
        B(xVar);
        this.f8397i.add(xVar);
        return true;
    }

    public boolean g() {
        return !this.f8397i.isEmpty() || !this.f8399k.isEmpty() || !this.f8398j.isEmpty() || !this.f8396h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.f8400l.isEmpty() || !this.n.isEmpty();
    }

    public boolean a(x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.itemView;
        int s2 = (int) (((float) i2) + B.s(view));
        int t = (int) (((float) i3) + B.t(xVar.itemView));
        d(xVar);
        int i6 = i4 - s2;
        int i7 = i5 - t;
        if (i6 == 0 && i7 == 0) {
            j(xVar);
            return false;
        }
        if (i6 != 0) {
            B.j(view, (float) (-i6));
        }
        if (i7 != 0) {
            B.k(view, (float) (-i7));
        }
        ArrayList<d> arrayList = this.f8398j;
        d dVar = new d(xVar, s2, t, i4, i5, null);
        arrayList.add(dVar);
        return true;
    }

    private void b(a aVar) {
        x xVar = aVar.f8401a;
        if (xVar != null) {
            a(aVar, xVar);
        }
        x xVar2 = aVar.f8402b;
        if (xVar2 != null) {
            a(aVar, xVar2);
        }
    }

    public boolean a(x xVar, x xVar2, int i2, int i3, int i4, int i5) {
        x xVar3 = xVar;
        x xVar4 = xVar2;
        if (xVar3 == xVar4) {
            return a(xVar, i2, i3, i4, i5);
        }
        float s2 = B.s(xVar3.itemView);
        float t = B.t(xVar3.itemView);
        float d2 = B.d(xVar3.itemView);
        d(xVar);
        int i6 = (int) (((float) (i4 - i2)) - s2);
        int i7 = (int) (((float) (i5 - i3)) - t);
        B.j(xVar3.itemView, s2);
        B.k(xVar3.itemView, t);
        B.a(xVar3.itemView, d2);
        if (!(xVar4 == null || xVar4.itemView == null)) {
            d(xVar4);
            B.j(xVar4.itemView, (float) (-i6));
            B.k(xVar4.itemView, (float) (-i7));
            B.a(xVar4.itemView, 0.0f);
        }
        ArrayList<a> arrayList = this.f8399k;
        a aVar = new a(xVar, xVar2, i2, i3, i4, i5, null);
        arrayList.add(aVar);
        return true;
    }

    public void b() {
        int size = this.f8398j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            d dVar = (d) this.f8398j.get(size);
            View view = dVar.f8411a.itemView;
            B.k(view, 0.0f);
            B.j(view, 0.0f);
            j(dVar.f8411a);
            this.f8398j.remove(size);
        }
        for (int size2 = this.f8396h.size() - 1; size2 >= 0; size2--) {
            l((x) this.f8396h.get(size2));
            this.f8396h.remove(size2);
        }
        for (int size3 = this.f8397i.size() - 1; size3 >= 0; size3--) {
            x xVar = (x) this.f8397i.get(size3);
            g.a.a.b.a.a(xVar.itemView);
            h(xVar);
            this.f8397i.remove(size3);
        }
        for (int size4 = this.f8399k.size() - 1; size4 >= 0; size4--) {
            b((a) this.f8399k.get(size4));
        }
        this.f8399k.clear();
        if (g()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    d dVar2 = (d) arrayList.get(size6);
                    View view2 = dVar2.f8411a.itemView;
                    B.k(view2, 0.0f);
                    B.j(view2, 0.0f);
                    j(dVar2.f8411a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f8400l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f8400l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    x xVar2 = (x) arrayList2.get(size8);
                    B.a(xVar2.itemView, 1.0f);
                    h(xVar2);
                    if (size8 < arrayList2.size()) {
                        arrayList2.remove(size8);
                    }
                    if (arrayList2.isEmpty()) {
                        this.f8400l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            a((List<x>) this.q);
            a((List<x>) this.p);
            a((List<x>) this.o);
            a((List<x>) this.r);
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        View view;
        x xVar = aVar.f8401a;
        View view2 = null;
        if (xVar == null) {
            view = null;
        } else {
            view = xVar.itemView;
        }
        x xVar2 = aVar.f8402b;
        if (xVar2 != null) {
            view2 = xVar2.itemView;
        }
        if (view != null) {
            this.r.add(aVar.f8401a);
            K a2 = B.a(view);
            a2.a(d());
            a2.b((float) (aVar.f8405e - aVar.f8403c));
            a2.c((float) (aVar.f8406f - aVar.f8404d));
            a2.a(0.0f);
            a2.a((L) new e(this, aVar, a2));
            a2.c();
        }
        if (view2 != null) {
            this.r.add(aVar.f8402b);
            K a3 = B.a(view2);
            a3.b(0.0f);
            a3.c(0.0f);
            a3.a(d());
            a3.a(1.0f);
            a3.a((L) new f(this, aVar, a3, view2));
            a3.c();
        }
    }

    private void a(List<a> list, x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, xVar) && aVar.f8401a == null && aVar.f8402b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, x xVar) {
        boolean z = false;
        if (aVar.f8402b == xVar) {
            aVar.f8402b = null;
        } else if (aVar.f8401a != xVar) {
            return false;
        } else {
            aVar.f8401a = null;
            z = true;
        }
        B.a(xVar.itemView, 1.0f);
        B.j(xVar.itemView, 0.0f);
        B.k(xVar.itemView, 0.0f);
        a(xVar, z);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(List<x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            B.a(((x) list.get(size)).itemView).a();
        }
    }
}
