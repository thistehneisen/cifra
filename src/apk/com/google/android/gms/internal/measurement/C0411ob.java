package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.d;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.ob reason: case insensitive filesystem */
final class C0411ob implements C0419pd {

    /* renamed from: a reason: collision with root package name */
    private final zzee f5299a;

    private C0411ob(zzee zzee) {
        Fb.a(zzee, "output");
        this.f5299a = zzee;
    }

    public static C0411ob a(zzee zzee) {
        C0411ob obVar = zzee.f5469c;
        if (obVar != null) {
            return obVar;
        }
        return new C0411ob(zzee);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f5299a.b(i2, i3);
    }

    public final void c(int i2, long j2) throws IOException {
        this.f5299a.c(i2, j2);
    }

    public final void d(int i2, long j2) throws IOException {
        this.f5299a.a(i2, j2);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f5299a.e(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f5299a.d(i2, i3);
    }

    public final void g(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.g(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.b(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.c(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.j(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.d(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.e(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.g(((Long) list.get(i5)).longValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.c(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.c(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void j(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.f(((Long) list.get(i5)).longValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.b(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.b(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void k(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.e(((Long) list.get(i5)).longValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void l(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.h(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.c(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.d(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void m(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.b(((Double) list.get(i5)).doubleValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Double) list.get(i3)).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, ((Double) list.get(i3)).doubleValue());
            i3++;
        }
    }

    public final void n(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.b(((Float) list.get(i5)).floatValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Float) list.get(i3)).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, ((Float) list.get(i3)).floatValue());
            i3++;
        }
    }

    public final void c(int i2, int i3) throws IOException {
        this.f5299a.e(i2, i3);
    }

    public final void f(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.i(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.d(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.e(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final int a() {
        return d.f4926l;
    }

    public final void b(int i2, long j2) throws IOException {
        this.f5299a.b(i2, j2);
    }

    public final void c(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.k(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.b(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void d(int i2, int i3) throws IOException {
        this.f5299a.c(i2, i3);
    }

    public final void e(int i2, long j2) throws IOException {
        this.f5299a.a(i2, j2);
    }

    public final void a(int i2, long j2) throws IOException {
        this.f5299a.c(i2, j2);
    }

    public final void b(int i2, Object obj, Ac ac) throws IOException {
        zzee zzee = this.f5299a;
        C0400mc mcVar = (C0400mc) obj;
        zzee.a(i2, 3);
        ac.a(mcVar, (C0419pd) zzee.f5469c);
        zzee.a(i2, 4);
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.d(((Long) list.get(i5)).longValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.h(((Long) list.get(i5)).longValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.c(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.c(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void a(int i2, float f2) throws IOException {
        this.f5299a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f5299a.a(i2, d2);
    }

    public final void a(int i2, int i3) throws IOException {
        this.f5299a.b(i2, i3);
    }

    public final void b(int i2) throws IOException {
        this.f5299a.a(i2, 4);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f5299a.a(i2, z);
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.f(((Integer) list.get(i5)).intValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.b(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void a(int i2, String str) throws IOException {
        this.f5299a.a(i2, str);
    }

    public final void a(int i2, Xa xa) throws IOException {
        this.f5299a.a(i2, xa);
    }

    public final void a(int i2, Object obj, Ac ac) throws IOException {
        this.f5299a.a(i2, (C0400mc) obj, ac);
    }

    public final void a(int i2) throws IOException {
        this.f5299a.a(i2, 3);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof Xa) {
            this.f5299a.b(i2, (Xa) obj);
        } else {
            this.f5299a.b(i2, (C0400mc) obj);
        }
    }

    public final void a(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f5299a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzee.b(((Boolean) list.get(i5)).booleanValue());
            }
            this.f5299a.b(i4);
            while (i3 < list.size()) {
                this.f5299a.a(((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, ((Boolean) list.get(i3)).booleanValue());
            i3++;
        }
    }

    public final void b(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof Ub) {
            Ub ub = (Ub) list;
            while (i3 < list.size()) {
                Object e2 = ub.e(i3);
                if (e2 instanceof String) {
                    this.f5299a.a(i2, (String) e2);
                } else {
                    this.f5299a.a(i2, (Xa) e2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f5299a.a(i2, (String) list.get(i3));
            i3++;
        }
    }

    public final void a(int i2, List<Xa> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f5299a.a(i2, (Xa) list.get(i3));
        }
    }

    public final void b(int i2, List<?> list, Ac ac) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, list.get(i3), ac);
        }
    }

    public final void a(int i2, List<?> list, Ac ac) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, list.get(i3), ac);
        }
    }
}
