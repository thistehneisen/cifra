package com.google.android.gms.internal.measurement;

final class Qa {

    /* renamed from: a reason: collision with root package name */
    private static final Class<?> f5018a = a("libcore.io.Memory");

    /* renamed from: b reason: collision with root package name */
    private static final boolean f5019b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f5018a != null && !f5019b;
    }

    static Class<?> b() {
        return f5018a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
