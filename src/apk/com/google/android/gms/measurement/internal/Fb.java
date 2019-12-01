package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
import java.util.List;

final class Fb {
    private long A;
    private long B;
    private String C;
    private boolean D;
    private long E;
    private long F;

    /* renamed from: a reason: collision with root package name */
    private final Ob f5548a;

    /* renamed from: b reason: collision with root package name */
    private final String f5549b;

    /* renamed from: c reason: collision with root package name */
    private String f5550c;

    /* renamed from: d reason: collision with root package name */
    private String f5551d;

    /* renamed from: e reason: collision with root package name */
    private String f5552e;

    /* renamed from: f reason: collision with root package name */
    private String f5553f;

    /* renamed from: g reason: collision with root package name */
    private long f5554g;

    /* renamed from: h reason: collision with root package name */
    private long f5555h;

    /* renamed from: i reason: collision with root package name */
    private long f5556i;

    /* renamed from: j reason: collision with root package name */
    private String f5557j;

    /* renamed from: k reason: collision with root package name */
    private long f5558k;

    /* renamed from: l reason: collision with root package name */
    private String f5559l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private String s;
    private Boolean t;
    private long u;
    private List<String> v;
    private long w;
    private long x;
    private long y;
    private long z;

    Fb(Ob ob, String str) {
        q.a(ob);
        q.b(str);
        this.f5548a = ob;
        this.f5549b = str;
        this.f5548a.d().j();
    }

    public final String A() {
        this.f5548a.d().j();
        return this.C;
    }

    public final String B() {
        this.f5548a.d().j();
        String str = this.C;
        h((String) null);
        return str;
    }

    public final long C() {
        this.f5548a.d().j();
        return this.p;
    }

    public final boolean D() {
        this.f5548a.d().j();
        return this.q;
    }

    public final boolean E() {
        this.f5548a.d().j();
        return this.r;
    }

    public final Boolean F() {
        this.f5548a.d().j();
        return this.t;
    }

    public final List<String> G() {
        this.f5548a.d().j();
        return this.v;
    }

    public final String a() {
        this.f5548a.d().j();
        return this.f5550c;
    }

    public final void b(String str) {
        this.f5548a.d().j();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= !Wd.e(this.f5551d, str);
        this.f5551d = str;
    }

    public final String c() {
        this.f5548a.d().j();
        return this.f5551d;
    }

    public final void d(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.f5552e, str);
        this.f5552e = str;
    }

    public final void e() {
        this.f5548a.d().j();
        this.D = false;
    }

    public final String f() {
        this.f5548a.d().j();
        return this.f5549b;
    }

    public final String g() {
        this.f5548a.d().j();
        return this.s;
    }

    public final String h() {
        this.f5548a.d().j();
        return this.f5552e;
    }

    public final long i() {
        this.f5548a.d().j();
        return this.f5555h;
    }

    public final long j() {
        this.f5548a.d().j();
        return this.f5556i;
    }

    public final String k() {
        this.f5548a.d().j();
        return this.f5557j;
    }

    public final long l() {
        this.f5548a.d().j();
        return this.f5558k;
    }

    public final String m() {
        this.f5548a.d().j();
        return this.f5559l;
    }

    public final long n() {
        this.f5548a.d().j();
        return this.m;
    }

    public final long o() {
        this.f5548a.d().j();
        return this.n;
    }

    public final long p() {
        this.f5548a.d().j();
        return this.u;
    }

    public final long q() {
        this.f5548a.d().j();
        return this.f5554g;
    }

    public final long r() {
        this.f5548a.d().j();
        return this.E;
    }

    public final long s() {
        this.f5548a.d().j();
        return this.F;
    }

    public final void t() {
        this.f5548a.d().j();
        long j2 = this.f5554g + 1;
        if (j2 > 2147483647L) {
            this.f5548a.e().w().a("Bundle index overflow. appId", C0532kb.a(this.f5549b));
            j2 = 0;
        }
        this.D = true;
        this.f5554g = j2;
    }

    public final long u() {
        this.f5548a.d().j();
        return this.w;
    }

    public final long v() {
        this.f5548a.d().j();
        return this.x;
    }

    public final long w() {
        this.f5548a.d().j();
        return this.y;
    }

    public final long x() {
        this.f5548a.d().j();
        return this.z;
    }

    public final long y() {
        this.f5548a.d().j();
        return this.B;
    }

    public final long z() {
        this.f5548a.d().j();
        return this.A;
    }

    public final void a(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.f5550c, str);
        this.f5550c = str;
    }

    public final void c(String str) {
        this.f5548a.d().j();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= !Wd.e(this.s, str);
        this.s = str;
    }

    public final void e(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.f5553f, str);
        this.f5553f = str;
    }

    public final void f(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.f5557j, str);
        this.f5557j = str;
    }

    public final void g(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.f5559l, str);
        this.f5559l = str;
    }

    public final void h(long j2) {
        this.f5548a.d().j();
        this.D |= this.E != j2;
        this.E = j2;
    }

    public final void i(long j2) {
        this.f5548a.d().j();
        this.D |= this.F != j2;
        this.F = j2;
    }

    public final void j(long j2) {
        this.f5548a.d().j();
        this.D |= this.w != j2;
        this.w = j2;
    }

    public final void k(long j2) {
        this.f5548a.d().j();
        this.D |= this.x != j2;
        this.x = j2;
    }

    public final void l(long j2) {
        this.f5548a.d().j();
        this.D |= this.y != j2;
        this.y = j2;
    }

    public final void m(long j2) {
        this.f5548a.d().j();
        this.D |= this.z != j2;
        this.z = j2;
    }

    public final void n(long j2) {
        this.f5548a.d().j();
        this.D |= this.B != j2;
        this.B = j2;
    }

    public final void o(long j2) {
        this.f5548a.d().j();
        this.D |= this.A != j2;
        this.A = j2;
    }

    public final void p(long j2) {
        this.f5548a.d().j();
        this.D |= this.p != j2;
        this.p = j2;
    }

    public final void d(long j2) {
        this.f5548a.d().j();
        this.D |= this.m != j2;
        this.m = j2;
    }

    public final String b() {
        this.f5548a.d().j();
        return this.f5553f;
    }

    public final void a(long j2) {
        this.f5548a.d().j();
        this.D |= this.f5555h != j2;
        this.f5555h = j2;
    }

    public final void e(long j2) {
        this.f5548a.d().j();
        this.D |= this.n != j2;
        this.n = j2;
    }

    public final void f(long j2) {
        this.f5548a.d().j();
        this.D |= this.u != j2;
        this.u = j2;
    }

    public final void g(long j2) {
        boolean z2 = true;
        q.a(j2 >= 0);
        this.f5548a.d().j();
        boolean z3 = this.D;
        if (this.f5554g == j2) {
            z2 = false;
        }
        this.D = z2 | z3;
        this.f5554g = j2;
    }

    public final void h(String str) {
        this.f5548a.d().j();
        this.D |= !Wd.e(this.C, str);
        this.C = str;
    }

    public final void b(long j2) {
        this.f5548a.d().j();
        this.D |= this.f5556i != j2;
        this.f5556i = j2;
    }

    public final void c(long j2) {
        this.f5548a.d().j();
        this.D |= this.f5558k != j2;
        this.f5558k = j2;
    }

    public final boolean d() {
        this.f5548a.d().j();
        return this.o;
    }

    public final void a(boolean z2) {
        this.f5548a.d().j();
        this.D |= this.o != z2;
        this.o = z2;
    }

    public final void b(boolean z2) {
        this.f5548a.d().j();
        this.D = this.q != z2;
        this.q = z2;
    }

    public final void c(boolean z2) {
        this.f5548a.d().j();
        this.D = this.r != z2;
        this.r = z2;
    }

    public final void a(Boolean bool) {
        this.f5548a.d().j();
        this.D = !Wd.a(this.t, bool);
        this.t = bool;
    }

    public final void a(List<String> list) {
        this.f5548a.d().j();
        if (!Wd.a(this.v, list)) {
            this.D = true;
            this.v = list != null ? new ArrayList(list) : null;
        }
    }
}
