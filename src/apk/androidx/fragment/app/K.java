package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.n;
import b.d.b;
import b.g.i.B;
import b.g.i.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition */
class K {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1473a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b reason: collision with root package name */
    private static final U f1474b = (VERSION.SDK_INT >= 21 ? new P() : null);

    /* renamed from: c reason: collision with root package name */
    private static final U f1475c = a();

    /* compiled from: FragmentTransition */
    static class a {

        /* renamed from: a reason: collision with root package name */
        public Fragment f1476a;

        /* renamed from: b reason: collision with root package name */
        public boolean f1477b;

        /* renamed from: c reason: collision with root package name */
        public C0186a f1478c;

        /* renamed from: d reason: collision with root package name */
        public Fragment f1479d;

        /* renamed from: e reason: collision with root package name */
        public boolean f1480e;

        /* renamed from: f reason: collision with root package name */
        public C0186a f1481f;

        a() {
        }
    }

    private static U a() {
        try {
            return (U) Class.forName("b.p.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void b(C0207w wVar, int i2, a aVar, View view, b<String, String> bVar) {
        Object obj;
        C0207w wVar2 = wVar;
        a aVar2 = aVar;
        View view2 = view;
        ViewGroup viewGroup = wVar2.u.a() ? (ViewGroup) wVar2.u.a(i2) : null;
        if (viewGroup != null) {
            Fragment fragment = aVar2.f1476a;
            Fragment fragment2 = aVar2.f1479d;
            U a2 = a(fragment2, fragment);
            if (a2 != null) {
                boolean z = aVar2.f1477b;
                boolean z2 = aVar2.f1480e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a3 = a(a2, fragment, z);
                Object b2 = b(a2, fragment2, z2);
                Object obj2 = a3;
                ViewGroup viewGroup2 = viewGroup;
                ArrayList arrayList3 = arrayList2;
                Object b3 = b(a2, viewGroup, view, bVar, aVar, arrayList2, arrayList, a3, b2);
                Object obj3 = obj2;
                if (obj3 == null && b3 == null) {
                    obj = b2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = b2;
                }
                ArrayList a4 = a(a2, obj, fragment2, arrayList3, view2);
                ArrayList a5 = a(a2, obj3, fragment, arrayList, view2);
                a(a5, 4);
                Fragment fragment3 = fragment;
                ArrayList arrayList4 = a4;
                Object a6 = a(a2, obj3, obj, b3, fragment3, z);
                if (a6 != null) {
                    a(a2, obj, fragment2, arrayList4);
                    ArrayList a7 = a2.a(arrayList);
                    a2.a(a6, obj3, a5, obj, arrayList4, b3, arrayList);
                    ViewGroup viewGroup3 = viewGroup2;
                    a2.a(viewGroup3, a6);
                    a2.a(viewGroup3, arrayList3, arrayList, a7, bVar);
                    a(a5, 0);
                    a2.b(b3, arrayList3, arrayList);
                }
            }
        }
    }

    static void a(C0207w wVar, ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z) {
        if (wVar.s >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i4 = i2; i4 < i3; i4++) {
                C0186a aVar = (C0186a) arrayList.get(i4);
                if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                    b(aVar, sparseArray, z);
                } else {
                    a(aVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(wVar.t.c());
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    b a2 = a(keyAt, arrayList, arrayList2, i2, i3);
                    a aVar2 = (a) sparseArray.valueAt(i5);
                    if (z) {
                        b(wVar, keyAt, aVar2, view, a2);
                    } else {
                        a(wVar, keyAt, aVar2, view, a2);
                    }
                }
            }
        }
    }

    private static b<String, String> a(int i2, ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList arrayList4;
        b<String, String> bVar = new b<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            C0186a aVar = (C0186a) arrayList.get(i5);
            if (aVar.c(i2)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i5)).booleanValue();
                ArrayList<String> arrayList5 = aVar.o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar.o;
                        arrayList4 = aVar.p;
                    } else {
                        ArrayList arrayList6 = aVar.o;
                        arrayList3 = aVar.p;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = (String) arrayList4.get(i6);
                        String str2 = (String) arrayList3.get(i6);
                        String str3 = (String) bVar.remove(str2);
                        if (str3 != null) {
                            bVar.put(str, str3);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    private static Object b(U u, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return u.b(obj);
    }

    private static Object b(U u, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        U u2 = u;
        View view3 = view;
        b<String, String> bVar2 = bVar;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = aVar2.f1476a;
        Fragment fragment2 = aVar2.f1479d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f1477b;
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = a(u, fragment, fragment2, z);
        }
        b b2 = b(u, bVar2, obj3, aVar2);
        b a2 = a(u, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) bVar.keySet());
            a(arrayList4, a2, bVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            u.b(obj4, view3, arrayList3);
            a(u, obj4, obj2, b2, aVar2.f1480e, aVar2.f1481f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar2, obj5, z);
            if (a3 != null) {
                u.a(obj5, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        I i2 = new I(fragment, fragment2, z, a2, view2, u, rect);
        s.a(viewGroup, i2);
        return obj4;
    }

    private static void a(U u, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            u.a(obj, fragment.getView(), arrayList);
            s.a(fragment.mContainer, new G(arrayList));
        }
    }

    private static void a(C0207w wVar, int i2, a aVar, View view, b<String, String> bVar) {
        Object obj;
        C0207w wVar2 = wVar;
        a aVar2 = aVar;
        View view2 = view;
        b<String, String> bVar2 = bVar;
        ViewGroup viewGroup = wVar2.u.a() ? (ViewGroup) wVar2.u.a(i2) : null;
        if (viewGroup != null) {
            Fragment fragment = aVar2.f1476a;
            Fragment fragment2 = aVar2.f1479d;
            U a2 = a(fragment2, fragment);
            if (a2 != null) {
                boolean z = aVar2.f1477b;
                boolean z2 = aVar2.f1480e;
                Object a3 = a(a2, fragment, z);
                Object b2 = b(a2, fragment2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object obj2 = b2;
                Object obj3 = a3;
                U u = a2;
                Object a4 = a(a2, viewGroup, view, bVar, aVar, arrayList, arrayList2, a3, obj2);
                Object obj4 = obj3;
                if (obj4 == null && a4 == null) {
                    obj = obj2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = obj2;
                }
                ArrayList a5 = a(u, obj, fragment2, arrayList3, view2);
                Object obj5 = (a5 == null || a5.isEmpty()) ? null : obj;
                u.a(obj4, view2);
                Object a6 = a(u, obj4, obj5, a4, fragment, aVar2.f1477b);
                if (a6 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    U u2 = u;
                    u2.a(a6, obj4, arrayList4, obj5, a5, a4, arrayList2);
                    a(u2, viewGroup, fragment, view, arrayList2, obj4, arrayList4, obj5, a5);
                    ArrayList arrayList5 = arrayList2;
                    u.a((View) viewGroup, arrayList5, (Map<String, String>) bVar2);
                    u.a(viewGroup, a6);
                    u.a(viewGroup, arrayList5, (Map<String, String>) bVar2);
                }
            }
        }
    }

    private static b<String, View> b(U u, b<String, String> bVar, Object obj, a aVar) {
        n nVar;
        ArrayList<String> arrayList;
        if (bVar.isEmpty() || obj == null) {
            bVar.clear();
            return null;
        }
        Fragment fragment = aVar.f1479d;
        b<String, View> bVar2 = new b<>();
        u.a((Map<String, View>) bVar2, fragment.requireView());
        C0186a aVar2 = aVar.f1481f;
        if (aVar.f1480e) {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar2.p;
        } else {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar2.o;
        }
        bVar2.a(arrayList);
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) bVar2.get(str);
                if (view == null) {
                    bVar.remove(str);
                } else if (!str.equals(B.r(view))) {
                    bVar.put(B.r(view), (String) bVar.remove(str));
                }
            }
        } else {
            bVar.a(bVar2.keySet());
        }
        return bVar2;
    }

    private static void a(U u, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        H h2 = new H(obj, u, view, fragment, arrayList, arrayList2, arrayList3, obj2);
        ViewGroup viewGroup2 = viewGroup;
        s.a(viewGroup, h2);
    }

    private static U a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        U u = f1474b;
        if (u != null && a(u, (List<Object>) arrayList)) {
            return f1474b;
        }
        U u2 = f1475c;
        if (u2 != null && a(u2, (List<Object>) arrayList)) {
            return f1475c;
        }
        if (f1474b == null && f1475c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(C0186a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.s.u.a()) {
            for (int size = aVar.f1411a.size() - 1; size >= 0; size--) {
                a(aVar, (a) aVar.f1411a.get(size), sparseArray, true, z);
            }
        }
    }

    private static boolean a(U u, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!u.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(U u, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return u.c(u.b(obj));
    }

    private static Object a(U u, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return u.b(obj);
    }

    private static void a(ArrayList<View> arrayList, b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View view = (View) bVar.d(size);
            if (collection.contains(B.r(view))) {
                arrayList.add(view);
            }
        }
    }

    private static Object a(U u, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        b<String, String> bVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        U u2 = u;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = aVar2.f1476a;
        Fragment fragment2 = aVar2.f1479d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f1477b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            obj3 = null;
        } else {
            obj3 = a(u2, fragment, fragment2, z);
            bVar2 = bVar;
        }
        b b2 = b(u2, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            u2.b(obj4, view, arrayList3);
            a(u, obj4, obj2, b2, aVar2.f1480e, aVar2.f1481f);
            if (obj5 != null) {
                u2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        J j2 = r0;
        J j3 = new J(u, bVar, obj4, aVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect);
        s.a(viewGroup, j2);
        return obj4;
    }

    static b<String, View> a(U u, b<String, String> bVar, Object obj, a aVar) {
        n nVar;
        ArrayList<String> arrayList;
        Fragment fragment = aVar.f1476a;
        View view = fragment.getView();
        if (bVar.isEmpty() || obj == null || view == null) {
            bVar.clear();
            return null;
        }
        b<String, View> bVar2 = new b<>();
        u.a((Map<String, View>) bVar2, view);
        C0186a aVar2 = aVar.f1478c;
        if (aVar.f1477b) {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar2.o;
        } else {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar2.p;
        }
        if (arrayList != null) {
            bVar2.a(arrayList);
            bVar2.a(bVar.values());
        }
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = (View) bVar2.get(str);
                if (view2 == null) {
                    String a2 = a(bVar, str);
                    if (a2 != null) {
                        bVar.remove(a2);
                    }
                } else if (!str.equals(B.r(view2))) {
                    String a3 = a(bVar, str);
                    if (a3 != null) {
                        bVar.put(a3, B.r(view2));
                    }
                }
            }
        } else {
            a(bVar, bVar2);
        }
        return bVar2;
    }

    private static String a(b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(bVar.d(i2))) {
                return (String) bVar.b(i2);
            }
        }
        return null;
    }

    static View a(b<String, View> bVar, a aVar, Object obj, boolean z) {
        String str;
        C0186a aVar2 = aVar.f1478c;
        if (!(obj == null || bVar == null)) {
            ArrayList<String> arrayList = aVar2.o;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (z) {
                    str = (String) aVar2.o.get(0);
                } else {
                    str = (String) aVar2.p.get(0);
                }
                return (View) bVar.get(str);
            }
        }
        return null;
    }

    private static void a(U u, Object obj, Object obj2, b<String, View> bVar, boolean z, C0186a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.o;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = (String) aVar.p.get(0);
            } else {
                str = (String) aVar.o.get(0);
            }
            View view = (View) bVar.get(str);
            u.c(obj, view);
            if (obj2 != null) {
                u.c(obj2, view);
            }
        }
    }

    private static void a(b<String, String> bVar, b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey((String) bVar.d(size))) {
                bVar.c(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, b<String, View> bVar, boolean z2) {
        n nVar;
        int i2;
        if (z) {
            nVar = fragment2.getEnterTransitionCallback();
        } else {
            nVar = fragment.getEnterTransitionCallback();
        }
        if (nVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (bVar == null) {
                i2 = 0;
            } else {
                i2 = bVar.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList2.add(bVar.b(i3));
                arrayList.add(bVar.d(i3));
            }
            if (z2) {
                nVar.b(arrayList2, arrayList, null);
            } else {
                nVar.a((List<String>) arrayList2, (List<View>) arrayList, null);
            }
        }
    }

    static ArrayList<View> a(U u, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            u.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        u.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i2);
            }
        }
    }

    private static Object a(U u, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        if (z2) {
            return u.b(obj2, obj, obj3);
        }
        return u.a(obj2, obj, obj3);
    }

    public static void a(C0186a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.f1411a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(aVar, (a) aVar.f1411a.get(i2), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.mAdded != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0074, code lost:
        if (r10.mPostponedAlpha >= 0.0f) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0080, code lost:
        if (r10.mHidden == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        if (r10.mHidden == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a2  */
    private static void a(C0186a aVar, a aVar2, SparseArray<a> sparseArray, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        a aVar3;
        C0207w wVar;
        boolean z6;
        C0186a aVar4 = aVar;
        a aVar5 = aVar2;
        SparseArray<a> sparseArray2 = sparseArray;
        boolean z7 = z;
        Fragment fragment = aVar5.f1424b;
        if (fragment != null) {
            int i2 = fragment.mContainerId;
            if (i2 != 0) {
                int i3 = z7 ? f1473a[aVar5.f1423a] : aVar5.f1423a;
                boolean z8 = false;
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    if (i3 != 7) {
                                        z5 = false;
                                        z4 = false;
                                        z3 = false;
                                        a aVar6 = (a) sparseArray2.get(i2);
                                        if (z8) {
                                            aVar6 = a(aVar6, sparseArray2, i2);
                                            aVar6.f1476a = fragment;
                                            aVar6.f1477b = z7;
                                            aVar6.f1478c = aVar4;
                                        }
                                        aVar3 = aVar6;
                                        if (!z2 && z5) {
                                            if (aVar3 != null && aVar3.f1479d == fragment) {
                                                aVar3.f1479d = null;
                                            }
                                            wVar = aVar4.s;
                                            if (fragment.mState < 1 && wVar.s >= 1 && !aVar4.q) {
                                                wVar.k(fragment);
                                                wVar.a(fragment, 1, 0, 0, false);
                                            }
                                        }
                                        if (z3 && (aVar3 == null || aVar3.f1479d == null)) {
                                            aVar3 = a(aVar3, sparseArray2, i2);
                                            aVar3.f1479d = fragment;
                                            aVar3.f1480e = z7;
                                            aVar3.f1481f = aVar4;
                                        }
                                        if (!z2 && z4 && aVar3 != null && aVar3.f1476a == fragment) {
                                            aVar3.f1476a = null;
                                        }
                                    }
                                }
                            } else if (z2) {
                                if (fragment.mHiddenChanged) {
                                    if (!fragment.mHidden) {
                                    }
                                }
                                z6 = false;
                                z8 = z6;
                                z5 = true;
                                z4 = false;
                                z3 = false;
                                a aVar62 = (a) sparseArray2.get(i2);
                                if (z8) {
                                }
                                aVar3 = aVar62;
                                aVar3.f1479d = null;
                                wVar = aVar4.s;
                                wVar.k(fragment);
                                wVar.a(fragment, 1, 0, 0, false);
                                aVar3 = a(aVar3, sparseArray2, i2);
                                aVar3.f1479d = fragment;
                                aVar3.f1480e = z7;
                                aVar3.f1481f = aVar4;
                                aVar3.f1476a = null;
                            } else {
                                z6 = fragment.mHidden;
                                z8 = z6;
                                z5 = true;
                                z4 = false;
                                z3 = false;
                                a aVar622 = (a) sparseArray2.get(i2);
                                if (z8) {
                                }
                                aVar3 = aVar622;
                                aVar3.f1479d = null;
                                wVar = aVar4.s;
                                wVar.k(fragment);
                                wVar.a(fragment, 1, 0, 0, false);
                                aVar3 = a(aVar3, sparseArray2, i2);
                                aVar3.f1479d = fragment;
                                aVar3.f1480e = z7;
                                aVar3.f1481f = aVar4;
                                aVar3.f1476a = null;
                            }
                        } else if (!z2) {
                            boolean z9 = false;
                            z3 = z9;
                            z5 = false;
                            z4 = true;
                            a aVar6222 = (a) sparseArray2.get(i2);
                            if (z8) {
                            }
                            aVar3 = aVar6222;
                            aVar3.f1479d = null;
                            wVar = aVar4.s;
                            wVar.k(fragment);
                            wVar.a(fragment, 1, 0, 0, false);
                            aVar3 = a(aVar3, sparseArray2, i2);
                            aVar3.f1479d = fragment;
                            aVar3.f1480e = z7;
                            aVar3.f1481f = aVar4;
                            aVar3.f1476a = null;
                        } else {
                            boolean z92 = false;
                            z3 = z92;
                            z5 = false;
                            z4 = true;
                            a aVar62222 = (a) sparseArray2.get(i2);
                            if (z8) {
                            }
                            aVar3 = aVar62222;
                            aVar3.f1479d = null;
                            wVar = aVar4.s;
                            wVar.k(fragment);
                            wVar.a(fragment, 1, 0, 0, false);
                            aVar3 = a(aVar3, sparseArray2, i2);
                            aVar3.f1479d = fragment;
                            aVar3.f1480e = z7;
                            aVar3.f1481f = aVar4;
                            aVar3.f1476a = null;
                        }
                    }
                    if (z2) {
                        if (!fragment.mAdded) {
                            View view = fragment.mView;
                            if (view != null) {
                                if (view.getVisibility() == 0) {
                                }
                            }
                        }
                        boolean z922 = false;
                        z3 = z922;
                        z5 = false;
                        z4 = true;
                        a aVar622222 = (a) sparseArray2.get(i2);
                        if (z8) {
                        }
                        aVar3 = aVar622222;
                        aVar3.f1479d = null;
                        wVar = aVar4.s;
                        wVar.k(fragment);
                        wVar.a(fragment, 1, 0, 0, false);
                        aVar3 = a(aVar3, sparseArray2, i2);
                        aVar3.f1479d = fragment;
                        aVar3.f1480e = z7;
                        aVar3.f1481f = aVar4;
                        aVar3.f1476a = null;
                    }
                    if (fragment.mAdded) {
                    }
                    boolean z9222 = false;
                    z3 = z9222;
                    z5 = false;
                    z4 = true;
                    a aVar6222222 = (a) sparseArray2.get(i2);
                    if (z8) {
                    }
                    aVar3 = aVar6222222;
                    aVar3.f1479d = null;
                    wVar = aVar4.s;
                    wVar.k(fragment);
                    wVar.a(fragment, 1, 0, 0, false);
                    aVar3 = a(aVar3, sparseArray2, i2);
                    aVar3.f1479d = fragment;
                    aVar3.f1480e = z7;
                    aVar3.f1481f = aVar4;
                    aVar3.f1476a = null;
                }
                if (z2) {
                    z6 = fragment.mIsNewlyAdded;
                    z8 = z6;
                    z5 = true;
                    z4 = false;
                    z3 = false;
                    a aVar62222222 = (a) sparseArray2.get(i2);
                    if (z8) {
                    }
                    aVar3 = aVar62222222;
                    aVar3.f1479d = null;
                    wVar = aVar4.s;
                    wVar.k(fragment);
                    wVar.a(fragment, 1, 0, 0, false);
                    aVar3 = a(aVar3, sparseArray2, i2);
                    aVar3.f1479d = fragment;
                    aVar3.f1480e = z7;
                    aVar3.f1481f = aVar4;
                    aVar3.f1476a = null;
                }
                if (!fragment.mAdded) {
                }
                z6 = false;
                z8 = z6;
                z5 = true;
                z4 = false;
                z3 = false;
                a aVar622222222 = (a) sparseArray2.get(i2);
                if (z8) {
                }
                aVar3 = aVar622222222;
                aVar3.f1479d = null;
                wVar = aVar4.s;
                wVar.k(fragment);
                wVar.a(fragment, 1, 0, 0, false);
                aVar3 = a(aVar3, sparseArray2, i2);
                aVar3.f1479d = fragment;
                aVar3.f1480e = z7;
                aVar3.f1481f = aVar4;
                aVar3.f1476a = null;
            }
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i2) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i2, aVar2);
        return aVar2;
    }
}
