package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class Cc {

    /* renamed from: a reason: collision with root package name */
    private static final Class<?> f4877a = d();

    /* renamed from: b reason: collision with root package name */
    private static final Tc<?, ?> f4878b = a(false);

    /* renamed from: c reason: collision with root package name */
    private static final Tc<?, ?> f4879c = a(true);

    /* renamed from: d reason: collision with root package name */
    private static final Tc<?, ?> f4880d = new Uc();

    public static void a(Class<?> cls) {
        if (!Eb.class.isAssignableFrom(cls)) {
            Class<?> cls2 = f4877a;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void b(int i2, List<Float> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.n(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.d(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.k(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.j(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.i(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.e(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.b(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.g(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.l(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.f(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.h(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.c(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.a(i2, list, z);
        }
    }

    public static void b(int i2, List<Xa> list, C0419pd pdVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.a(i2, list);
        }
    }

    static int c(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzee.e(i2));
    }

    static int d(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return h(list) + (size * zzee.e(i2));
    }

    static int e(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.d(acVar.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.d(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int f(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.e(acVar.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.e(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int g(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.f(acVar.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.f(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int h(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.k(hb.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.k(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int i(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.f(hb.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.f(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int j(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.g(hb.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.g(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void a(int i2, List<Double> list, C0419pd pdVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.m(i2, list, z);
        }
    }

    public static void b(int i2, List<?> list, C0419pd pdVar, Ac ac) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.b(i2, list, ac);
        }
    }

    public static void a(int i2, List<String> list, C0419pd pdVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.b(i2, list);
        }
    }

    static int c(List<?> list) {
        return list.size() << 3;
    }

    static int d(List<?> list) {
        return list.size();
    }

    static int b(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzee.e(i2));
    }

    public static Tc<?, ?> c() {
        return f4880d;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(int i2, List<?> list, C0419pd pdVar, Ac ac) throws IOException {
        if (list != null && !list.isEmpty()) {
            pdVar.a(i2, list, ac);
        }
    }

    static int e(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * zzee.e(i2));
    }

    static int f(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzee.e(i2));
    }

    static int g(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a(list) + (size * zzee.e(i2));
    }

    static int h(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.i(i2, 0);
    }

    static int i(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.g(i2, 0);
    }

    static int j(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.b(i2, true);
    }

    static int a(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzee.e(i2));
    }

    static int b(List<?> list) {
        return list.size() << 2;
    }

    static int b(int i2, List<Xa> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = size * zzee.e(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            e2 += zzee.a((Xa) list.get(i3));
        }
        return e2;
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static int a(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzee.h(hb.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzee.h(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int b(int i2, List<C0400mc> list, Ac ac) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzee.c(i2, (C0400mc) list.get(i4), ac);
        }
        return i3;
    }

    public static Tc<?, ?> b() {
        return f4879c;
    }

    static int a(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int e2 = zzee.e(i2) * size;
        if (list instanceof Ub) {
            Ub ub = (Ub) list;
            while (i5 < size) {
                Object e3 = ub.e(i5);
                if (e3 instanceof Xa) {
                    i4 = zzee.a((Xa) e3);
                } else {
                    i4 = zzee.a((String) e3);
                }
                e2 += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof Xa) {
                    i3 = zzee.a((Xa) obj);
                } else {
                    i3 = zzee.a((String) obj);
                }
                e2 += i3;
                i5++;
            }
        }
        return e2;
    }

    static int a(int i2, Object obj, Ac ac) {
        if (obj instanceof Sb) {
            return zzee.a(i2, (Sb) obj);
        }
        return zzee.b(i2, (C0400mc) obj, ac);
    }

    static int a(int i2, List<?> list, Ac ac) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = zzee.e(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof Sb) {
                i3 = zzee.a((Sb) obj);
            } else {
                i3 = zzee.a((C0400mc) obj, ac);
            }
            e2 += i3;
        }
        return e2;
    }

    public static Tc<?, ?> a() {
        return f4878b;
    }

    private static Tc<?, ?> a(boolean z) {
        try {
            Class e2 = e();
            if (e2 == null) {
                return null;
            }
            return (Tc) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void a(C0358fc fcVar, T t, T t2, long j2) {
        Yc.a((Object) t, j2, fcVar.a(Yc.f(t, j2), Yc.f(t2, j2)));
    }

    static <T, FT extends C0458wb<FT>> void a(C0440tb<FT> tbVar, T t, T t2) {
        C0446ub a2 = tbVar.a((Object) t2);
        if (!a2.f5389b.isEmpty()) {
            tbVar.b(t).a(a2);
        }
    }

    static <T, UT, UB> void a(Tc<UT, UB> tc, T t, T t2) {
        tc.a((Object) t, tc.c(tc.d(t), tc.d(t2)));
    }

    static <UT, UB> UB a(int i2, List<Integer> list, Lb lb, UB ub, Tc<UT, UB> tc) {
        UB ub2;
        if (lb == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!lb.a(intValue)) {
                        ub = a(i2, intValue, ub2, tc);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                if (lb.a(intValue2)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, tc);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, int i3, UB ub, Tc<UT, UB> tc) {
        if (ub == null) {
            ub = tc.a();
        }
        tc.a(ub, i2, (long) i3);
        return ub;
    }
}
