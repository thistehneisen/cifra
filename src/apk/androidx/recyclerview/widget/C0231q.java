package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.q reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
public class C0231q extends X {

    /* renamed from: h reason: collision with root package name */
    private static TimeInterpolator f1956h;

    /* renamed from: i reason: collision with root package name */
    private ArrayList<x> f1957i = new ArrayList<>();

    /* renamed from: j reason: collision with root package name */
    private ArrayList<x> f1958j = new ArrayList<>();

    /* renamed from: k reason: collision with root package name */
    private ArrayList<b> f1959k = new ArrayList<>();

    /* renamed from: l reason: collision with root package name */
    private ArrayList<a> f1960l = new ArrayList<>();
    ArrayList<ArrayList<x>> m = new ArrayList<>();
    ArrayList<ArrayList<b>> n = new ArrayList<>();
    ArrayList<ArrayList<a>> o = new ArrayList<>();
    ArrayList<x> p = new ArrayList<>();
    ArrayList<x> q = new ArrayList<>();
    ArrayList<x> r = new ArrayList<>();
    ArrayList<x> s = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.q$a */
    /* compiled from: DefaultItemAnimator */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        public x f1961a;

        /* renamed from: b reason: collision with root package name */
        public x f1962b;

        /* renamed from: c reason: collision with root package name */
        public int f1963c;

        /* renamed from: d reason: collision with root package name */
        public int f1964d;

        /* renamed from: e reason: collision with root package name */
        public int f1965e;

        /* renamed from: f reason: collision with root package name */
        public int f1966f;

        private a(x xVar, x xVar2) {
            this.f1961a = xVar;
            this.f1962b = xVar2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.f1961a);
            sb.append(", newHolder=");
            sb.append(this.f1962b);
            sb.append(", fromX=");
            sb.append(this.f1963c);
            sb.append(", fromY=");
            sb.append(this.f1964d);
            sb.append(", toX=");
            sb.append(this.f1965e);
            sb.append(", toY=");
            sb.append(this.f1966f);
            sb.append('}');
            return sb.toString();
        }

        a(x xVar, x xVar2, int i2, int i3, int i4, int i5) {
            this(xVar, xVar2);
            this.f1963c = i2;
            this.f1964d = i3;
            this.f1965e = i4;
            this.f1966f = i5;
        }
    }

    /* renamed from: androidx.recyclerview.widget.q$b */
    /* compiled from: DefaultItemAnimator */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        public x f1967a;

        /* renamed from: b reason: collision with root package name */
        public int f1968b;

        /* renamed from: c reason: collision with root package name */
        public int f1969c;

        /* renamed from: d reason: collision with root package name */
        public int f1970d;

        /* renamed from: e reason: collision with root package name */
        public int f1971e;

        b(x xVar, int i2, int i3, int i4, int i5) {
            this.f1967a = xVar;
            this.f1968b = i2;
            this.f1969c = i3;
            this.f1970d = i4;
            this.f1971e = i5;
        }
    }

    private void u(x xVar) {
        View view = xVar.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.r.add(xVar);
        animate.setDuration(f()).alpha(0.0f).setListener(new C0226l(this, xVar, animate, view)).start();
    }

    private void v(x xVar) {
        if (f1956h == null) {
            f1956h = new ValueAnimator().getInterpolator();
        }
        xVar.itemView.animate().setInterpolator(f1956h);
        d(xVar);
    }

    public boolean a(x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) xVar.itemView.getTranslationY());
        v(xVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(xVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        ArrayList<b> arrayList = this.f1959k;
        b bVar = new b(xVar, translationX, translationY, i4, i5);
        arrayList.add(bVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void b(x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.q.add(xVar);
        ViewPropertyAnimator duration = animate.setDuration(e());
        C0228n nVar = new C0228n(this, xVar, i6, view, i7, animate);
        duration.setListener(nVar).start();
    }

    public void d(x xVar) {
        View view = xVar.itemView;
        view.animate().cancel();
        int size = this.f1959k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((b) this.f1959k.get(size)).f1967a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(xVar);
                this.f1959k.remove(size);
            }
        }
        a((List<a>) this.f1960l, xVar);
        if (this.f1957i.remove(xVar)) {
            view.setAlpha(1.0f);
            l(xVar);
        }
        if (this.f1958j.remove(xVar)) {
            view.setAlpha(1.0f);
            h(xVar);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.o.get(size2);
            a((List<a>) arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.o.remove(size2);
            }
        }
        for (int size3 = this.n.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.n.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f1967a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.n.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.m.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                h(xVar);
                if (arrayList3.isEmpty()) {
                    this.m.remove(size5);
                }
            }
        }
        this.r.remove(xVar);
        this.p.remove(xVar);
        this.s.remove(xVar);
        this.q.remove(xVar);
        j();
    }

    public boolean f(x xVar) {
        v(xVar);
        xVar.itemView.setAlpha(0.0f);
        this.f1958j.add(xVar);
        return true;
    }

    public boolean g(x xVar) {
        v(xVar);
        this.f1957i.add(xVar);
        return true;
    }

    public void i() {
        boolean z = !this.f1957i.isEmpty();
        boolean z2 = !this.f1959k.isEmpty();
        boolean z3 = !this.f1960l.isEmpty();
        boolean z4 = !this.f1958j.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator it = this.f1957i.iterator();
            while (it.hasNext()) {
                u((x) it.next());
            }
            this.f1957i.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f1959k);
                this.n.add(arrayList);
                this.f1959k.clear();
                C0223i iVar = new C0223i(this, arrayList);
                if (z) {
                    B.a(((b) arrayList.get(0)).f1967a.itemView, (Runnable) iVar, f());
                } else {
                    iVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f1960l);
                this.o.add(arrayList2);
                this.f1960l.clear();
                C0224j jVar = new C0224j(this, arrayList2);
                if (z) {
                    B.a(((a) arrayList2.get(0)).f1961a.itemView, (Runnable) jVar, f());
                } else {
                    jVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f1958j);
                this.m.add(arrayList3);
                this.f1958j.clear();
                C0225k kVar = new C0225k(this, arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long f2 = z ? f() : 0;
                    long e2 = z2 ? e() : 0;
                    if (z3) {
                        j2 = d();
                    }
                    B.a(((x) arrayList3.get(0)).itemView, (Runnable) kVar, f2 + Math.max(e2, j2));
                } else {
                    kVar.run();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        if (!g()) {
            a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void t(x xVar) {
        View view = xVar.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.p.add(xVar);
        animate.alpha(1.0f).setDuration(c()).setListener(new C0227m(this, xVar, view, animate)).start();
    }

    public boolean g() {
        return !this.f1958j.isEmpty() || !this.f1960l.isEmpty() || !this.f1959k.isEmpty() || !this.f1957i.isEmpty() || !this.q.isEmpty() || !this.r.isEmpty() || !this.p.isEmpty() || !this.s.isEmpty() || !this.n.isEmpty() || !this.m.isEmpty() || !this.o.isEmpty();
    }

    private void b(a aVar) {
        x xVar = aVar.f1961a;
        if (xVar != null) {
            a(aVar, xVar);
        }
        x xVar2 = aVar.f1962b;
        if (xVar2 != null) {
            a(aVar, xVar2);
        }
    }

    public boolean a(x xVar, x xVar2, int i2, int i3, int i4, int i5) {
        if (xVar == xVar2) {
            return a(xVar, i2, i3, i4, i5);
        }
        float translationX = xVar.itemView.getTranslationX();
        float translationY = xVar.itemView.getTranslationY();
        float alpha = xVar.itemView.getAlpha();
        v(xVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        xVar.itemView.setTranslationX(translationX);
        xVar.itemView.setTranslationY(translationY);
        xVar.itemView.setAlpha(alpha);
        if (xVar2 != null) {
            v(xVar2);
            xVar2.itemView.setTranslationX((float) (-i6));
            xVar2.itemView.setTranslationY((float) (-i7));
            xVar2.itemView.setAlpha(0.0f);
        }
        ArrayList<a> arrayList = this.f1960l;
        a aVar = new a(xVar, xVar2, i2, i3, i4, i5);
        arrayList.add(aVar);
        return true;
    }

    public void b() {
        int size = this.f1959k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = (b) this.f1959k.get(size);
            View view = bVar.f1967a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f1967a);
            this.f1959k.remove(size);
        }
        for (int size2 = this.f1957i.size() - 1; size2 >= 0; size2--) {
            l((x) this.f1957i.get(size2));
            this.f1957i.remove(size2);
        }
        int size3 = this.f1958j.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            x xVar = (x) this.f1958j.get(size3);
            xVar.itemView.setAlpha(1.0f);
            h(xVar);
            this.f1958j.remove(size3);
        }
        for (int size4 = this.f1960l.size() - 1; size4 >= 0; size4--) {
            b((a) this.f1960l.get(size4));
        }
        this.f1960l.clear();
        if (g()) {
            for (int size5 = this.n.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.n.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f1967a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f1967a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.n.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.m.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.m.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    x xVar2 = (x) arrayList2.get(size8);
                    xVar2.itemView.setAlpha(1.0f);
                    h(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.o.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.o.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.o.remove(arrayList3);
                    }
                }
            }
            a((List<x>) this.r);
            a((List<x>) this.q);
            a((List<x>) this.p);
            a((List<x>) this.s);
            a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        View view;
        x xVar = aVar.f1961a;
        View view2 = null;
        if (xVar == null) {
            view = null;
        } else {
            view = xVar.itemView;
        }
        x xVar2 = aVar.f1962b;
        if (xVar2 != null) {
            view2 = xVar2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(d());
            this.s.add(aVar.f1961a);
            duration.translationX((float) (aVar.f1965e - aVar.f1963c));
            duration.translationY((float) (aVar.f1966f - aVar.f1964d));
            duration.alpha(0.0f).setListener(new C0229o(this, aVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.s.add(aVar.f1962b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(d()).alpha(1.0f).setListener(new C0230p(this, aVar, animate, view2)).start();
        }
    }

    private void a(List<a> list, x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, xVar) && aVar.f1961a == null && aVar.f1962b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, x xVar) {
        boolean z = false;
        if (aVar.f1962b == xVar) {
            aVar.f1962b = null;
        } else if (aVar.f1961a != xVar) {
            return false;
        } else {
            aVar.f1961a = null;
            z = true;
        }
        xVar.itemView.setAlpha(1.0f);
        xVar.itemView.setTranslationX(0.0f);
        xVar.itemView.setTranslationY(0.0f);
        a(xVar, z);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(List<x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((x) list.get(size)).itemView.animate().cancel();
        }
    }

    public boolean a(x xVar, List<Object> list) {
        return !list.isEmpty() || super.a(xVar, list);
    }
}
