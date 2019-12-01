package b.p;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.p.E.b;
import b.p.E.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet */
public class K extends E {
    private ArrayList<E> K = new ArrayList<>();
    private boolean L = true;
    int M;
    boolean N = false;
    private int O = 0;

    /* compiled from: TransitionSet */
    static class a extends F {

        /* renamed from: a reason: collision with root package name */
        K f2835a;

        a(K k2) {
            this.f2835a = k2;
        }

        public void a(E e2) {
            K k2 = this.f2835a;
            if (!k2.N) {
                k2.o();
                this.f2835a.N = true;
            }
        }

        public void c(E e2) {
            K k2 = this.f2835a;
            k2.M--;
            if (k2.M == 0) {
                k2.N = false;
                k2.a();
            }
            e2.b((c) this);
        }
    }

    private void q() {
        a aVar = new a(this);
        Iterator it = this.K.iterator();
        while (it.hasNext()) {
            ((E) it.next()).a((c) aVar);
        }
        this.M = this.K.size();
    }

    public void c(M m) {
        if (b(m.f2840b)) {
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                E e2 = (E) it.next();
                if (e2.b(m.f2840b)) {
                    e2.c(m);
                    m.f2841c.add(e2);
                }
            }
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((E) this.K.get(i2)).e(view);
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        if (this.K.isEmpty()) {
            o();
            a();
            return;
        }
        q();
        if (!this.L) {
            for (int i2 = 1; i2 < this.K.size(); i2++) {
                ((E) this.K.get(i2 - 1)).a((c) new J(this, (E) this.K.get(i2)));
            }
            E e2 = (E) this.K.get(0);
            if (e2 != null) {
                e2.n();
            }
        } else {
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                ((E) it.next()).n();
            }
        }
    }

    public int p() {
        return this.K.size();
    }

    public E clone() {
        K k2 = (K) super.clone();
        k2.K = new ArrayList<>();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            k2.a(((E) this.K.get(i2)).clone());
        }
        return k2;
    }

    public K d(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            ((E) this.K.get(i2)).d(view);
        }
        super.d(view);
        return this;
    }

    public K b(int i2) {
        if (i2 == 0) {
            this.L = true;
        } else if (i2 == 1) {
            this.L = false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid parameter for TransitionSet ordering: ");
            sb.append(i2);
            throw new AndroidRuntimeException(sb.toString());
        }
        return this;
    }

    public K a(E e2) {
        this.K.add(e2);
        e2.u = this;
        long j2 = this.f2814f;
        if (j2 >= 0) {
            e2.a(j2);
        }
        if ((this.O & 1) != 0) {
            e2.a(d());
        }
        if ((this.O & 2) != 0) {
            e2.a(g());
        }
        if ((this.O & 4) != 0) {
            e2.a(f());
        }
        if ((this.O & 8) != 0) {
            e2.a(c());
        }
        return this;
    }

    public K b(long j2) {
        super.b(j2);
        return this;
    }

    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((E) this.K.get(i2)).c(view);
        }
    }

    public K b(c cVar) {
        super.b(cVar);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void b(M m) {
        super.b(m);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((E) this.K.get(i2)).b(m);
        }
    }

    public E a(int i2) {
        if (i2 < 0 || i2 >= this.K.size()) {
            return null;
        }
        return (E) this.K.get(i2);
    }

    public K a(long j2) {
        super.a(j2);
        if (this.f2814f >= 0) {
            int size = this.K.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((E) this.K.get(i2)).a(j2);
            }
        }
        return this;
    }

    public K a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<E> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((E) this.K.get(i2)).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    public K a(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            ((E) this.K.get(i2)).a(view);
        }
        super.a(view);
        return this;
    }

    public K a(c cVar) {
        super.a(cVar);
        return this;
    }

    public void a(C0275v vVar) {
        super.a(vVar);
        this.O |= 4;
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            ((E) this.K.get(i2)).a(vVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, N n, N n2, ArrayList<M> arrayList, ArrayList<M> arrayList2) {
        long h2 = h();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            E e2 = (E) this.K.get(i2);
            if (h2 > 0 && (this.L || i2 == 0)) {
                long h3 = e2.h();
                if (h3 > 0) {
                    e2.b(h3 + h2);
                } else {
                    e2.b(h2);
                }
            }
            e2.a(viewGroup, n, n2, arrayList, arrayList2);
        }
    }

    public void a(M m) {
        if (b(m.f2840b)) {
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                E e2 = (E) it.next();
                if (e2.b(m.f2840b)) {
                    e2.a(m);
                    m.f2841c.add(e2);
                }
            }
        }
    }

    public void a(I i2) {
        super.a(i2);
        this.O |= 2;
        int size = this.K.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((E) this.K.get(i3)).a(i2);
        }
    }

    public void a(b bVar) {
        super.a(bVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((E) this.K.get(i2)).a(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            E e2 = (E) this.K.get(i2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            sb.append(e2.a(sb2.toString()));
            a2 = sb.toString();
        }
        return a2;
    }
}
