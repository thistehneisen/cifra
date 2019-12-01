package b.p;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import b.d.b;
import b.g.i.B;
import b.p.E.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
public class H {

    /* renamed from: a reason: collision with root package name */
    private static E f2828a = new C0256b();

    /* renamed from: b reason: collision with root package name */
    private static ThreadLocal<WeakReference<b<ViewGroup, ArrayList<E>>>> f2829b = new ThreadLocal<>();

    /* renamed from: c reason: collision with root package name */
    static ArrayList<ViewGroup> f2830c = new ArrayList<>();

    /* compiled from: TransitionManager */
    private static class a implements OnPreDrawListener, OnAttachStateChangeListener {

        /* renamed from: a reason: collision with root package name */
        E f2831a;

        /* renamed from: b reason: collision with root package name */
        ViewGroup f2832b;

        a(E e2, ViewGroup viewGroup) {
            this.f2831a = e2;
            this.f2832b = viewGroup;
        }

        private void a() {
            this.f2832b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2832b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!H.f2830c.remove(this.f2832b)) {
                return true;
            }
            b a2 = H.a();
            ArrayList arrayList = (ArrayList) a2.get(this.f2832b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f2832b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2831a);
            this.f2831a.a((c) new G(this, a2));
            this.f2831a.a(this.f2832b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).e(this.f2832b);
                }
            }
            this.f2831a.a(this.f2832b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            H.f2830c.remove(this.f2832b);
            ArrayList arrayList = (ArrayList) H.a().get(this.f2832b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).e(this.f2832b);
                }
            }
            this.f2831a.a(true);
        }
    }

    static b<ViewGroup, ArrayList<E>> a() {
        WeakReference weakReference = (WeakReference) f2829b.get();
        if (weakReference != null) {
            b<ViewGroup, ArrayList<E>> bVar = (b) weakReference.get();
            if (bVar != null) {
                return bVar;
            }
        }
        b<ViewGroup, ArrayList<E>> bVar2 = new b<>();
        f2829b.set(new WeakReference(bVar2));
        return bVar2;
    }

    private static void b(ViewGroup viewGroup, E e2) {
        if (e2 != null && viewGroup != null) {
            a aVar = new a(e2, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, E e2) {
        ArrayList arrayList = (ArrayList) a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((E) it.next()).c((View) viewGroup);
            }
        }
        if (e2 != null) {
            e2.a(viewGroup, true);
        }
        A a2 = A.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, E e2) {
        if (!f2830c.contains(viewGroup) && B.C(viewGroup)) {
            f2830c.add(viewGroup);
            if (e2 == null) {
                e2 = f2828a;
            }
            E clone = e2.clone();
            c(viewGroup, clone);
            A.a(viewGroup, null);
            b(viewGroup, clone);
        }
    }
}
