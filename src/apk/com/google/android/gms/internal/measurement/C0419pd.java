package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.pd reason: case insensitive filesystem */
interface C0419pd {
    int a();

    @Deprecated
    void a(int i2) throws IOException;

    void a(int i2, double d2) throws IOException;

    void a(int i2, float f2) throws IOException;

    void a(int i2, int i3) throws IOException;

    void a(int i2, long j2) throws IOException;

    void a(int i2, Xa xa) throws IOException;

    void a(int i2, Object obj) throws IOException;

    void a(int i2, Object obj, Ac ac) throws IOException;

    void a(int i2, String str) throws IOException;

    void a(int i2, List<Xa> list) throws IOException;

    void a(int i2, List<?> list, Ac ac) throws IOException;

    void a(int i2, List<Boolean> list, boolean z) throws IOException;

    void a(int i2, boolean z) throws IOException;

    @Deprecated
    void b(int i2) throws IOException;

    void b(int i2, int i3) throws IOException;

    void b(int i2, long j2) throws IOException;

    @Deprecated
    void b(int i2, Object obj, Ac ac) throws IOException;

    void b(int i2, List<String> list) throws IOException;

    @Deprecated
    void b(int i2, List<?> list, Ac ac) throws IOException;

    void b(int i2, List<Integer> list, boolean z) throws IOException;

    void c(int i2, int i3) throws IOException;

    void c(int i2, long j2) throws IOException;

    void c(int i2, List<Integer> list, boolean z) throws IOException;

    void d(int i2, int i3) throws IOException;

    void d(int i2, long j2) throws IOException;

    void d(int i2, List<Long> list, boolean z) throws IOException;

    void e(int i2, int i3) throws IOException;

    void e(int i2, long j2) throws IOException;

    void e(int i2, List<Long> list, boolean z) throws IOException;

    void f(int i2, int i3) throws IOException;

    void f(int i2, List<Integer> list, boolean z) throws IOException;

    void g(int i2, List<Integer> list, boolean z) throws IOException;

    void h(int i2, List<Integer> list, boolean z) throws IOException;

    void i(int i2, List<Long> list, boolean z) throws IOException;

    void j(int i2, List<Long> list, boolean z) throws IOException;

    void k(int i2, List<Long> list, boolean z) throws IOException;

    void l(int i2, List<Integer> list, boolean z) throws IOException;

    void m(int i2, List<Double> list, boolean z) throws IOException;

    void n(int i2, List<Float> list, boolean z) throws IOException;
}
