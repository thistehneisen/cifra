package com.google.android.gms.internal.measurement;

public final class He implements Ie {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f4961a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Double> f4962b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Long> f4963c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<Long> f4964d;

    /* renamed from: e reason: collision with root package name */
    private static final C0439ta<String> f4965e;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f4961a = aa.a("measurement.test.boolean_flag", false);
        f4962b = aa.a("measurement.test.double_flag", -3.0d);
        f4963c = aa.a("measurement.test.int_flag", -2);
        f4964d = aa.a("measurement.test.long_flag", -1);
        f4965e = aa.a("measurement.test.string_flag", "---");
    }

    public final double a() {
        return ((Double) f4962b.a()).doubleValue();
    }

    public final boolean b() {
        return ((Boolean) f4961a.a()).booleanValue();
    }

    public final String c() {
        return (String) f4965e.a();
    }

    public final long d() {
        return ((Long) f4964d.a()).longValue();
    }

    public final long e() {
        return ((Long) f4963c.a()).longValue();
    }
}
