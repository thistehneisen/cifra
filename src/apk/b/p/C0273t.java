package b.p;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.U;
import b.p.E.b;
import b.p.E.c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.p.t reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
public class C0273t extends U {
    public boolean a(Object obj) {
        return obj instanceof E;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((E) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        K k2 = new K();
        k2.a((E) obj);
        return k2;
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        E e2 = (E) obj;
        if (e2 != null) {
            int i2 = 0;
            if (e2 instanceof K) {
                K k2 = (K) e2;
                int p = k2.p();
                while (i2 < p) {
                    a((Object) k2.a(i2), arrayList);
                    i2++;
                }
            } else if (!a(e2) && U.a(e2.l())) {
                int size = arrayList.size();
                while (i2 < size) {
                    e2.a((View) arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void b(Object obj, View view, ArrayList<View> arrayList) {
        K k2 = (K) obj;
        List l2 = k2.l();
        l2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            U.a(l2, (View) arrayList.get(i2));
        }
        l2.add(view);
        arrayList.add(view);
        a((Object) k2, arrayList);
    }

    public void c(Object obj, View view) {
        if (view != null) {
            E e2 = (E) obj;
            Rect rect = new Rect();
            a(view, rect);
            e2.a((b) new C0270p(this, rect));
        }
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        K k2 = new K();
        if (obj != null) {
            k2.a((E) obj);
        }
        if (obj2 != null) {
            k2.a((E) obj2);
        }
        if (obj3 != null) {
            k2.a((E) obj3);
        }
        return k2;
    }

    private static boolean a(E e2) {
        return !U.a(e2.i()) || !U.a(e2.j()) || !U.a(e2.k());
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        K k2 = (K) obj;
        if (k2 != null) {
            k2.l().clear();
            k2.l().addAll(arrayList2);
            a((Object) k2, arrayList, arrayList2);
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((E) obj).a((c) new C0271q(this, view, arrayList));
    }

    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Object a(Object obj, Object obj2, Object obj3) {
        E e2 = (E) obj;
        E e3 = (E) obj2;
        E e4 = (E) obj3;
        if (e2 != 0 && e3 != 0) {
            K k2 = new K();
            k2.a(e2);
            k2.a(e3);
            k2.b(1);
            e2 = k2;
        } else if (e2 == 0) {
            e2 = e3 != 0 ? e3 : 0;
        }
        if (e4 == null) {
            return e2;
        }
        K k3 = new K();
        if (e2 != 0) {
            k3.a(e2);
        }
        k3.a(e4);
        return k3;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((E) obj).d(view);
        }
    }

    public void a(ViewGroup viewGroup, Object obj) {
        H.a(viewGroup, (E) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        E e2 = (E) obj;
        r rVar = new r(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3);
        e2.a((c) rVar);
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        E e2 = (E) obj;
        int i3 = 0;
        if (e2 instanceof K) {
            K k2 = (K) e2;
            int p = k2.p();
            while (i3 < p) {
                a((Object) k2.a(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!a(e2)) {
            List l2 = e2.l();
            if (l2.size() == arrayList.size() && l2.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    e2.a((View) arrayList2.get(i3));
                    i3++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    e2.d((View) arrayList.get(size));
                }
            }
        }
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((E) obj).a(view);
        }
    }

    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((E) obj).a((b) new C0272s(this, rect));
        }
    }
}
