package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

interface Bc {
    @Deprecated
    <T> T a(Ac<T> ac, C0428rb rbVar) throws IOException;

    void a(List<Long> list) throws IOException;

    <T> void a(List<T> list, Ac<T> ac, C0428rb rbVar) throws IOException;

    boolean a() throws IOException;

    int b() throws IOException;

    <T> T b(Ac<T> ac, C0428rb rbVar) throws IOException;

    void b(List<Long> list) throws IOException;

    @Deprecated
    <T> void b(List<T> list, Ac<T> ac, C0428rb rbVar) throws IOException;

    int c() throws IOException;

    void c(List<Integer> list) throws IOException;

    long d() throws IOException;

    void d(List<Integer> list) throws IOException;

    long e() throws IOException;

    void e(List<Float> list) throws IOException;

    long f() throws IOException;

    void f(List<Long> list) throws IOException;

    int g() throws IOException;

    void g(List<Long> list) throws IOException;

    int getTag();

    int h() throws IOException;

    void h(List<Integer> list) throws IOException;

    int i() throws IOException;

    void i(List<Integer> list) throws IOException;

    void j(List<Boolean> list) throws IOException;

    boolean j() throws IOException;

    long k() throws IOException;

    void k(List<Long> list) throws IOException;

    int l() throws IOException;

    void l(List<Integer> list) throws IOException;

    int m() throws IOException;

    void m(List<Integer> list) throws IOException;

    long n() throws IOException;

    void n(List<String> list) throws IOException;

    Xa o() throws IOException;

    void o(List<Xa> list) throws IOException;

    String p() throws IOException;

    void p(List<Double> list) throws IOException;

    void q(List<String> list) throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;
}
